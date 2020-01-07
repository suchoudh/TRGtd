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
package tr.data;

import au.com.thinkingrock.tr.resource.Resource;
import au.com.trgtd.tr.appl.Constants;
import java.awt.Component;
import java.io.File;
import java.util.logging.Logger;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;

import org.openide.util.HelpCtx;
import org.openide.util.NbBundle;
import org.openide.util.actions.CallableSystemAction;
import org.openide.windows.WindowManager;

import tr.datastore.DataStore;
import tr.datastore.DataStoreLookup;
import tr.datastore.xstream.XStreamDataStore;
import tr.model.Data;
import tr.util.Utils;
import tr.util.UtilsFile;
import tr.view.WindowUtils;

/**
 * Action to create a new data file.
 *
 * @author Jeremy Moore
 */
public final class NewAction extends CallableSystemAction {

    private static final Logger LOG = Logger.getLogger("tr.data"); // No I18N

    public NewAction() {
    }
    
    @Override
    protected String iconResource() {
        return Resource.DataNew;
    }    

    /** Perform the action to show a file dialog and create a data file. */
    public void performAction() {

        DataStore ds = (DataStore) DataStoreLookup.instance().lookup(DataStore.class);
        if (ds == null) {
            LOG.severe("Datastore was not found."); // No I18N
            return;
        }
        
        JFileChooser chooser = new JFileChooser();
        String[] extns = XStreamDataStore.FILE_EXTENSIONS;
        FileFilter filter = new FileFilterImpl(NbBundle.getMessage(NewAction.class, "tr.xstream.datafiles"), extns, true);
        chooser.setFileFilter(filter);

        File defaultFile = new File(ds.getPath());
        if (defaultFile.exists()) {
            chooser.setSelectedFile(defaultFile);
        }

        Component p = WindowManager.getDefault().getMainWindow();
        int returnVal = chooser.showDialog(p, NbBundle.getMessage(NewAction.class, "new.file"));
        if (returnVal != JFileChooser.APPROVE_OPTION) {
            return;
        }
        
        // close windows here so that window settings are saved. 
        WindowUtils.closeWindows();

        // save current data
        try {
            ds.store();
        } catch (Exception ex) {
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
        
        // create new data
        String path = chooser.getSelectedFile().getPath();
        String extn = UtilsFile.getExtension(path);
        if (!Utils.in(extn, extns)) {
            path = UtilsFile.setExtension(path, "trx");
        }
        File newfile = new File(path);
        if (newfile.exists()) {
            String t = org.openide.util.NbBundle.getMessage(NewAction.class, "new.file");
            String m = org.openide.util.NbBundle.getMessage(NewAction.class, "confirm.replace.file");
            int r = JOptionPane.showConfirmDialog(p, m, t, JOptionPane.YES_NO_OPTION);
            if (r == JOptionPane.YES_OPTION) {
                newfile.delete();
            } else {
                return;
            }
        }
        LOG.info("New file: " + path);
        try {
            newfile.createNewFile();
            ds.setPath(path);
            ds.setData(new Data());
            ds.setChanged(true);
            ds.store();
            WindowManager.getDefault().getMainWindow().setTitle(Constants.TITLE + " " + path);
            WindowUtils.closeWindows();
            WindowUtils.openInitialWindow();
        } catch (Exception ex) {
            String t = org.openide.util.NbBundle.getMessage(NewAction.class, "new.file.error.title");
            String m = org.openide.util.NbBundle.getMessage(NewAction.class, "new.file.error.message") + "\n" + ex.getMessage();
            JOptionPane.showMessageDialog(p, m, t, JOptionPane.ERROR_MESSAGE);
        }
    }

    public String getName() {
        return NbBundle.getMessage(NewAction.class, "CTL_NewAction");
    }

    public HelpCtx getHelpCtx() {
        return HelpCtx.DEFAULT_HELP;
    }

    @Override
    protected boolean asynchronous() {
        return false;
    }
}
