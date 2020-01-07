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

import au.com.thinkingrock.tr.resource.Icons;
import au.com.trgtd.tr.appl.Constants;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.util.logging.Logger;
import javax.swing.AbstractButton;
import javax.swing.ActionMap;
import javax.swing.JToolBar;
import javax.swing.text.DefaultEditorKit;
import org.openide.awt.Toolbar;
import org.openide.cookies.ViewCookie;
import org.openide.explorer.ExplorerManager;
import org.openide.explorer.ExplorerUtils;
import org.openide.explorer.view.BeanTreeView;
import org.openide.explorer.view.TreeView;
import org.openide.nodes.Node;
import org.openide.util.HelpCtx;
import org.openide.util.Lookup;
import org.openide.util.LookupEvent;
import org.openide.util.LookupListener;
import org.openide.util.NbBundle;
import org.openide.util.actions.SystemAction;
import org.openide.windows.TopComponent;
import tr.model.Data;
import tr.model.DataLookup;
import tr.model.Item.Item;
import tr.model.action.Action;
import tr.model.project.Project;
import tr.model.project.ProjectProjects;
import tr.prefs.gui.GUIPrefs;
import tr.util.Utils;
import tr.view.ReprocessAction;
import tr.view.Window;

/**
 * Top component for the review projects tree.
 *
 * @author Jeremy Moore
 */
