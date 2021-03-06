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

package tr.view.contexts;

import au.com.thinkingrock.tr.resource.Icons;
import org.openide.nodes.Node;
import org.openide.util.HelpCtx;
import org.openide.util.NbBundle;
import org.openide.util.actions.CookieAction;
import tr.model.context.Context;

/**
 * Action to edit a context.
 *
 * @author <a href="mailto:jimoore@netspace.net.au">Jeremy Moore</a>
 */
public class EditContextAction extends CookieAction {
    
    public EditContextAction() {
        super();
        setIcon(Icons.ContextEdit);
    }
    
    /** Gets the display name. */
    public String getName() {
        return NbBundle.getMessage(getClass(), "CTL_EditContextAction");
    }
    
    /** Gets help context. */
    public HelpCtx getHelpCtx() {
        return HelpCtx.DEFAULT_HELP;
    }
    
    public Class[] cookieClasses() {
        return new Class[] { Context.class };
    }
    
    public int mode() {
        return MODE_EXACTLY_ONE;
    }
    
    protected boolean asynchronous() {
        return false;
    }
    
    public void performAction(Node[] nodes) {
        EditContextCookie cookie = (EditContextCookie)nodes[0].getCookie(EditContextCookie.class);
        if (cookie != null) {
            cookie.editContext();
        }
    }
    
}

