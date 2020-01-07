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

import au.com.thinkingrock.xsd.tr.view.actions.screens.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.List;
import java.util.Vector;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import org.apache.commons.lang.StringEscapeUtils;
import tr.datastore.DataStore;
import tr.datastore.DataStoreLookup;
import tr.util.Utils;
import tr.view.actions.screens.ActionsScreen;
import tr.view.actions.screens.ActionsScreens;
import tr.view.actions.screens.columns.ActionsColumn;
import tr.view.actions.screens.filters.ActionsFilter;
import tr.view.actions.screens.filters.FilterFactory;

/**
 * Actions screens DAO using JAXB.
 *
 * @author Jeremy Moore (jimoore@netspace.net.au)
 */
final class ScreensDAOJAXB implements ScreensDAO {

    private static final Logger LOG = Logger.getLogger("tr.view.actions");
    private static final String FILENAME = "ReviewActions.xml";
    private static final String ENCODING = "UTF-8";
    private static ScreensDAO instance;
    private ActionsScreens actionsScreens = null;

    public static ScreensDAO getInstance() {
        if (instance == null) {
            instance = new ScreensDAOJAXB();
        }
        return instance;
    }

    /* Singleton private constructor. */
    private ScreensDAOJAXB() {
    }

    public ActionsScreens getData() {
        LOG.info("ScreensDAOJAXB.getData()");        
        
        if (actionsScreens == null) {
            if (hasPersistantData()) {
                try {
                    restore();
                } catch (Exception ex) {
                    LOG.severe("Failed to restore review actions screens. " + ex.getMessage());
                }
            }
            if (actionsScreens == null) {
                actionsScreens = new ActionsScreens();
            }
        }
        
        return actionsScreens;
    }    

    public boolean hasPersistantData() {
        File file = getFile();
        return file != null && file.exists();
    }

    private File getFile() {
        DataStore ds = (DataStore) DataStoreLookup.instance().lookup(DataStore.class);
        if (ds != null) {
            try {
                File parent = (new File(ds.getPath())).getParentFile();
                return new File(parent, FILENAME);
            } catch (Exception ex) {
                LOG.severe("Failed to get file. " + ex.getMessage());
            }
        }
        return null;
    }

    public void persist() throws Exception {
        LOG.info("ScreensDAOJAXB.persist()");
        
        if (actionsScreens == null) {
            // do not persist if screens have not been restored.
            return;
        }
        File file = getFile();
        if (file == null) {
            LOG.severe("File is null.");
            return;
        }
        if (!file.exists()) {
            file.createNewFile();
        }
        if (!file.canWrite()) {
            LOG.severe("Can not write to file: " + file);
            return;
        }
        Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), ENCODING));
        JAXBContext jaxbContext = JAXBContext.newInstance(Screens.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(toXMLScreens(actionsScreens), writer);
        writer.close();
    }

    public void restore() throws Exception {
        File file = getFile();
        if (file == null || !file.exists()) {
            LOG.severe("File does not exist: " + file);
            return;
        }
        
        LOG.info("ScreensDAOJAXB.restore() - Reading file: " + file);        
        
        Reader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), ENCODING));
        JAXBContext jaxbContext = JAXBContext.newInstance(Screens.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        Screens screens = (Screens) unmarshaller.unmarshal(reader);
        reader.close();

        actionsScreens = toActionsScreens(screens);
    }

    private Screens toXMLScreens(ActionsScreens actionScreens) {
        if (actionsScreens == null) {
            return new Screens();
        }
        Screens screens = new Screens();

        for (ActionsScreen as : actionScreens.getScreens().list()) {

            String name = StringEscapeUtils.escapeXml(as.getKey());

            Screen screen = new Screen(name);

            // columns
            for (byte columnIndex : as.getColumnOrder()) {
                ActionsColumn ac = as.getColumns().get(columnIndex);
                if (ac.isVisible()) {
                    Column c = new Column();
                    c.setColumnID(ColumnID.fromValue(ac.getColumnID()));
                    c.setWidth(ac.getWidth());
                    screen.getColumns().getColumns().add(c);
                }
            }

            // sort columns
            byte[] sortColumns = as.getSortColumns();
            byte[] sortStates = as.getSortStates();
            for (int i = 0; i < sortColumns.length; i++) {
                SortColumn sc = new SortColumn();
                sc.setColumnID(ColumnID.fromValue(ActionsColumn.getColumnID(sortColumns[i])));
                sc.setDescending(sortStates[i] == 2);
                screen.getSortColumns().getSortColumns().add(sc);
            }
            // filters
            screen.getFilters().setShow(as.isShowFilters());

            for (ActionsFilter af : as.getFilters()) {
                if (af.isUsed()) {
                    Filter f = new Filter();
                    f.setFilterID(FilterID.fromValue(FilterFactory.getID(af.getIndex())));
                    f.setVisible(af.isShown());
                    f.setExcludeNulls(af.isExcludeNulls());
                    if (af.getSerialValues() != null) {
                        for (String value : af.getSerialValues()) {
                            f.getValues().add(value);
                        }
                    }
                    screen.getFilters().getFilters().add(f);
                }
            }
            screens.getScreens().add(screen);
        }

        return screens;
    }

    private ActionsScreens toActionsScreens(Screens screens) {

        ActionsScreens scrns = new ActionsScreens();

        for (Screen screen : screens.getScreens()) {

            String name = StringEscapeUtils.unescapeXml(screen.getName());

            ActionsScreen actionsScreen = ActionsScreen.create(name);

            // columns
            List<Byte> columnOrderList = new Vector<Byte>();
            Columns columns = screen.getColumns();
            if (columns != null) {
                for (Column column : columns.getColumns()) {
                    byte index = column.getColumnID().index();
                    columnOrderList.add(index);
                    ActionsColumn actionsColumn = actionsScreen.getColumns().get(index);
                    actionsColumn.setVisible(true);
                    actionsColumn.setWidth(column.getWidth());
                }
            }
            actionsScreen.setColumnOrder(Utils.byteArray(columnOrderList));

            // filters
            Filters filters = screen.getFilters();
            if (filters != null) {
                actionsScreen.setShowFilters(filters.isShow());
                for (Filter filter : filters.getFilters()) {
                    byte index = filter.getFilterID().index();
                    ActionsFilter actionsFilter = actionsScreen.getFilters().get(index);
                    actionsFilter.setUsed(true);
                    actionsFilter.setShown(filter.isVisible());
                    actionsFilter.setExcludeNulls(filter.isExcludeNulls());
                    actionsFilter.setSerialValues(filter.getValues().toArray(new String[0]));
                }
            }

            // sort columns
            List<Byte> sortColumnList = new Vector<Byte>();
            List<Byte> sortStatusList = new Vector<Byte>();
            SortColumns sortColumns = screen.getSortColumns();
            if (sortColumns != null) {
                for (SortColumn sortColumn : screen.getSortColumns().getSortColumns()) {
                    sortColumnList.add(sortColumn.getColumnID().index());
                    sortStatusList.add(sortColumn.isDescending() ? (byte) 2 : (byte) 1);
                }
            }
            actionsScreen.setSortColumns(Utils.byteArray(sortColumnList));
            actionsScreen.setSortStatus(Utils.byteArray(sortStatusList));

            scrns.getScreens().add(actionsScreen);
        }

        return scrns;
    }

    public void delete() {
        File file = getFile();
        if (file != null) {
            file.delete();
        }
    }

    public void reset() {
        LOG.info("ScreensDAOJAXB.reset()");
        
        actionsScreens = null;
    }
}
