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
package tr.datastore.xstream;

import au.com.trgtd.tr.appl.Constants;
import au.com.trgtd.tr.calendar.prefs.CalendarPrefs;
import java.awt.Component;
import java.awt.EventQueue;
import java.io.File;
import java.util.logging.Logger;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;
import javax.swing.JOptionPane;
import org.openide.util.NbBundle;
import org.openide.windows.WindowManager;
import tr.model.Data;
import tr.datastore.AbstractDataStore;
import tr.datastore.DataStore;
import tr.prefs.datafile.DataPrefs;
import tr.util.UtilsFile;
import tr.view.WindowUtils;

/**
 * Data manager singleton that uses XStream (http://xstream.codehaus.org/) to
 * persist the data model.
 *
 * @author Jeremy Moore (jeremyimoore@yahoo.com.au)
 */
public final class XStreamDataStore extends AbstractDataStore { 
    // implements FileChangeListener {

    private static final Logger LOG = Logger.getLogger("tr.datastore.xstream");
    /** Data file extensions. */
    public static final String[] FILE_EXTENSIONS = {"xml", "trx"};    // User preferences for the application.
    private static final String PATH = Constants.PREFS_PATH + "/xstream";
    private static final Preferences prefs = Preferences.userRoot().node(PATH);    // User preferences key for the xstream datastore file.
    private static final String KEY_DATAFILE = "data.file";    // User preferences default for the xstream datastore file.
    private static final String DEF_DATAFILE = "";
    private static final long AUTO_SAVE_INTERVAL = 30 * 1000;	// 30 seconds
    private static DataStore instance;
    private Thread autoSaveThread;
    private boolean autoSave;
    private String recoveryPath;    
//  private FileObject fileObject;
//  private boolean externalFileChange;
//  private final FileChangeListener dataFileChangeListener;

    /* Singleton constructor. */
    private XStreamDataStore() {
        super();
//        dataFileChangeListener = new DataFileChangeListener();        
    }

    /**
     * Returns the singleton instance.
     * @return the singleton instance.
     */
    public static DataStore instance() {
        if (instance == null) {
            instance = new XStreamDataStore();
        }
        return instance;
    }

    /**
     * Gets the data file path preference.
     * @return The data file path.
     */
    public String getPath() {
        return prefs.get(KEY_DATAFILE, DEF_DATAFILE);
    }

    /**
     * Sets the data file path preference.
     * @param path The data file path.
     */
    public void setPath(String path) {        
//        stopObservingDataFile();        
        
        if (path == null || path.trim().equals("")) {
            prefs.remove(KEY_DATAFILE);
            return;
        }
        // if the file is in the user directory then just store the file name
        File file = new File(path);
        String userdir = System.getProperty("user.dir");
        if (userdir.equals(file.getParent())) {
            prefs.put(KEY_DATAFILE, file.getName());
            flush();
        } else {
            prefs.put(KEY_DATAFILE, path);
            flush();
        }
                
//        startObservingDataFile();
    }

    /* Gets the data file. */
    private File getDataFile() {
        return new File(getPath());
    }

    private String getRecoveryPath() {
        if (recoveryPath == null) {
            recoveryPath = DataPrefs.getRecoveryPath();
        }
        if (recoveryPath == null || recoveryPath.trim().equals("")) {
            return null;
        }
        return recoveryPath;
    }

    /* Gets the backup file path. */
    private String getBackupFilePath() {

        String path = getPath();

        String recPath = getRecoveryPath();
        if (recPath != null) {
            File recFolder = new File(recPath);
            if (recFolder.isDirectory() && recFolder.canWrite()) {
                String filename = (new File(path)).getName();
                path = (new File(recFolder, filename)).getPath();
            }
        }

        String extn = UtilsFile.getExtension(path);

        return UtilsFile.removeExtension(path) + ".bak." + extn;
    }

    /* Gets the backup file. */
    private File getBackupFile() {
        return new File(getBackupFilePath());
    }

    /* Gets the automatic save thread. */
    private Thread getAutoSaveThread() {
        if (autoSaveThread == null) {
            autoSaveThread = new AutoSaveThread();
            autoSaveThread.setDaemon(true);
        }
        return autoSaveThread;
    }

    /* Starts the automatic saving thread.	*/
    private void startAutoSaving() {
        Thread thread = getAutoSaveThread();
        if (thread.isAlive()) {
            return;
        }
        autoSave = true;
        thread.start();

        LOG.fine("Automatic saving started");
    }

