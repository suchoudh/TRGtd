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
import java.awt.BorderLayout;
import java.util.Collection;
import java.util.logging.Logger;
import org.openide.util.HelpCtx;
import org.openide.util.Lookup;
import org.openide.util.LookupEvent;
import org.openide.util.LookupListener;
import org.openide.util.NbBundle;
import org.openide.windows.TopComponent;
import tr.view.Window;

/**
 * Top component for future item.
 *
 * @author <a href="mailto:jimoore@netspace.net.au">Jeremy Moore</a>
 */
public final class FutureTopComponent extends Window implements LookupListener {
    
    private static final Logger LOG = Logger.getLogger("tr.view.future");
    
    private static final String PREFERRED_ID = "FutureTopComponent";
    
    private static FutureTopComponent instance;
    
    private FuturePanel panel;
    private Lookup.Result result;
    
    private FutureTopComponent() {
        setName(NbBundle.getMessage(FutureTopComponent.class, "CTL_FutureTopComponent"));
        setToolTipText(NbBundle.getMessage(FutureTopComponent.class, "TTT_FutureTopComponent"));
        setIcon(Icons.SomedayMaybe.getImage());            
        initComponents();
    }
    
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(new java.awt.BorderLayout());

    }// </editor-fold>//GEN-END:initComponents
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    
    @Override
    protected void componentOpened() {
        super.componentOpened();
        
        if (panel == null) {
            removeAll();
            panel = new FuturePanel();
            add(panel, BorderLayout.CENTER);
        }
        
        panel.initModel(null);
        
        FuturesTopComponent rtc = FuturesTopComponent.findInstance();
        
        result = rtc.getLookup().lookup(new Lookup.Template(FutureNode.class));
        result.addLookupListener(this);
        result.allInstances();
    }
    
    protected void componentClosed() {
        super.componentClosed();
        result.removeLookupListener(this);
        result = null;
    }
    
    protected void componentDeactivated() {
        panel.deactivate();
        super.componentDeactivated();
    }
    
    public synchronized void resultChanged(LookupEvent lookupEvent) {
        LOG.info("Starting");
        
        if (panel == null) return;
        
        Collection collection = result.allInstances();
        if (collection.isEmpty()) {
            panel.initModel(null);
            
            LOG.info("null");
        } else {
            FutureNode node = (FutureNode)collection.iterator().next();
            panel.initModel(node.future);
            
            LOG.info("initialising model");
        }
    }
    
    /** Start editing if possible. */
    public void edit() {
        if (panel == null) return;
        
        requestActive();
        
        panel.edit();
    }
    
    /**
     * Gets default instance. Do not use directly: reserved for *.settings files only,
     * i.e. deserialization routines; otherwise you could get a non-deserialized instance.
     * To obtain the singleton instance, use {@link findInstance}.
     */
    public static synchronized FutureTopComponent getDefault() {
        if (instance == null) {
            instance = new FutureTopComponent();
        }
        return instance;
    }
    
    /**
     * Obtain the FutureTopComponent instance. Never call {@link #getDefault} directly!
     */
    public static synchronized FutureTopComponent findInstance() {
//        TopComponent win = WindowManager.getDefault().findTopComponent(PREFERRED_ID);
//        if (win == null) {
//            ErrorManager.getDefault().log(ErrorManager.WARNING, "Cannot find Future component. It will not be located properly in the window system.");
//            return getDefault();
//        }
//        if (win instanceof FutureTopComponent) {
//            return (FutureTopComponent)win;
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
    protected String preferredID() {
        return PREFERRED_ID;
    }
    
    @Override
    public HelpCtx getHelpCtx() {
        return new HelpCtx("tr.view.future");
    }
    
//    /** replaces this in object stream */
//    public Object writeReplace() {
//        return new ResolvableHelper();
//    }
//
//    final static class ResolvableHelper implements Serializable {
//        private static final long serialVersionUID = 1L;
//        public Object readResolve() {
//            return FutureTopComponent.getDefault();
//        }
//    }
    
}
