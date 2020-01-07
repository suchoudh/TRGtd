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
package tr.view.actions.screens;

import au.com.thinkingrock.tr.resource.Resource;
import java.awt.Frame;
import java.awt.Rectangle;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.openide.nodes.Node;
import org.openide.util.HelpCtx;
import org.openide.util.NbBundle;
import org.openide.util.Utilities;
import org.openide.util.actions.CookieAction;
import org.openide.windows.WindowManager;
import tr.model.action.Action;
import tr.model.context.Context;
import tr.view.contexts.ContextsComboBox;
import tr.view.contexts.ContextsComboBoxModel;

/**
 * Action to set one or more action to done.
 *
 * @author Jeremy Moore (jimoore@netspace.net.au)
 */
public class SetDoneAction extends CookieAction {

    public SetDoneAction() {
        super();
    }

    @Override
    protected String iconResource() {
        return Resource.CheckBox;
    }

    /** Gets the display name. */
    public String getName() {
        return NbBundle.getMessage(getClass(), "CTL_SetDoneAction");
    }

    /** Gets help context. */
    public HelpCtx getHelpCtx() {
        return HelpCtx.DEFAULT_HELP;
    }

    public Class[] cookieClasses() {
        return new Class[]{Action.class};
    }

    public int mode() {
        return MODE_ALL;
    }

    @Override
    protected boolean asynchronous() {
        return false;
    }

    public void performAction(Node[] nodes) {
        if (nodes == null || nodes.length == 0) {
            return;
        }
        String t;
        String m;
        if (nodes.length == 1) {
            m = NbBundle.getMessage(getClass(), "confirm.set.done.message");            
            t = NbBundle.getMessage(getClass(), "confirm.set.done.title");            
        } else {
            m = NbBundle.getMessage(getClass(), "confirm.multiple.set.done.message", nodes.length );            
            t = NbBundle.getMessage(getClass(), "confirm.multiple.set.done.title");            
        }
        Frame f = WindowManager.getDefault().getMainWindow();
        int r = JOptionPane.showConfirmDialog(f, m, t, JOptionPane.YES_NO_OPTION);
        if (r != JOptionPane.YES_OPTION) {
            return;
        }
        for (Node node : nodes) {
            SetDoneCookie cookie = (SetDoneCookie)node.getCookie(SetDoneCookie.class);
            if (cookie != null) {
                cookie.setDone(true);
            }
        }
    }
}

