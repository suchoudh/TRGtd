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

package tr.prefs.datafile;

import au.com.trgtd.tr.appl.Constants;
import java.util.logging.Logger;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

/**
 * Data preferences.
 *
 * @author Jeremy Moore
 */
public class DataPrefs {
    
    private static final Logger LOG = Logger.getLogger("tr.prefs.datafile");
    
    private static final Preferences prefs = Preferences.userRoot().node(Constants.PREFS_PATH + "/data");
    
    private static final String KEY_PATH = "recovery.path";
    private static final String DEF_PATH = "";
    
    /**
     * Gets the value for the recovery folder path preference.
     * @return The value.
     */
    public static final String getRecoveryPath() {
        return prefs.get(KEY_PATH, DEF_PATH);
    }
    
    /**
     * Sets the value for the recovery folder path preference.
     * @param value The value.
     */
    public static final void setRecoveryPath(String value) {
        prefs.put(KEY_PATH, value);
        try {
            prefs.flush();
        } catch (BackingStoreException ex) {
             LOG.severe("Datafile preferences error. " + ex.getMessage());            
        }
    }
    
}
