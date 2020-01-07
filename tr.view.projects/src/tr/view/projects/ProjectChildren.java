/*
 * The contents of this file are subject to the terms of the Common Development
 * and Distribution License (the License). You may not use this file except in
 * compliance with the License.
 *
 * You can get a copy of the License at http://www.thinkingrock.com.au/cddl.html
 * or http://www.thinkingrock.com.au/cddl.txt.
 *
 * When distributing Covered Code, include this CDDL Header Notice in each file
 * and include the License file at http://www.thinkingrock.com.au/cddl.txt.
 * If applicable, add the following below the CDDL Header, with the fields
 * enclosed by brackets [] replaced by your own identifying information:
 * "Portions Copyright [year] [name of copyright owner]"
 *
 * The Original Software is ThinkingRock. The Initial Developer of the Original
 * Software is Avente Pty Ltd, Australia.
 *
 * Portions Copyright 2006-2007 Avente Pty Ltd. All Rights Reserved.
 */
package tr.view.projects;

import java.awt.EventQueue;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Vector;
import java.util.logging.Logger;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.openide.explorer.ExplorerManager;
import org.openide.nodes.Children;
import org.openide.nodes.Index;
import org.openide.nodes.Node;
import org.openide.util.WeakListeners;
import tr.model.Item.Doable;
import tr.model.Item.Item;
import tr.model.project.Project;
import tr.model.action.Action;
import tr.util.Observable;
import tr.util.Observer;

/**
 * Children of a project node.
 */
public class ProjectChildren extends Children.Keys implements Observer, ChangeListener {

    private static final Logger LOG = Logger.getLogger("tr.view.projects");
    public final Project project;
    public final boolean showDone;
    public final Comparator alphaCompatator;
    public boolean alphabetic;
    
    public ProjectChildren(Project project, boolean showDone) {
        this.project = project;
        this.showDone = showDone;
        this.alphaCompatator = new AlphabeticComparator();
    }

    private Collection<Item> getItems() {
        if (project == null) {
            return Collections.EMPTY_SET;
        }

        List<Item> items = new Vector<Item>();

        for (Item item : project.getChildren()) {
            if (showDone || !(item instanceof Doable) || !((Doable) item).isDone()) {
                items.add(item);
            }
        }
        
        if (alphabetic) {
            Collections.sort(items, alphaCompatator);
        }

        return items;
    }

    protected Node[] createNodes(Object key) {

        if (key instanceof Project) {
            return new Node[]{new ProjectNode((Project) key, showDone)};
        }
        if (key instanceof Action) {
            return new Node[]{new ActionNode((Action) key)};
        }
        return new Node[]{};
    }

    @Override
    protected void addNotify() {
        setKeys(getItems());

        if (project != null) {
            project.addObserver(this);
        }

        super.addNotify();
    }

    @Override
    protected void removeNotify() {
        setKeys(Collections.EMPTY_SET);

        if (project != null) {
            project.removeObserver(this);
        }

        super.removeNotify();
    }

    /**
     * Handles the case where a child has been added to or removed from the
     * project data model, by refreshing the child keys. Other relevant model
     * changes are handled by ProjectNode and ActionNode.
     */
    public void update(Observable observable, Object arg) {
        if (arg != null && project.equals(observable)) {
            setKeys(getItems());
        }
    }
    private Index index;

    /**
     * Getter for the index that works with this children.
     * @return the index.
     */
    public Index getIndex() {
        if (index == null) {
            index = new IndexImpl(this);
            index.addChangeListener(WeakListeners.change(this, index));
        }
        return index;
    }

    public void stateChanged(ChangeEvent changeEvent) {
        setKeys(getItems());
    }

    protected ExplorerManager getExplorerManager() {
        return ProjectsTreeLookup.lookup().getExplorerManager();
    }

    private class IndexImpl extends Index.Support {

        private final ProjectChildren children;

        public IndexImpl(ProjectChildren children) {
            super();
            this.children = children;
        }

        public Node[] getNodes() {
            return children.getNodes();
        }

        public int getNodesCount() {
            return children.getNodesCount();
        }

