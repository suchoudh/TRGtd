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
package au.com.trgtd.tr.l10n.prefs;

import au.com.trgtd.tr.appl.Constants;
import au.com.trgtd.tr.l10n.Locale;
import java.util.logging.Logger;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

/**
 * User preferences for internationalisation.
 *
 * @author <a href="mailto:jimoore@netspace.net.au">Jeremy Moore</a>
 */
public class L10nPrefs {

    public static final String KEY_ENABLED = "enabled";
    public static final String KEY_LOCALE = "locale";    
    private static final Logger LOG = Logger.getLogger("au.com.trgtd.tr.l10n");
    private static final Preferences prefs = Preferences.userRoot().node(Constants.PREFS_PATH + "/l10n");

    /**
     * Gets the value for the locale preference.
     * @return The language.
     */
    public static final Locale getLocale() {
        try {
            return Locale.valueOf(prefs.get(KEY_LOCALE, Locale.en_UK.name()));
        } catch (IllegalArgumentException ex) {
            return Locale.none;
        }
    }

    /**
     * Sets the value for the locale preference.
     * @param locale The locale.
     */
    public static final void setLanguage(Locale locale) {
        if (locale == null) {
            prefs.put(KEY_LOCALE, locale.none.name());            
        } else {
            prefs.put(KEY_LOCALE, locale.name());            
        }
        flush();
    }
        
    /**
     * Gets the value for the enabled preference.
     * @return The enabled value.
     */
    public static final boolean isEnabled() {        
        return prefs.getBoolean(KEY_ENABLED, false);
    }

    /**
     * Sets the value for the enabled preference.
     * @param enabled The enabled value.
     */
    public static final void setEnabled(boolean enabled) {
        prefs.putBoolean(KEY_ENABLED, enabled);            
        flush();
    }

    // Don't forget to flush :)
    private static void flush() {
        try {
            prefs.flush();
        } catch (BackingStoreException ex) {
            LOG.severe("L10n preferences error. " + ex.getMessage());
        }
    }
}
