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

import org.openide.util.HelpCtx;
import org.openide.util.NbBundle;
import org.openide.util.actions.CallableSystemAction;
import org.openide.util.actions.SystemAction;

/**
 * Action to clear the recent files menu.
 *
 * @author Jeremy Moore (jimoore@netspace.net.au)
 */
public final class RecentDataFilesClearAction extends CallableSystemAction {
        
    public void performAction() {
        Prefs.setPaths(null, 0);
        
        RecentDataFilesAction action = (RecentDataFilesAction)SystemAction.get(RecentDataFilesAction.class);
        if (action != null) {
            action.refreshMenu();
        }
    }
    
    public String getName() {
        return NbBundle.getMessage(RecentDataFilesClearAction.class, "CTL_RecentDataFilesClearAction");
    }
    
    
    public HelpCtx getHelpCtx() {
        return HelpCtx.DEFAULT_HELP;
    }
    
    @Override
    protected boolean asynchronous() {
        return false;
    }
    
}
