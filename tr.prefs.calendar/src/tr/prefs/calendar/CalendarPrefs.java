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
package tr.prefs.calendar;

import java.util.logging.Logger;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;
import tr.appl.Constants;

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

    
    
    // Key for the file path.
    private static final String KEY_PATH = "icalendar.path";
    // Default for file path.
    private static final String DEF_PATH = System.getProperty("user.home");
    // Key for the timezone id.
    private static final String KEY_TIMEZONE = "timezone.id";
    // Default for file timezone id.
    public static final String DEF_TIMEZONE = "";

    
    
    
    
    
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
     * Gets the value for the path preference.
     * @return The value.
     */
    public static final String getICalendarPath() {
        return prefs.get(KEY_PATH, DEF_PATH);
    }

    /**
     * Sets the value for the path preference.
     * @param value The value.
     */
    public static final void setICalendarPath(String value) {
        prefs.put(KEY_PATH, value);
        flush();
    }

    /**
     * Gets the value for the time zone id preference.
     * @return The value.
     */
    public static final String getTimeZoneID() {
        return prefs.get(KEY_TIMEZONE, DEF_TIMEZONE);
    }

    /**
     * Sets the value for the time zone id preference.
     * @param value The value.
     */
    public static final void setTimeZoneID(String value) {
        prefs.put(KEY_TIMEZONE, value);
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
