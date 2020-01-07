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
package tr.view.projects.actions;

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
import tr.prefs.gui.GUIPrefs;
import tr.util.Utils;
import tr.view.ReprocessAction;
import tr.view.Window;
import tr.view.projects.ActionNode;
import tr.view.projects.AddActionAction;
import tr.view.projects.EditCookie;
import tr.view.projects.EditorTopComponent;
import tr.view.projects.ProjectNode;
import tr.view.projects.ProjectiseAction;
import tr.view.projects.ToggleShowDoneAction;

/**
 * Top component for the review projects, single actions tree.
 */
public class SingleActionsTopComponent extends Window
        implements ExplorerManager.Provider, LookupListener {

    private static final Logger LOG = Logger.getLogger("tr.view.projects");
    private static final String PREFERRED_ID = "SingleActionsTopComponent";
    private static SingleActionsTopComponent instance;
    private transient final ExplorerManager manager = new ExplorerManager();
    private transient boolean initialised;
    private transient Lookup.Result dataResult;
    private transient Lookup.Result itemResult;
    // Mantis:772
    private transient JToolBar toolbar;

    /** Constructs a new instance. */
    protected SingleActionsTopComponent() {
        setName(getText("CTL_SingleActionsTopComponent"));
        setToolTipText(getText("HINT_SingleActionsTopComponent"));
        setIcon(Icons.SingleActions.getImage());                            
        initComponents();
        initialise();
    }

    private void initialise() {
        if (initialised) {
            return;
        // Mantis:772
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
        manager.setRootContext(new SingleActionsRootNode(data.getRootActions(), false));
        manager.getRootContext().setDisplayName(getText("CTL_SingleActionsNode"));

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
            null,
            SystemAction.get(ReprocessAction.class),
            null,
            SystemAction.get(ProjectiseAction.class),
            null,
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

    @Override
    public void componentActivated() {
        super.componentActivated();

        initialise();

        EventQueue.invokeLater(new Runnable() {

            public void run() {
                activate();
            }
        });
    }

    private void activate() {
//      ExplorerUtils.activateActions(manager, true);

        // listen for item selection in the tree
        itemResult = getLookup().lookup(new Lookup.Template(Item.class));
        itemResult.addLookupListener(this);
        itemResult.allInstances();

        Node[] selectedNodes = manager.getSelectedNodes();
        if (selectedNodes == null || selectedNodes.length == 0) {
            try {
                manager.setSelectedNodes(new Node[]{manager.getRootContext()});
            } catch (Exception ex) {
            }
        } else if (selectedNodes[0] instanceof ProjectNode) {
//////            Project project = ((ProjectNode)selectedNodes[0]).project;
//////            EditorTopComponent.findInstance().view(project);
            ProjectNode projectNode = (ProjectNode) selectedNodes[0];
            EditorTopComponent.findInstance().view(projectNode);
        } else if (selectedNodes[0] instanceof ActionNode) {
//////            Action action = ((ActionNode)selectedNodes[0]).action;
//////            EditorTopComponent.findInstance().view(action);
            ActionNode actionNode = (ActionNode) selectedNodes[0];
            EditorTopComponent.findInstance().view(actionNode);
        }
    }

    @Override
    protected void componentDeactivated() {
        super.componentDeactivated();

//      ExplorerUtils.activateActions(manager, false);

        if (itemResult != null) {
            itemResult.removeLookupListener(this);
            itemResult = null;
        }
    }

    public void resultChanged(LookupEvent lookupEvent) {
//////        if (itemResult == null) {
//////            return;
//////        }
//////        Collection instances = itemResult.allInstances();
//////        if (instances == null || instances.isEmpty()) {
//////            return;
//////        }
//////        Object item = instances.iterator().next();
//////        if (item instanceof Action) {
//////            EditorTopComponent.findInstance().view((Action)item);
//////        } else if (item instanceof Project) {
//////            EditorTopComponent.findInstance().view((Project)item);
//////        }
        EventQueue.invokeLater(new Runnable() {

            public void run() {
                Node[] nodes = manager.getSelectedNodes();
                Node node = nodes.length > 0 ? nodes[0] : null;
                EditorTopComponent.findInstance().view(node);
            }
        });
    }

    private String getText(String key) {
        return NbBundle.getMessage(SingleActionsTopComponent.class, key);
    }

    public TreeView getTreeView() {
        return (TreeView) scrollPane;
    }

    /** Generated by the Form Editor. */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        scrollPane = new BeanTreeView();

        setLayout(new java.awt.BorderLayout());

        add(scrollPane, java.awt.BorderLayout.CENTER);

    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane scrollPane;
    // End of variables declaration//GEN-END:variables

    /**
     * Gets default instance. Do not use directly: reserved for *.settings files only,
     * i.e. deserialization routines; otherwise you could get a non-deserialized instance.
     * To obtain the singleton instance, use {@link findInstance}.
     */
    public static synchronized SingleActionsTopComponent getDefault() {
        if (instance == null) {
            instance = new SingleActionsTopComponent();
        }
        return instance;
    }

    /**
     * Obtain the SingleActionsTopComponent instance. Never call {@link #getDefault} directly!
     */
    public static synchronized SingleActionsTopComponent findInstance() {
//        TopComponent tc = WindowManager.getDefault().findTopComponent(PREFERRED_ID);
//        if (tc == null) {
//            ErrorManager.getDefault().log(ErrorManager.WARNING, "Cannot find SingleActions component. It will not be located properly in the window system.");
//            return getDefault();
//        }
//        if (tc instanceof SingleActionsTopComponent) {
//            return (SingleActionsTopComponent)tc;
//        }
//        ErrorManager.getDefault().log(ErrorManager.WARNING, "There seem to be multiple components with the '" + PREFERRED_ID + "' ID. That is a potential source of errors and unexpected behavior.");
        return getDefault();
    }

    @Override
    public int getPersistenceType() {
////////return TopComponent.PERSISTENCE_ALWAYS;
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
        return new HelpCtx("tr.view.projects.actions");
    }

//    /** replaces this in object stream */
//    public Object writeReplace() {
//        return new ResolvableHelper();
//    }
//
//    final static class ResolvableHelper implements Serializable {
//        private static final long serialVersionUID = 1L;
//        public Object readResolve() {
//            return SingleActionsTopComponent.getDefault();
//        }
//    }
    /**
     * Sets the show done option.
     * @param b The option.
     */
    public void setShowDone(boolean b) {
        SingleActionsRootNode rootNode = (SingleActionsRootNode) manager.getRootContext();
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
        if (!action.isSingleAction()) {
            return;
        }
        SingleActionsRootNode rootNode = (SingleActionsRootNode) manager.getRootContext();

        // find the node for the action
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

    public void clearSelection() {
        try {
            manager.setSelectedNodes(new Node[]{});
        } catch (Exception ex) {
            LOG.warning(ex.getMessage());
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
