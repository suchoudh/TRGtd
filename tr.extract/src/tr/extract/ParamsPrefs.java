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

package tr.extract;

import au.com.trgtd.tr.appl.Constants;
import java.util.logging.Logger;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

/**
 * Preferences for report and export parameters.
 *
 * @author Jeremy Moore (jimoore@netspace.net.au)
 */
public class ParamsPrefs {
    
    private static final Logger LOG = Logger.getLogger("tr.extract");

    // Parameters preferences node.
    private static final Preferences prefs = Preferences.userRoot().node(Constants.PREFS_PATH + "/extract/params");
    
    /**
     * Gets the value for the parameter ID and key.
     * @param id The parameter ID.
     * @param key The parameter key.
     */
    public static final String getParam(String id, String key) {
        return prefs.get(id + "." + key, null);
    }
    
    /**
     * Sets the value for the parameter ID and key.
     * @param id The parameter ID.
     * @param key The parameter key.
     * @param value The parameter value.
     */
    public static final void setParam(String id, String key, String value) {
        prefs.put(id + "." + key, value);
        flush();                        
    }
    
    
    private static void flush() {
        try {
            prefs.flush();
        } catch (BackingStoreException ex) {
            LOG.severe("Extract preferences error. " + ex.getMessage());
        }
    }
    
}
