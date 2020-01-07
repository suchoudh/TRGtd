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

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.util.List;
import java.util.Vector;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import org.apache.commons.lang.StringEscapeUtils;
import org.openide.actions.CopyAction;
import org.openide.actions.CutAction;
import org.openide.actions.MoveDownAction;
import org.openide.actions.MoveUpAction;
import org.openide.actions.PasteAction;
import org.openide.cookies.ViewCookie;
import org.openide.explorer.ExplorerManager;
import org.openide.explorer.view.TreeView;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;
import org.openide.nodes.Index;
import org.openide.nodes.Node;
import org.openide.nodes.Node.Cookie;
import org.openide.nodes.NodeTransfer;
import org.openide.util.actions.SystemAction;
import org.openide.util.datatransfer.PasteType;
import org.openide.util.lookup.Lookups;
import org.openide.windows.WindowManager;
import tr.model.Data;
import tr.model.DataLookup;
import tr.model.action.Action;
import tr.model.action.ActionStateASAP;
import tr.model.action.ActionStateInactive;
import tr.model.action.ActionStateScheduled;
import tr.model.action.Recurrence;
import tr.model.project.Project;
import tr.model.project.Sequencing;
import tr.model.topic.Topic;
import tr.model.topic.TopicChangeCookie;
import tr.prefs.projects.ProjectsPrefs;
import tr.util.Observable;
import tr.util.Observer;
import tr.view.DeleteAction;
import tr.view.DeleteCookie;
import tr.view.topics.TopicChangeAction;

/**
 * Node for a TR project.
 *
 * @author Jeremy Moore (jimoore@netspace.net.au)
 */
