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

package tr.view.action.prefs;

import au.com.trgtd.tr.appl.Constants;
import java.util.logging.Logger;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;
import org.openide.util.Utilities;

/**
 * User preferences for actions.
 *
 * @author Jeremy Moore (jimoore@netspace.net.au)
 */
public class ActionPrefs {
    
    private static final Logger LOG = Logger.getLogger("tr.view.action.prefs");

    /** The preferences object. */
    public static final Preferences prefs = Preferences.userRoot().node(Constants.PREFS_PATH + "/actn");

    // Note delegate email key.
    public static final String KEY_NOTE_DELEGATE_EMAIL = "note.delegate.email";
    // Note delegate email default value.
    private static final boolean DEF_NOTE_DELEGATE_EMAIL = true;
    
    // Include due date field key.
    public static final String KEY_SHOW_DUE = "show.due";
    // Include due date field default value.
    private static final boolean DEF_SHOW_DUE = false;

    // Include start date field key.
    public static final String KEY_SHOW_START = "show.start";
    // Include start date field default value.
    private static final boolean DEF_SHOW_START = false;
    
    // Show success outcome key.
    public static final String KEY_SHOW_SUCCESS = "show.success";
    // Show success outcome default value.
    private static final boolean DEF_SHOW_SUCCESS = true;
    
    // Edit creation date key.
    public static final String KEY_EDIT_CREATE_DATE = "edit.create-date";
    // Edit create date default value.
    private static final boolean DEF_EDIT_CREATE_DATE = false;

    // Key for encoding.
    private static final String KEY_ENCODING = "email.encoding";
    // Default value for encoding.
    private static final String DEF_ENCODING = "UTF-8";
    private static final String DEF_ENCODING_LINUX = "";

    private static Boolean isNoteDelegateEmail;
    private static Boolean isShowSuccess;
    private static Boolean isShowDueDate;
    private static Boolean isShowStartDate;
    private static Boolean isEditCreateDate;

    /**
     * Gets the value for the note delegate email preference.
     * @return The value.
     */
    public static final boolean isNoteDelegateEmail() {
        isNoteDelegateEmail = prefs.getBoolean(KEY_NOTE_DELEGATE_EMAIL, DEF_NOTE_DELEGATE_EMAIL);
        return isNoteDelegateEmail;
    }
    /**
     * Sets the value for the note delegate email preference.
     * @param value The value.
     */
    public static final void setNoteDelegateEmail(boolean value) {
        if (value == isNoteDelegateEmail) {
            return;
        }
        
        prefs.putBoolean(KEY_NOTE_DELEGATE_EMAIL, value);
        flush();

        isNoteDelegateEmail = value;
    }

    /**
     * Gets the value for the show due date field preference.
     * @return The value.
     */
    public static final boolean isShowDueDate() {
        isShowDueDate = prefs.getBoolean(KEY_SHOW_DUE, DEF_SHOW_DUE);
        return isShowDueDate;
    }
    /**
     * Sets the value for the show due date field preference.
     * @param value The value.
     */
    public static final void setShowDueDate(boolean value) {
        if (value == isShowDueDate) {
            return;
        }

        prefs.putBoolean(KEY_SHOW_DUE, value);
        flush();

        isShowDueDate = value;
    }
    
    /**
     * Gets the value for the show start date field preference.
     * @return The value.
     */
    public static final boolean isShowStartDate() {
        isShowStartDate = prefs.getBoolean(KEY_SHOW_START, DEF_SHOW_START);
        return isShowStartDate;
    }
    /**
     * Sets the value for the show start date field preference.
     * @param value The value.
     */
    public static final void setShowStartDate(boolean value) {
        if (value == isShowStartDate) {
            return;
        }

        prefs.putBoolean(KEY_SHOW_START, value);
        flush();

        isShowStartDate = value;
    }
    
    /**
     * Gets the value for the show success outcome preference.
     * @return The value.
     */
    public static final boolean isShowSuccess() {
        isShowSuccess = prefs.getBoolean(KEY_SHOW_SUCCESS, DEF_SHOW_SUCCESS);
        return isShowSuccess;
    }

    /**
     * Sets the value for the show success outcome preference.
     * @param value The value.
     */
    public static final void setShowSuccess(boolean value) {
        if (value == isShowSuccess) {
            return;
        }

        prefs.putBoolean(KEY_SHOW_SUCCESS, value);
        flush();

        isShowSuccess = value;
    }
    
    /**
     * Gets the value for the edit create date preference.
     * @return The value.
     */
    public static final boolean isEditCreateDate() {
        isEditCreateDate = prefs.getBoolean(KEY_EDIT_CREATE_DATE, DEF_EDIT_CREATE_DATE);
        return isEditCreateDate;
    }
    /**
     * Sets the value for the edit create date preference.
     * @param value The value.
     */
    public static final void setEditCreateDate(boolean value) {
        if (value == isEditCreateDate) {
            return;
        }

        prefs.putBoolean(KEY_EDIT_CREATE_DATE, value);
        flush();

        isEditCreateDate = value;
    }

    /**
     * Gets the value for encoding.
     * @return The value.
     */
    public static final String getEmailEncoding() {        
        if (Utilities.getOperatingSystem() == Utilities.OS_LINUX) {
            return prefs.get(KEY_ENCODING, DEF_ENCODING_LINUX);
        } else {
            return prefs.get(KEY_ENCODING, DEF_ENCODING);
        }
    }

    /**
     * Sets the value for encoding.
     * @param value The value.
     */
    public static final void setEmailEncoding(String value) {
        prefs.put(KEY_ENCODING, (value == null) ? "" : value.trim());
        flush();
    }

    private static void flush() {
        try {
            prefs.flush();
        } catch (BackingStoreException ex) {
            LOG.severe("Action preferences error. " + ex.getMessage());
        }
    }

}
