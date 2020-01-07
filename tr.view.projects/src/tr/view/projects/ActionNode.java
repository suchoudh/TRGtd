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

import java.awt.Color;
import java.awt.Image;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import org.apache.commons.lang.StringEscapeUtils;
import org.openide.actions.CopyAction;
import org.openide.actions.CutAction;
import org.openide.actions.MoveDownAction;
import org.openide.actions.MoveUpAction;
import org.openide.cookies.ViewCookie;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;
import org.openide.nodes.Node;
import org.openide.util.actions.SystemAction;
import org.openide.util.lookup.Lookups;
import org.openide.windows.WindowManager;
import tr.model.Data;
import tr.model.DataLookup;
import tr.model.action.Action;
import tr.model.action.ActionStateDelegated;
import tr.model.action.ActionStateScheduled;
import tr.model.context.Context;
import tr.model.context.ContextChangeCookie;
import tr.model.project.Project;
import tr.model.project.ProjectSingleActions;
import tr.model.project.Sequencing;
import tr.model.thought.Thought;
import tr.model.topic.Topic;
import tr.model.topic.TopicChangeCookie;
import tr.prefs.projects.ProjectsPrefs;
import tr.view.DeleteAction;
import tr.view.DeleteCookie;
import tr.view.ReprocessAction;
import tr.view.ReprocessCookie;
import tr.view.WindowUtils;
import tr.view.contexts.ContextChangeAction;
import tr.view.process.ProcessThoughtsAction;
import tr.view.projects.PostponeActionAction.Periods;
import tr.view.topics.TopicChangeAction;

/**
 * Node for a TR action.
 *
 * @author Jeremy Moore (jimoore@netspace.net.au)
 */