    /* Stops the automatic saving thread. */
    private void stopAutoSaving() {
        autoSave = false;

        Thread thread = getAutoSaveThread();
        while (thread.isAlive()) {
            thread.interrupt();
        }

        LOG.fine("Automatic saving stopped");
    }

    /*
     * Creates a new data file and tests that it is writable.
     * @throws Exception if the file can not be created or is not writable
     */
    private void createDataFile() throws Exception {
        File file = getDataFile();
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Exception ex) {
            }
        }
        if (!file.exists() || !file.canWrite()) {
            throw new Exception("Could not create writable data file: " + getPath());
        }
    }

    /**
     * Atempt to load and set the data model from persistant storage using XStream.
     * Upon completion of this method, either the data will be set or an exception
     * will be thrown.
     * @throws Exception if the data could not be loaded and set in some way.
     */
    public void load() throws Exception {
        
//        if (fileObject == null) { 
            // Not listening for file changes.
            // Need to do this here since setPath() is not called at startup but
            // load() is. 
//          startObservingDataFile();            
//        } 
        
        setData(null);

        // return if no data file or recovery file - probably the first time.
        if (!getDataFile().exists() && !getBackupFile().exists()) {
            LOG.info("No data file or recovery file found.");
            return;
        }

        String error = "";

        // Normal case: read the existing data file
        if (getDataFile().exists()) {
            try {
                Data data = XStreamWrapper.instance().load(getDataFile());
                data.checkVersion();
                setData(data);
                return;
            } catch (Exception ex) {
                LOG.severe("Failed to read data file. " + ex.getMessage());
                error = ex.getMessage();
            }
        }

        String m;
        if (error.trim().length() > 0) {
            m = NbBundle.getMessage(getClass(), "file.read.error") + "\n\n" + error + "\n\n";
        } else {
            m = NbBundle.getMessage(getClass(), "file.read.error.short") + "\n\n";
        }

        // if no recovery file show message and return
        if (!getBackupFile().exists()) {
            Object[] options = {NbBundle.getMessage(getClass(), "ok")};
            Component p = WindowManager.getDefault().getMainWindow();
            JOptionPane.showOptionDialog(p, m, Constants.TITLE,
                    JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                    null, options, options[0]);
            return;
        }

        m = m + NbBundle.getMessage(getClass(), "restore.from.recovery.file") + "\n\n";
        Object[] options = {
            NbBundle.getMessage(getClass(), "ok"),
            NbBundle.getMessage(getClass(), "cancel")
        };

        //Component p = WindowManager.getDefault().getMainWindow();
        Component p = null; // above line must be called in AWT thread

        int opt = JOptionPane.showOptionDialog(p, m, Constants.TITLE,
                JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                null, options, options[0]);
        if (opt == 1) { // CANCEL
            throw new Exception("The data file could not be read.");
        }

        try {
            Data data = XStreamWrapper.instance().load(getBackupFile());
            data.checkVersion();
            createDataFile();
            setData(data);
            setChanged(true);
        } catch (Exception ex) {
            throw new Exception("The data file could not be recovered.");
        }
    }

    /**
     * Stores the data to file using XStream and makes a backup copy of the file.
     * @throws Exception if an exception occurs while storing the data.
     */
    public synchronized void store() throws Exception {
        if (!isLoaded()) {
            return;
        }
//        if (externalFileChange) {
//            return;
//        }        
        if (getDataFile().exists()) {
            try {
                UtilsFile.renameFile(getDataFile(), getBackupFile());
                LOG.info("Recovery file has been made.");
            } catch (Exception ex) {
                LOG.severe("Could not make recovery file. " + ex.getMessage());
            }
        }
        // Set the data state to not changed before (not after) writing because
        // a data change could occur during the writing time.
        setChanged(false);

        try {
            
//          stopObservingDataFile();

            synchronized(this) {
                XStreamWrapper.instance().store(getData(), getDataFile());                
            }
            
//          startObservingDataFile();

            LOG.fine("Data has been saved to file. ");
        } catch (Exception ex) {
            // write failed so restore (assumed) data changed state and re-throw exception
            setChanged(true);
            throw ex;
        }

        // Generate ICalendar if required.
        if (CalendarPrefs.isICalendarRequired()) {
//            LOG.fine("Creating iCalendar file.");
//
//            String path;
//
//            File file = new File(CalendarPrefs.getICalendarPath().trim());
//            if (file.isFile()) {
//                // iCalendar path preference is a file so use it
//                path = file.getPath();
//            } else if (file.isDirectory()) {
//                // iCalendar path preference is a dir so use it with datafile name and .ics extension
//                String dir = file.getPath();
//                if (!dir.endsWith(File.separator)) {
//                    dir += File.separator;
//                }
//                path = dir + UtilsFile.removeExtension(getDataFile().getName()) + ".ics";
//            } else {
//                // no iCalendar path preference so use datafile path and filename with .ics extension
//                path = UtilsFile.removeExtension(getDataFile().getPath()) + ".ics";
//            }
//
//            ICalendar.process(getData(), path, CalendarPrefs.getTimeZoneID());
//            
            try {
                LOG.fine("Starting iCalendar export ... ");                
                String filename = UtilsFile.removeExtension(getDataFile().getName()) + ".ics";                
                au.com.trgtd.tr.calendar.Calendar.syncToCalendar(filename);                
                LOG.fine("Finished iCalendar export.");
            }
            catch (Exception ex) {
                LOG.severe("iCalendar export failed. " + ex.getMessage());
                ex.printStackTrace(System.err);
            }
        }
    }

    /* Thread to periodically save the data. */
    private class AutoSaveThread extends Thread {
        @Override
        public void run() {
            while (autoSave) {
                if (hasChanged()) {
                    try {
                        store();
                    } catch (Exception ex) {
                        LOG.severe("XStream store exception. " + ex.getMessage());
                    }
                }
                try {
                    Thread.sleep(AUTO_SAVE_INTERVAL);
                } catch (InterruptedException ex) {
                }
            }
        }
    }

    /** Starts a thread to automatically save the data file periodically. */
    public void startDaemon() {
        startAutoSaving();
    }

    /** Stops the automatic saving thread. */
    public void stopDaemon() {
        stopAutoSaving();
    }

    private static void flush() {
        try {
            prefs.flush();
        } catch (BackingStoreException ex) {
            LOG.severe("XStream preferences exception. " + ex.getMessage());
        }
    }
    
