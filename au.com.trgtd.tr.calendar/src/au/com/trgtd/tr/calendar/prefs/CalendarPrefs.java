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
package au.com.trgtd.tr.calendar.prefs;

import au.com.trgtd.tr.appl.Constants;
import java.util.logging.Logger;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

/**
 * ICalendar preferences.
 *
 * @author jeremyimoore@yahoo.com.au
 */
public class CalendarPrefs {

    private static final Logger LOG = Logger.getLogger("tr.prefs.calendar");
    
    // User preferences for iCalendar.
    private static final Preferences prefs = Preferences.userRoot().node(Constants.PREFS_PATH + "/calendar");
    
    // Key for the iCalendar required preference.
    private static final String KEY_REQUIRED = "icalendar.required";
    // Default for the iCalendar required preference.
    private static final boolean DEF_REQUIRED = false;
    
    // Key for the synchronizer identifier.
    private static final String KEY_ID_SYNCHRONIZER = "id.synchronizer";

    // Key for the sync Inactive actions preference.
    private static final String KEY_SYNC_INACTIVE = "sync.inactive";
    // Default for sync Inactive actions preference.
    private static final boolean DEF_SYNC_INACTIVE = false;
    // Key for the sync Inactive actions as To Do item preference.
    private static final String KEY_TODO_INACTIVE = "todo.inactive";
    // Default for sync Inactive actions as To Do item preference.
    private static final boolean DEF_TODO_INACTIVE = true;
    
    // Key for the sync Do ASAP actions with due date preference.
    private static final String KEY_SYNC_DOASAP_DUE_DATE = "sync.doasap.due.date";
    // Default for sync Do ASAP actions with due date preference.
    private static final boolean DEF_SYNC_DOASAP_DUE_DATE = false;
    // Key for the sync Do ASAP actions with due date as To Do item preference.
    private static final String KEY_TODO_DOASAP_DUE_DATE = "todo.doasap.due.date";
    // Default for sync Do ASAP actions with due date as To Do item preference.
    private static final boolean DEF_TODO_DOASAP_DUE_DATE = true;
    // Key for the sync Do ASAP actions without due date preference.
    private static final String KEY_SYNC_DOASAP_NO_DUE_DATE = "sync.doasap.no.due.date";
    // Default for sync Do ASAP actions without due date preference.
    private static final boolean DEF_SYNC_DOASAP_NO_DUE_DATE = false;

    // Key for the sync Delegated actions preference.
    private static final String KEY_SYNC_DELEGATED = "sync.delegated";
    // Default for sync Delegated actions preference.
    private static final boolean DEF_SYNC_DELEGATED = false;    
    // Key for the sync Delegated actions as To Do item preference.
    private static final String KEY_TODO_DELEGATED = "todo.delegated";
    // Default for sync Delegated actions as To Do item preference.
    private static final boolean DEF_TODO_DELEGATED = true;
    // Key for the sync Delegated actions with no action date preference.
    private static final String KEY_SYNC_DELEGATED_NO_DATE = "sync.delegated.no.due.date";
    // Default for sync Delegated actions with no action date preference.
    private static final boolean DEF_SYNC_DELEGATED_NO_DATE = false;

    // Key for the sync Scheduled actions preference.
    private static final String KEY_SYNC_SCHEDULED = "sync.scheduled";
    // Default for sync Scheduled actions preference.
    private static final boolean DEF_SYNC_SCHEDULED = false;
    
    /**
     * Gets the value for the iCalendar required preference.
     * @return The value.
     */
    public static final boolean isICalendarRequired() {
        return prefs.getBoolean(KEY_REQUIRED, DEF_REQUIRED);
    }

    /**
     * Sets the value for the ICalendar required preference.
     * @param value The value.
     */
    public static final void setICalendarRequired(boolean value) {
        prefs.putBoolean(KEY_REQUIRED, value);
        flush();
    }
    
    /**
     * Gets the value for the synchronizer identifier.
     * @return The value.
     */
    public static final String getSynchronizerID() {
        return prefs.get(KEY_ID_SYNCHRONIZER, "");
    }

    /**
     * Sets the value for the synchronizer identifier.
     * @param value The value.
     */
    public static final void setSynchronizerID(String value) {
        prefs.put(KEY_ID_SYNCHRONIZER, value);
        flush();
    }
    
    /**
     * Gets the value for the sync Do ASAP actions with a due date preference.
     * @return The value.
     */
    public static final boolean isSyncDoasapDueDate() {
        return prefs.getBoolean(KEY_SYNC_DOASAP_DUE_DATE, DEF_SYNC_DOASAP_DUE_DATE);
    }

    /**
     * Sets the value for the sync Do ASAP actions with a due date preference.
     * @param value The value.
     */
    public static final void setSyncDoASAPWithDueDate(boolean value) {
        prefs.putBoolean(KEY_SYNC_DOASAP_DUE_DATE, value);
        flush();
    }
    
