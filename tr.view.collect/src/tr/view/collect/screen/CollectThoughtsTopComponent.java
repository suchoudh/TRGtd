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
package tr.view.collect.screen;

import au.com.thinkingrock.tr.resource.Icons;
import au.com.trgtd.tr.appl.Constants;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Vector;
import javax.swing.AbstractButton;
import javax.swing.JToolBar;
import org.openide.ErrorManager;
import org.openide.awt.Toolbar;
import org.openide.util.HelpCtx;
import org.openide.util.Lookup;
import org.openide.util.NbBundle;
import org.openide.util.actions.SystemAction;
import org.openide.util.lookup.AbstractLookup;
import org.openide.util.lookup.InstanceContent;
import org.openide.windows.TopComponent;
import org.openide.windows.WindowManager;
import tr.prefs.gui.GUIPrefs;
import tr.view.collect.DeleteThoughtAction;
import tr.view.collect.EditThoughtAction;
import tr.view.Window;
import tr.view.collect.AddThoughtsAction;

/**
 * Top component for the collect thoughts window.
 */
public final class CollectThoughtsTopComponent extends Window implements ThoughtNodeProvider {

    public static final String PREFERRED_ID = "CollectThoughtsTopComponent";
    private static final long serialVersionUID = 1L;
    private static CollectThoughtsTopComponent instance;
    private transient CollectThoughtsPanel panel;
    private transient InstanceContent content;
    private transient Lookup lookup;
//  private transient Toolbar toolbar;
    private transient JToolBar toolbar;

    /* Singleton instance. */
    private CollectThoughtsTopComponent() {
        initComponents();
        setName(NbBundle.getMessage(CollectThoughtsTopComponent.class, "CTL_CollectTopComponent"));
        setToolTipText(NbBundle.getMessage(CollectThoughtsTopComponent.class, "HINT_CollectTopComponent"));
        setIcon(Icons.Collect.getImage());            
    }


    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(new java.awt.BorderLayout());

    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    /**
     * Gets default instance. Do not use directly: reserved for *.settings files only,
     * i.e. deserialization routines; otherwise you could get a non-deserialized instance.
     * To obtain the singleton instance, use {@link findInstance}.
     */
    public static synchronized CollectThoughtsTopComponent getDefault() {
        if (instance == null) {
            instance = new CollectThoughtsTopComponent();
        }
        return instance;
    }

    /**
     * Obtain the CollectTopComponent instance. Never call {@link #getDefault}
     * directly!
     */
    public static synchronized CollectThoughtsTopComponent findInstance() {
        TopComponent win = WindowManager.getDefault().findTopComponent(PREFERRED_ID);
        if (win == null) {
            ErrorManager.getDefault().log(ErrorManager.WARNING, "Cannot find collect thoughts component. It will not be located properly in the window system.");
            return getDefault();
        }
        if (win instanceof CollectThoughtsTopComponent) {
            return (CollectThoughtsTopComponent) win;
        }
        ErrorManager.getDefault().log(ErrorManager.WARNING, "There seem to be multiple components with the '" + PREFERRED_ID + "' ID. That is a potential source of errors and unexpected behavior.");
        return getDefault();
    }

    @Override
    public int getPersistenceType() {
        return TopComponent.PERSISTENCE_ALWAYS;
    }

    private JToolBar getToolbar() {
        SystemAction[] actions = new SystemAction[]{
            SystemAction.get(AddThoughtsAction.class),
            SystemAction.get(EditThoughtAction.class),
            SystemAction.get(DeleteThoughtAction.class)
        };
        toolbar = SystemAction.createToolbarPresenter(actions);
        toolbar.setUI((new Toolbar()).getUI());
        toolbar.setFloatable(false);

        Dimension buttonSize = Constants.TOOLBAR_BUTTON_SIZE;
        for (Component component : toolbar.getComponents()) {
            if (component instanceof AbstractButton) {
                component.setPreferredSize(buttonSize);
                component.setMinimumSize(buttonSize);
                component.setMaximumSize(buttonSize);
                component.setSize(buttonSize);
            }
        }

        return toolbar;
    }

    @Override
    protected void componentOpened() {
        provide(null);

        removeAll();
        if (GUIPrefs.getButtonsPosition().equals(GUIPrefs.BUTTONS_POSITION_TOP)) {
            add(getToolbar(), BorderLayout.NORTH);
        } else {
            add(getToolbar(), BorderLayout.SOUTH);
        }
        panel = new CollectThoughtsPanel(this);
        add(panel, BorderLayout.CENTER);
    }

    private synchronized InstanceContent getInstanceContent() {
        if (content == null) {
            content = new InstanceContent();
        }
        return content;
    }

    @Override
    public Lookup getLookup() {
        if (lookup == null) {
            lookup = new AbstractLookup(getInstanceContent());
        }
        return lookup;
    }

    public void provide(final ThoughtNode thoughtNode) {
        EventQueue.invokeLater(new Runnable() {

            public void run() {
                if (panel == null || thoughtNode == null) {
                    getInstanceContent().set(Collections.EMPTY_LIST, null);
                } else {
                    Collection collection = new Vector();
                    collection.add(thoughtNode);
                    getInstanceContent().set(collection, null);
                }
            }
        });
    }

    @Override
    public HelpCtx getHelpCtx() {
        return new HelpCtx("tr.view.collect");
    }

    @Override
    public String preferredID() {
        return PREFERRED_ID;
    }

    /** replaces this in object stream */
    @Override
    public Object writeReplace() {
        return new ResolvableHelper();
    }

    final static class ResolvableHelper implements Serializable {

        private static final long serialVersionUID = 1L;

        public Object readResolve() {
            return CollectThoughtsTopComponent.getDefault();
        }
    }
}
