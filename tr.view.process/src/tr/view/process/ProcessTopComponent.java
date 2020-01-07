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

import au.com.thinkingrock.tr.resource.Icons;
import au.com.trgtd.tr.appl.Constants;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.util.Collection;
import java.util.Collections;
import java.util.Vector;
import javax.swing.AbstractButton;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import org.openide.awt.Toolbar;
import org.openide.util.HelpCtx;
import org.openide.util.Lookup;
import org.openide.util.NbBundle;
import org.openide.util.actions.SystemAction;
import org.openide.util.lookup.AbstractLookup;
import org.openide.util.lookup.InstanceContent;
import org.openide.windows.TopComponent;
import tr.prefs.gui.GUIPrefs;
import tr.view.Window;
import tr.view.process.ProcessPanel;
//import tr.view.process.panels.ProcessPanel;

/**
 * Top component for the process thoughts window.
 */
public final class ProcessTopComponent extends Window implements ProcessNodeProvider {

    public static final String PREFERRED_ID = "ProcessTopComponent";
    private static ProcessTopComponent instance;
    private transient InstanceContent content;
    private transient ProcessPanel panel;
    private transient Lookup lookup;

    private ProcessTopComponent() {
        initComponents();
        setName(NbBundle.getMessage(ProcessTopComponent.class, "CTL_ProcessTopComponent"));
        setToolTipText(NbBundle.getMessage(ProcessTopComponent.class, "HINT_ProcessTopComponent"));
        setIcon(Icons.ProcessThoughts.getImage());            
    }

    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(new java.awt.BorderLayout());

    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    
    private JScrollPane scrollPane;

    /**
     * Gets default instance. Do not use directly: reserved for *.settings files only,
     * i.e. deserialization routines; otherwise you could get a non-deserialized instance.
     * To obtain the singleton instance, use {@link findInstance}.
     */
    public static synchronized ProcessTopComponent getDefault() {
        if (instance == null) {
            instance = new ProcessTopComponent();
        }
        return instance;
    }

    /**
     * Obtain the ProcessTopComponent instance. Never call {@link #getDefault} directly!
     */
    public static synchronized ProcessTopComponent findInstance() {
//        TopComponent win = WindowManager.getDefault().findTopComponent(PREFERRED_ID);
//        if (win == null) {
//            ErrorManager.getDefault().log(ErrorManager.WARNING, "Cannot find Process component. It will not be located properly in the window system.");
//            return getDefault();
//        }
//        if (win instanceof ProcessTopComponent) {
//            return (ProcessTopComponent)win;
//        }
//        ErrorManager.getDefault().log(ErrorManager.WARNING, "There seem to be multiple components with the '" + PREFERRED_ID + "' ID. That is a potential source of errors and unexpected behavior.");
        return getDefault();
    }

    @Override
    public int getPersistenceType() {
//        return TopComponent.PERSISTENCE_ALWAYS;
        return TopComponent.PERSISTENCE_NEVER;
    }

    @Override
    protected void componentClosed() {
        getInstanceContent().set(Collections.EMPTY_LIST, null);
    }

    private JToolBar getToolBar() {
        SystemAction[] actions = new SystemAction[]{
            SystemAction.get(ProcessAction.class),
        };

        JToolBar toolbar = SystemAction.createToolbarPresenter(actions);
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
            add(getToolBar(), BorderLayout.NORTH);
        } else {
            add(getToolBar(), BorderLayout.SOUTH);
        }

        panel = new ProcessPanel(this);

        scrollPane = new JScrollPane();
        scrollPane.setBorder(null);
        scrollPane.setViewportView(panel);
        add(scrollPane, BorderLayout.CENTER);

        panel.initModel();
    }

    @Override
    protected void componentActivated() {
        super.componentActivated();
        
        if (panel != null) {
            panel.takeFocus();            
        }
        
    }

    @Override
    public String preferredID() {
        return PREFERRED_ID;
    }

//    /** replaces this in object stream */
//    public Object writeReplace() {
//        return new ResolvableHelper();
//    }
//
//    final static class ResolvableHelper implements Serializable {
//        private static final long serialVersionUID = 1L;
//        public Object readResolve() {
//            return ProcessTopComponent.getDefault();
//        }
//    }
    /** Refreshes the window. */
    public void refresh() {
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

    @Override
    public HelpCtx getHelpCtx() {
        return new HelpCtx("tr.view.process");
    }

    /**
     * Provides a process node on the global lookup so that actions are enabled.
     * @param processNode The process node or null to remove.
     */
    public void provide(final ProcessNode processNode) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                if (panel == null || processNode == null) {
                    getInstanceContent().set(Collections.EMPTY_LIST, null);
                } else {
                    Collection collection = new Vector();
                    collection.add(processNode);
                    getInstanceContent().set(collection, null);
                }
            }
        });
    }
}
