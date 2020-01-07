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

package tr.prefs.gui;

import au.com.trgtd.tr.appl.Constants;
import java.awt.BorderLayout;
import java.util.logging.Logger;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;
import javax.swing.JToolBar;

/**
 * User preferences for the GUI.
 *
 * @author Jeremy Moore (jimoore@netspace.net.au)
 */
public class GUIPrefs {
    
    private static final Logger LOG = Logger.getLogger("tr.prefs.gui");
    
    private static final Preferences prefs = Preferences.userRoot().node(Constants.PREFS_PATH + "/gui");
    
    /** No initial action. */
    public static final String INITIAL_ACTION_ID_NONE = "none";
    /* Initial action preference key. */
    private static final String KEY_INITIAL_ACTION_ID = "initial.action.id";
    /* Initial action preference default. */
    private static final String DEF_INITIAL_ACTION_ID = "overview";
    
    /** Position buttons at the top of windows. */
    public static final String BUTTONS_POSITION_TOP = "top";
    /** Position buttons at the botton of windows. */
    public static final String BUTTONS_POSITION_BOTTOM = "bottom";
    /** Position buttons at the left of windows. */
    public static final String BUTTONS_POSITION_LEFT = "left";
    /** Position buttons at the right of windows. */
    public static final String BUTTONS_POSITION_RIGHT = "right";
    /* Buttions position preference key. */
    private static final String KEY_BUTTONS_POSITION = "buttons.position";
    /* Buttions position preference default. */
    private static final String DEF_BUTTONS_POSITION = BUTTONS_POSITION_TOP;
    
    /**
     * Gets the value for the initial action identifier preference.
     * @return The value.
     */
    public static final String getInitialActionID() {
        return prefs.get(KEY_INITIAL_ACTION_ID, DEF_INITIAL_ACTION_ID);
    }
    
    /**
     * Sets the value for the initial action identifier preference.
     * @param value The value.
     */
    public static final void setInitialWindowID(String value) {
        prefs.put(KEY_INITIAL_ACTION_ID, value);
        flush();
    }
    
    /**
     * Gets the value for the buttons position preference.
     * @return The value.
     */
    public static final String getButtonsPosition() {
        return prefs.get(KEY_BUTTONS_POSITION, DEF_BUTTONS_POSITION);
    }
    
    /**
     * Gets the BorderLayout value for the buttons position preference.
     * @return The BorderLayout position value.
     */
    public static final String getBorderLayoutButtonsPosition() {
        String bp = getButtonsPosition();
        if (bp.equals(BUTTONS_POSITION_TOP)) return BorderLayout.NORTH;
        if (bp.equals(BUTTONS_POSITION_BOTTOM)) return BorderLayout.SOUTH;
        if (bp.equals(BUTTONS_POSITION_LEFT)) return BorderLayout.WEST;
        if (bp.equals(BUTTONS_POSITION_RIGHT)) return BorderLayout.EAST;
        return BorderLayout.NORTH;
    }
    
    /**
     * Gets the JToolBar orientation for the buttons position preference.
     * @return The JToolBar orientation value.
     */
    public static final int getToolBarOrientation() {
        String bp = getButtonsPosition();
        if (bp.equals(BUTTONS_POSITION_TOP)) return JToolBar.HORIZONTAL;
        if (bp.equals(BUTTONS_POSITION_BOTTOM)) return JToolBar.HORIZONTAL;
        if (bp.equals(BUTTONS_POSITION_LEFT)) return JToolBar.VERTICAL;
        if (bp.equals(BUTTONS_POSITION_RIGHT)) return JToolBar.VERTICAL;
        return JToolBar.HORIZONTAL;
    }
    
    /**
     * Sets the value for the buttons position preference.
     * @param value The value.
     */
    public static final void setButtonsPosition(String value) {
        prefs.put(KEY_BUTTONS_POSITION, value);
        flush();
    }
    
    private static void flush() {
        try {
            prefs.flush();
        } catch (BackingStoreException ex) {
            LOG.severe("GUI preferences error. " + ex.getMessage());
        }
    }
    
}