public class ProjectNode extends AbstractNode implements Observer, EditCookie,
        ToggleShowDoneCookie, CollapseAllCookie, ExpandAllCookie,
        TransferNode, AddActionCookie, AddProjectCookie, ViewCookie,
        ActionFinder, ProjectFinder, PrintOutlineCookie, PrintDetailCookie,
        ExportTemplateCookie, DeleteCookie {

    private static final Logger LOG = Logger.getLogger("tr.view.projects");
    public final Project project;
    protected boolean showDone;

    /**
     * Constructs a new instance for a given project.
     * @param project The project.
     */
    public ProjectNode(Project project, boolean showDone) {
        this(new ProjectChildren(project, showDone));
    }

    /**
     * Constructs a new instance for a given project children.
     * @param projectChildren The project children.
     */
    public ProjectNode(ProjectChildren projectChildren) {
        super(projectChildren, Lookups.singleton(projectChildren.project));
        this.showDone = projectChildren.showDone;
        this.project = projectChildren.project;
        this.project.addObserver(this);
    }

//    @Override
//    public boolean isHidden() {
//        return !showDone && project.isDone();
//    }
    
    @Override
    public String toString() {
        return project.getDescription();
    }    
    
    @Override
    public String getName() {
        return project.getDescription();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    private String escapeHTML(String str) {
        str = StringEscapeUtils.escapeXml(str);
        return str.replace("&apos;", "'");
    }

    @Override
    public String getHtmlDisplayName() {
        String name = escapeHTML(getName());
        String fg = tr.util.HTML.format(project.getTopic().getForeground());
//      String bg = tr.util.HTML.format(project.getTopic().getBackground());
        if (project.isDone()) {
            return "<s><font color='" + fg + "'>" + name + "</font></s>";
        } else {
            return "<font color='" + fg + "'>" + name + "</font>";
        }
    }

    private Image getIcon(int type, boolean opened) {
        Icon icon = project.getIcon(opened);
        if (icon instanceof ImageIcon) {
            return ((ImageIcon) icon).getImage();
        }
        return super.getIcon(type);
    }

    @Override
    public Image getIcon(int type) {
        return getIcon(type, false);
    }

    @Override
    public Image getOpenedIcon(int type) {
        return getIcon(type, true);
    }
    public final static int MASK_ANY = DnDConstants.ACTION_COPY_OR_MOVE + NodeTransfer.CLIPBOARD_CUT;

    @Override
    public PasteType getDropType(Transferable t, final int type, int index) {
        final Node dropNode = NodeTransfer.node(t, MASK_ANY);
        if (dropNode != null && dropNode instanceof TransferNode) {
            final TransferNode transferNode = (TransferNode) dropNode;
            final boolean isMove = isMoveTransfer(type) || transferNode.isMoveTransfer();
            final Action dropAction = (Action) dropNode.getLookup().lookup(Action.class);
            if (dropAction != null) {
                final Action transferAction = (isMove) ? dropAction : (Action) dropAction.copy(getData());
                if (transferAction != null && project.canAdd(transferAction)) {
                    return new PasteType() {

                        public Transferable paste() throws IOException {
                            if (isMove) {
                                move(transferAction, transferNode);
                            } else {
                                transferAction.setThought(null);
                                project.add(transferAction);
                            }
                            return null;
                        }
                    };
                }
            }
            Project p = (Project) dropNode.getLookup().lookup(Project.class);
            if (p != null) {
                final Project transferProject = (isMove) ? p : (Project) p.copy(getData());
                if (transferProject != null && project.canAdd(transferProject)) {
                    return new PasteType() {

                        public Transferable paste() throws IOException {
                            if (isMove) {
                                move(transferProject, transferNode);
                            } else {
                                transferProject.setThought(null);
                                project.add(transferProject);
                            }
                            return null;
                        }
                    };
                }
            }
        }
        return null;
    }

    protected void move(final Action tAction, final TransferNode tNode) {
        EventQueue.invokeLater(new Runnable() {

            public void run() {
                // check for recurrence 
                Recurrence r = tAction.getRecurrence();
                if (r != null && !r.getProject().equals(project)) {
                    String ad = tAction.getDescription();
                    String pd = project.getDescription(); 
                    String m = org.openide.util.NbBundle.getMessage(ProjectNode.class, "warning.move.recurrent.action", ad, pd);
                    String t = org.openide.util.NbBundle.getMessage(ProjectNode.class, "confirm.move.recurrent.action");
                    Component p = WindowManager.getDefault().getMainWindow();
                    int opt = JOptionPane.showConfirmDialog(p, m, t, JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
                    if (opt == JOptionPane.CANCEL_OPTION) {
                        return;
                    }
                    // remove recurrence from transfer action
                    ((ActionStateScheduled) tAction.getState()).setRecurrence(null);
                }
                // do the move
                tAction.removeFromParent();
                project.add(tAction);
                tNode.setTransferType(DnDConstants.ACTION_COPY);
                select(tAction);
            }
        });
    }

    protected void move(final Project transferProject, final TransferNode transferNode) {
        EventQueue.invokeLater(new Runnable() {

            public void run() {
                transferProject.removeFromParent();
                project.add(transferProject);
                transferNode.setTransferType(DnDConstants.ACTION_COPY);
                select(transferProject);
            }
        });
    }

    /**
     * Select the node of the action in the tree if possible, otherwise clear
     * the node selection.
     * @param action The action of the node to select.
     */
    void select(final Action action) {
        EventQueue.invokeLater(new Runnable() {

            public void run() {
                select(find(action));
            }
        });
    }

    /**
     * Select the node of the project in the tree if possible, otherwise clear
     * the node selection.
     * @param project The project of the node to select.
     */
    void select(final Project project) {
        EventQueue.invokeLater(new Runnable() {

            public void run() {
                select(find(project));
            }
        });
    }

    private void select(Node node) {
        try {
            if (node == null) {
                getExplorerManager().setSelectedNodes(new Node[]{});
            } else {
                getExplorerManager().setSelectedNodes(new Node[]{node});
            }
        } catch (PropertyVetoException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    protected void createPasteTypes(Transferable t, List s) {
        super.createPasteTypes(t, s);
        PasteType paste = getDropType(t, DnDConstants.ACTION_COPY, -1);
        if (paste != null) {
            s.add(paste);
        }
    }

    @Override
    public Cookie getCookie(Class clazz) {
        if (clazz == Index.class) {
            return ((ProjectChildren) getChildren()).getIndex();
        }
        if (clazz == ViewCookie.class) {
            return this;
        }
        if (clazz == EditCookie.class) {
            return this;
        }
        if (clazz == DeleteCookie.class) {
            return this;
        }
        if (clazz == AddActionCookie.class) {
            return this;
        }
        if (clazz == AddProjectCookie.class) {
            return this;
        }
        if (clazz == ExpandAllCookie.class) {
            return this;
        }
        if (clazz == CollapseAllCookie.class) {
            return this;
        }
        if (clazz == ToggleShowDoneCookie.class) {
            return this;
        }
        if (clazz == TopicChangeCookie.class) {
            return project;
        }
        if (clazz == PrintOutlineCookie.class) {
            return this;
        }
        if (clazz == PrintDetailCookie.class) {
            return this;
        }
        if (clazz == ExportTemplateCookie.class) {
            return this;
        }
        Children ch = getChildren();
        if (clazz.isInstance(ch)) {
            return (Cookie) ch;
        }
        return super.getCookie(clazz);
    }

    @Override
    public javax.swing.Action[] getActions(boolean popup) {
        return new javax.swing.Action[]{
                    SystemAction.get(EditAction.class),
                    null,
                    SystemAction.get(ExpandAllAction.class),
                    SystemAction.get(CollapseAllAction.class),
                    null,
                    //            SystemAction.get(ShowDoneAction.class),
                    //            SystemAction.get(HideDoneAction.class),
                    SystemAction.get(ToggleShowDoneAction.class),
                    null,
                    SystemAction.get(AddActionAction.class),
                    SystemAction.get(AddProjectAction.class),
                    null,
                    SystemAction.get(CopyAction.class),
                    SystemAction.get(CutAction.class),
                    SystemAction.get(PasteAction.class),
                    null,
                    SystemAction.get(DeleteAction.class),
                    //          SystemAction.get(RenameAction.class),
                    null,
                    SystemAction.get(MoveUpAction.class),
                    SystemAction.get(MoveDownAction.class),
                    null,
                    SystemAction.get(TopicChangeAction.class),
                    null,
                    SystemAction.get(PrintOutlineAction.class),
                    SystemAction.get(PrintDetailAction.class),
                    null,
                    SystemAction.get(ExportTemplateAction.class),
                };
    }

    @Override
    public javax.swing.Action getPreferredAction() {
        return SystemAction.get(EditAction.class);
    }

    @Override
    public boolean canCopy() {
        return true;
    }

    @Override
    public boolean canCut() {
        return true;
    }

    @Override
    public boolean canDestroy() {
        return true;
    }

    @Override
    public void destroy() throws IOException {
        project.removeFromParent();
    }

    @Override
    public boolean canRename() {
        return false;
    }

    /** Handle change to data model project by refreshing visible attributes. */
////public synchronized void update(Observable observable, Object object) {
    public void update(Observable obs, Object arg) {
        if (project.equals(obs)) {
            // handle project update
            if (arg == null) { // project itself has changed
                // could be a description change

                setName(project.getDescription());
            }
        }
        fireIconChange();
        fireOpenedIconChange();
    }

//    /**
//     * Finds the node of the given object if possible.
//     * @param o The object
//     * @return the node of the object or null if one can not be found.
//     */
//    public Node find(Object o) {
//        if (project.equals(o)) return this;
//
//        Node result = null;
//        for (Node node : getChildren().getNodes()) {
//            if (node instanceof SearchableNode) {
//                result = ((SearchableNode)node).find(o);
//                if (result != null) break;
//            }
//        }
//        return result;
//    }
    /**
     * Finds the node of the given action if possible.
     * @param action The action
     * @return the node of the action or null if it can not be found.
     */
    public Node find(Action findAction) {
        Node result = null;
        for (Node node : getChildren().getNodes()) {
            if (node instanceof ActionFinder) {
                result = ((ActionFinder) node).find(findAction);
                if (result != null) {
                    break;
                }
            }
        }
        return result;
    }

    /**
     * Finds the node of the given project if possible.
     * @param project The project
     * @return the node of the project or null if it can not be found.
     */
    public Node find(Project findProject) {
        if (project.getID() == findProject.getID()) {
            return this;
        }
        Node result = null;
        for (Node node : getChildren().getNodes()) {
            if (node instanceof ProjectFinder) {
                result = ((ProjectFinder) node).find(findProject);
                if (result != null) {
                    break;
                }
            }
        }
        return result;
    }

    public synchronized void setShowDone(boolean showDone) {
        if (this.showDone == showDone) {
            return;
        }
        this.showDone = showDone;
        try {
            setChildren(new ProjectChildren(project, showDone));
        } catch (Exception ex) {
            LOG.warning(ex.getMessage());
        }
        fireCookieChange();
        if (!getTreeView().isExpanded(this)) {
            getTreeView().expandNode(this);
        }
    }

    public TreeView getTreeView() {
        return ProjectsTreeLookup.lookup().getTreeView();
    }

    public ExplorerManager getExplorerManager() {
        return ProjectsTreeLookup.lookup().getExplorerManager();
    }

    @Override
    public Transferable clipboardCut() throws IOException {
        setTransferType(DnDConstants.ACTION_MOVE);
        return super.clipboardCut();
    }

    @Override
    public Transferable clipboardCopy() throws IOException {
        setTransferType(DnDConstants.ACTION_COPY);
        return super.clipboardCopy();
    }
    private int transferType;

    /**
     * Sets the transfer type.
     * @param type The transfer type which should be DndConstants.ACTION_COPY or
     * DnDConstants.ACTION_MOVE.
     */
    public void setTransferType(int type) {
        transferType = type;
    }

    /**
     * Determines whether a move transfer type has been set.
     * @return true iff the action value of the latest setTransferAction() was
     * DnDConstants.ACTION_MOVE.
     */
    public boolean isMoveTransfer() {
        return (transferType & DnDConstants.ACTION_MOVE) != 0;
    }

    protected boolean isMoveTransfer(int type) {
        return (type & DnDConstants.ACTION_MOVE) != 0;
    }

    /**
     * Determines whether a copy transfer type has been set.
     * @return true iff the type value of the latest setTransferAction() was
     * DnDConstants.ACTION_COPY.
     */
    public boolean isCopyTransfer() {
        return (transferType & DnDConstants.ACTION_COPY) != 0;
    }

    protected Data getData() {
        return (Data) DataLookup.instance().lookup(Data.class);
    }

    public boolean canAddAction() {
        return true;
    }

    public boolean canAddProject() {
        return true;
    }

    public void addAction() {
        EventQueue.invokeLater(new Runnable() {

            public void run() {
                addNewAction(null);
            }
        });
    }

    public void addAction(final Action sibling) {
        EventQueue.invokeLater(new Runnable() {

            public void run() {
                addNewAction(sibling);
            }
        });
    }

    private void addNewAction(Action sibling) {
        Data data = (Data) DataLookup.instance().lookup(Data.class);
        if (data == null) {
            return;
        }
        Action newAction = new Action(data);
        newAction.setDescription(Resources.getText("NewActionDescr"));
        newAction.setTopic(project.getTopic());
        ProjectsPrefs.ActionState defState = ProjectsPrefs.getNewActionState();
        switch (defState) {
            case INACTIVE: {
                newAction.setState(new ActionStateInactive());
                break;
            }
            case DOASAP: {
                newAction.setState(new ActionStateASAP());
                break;
            }
            case SCHEDULED: {
                newAction.setState(new ActionStateScheduled());
                break;
            }
            case DELEGATED: {
                newAction.setState(new ActionStateScheduled());
                break;
            }
        }
        newAction.setPriority(project.getPriority());

        if (sibling == null) {
            if (!project.add(newAction)) {
                return;
            }
        } else {
            int index = project.indexOf(sibling);
            if (index == -1) {
                if (!project.add(newAction)) {
                    return;
                }
            } else {
                project.add(index + 1, newAction);
            }
        }

        // try to select the new action node
        try {
            Thread.sleep(500); // wait a bit for node to be created

        } catch (InterruptedException ex) {
        }

        Node node = find(newAction);
        if (node == null) {
            return;
        }
        try {
            getExplorerManager().setSelectedNodes(new Node[]{node});
        } catch (Exception ex) {
            LOG.info("Node selection failed. " + ex.getMessage());
        }

        getTreeView().requestFocus();

        EditCookie cookie = (EditCookie) node.getCookie(EditCookie.class);
        if (cookie != null) {
            cookie.edit();
        }
    }

    public void addProject() {
        EventQueue.invokeLater(new Runnable() {

            public void run() {
                addNewProject(null);
            }
        });
    }

    public void addProject(final Action sibling) {
        EventQueue.invokeLater(new Runnable() {

            public void run() {
                addNewProject(sibling);
            }
        });
    }

    private void addNewProject(Action sibling) {
        Data data = (Data) DataLookup.instance().lookup(Data.class);
        if (data == null) {
            return;
        }
        Project newProject = new Project(data);
        newProject.setDescription(Resources.getText("NewProjectDescr"));
        newProject.setTopic(project.getTopic());
        if (project.isRoot()) {
            if (ProjectsPrefs.isSequencing()) {
                newProject.setSequencing(true);
                newProject.setSequenceType(Sequencing.INTO_SUBPROJECTS);
            }
        } else {
            newProject.setSequencing(project.isSequencing());
            newProject.setSequenceType(project.getSequenceType());
        }
        newProject.setPriority(project.getPriority());

//      project.add(newProject);
        if (sibling == null) {
            if (!project.add(newProject)) {
                return;
            }
        } else {
            int index = project.indexOf(sibling);
            if (index == -1) {
                if (!project.add(newProject)) {
                    return;
                }
            } else {
                project.add(index + 1, newProject);
            }
        }

        // try to select the new action node
        try {
            Thread.sleep(500); // wait a bit for node to be created

        } catch (InterruptedException ex) {
        }

        Node node = find(newProject);
        if (node == null) {
            return;
        }
        try {
            getExplorerManager().setSelectedNodes(new Node[]{node});
        } catch (Exception ex) {
            LOG.info("Node selection failed. " + ex.getMessage());
        }

        getTreeView().requestFocus();

        EditCookie cookie = (EditCookie) node.getCookie(EditCookie.class);
        if (cookie != null) {
            cookie.edit();
        }
    }

    public void edit() {
        EditorTopComponent.findInstance().edit(this);
    }

    public void changeTopic(Topic topic) {
        project.setTopic(topic);
    }

    public void toggle() {
        setShowDone(!showDone);
    }

    public void view() {
        EditorTopComponent.findInstance().view(this);
    }

    public void printOutline() {
        try {
            au.com.trgtd.tr.report.project.outline.ReportImpl report =
                    new au.com.trgtd.tr.report.project.outline.ReportImpl();
            List<Project> projects = new Vector<Project>();
            projects.add(project);
            report.process(projects);
        } catch (Exception ex) {
            LOG.severe("Report exception: " + ex.getMessage());
        }
    }

    public void printDetail() {
        try {
            au.com.trgtd.tr.report.project.detail.ReportImpl report =
                    new au.com.trgtd.tr.report.project.detail.ReportImpl();
            report.process(project);
        } catch (Exception ex) {
            LOG.severe("Report exception: " + ex.getMessage());
        }
    }

    public void exportTemplate() {
        ExportTemplate exportTemplate = new ExportTemplate();
        exportTemplate.export(project);        
    }

    public void delete() {
        project.removeFromParent();
    }
    
}