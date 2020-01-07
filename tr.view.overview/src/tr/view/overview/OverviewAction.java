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
package tr.view.overview;

import au.com.thinkingrock.tr.resource.Resource;
import au.com.trgtd.tr.appl.InitialAction;
import java.awt.EventQueue;
import org.openide.util.HelpCtx;
import org.openide.util.NbBundle;
import org.openide.util.actions.CallableSystemAction;
import org.openide.windows.Mode;
import org.openide.windows.TopComponent;
import org.openide.windows.WindowManager;
import tr.view.WindowUtils;

/**
 * Action which shows the overview window.
 */
//public class OverviewAction extends AbstractAction implements InitialAction {
public class OverviewAction extends CallableSystemAction implements InitialAction {

    public OverviewAction() {
        super();
    }

    @Override
    protected String iconResource() {
        return Resource.Overview;
    }
        
    /** Gets the initial action identifier. */
    public String getID() {
        return "overview";
    }

    public String getName() {
        return NbBundle.getMessage(OverviewAction.class, "CTL_OverviewAction");
    }

    @Override
    public void performAction() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                WindowUtils.closeWindows();

                TopComponent tc = OverviewTopComponent.findInstance();

                Mode mode = WindowManager.getDefault().findMode("overview");
                if (mode != null) {
                    mode.dockInto(tc);
                }

                tc.open();
                tc.requestActive();
            }
        });
    }

    @Override
    protected boolean asynchronous() {
        return false;
    }
    
    @Override
    public HelpCtx getHelpCtx() {
        return new HelpCtx("tr.view.overview");
    }
}
