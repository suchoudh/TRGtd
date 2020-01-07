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

package tr.data;

import au.com.trgtd.tr.appl.Constants;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.logging.Logger;
import org.openide.modules.ModuleInstall;
import org.openide.windows.WindowManager;
import tr.datastore.DataStore;
import tr.datastore.DataStoreLookup;
import tr.datastore.xstream.XStreamDataStore;
import tr.view.WindowUtils;

/**
 * Module installer.
 *
 * @author Jeremy Moore (jimoore@netspace.net.au)
 */
public class Installer extends ModuleInstall {
    
    private static final Logger LOG = Logger.getLogger("tr.data"); // No I18N
    
    /** Creates a new instance of Installer. */
    public Installer() {
//        System.setProperty("netbeans.tab.close.button.enabled","false");
//        System.setProperty("nb.tabs.suppressCloseButton","true");
    }
    
    /**
     * On every startup register the datastore then listen for the main window
     * to be opened and attempt to load the datastore and set the window title
     * to include the datafile path.
     */
    @Override
    public void restored() {
        loadDatastore();
    }
    
    private void loadDatastore() {
        
        DataStore ds = XStreamDataStore.instance();
        
        DataStoreLookup.instance().setDataStore(ds);
        
        try {
            ds.load();
            ds.startDaemon();
        } catch (Exception ex) {
            LOG.severe("Data store could not load data. " + ex.getMessage()); // No I18N
        }
        
        final String path = (ds == null || !ds.isLoaded()) ? "" : ds.getPath();
        
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                WindowManager.getDefault().getMainWindow().addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowOpened(WindowEvent e) {
                        super.windowOpened(e);
                        
                        ((Frame)e.getSource()).setTitle(Constants.TITLE + " " + path); // No I18N
                        
                        if (path.equals("")) { // No I18N
                            WindowUtils.openOverviewWindow();
                        } else {
                            WindowUtils.openInitialWindow();
                        }
                    }
                });
            }
        });
    }
    
    @Override
    public boolean closing() {
        WindowUtils.closeWindows();
        return super.closing();
    }
    
    @Override
    public void close() {
        DataStore ds = (DataStore)DataStoreLookup.instance().lookup(DataStore.class);
        if (ds != null) {
            ds.stopDaemon();
            try {
                ds.store();
            } catch (Exception ex) {
                LOG.severe("Data store could not store data. " + ex.getMessage()); // No I18N
            }
        }
        super.close();
        
    }
    
}
