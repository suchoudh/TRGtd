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

package tr.view;

import au.com.trgtd.tr.appl.InitialAction;
import au.com.trgtd.tr.appl.InitialActionLookup;
import java.util.Collection;
import java.util.Iterator;
import java.util.logging.Logger;
import javax.swing.Action;
import org.openide.util.Lookup;
import org.openide.windows.TopComponent;
import org.openide.windows.WindowManager;
import tr.prefs.gui.GUIPrefs;

/**
 * Utilities for TR Windows.
 *
 * @author Jeremy Moore
 */
public class WindowUtils {
    
    private static final Logger LOG = Logger.getLogger("tr.viw");    
    
    /* Disabled creation of new instances */
    private WindowUtils() {
    }
    
    private static final TopComponent[] TC_ARRAY = new TopComponent[0];
    
    /**
     * Closes all opened windows.
     */
    public static final void closeWindows() {
        
        TopComponent.Registry reg = WindowManager.getDefault().getRegistry();

        TopComponent[] tcs = (TopComponent[])reg.getOpened().toArray(TC_ARRAY);
        
        for (int i = 0; i < 10; i++) { // limit attempts
            
            for (TopComponent tc : tcs) {
//                if (tc instanceof Window) {
//                    ((Window)tc).forceClose();
//                } else {
                tc.close();
//                }
            }
            
            tcs = (TopComponent[])reg.getOpened().toArray(TC_ARRAY);
            if (tcs.length == 0) {
                return;
            }
        }
        
        LOG.severe("Windows probably not closed successfully.");
        
    }
    
    /**
     * Open the initial window(s) by running the initial action defined in the
     * GUI user preferences.
     */
    public static final void openInitialWindow() {
        String id = GUIPrefs.getInitialActionID();
        if (!id.equals(GUIPrefs.INITIAL_ACTION_ID_NONE)) {
            Lookup.Result r = InitialActionLookup.instance().lookup(new Lookup.Template(InitialAction.class));
            Collection c = r.allInstances();
            for (Iterator iter = c.iterator(); iter.hasNext(); ) {
                InitialAction action = (InitialAction)iter.next();
                if (action.getID().equals(id)) {
                    ((Action)action).actionPerformed(null);
                    return;
                }
            }
        }
    }
    
    /** Open the overview window. */
    public static final void openOverviewWindow() {
        String id = "overview";
        Lookup.Result r = InitialActionLookup.instance().lookup(new Lookup.Template(InitialAction.class));
        Collection c = r.allInstances();
        for (Iterator iter = c.iterator(); iter.hasNext(); ) {
            InitialAction action = (InitialAction)iter.next();
            if (action.getID().equals(id)) {
                ((Action)action).actionPerformed(null);
                return;
            }
        }
    }
    
}

