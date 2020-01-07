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

package tr.view.actions.prefs;

import au.com.trgtd.tr.appl.Constants;
import java.util.logging.Logger;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

/**
 * User preferences for actions screen.
 *
 * @author jeremyimoore@yahoo.com.au
 */
public class ActionsPrefs {
    
    private static final Logger LOG = Logger.getLogger("tr.view.actions.prefs");
    
    /** The preferences object. */
    public static final Preferences prefs = Preferences.userRoot().node(Constants.PREFS_PATH + "/screens/actions");
    
    private static final String KEY_REPORT_USE_COLOUR = "report.colour.";
    private static final boolean DEF_REPORT_USE_COLOUR = true;
    private static final String KEY_REPORT_STRIKE_DONE = "report.strike.";
    private static final boolean DEF_REPORT_STRIKE_DONE = true;
    private static final String KEY_REPORT_FONT = "report.font";
    private static final String DEF_REPORT_FONT = "Helvetica";
        
    private static final String KEY_VIEW_DELAY = "view.delay";
    private static final int DEF_VIEW_DELAY = 200;
    
    /**
     * Gets the value for the report use colour preference.
     * @return The value.
     */
    public static final boolean isReportUseColour() {
        return prefs.getBoolean(KEY_REPORT_USE_COLOUR, DEF_REPORT_USE_COLOUR);
    }
    /**
     * Sets the value for the report use colour preference.
     * @param value The value.
     */
    public static final void setReportUseColour(boolean value) {
        prefs.putBoolean(KEY_REPORT_USE_COLOUR, value);
        flush();
    }
    
    /**
     * Gets the value for the report strike done preference.
     * @return The value.
     */
    public static final boolean isReportStrikeDone() {
        return prefs.getBoolean(KEY_REPORT_STRIKE_DONE, DEF_REPORT_STRIKE_DONE);
    }
    /**
     * Sets the value for the report strike done preference.
     * @param value The value.
     */
    public static final void setReportStrikeDone(boolean value) {
        prefs.putBoolean(KEY_REPORT_STRIKE_DONE, value);
        flush();
    }
    
    /**
     * Gets the value for the report font preference.
     * @return The value.
     */
    public static final String getReportFont() {
        return prefs.get(KEY_REPORT_FONT, DEF_REPORT_FONT);
    }
    
    /**
     * Sets the value for the report font preference.
     * @param value The value.
     */
    public static final void setReportFont(String value) {
        prefs.put(KEY_REPORT_FONT, value);
        flush();
    }

    /**
     * TEMPORARY.
     * Gets the value for the view delay preference.
     * @return The value.
     */
    public static final int getViewDelay() {
        return prefs.getInt(KEY_VIEW_DELAY, DEF_VIEW_DELAY);
    }
    
    /**
     * Sets the value for the view delay preference.
     * @param value The value.
     */
    public static final void setViewDelay(int value) {
        prefs.putInt(KEY_VIEW_DELAY, value);
        flush();
    }
    
    private static void flush() {
        try {
            prefs.flush();
        } catch (BackingStoreException ex) {
            LOG.severe("Actions preferences error. " + ex.getMessage());
        }
    }
    
}
