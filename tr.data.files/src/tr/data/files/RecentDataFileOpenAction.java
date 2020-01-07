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
package tr.data.files;

import au.com.trgtd.tr.appl.Constants;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import org.openide.util.HelpCtx;
import org.openide.windows.WindowManager;
import tr.background.activation.ActivatorTaskScheduler;
import tr.background.recurrence.RecurrenceTaskScheduler;
import tr.data.DAOProvider;
import tr.data.DAOProviderLookup;
import tr.datastore.DataStore;
import tr.datastore.DataStoreLookup;
import tr.view.WindowUtils;

/**
 * Action to open a recent data file.
 *
 * @author Jeremy Moore (jimoore@netspace.net.au)
 */
public final class RecentDataFileOpenAction extends AbstractAction {

    private static final Logger LOG = Logger.getLogger("tr.data.files");
    private final String path;

    /**
     * Constructs a new instance for the given data file path.
     * @param path The data file path.
     */
    public RecentDataFileOpenAction(String path) {
        super(path);
        this.path = path;
    }

    /**
     * Perform the action to open the recent data file.
     */
    public void actionPerformed(ActionEvent actionEvent) {

        DataStore ds = (DataStore) DataStoreLookup.instance().lookup(DataStore.class);
        if (ds == null) {
            LOG.severe("Datastore was not found.");
            return;
        }

        File datafile = new File(path);
        if (!datafile.exists()) {
            String t = org.openide.util.NbBundle.getMessage(RecentDataFileOpenAction.class, "datafile.not.found.title");
            String m = org.openide.util.NbBundle.getMessage(RecentDataFileOpenAction.class, "datafile.not.found.message") + "\n\n";
            Component p = WindowManager.getDefault().getMainWindow();
            JOptionPane.showMessageDialog(p, m, t, JOptionPane.ERROR_MESSAGE);
            return;
        }

        // close windows here so that window settings are saved. 
        WindowUtils.closeWindows();

        // save current data
        try {
            ds.store();
        } catch (Exception ex) {
            LOG.severe("Datastore store exception: " + ex.getMessage());
        }

        // save review actions screens and force reload
        DAOProvider screensDAOProvider = (DAOProvider)DAOProviderLookup.instance().lookup(DAOProvider.class);
        if (screensDAOProvider != null) {
            try {
                LOG.info("Saving actions screens.");                
                if (screensDAOProvider.isInitialised()) {
                    screensDAOProvider.provide().persist();
                    screensDAOProvider.provide().reset();
                    screensDAOProvider.reset();
                }
            } catch (Exception ex) {
                LOG.severe("Review Actions screens could not be saved. " + ex.getMessage());                
            }
        }        

        // open new data
        try {
            ds.setPath(path);
            ds.load();
            WindowManager.getDefault().getMainWindow().setTitle(Constants.TITLE + " " + path);
            WindowUtils.closeWindows();
            WindowUtils.openInitialWindow();
            ActivatorTaskScheduler.instance().runTask(0, 1, 0);
            RecurrenceTaskScheduler.instance().runTask(0, 2, 0);
        } catch (Exception ex) {
            String e = ex.getMessage();
            String t = org.openide.util.NbBundle.getMessage(RecentDataFileOpenAction.class, "file.open.error.title");
            String m = org.openide.util.NbBundle.getMessage(RecentDataFileOpenAction.class, "file.open.error.message") + " " + path + "\n\n" + ((e == null) ? "" : e);
            Component p = WindowManager.getDefault().getMainWindow();
            JOptionPane.showMessageDialog(p, m, t, JOptionPane.ERROR_MESSAGE);
        }
    }

    public HelpCtx getHelpCtx() {
        return HelpCtx.DEFAULT_HELP;
    }

    protected boolean asynchronous() {
        return false;
    }
}
