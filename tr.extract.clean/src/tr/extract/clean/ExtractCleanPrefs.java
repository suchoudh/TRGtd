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

package tr.extract.clean;

import au.com.trgtd.tr.appl.Constants;
import java.util.logging.Logger;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

/**
 * Extract clean preferences.
 *
 * @author Jeremy Moore (jimoore@netspace.net.au)
 */
public class ExtractCleanPrefs {
    
    private static final Logger LOG = Logger.getLogger("tr.extract.clean");

    // User preferences for extracts.
    private static final Preferences prefs = Preferences.userRoot().node(Constants.PREFS_PATH + "/extract");
        
    // Last clean date ms key.
    private static final String KEY_CLEAN_LAST_DATE_MS = "clean.last.date.ms";
    // Last clean date ms default value.
    private static final long DEF_CLEAN_LAST_DATE_MS = 0;
    
    /** Clean interval days value for Every Startup */
    public static final int CLEAN_INTERVAL_STARTUP = 0;
    /** Clean interval days value for Never */
    public static final int CLEAN_INTERVAL_NEVER = Integer.MAX_VALUE;
    // Clean interval days key.
    private static final String KEY_CLEAN_INTERVAL_DAYS = "clean.interval.days";
    // Clean interval days default value.
    private static final int DEF_CLEAN_INTERVAL_DAYS = CLEAN_INTERVAL_STARTUP;
    
    // Clean age days key.
    private static final String KEY_CLEAN_AGE_DAYS = "clean.age.days";
    // Clean age days default value.
    private static final int DEF_CLEAN_AGE_DAYS = 0;
    
    /**
     * Gets the value for the last clean date milliseconds preference.
     * @return The value.
     */
    public static final long getCleanLastDateMS() {
        return prefs.getLong(KEY_CLEAN_LAST_DATE_MS, DEF_CLEAN_LAST_DATE_MS);
    }
    /**
     * Sets the value for the last clean date milliseconds preference.
     * @param value The value.
     */
    public static final void setCleanLastDateMS(long value) {
        prefs.putLong(KEY_CLEAN_LAST_DATE_MS, value);
        flush();                
    }
    
    /**
     * Gets the value for the clean interval days preference.
     * @return The value.
     */
    public static final int getCleanIntervalDays() {
        return prefs.getInt(KEY_CLEAN_INTERVAL_DAYS, DEF_CLEAN_INTERVAL_DAYS);
    }
    /**
     * Sets the value for the clean interval days preference.
     * @param value The value.
     */
    public static final void setCleanIntervalDays(int value) {
        prefs.putInt(KEY_CLEAN_INTERVAL_DAYS, value);
        flush();                
    }
    
    /**
     * Gets the value for the clean file age days preference.
     * @return The value.
     */
    public static final int getCleanAgeDays() {
        return prefs.getInt(KEY_CLEAN_AGE_DAYS, DEF_CLEAN_AGE_DAYS);
    }
    /**
     * Sets the value for the clean file age days preference.
     * @param value The value.
     */
    public static final void setCleanAgeDays(int value) {
        prefs.putInt(KEY_CLEAN_AGE_DAYS, value);
        flush();                
    }

    private static void flush() {
        try {
            prefs.flush();
        } catch (BackingStoreException ex) {
            LOG.severe("Extract clean preferences error. " + ex.getMessage());
        }
    }

}
