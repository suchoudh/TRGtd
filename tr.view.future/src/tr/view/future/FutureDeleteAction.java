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

package tr.view.future;

import au.com.thinkingrock.tr.resource.Icons;
import java.awt.Component;
import javax.swing.JOptionPane;
import org.openide.nodes.Node;
import org.openide.util.HelpCtx;
import org.openide.util.NbBundle;
import org.openide.util.actions.CookieAction;
import org.openide.windows.WindowManager;
import tr.model.future.Future;

/**
 * Action to delete future items.
 *
 * @author <a href="mailto:jimoore@netspace.net.au">Jeremy Moore</a>
 */
public class FutureDeleteAction extends CookieAction {
    
    public FutureDeleteAction() {
        super();
        setIcon(Icons.SomedayMaybeDelete);
    }
    
    /** Gets the display name. */
    public String getName() {
        return NbBundle.getMessage(getClass(), "CTL_FutureDeleteAction");
    }
    
    /** Gets help context. */
    public HelpCtx getHelpCtx() {
        return HelpCtx.DEFAULT_HELP;
    }
    
    public Class[] cookieClasses() {
        return new Class[] { Future.class };
    }
    
    public int mode() {
        return MODE_ALL;
    }
    
    protected boolean asynchronous() {
        return false;
    }
    
    public void performAction(Node[] nodes) {
        
        if (nodes == null || nodes.length == 0) return;
        
        String title = NbBundle.getMessage(FutureDeleteAction.class, "confirm.deletion");
        String message;
        if (nodes.length == 1) {
            message = NbBundle.getMessage(FutureDeleteAction.class, "confirm.deletion.message.1", nodes[0].getName());
        } else {
            message = NbBundle.getMessage(FutureDeleteAction.class, "confirm.deletion.message.2", nodes.length);
        }
        Component p = WindowManager.getDefault().getMainWindow();
        int opt = JOptionPane.showConfirmDialog(p, message, title, JOptionPane.YES_NO_OPTION);
        if (opt != JOptionPane.YES_OPTION) {
            return;
        }
        
        for (Node node : nodes) {
            FutureDeleteCookie cookie = (FutureDeleteCookie)node.getCookie(FutureDeleteCookie.class);
            if (cookie != null) {
                cookie.deleteFuture();
            }
        }
    }
    
}