//    private synchronized void startObservingDataFile() {        
//        if (fileObject != null) {
//            fileObject.removeFileChangeListener(dataFileChangeListener);
//            fileObject = null;
//            LOG.info("Stopped listening for data file changes.");
//        }
//        File file = getDataFile();
//        if (!file.isFile()) {
//            return;
//        }
//        try {
//            fileObject = FileUtil.createData(file);
//            fileObject.addFileChangeListener(dataFileChangeListener);
//            LOG.info("Started listening for data file changes.");
//        } catch (IOException ex) {
//            LOG.severe("Could not listen for data file changes. " + ex.getMessage());
//        }
//    }
//
//    private synchronized void stopObservingDataFile() {
//        if (fileObject != null) {
//            fileObject.removeFileChangeListener(dataFileChangeListener);
//            fileObject = null;
//            LOG.info("Stopped listening for data file changes.");
//        }
//    }

//    private class DataFileChangeListener extends FileChangeAdapter {
//        public void fileChanged(FileEvent arg0) {
//            externalFileChangeEvent();            
//        }        
//    }
    
//    public void fileFolderCreated(FileEvent arg0) {
//    }
//
//    public void fileDataCreated(FileEvent arg0) {
//    }
//
//    public void fileChanged(FileEvent arg0) {
//        externalFileChangeEvent();            
//    }
//
//    public void fileDeleted(FileEvent arg0) {
//    }
//
//    public void fileRenamed(FileRenameEvent arg0) {
//    }
//
//    public void fileAttributeChanged(FileAttributeEvent arg0) {
//    }
    
//    private void externalFileChangeEvent() {
//        externalFileChange = true;
//        
//        String m = NbBundle.getMessage(getClass(), "message.file.changed") + "    \n\n";
//        Object[] options = {
//            NbBundle.getMessage(getClass(), "ok"),
//            NbBundle.getMessage(getClass(), "cancel")
//        };
//        int opt = JOptionPane.showOptionDialog(null, m, Constants.TITLE,
//                JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
//                null, options, options[0]);
//        
//        if (opt == 0) { // OK
//            reload();
//        }                
//        
//        externalFileChange = false;                
//    }

    private void reload() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    WindowUtils.closeWindows();
                    load();
                    WindowUtils.openInitialWindow();
                } catch (Exception ex) {
                    LOG.severe("Could not open updated file. " + ex.getMessage());
                }
            }
        });        
    }

}