        @Override
        public void reorder() {
            super.reorder();
            fireChangeEvent(new ChangeEvent(IndexImpl.this));            
        }
        
        /**
         * Reorder for the given permutation. The permutation gives for every
         * node (nodes[0,1, ... (perm.length -1)]) the position to move it to.
         * e.g. for perm = {0,2,3,1}
         *      nodes[0] -> nodes[0]
         *      nodes[1] -> nodes[2]
         *      nodes[2] -> nodes[3]
         *      nodes[3] -> nodes[1]
         * Since the nodes may be either showing or hiding done items we first
         * get the items for the nodes of both the source and destination
         * positions. The items can then be reordered in the model by finding
         * the actual index (regardless of show/hide done). Thus if done items
         * are not shown and the order of nodes is changed, the done items will
         * be skipped over. This algorithm may have have efficiency problems for
         * large numbers of sub-nodes and it may be necessary to implement
         * moveDown and moveUp (see below) and if all else fails, implement a
         * faster method.
         */
        public synchronized void reorder(int[] perm) {

            final ExplorerManager explorerManager = getExplorerManager();

            final Node[] selectedNodes = explorerManager.getSelectedNodes();

            Node[] nodes = getNodes();

            if (nodes.length != perm.length) {
                LOG.info("Error number of nodes different in permutation.");
                return;
            }

            Item[] srcItems = new Item[perm.length];

            for (int i = 0; i < perm.length; i++) {
                if (nodes[i] instanceof ProjectNode) {
                    srcItems[i] = ((ProjectNode) nodes[i]).project;
                } else if (nodes[i] instanceof ActionNode) {
                    srcItems[i] = ((ActionNode) nodes[i]).action;
                }
                if (srcItems[i] == null) {
                    LOG.info("Source item is null error.");
                    return;
                }
            }

            Item[] dstItems = new Item[perm.length];

            for (int i = 0; i < perm.length; i++) {
                if (nodes[perm[i]] instanceof ProjectNode) {
                    dstItems[i] = (Item) ((ProjectNode) nodes[perm[i]]).project;
                } else if (nodes[perm[i]] instanceof ActionNode) {
                    dstItems[i] = (Item) ((ActionNode) nodes[perm[i]]).action;
                }
                if (dstItems[i] == null) {
                    LOG.info("Destination item is null error.");
                    return;
                }
            }

            project.reorder(srcItems, dstItems);

            fireChangeEvent(new ChangeEvent(IndexImpl.this));

            // reselect previously selected nodes
            EventQueue.invokeLater(new Runnable() {
                public void run() {
                    try {
                        explorerManager.setSelectedNodes(selectedNodes);
                    } catch (Exception ex) {
                        LOG.info("Node selection failed. " + ex.getMessage());
                    }
                }
            });
        }
        
        
// This could be implemented for efficiency - instead of defaulting to reorder.
//        public void moveUp(int i) {
//            System.out.println("ProjectChildren.moveUp(" + i + ")");
//            super.moveUp(i);
//        }
// This could be implemented for efficiency - instead of defaulting to reorder.
//        public void moveDown(int i) {
//            System.out.println("ProjectChildren.moveDown(" + i + ")");
//            super.moveDown(i);
//        }
//
// This does not seem to be used.
//        public void move(int i, int j) {
//            System.out.println("ProjectChildren.move(" + i + ", " + j + ")");
//            super.move(i, j);
//        }
//
//        public int indexOf(Node node) {
//            System.out.println("ProjectChildren.indexOf(...) " + node.toString());
//
//            int retValue;
//            retValue = super.indexOf(node);
//            return retValue;
//        }
//
// This seems to be called only for moveUp and moveDown.
//        public void exchange(int i, int j) {
//            System.out.println("ProjectChildren.exchange(" + i + ", " + j + ")");
//            super.exchange(i, j);
//        }
    }
    
    private class AlphabeticComparator implements Comparator<Project> {
        public int compare(Project p1, Project p2) {
            return p1.getDescription().compareToIgnoreCase(p2.getDescription());
        }
    }    
    
}