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
package tr.view.actions.screens.dao;

import au.com.trgtd.tr.appl.Constants;
import java.util.Vector;
import java.util.logging.Logger;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;
import tr.view.actions.screens.*;
import tr.view.actions.screens.columns.ActionsColumn;
import tr.view.actions.screens.filters.ActionsFilter;

/**
 * Actions screens.
 *
 * @author Jeremy Moore (jimoore@netspace.net.au)
 */
final class ScreensDAOProperties implements ScreensDAO {

    private static final Logger LOG = Logger.getLogger("tr.view.actions");
    private static final Preferences trPrefs = Preferences.userRoot().node(Constants.PREFS_PATH);
    private static final String PREFS_PATH_SCREENS = "actions/screens";
    private static ScreensDAO instance;
    private ActionsScreens actionsScreens;

    /** Gets the singleton instance. */
    public static ScreensDAO getInstance() {
        if (instance == null) {
            instance = new ScreensDAOProperties();
        }
        return instance;
    }

    /* Singleton private constructor. */
    private ScreensDAOProperties() {
    }

    public ActionsScreens getData() {
        if (actionsScreens != null) {
            return actionsScreens;
        }
        if (hasPersistantData()) {
            try {
                restore();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        if (actionsScreens == null) {
            actionsScreens = new ActionsScreens();
        }
        return actionsScreens;
    }

    public boolean hasPersistantData() {
        try {
            return trPrefs.nodeExists(PREFS_PATH_SCREENS);
        } catch (Exception ex) {
            return false;
        }
    }

    public void delete() {
        try {
            trPrefs.remove(PREFS_PATH_SCREENS);
            trPrefs.flush();
        } catch (BackingStoreException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Saves data to persistant storage.
     * @deprecated
     */
    public void persist() throws Exception {
    }

    /**
     * Restores data from persistant storage if possible.
     */
    public void restore() throws Exception {
        if (hasPersistantData()) {
            load();
        }
    }

    /**
     * Load screen definitions from preferences.
     * @deprecated This method is now only used to read old preferences if the
     * new file based settings do not exist.
     */
    private void load() {
        LOG.fine("Attempting to load actions screens from preferences.");

        actionsScreens = new ActionsScreens();

        if (!hasPersistantData()) {
            return;
        }

        try {
            Preferences prefs = trPrefs.node(PREFS_PATH_SCREENS);

            int i = 0;

            while (prefs.nodeExists("screen" + i)) {
                Preferences prefsScreen = prefs.node("screen" + i++);
                ActionsScreen screen = ActionsScreen.create(prefsScreen.get("key", ""));
                screen.setColumnOrder(prefsScreen.getByteArray("order", null));
                screen.setSortColumns(prefsScreen.getByteArray("sortfields", null));
                screen.setSortStatus(prefsScreen.getByteArray("sortstatus", null));

                int j = -1;
                while (prefsScreen.nodeExists("field" + ++j)) {
                    Preferences prefsField = prefsScreen.node("field" + j);
                    ActionsColumn field = screen.getColumns().get(j);
                    field.setVisible(prefsField.getBoolean("visible", field.isVisible()));
                    field.setWidth(prefsField.getInt("width", field.getWidth()));
                }

                int k = -1;
                while (prefsScreen.nodeExists("filter" + ++k)) {
                    Preferences prefsFilter = prefsScreen.node("filter" + k);
                    ActionsFilter filter = screen.getFilters().get(k);
                    filter.setUsed(prefsFilter.getBoolean("used", false));
                    filter.setShown(prefsFilter.getBoolean("visible", false));
                    Preferences prefsValues = prefsFilter.node("values");
                    Vector<String> values = new Vector<String>();
                    for (int n = 0; n < Integer.MAX_VALUE; n++) {
                        String value = prefsValues.get("value" + n, "%%%NONE%%%");
                        if ("%%%NONE%%%".equals(value)) {
                            break;
                        }
                        values.add(value);
                    }
                    filter.setSerialValues(values.toArray(new String[]{}));
                }

                screen.setShowFilters(prefsScreen.getBoolean("showFilters", true));

                actionsScreens.getScreens().add(screen);
            }
        } catch (BackingStoreException ex) {
            LOG.severe("Backing Store Exception");
        }
    }

    public void reset() {
        // nothing to do
    }
}

