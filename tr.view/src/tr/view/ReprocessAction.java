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

import au.com.thinkingrock.tr.resource.Icons;
import java.awt.Frame;
import javax.swing.JOptionPane;
import org.openide.nodes.Node;
import org.openide.util.HelpCtx;
import org.openide.util.NbBundle;
import org.openide.util.actions.CookieAction;
import org.openide.windows.WindowManager;
import tr.model.action.Action;
import tr.model.future.Future;
import tr.model.information.Information;

/**
 * Action to reprocess an item.
 *
 * @author Jeremy Moore (jimoore@netspace.net.au)
 */
public class ReprocessAction extends CookieAction {
    
    public ReprocessAction() {
        setIcon(Icons.Reprocess);
    }
    
    /** Gets the display name. */
    public String getName() {
        return NbBundle.getMessage(getClass(), "CTL_ReprocessAction");
    }
    
    /** Gets help context. */
    public HelpCtx getHelpCtx() {
        return HelpCtx.DEFAULT_HELP;
    }
    
    public Class[] cookieClasses() {
        return new Class[] { Action.class, Information.class, Future.class };
    }
    
    public int mode() {
//      return MODE_EXACTLY_ONE;
        return MODE_ALL;
    }
    
    @Override
    protected boolean asynchronous() {
        return false;
    }
    
    public void performAction(Node[] nodes) {
//        ReprocessCookie cookie = (ReprocessCookie)nodes[0].getCookie(ReprocessCookie.class);
//        if (cookie != null) {
//            cookie.reprocess();
//        }
        if (nodes == null || nodes.length == 0) {
            return;
        }                
        String t;
        String m;
        if (nodes.length == 1) {
            m = NbBundle.getMessage(getClass(), "confirm.reprocess.message");            
            t = NbBundle.getMessage(getClass(), "confirm.reprocess.title");            
        } else {
            m = NbBundle.getMessage(getClass(), "confirm.multiple.reprocess.message", nodes.length );            
            t = NbBundle.getMessage(getClass(), "confirm.multiple.reprocess.title");            
        }
        Frame frame = WindowManager.getDefault().getMainWindow();
        
        String REPROCESS_CANCEL = NbBundle.getMessage(getClass(), "reprocess.cancel");
        String REPROCESS_NOW = NbBundle.getMessage(getClass(), "reprocess.now");
        String REPROCESS_LATER = NbBundle.getMessage(getClass(), "reprocess.later");
        
        Object[] options = {REPROCESS_CANCEL, REPROCESS_NOW, REPROCESS_LATER};
        int n = JOptionPane.showOptionDialog(frame, 
                m,
                t,
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,     //do not use a custom Icon
                options,  //the titles of buttons
                options[2]); //default button title
        
        if (n > 0) {
            boolean now = (n == 1 ? true : false);        
            for (Node node : nodes) {
                ReprocessCookie cookie = (ReprocessCookie)node.getCookie(ReprocessCookie.class);
                if (cookie != null) {
                    cookie.reprocess(now);
                }
            }
        }        
    }
    
}