public class ProjectsTreeTopComponent extends Window
        implements ExplorerManager.Provider, LookupListener {

    private static final Logger LOG = Logger.getLogger("tr.view.projects");
    private static final String PREFERRED_ID = "ProjectsTopComponent";
    private static ProjectsTreeTopComponent instance;
    private final ExplorerManager manager = new ExplorerManager();
    private boolean initialised;
    private Lookup.Result dataResult;
    private Lookup.Result itemResult;
    // Mantis:772
    private JToolBar toolbar;

    /** Constructs a new instance. */
    protected ProjectsTreeTopComponent() {
        setName(getText("CTL_ProjectsTopComponent"));
        setToolTipText(getText("TTT_ProjectsTopComponent"));
        setIcon(Icons.Projects.getImage());                    
        initComponents();
        initialise();
    }

    // Initialise components
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        projectsPane = new BeanTreeView();

        setLayout(new java.awt.BorderLayout());

        add(projectsPane, java.awt.BorderLayout.CENTER);

    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane projectsPane;
    // End of variables declaration//GEN-END:variables

    private void initialise() {
        if (initialised) {
            return;
        }

        add(getToolbar(), GUIPrefs.getBorderLayoutButtonsPosition());

        // data lookup listener to force re-initialisation if data changes
        if (dataResult == null) {
            dataResult = DataLookup.instance().lookup(new Lookup.Template(Data.class));
            dataResult.addLookupListener(new LookupListener() {
                public void resultChanged(LookupEvent lookupEvent) {
                    initialised = false;
                }
            });
        }

        Data data = (Data) DataLookup.instance().lookup(Data.class);
        if (data == null) {
            return;
        }

        manager.setRootContext(new ProjectRootNode((ProjectProjects) data.getRootProjects(), false));
        manager.getRootContext().setDisplayName(getText("CTL_ProjectsNode"));

        ActionMap map = getActionMap();
        map.put(DefaultEditorKit.copyAction, ExplorerUtils.actionCopy(manager));
        map.put(DefaultEditorKit.cutAction, ExplorerUtils.actionCut(manager));
        map.put(DefaultEditorKit.pasteAction, ExplorerUtils.actionPaste(manager));
        map.put("delete", ExplorerUtils.actionDelete(manager, true));

        try {
            associateLookup(ExplorerUtils.createLookup(manager, map));
        } catch (IllegalStateException ex) {
            // already associated - ignore
        }

        initialised = true;
    }

    // Mantis:772
    private JToolBar getToolbar() {
        SystemAction[] actions = new SystemAction[]{
            SystemAction.get(AddActionAction.class),
            SystemAction.get(AddProjectAction.class),
            SystemAction.get(ReprocessAction.class),
            SystemAction.get(ProjectiseAction.class),
            SystemAction.get(ToggleShowDoneAction.class),
        };
        toolbar = SystemAction.createToolbarPresenter(actions);
        toolbar.setUI((new Toolbar()).getUI());
        toolbar.setFloatable(false);
        toolbar.setOrientation(GUIPrefs.getToolBarOrientation());


        Dimension buttonSize = Constants.TOOLBAR_BUTTON_SIZE;
        for (Component component : toolbar.getComponents()) {
            if (component instanceof AbstractButton) {
                component.setPreferredSize(buttonSize);
                component.setMinimumSize(buttonSize);
                component.setMaximumSize(buttonSize);
                component.setSize(buttonSize);
            }
        }

        return toolbar;
    }

    @Override
    public void componentOpened() {
        super.componentOpened();

        initialise();
    }

    private void addItemListener() {
        itemResult = getLookup().lookup(new Lookup.Template(Item.class));
        itemResult.addLookupListener(this);
        itemResult.allInstances();
    }

    private void removeItemListener() {
        if (itemResult != null) {
            itemResult.removeLookupListener(this);
            itemResult = null;
        }
    }

    @Override
    public void componentActivated() {
        super.componentActivated();

        initialise();

        addItemListener();

        // If there is no selected node then select the root node, otherwise
        // make sure the selected project or action is viewed in the editor.
        Node[] selectedNodes = manager.getSelectedNodes();
        if (selectedNodes == null || selectedNodes.length == 0) {
            try {
                manager.setSelectedNodes(new Node[]{manager.getRootContext()});
                takeFocus();
            } catch (Exception ex) {
            }
        } else if (selectedNodes[0] instanceof ProjectNode) {
            final ProjectNode projectNode = (ProjectNode) selectedNodes[0];
            EventQueue.invokeLater(new Runnable() {
                public void run() {
                    EditorTopComponent.findInstance().view(projectNode);
                    takeFocus();
                }
            });
        } else if (selectedNodes[0] instanceof ActionNode) {
            final ActionNode actionNode = (ActionNode) selectedNodes[0];
            EventQueue.invokeLater(new Runnable() {
                public void run() {
                    EditorTopComponent.findInstance().view(actionNode);
                    takeFocus();
                }
            });
        }
    }

    @Override
    protected void componentDeactivated() {
        super.componentDeactivated();

        removeItemListener();
    }

    /**
     * Handle changed node selection by calling the editor to view the selected
     * project or action node.
     */
    public void resultChanged(LookupEvent lookupEvent) {
//////        if (itemResult == null) {
//////            return;
//////        }
//////        Collection instances = itemResult.allInstances();
//////        if (instances == null || instances.isEmpty()) {
//////            return;
//////        }
//////        final Object item = instances.iterator().next();
//////        if (item instanceof Action) {
//////            EventQueue.invokeLater(new Runnable() {
//////                public void run() {
//////                    EditorTopComponent.findInstance().view((Action)item);
//////                }
//////            });
//////        } else if (item instanceof Project) {
//////            EventQueue.invokeLater(new Runnable() {
//////                public void run() {
//////                    EditorTopComponent.findInstance().view((Project)item);
//////                }
//////            });
//////        }

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                Node[] nodes = manager.getSelectedNodes();
                Node node = nodes.length > 0 ? nodes[0] : null;
                EditorTopComponent.findInstance().view(node);
            }
        });
    }

    public void clearSelection() {
        try {
            manager.setSelectedNodes(new Node[0]);
        } catch (Exception ex) {
        }
    }

    private String getText(String key) {
        return NbBundle.getMessage(ProjectsTreeTopComponent.class, key);
    }

    public TreeView getTreeView() {
        return (TreeView) projectsPane;
    }

    /**
     * Gets default instance. Do not use directly: reserved for *.settings files only,
     * i.e. deserialization routines; otherwise you could get a non-deserialized instance.
     * To obtain the singleton instance, use {@link findInstance}.
     */
    public static synchronized ProjectsTreeTopComponent getDefault() {
        if (instance == null) {
            instance = new ProjectsTreeTopComponent();
        }
        return instance;
    }

    /**
     * Obtain the ProjectsTopComponent instance. Never call {@link #getDefault}
     * directly!
     */
    public static synchronized ProjectsTreeTopComponent findInstance() {
//        TopComponent tc = WindowManager.getDefault().findTopComponent(PREFERRED_ID);
//        if (tc == null) {
//            ErrorManager.getDefault().log(ErrorManager.WARNING, "Cannot find Projects component. It will not be located properly in the window system.");
//            return getDefault();
//        }
//        if (tc instanceof ProjectsTreeTopComponent) {
//            return (ProjectsTreeTopComponent)tc;
//        }
//        ErrorManager.getDefault().log(ErrorManager.WARNING, "There seem to be multiple components with the '" + PREFERRED_ID + "' ID. That is a potential source of errors and unexpected behavior.");
        return getDefault();
    }

    @Override
    public int getPersistenceType() {
        return TopComponent.PERSISTENCE_NEVER;
    }

    @Override
    protected String preferredID() {
        return PREFERRED_ID;
    }

    public ExplorerManager getExplorerManager() {
        return manager;
    }

    @Override
    public HelpCtx getHelpCtx() {
        return new HelpCtx("tr.view.projects");
    }

