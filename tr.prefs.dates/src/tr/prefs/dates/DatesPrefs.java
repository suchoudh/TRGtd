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

package tr.prefs.dates;

import au.com.trgtd.tr.appl.Constants;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Logger;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

/**
 * User preferences for dates.
 *
 * @author Jeremy Moore (jimoore@netspace.net.au)
 */
public class DatesPrefs {
    
    private static final Logger LOG = Logger.getLogger("tr.prefs.dates");
    
    public static final Preferences prefs = Preferences.userRoot().node(Constants.PREFS_PATH + "/dates");
    
    /** Week start day Sunday value. */
    public static final int SUNDAY = Calendar.SUNDAY;
    /** Week start day Monday value. */
    public static final int MONDAY = Calendar.MONDAY;
    /* Week start day key. */
    public static final String KEY_WEEK_FIRST_DAY = "week.first.day";
    /* Week start day default. */
    private static final int DEF_WEEK_FIRST_DAY
            = Calendar.getInstance().getFirstDayOfWeek();
    
    /** Date order for month first. */
    public static final int MMDDYY = 0;
    /** Date order for day first. */
    public static final int DDMMYY = 1;
    /* Date order key. */
    public static final String KEY_DATE_ORDER = "date.order";
    /* Date order default. */
    private static final int DEF_DATE_ORDER
            = (Locale.getDefault().getCountry().equals(Locale.US.getCountry()))
            ? MMDDYY
            : DDMMYY;
    
    /** Date format type for long format. */
    public static final int DF_LONG = 0;
    /** Date format type for medium format. */
    public static final int DF_MEDIUM = 2;
    /** Date format type for short format. */
    public static final int DF_SHORT = 1;
    
    /**
     * Date formats for the date picker and also for formatting dates, e.g.
     * DateFormats[MMDDYY][DF_LONG]
     */
    public static final String[][] DateFormats = new String[][] {
        {"EEE MMM d yyyy", "M/d/yy", "MM/dd/yyyy"},
        {"EEE d MMM yyyy", "d/M/yy", "dd/MM/yyyy"},
    };
    
    /**
     * Format the given date in long (length) format using the date format
     * preferences.
     * @param date the date to format.
     * @return the formatted date.
     */
    public static final String formatLong(Date date) {
        int order = getDateOrder();
        DateFormat df = new SimpleDateFormat(DateFormats[order][0]);
        return df.format(date);
    }
    
    /**
     * Format the given date in medium (length) format using the date format
     * preferences.
     * @param date the date to format.
     * @return the formatted date.
     */
    public static final String formatMedium(Date date) {
        int order = getDateOrder();
        DateFormat df = new SimpleDateFormat(DateFormats[order][2]);
        return df.format(date);
    }
    
    /**
     * Format the given date in short (length) format using the date format
     * preferences.
     * @param date the date to format.
     * @return the formatted date.
     */
    public static final String formatShort(Date date) {
        return format(date, 1);
    }
    
    private static final String format(Date date, int type) {
        int order = getDateOrder();
        DateFormat df = new SimpleDateFormat(DateFormats[order][type]);
        return df.format(date);
    }
    
    /**
     * Gets the value for the first day of the week preference.
     * @see Calendar.getFirstDayOfWeek()
     * @return The value.
     */
    public static final int getFirstDayOfWeek() {
        return prefs.getInt(KEY_WEEK_FIRST_DAY, DEF_WEEK_FIRST_DAY);
    }
    
    /**
     * Sets the value for the first day of the week preference.
     * @see Calendar.getFirstDayOfWeek()
     * @param value The value.
     */
    public static final void setFirstDayOfWeek(int value) {
        if (value == SUNDAY || value == MONDAY) {
            prefs.putInt(KEY_WEEK_FIRST_DAY, value);
            flush();
        }
    }
        
    /**
     * Gets the value for the date order preference.
     * @return The value [DDMMYY|MMDDYY].
     */
    public static final int getDateOrder() {
        return prefs.getInt(KEY_DATE_ORDER, DEF_DATE_ORDER);
    }
    
    /**
     * Sets the value for the date order preference.
     * @param value The value [DDMMYY|MMDDYY].
     */
    public static final void setDateOrder(int value) {
        if (value == DDMMYY || value == MMDDYY) {
            prefs.putInt(KEY_DATE_ORDER, value);
            flush();
        }
    }
    
    private static void flush() {
        try {
            prefs.flush();
        } catch (BackingStoreException ex) {
            LOG.severe("Date preferences error. " + ex.getMessage());
        }
    }
    
}
