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

package tr.view.contexts.screen;

import au.com.thinkingrock.tr.resource.Icons;
import au.com.trgtd.tr.appl.Constants;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
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
import tr.view.Window;
import tr.view.contexts.AddContextsAction;
import tr.view.contexts.DeleteContextAction;
import tr.view.contexts.EditContextAction;

/**
 * Top component for the contexts window.
 *
 * @author <a href="mailto:jimoore@netspace.net.au">Jeremy Moore</a>
 */
public final class ContextsTopComponent extends Window implements ContextNodeProvider {
    
    private static final long serialVersionUID = 1L;
    
    private static final String PREFERRED_ID = "ContextsTopComponent";
    
    private static ContextsTopComponent instance;
    
    private ContextsPanel.Preferences panelPrefs;
    private ContextsPanel panel;
    private InstanceContent content;
    private Lookup lookup;
    private JToolBar toolbar;
    
    /* Singleton instance. */
    private ContextsTopComponent() {
        initComponents();
        setName(NbBundle.getMessage(ContextsTopComponent.class, "CTL_ContextsTopComponent"));
        setToolTipText(NbBundle.getMessage(ContextsTopComponent.class, "TTT_ContextsTopComponent"));
        setIcon(Icons.Context.getImage());            
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
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
    public static synchronized ContextsTopComponent getDefault() {
        if (instance == null) {
            instance = new ContextsTopComponent();
        }
        return instance;
    }
    
    /**
     * Obtain the CollectTopComponent instance. Never call {@link #getDefault}
     * directly!
     */
    public static synchronized ContextsTopComponent findInstance() {
        TopComponent win = WindowManager.getDefault().findTopComponent(PREFERRED_ID);
        if (win == null) {
            ErrorManager.getDefault().log(ErrorManager.WARNING, "Cannot find contexts component. It will not be located properly in the window system.");
            return getDefault();
        }
        if (win instanceof ContextsTopComponent) {
            return (ContextsTopComponent)win;
        }
        ErrorManager.getDefault().log(ErrorManager.WARNING, "There seem to be multiple components with the '" + PREFERRED_ID + "' ID. That is a potential source of errors and unexpected behavior.");
        return getDefault();
    }
    
    public int getPersistenceType() {
        return TopComponent.PERSISTENCE_ALWAYS;
    }
    
    private JToolBar getToolBar() {
        if (toolbar == null) {
            SystemAction[] actions = new SystemAction[] {
                SystemAction.get(AddContextsAction.class),
//              null,
                SystemAction.get(EditContextAction.class),
//              null,
                SystemAction.get(DeleteContextAction.class)
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
        }
        return toolbar;
    }
    
    protected void componentOpened() {
        super.componentOpened();
        
        provide(null);
        
        removeAll();
        
        JToolBar toolbar = getToolBar();
        String position = GUIPrefs.getButtonsPosition();
        if (position.equals(GUIPrefs.BUTTONS_POSITION_TOP)) {
            toolbar.setOrientation(JToolBar.HORIZONTAL);
            add(getToolBar(), BorderLayout.NORTH);
        } else if (position.equals(GUIPrefs.BUTTONS_POSITION_BOTTOM)) {
            toolbar.setOrientation(JToolBar.HORIZONTAL);
            add(getToolBar(), BorderLayout.SOUTH);
        } else if (position.equals(GUIPrefs.BUTTONS_POSITION_LEFT)) {
            toolbar.setOrientation(JToolBar.VERTICAL);
            add(getToolBar(), BorderLayout.WEST);
        } else if (position.equals(GUIPrefs.BUTTONS_POSITION_RIGHT)) {
            toolbar.setOrientation(JToolBar.VERTICAL);
            add(getToolBar(), BorderLayout.EAST);
        }
        
        panel = new ContextsPanel(this);
        panel.setPreferences(panelPrefs);
        
        add(panel, BorderLayout.CENTER);
    }
    
    protected void componentClosed() {
        panelPrefs = panel.getPreferences();
        
        super.componentClosed();
    }
    
    private synchronized InstanceContent getInstanceContent() {
        if (content == null) {
            content = new InstanceContent();
        }
        return content;
    }
    
    public Lookup getLookup() {
        if (lookup == null) {
            lookup = new AbstractLookup(getInstanceContent());
        }
        return lookup;
    }
    
    public void provide(final Collection<ContextNode> contextNodes) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                if (panel == null || contextNodes == null) {
                    getInstanceContent().set(Collections.EMPTY_LIST, null);
                } else {
                    getInstanceContent().set(contextNodes, null);
                }
            }
        });
    }
    
    public HelpCtx getHelpCtx() {
        return new HelpCtx("tr.view.contexts");
    }
    
    public String preferredID() {
        return PREFERRED_ID;
    }
    
    /** replaces this in object stream */
    public Object writeReplace() {
        return new ResolvableHelper(panel.getPreferences());
    }
    
    final static class ResolvableHelper implements Serializable {
        private static final long serialVersionUID = 1L;
        
        private final ContextsPanel.Preferences prefs;
        
        public ResolvableHelper(ContextsPanel.Preferences prefs) {
            this.prefs = prefs;
        }
        
        public Object readResolve() {
            ContextsTopComponent result = ContextsTopComponent.getDefault();
            result.panelPrefs = prefs;
            return result;
        }
    }
    
}
