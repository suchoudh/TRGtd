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

package tr.archive;

import au.com.trgtd.tr.appl.Constants;
import java.util.Date;
import java.util.logging.Logger;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

/**
 * Archive preferences.
 *
 * @author jeremyimoore@yahoo.com.au
 */
public class ArchivePrefs {
    
    private static final Logger LOG = Logger.getLogger("tr.archive"); // No I18N

    // User preferences for archive.
    private static final Preferences prefs = Preferences.userRoot().node(Constants.PREFS_PATH + "/archive"); // No I18N
    
    // Key for the folder path preference.
    private static final String KEY_PATH = "path"; // No I18N
    
    // Default for the folder path preference.
    private static final String DEF_PATH = ""; // No I18N
    
    // Key for the archive date option.
    private static final String KEY_DATE = "date"; // No I18N
    
    // Default for archive date option.
    private static final long DEF_DATE = -1;

    // Key for the archive done projects only option.
    private static final String KEY_DONE_PROJECTS_ONLY = "done.projects.only"; // No I18N
    
    // Default for the archive done projects only option.
    private static final boolean DEF_DONE_PROJECTS_ONLY = true;
    
    /**
     * Gets the value for the path preference.
     * @return The value.
     */
    public static final String getPath() {
        return prefs.get(KEY_PATH, DEF_PATH);
    }
    /**
     * Sets the value for the path preference.
     * @param value The value.
     */
    public static final void setPath(String value) {
        prefs.put(KEY_PATH, value);
        flush();        
    }
    
    /**
     * Gets the value for the date option preference.
     * @return The value.
     */
    public static final Date getDate() {        
        long ms = prefs.getLong(KEY_DATE, DEF_DATE);
        if (ms == DEF_DATE) {
            return null;
        }        
        return new Date(ms);
    }

    /**
     * Sets the value for the date option preference.
     * @param value The value.
     */
    public static final void setDate(Date date) {
        prefs.putLong(KEY_DATE, (date == null) ? DEF_DATE : date.getTime());
        flush();        
    }

    
    /**
     * Gets the value for the archive done projects only preference.
     * @return The value.
     */
    public static final boolean isDoneProjectsOnly() {        
        return prefs.getBoolean(KEY_DONE_PROJECTS_ONLY, DEF_DONE_PROJECTS_ONLY);
    }

    /**
     * Sets the value for the archive done projects only preference.
     * @param value The value.
     */
    public static final void setDoneProjectsOnly(boolean b) {
        prefs.putBoolean(KEY_DONE_PROJECTS_ONLY, b);
        flush();        
    }
    
    private static void flush() {
        try {
            prefs.flush();
        } catch (BackingStoreException ex) {
            LOG.severe("Archive preferences error. " + ex.getMessage()); // No I18N
        }
    }
    
}