    /**
     * Gets the value for the sync Do ASAP actions with no due date preference.
     * @return The value.
     */
    public static final boolean isSyncDoasapNoDueDate() {
        return prefs.getBoolean(KEY_SYNC_DOASAP_NO_DUE_DATE, DEF_SYNC_DOASAP_NO_DUE_DATE);
    }

    /**
     * Sets the value for the sync Do ASAP actions with no due date preference.
     * @param value The value.
     */
    public static final void setSyncDoASAPWithNoDueDate(boolean value) {
        prefs.putBoolean(KEY_SYNC_DOASAP_NO_DUE_DATE, value);
        flush();
    }
        
    /**
     * Gets the value for the sync Delegated actions preference.
     * @return The value.
     */
    public static final boolean isSyncDelegated() {
        return prefs.getBoolean(KEY_SYNC_DELEGATED, DEF_SYNC_DELEGATED);
    }

    /**
     * Sets the value for the sync Delegated actions preference.
     * @param value The value.
     */
    public static final void setSyncDelegated(boolean value) {
        prefs.putBoolean(KEY_SYNC_DELEGATED, value);
        flush();
    }

    /**
     * Gets the value for the sync Delegated actions with no date preference.
     * @return The value.
     */
    public static final boolean isSyncDelegatedNoDate() {
        return prefs.getBoolean(KEY_SYNC_DELEGATED_NO_DATE, DEF_SYNC_DELEGATED_NO_DATE);
    }

    /**
     * Sets the value for the sync Delegated actions with no date preference.
     * @param value The value.
     */
    public static final void setSyncDelegatedNoDate(boolean value) {
        prefs.putBoolean(KEY_SYNC_DELEGATED_NO_DATE, value);
        flush();
    }



    /**
     * Gets the value for the sync Scheduled actions preference.
     * @return The value.
     */
    public static final boolean isSyncScheduled() {
        return prefs.getBoolean(KEY_SYNC_SCHEDULED, DEF_SYNC_SCHEDULED);
    }

    /**
     * Sets the value for the sync Scheduled actions preference.
     * @param value The value.
     */
    public static final void setSyncScheduled(boolean value) {
        prefs.putBoolean(KEY_SYNC_SCHEDULED, value);
        flush();
    }
    
    /**
     * Gets the value for the sync Do ASAP actions with a due date as To Do 
     * items preference.
     * @return The value.
     */
    public static final boolean isDoasapDueAsTodo() {
        return prefs.getBoolean(KEY_TODO_DOASAP_DUE_DATE, DEF_TODO_DOASAP_DUE_DATE);
    }

    /**
     * Sets the value for the sync Do ASAP actions with a due date as To Do 
     * items preference.
     * @param value The value.
     */
    public static final void setDoasapDueAsTodo(boolean value) {
        prefs.putBoolean(KEY_TODO_DOASAP_DUE_DATE, value);
        flush();
    }
    
    /**
     * Gets the value for the sync Delegated actions as To Do items preference.
     * @return The value.
     */
    public static final boolean isDelegatedAsTodo() {
        return prefs.getBoolean(KEY_TODO_DELEGATED, DEF_TODO_DELEGATED);
    }
    /**
     * Sets the value for the sync Delegated actions as To Do items preference.
     * @param value The value.
     */
    public static final void setDelegatedAsTodo(boolean value) {
        prefs.putBoolean(KEY_TODO_DELEGATED, value);
        flush();
    }
        
    /**
     * Gets the value for the sync Inactive actions with a start date preference.
     * @return The value.
     */
    public static final boolean isSyncInactive() {
        return prefs.getBoolean(KEY_SYNC_INACTIVE, DEF_SYNC_INACTIVE);
    }
    /**
     * Sets the value for the sync Inactive actions with a start date preference.
     * @param value The value.
     */
    public static final void setSyncInactive(boolean value) {
        prefs.putBoolean(KEY_SYNC_INACTIVE, value);
        flush();
    }

    /**
     * Gets the value for the sync Inactive actions as To Do items preference.
     * @return The value.
     */
    public static final boolean isInactiveAsTodo() {
        return prefs.getBoolean(KEY_TODO_INACTIVE, DEF_TODO_INACTIVE);
    }
    /**
     * Sets the value for the sync Inactive actions as To Do items preference.
     * @param value The value.
     */
    public static final void setInactiveAsTodo(boolean value) {
        prefs.putBoolean(KEY_TODO_INACTIVE, value);
        flush();
    }

    
    private static void flush() {
        try {
            prefs.flush();
        } catch (BackingStoreException ex) {
            LOG.severe("Calendar preferences error. " + ex.getMessage());
        }
    }
    
}
