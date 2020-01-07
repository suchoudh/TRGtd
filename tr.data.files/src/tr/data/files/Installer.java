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

import java.util.Vector;
import java.util.logging.Logger;
import org.openide.modules.ModuleInstall;
import org.openide.util.Lookup;
import org.openide.util.LookupEvent;
import org.openide.util.LookupListener;
import org.openide.util.actions.SystemAction;
import tr.datastore.DataStore;
import tr.datastore.DataStoreLookup;
import tr.model.Data;
import tr.model.DataLookup;

/**
 * Module installer that detects each change of data file and stores the path of
 * the ten most recently used data files in preferences.
 *
 * @author Jeremy Moore (jimoore@netspace.net.au)
 */
public class Installer extends ModuleInstall {
    
    private static final Logger LOG = Logger.getLogger("tr.data.files");
    
    private static final int N_MOST_RECENT = 10;
    
    private Lookup.Result result;
    private RecentDataFilesAction action;
    
    /**
     * Starts listening for change of data file and populates the Open Recent
     * submenu of the File menu.
     */
    public void restored() {
        result = DataLookup.instance().lookup(new Lookup.Template(Data.class));
        result.addLookupListener(new LookupListener() {
            public void resultChanged(LookupEvent lookupEvent) {
                storeDataFilePath();
                refreshRecentFilesMenu();
            }
        });
    }
    
    /**
     * Store latest data file path in preferences.
     */
    private synchronized void storeDataFilePath() {
        LOG.info("Change of data file.");
        
        DataStore ds = (DataStore)DataStoreLookup.instance().lookup(DataStore.class);
        if (ds == null) {
            LOG.info("Datastore was not found.");
            return;
        }
        
        if (!ds.isLoaded()) {
            LOG.info("No data file loaded.");
            return;
        }
        
        String path = ds.getPath();
        if (path == null || path.trim().length() == 0) {
            LOG.info("Data file path was null or an empty string.");
            return;
        }
        
        Vector<String> paths = Prefs.getPaths();
        
        if (paths.contains(path)) {
            paths.remove(path);
        }
        
        paths.add(0, path);
        
        Prefs.setPaths(paths, N_MOST_RECENT);
    }
    
    private synchronized void refreshRecentFilesMenu() {
        if (action == null) {
            action = (RecentDataFilesAction)SystemAction.get(RecentDataFilesAction.class);
        }
        action.refreshMenu();
    }
    
}