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
package tr.model.action;

import au.com.thinkingrock.tr.resource.Icons;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Calendar;
import java.util.Date;
import javax.swing.ImageIcon;
import tr.model.IDGenerator;
import tr.model.Item.Doable;
import tr.model.Item.Item;
import tr.model.Item.ItemList;
import tr.model.context.Context;
import tr.model.context.ContextChangeCookie;
import tr.model.criteria.Value;
import tr.model.project.Project;
import tr.model.project.ProjectSingleActions;
import tr.model.thought.Thought;
import tr.model.topic.Topic;
import tr.model.topic.TopicChangeCookie;
import tr.util.DateNoTime;
import tr.util.DateUtils;
import tr.util.Observable;
import tr.util.ObservableImpl;
import tr.util.Utils;

/**
 * This class represents an action which can be a child of a project or a single
 * action.
 *
 * @author Jeremy Moore (jimoore@netspace.net.au)
 */
/*
 * This class was not changed to extend ItemList as it would require data
 * conversion of existing data stored and retrieved using XStream.
 */
public class Action extends ObservableImpl implements Doable, Item,
        ContextChangeCookie, TopicChangeCookie {

    private final Integer id;
    private Date created;
    private Thought thought;        // the originating thought if any

    private Project parent;         // the parent project if any

    private String description;
    private Topic topic;
    private Context context;
    private ActionState state;
    private String notes;
    private boolean done;
    private Date doneDate;
    /* @since 2.0 */
    private Value time;
    /* @since 2.0 */
    private Value energy;
    /* @since 2.0 */
    private Value priority;
    /* @since 2.0 */
    private String success;
    /* @since 2.0.1 */
    private Date startDate;         // not used for scheduled state
    /* @since 2.0.1 */

    private Date dueDate;           // not used for scheduled state
    /* @since 2.0.1 */

    private Date modified;

    public enum FIELD { Notes };
    
    public static final String PROP_DONE = "Done";
    public static final String PROP_DESCR = "Descr";
    public static final String PROP_CONTEXT = "Context";
    public static final String PROP_TOPIC = "Topic";
    public static final String PROP_STATE = "State";
    public static final String PROP_TIME = "Time";
    public static final String PROP_ENERGY = "Energy";
    public static final String PROP_PRIORITY = "Priority";
    public static final String PROP_NOTES = "Notes";
    
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

    /**
     * Creates a new instance.
     */
    public Action(IDGenerator idGenerator) {
        id = idGenerator.getNextID();
        setCreated();
        setModified();
        setParent(null);
        setThought(null);
        setDescription("");
        setTopic(Topic.getDefault());
        setContext(Context.getDefault());
        setState(new ActionStateASAP());
        setNotes("");
        setDone(false);
        doneDate = null;
        setTime(null);
        setEnergy(null);
        setPriority(null);
    }

    private void setCreated() {
        created = Calendar.getInstance().getTime();
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
     * Gets the creation date.
     * @return the creation date.
     */
    public Date getCreated() {
        return created;
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
     * Determines whether the action is a single action.
     * @return true iff the action does not have a parent.
     */
    public boolean isSingleAction() {
        return (parent == null || parent instanceof ProjectSingleActions);
    }

    /**
     * Determines whether the action is active.
     * @return true iff the action is not done and isStateInactive() is false.
     */
    public boolean isActive() {
        return !done && !isStateInactive();
    }

    public Date getDoneDate() {
        return doneDate;
    }

    public ActionState getState() {
        return state;
    }

    /**
     * Sets the done date to the given date without any validation.
     * @param date the given date.
     */
    public void setDoneDate(Date doneDate) {
        if (Utils.equal(this.doneDate, doneDate)) {
            return;
        }

        this.doneDate = doneDate;

        setDone(doneDate != null);

        setModified();

        notifyObservers(this);
    }

    /**
     * Gets the earliest date for which the user needs to do something.  This is
     * null if the action is done otherwise it is the earliest of delegated
     * follow-up date, scheduled date, start date and due date.
     * @return The user action date or null if there isn't one.
     */
    public Date getActionDate() {

        if (isDone()) {
            return null;
        }
        
        Date due = getDueDate();

        switch (state.getType()) {
            case DELEGATED: {
                Date followup = ((ActionStateDelegated) getState()).getDate();
                if (followup != null && (due == null || followup.before(due))) {
                    return new DateNoTime(followup);
                }
                break;
            }
            case SCHEDULED: {
                Date scheduled = ((ActionStateScheduled) getState()).getDate();
//              if (scheduled != null && (due == null || scheduled.before(due))) {
                return scheduled;
//              }
//              break;
            }
            case INACTIVE: {
                if (startDate != null && (due == null || startDate.before(due))) {
                    return new DateNoTime(startDate);
                }
                break;
            }
            default: {
            }
        }

        return (due == null) ? null : new DateNoTime(due);
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
     * Gets the due date.
     * @return the due date value.
     * @since 2.0.1
     */
    public Date getDueDate() {
        return dueDate;
    }

    /**
     * Sets the due date value after clearing any time values.
     * @param date The date to set.
     * @since 2.0.1
     */
    public void setDueDate(Date date) {
        if (date != null) {
            date = DateUtils.clearTime(date);
        }
        if (!Utils.equal(dueDate, date)) {
            dueDate = date;
            setModified();

            notifyObservers(this);
        }
    }

    public void setState(final ActionState state) {
        if (state == null) {
            return;
        }
        if (state.equals(this.state)) {
            return;
        }
        ActionState oldValue = this.state;

        if (this.state != null) {
            this.state.removeObserver(this);
        }

        this.state = state;

        this.state.addObserver(this);
        this.state.resetObservers();

        setModified();

        notifyObservers(this);

        getPropertyChangeSupport().firePropertyChange(PROP_STATE, oldValue, state);
    }

    public boolean isStateASAP() {
        return state.getType() == ActionState.Type.DOASAP;
    }

    public boolean isStateScheduled() {
        return state.getType() == ActionState.Type.SCHEDULED;
    }

    public boolean isStateDelegated() {
        return state.getType() == ActionState.Type.DELEGATED;
    }

    public boolean isStateInactive() {
        return state.getType() == ActionState.Type.INACTIVE;
    }

    public Recurrence getRecurrence() {
        if (isStateScheduled()) {
            return ((ActionStateScheduled) state).getRecurrence();
        }
        return null;
    }

    public void setRecurrence(Recurrence recurrence) {
        if (isStateScheduled()) {
            ((ActionStateScheduled) state).setRecurrence(recurrence);
        } else {
            throw new IllegalStateException("Can only set recurrence on scheduled actions.");
        }
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

    public Context getContext() {
        if (context == null) {
            return Context.getDefault();
        }
        if (context.getName().equals(Context.getDefault().getName())) {
            return Context.getDefault();
        }
        return context;
    }

    public void setContext(final Context context) {
        if (Utils.equal(this.context, context)) {
            return;
        }
        if (this.context != null) {
            this.context.removeObserver(this);
        }

        Context oldValue = this.context;

        this.context = context;

        if (this.context != null) {
            this.context.addObserver(this);
        }

        setModified();

        notifyObservers(this);

        getPropertyChangeSupport().firePropertyChange(PROP_CONTEXT, oldValue, context);
    }

    public Value getTime() {
        return time;
    }

    public void setTime(Value time) {
        if (Utils.equal(this.time, time)) {
            return;
        }
        if (this.time != null) {
            this.time.removeObserver(this);
        }

        Value oldValue = this.time;

        this.time = time;
        if (this.time != null) {
            this.time.addObserver(this);
        }
        setModified();

        notifyObservers(this);

        getPropertyChangeSupport().firePropertyChange(PROP_TIME, oldValue, time);
    }

    public Value getEnergy() {
        return energy;
    }

    public void setEnergy(Value energy) {
        if (Utils.equal(this.energy, energy)) {
            return;
        }
        if (this.energy != null) {
            this.energy.removeObserver(this);
        }

        Value oldValue = this.energy;

        this.energy = energy;
        if (this.energy != null) {
            this.energy.addObserver(this);
        }
        setModified();

        notifyObservers(this);

        getPropertyChangeSupport().firePropertyChange(PROP_ENERGY, oldValue, energy);
    }

    /**
     * Gets the priority value.
     * @return the priority value.
     */
    public Value getPriority() {
        return priority;
    }

    /**
     * Sets the priority value.
     * @param priority the new value.
     */
    public void setPriority(Value priority) {
        if (Utils.equal(this.priority, priority)) {
            return;
        }
        if (this.priority != null) {
            this.priority.removeObserver(this);
        }

        Value oldValue = this.priority;

        this.priority = priority;
        if (this.priority != null) {
            this.priority.addObserver(this);
        }
        setModified();

        notifyObservers(this);

        getPropertyChangeSupport().firePropertyChange(PROP_PRIORITY, oldValue, priority);
    }

    /**
     * Gets the notes.
     * @return the notes.
     */
    public String getNotes() {
        return (notes == null) ? "" : notes;
    }

    /**
     * Sets the notes.
     * @param notes The notes.
     */
    public void setNotes(String notes) {
        if (Utils.equal(this.notes, notes)) {
            return;
        }
        this.notes = notes;

        setModified();

//      notifyObservers(this);
        notifyObservers(this, FIELD.Notes);
    }

    @Override
    public boolean equals(Object object) {

        if (object instanceof Action) {
            return this.getID() == ((Action) object).getID();
        }
        return false;
    }

    @Override
    public String toString() {
        return getDescription();
    }

    /* Observer implementation */
    /**
     * Handle update by passing on changes to observers.
     */
    public void update(Observable observable, Object argument) {
        if (observable instanceof ActionState) {
            getPropertyChangeSupport().firePropertyChange(PROP_STATE, null, state);
        }
        notifyObservers(this, argument);
    }
    /* End of Observer implementation */

    /* Observable implementation */
    /**
     * Resets observing of state, topic and context.
     */
    @Override
    public void resetObservers() {
        if (state != null) {
            state.addObserver(this);
            state.resetObservers();
        }
        if (topic != null) {
            topic.addObserver(this);
            topic.resetObservers();
        }
        if (context != null) {
            context.addObserver(this);
            context.resetObservers();
        }
    }

    /* Doable implementation */
    /**
     * Determines whether this action is done.
     * @return true iff this action has been set to done.
     */
    public boolean isDone() {
        return done;
    }

    /**
     * Determines whether the action can be set to done.
     * @return true.
     */
    public boolean canSetDone(boolean b) {
        return true;
    }

    /**
     * Sets the done state and done date if the done state has changed. If the
     * new state is true then the done date is set to the current date and time.
     * If the new state is false then the done date is cleared.
     * @param done The new done state.
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
            // auto-sequencing
            if (parent != null && !parent.isRoot()) {
//                parent.sequence();
                Thread sequencingThread = new Thread("Action Sequencing") {

                    @Override
                    public void run() {
                        parent.sequence();
                    }
                };
                sequencingThread.start();
            }
            // recurrent scheduled action
            if (isStateScheduled()) {
                ActionStateScheduled s = (ActionStateScheduled) getState();
                Recurrence r = s.getRecurrence();
                if (r != null && r.getBasis() == Recurrence.Basis.DONE_DATE) {
                    r.generateSubsequent(this);
                }
            }
        } else { // not done

            doneDate = null;
            if (parent != null && !parent.isRoot()) {
                parent.setDone(false);
            }
        }

        setModified();

        notifyObservers(this);

        getPropertyChangeSupport().firePropertyChange(PROP_DONE, oldValue, done);
    }
    /* End of Doable implementation */

    /* Item implementation */
    /**
     * Gets the ID number.
     * @return the ID number.
     */
    public int getID() {
        return id;
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
     * Gets the successful outcome.
     * @return the successful outcome value. Never returns null.
     */
    public String getSuccess() {
        return (success == null) ? "" : success;
    }

    /**
     * Sets the successful outcome.
     * @param success The successful outcome value.
     */
    public void setSuccess(String success) {
        if (Utils.equal(this.success, success)) {
            return;
        }

        this.success = success;

        setModified();

        notifyObservers(this);
    }

    /**
     * Gets the icon representing the action item.
     * @param expanded is not applicable and is ignored.
     * @return The icon.
     */
    public ImageIcon getIcon(boolean expanded) {
        if (isStateASAP()) {
            return Icons.ActionDoASAP;
        }
        if (isStateDelegated()) {
            return Icons.ActionDelegated;
        }
        if (isStateScheduled()) {
            ActionStateScheduled s = (ActionStateScheduled) getState();
            Recurrence r = s.getRecurrence();
            if (r == null) {
                return Icons.ActionScheduled;
            } else {
                if (r.getBasis() == Recurrence.Basis.START_DATE) {
                    return Icons.ActionScheduledReg;
                } else {
                    return Icons.ActionScheduledSub;
                }
            }
        }
        if (isStateInactive()) {
            return Icons.ActionInactive;
        }
        return Icons.ActionDoASAP;
    }

    /**
     * Gets the parent item list.
     * @return The parent.
     */
    public ItemList getParent() {
        return parent;
    }

    /**
     * Sets the parent item list.
     * @param parent The new parent.
     */
//  public void setParent(Project project) {
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
     * Makes a copy of the action item. The copy has a new ID and creation date.
     * @param idGeneratorid The id generator.
     * @return the copy.
     */
    public Item copy(IDGenerator idGenerator) {
        Action copy = new Action(idGenerator);
        copy.setCreated();
        copy.setModified();
        copy.thought = this.thought;
        copy.parent = this.parent;
        copy.description = this.description;
        copy.success = this.success;
        copy.topic = this.topic;
        copy.context = this.context;
        copy.time = this.time;
        copy.energy = this.energy;
        copy.priority = this.priority;
        copy.state = this.state.copy();
        copy.notes = this.notes;
        copy.startDate = this.startDate;
        copy.dueDate = this.dueDate;
        copy.done = this.done;
        copy.doneDate = this.doneDate;
        return copy;
    }

    /**
     * Removes this action item from its parent item list.
     */
    public void removeFromParent() {
        if (parent != null) {
            parent.remove(this);
        }
    }

    /**
     * Determines whether this item is directly or indirectly within a given
     * list.
     * @param list The given list.
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

    /**
     * Determines whether the item is user editable.
     * @return true.
     */
    public boolean isEditable() {
        return true;
    }

    /* End of Item implementation */
    public int compareTo(Item item) {
        if (item instanceof Action) {
            return getDescription().compareToIgnoreCase(((Action) item).getDescription());
        }
        throw new ClassCastException(item.getClass().toString());
    }
}
