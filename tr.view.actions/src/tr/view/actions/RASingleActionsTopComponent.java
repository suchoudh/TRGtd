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

package tr.view.actions;

import tr.view.projects.actions.SingleActionsTopComponent;

/**
 * Top component for the review actions, single actions tree.
 */
public final class RASingleActionsTopComponent extends SingleActionsTopComponent {
    
    private static final String PREFERRED_ID = "RASingleActionsTopComponent";
    
    private static SingleActionsTopComponent instance;
    
    private RASingleActionsTopComponent() {
        super();
    }
    
    /**
     * Gets default instance. Do not use directly: reserved for *.settings files only,
     * i.e. deserialization routines; otherwise you could get a non-deserialized instance.
     * To obtain the singleton instance, use {@link findInstance}.
     */
    public static synchronized SingleActionsTopComponent getDefault() {
        if (instance == null) {
            instance = new RASingleActionsTopComponent();
        }
        return instance;
    }
    
    /**
     * Obtain the SingleActionsTopComponent instance. Never call {@link #getDefault} directly!
     */
    public static synchronized SingleActionsTopComponent findInstance() {
//        TopComponent tc = WindowManager.getDefault().findTopComponent(PREFERRED_ID);
//        if (tc == null) {
//            ErrorManager.getDefault().log(ErrorManager.WARNING, "Cannot find review actions single actions component. It will not be located properly in the window system.");
//            return getDefault();
//        }
//        if (tc instanceof RASingleActionsTopComponent) {
//            return (RASingleActionsTopComponent)tc;
//        }
//        ErrorManager.getDefault().log(ErrorManager.WARNING, "There seem to be multiple components with the '" + PREFERRED_ID + "' ID. That is a potential source of errors and unexpected behavior.");
        return getDefault();
    }
    
    @Override
    protected String preferredID() {
        return PREFERRED_ID;
    }
    
//    final static class ResolvableHelper implements Serializable {
//        private static final long serialVersionUID = 1L;
//        public Object readResolve() {
//            return RASingleActionsTopComponent.getDefault();
//        }
//    }
    
}
