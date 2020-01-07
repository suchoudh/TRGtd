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
import java.awt.EventQueue;
import java.io.File;
import java.util.logging.Logger;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import org.openide.util.HelpCtx;
import org.openide.util.Lookup;
import org.openide.util.LookupEvent;
import org.openide.util.LookupListener;
import org.openide.util.NbBundle;
import org.openide.util.actions.CallableSystemAction;
import org.openide.windows.WindowManager;
import tr.datastore.DataStore;
import tr.datastore.DataStoreLookup;
import tr.datastore.xstream.XStreamDataStore;
import tr.model.Data;
import tr.model.DataLookup;
import tr.util.Utils;
import tr.util.UtilsFile;

/**
 * Backup action.
 *
 * @author Jeremy Moore (jimoore@netspace.net.au)
 */
public final class SaveToAction extends CallableSystemAction {
    
    /** Constructs a new instance. */
    public SaveToAction() {
        super();
        enableDisable();
        Lookup.Result r = DataLookup.instance().lookup(new Lookup.Template(Data.class));
        r.addLookupListener(new LookupListener() {
            public void resultChanged(LookupEvent lookupEvent) {
                enableDisable();
            }
        });
    }
    
    @Override
    protected String iconResource() {
        return Resource.DataSaveTo;
    }

    private void enableDisable() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                Data data = (Data)DataLookup.instance().lookup(Data.class);
                setEnabled(data != null);
            }
        });
    }
    
    /** Save the current datastore to another file. */
    public void performAction() {
        DataStore ds = (DataStore)DataStoreLookup.instance().lookup(DataStore.class);
        if (ds == null) return;
        
        saveData(ds);
        
        JFileChooser chooser = new JFileChooser();
        String[] extns = XStreamDataStore.FILE_EXTENSIONS;
        FileFilter filter = new FileFilterImpl(NbBundle.getMessage(SaveToAction.class, "tr.xstream.datafiles"), extns, true);
        chooser.setFileFilter(filter);
        
//      chooser.setSelectedFile(new File(ds.getPath()));
        String lastPath = getSaveToPath();
        lastPath = lastPath.equals(DEF_SAVE_TO_PATH) ? ds.getPath() : lastPath;
        chooser.setSelectedFile(new File(lastPath));
        
        Component p = WindowManager.getDefault().getMainWindow();
        
        int returnVal = chooser.showDialog(p, NbBundle.getMessage(SaveToAction.class, "save.to"));
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            String pathTo = chooser.getSelectedFile().getPath();
            String extn = UtilsFile.getExtension(pathTo);
            if (!Utils.in(extn, extns) ) {
                pathTo = UtilsFile.setExtension(pathTo, "trx");
            }
            File file = new File(pathTo);
            if (file.exists()) {
                String t = NbBundle.getMessage(SaveToAction.class, "save.to");
                String m = NbBundle.getMessage(SaveToAction.class, "confirm.replace.file");
                int r = JOptionPane.showConfirmDialog(p, m, t, JOptionPane.YES_NO_OPTION);
                if (r != JOptionPane.YES_OPTION) return;
            }
            
            LOG.info("Backup to: " + pathTo);
            
            String path = ds.getPath();
            
            ds.setPath(pathTo);
            ds.setChanged(true);
            saveData(ds);
            
            setSaveToPath(pathTo);
            
            ds.setPath(path);
        }
    }
    
    private void saveData(DataStore ds) {
        try {
            ds.store();
        } catch (Exception ex) {
            ex.printStackTrace(System.err);
        }
    }
    
    public String getName() {
        return NbBundle.getMessage(SaveToAction.class, "CTL_SaveToAction");
    }
    
    public HelpCtx getHelpCtx() {
        return HelpCtx.DEFAULT_HELP;
    }
    
    @Override
    protected boolean asynchronous() {
        return false;
    }
    
    /**
     * Gets the value for the default file path.
     * @return The value.
     */
    public static final String getSaveToPath() {
        return prefs.get(KEY_SAVE_TO_PATH, DEF_SAVE_TO_PATH);
    }
    
    /**
     * Sets the value for the default file path.
     * @param value The value.
     */
    public static final void setSaveToPath(String value) {
        prefs.put(KEY_SAVE_TO_PATH, value);
        flush();
    }
    
    private static void flush() {
        try {
            prefs.flush();
        } catch (BackingStoreException ex) {
            LOG.severe("Backup preferences error. " + ex.getMessage());
        }
    }
    
    private static final Logger LOG = Logger.getLogger("tr.data");
    // User preferences node.
    private static final Preferences prefs = Preferences.userRoot().node(Constants.PREFS_PATH + "/file");
    // Default file path key.
    private static final String KEY_SAVE_TO_PATH = "saveto.path";
    // Default file path default.
    private static final String DEF_SAVE_TO_PATH = "";
    
}
