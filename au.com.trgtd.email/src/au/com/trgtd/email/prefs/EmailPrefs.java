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
package au.com.trgtd.email.prefs;

import au.com.trgtd.tr.appl.Constants;
import java.util.logging.Logger;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

/**
 * Email options preferences.
 *
 * @author <a href="mailto:jimoore@netspace.net.au">Jeremy Moore</a>
 */
public class EmailPrefs {
    
    private static final Logger LOG 
            = Logger.getLogger("au.com.trgtd.email.prefs.EmailPrefs");
    
    private static final Preferences prefs = Preferences.userRoot().node(Constants.PREFS_PATH + "/email");

    private static final String KEY_EMAIL_DESC = "account.descr";
    private static final String KEY_EMAIL_ADDR = "account.address";
    private static final String KEY_EMAIL_USER = "account.username";
    private static final String KEY_EMAIL_PASS = "account.password";
    private static final String KEY_EMAIL_SRVR = "email.server";
    private static final String KEY_EMAIL_PORT = "email.port";
    private static final String KEY_EMAIL_SSL = "email.ssl";    
    private static final int DEF_EMAIL_PORT = 110;
    private static final boolean DEF_EMAIL_SSL = false;

    private static final String KEY_FETCH_AT_STARTUP = "fetch.at.startup";
    private static final String KEY_FETCH_SCHEDULE = "fetch.schedule";
    private static final String KEY_FETCH_MS_INTERVAL = "fetch.ms.interval";

    private static final long MS_PER_MS = 1;
    private static final long MS_PER_SEC = 1000 * MS_PER_MS;
    private static final long MS_PER_MIN = 60 * MS_PER_SEC;
    private static final long MS_PER_HR = 60 * MS_PER_MIN;
    private static final long MS_PER_DAY = 24 * MS_PER_HR;

    /**
     * Gets the whole days in the given number of milliseconds.
     * @param ms
     * @return the number of days.
     */
    public static final long getDays(final long ms) {
        return (ms < MS_PER_DAY) ? 0 : ms / MS_PER_DAY;
    }

    /**
     * Gets the number of hours in the given number of milliseconds (not
     * including whole days).
     * @param ms
     * @return the number of hours (not including whole days).
     */
    public static final long getHrs(final long ms) {
        long remainder = ms;
        remainder -= getDays(ms) * MS_PER_DAY;
        return remainder / MS_PER_HR;
    }
    /**
     * Gets the number of minutes in the given number of milliseconds (not
     * including whole hours).
     * @param ms
     * @return the number of minutes (not including whole hours).
     */
    public static final long getMins(final long ms) {
        long remainder = ms;
        remainder -= getDays(ms) * MS_PER_DAY;
        remainder -= getHrs(ms) * MS_PER_HR ;
        return remainder / MS_PER_MIN;
    }
    /**
     * Gets the number of seconds in the given number of milliseconds (not
     * including whole minutes).
     * @param ms
     * @return the number of seconds (not including whole minutes).
     */
    public static final long getSecs(final long ms) {
        long remainder = ms;
        remainder -= getDays(ms) * MS_PER_DAY;
        remainder -= getHrs(ms) * MS_PER_HR ;
        remainder -= getMins(ms) * MS_PER_MIN ;
        return remainder / MS_PER_SEC;
    }
    /**
     * Gets the number of milliseconds for the given number of days, hours,
     * minutes and seconds.
     * @param days The number of days.
     * @param hrs The number of hours.
     * @param mins The number of minutes.
     * @param secs The number of seconds.
     * @return the number of milliseconds.
     */
    public static final long getMilliseconds(long days, long hrs, long mins, long secs) {
        return (days * MS_PER_DAY) + (hrs * MS_PER_HR) + (mins * MS_PER_MIN) + (secs * MS_PER_SEC);
    }

    /**
     * Gets the value for the email account description preference.
     * @return The value.
     */
    public static final String getEmailDescription() {
        return prefs.get(KEY_EMAIL_DESC, "");
    }
    
    /**
     * Sets the value for the email account description preference.
     * @param value The value.
     */
    public static final void setEmailDescription(String value) {
        prefs.put(KEY_EMAIL_DESC, value);
        flush();
    }
    