//    /** replaces this in object stream */
//    public Object writeReplace() {
//        return new ResolvableHelper();
//    }
//    final static class ResolvableHelper implements Serializable {
//        private static final long serialVersionUID = 1L;
//        public Object readResolve() {
//            return ProjectsTreeTopComponent.getDefault();
//        }
//    }
    
    /**
     * Sets the show done option.
     * @param b The option.
     */
    public void setShowDone(boolean b) {
        ProjectRootNode rootNode = (ProjectRootNode) manager.getRootContext();
        rootNode.setShowDone(b);
    }
    
    public boolean isSelected(Action action) {
        Node[] nodes = manager.getSelectedNodes();
        if (nodes != null && nodes.length > 0) {
            if (nodes[0] instanceof ActionNode) {
                return Utils.equal(((ActionNode)nodes[0]).action, action);            
            }
        }
        return false;        
    }                
    
    /**
     * Selects the node for the given action if possible.
     * @param action The action.
     */
    public synchronized void select(Action action) {
        if (!isOpened()) {
            return;
        }
        if (action.isSingleAction()) {
            return;
        }        
//        if (isSelected(action)) {
//            return;
//        }

        ProjectNode rootNode = (ProjectNode) manager.getRootContext();

        Node node = rootNode.find(action);
        if (node == null) {
            return;
        }

        requestVisible();

        try {
            manager.setSelectedNodes(new Node[]{node});

            ViewCookie cookie = (ViewCookie) node.getCookie(ViewCookie.class);
            if (cookie != null) {
                cookie.view();
            }
        } catch (Exception ex) {
            LOG.severe("Action node could not be selected in the tree.");
        }
    }

    /**
     * Selects the node for the given project if possible.
     * @param project The project.
     */
    public synchronized void select(Project project) {

        if (!isOpened()) {
            return;
        }

        ProjectNode rootNode = (ProjectNode) manager.getRootContext();

        Node node = rootNode.find(project);
        if (node == null) {
            return;
        }

        requestVisible();

        try {
            manager.setSelectedNodes(new Node[]{node});

            ViewCookie cookie = (ViewCookie) node.getCookie(ViewCookie.class);
            if (cookie != null) {
                cookie.view();
            }
        } catch (Exception ex) {
            LOG.severe("Project node could not be selected in the tree.");
        }
    }

    public void edit(Project project) {
        if (!isOpened()) {
            return;
        }
        ProjectNode rootNode = (ProjectNode) manager.getRootContext();
        Node node = rootNode.find(project);
        if (node == null) {
            return;
        }

        requestVisible();

        try {
            manager.setSelectedNodes(new Node[]{node});
            EditCookie cookie = (EditCookie) node.getCookie(EditCookie.class);
            if (cookie != null) {
                cookie.edit();
            }
        } catch (Exception ex) {
            LOG.severe("Project node could not be selected in the tree.");
        }
    }

    public void edit(Action action) {
        if (!isOpened()) {
            return;
        }
        ProjectNode rootNode = (ProjectNode) manager.getRootContext();
        Node node = rootNode.find(action);
        if (node == null) {
            return;
        }

        requestVisible();

        try {
            manager.setSelectedNodes(new Node[]{node});
            EditCookie cookie = (EditCookie) node.getCookie(EditCookie.class);
            if (cookie != null) {
                cookie.edit();
            }
        } catch (Exception ex) {
            LOG.severe("Action node could not be selected in the tree.");
        }
    }

    @Override
    public void takeFocus() {
        getTreeView().requestFocusInWindow();
    }
}