public class ActionNode extends AbstractNode implements EditCookie,
        ProjectiseCookie, ReprocessCookie, ActionFinder, TransferNode,
        AddActionCookie, AddProjectCookie, ViewCookie, PrintCookie, 
        SetDoneCookie, PostponeActionCookie, DeleteCookie {

    private static final Logger LOG = Logger.getLogger("tr.view.projects");
    public final Action action;
    private IconChangeListener icl;
    private NameChangeListener ncl;
    private boolean showDone;

    /** Constructs a new instance. */
    public ActionNode(Action action) {
        super(Children.LEAF, Lookups.singleton(action));
        this.action = action;
        addListeners();
    }

    private void addListeners() {
        icl = new IconChangeListener();
        action.addPropertyChangeListenter(Action.PROP_STATE, icl);
        ncl = new NameChangeListener();
        action.addPropertyChangeListenter(Action.PROP_DONE, ncl);
        action.addPropertyChangeListenter(Action.PROP_DESCR, ncl);
        action.addPropertyChangeListenter(Action.PROP_TOPIC, ncl);
    }

    private void removeListeners() {
        action.removePropertyChangeListenter(Action.PROP_STATE, icl);
        icl = null;
        action.removePropertyChangeListenter(Action.PROP_DONE, ncl);
        action.removePropertyChangeListenter(Action.PROP_DESCR, ncl);
        action.removePropertyChangeListenter(Action.PROP_TOPIC, ncl);
        ncl = null;
    }

    @Override
    public boolean isHidden() {
        return !showDone && action.isDone();
    }

    public void setShowDone(boolean showDone) {
        this.showDone = showDone;
        this.fireCookieChange();
    }

    @Override
    public String getName() {
        return action.getDescription();
    }

    @Override
    public String toString() {
        return action.getDescription();
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
        String color = action.isStateInactive()
                ? tr.util.HTML.format(Color.GRAY)
                : tr.util.HTML.format(action.getTopic().getForeground());
        if (action.isDone()) {
            return "<s><font color='" + color + "'>" + name + "</font></s>";
        } else {
            return "<font color='" + color + "'>" + name + "</font>";
        }
    }

    @Override
    public boolean canCut() {
        return true;
    }

    @Override
    public boolean canCopy() {
        return true;
    }

    @Override
    public boolean canDestroy() {
        return true;
    }

    @Override
    public void destroy() throws IOException {
        action.removeFromParent();
    }

    @Override
    public boolean canRename() {
        return false;
    }

    @Override
    public javax.swing.Action[] getActions(boolean popup) {
        if (action.isSingleAction()) {
            return new javax.swing.Action[]{
                        SystemAction.get(EditAction.class),
                        null,
                        SystemAction.get(CopyAction.class),
                        SystemAction.get(CutAction.class),
                        null,
                        SystemAction.get(DeleteAction.class),
                        null,
                        SystemAction.get(MoveUpAction.class),
                        SystemAction.get(MoveDownAction.class),
                        null,
                        SystemAction.get(ReprocessAction.class),
                        SystemAction.get(ProjectiseAction.class),
                        null,
                        SystemAction.get(ContextChangeAction.class),
                        SystemAction.get(TopicChangeAction.class),
                        null,
                        SystemAction.get(AddActionAction.class),
                        null,
                        SystemAction.get(PostponeActionAction.class),                        
                        SystemAction.get(SetDoneAction.class),                        
                        null,
                        SystemAction.get(PrintAction.class),
                    };
        } else {
            return new javax.swing.Action[]{
                        SystemAction.get(EditAction.class),
                        null,
                        SystemAction.get(CopyAction.class),
                        SystemAction.get(CutAction.class),
                        null,
                        SystemAction.get(DeleteAction.class),
                        null,
                        SystemAction.get(MoveUpAction.class),
                        SystemAction.get(MoveDownAction.class),
                        null,
                        SystemAction.get(ReprocessAction.class),
                        SystemAction.get(ProjectiseAction.class),
                        null,
                        SystemAction.get(ContextChangeAction.class),
                        SystemAction.get(TopicChangeAction.class),
                        null,
                        SystemAction.get(AddActionAction.class),
                        SystemAction.get(AddProjectAction.class),
                        null,
                        SystemAction.get(PostponeActionAction.class),                        
                        SystemAction.get(SetDoneAction.class),                        
                        null,
                        SystemAction.get(PrintAction.class),
                    };
        }
    }

    @Override
    public javax.swing.Action getPreferredAction() {
        return SystemAction.get(EditAction.class);
    }

    @Override
    public Cookie getCookie(Class clazz) {
        if (clazz == ViewCookie.class) {
            return this;
        }
        if (clazz == DeleteCookie.class) {
            return this;
        }
        if (clazz == EditCookie.class) {
            return this;
        }
        if (clazz == AddActionCookie.class) {
            return this;
        }
        if (clazz == AddProjectCookie.class) {
            return this;
        }
        if (clazz == ReprocessCookie.class) {
            return this;
        }
        if (clazz == ProjectiseCookie.class) {
            return this;
        }
        if (clazz == PrintCookie.class) {
            return this;
        }
        if (clazz == TopicChangeCookie.class) {
            return action;
        }
        if (clazz == ContextChangeCookie.class) {
            return action;
        }
        if (clazz == SetDoneCookie.class) {
            return this;
        }
        if (clazz == PostponeActionCookie.class) {
            return this;
        }
        return super.getCookie(clazz);
    }

    @Override
    public Image getIcon(int type) {
        Icon icon = action.getIcon(false);
        if (icon instanceof ImageIcon) {
            return ((ImageIcon) icon).getImage();
        }
        return super.getIcon(type);
    }

    /**
     * Reprocess the action as a thought.
     * @param action The action to reprocess.
     */
    public void reprocess(boolean now) {
        if (action == null) {
            return;
        }
        Data data = (Data) DataLookup.instance().lookup(Data.class);
        if (data == null) {
            return;
        }

        ProcessThoughtsAction processThoughtsAction = null;
        if (now) {
            processThoughtsAction = (ProcessThoughtsAction) SystemAction.get(ProcessThoughtsAction.class);
            if (processThoughtsAction != null) {
                WindowUtils.closeWindows();
            }            
        }

        // delete the action
        removeListeners();

        action.removeFromParent();

        fireNodeDestroyed(); // added 08/04/08

        // add the new thought to the front of the thoughts
        Thought thought = new Thought(data.getNextID());
        thought.setDescription(action.getDescription());
        thought.setTopic(action.getTopic());
        thought.setAction(action);
        data.getThoughtManager().insert(thought, 0);

        try {
            // hack to fix hanging - probably due to a windowing issue.
            Thread.sleep(400);
        } catch (InterruptedException ex) {
        }

        // got to process thoughts screen
        if (now && processThoughtsAction != null) {
            processThoughtsAction.performAction();
        }
    }

    /**
     * Converts an action to be the first action of a new project.
     * @param action The action to convert.
     */
    public void projectise() {
        if (action == null) {
            return;
        }
        Data data = (Data) DataLookup.instance().lookup(Data.class);
        if (data == null) {
            return;
        }
        Node parentNode = getParentNode();

        // get parent of action
        Project parent = (Project) action.getParent();
        int index = parent.indexOf(action);

        // delete the action
        removeListeners();

        action.removeFromParent();

        fireNodeDestroyed();

        // create a new project
        Project project = new Project(data);
        project.setThought(action.getThought());
        project.setDescription(action.getDescription());
        project.setTopic(action.getTopic());
        project.setPriority(action.getPriority());
        project.setDueDate(action.getDueDate());
        project.setNotes(action.getNotes());
        if (parent.isRoot()) {
            if (ProjectsPrefs.isSequencing()) {
                project.setSequencing(true);
                project.setSequenceType(Sequencing.INTO_SUBPROJECTS);
            }
        } else {
            project.setSequencing(parent.isSequencing());
            project.setSequenceType(parent.getSequenceType());
        }
        project.add(action);

        if (parent instanceof ProjectSingleActions) {
            // add to root projects
            data.getRootProjects().add(project);

            // activate projects tree top component and select new project
            ProjectsTreeTopComponent pt = ProjectsTreeTopComponent.getDefault();
            if (!pt.isOpened()) {
                WindowManager wm = WindowManager.getDefault();
                pt = (ProjectsTreeTopComponent) wm.findTopComponent("RAProjectsTopComponent");
            }
            if (pt != null && pt.isOpened()) {
                pt.requestActive();
                Node rootNode = pt.getExplorerManager().getRootContext();
                if (rootNode instanceof ProjectNode) {
                    ((ProjectNode) rootNode).select(project);
                }
            }
        } else {
            // insert new project into the tree at the same index as action was
            parent.add(index, project);

            // try to select new project
            if (parentNode instanceof ProjectNode) {
                ((ProjectNode) parentNode).select(project);
            }
        }
    }
//////    /** Handles change to data model action by refreshing visible attributes. */
//////    public void update(Observable obs, Object arg) {
//////        if (arg instanceof Action.ChangeEventDescription) {
////////            Action.ChangeEventDescription e = (Action.ChangeEventDescription)arg;
//////            setName(action.getDescription());
////////            setName(e.newValue);
////////            fireDisplayNameChange(e.oldValue, e.newValue);
//////        } else if (arg instanceof Action.ChangeEventDone) {
//////            // done changed so need strike/unstrike
////////            setName(e.newValue);
//////            setName(action.getDescription());
//////
////////            fireDisplayNameChange(action.getDescription(), action.getDescription());
//////        } else {
//////            fireIconChange();
////////          fireOpenedIconChange();
//////        }
//////    }
//    /**
//     * Finds the node of the given object if possible.
//     * @param o The object
//     * @return the node of the object or null if one can not be found.
//     */
//    public Node find(Object o) {
//        return (action.equals(o)) ? this : null;
//    }
    /**
     * Finds the node of the given action if possible.
     * @param action The action
     * @return the node of the action or null if one can not be found.
     */
    public Node find(Action findAction) {
        return action.getID() == findAction.getID() ? this : null;
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
     * Sets the transfer action.
     * @param type The transfer type which should be DndConstants.ACTION_COPY or
     * DnDConstants.ACTION_MOVE.
     */
    public void setTransferType(int type) {
        transferType = type;
    }

    /**
     * Determines whether a move transfer type has been set.
     * @return true iff the type value of the latest setTransferAction() was
     * DnDConstants.ACTION_MOVE.
     */
    public boolean isMoveTransfer() {
        return (transferType & DnDConstants.ACTION_MOVE) != 0;
    }

    /**
     * Determines whether a copy transfer type has been set.
     * @return true iff the type value of the latest setTransferAction() was
     * DnDConstants.ACTION_COPY.
     */
    public boolean isCopyTransfer() {
        return (transferType & DnDConstants.ACTION_COPY) != 0;
    }

    public void edit() {
        EditorTopComponent.findInstance().edit(this);
    }

    public void changeTopic(Topic topic) {
        action.setTopic(topic);
    }

    public void changeContext(Context context) {
        action.setContext(context);
    }

    /** Calls parent project to add an action. */
    public void addAction() {
        Node parentNode = getParentNode();
        if (parentNode instanceof AddActionCookie) {
            ((AddActionCookie) parentNode).addAction(action);
        }
    }

    /** Should not be called - doesn't do anything. */
    public void addAction(Action sibling) {
    }

    /** Calls parent project to add a project. */
    public void addProject() {
        Node parentNode = getParentNode();
        if (parentNode instanceof AddProjectCookie) {
            ((AddProjectCookie) parentNode).addProject(action);
        }
    }

    /** Should not be called - doesn't do anything. */
    public void addProject(Action sibling) {
    }

    public boolean canAddAction() {
        Node parentNode = getParentNode();
        if (parentNode instanceof AddActionCookie) {
            return ((AddActionCookie) parentNode).canAddAction();
        }
        return false;
    }

    public boolean canAddProject() {
        Node parentNode = getParentNode();
        if (parentNode instanceof AddActionCookie) {
            return ((AddProjectCookie) parentNode).canAddProject();
        }
        return false;
    }

    public void view() {
        EditorTopComponent.findInstance().view(this);
    }

    private class IconChangeListener implements PropertyChangeListener {

        public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
            setName(action.getDescription()); // name colour - inactive grey
            fireIconChange();                 // state icon change
        }
    }

    private class NameChangeListener implements PropertyChangeListener {

        public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
            setName(action.getDescription()); // name change
        }
    }

    public void print() {
        try {
            ReportImpl report = new ReportImpl();
            report.process(action);
        } catch (Exception ex) {    
        }
    }

    public void setDone() {
        if (action != null) {
            action.setDone(true);            
        }
    }

    private Date add(Date date, int n, Periods periods) {
        Calendar calendar = Calendar.getInstance();
        if (date != null) {
            calendar.setTime(date);            
        }        
        switch (periods) {
            case DAYS: {
                calendar.add(Calendar.DAY_OF_YEAR, n);
                break;
            }
            case WEEKS: {
                calendar.add(Calendar.WEEK_OF_YEAR, n);
                break;
            }
            case MONTHS: {
                calendar.add(Calendar.MONTH, n);
                break;
            }
            case YEARS: {
                calendar.add(Calendar.YEAR, n);
                break;
            }
        }
        return calendar.getTime();                                        
    }
    
    public void postponeAction(int n, Periods periods) {
        switch (action.getState().getType()) {
            case DOASAP: {
                action.setDueDate(add(action.getDueDate(), n, periods));
                break;
            }
            case INACTIVE: {
                action.setStartDate(add(action.getStartDate(), n, periods));
                break;
            }
            case SCHEDULED: {
                ActionStateScheduled state = (ActionStateScheduled)action.getState(); 
                state.setDate(add(state.getDate(), n, periods));
                break;
            }
            case DELEGATED: {
                ActionStateDelegated state = (ActionStateDelegated)action.getState(); 
                state.setDate(add(state.getDate(), n, periods));                
                break;
            }
        }        
    }

    public void delete() {
        action.removeFromParent();
    }

}
