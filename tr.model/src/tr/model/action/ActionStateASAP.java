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

import java.util.Calendar;
import java.util.Date;
import tr.model.action.ActionState.Type;
import tr.util.Utils;

/**
 * Do ASAP action state.
 *
 * @author Jeremy Moore (jeremyimoore@yahoo.com.au)
 */
public class ActionStateASAP extends ActionState {
    
    /* @deprecated */
    private Date due;
    
    /** Constructs a new instance. */
    public ActionStateASAP() {
        super();
    }
    
    /**
     * Makes an exact copy of itself.
     * @return The copy.
     */
    public ActionState copy() {
        ActionStateASAP copy = new ActionStateASAP();
        copy.created = this.created;
        copy.due = this.due;
        return copy;
    }
    
    /**
     * Gets the due date.
     * @return the due date value.
     * @deprecated
     */
    public Date getDueDate() {
        return due;
    }
    
    /**
     * Sets the due date value after clearing time values.
     * @param date The date to set.
     * @deprecated
     */
    public void setDueDate(Date due) {
        // remove time from date
        if (due != null) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(due);
            cal.set(Calendar.HOUR_OF_DAY, 0);
            cal.set(Calendar.MINUTE, 0);
            cal.set(Calendar.SECOND, 0);
            cal.set(Calendar.MILLISECOND, 0);
            due = cal.getTime();
        }
        
        if (!Utils.equal(this.due, due)) {
            this.due = due;
            notifyObservers(this);
        }
    }
    
    /**
     * Overrides equals to compare this state and another object for equality.
     * @param object the object to compare with.
     * @return true iff the object is an ActionStateASAP instance and the
     * creation dates (of superclass ActionState) and due dates are equal.
     */
    public boolean equals(Object object) {
        if (object instanceof ActionStateASAP) {
            
            ActionStateASAP state = (ActionStateASAP)object;
            
            if (!Utils.equal(due, state.due)) return false;
            
            return super.equals(object);
        }
        return false;
    }
    
    public final ActionState.Type getType() {
        return Type.DOASAP;
    }
    
}
