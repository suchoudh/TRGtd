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

package tr.view.criteria;

import au.com.thinkingrock.tr.resource.Resource;
import au.com.trgtd.tr.appl.InitialAction;
import java.awt.EventQueue;
import org.openide.util.HelpCtx;
import org.openide.util.Lookup;
import org.openide.util.LookupEvent;
import org.openide.util.LookupListener;
import org.openide.util.NbBundle;
import org.openide.util.actions.CallableSystemAction;
import org.openide.windows.Mode;
import org.openide.windows.TopComponent;
import org.openide.windows.WindowManager;
import tr.model.Data;
import tr.model.DataLookup;
import tr.view.WindowUtils;

/**
 * Action which shows the contexts window.
 *
 * @author Jeremy Moore (jimoore@netspace.net.au)
 */

public class CriteriaAction extends CallableSystemAction implements InitialAction {
    
    public CriteriaAction() {
        super();
        enableDisable();
        Lookup.Result r = DataLookup.instance().lookup(new Lookup.Template(Data.class));
        r.addLookupListener(new LookupListener() {
            public void resultChanged(LookupEvent lookupEvent) {
                enableDisable();
            }
        });
    }
    
    public String getName() {
        return NbBundle.getMessage(getClass(), "CTL_CriteriaAction");
    }
    
     @Override
    protected String iconResource() {
        return Resource.Criteria;
    }       
    
    private void enableDisable() {
        Data data = (Data)DataLookup.instance().lookup(Data.class);
        setEnabled(data != null);
    }
    
    /** Gets the action identifier. */
    public String getID() {
        return "criteria";
    }
    
    public void performAction() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                Data data = (Data)DataLookup.instance().lookup(Data.class);
                if (data == null) return;
                
                WindowUtils.closeWindows();
                
                TopComponent tc = CriteriaTopComponent.findInstance();
                
//              Mode mode = WindowManager.getDefault().findMode("Setup");
                Mode mode = WindowManager.getDefault().findMode("criteria");
                if (mode != null) {
                    mode.dockInto(tc);
                }
                
                tc.open();
                tc.requestActive();
            }
        });
    }
    
    protected boolean asynchronous() {
        return false;
    }
    
    public HelpCtx getHelpCtx() {
        return new HelpCtx("tr.view.contexts");
    }
    
}
