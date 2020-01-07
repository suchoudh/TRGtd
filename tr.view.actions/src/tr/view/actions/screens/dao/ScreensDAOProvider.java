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

import java.util.logging.Logger;
import tr.data.DAOProvider;
import tr.data.DAOProviderLookup;
import tr.view.actions.screens.ActionsScreens;

/**
 * Actions screens DAO provider.
 *
 * @author Jeremy Moore (jimoore@netspace.net.au)
 */
public class ScreensDAOProvider implements DAOProvider<ScreensDAO> {

    private static final Logger LOG = Logger.getLogger("tr.view.actions");
    private static final ScreensDAOProvider instance = new ScreensDAOProvider();
    private ScreensDAO screensDAO;

    /**
     * Gets the singleton instance.
     * @return the instance.
     */
    public static final ScreensDAOProvider instance() {
        return instance;
    }

    /* Private singleton constructor. */
    private ScreensDAOProvider() {
        DAOProviderLookup.instance().setDAOProvider(this);
    }

    /**
     * Provide the actions screens DAO.
     * @return the actions screens DAO.
     */
    public ScreensDAO provide() {
        if (screensDAO == null) {
            screensDAO = initialiseScreensDAO();
        }
        return screensDAO;
    }

    private ScreensDAO initialiseScreensDAO() {
        LOG.info("initialiseScreensDAO()");

        ScreensDAO dao = ScreensDAOJAXB.getInstance();

        // use JAXB action screens data if it exists
        if (dao.hasPersistantData()) {
            try {
                dao.restore();                
                return dao;
            } catch (Exception ex) {
                LOG.severe("Failed to restore review actions settings. " + ex.getMessage());                
            }
        }

        // No JAXB screens meta-data so try to get it from properties.
        ScreensDAO screensDAOProps = ScreensDAOProperties.getInstance();
        if (screensDAOProps.hasPersistantData()) {
            try {
                dao.getData().setScreens(screensDAOProps.getData().getScreens());
                return dao;
            } catch (Exception ex) {
                LOG.severe("Failed to get review actions settings. " + ex.getMessage());
            }
        }

        // No JAXB or properties screens meta-data so create default screens meta-data.
        dao.getData().setScreens(ActionsScreens.createDefaultScreens());
        return dao;
    }

    public boolean isInitialised() {
        return screensDAO != null;
    }

    public void reset() {
        screensDAO = null;
    }
}
