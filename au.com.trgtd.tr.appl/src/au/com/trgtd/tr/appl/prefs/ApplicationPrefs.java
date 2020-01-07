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

package au.com.trgtd.tr.appl.prefs;

import java.util.logging.Logger;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;
import au.com.trgtd.tr.appl.Constants;

/**
 * General preferences.
 *
 * @author Jeremy Moore (jimoore@netspace.net.au)
 */
public class ApplicationPrefs {
    
    private static final Logger LOG = Logger.getLogger("tr.prefs.general");

    // User preferences for the application.
    private static final Preferences prefs = Preferences.userRoot().node(Constants.PREFS_PATH + "/general");
    
    // License accepted key.
    private static final String KEY_LICENSE_ACCEPTED = "license.accepted";
    // License accepted default value.
    private static final boolean DEF_LICENSE_ACCEPTED = false;
    
    // Last version check time key.
    private static final String KEY_VERSION_CHECK_LAST_TIME = "version.check.last.time";
    // Last version check time default value.
    private static final long DEF_VERSION_CHECK_LAST_TIME = 0;
    
    public static final int VERSION_CHECK_PERIOD_STARTUP = 0;
    public static final int VERSION_CHECK_PERIOD_DAY = 1;
    public static final int VERSION_CHECK_PERIOD_WEEK = 2;
    public static final int VERSION_CHECK_PERIOD_2_WEEKS = 3;
    public static final int VERSION_CHECK_PERIOD_MONTH = 4;
    public static final int VERSION_CHECK_PERIOD_NEVER = 5;
    
    private static final String KEY_VERSION_CHECK_PERIOD = "version.check.period";
    private static final int DEF_VERSION_CHECK_PERIOD = VERSION_CHECK_PERIOD_2_WEEKS;
    
    /**
     * Gets the value for the user has accepted the license preference.
     * @return The value.
     */
    public static final boolean isLicenceAccepted() {
        return prefs.getBoolean(KEY_LICENSE_ACCEPTED, DEF_LICENSE_ACCEPTED);
    }
    /**
     * Sets the value for the user has accepted the license preference.
     * @param value The value.
     */
    public static final void setLicenceAccepted(boolean value) {
        prefs.putBoolean(KEY_LICENSE_ACCEPTED, value);
        flush();
    }
    
    /**
     * Gets the value for the version check last time preference.
     * @return The value.
     */
    public static final long getCheckVersionLastTime() {
        return prefs.getLong(KEY_VERSION_CHECK_LAST_TIME, DEF_VERSION_CHECK_LAST_TIME);
    }
    /**
     * Sets the value for the version check last time preference.
     * @param value The value.
     */
    public static final void setCheckVersionLastTime(long value) {
        prefs.putLong(KEY_VERSION_CHECK_LAST_TIME, value);
        flush();
    }
    
    /**
     * Gets the value for the version check period preference.
     * @return The value.
     */
    public static final int getVersionCheckPeriod() {
        return prefs.getInt(KEY_VERSION_CHECK_PERIOD, DEF_VERSION_CHECK_PERIOD);
    }
    /**
     * Sets the value for the version check period preference.
     * @param value The value.
     */
    public static final void setVersionCheckPeriod(int value) {
        prefs.putInt(KEY_VERSION_CHECK_PERIOD, value);
        flush();
    }
    
    
    private static void flush() {
        try {
            prefs.flush();
        } catch (BackingStoreException ex) {
            LOG.severe("General preferences error. " + ex.getMessage());
        }
    }
    
}
