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

package tr.data.files;

import au.com.trgtd.tr.appl.Constants;
import java.util.Vector;
import java.util.logging.Logger;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

/**
 * Preferences for recent files.
 *
 * @author Jeremy Moore (jimoore@netspace.net.au)
 */
public class Prefs {
    
    private static final Logger LOG = Logger.getLogger("tr.data.files");
    
    private static final String PATH = Constants.PREFS_PATH + "/recent";
    
    private static final Preferences prefs = Preferences.userRoot().node(PATH);
    
    private static final String KEY_PATH_PREFIX = "path";
    
    /**
     * Gets the value for the path preference.
     * @param n The path number.
     * @return The path value or null if there is no value stored.
     */
    private static final String getPath(int n) {
        return prefs.get(KEY_PATH_PREFIX + n, null);
    }
    
    /**
     * Sets the value for the path preference.
     * @param n The path number.
     * @param p The path value.
     */
    private static final void setPath(int n, String p) {
        prefs.put(KEY_PATH_PREFIX + n, p);
    }
    
    /**
     * Sets the values of the paths preference.
     * @param paths The paths.
     * @param max The maximum number of paths to store.
     */
    public static final void setPaths(Vector<String> paths, int max) {
        try {
            
            prefs.clear();
            
            if (paths != null) {
                for (int i = 0; i < paths.size() && i < max; i++) {
                    setPath(i, paths.get(i));
                }
            }
            
            prefs.flush();
            
        } catch (BackingStoreException ex) {
            LOG.severe("Preferences backing store exception. " + ex.getMessage());
        }
    }
    
    /**
     * Gets the values of the paths preference.
     * @return The paths.
     */
    public static final Vector<String> getPaths() {
        
        Vector<String> paths = new Vector<String>();
        
        int i = 0;
        
        while (true) {
            String path = getPath(i++);
            if (path == null) {
                break;
            }
            paths.add(path);
        }
        
        return paths;
    }
    
}
