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

package tr.imports.thoughts.prefs;

import au.com.trgtd.tr.appl.Constants;
import java.io.File;
import java.util.logging.Logger;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

/**
 * Preferences for import thoughts.
 *
 * @author Jeremy Moore (jimoore@netspace.net.au)
 */
public class ImportThoughtsPrefs {
    
    private static final Logger LOG = Logger.getLogger("tr.imports.thoughts");
    
    // User preferences node.
    private static final Preferences prefs
            = Preferences.userRoot().node(Constants.PREFS_PATH + "/import/thoughts");
    
    // Warning file size key.
    private static final String KEY_WARNING_FILE_SIZE = "warning.file.size";
    // Warning file size default value.
    private static final int DEF_WARNING_FILE_SIZE = 4000;
    
    // Default file path key.
    private static final String KEY_DEFAULT_FILE_PATH = "default.file.path";
    // Default file path default.
    private static final String DEF_DEFAULT_FILE_PATH = System.getProperty("user.home") + File.separator + "thoughts.txt";
    
    // Key for encoding.
    private static final String KEY_ENCODING = "thoughts.encoding";
    
    // Default value for encoding.
    private static final String DEF_ENCODING = "";
    
    
    /**
     * Gets the value for the warning file size.
     * @return The value.
     */
    public static final int getWarningFileSize() {
        return prefs.getInt(KEY_WARNING_FILE_SIZE, DEF_WARNING_FILE_SIZE );
    }
    
    /**
     * Sets the value for the warning file size.
     * @param value The value.
     */
    public static final void setWarningFileSize(int value) {
        prefs.putInt(KEY_WARNING_FILE_SIZE, value);
        flush();
    }
    
    /**
     * Gets the value for the default file path.
     * @return The value.
     */
    public static final String getDefaultFilePath() {
        return prefs.get(KEY_DEFAULT_FILE_PATH, DEF_DEFAULT_FILE_PATH);
    }
    
    /**
     * Sets the value for the default file path.
     * @param value The value.
     */
    public static final void setDefaultFilePath(String value) {
        prefs.put(KEY_DEFAULT_FILE_PATH, value);
        flush();
    }
    
    /**
     * Gets the value for encoding.
     * @return The value.
     */
    public static final String getEncoding() {
        return prefs.get(KEY_ENCODING, DEF_ENCODING);
    }
    
    /**
     * Sets the value for encoding.
     * @param value The value.
     */
    public static final void setEncoding(String value) {
        prefs.put(KEY_ENCODING, (value == null) ? "" : value.trim());
        flush();
    }
    
    
    private static void flush() {
        try {
            prefs.flush();
        } catch (BackingStoreException ex) {
            LOG.severe("Import thoughts preferences error. " + ex.getMessage());
        }
    }
    
}
