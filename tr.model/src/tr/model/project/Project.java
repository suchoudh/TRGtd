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
package tr.model.project;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.logging.Logger;
import tr.model.IDGenerator;
import tr.model.Item.Doable;
import tr.model.Item.Item;
import tr.model.Item.ItemList;
import tr.model.Item.ItemSelector;
import tr.model.action.Action;
import tr.model.action.ActionStateASAP;
import tr.model.criteria.Value;
import au.com.thinkingrock.tr.resource.Icons;
import au.com.trgtd.tr.appl.Constants;
import javax.swing.ImageIcon;
import tr.model.thought.Thought;
import tr.model.topic.Topic;
import tr.model.topic.TopicChangeCookie;
import tr.prefs.projects.ProjectsPrefs;
import tr.util.DateUtils;
import tr.util.Observable;
import tr.util.ObservableImpl;
import tr.util.Observer;
import tr.util.Utils;

/**
 * This class represents a TR project.
 *
 * @author Jeremy Moore (jeremyimoore@yahoo.com.au)
 */
/*
 * This class was not changed to extend ItemList as it would require data
 * conversion of existing data stored and retrieved using XStream.
 */
public class Project extends ObservableImpl
        implements TopicChangeCookie, Doable, ItemList, Observer {

    private static final Logger LOG = Logger.getLogger("tr.model.project");
    protected Integer id;
    protected Date created;
    protected Thought thought;
    protected Project parent;
    protected Vector<Item> children;
    protected Topic topic;
    protected String description;
    protected String purpose;
    /** Vision */
    protected String success;
    /** @deprecated */
    protected String brainstorming;
    /** @deprecated */
    protected String organising;
    protected boolean done;
    protected Date doneDate;
    protected boolean sequence;
    /** Action sequencing type. @since 2.0 */
    protected Sequencing sequencing;
    /** Due date. @since 2.0 */
    protected Date dueDate;
    /** Notes. @since 2.0 */
    protected String notes;
    /* @since 2.0.1 */
    protected Value priority;
    /* @since 2.0.1 */
    protected Date startDate;
    /* @since 2.0.1 */
    private Date modified;
    public static final String PROP_DONE = "Done";
    public static final String PROP_DESCR = "Descr";
    public static final String PROP_TOPIC = "Topic";
    private transient PropertyChangeSupport propertyChangeSupport;

    private PropertyChangeSupport getPropertyChangeSupport() {
        if (propertyChangeSupport == null) {
            propertyChangeSupport = new PropertyChangeSupport(this);
        }
        return propertyChangeSupport;
    }

    public void addPropertyChangeListenter(String property, PropertyChangeListener listener) {
        getPropertyChangeSupport().addPropertyChangeListener(property, listener);
    }

    public void removePropertyChangeListenter(String property, PropertyChangeListener listener) {
        getPropertyChangeSupport().removePropertyChangeListener(property, listener);
    }

    /** Default constructor. */
    public Project(IDGenerator idGenerator) {
        id = idGenerator.getNextID();
        setCreated();
        setModified();
        thought = null;
        parent = null;
        children = new Vector<Item>();
        setTopic(Topic.getDefault());
        setDescription("");
        setPurpose("");
        setVision("");
        setBrainstorming("");
        setOrganising("");
        setSequencing(ProjectsPrefs.isSequencing());
        setDone(false);
        doneDate = null;
    }

    private void setCreated() {
        created = Calendar.getInstance().getTime();
    }

    private void setModified() {
        modified = Calendar.getInstance().getTime();
    }

    public Thought getThought() {
        return thought;
    }

    public void setThought(Thought thought) {
        if (Utils.equal(this.thought, thought)) {
            return;
        }

        this.thought = thought;

        setModified();

        notifyObservers(this);
    }

    /**
     * Determines whether the project is done.
     * @return true iff the project is done.
     */
    public boolean isDone() {
        return done;
    }

    /**
     * Determines whether the project item is user editable.
     * @return true.
     */
    public boolean isEditable() {
        return true;
    }

    /**
     * Determines whether the project is a root project.
     * @return false.
     */
    public boolean isRoot() {
        return false;
    }

    /* Item selector that selects active actions. */
    private static class ActiveSelector implements ItemSelector {

        public boolean isSelected(Item item) {
            return item instanceof Action && ((Action) item).isActive();
        }
    }
    private static ActiveSelector activeSelector = new ActiveSelector();

    /**
     * Determines whether the project or any decendant project has an active
     * child action.
     * @return true iff the project contains an action that is active.
     */
    public boolean hasActiveDecendant() {
        return contains(activeSelector, true);
    }

    /* Item selector that selects doable items that are not done. */
    private static class NotDoneSelector implements ItemSelector {

        public boolean isSelected(Item item) {
            return item instanceof Doable && !((Doable) item).isDone();
        }
    }
    private static NotDoneSelector notDoneSelector = new NotDoneSelector();

    /**
     * Determines whether the project has any decendant items that are not done.
     * @return true iff the project contains an item that is not done.
     */
    public boolean hasNotDoneDecendant() {
        return contains(notDoneSelector, true);
    }

    /**
     * Sets the project done state and done date if the done state is changed.
     * If the new state is true then the done date is set to the current date
     * and time. If the new state is false then the done date is cleared.
     *
     * Make sure all children are done before calling this method - see
     * Project.canSetDone().
     *
     * @param done The new done state to set.
     */
    public void setDone(boolean done) {
        if (this.done == done) {
            return;
        }

        boolean oldValue = this.done;

        this.done = done;

        if (done) {
            if (doneDate == null) {
                doneDate = Calendar.getInstance().getTime();
            }
        } else {
            doneDate = null;
            if (parent != null) {
                parent.setDone(false);
            }
        }

        setModified();

        notifyObservers(this);

        getPropertyChangeSupport().firePropertyChange(PROP_DONE, oldValue, done);
    }

    /**
     * Sets the automatically sequencing option.
     * @param b true for automatic sequencing, false for none.
     */
    public void setSequencing(boolean b) {
        if (sequence == b) {
            return;
        }

        sequence = b;

        setModified();
        notifyObservers(this);
    }

    /**
     * Determines whether or not the automatic sequence option is on.
     * @return true iff the automatic sequence option is on.
     */
    public boolean isSequencing() {
        return sequence;
    }

    /**
     * Gets the automatic sequence type.
     * @return The automatic sequence type.
     */
    public Sequencing getSequenceType() {
        if (sequencing == null) {
            sequencing = Sequencing.INTO_SUBPROJECTS;
        }
        return sequencing;
    }

    /**
     * Sets the automatic sequence type.
     * @param type The automatic sequence type.
     */
    public void setSequenceType(Sequencing type) {
        if (this.sequencing == type) {
            return;
        }

        this.sequencing = type;

        setModified();
        notifyObservers(this);
    }

    /**
     * Determines whether automatic sequencing should go into sub-projects.
     * @return true iff automatic sequencing should go into sub-projects.
     */
    public boolean isSequenceIntoSubProjects() {
        return isSequencing() && (sequencing == Sequencing.INTO_SUBPROJECTS);
    }

    /* Item selector for determining whether an active action exists in respect
     * to automatic sequencing. */
    private static class SequencingActiveChildSelector implements ItemSelector {

        public boolean isSelected(Item item) {
            if (item instanceof Action) {
                return ((Action) item).isActive();
            }
            if (item instanceof Project) {
                Project p = (Project) item;
                if (p.parent.isSequencing() && p.parent.isSequenceIntoSubProjects()) {
                    for (Item subItem : p.getChildren()) {
                        if (isSelected(subItem)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
    }
    private static SequencingActiveChildSelector sequencingActiveChildSelector = new SequencingActiveChildSelector();

    /**
     * Automatically sequence the next action if the user preference is on.
     * @return true iff an action was activated.
     */
    public boolean sequence() {
        if (!ProjectsPrefs.isSequencing()) {
            LOG.fine("Automatic sequencing is turned off in the user preferences");
            return false;
        }

        if (sequenceNextAction()) {
            return true;
        }

        if (parent.isRoot()) {
            return false;
        }

        return parent.sequence();
    }

    private boolean sequenceNextAction() {
        if (!isSequencing()) {
            LOG.fine("Automatic sequencing is turned off for this project.");
            return false;
        }

        if (contains(sequencingActiveChildSelector, false)) {
            LOG.fine("An active action already exists.");
            return false;
        }

        // find and activate the next action if possible
        for (Item child : getChildren()) {
            LOG.fine("Processing child");

            if (child instanceof Action) {
                Action action = (Action) child;
                if (!action.isDone() && action.isStateInactive()) {
                    LOG.fine("Setting state to Do ASAP.");

                    action.setState(new ActionStateASAP());
                    return true;
                }
            } else if (isSequenceIntoSubProjects() && child instanceof Project) {
                Project subProject = (Project) child;
                if (!subProject.isDone()) {
                    if (subProject.sequenceNextAction()) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    /**
     * Sets the project done date. Make sure all decendants are done before
     * calling this method with a non-null value - see Project.canSetDone().
     */
    public void setDoneDate(Date date) {
        if (Utils.equal(this.doneDate, doneDate)) {
            return;
        }

        this.doneDate = date;

        setDone(this.doneDate != null);

        setModified();

        notifyObservers(this);
    }

    public Date getDoneDate() {
        return doneDate;
    }

    public void setDueDate(Date date) {
        this.dueDate = date;

        setModified();
        notifyObservers(this);
    }

    public Date getDueDate() {
        return dueDate;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        if (Utils.equal(this.purpose, purpose)) {
            return;
        }

        this.purpose = purpose;

        setModified();
        notifyObservers(this);
    }

    public String getVision() {
        return success;
    }

    public void setVision(String success) {
        if (Utils.equal(this.success, success)) {
            return;
        }

        this.success = success;

        setModified();
        notifyObservers(this);
    }

    /**
     * Gets the brainstorming text.
     * @return The brainstorming text.
     * @deprecated
     */
    public String getBrainstorming() {
        return brainstorming;
    }

    /**
     * Sets the brainstorming text.
     * @param text The brainstorming text.
     * @deprecated
     */
    public void setBrainstorming(String text) {
        if (Utils.equal(this.brainstorming, text)) {
            return;
        }

        this.brainstorming = text;

        setModified();
        notifyObservers(this);
    }

    /**
     * Gets the notes.
     * @return the notes.
     * @since 2.0
     */
    public String getNotes() {
        return (notes == null) ? "" : notes;
    }

    /**
     * Sets the notes.
     * @param notes The notes.
     * @since 2.0
     */
    public void setNotes(String notes) {
        if (Utils.equal(this.notes, notes)) {
            return;
        }

        this.notes = notes;

        setModified();
        notifyObservers(this);
    }

    /**
     * Gets the organising text.
     * @return The organising text.
     * @deprecated
     */
    public String getOrganising() {
        return organising;
    }

    /**
     * Sets the organising text.
     * @param text The organising text.
     * @deprecated
     */
    public void setOrganising(String text) {
        if (Utils.equal(this.organising, text)) {
            return;
        }

        this.organising = text;

        setModified();
        notifyObservers(this);
    }

    public Topic getTopic() {
        if (topic == null) {
            return Topic.getDefault();
        }
        if (topic.getName().equals(Topic.getDefault().getName())) {
            return Topic.getDefault();
        }
        return topic;
    }

    public void setTopic(Topic topic) {
        if (Utils.equal(this.topic, topic)) {
            return;
        }

        if (this.topic != null) {
            this.topic.removeObserver(this);
        }

        Topic oldValue = this.topic;

        this.topic = topic;

        if (this.topic != null) {
            this.topic.addObserver(this);
        }

        setModified();
        notifyObservers(this);

        getPropertyChangeSupport().firePropertyChange(PROP_TOPIC, oldValue, topic);
    }

    /**
     * Recursively resets this project as an observer for its children.
     */
    @Override
    public void resetObservers() {
        // observe referenced objects
        if (topic != null) {
            topic.addObserver(this);
        }

        // reset observers for children
        for (Item item : getChildren()) {
            item.addObserver(this);
            item.resetObservers();
        }
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Project) {
            return this.getID() == ((Project) object).getID();
        }
        return false;
    }

    /**
     * Gets the string representation of the project.
     * @param The project description.*/
    @Override
    public String toString() {
        return getDescription();
    }

    /** Implements Observer to pass on changes to Observers. */
    public void update(Observable observable, Object arg) {
        notifyObservers(observable, arg);
    }

    /**
     * Determines whether setting done is valid.
     * @param value the boolean value to set done to.
     * @return true if value is true, otherwise true if all decendants are done.
     */
    public boolean canSetDone(boolean value) {
        if (value == false) {
            return true;
        } else {
            // can set done true only if all children are done, i.e. there does
            // not exist a decendant that is not done.
            return !hasNotDoneDecendant();
        }
    }

    /* Item implementation */
    /**
     * Gets the ID number.
     * @return the ID number.
     */
    public int getID() {
        return id.intValue();
    }

    /**
     * Gets the creation date.
     * @return the creation date.
     */
    public Date getCreated() {
        return created;
    }

    /**
     * Sets the created date to the given date without any validation.
     * @param created the new creation date.
     */
    public void setCreated(Date created) {
        if (created == null) {
            return;
        }
        if (Utils.equal(this.created, created)) {
            return;
        }
        this.created = created;
        setModified();
        notifyObservers(this);
    }

    /**
     * Gets the description.
     * @return the description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description.
     * @param description The new description.
     */
    public void setDescription(String description) {
        if (description == null) {
            return;
        }
        if (Utils.equal(this.description, description)) {
            return;
        }

        String oldValue = this.description;

        this.description = description;

        setModified();

        notifyObservers(this);

        getPropertyChangeSupport().firePropertyChange(PROP_DESCR, oldValue, description);
    }

    /**
     * Gets the icon representing the project item.
     * @param expanded Whether or not the item is in an opened state.
     * @return The icon.
     */
    public ImageIcon getIcon(boolean opened) {
        Project patriarch = getPatriarch();        
        if (patriarch.id == Constants.ID_ROOT_PROJECTS) {
            if (isDone() || hasActiveDecendant()) {
                return (opened) ? Icons.ProjectOpen : Icons.Project;
            } else {
                return (opened) ? Icons.ProjectOpenWarn : Icons.ProjectWarn;
            }
        }
        if (patriarch.id == Constants.ID_ROOT_FUTURES) {
            return (opened) ? Icons.ProjectFutureOpen : Icons.ProjectFuture;
        }
        if (patriarch.id == Constants.ID_ROOT_TEMPLATES) {
            return (opened) ? Icons.ProjectTemplateOpen : Icons.ProjectTemplate;
        }
        return null;
    }

    private Project getPatriarch() {
        Project project = this;
        while (project.parent != null && project.parent.id != Constants.ID_ROOT_ALL) {
            project = project.parent;
        }
        return project;
    }

    /**
     * Gets the parent item list.
     * @return The parent.
     */
//    public Project getParent() {
    public ItemList getParent() {
        return parent;
    }

    /**
     * Sets the parent item list.
     * @param parent The new parent.
     */
//    public void setParent(Project parent) {
    public void setParent(ItemList parent) {
        if (Utils.equal(this.parent, parent)) {
            return;
        }

        if (parent instanceof Project) {
            this.parent = (Project) parent;
            setModified();

            notifyObservers(this);
        }

    }

    /**
     * Gets the priority value.
     * @return the priority value.
     * @since 2.0.1
     */
    public Value getPriority() {
        return priority;
    }

    /**
     * Sets the priority value.
     * @param priority the new value.
     * @since 2.0.1
     */
    public void setPriority(Value priority) {
        if (Utils.equal(this.priority, priority)) {
            return;
        }

        if (this.priority != null) {
            this.priority.removeObserver(this);
        }

        this.priority = priority;
        if (this.priority != null) {
            this.priority.addObserver(this);
        }

        setModified();
        notifyObservers(this);
    }

    /**
     * Gets the start date.
     * @return the start date value.
     * @since 2.0.1
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * Sets the start date value after clearing any time values.
     * @param date The date to set.
     * @since 2.0.1
     */
    public void setStartDate(Date date) {
        if (date != null) {
            date = DateUtils.clearTime(date);
        }

        if (!Utils.equal(startDate, date)) {
            startDate = date;
            setModified();

            notifyObservers(this);
        }

    }

    /**
     * Makes a copy of the project including children (recursively). The copy
     * has a new ID and creation date.
     * @param idGenerator the ID generator.
     * @return the copy.
     */
    public Item copy(
            IDGenerator idGenerator) {
        Project copy = new Project(idGenerator);
        copy.setCreated();
        copy.thought = this.thought;
        copy.parent = this.parent;
        copy.description = this.description;
        copy.topic = this.topic;
        copy.purpose = this.purpose;
        copy.success = this.success;
        copy.brainstorming = this.brainstorming;
        copy.organising = this.organising;
        copy.sequence = this.sequence;
        copy.sequencing = this.sequencing;
        copy.priority = this.priority;
        copy.startDate = this.startDate;
        copy.dueDate = this.dueDate;
        copy.done = this.done;
        copy.doneDate = this.doneDate;
        for (Item item : getChildren()) {
            copy.add(item.copy(idGenerator));
        }

        return copy;
    }

    /**
     * Removes this item from its parent.
     */
    public void removeFromParent() {
        if (parent != null) {
            parent.remove(this);
        }

    }

    /**
     * Determines whether this item is directly or indirectly within a given
     * item list.
     * @param list The given item list.
     * @return true Iff this item is within the given item list.
     */
    public boolean isWithin(ItemList list) {
        if (list == null || parent == null) {
            return false;
        }

        if (list == parent) {
            return true;
        }

        return parent.isWithin(list);
    }
    /* End of Item implementation */

    /* ItemList Implementation */
    /**
     * Determines whether a given item can be added.
     * @param item the given item.
     * @return true iff the item can be added.
     */
    public boolean canAdd(Item item) {

        if (item.getClass() == Action.class) {

            Action action = (Action) item;

            // can not add existing child



            if (contains(action)) {
                return false;
            }
            return true;
        }

        if (item.getClass() == Project.class) {

            Project project = (Project) item;

            // can not add child



            if (contains(project)) {
                return false;
            }
            // can not add self
            if (equals(project)) {
                return false;
            }
            // can not add parent or ancestor
            if (isWithin(project)) {
                return false;
            }
            return true;
        }

        return false;
    }

    /**
     * Reorders the children by moving the source items to the positions of the
     * destination items. Both source and destination items should be children
     * of this project
     * @param srcItems The source children items.
     * @param dstItems The destination children items.
     */
    public synchronized void reorder(Item[] srcItems, Item[] dstItems) {
        if (srcItems.length != dstItems.length) {
            return;
        }

        synchronized (this) {
            Vector reorderedChildren = new Vector(children);

            for (int i = 0; i <
                    srcItems.length; i++) {
                if (contains(srcItems[i]) && contains(dstItems[i])) {
                    int dstIndex = children.indexOf(dstItems[i]);
                    reorderedChildren.set(dstIndex, srcItems[i]);
                }

            }

            children = reorderedChildren;
        }

        setModified();
        notifyObservers(this);
    }

    /**
     * Adds a given item if possible.
     * @param item The item to add.
     * @return true if the item was added.
     */
    public boolean add(Item item) {
        if (!canAdd(item)) {
            return false;
        }

        synchronized (this) {
            if (!children.add(item)) {
                return false;
            }

        }

        item.setParent(this);
        item.addObserver(this);

        /* @since 2.0.1 */
        if (item instanceof Doable && !((Doable) item).isDone()) {
            this.setDone(false);
        }

        setModified();
        notifyObservers(this, item);

        return true;
    }

    /**
     * Adds a given item at the given index if possible.
     * @param index The index at which the item is to be inserted.
     * @param item The item to be added.
     */
    public void add(int index, Item item) {
        if (!canAdd(item)) {
            return;
        }

        synchronized (this) {
            children.add(index, item);
        }

        item.setParent(this);
        item.addObserver(this);

        /* @since 2.0.1 */
        if (item instanceof Doable && !((Doable) item).isDone()) {
            this.setDone(false);
        }

        setModified();
        notifyObservers(this, item);
    }

    /**
     * Removes the item at the given index.
     * @param index The given index.
     * @return The item that was removed.
     */
    public Item remove(int index) {
        synchronized (this) {
            if (index < 0 || index >= children.size()) {
                return null;
            }

            Item removed = children.remove(index);
            if (removed != null) {
                removed.removeObserver(this);
                setModified();

                notifyObservers(this, removed);
            }

            return removed;
        }

    }

    /**
     * Removes the item at the given index.
     * @param item the item to remove.
     * @return true iff the item in the list and was removed.
     */
    public boolean remove(Item item) {
        int index = indexOf(item);
        if (index == -1) {
            return false;
        }

        return (remove(index) != null);
    }

    /**
     * Determines whether this item list contains a given item.
     * @param item The item to look for.
     * @return true iff this list contains the given item.
     */
    public boolean contains(Item item) {
        synchronized (this) {
            return children.contains(item);
        }

    }

    /**
     * Determines whether this list contains a given item.
     * @param item The item to look for.
     * @param recurse Whether or not to recurse into sub-lists.
     * @return true iff this list contains the given item.
     */
    public boolean contains(Item item, boolean recurse) {
        if (contains(item)) {
            return true;
        }

        if (recurse) {
            for (Item child : getChildren()) {
                if (child instanceof ItemList) {
                    if (((ItemList) child).contains(item, true)) {
                        return true;
                    }

                }
            }
        }
        return false;
    }

    /**
     * Determines whether this list contains an item defined by the given item
     * selector.
     * @param selector The item selector.
     * @param recurse Whether or not to recurse into sub-lists.
     * @return true iff an item defined by the selector is found.
     */
    public boolean contains(ItemSelector selector, boolean recurse) {
        for (Item child : getChildren()) {
            if (selector.isSelected(child)) {
                return true;
            }

            if (recurse && child instanceof ItemList) {
                if (((ItemList) child).contains(selector, true)) {
                    return true;
                }

            }
        }
        return false;
    }

    /**
     * Gets an iterator over items in the list where the class of the item is
     * the same as or a subclass of the given class.
     * @param clazz The given class.
     * @return the iterator containing all item instances of the given class or
     * of a subclass of the given class.
     */
    public synchronized <T extends Item> Iterator<T> iterator(Class<T> clazz) {
        Vector<T> result = new Vector<T>();
        for (Item item : getChildren()) {
            if (clazz.isAssignableFrom(item.getClass())) {
                result.add(clazz.cast(item));
            }

        }
        return result.iterator();

    }

    /**
     * Gets a list of the children.
     * @return the list.
     */
    public synchronized List<Item> getChildren() {
        synchronized (this) {
            return new Vector<Item>(children);
        }

    }

    /**
     * Gets a list of the children of the given class.
     * @param clazz The given class.
     * @return the list.
     */
    public synchronized <T extends Item> List<T> getChildren(Class<T> clazz) {
        synchronized (this) {
            List<T> result = new Vector<T>();
            for (Item item : getChildren()) {
                if (clazz.isAssignableFrom(item.getClass())) {
                    result.add(clazz.cast(item));
                }

            }
            return result;
        }

    }

    /**
     * Gets the item list size.
     * @return The number of children in the list.
     */
    public int size() {
        synchronized (this) {
            return children.size();
        }

    }

    /**
     * Returns the index of the given item.
     * @param item The item to get the index for.
     * @return The index of the given item or -1 if the item is not in the list.
     */
    public int indexOf(Item item) {
        synchronized (this) {
            return children.indexOf(item);
        }

    }

    /* End of ItemList Implementation */
    public int compareTo(Item item) {
        if (item instanceof Project) {
            return getDescription().compareToIgnoreCase(((Project) item).getDescription());
        }

        throw new ClassCastException(item.getClass().toString());
    }
}
