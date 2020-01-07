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

import java.util.Date;
import tr.model.action.ActionState.Type;
import tr.util.Observable;
import tr.util.Observer;
import tr.util.Utils;

/**
 * Scheduled action state.
 *
 * @author Jeremy Moore (jeremyimoore@yahoo.com.au)
 */
public class ActionStateScheduled extends ActionState implements Observer {
    
    private Date date;
    private byte durationHours;
    private byte durationMinutes;
    private Recurrence recurrence;
    
    /** Constructs a new instance. */
    public ActionStateScheduled() {
        super();
    }
    
    /**
     * Makes a copy of itself omitting recurrence. 
     * @return The copy.
     */
    public ActionState copy() {
        ActionStateScheduled copy = new ActionStateScheduled();
        copy.created = this.created;
        copy.date = this.date;
        copy.durationHours = this.durationHours;
        copy.durationMinutes = this.durationMinutes;
        copy.recurrence = null;
        return copy;
    }
    
    /**
     * Sets the scheduled date.
     * @param date The date to set.
     */
    public void setDate(Date date) {
        if (!Utils.equal(this.date, date) ) {
            this.date = date;
            notifyObservers(this);
        }
    }
    
    /**
     * Gets the schedule date.
     * @return The schedule date.
     */
    public Date getDate() {
        return date;
    }
    
    /**
     * Sets the duration hours.
     * @param hours The hours value.
     */
    public void setDurationHours(int hours) {
        byte value = (byte)hours;
        if (value != durationHours) {
            this.durationHours = value;
            notifyObservers(this);
        }
    }
    
    /**
     * Gets the duration hours.
     * @return The hours value.
     */
    public int getDurationHours() {
        return durationHours;
    }
    
    /**
     * Sets the duration minutes.
     * @param minutes The minutes value.
     */
    public void setDurationMins(int minutes) {
        byte value = (byte)minutes;
        if (value != durationMinutes) {
            this.durationMinutes = value;
            notifyObservers(this);
        }
    }
    
    /**
     * Gets the duration minutes.
     * @return The minutes value.
     */
    public int getDurationMinutes() {
        return durationMinutes;
    }
    
    /**
     * Sets or removes a recurrence.
     * @param recurrence The new recurrence or null to remove any existing
     * recurrence.
     */
    public void setRecurrence(Recurrence recurrence) {
        
        if (this.recurrence != null) {
            this.recurrence.removeObserver(this);            
        }        
        
        this.recurrence = recurrence;
        
        if (this.recurrence != null) {
            this.recurrence.addObserver(this);            
        }                
        
        notifyObservers(this);
    };
    
    /**
     * Gets the recurrence if recurrence is defined.
     * @return The recurrence object or null.
     */
    public Recurrence getRecurrence() {
        return recurrence;
    };
    
    /**
     * Overrides equals to compare this state and another object for equality.
     * @param object the object to compare with.
     * @return true iff the object is an ActionStateScheduled instance, the
     * creation dates are equal and the schedule dates are equal.
     */
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof ActionStateScheduled)) return false;
        
        ActionStateScheduled asd = (ActionStateScheduled)object;
        if (!Utils.equal(date, asd.date)) return false;
        if (durationHours != asd.durationHours) return false;
        if (durationMinutes != asd.durationMinutes) return false;
        
        return super.equals(object);
    }
    
    /* Observable implementation. */
    /** Resets observing of recurrence. */
    @Override
    public void resetObservers() {
        if (recurrence != null) {
            recurrence.addObserver(this);
            recurrence.resetObservers();
        }
    }
    
    /* Observer implementation. */
    /**  Handle recurrence changes. */
    public void update(Observable observable, Object object) {
        notifyObservers(this, object);
    }
    
    public final ActionState.Type getType() {
        return Type.SCHEDULED;
    }
    
}
