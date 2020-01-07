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
package tr.view.process;

import au.com.thinkingrock.tr.resource.Resource;
import org.openide.nodes.Node;
import org.openide.util.HelpCtx;
import org.openide.util.Lookup;
import org.openide.util.LookupEvent;
import org.openide.util.LookupListener;
import org.openide.util.NbBundle;
import org.openide.util.actions.CookieAction;
import tr.model.Data;
import tr.model.DataLookup;

/**
 * Action to process a thought.
 *
 * @author Jeremy Moore (jimoore@netspace.net.au)
 */
public class ProcessAction extends CookieAction {

    public ProcessAction() {
        super();
        enableDisable();
        Lookup.Result r = DataLookup.instance().lookup(new Lookup.Template(Data.class));
        r.addLookupListener(new LookupListener() {
            public void resultChanged(LookupEvent lookupEvent) {
                enableDisable();
            }
        });
    }

    private void enableDisable() {
        Data data = (Data) DataLookup.instance().lookup(Data.class);
        setEnabled(data != null);
    }

    @Override
    protected String iconResource() {
        return Resource.Process;
    }

    /** Gets the display name. */
    public String getName() {
        return NbBundle.getMessage(getClass(), "CTL_ProcessAction");
    }

    /** Gets help context. */
    public HelpCtx getHelpCtx() {
        return HelpCtx.DEFAULT_HELP;
    }

    public Class[] cookieClasses() {
        return new Class[]{ProcessCookie.class};
    }

    public int mode() {
        return MODE_EXACTLY_ONE;
    }

    @Override
    protected boolean asynchronous() {
        return false;
    }

    public void performAction(Node[] nodes) {
        ProcessCookie cookie = (ProcessCookie) nodes[0].getCookie(ProcessCookie.class);
        if (cookie != null) {
            cookie.process();
        }
    }
}

