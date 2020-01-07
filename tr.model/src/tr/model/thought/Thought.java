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

package tr.model.thought;

import java.util.Calendar;
import java.util.Date;
import tr.model.action.Action;
import tr.model.topic.Topic;
import tr.model.topic.TopicChangeCookie;
import tr.util.ObservableImpl;
import tr.util.Utils;

/**
 * Represents a thought.
 *
 * @author Jeremy Moore (jeremyimoore@yahoo.com.au)
 */
public class Thought extends ObservableImpl implements TopicChangeCookie {
    
    private Date created;
    private String description;
    private Topic topic;
    private boolean processed;
    /** Reprocess action. @since 2.0 */
    private Action action;
    /** @since 2.0 */
    private String notes;
    /** @since 2.2.1 */
    private Integer id;
    
    /** Observable changes to thoughts. @since 2.0 */
    public static enum Change { DESCRIPTION, TOPIC, NOTES, PROCESSED }
    
    public transient String key;
    
    /**
     * Creates a new instance.
     */
    public Thought(int id) {
        this.id = id;
        this.created = Calendar.getInstance().getTime();
        this.description = "";
        this.topic = Topic.getDefault();
        this.processed = false;
    }

    public void initID(int id) {
        if (this.id == null) {
            this.id = id;
        }
    }

    /**
     * Gets the ID number.
     * @return the ID number.
     */
    public int getID() {
        return id;
    }

    /**
     * Gets the creation date.
     * @return The creation date.
     */
    public Date getCreated() {
        return created;
    }
    
    /**
     * Gets the description.
     * @return The description.
     */
    public String getDescription() {
        return description;
    }
    
    /**
     * Sets the description.
     * @param description The description.
     */
    public void setDescription(String description) {
        if (Utils.equal(this.description, description)) return;
        
        this.description = description;
        
        notifyObservers(this, Change.DESCRIPTION);
    }
    
    /**
     * Gets the topic.
     * @return The topic.
     */
    public Topic getTopic() {
        if (topic == null) {
            return Topic.getDefault();
        }
        if (topic.getName().equals(Topic.getDefault().getName())) {
            return Topic.getDefault();
        }
        return topic;
    }
    
    /**
     * Sets the topic.
     * @param topic The topic.
     */
    public void setTopic(Topic topic) {
        if (Utils.equal(this.topic, topic)) return;
        
        this.topic = topic;
        
        notifyObservers(this, Change.TOPIC);
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
        if (notes != null && notes.trim().length() == 0) {
            notes = null;
        }
        if (Utils.equal(this.notes, notes)) {
            return;
        }
        
        this.notes = notes;
        
        notifyObservers(this, Change.NOTES);
    }
    
    /**
     * Determines whether the process flag is set to true.
     * @return true iff the processed flag is set to true.
     */
    public boolean isProcessed() {
        return processed;
    }
    
    /**
     * Sets the processed flag.
     * @param processed The new value.
     */
    public void setProcessed(boolean processed) {
        if (this.processed == processed) return;
        
        this.processed = processed;
        
        notifyObservers(this, Change.PROCESSED);
    }
    
    /**
     * Sets the reprocess action.
     * @param action The action.
     * @since 2.0
     */
    public void setAction(Action action) {
        if (this.action == action) return;
        
        this.action = action;
        
        notifyObservers(this);
    }
    
    /**
     * Gets the reprocess action.
     * @param action The action.
     * @since 2.0
     */
    public Action getAction() {
        return action;
    }
    
    /**
     * Override equals.
     * @see java.Object.equals()
     */
    public boolean equals(Object object) {
        if (!(object instanceof Thought)) return false;

        Thought thought = (Thought)object;
        
        if (!Utils.equal(this.created, thought.created)) return false;
        if (!Utils.equal(this.description, thought.description)) return false;
        if (!Utils.equal(this.topic, thought.topic)) return false;
        if (processed != thought.processed) return false;

        return true;
    }
    
    public String toString() {
        return description;
    }
    
}