    /**
     * Gets the value for the email account address preference.
     * @return The value.
     */
    public static final String getEmailAddress() {
        return prefs.get(KEY_EMAIL_ADDR, "");
    }
    
    /**
     * Sets the value for the email account address preference.
     * @param value The value.
     */
    public static final void setEmailAddress(String value) {
        prefs.put(KEY_EMAIL_ADDR, value);
        flush();
    }
    
    /**
     * Gets the value for the email account username preference.
     * @return The value.
     */
    public static final String getEmailUsername() {
        return prefs.get(KEY_EMAIL_USER, "");
    }
    
    /**
     * Sets the value for the email account username preference.
     * @param value The value.
     */
    public static final void setEmailUsername(String value) {
        prefs.put(KEY_EMAIL_USER, value);
        flush();
    }
    
    /**
     * Gets the value for the email account password preference.
     * @return The value.
     */
    public static final String getEmailPassword() {
        return prefs.get(KEY_EMAIL_PASS, "");
    }
    
    /**
     * Sets the value for the email account description preference.
     * @param value The value.
     */
    public static final void setEmailPassword(String value) {
        prefs.put(KEY_EMAIL_PASS, value);
        flush();
    }

    /**
     * Gets the value for the email server preference.
     * @return The value.
     */
    public static final String getEmailServer() {
        return prefs.get(KEY_EMAIL_SRVR, "");
    }
    
    /**
     * Sets the value for the email server preference.
     * @param value The value.
     */
    public static final void setEmailServer(String value) {
        prefs.put(KEY_EMAIL_SRVR, value);
        flush();
    }
    
    
    /**
     * Gets the value for the email account port preference.
     * @return The value.
     */
    public static final int getPort() {
        return prefs.getInt(KEY_EMAIL_PORT, DEF_EMAIL_PORT);
    }
    
    /**
     * Sets the value for the email account port preference.
     * @param value The value.
     */
    public static final void setPort(int value) {
        prefs.putInt(KEY_EMAIL_PORT, value);
        flush();
    }
        
    /**
     * Gets the value for the email account SSL preference.
     * @return The value.
     */
    public static final boolean isSSL() {
        return prefs.getBoolean(KEY_EMAIL_SSL, DEF_EMAIL_SSL);
    }
    
    /**
     * Sets the value for the email account SSL preference.
     * @param value The value.
     */
    public static final void setSSL(boolean value) {
        prefs.putBoolean(KEY_EMAIL_SSL, value);
        flush();
    }



    /**
     * Gets the value for the fetch email at startup preference.
     * @return The value.
     */
    public static final boolean isEmailFetchAtStartup() {
        return prefs.getBoolean(KEY_FETCH_AT_STARTUP, false);
    }

    /**
     * Sets the value for the fetch email at startup preference.
     * @param value The value.
     */
    public static final void setEmailFetchAtStartup(boolean value) {
        prefs.putBoolean(KEY_FETCH_AT_STARTUP, value);
        flush();
    }

    /**
     * Gets the value for the schedule fetch email preference.
     * @return The value.
     */
    public static final boolean isEmailFetchSchedule() {
        return prefs.getBoolean(KEY_FETCH_SCHEDULE, false);
    }

    /**
     * Sets the value for the schedule fetch email preference.
     * @param value The value.
     */
    public static final void setEmailFetchSchedule(boolean value) {
        prefs.putBoolean(KEY_FETCH_SCHEDULE, value);
        flush();
    }

    /**
     * Gets the value for the scheduled fetch email millisecond interval
     * preference.
     * @return The value.
     */
    public static final long getEmailFetchIntervalMS() {
        return prefs.getLong(KEY_FETCH_MS_INTERVAL, 0);
    }

    /**
     * Sets the value for the scheduled fetch email millisecond interval
     * preference.
     * @param value The value.
     */
    public static final void setEmailFetchIntervalMS(long value) {
        prefs.putLong(KEY_FETCH_MS_INTERVAL, value);
        flush();
    }

    private static void flush() {
        try {
            prefs.flush();
        } catch (BackingStoreException ex) {
             LOG.severe("Email preferences error. " + ex.getMessage());            
        }
    }
    
}
