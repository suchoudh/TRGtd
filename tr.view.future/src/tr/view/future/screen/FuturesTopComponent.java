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

package tr.view.future.screen;

import au.com.thinkingrock.tr.resource.Icons;
import au.com.trgtd.tr.appl.Constants;
import ca.odell.glazedlists.matchers.MatcherEditor;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import org.openide.awt.Toolbar;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.prefs.Preferences;
import javax.swing.AbstractAction;
import javax.swing.AbstractButton;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import org.openide.ErrorManager;
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
import tr.view.future.FutureDeleteAction;
import tr.view.future.FutureEditAction;
import tr.view.future.FutureReprocessAction;

/**
 * Top component for the someday/maybe items table.
 *
 * @author <a href="mailto:jimoore@netspace.net.au">Jeremy Moore</a>
 */
public final class FuturesTopComponent extends Window implements FutureNodeProvider {
    
    public static final String PREFERRED_ID = "FuturesTopComponent";
    
    private static final long serialVersionUID = 1L;
    
    private static final Preferences prefs = Preferences.userRoot().node(Constants.PREFS_PATH + "/sdmb");
    private static final String PREFS_KEY_SHOW_FILTERS = "show.filters";
    private static final boolean PREFS_DEF_SHOW_FILTERS = true;
    
    private static FuturesTopComponent instance;
    
    private FuturesPanel.Preferences panelPrefs;
    
    private transient FuturesFilters filters;
    private transient FuturesPanel panel;
    private transient InstanceContent content;
    private transient Lookup lookup;
    private transient JToolBar toolbar;
    private transient JPanel bodyPanel;
    private transient JToggleButton filtersButton;
    
    /* Singleton instance. */
    private FuturesTopComponent() {
        initComponents();
        setName(NbBundle.getMessage(FuturesTopComponent.class, "CTL_FuturesTopComponent"));
        setToolTipText(NbBundle.getMessage(FuturesTopComponent.class, "TTT_FuturesTopComponent"));
        setIcon(Icons.SomedayMaybes.getImage());                    
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
    public static synchronized FuturesTopComponent getDefault() {
        if (instance == null) {
            instance = new FuturesTopComponent();
        }
        return instance;
    }
    
    /**
     * Obtain the CollectTopComponent instance. Never call {@link #getDefault}
     * directly!
     */
    public static synchronized FuturesTopComponent findInstance() {
        TopComponent win = WindowManager.getDefault().findTopComponent(PREFERRED_ID);
        if (win == null) {
            ErrorManager.getDefault().log(ErrorManager.WARNING, "Cannot find futures component. It will not be located properly in the window system.");
            return getDefault();
        }
        if (win instanceof FuturesTopComponent) {
            return (FuturesTopComponent)win;
        }
        ErrorManager.getDefault().log(ErrorManager.WARNING, "There seem to be multiple components with the '" + PREFERRED_ID + "' ID. That is a potential source of errors and unexpected behavior.");
        return getDefault();
    }
    
    @Override
    public int getPersistenceType() {
        return TopComponent.PERSISTENCE_ALWAYS;
    }
    
    private JToolBar getToolBar() {
        if (toolbar == null) {
            SystemAction[] actions = new SystemAction[] {
//              null,
                SystemAction.get(FutureEditAction.class),
//              null,
                SystemAction.get(FutureDeleteAction.class),
                SystemAction.get(FutureReprocessAction.class)
            };
            toolbar = SystemAction.createToolbarPresenter(actions);
            filtersButton = new JToggleButton(new FiltersAction());
            toolbar.add(filtersButton, 0);
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
    
    private class FiltersAction extends AbstractAction {
        public FiltersAction() {
            super("", Icons.FiltersView);
            putValue(SHORT_DESCRIPTION, NbBundle.getMessage(getClass(), "CTL_FiltersAction"));
        }
        public void actionPerformed(ActionEvent e) {
            if (filtersButton.isSelected()) {
                bodyPanel.add(getFilters().getComponent(), BorderLayout.NORTH);
            } else {
                bodyPanel.remove(getFilters().getComponent());
            }
            validate();
        }
    }
    
    private FuturesFilters getFilters() {
        if (filters == null) {
            filters = new FuturesFilters();
        }
        return filters;
    }
    
    private MatcherEditor getMatcherEditor() {
        return getFilters().getMatcherEditor();
    }
    
    @Override
    protected void componentOpened() {
        super.componentOpened();
        
        provide(null);
        
        removeAll();
        
        getToolBar();
        filtersButton.setSelected(false);
        String position = GUIPrefs.getButtonsPosition();
        if (position.equals(GUIPrefs.BUTTONS_POSITION_TOP)) {
            toolbar.setOrientation(JToolBar.HORIZONTAL);
            add(toolbar, BorderLayout.NORTH);
        } else if (position.equals(GUIPrefs.BUTTONS_POSITION_BOTTOM)) {
            toolbar.setOrientation(JToolBar.HORIZONTAL);
            add(toolbar, BorderLayout.SOUTH);
        } else if (position.equals(GUIPrefs.BUTTONS_POSITION_LEFT)) {
            toolbar.setOrientation(JToolBar.VERTICAL);
            add(toolbar, BorderLayout.WEST);
        } else if (position.equals(GUIPrefs.BUTTONS_POSITION_RIGHT)) {
            toolbar.setOrientation(JToolBar.VERTICAL);
            add(toolbar, BorderLayout.EAST);
        }
        
        panel = new FuturesPanel(this, getMatcherEditor());
        panel.setPreferences(panelPrefs);
        
        bodyPanel = new JPanel(new BorderLayout());
        bodyPanel.add(panel, BorderLayout.CENTER);
        
        add(bodyPanel, BorderLayout.CENTER);
        
        // restore showFilters from preference
        boolean b = prefs.getBoolean(PREFS_KEY_SHOW_FILTERS, PREFS_DEF_SHOW_FILTERS);
        filtersButton.setSelected(b);
        filtersButton.getAction().actionPerformed(null);
    }
    
    @Override
    protected void componentClosed() {
        panelPrefs = panel.getPreferences();
        
        // save show filters as a preference
        prefs.putBoolean(PREFS_KEY_SHOW_FILTERS, filtersButton.isSelected());
        
        super.componentClosed();
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
    
    public void provide(final Collection<FutureNode> nodes) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                if (panel == null || nodes == null) {
                    getInstanceContent().set(Collections.EMPTY_LIST, null);
                } else {
                    getInstanceContent().set(nodes, null);
                }
            }
        });
    }
    
    @Override
    public HelpCtx getHelpCtx() {
        return new HelpCtx("tr.view.future");
    }
    
    @Override
    public String preferredID() {
        return PREFERRED_ID;
    }
    
    /** replaces this in object stream */
    @Override
    public Object writeReplace() {
        return new ResolvableHelper(panel.getPreferences(), filters.getSerializable());
    }
    
    final static class ResolvableHelper implements Serializable {
        private static final long serialVersionUID = 1L;
        
        private final FuturesPanel.Preferences prefs;
        private final Serializable rmes;
        
        public ResolvableHelper(FuturesPanel.Preferences prefs, Serializable rmes) {
            this.prefs = prefs;
            this.rmes = rmes;
        }
        
        public Object readResolve() {
            FuturesTopComponent result = FuturesTopComponent.getDefault();
            result.panelPrefs = prefs;
            result.filters = new FuturesFilters();
            result.filters.setSerializable(rmes);
            return result;
        }
    }
    
}
