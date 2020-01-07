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
 * Delegated action state.
 *
 * @author Jeremy Moore (jeremyimoore@yahoo.com.au)
 */
public class ActionStateDelegated extends ActionState {
    
    private String to;          // delegated to
    private Date chase;		// follow-up date
    
    /**
     * Constructs a new instance.
     */
    public ActionStateDelegated() {
        super();
    }
    
    /**
     * Makes an exact copy of itself.
     * @return The copy.
     */
    public ActionState copy() {
        ActionStateDelegated copy = new ActionStateDelegated();
        copy.created = this.created;
        copy.to = this.to;
        copy.chase = this.chase;
        return copy;
    }
    
    /**
     * Gets the delegated to value.
     * @return the delegated to value.
     */
    public String getTo() {
        return (to == null) ? "" : to;
    }
    
    /**
     * Sets the delegated to value.
     * @param to The delegated to value.
     */
    public void setTo(String to) {
        if (!Utils.equal(this.to, to)) {
            this.to = to;
            notifyObservers(this);
        }
    }
    
    /**
     * Gets the follow-up date value.
     * @return the follow-up date value.
     */
    public Date getDate() {
        return chase;
    }
    
    /**
     * Sets the follow-up date value after clearing time values.
     * @param date The date to set.
     */
    public void setDate(Date date) {
        // remove time from date
        if (date != null) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            cal.set(Calendar.HOUR_OF_DAY, 0);
            cal.set(Calendar.MINUTE, 0);
            cal.set(Calendar.SECOND, 0);
            cal.set(Calendar.MILLISECOND, 0);
            date = cal.getTime();
        }
        
        if ( ! Utils.equal(this.chase, date)) {
            this.chase = date;
            notifyObservers(this);
        }
    }
    
    /**
     * Overrides equals to compare this state and another object for equality.
     * @param object the object to compare with.
     * @return true iff the object is an ActionStateDelegated instance, the
     * creation dates, delegated to values and chase dates are equal.
     */
    public boolean equals(Object object) {
        if (!(object instanceof ActionStateDelegated)) return false;
        
        ActionStateDelegated asd = (ActionStateDelegated)object;
        if (!Utils.equal(to, asd.to)) return false;
        if (!Utils.equal(chase, asd.chase)) return false;
        
        return super.equals(object);
    }
    
    public final ActionState.Type getType() {
        return Type.DELEGATED;
    }
    
}
