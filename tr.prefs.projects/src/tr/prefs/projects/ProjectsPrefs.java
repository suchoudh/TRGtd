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

package tr.prefs.projects;

import au.com.trgtd.tr.appl.Constants;
import java.util.logging.Logger;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;
import org.openide.util.NbBundle;

/**
 * User preferences for projects screen.
 *
 * @author jeremyimoore@yahoo.com.au
 */
public class ProjectsPrefs {
    
    private static final Logger LOG = Logger.getLogger("tr.prefs.projects");
    
    /** The preferences object. */
    public static final Preferences prefs
            = Preferences.userRoot().node(Constants.PREFS_PATH + "/projects");
    
    private static final String KEY_AUTO_SEQUENCE_ACTIONS = "auto.sequence.actions";
    private static final boolean DEF_AUTO_SEQUENCE_ACTIONS = false;
    
    private static final String KEY_INCLUDE_START_DATE = "include.start.date";
    private static final boolean DEF_INCLUDE_START_DATE = false;
    
    private static final String KEY_INCLUDE_DUE_DATE = "include.due.date";
    private static final boolean DEF_INCLUDE_DUE_DATE = false;
    
    public enum ActionState {
        INACTIVE(0, NbBundle.getMessage(ProjectsPrefs.class, "ActionStateInactive")),
        DOASAP(1, NbBundle.getMessage(ProjectsPrefs.class, "ActionStateDoASAP")),
        SCHEDULED(2, NbBundle.getMessage(ProjectsPrefs.class, "ActionStateScheduled")),
        DELEGATED(3, NbBundle.getMessage(ProjectsPrefs.class, "ActionStateDelegated"));
        public final int id;
        public final String name;
        private ActionState(int id, String name) {
            this.id = id;
            this.name = name;
        }
        public static ActionState getActionState(int id) {
            if (id == DOASAP.id)    return DOASAP;
            if (id == SCHEDULED.id) return SCHEDULED;
            if (id == DELEGATED.id) return DELEGATED;
            return INACTIVE;
        }
        @Override
        public String toString() {
            return name;
        }
    }
    
    private static final String KEY_NEW_ACTION_STATE = "new.action.state";
    private static final ActionState DEF_NEW_ACTION_STATE = ActionState.INACTIVE;
    
    // Edit creation date key.
    private static final String KEY_EDIT_CREATE_DATE = "edit.create-date";
    // Edit create date default value.
    private static final boolean DEF_EDIT_CREATE_DATE = false;
    
    /**
     * Gets the value for the automatic sequence actions preference.
     * @return The value.
     */
    public static final boolean isSequencing() {
        return prefs.getBoolean(KEY_AUTO_SEQUENCE_ACTIONS, DEF_AUTO_SEQUENCE_ACTIONS);
    }
    
    /**
     * Sets the value for the automatic sequence actions preference.
     * @param value The value.
     */
    public static final void setSequencing(boolean value) {
        prefs.putBoolean(KEY_AUTO_SEQUENCE_ACTIONS, value);
        flush();
    }
    
    /**
     * Gets the value for the include start date field preference.
     * @return The value.
     */
    public static final boolean isIncludeStartDate() {
        return prefs.getBoolean(KEY_INCLUDE_START_DATE, DEF_INCLUDE_START_DATE);
    }
    /**
     * Sets the value for the include start date field preference.
     * @param value The value.
     */
    public static final void setIncludeStartDate(boolean value) {
        prefs.putBoolean(KEY_INCLUDE_START_DATE, value);
        flush();
    }
    
    /**
     * Gets the value for the include due date field preference.
     * @return The value.
     */
    public static final boolean isIncludeDueDate() {
        return prefs.getBoolean(KEY_INCLUDE_DUE_DATE, DEF_INCLUDE_DUE_DATE);
    }
    /**
     * Sets the value for the  include due date field preference.
     * @param value The value.
     */
    public static final void setIncludeDueDate(boolean value) {
        prefs.putBoolean(KEY_INCLUDE_DUE_DATE, value);
        flush();
    }
    
    /**
     * Gets the value for the new action state preference.
     * @return The value.
     */
    public static final ActionState getNewActionState() {
        int id = prefs.getInt(KEY_NEW_ACTION_STATE, DEF_NEW_ACTION_STATE.id);
        return ActionState.getActionState(id);
    }
    
    /**
     * Sets the value for the new action state preference.
     * @param value The value.
     */
    public static final void setNewActionState(ActionState value) {
        if (value == null) {
            value = DEF_NEW_ACTION_STATE;
        }
        prefs.putInt(KEY_NEW_ACTION_STATE, value.id);
        flush();
    }
    
    /**
     * Gets the value for the edit create date preference.
     * @return The value.
     */
    public static final boolean isEditCreateDate() {
        return prefs.getBoolean(KEY_EDIT_CREATE_DATE, DEF_EDIT_CREATE_DATE);
    }
    /**
     * Sets the value for the edit create date preference.
     * @param value The value.
     */
    public static final void setEditCreateDate(boolean value) {
        prefs.putBoolean(KEY_EDIT_CREATE_DATE, value);
        flush();
    }
    
    private static void flush() {
        try {
            prefs.flush();
        } catch (BackingStoreException ex) {
            LOG.severe("Projects preferences error. " + ex.getMessage());
        }
    }
    
}
