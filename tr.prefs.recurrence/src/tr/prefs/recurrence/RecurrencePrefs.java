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

package tr.prefs.recurrence;

import au.com.trgtd.tr.appl.Constants;
import java.util.logging.Logger;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

/**
 * User preferences for recurrent scheduled actions.
 *
 * @author Jeremy Moore
 */
public class RecurrencePrefs {
    
    private static final Logger LOG = Logger.getLogger("tr.prefs.recurrence");
    
    /** The preferences object. */
    public static final Preferences prefs = Preferences.userRoot().node(Constants.PREFS_PATH + "/recurrence");
    
    private static final String KEY_NBR_FUTURE_WEEKDAY = "nbr.future.weekday";
    private static final String KEY_NBR_FUTURE_DAY = "nbr.future.day";
    private static final String KEY_NBR_FUTURE_WEEK = "nbr.future.week";
    private static final String KEY_NBR_FUTURE_MONTH = "nbr.future.month";
    private static final String KEY_NBR_FUTURE_YEAR = "nbr.future.year";

    private static final int DEF_NBR_FUTURE_WEEKDAY = 5;
    private static final int DEF_NBR_FUTURE_DAY = 7;
    private static final int DEF_NBR_FUTURE_WEEK = 4;
    private static final int DEF_NBR_FUTURE_MONTH = 1;
    private static final int DEF_NBR_FUTURE_YEAR = 1;    
    
    /**
     * Gets the preference value for the number of future occurences to generate 
     * for weekday recurrence. 
     * @return The value.
     */
    public static final int getNbrFutureWeekday() {
        return prefs.getInt(KEY_NBR_FUTURE_WEEKDAY, DEF_NBR_FUTURE_WEEKDAY);
    }

    /**
     * Gets the preference value for the number of future occurences to generate 
     * for day recurrence. 
     * @return The value.
     */
    public static final int getNbrFutureDay() {
        return prefs.getInt(KEY_NBR_FUTURE_DAY, DEF_NBR_FUTURE_DAY);
    }
    
    /**
     * Gets the preference value for the number of future occurences to generate 
     * for week recurrence. 
     * @return The value.
     */
    public static final int getNbrFutureWeek() {
        return prefs.getInt(KEY_NBR_FUTURE_WEEK, DEF_NBR_FUTURE_WEEK);
    }
    
    /**
     * Gets the preference value for the number of future occurences to generate 
     * for month recurrence. 
     * @return The value.
     */
    public static final int getNbrFutureMonth() {
        return prefs.getInt(KEY_NBR_FUTURE_MONTH, DEF_NBR_FUTURE_MONTH);
    }
    
    /**
     * Gets the preference value for the number of future occurences to generate 
     * for year recurrence. 
     * @return The value.
     */
    public static final int getNbrFutureYear() {
        return prefs.getInt(KEY_NBR_FUTURE_YEAR, DEF_NBR_FUTURE_YEAR);
    }
 
    /**
     * Sets the preference value for the number of future occurences to generate 
     * for weekday recurrence. 
     * @param The value.
     */
    public static final void setNbrFutureWeekday(int value) {
        prefs.putInt(KEY_NBR_FUTURE_WEEKDAY, value);
        flush();
    }    
    
    /**
     * Sets the preference value for the number of future occurences to generate 
     * for day recurrence. 
     * @param The value.
     */
    public static final void setNbrFutureDay(int value) {
        prefs.putInt(KEY_NBR_FUTURE_DAY, value);
        flush();
    }    
  
    /**
     * Sets the preference value for the number of future occurences to generate 
     * for weekday recurrence. 
     * @param The value.
     */
    public static final void setNbrFutureWeek(int value) {
        prefs.putInt(KEY_NBR_FUTURE_WEEK, value);
        flush();
    }    
    
    /**
     * Sets the preference value for the number of future occurences to generate 
     * for month recurrence. 
     * @param The value.
     */
    public static final void setNbrFutureMonth(int value) {
        prefs.putInt(KEY_NBR_FUTURE_MONTH, value);
        flush();
    }    

    /**
     * Sets the preference value for the number of future occurences to generate 
     * for year recurrence. 
     * @param The value.
     */
    public static final void setNbrFutureYear(int value) {
        prefs.putInt(KEY_NBR_FUTURE_YEAR, value);
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
