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
package tr.archive;

import au.com.thinkingrock.tr.resource.Icons;
import au.com.trgtd.tr.appl.Constants;
import java.awt.Frame;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.openide.awt.StatusDisplayer;
import org.openide.util.HelpCtx;
import org.openide.util.Lookup;
import org.openide.util.LookupEvent;
import org.openide.util.LookupListener;
import org.openide.util.NbBundle;
import org.openide.util.actions.CallableSystemAction;
import org.openide.windows.WindowManager;
import tr.datastore.DataStore;
import tr.datastore.DataStoreLookup;
import tr.datastore.xstream.XStreamWrapper;
import tr.model.Data;
import tr.model.DataLookup;
import tr.model.action.Action;
import tr.model.action.RecurrenceRemover;
import tr.model.project.Project;
import tr.model.thought.Thought;
import tr.model.util.Manager;
import tr.util.DateUtils;
import tr.util.UtilsFile;

/**
 * Archive action.
 *
 * @author Jeremy Moore (jimoore@netspace.net.au)
 */
public final class ArchiveAction extends CallableSystemAction implements LookupListener {

    private static final Logger LOG = Logger.getLogger("tr.archive"); // No I18N
    private static final DateFormat DATESTAMP = new SimpleDateFormat("yyyyMMdd"); // No I18N
    private static final DateFormat TIMESTAMP = new SimpleDateFormat("HHmmssSSS"); // No I18N
    private Date archiveDate;
    private Vector<Project> archiveProjects;
    private Vector<Action> archiveActions;
    private Vector<Action> archiveSingleActions;

    /** Constructs a new instance. */
    public ArchiveAction() {
        super();
        setIcon(Icons.Archive);
        Data data = (Data) DataLookup.instance().lookup(Data.class);
        setEnabled(data != null);
        Lookup.Result r = DataLookup.instance().lookup(new Lookup.Template(Data.class));
        r.addLookupListener(this);
        r.allInstances();
    }

    public String getName() {
        return NbBundle.getMessage(getClass(), "CTL_ArchiveAction"); // No I18N
    }

    public HelpCtx getHelpCtx() {
        return new HelpCtx("tr.archive"); // No I18N
    }

    @Override
    protected boolean asynchronous() {
        return false;
    }

    /** Save the current datastore as another file. */
    public void performAction() {

        // get saved preferences
        Date date = ArchivePrefs.getDate();
        String path = ArchivePrefs.getPath();
        boolean doneProjectsOnly = ArchivePrefs.isDoneProjectsOnly();

        // dialog to get archive preferences
        Frame frame = WindowManager.getDefault().getMainWindow();

        ArchiveDialog dialog = new ArchiveDialog(frame, true, date, path, doneProjectsOnly);
        dialog.setVisible(true);
        if (!dialog.archive) {
            LOG.fine("User did not select archive"); // No I18N
            return;
        }

        StatusDisplayer.getDefault().setStatusText(NbBundle.getMessage(ArchiveAction.class, "archiving"));

        archiveDate = DateUtils.getEnd(dialog.getArchiveDate());
        String archivePath = dialog.getArchivePath();
        doneProjectsOnly = dialog.isDoneProjectsOnly();

        DataStore datastore = (DataStore) DataStoreLookup.instance().lookup(DataStore.class);
        if (datastore == null) {
            LOG.severe("Data store could not be obtained."); // No I18N
            StatusDisplayer.getDefault().setStatusText("");
            return;
        }

        File dataFile = new File(datastore.getPath());
        if (!dataFile.isFile()) {
            LOG.severe("Data file path error."); // No I18N
            StatusDisplayer.getDefault().setStatusText(""); // No I18N
            return;
        }

        File archiveFolder = (archivePath == null || archivePath.equals("")) // No I18N
                ? dataFile.getParentFile()
                : new File(archivePath);

        if (!archiveFolder.isDirectory()) {
            LOG.severe("Archive directory error."); // No I18N
            StatusDisplayer.getDefault().setStatusText(""); // No I18N
            return;
        }

        String filename = UtilsFile.removeExtension(dataFile.getName());
        String extension = UtilsFile.getExtension(dataFile.getName());

        Date currentDate = Calendar.getInstance().getTime();
        String currentDateStamp = DATESTAMP.format(currentDate);
        String currentTimeStamp = TIMESTAMP.format(currentDate);

        // make backupFile copy of dataFile to archive folder
        File backupFile = new File(archiveFolder, filename + "-" + currentDateStamp + "-" + currentTimeStamp + ".backup." + extension); // No I18N
        try {
            UtilsFile.copyFile(dataFile, backupFile);
        } catch (Exception ex) {
            LOG.severe("Error creating archive backup of datafile. " + ex.getMessage()); // No I18N
            StatusDisplayer.getDefault().setStatusText("");
            return;
        }

        // Make archive copy of data file to archive folder
        String archiveDateStamp = DATESTAMP.format(archiveDate);
        File archiveFile = new File(archiveFolder, filename + "-" + archiveDateStamp + "-" + currentTimeStamp + ".archive." + extension); // No I18N

        try {
            UtilsFile.copyFile(dataFile, archiveFile);
        } catch (Exception ex) {
            LOG.severe("Error creating archive copy of datafile. " + ex.getMessage()); // No I18N
            StatusDisplayer.getDefault().setStatusText("");
            return;
        }

        archiveSingleActions = new Vector<Action>();
        archiveActions = new Vector<Action>();
        archiveProjects = new Vector<Project>();

        Data archiveData = null;
        try {
            archiveData = XStreamWrapper.instance().load(archiveFile);
        } catch (Exception ex) {
            LOG.severe("Error loading data from archive file. " + ex.getMessage()); // No I18N
            StatusDisplayer.getDefault().setStatusText("");
            return;
        }

        // Remove from archive all single singleActions that are not done or
        // have done date after the archive date
        for (Action action : archiveData.getRootActions().getChildren(Action.class)) {
            if (action.isDone() && action.getDoneDate().before(archiveDate)) {
                archiveSingleActions.add(action);
            } else {
                LOG.fine("Removing from archive - action: " + action.getDescription()); // No I18N
                action.removeFromParent();
            }
        }

        if (doneProjectsOnly) {            
            // Remove from archive all top level projects which are not done or 
            // have done date after archive date
            for (Project project : archiveData.getRootProjects().getChildren(Project.class)) {
                if (project.isDone() && project.getDoneDate().before(archiveDate)) {
                    archiveProjects.add(project);
                } else {
                    LOG.fine("Removing from archive - project: " + project.getDescription()); // No I18N
                    project.removeFromParent();
                }
            }
        } else {
            /* @since 1.2 */
            for (Project project : archiveData.getRootProjects().getChildren(Project.class)) {
                keepArchived(project);
            }
        }

        // remove from archive all unprocessed thoughts
        Manager<Thought> archiveThoughtManager = archiveData.getThoughtManager();
        for (Thought thought : archiveThoughtManager.list()) {
            if (!thought.isProcessed()) {
                archiveThoughtManager.remove(thought);
            }
        }

        // Remove from archive all future projects
        for (Iterator<Project> i = archiveData.getRootFutures().iterator(Project.class); i.hasNext();) {
            i.next().removeFromParent();
        }

        // Remove from archive all template projects
        for (Iterator<Project> i = archiveData.getRootTemplates().iterator(Project.class); i.hasNext();) {
            i.next().removeFromParent();
        }

        // remove from archive all future items
        archiveData.getFutureManager().removeAll();

        // remove from archive all information items
        archiveData.getInformationManager().removeAll();

        // remove from archive actions all recurrence definitions
        RecurrenceRemover.removeAll(archiveData);

        // save archive
        try {
            XStreamWrapper.instance().store(archiveData, archiveFile);
        } catch (Exception ex) {
            LOG.severe("Error storing archive. " + ex.getMessage()); // No I18N
            StatusDisplayer.getDefault().setStatusText(""); // No I18N
            return;
        }

        // get actual data file
        Data data = (Data) DataLookup.instance().lookup(Data.class);
        if (data == null) {
            LOG.severe("Data could not be obtained."); // No I18N
            StatusDisplayer.getDefault().setStatusText(""); // No I18N
            return;
        }

//      // Remove from data file all archived single singleActions
//        Project singleActions = data.getRootActions();
//        for (Action archiveAction : archiveActions) {
//            LOG.fine("Removing from data - action: " + archiveAction.getDescription()); // No I18N
//            singleActions.remove(archiveAction);
//        }

        // Remove from data file all archived single actions
        Project singleActions = data.getRootActions();
        for (Action a : archiveSingleActions) {
            LOG.fine("Removing from data - single action: " + a.getDescription()); 
            singleActions.remove(a);
        }        

        // create a map of all data file projects
        Map<Integer, Project> dataProjectsMap = createProjectsMap(data);        

        // Remove from data file all archived actions
        for (Action archiveAction : archiveActions) {
            LOG.fine("Removing from data file - archived action: " + archiveAction.getDescription());
            
            Project dataParent = dataProjectsMap.get(archiveAction.getParent().getID());
            if (dataParent != null) {
                if (!dataParent.remove(archiveAction)) {
                    LOG.severe("Archived action could not be removed from data file.");                                                    
                }
            } else {
                // should never happen.
                LOG.severe("Could not find parent project in data file for archived action.");                                
            }
        }

        // Remove from data file all archived projects
//      Project projects = data.getRootProjects();
        for (Project archiveProject : archiveProjects) {
            LOG.fine("Removing from data file - archived project: " + archiveProject.getDescription());
//          projects.remove(archiveProject);
            Project dataParent = dataProjectsMap.get(archiveProject.getParent().getID());
            if (dataParent != null) {
                if (!dataParent.remove(archiveProject)) {
                    LOG.severe("Archived project could not be removed from data file.");                                                    
                }
            } else {
                // should never happen.
                LOG.severe("Could not find parent project in data file for archived project.");                                
            }
        }

        saveData(datastore);

        // Save archive preferences
        ArchivePrefs.setDate(archiveDate);
        ArchivePrefs.setPath(archivePath);
        ArchivePrefs.setDoneProjectsOnly(doneProjectsOnly);

        StatusDisplayer.getDefault().setStatusText(""); // No I18N

        String t = Constants.TITLE + " " + NbBundle.getMessage(getClass(), "CTL_ArchiveAction"); // No I18N

        String COMPLETED = NbBundle.getMessage(getClass(), "archive.completed"); 
        String ARCHIVE_DATE = NbBundle.getMessage(getClass(), "archive.date"); 
        String BACKUP_FILE = NbBundle.getMessage(getClass(), "backup.file"); 
        String ARCHIVE_FILE = NbBundle.getMessage(getClass(), "archive.file");
        String SINGLE_ACTIONS = NbBundle.getMessage(getClass(), "single.actions");
        String PROJECTS = NbBundle.getMessage(getClass(), "projects"); 
        String PROJECT_ACTIONS = NbBundle.getMessage(getClass(), "project.actions");

        String m = COMPLETED + ". \n\n" 
                + ARCHIVE_DATE + ": " + archiveDate + "\n\n" 
                + BACKUP_FILE + ": " + backupFile.getPath() + "\n" 
                + ARCHIVE_FILE + ": " + archiveFile.getPath() + "\n\n"; 
//                + archiveSingleActions.size() + "  " + SINGLE_ACTIONS + "\n" 
//                + archiveProjects.size() + "  " + PROJECTS + "\n"
//                + archiveActions.size() + "  " + PROJECT_ACTIONS + "\n\n";
        JOptionPane.showMessageDialog(frame, m, t, JOptionPane.INFORMATION_MESSAGE);
    }

    /* Remove all projects and actions that are not to be archived and
     * return true if any are kept.
     */
    private boolean keepArchived(Project project) {

        if (project == null) {
            return false;
        }

        if (project.isDone() && project.getDoneDate().before(archiveDate)) {
            archiveProjects.add(project);
            return true;
        }

        boolean isAnyKept = false;

        for (Project subproject : project.getChildren(Project.class)) {
            if (keepArchived(subproject)) {
                isAnyKept = true;
            }
        }

        for (Action action : project.getChildren(Action.class)) {
            if (action.isDone() && action.getDoneDate().before(archiveDate)) {
                archiveActions.add(action);
                isAnyKept = true;
            } else {
                action.removeFromParent();
            }
        }

        if (isAnyKept) {
            // we need to keep this project since it has archived children
            // but we do not add to the archived projects list as we do not 
            // want to remove it from the data file.
        } else {
            // no archived children so remove
            project.removeFromParent();
        }
        
        return isAnyKept;
    }
    
    private Map<Integer, Project> createProjectsMap(Data data) {        
        Map<Integer, Project> map = new HashMap<Integer, Project>();        
        mapProjects(data.getRootProjects(), map);
        return map;
    }

    private void mapProjects(Project project, Map<Integer, Project> map) {
        map.put(project.getID(), project);
        for (Project subproject : project.getChildren(Project.class)) {
            mapProjects(subproject, map);
        }
    }
    
    private void saveData(DataStore ds) {
        try {
            ds.store();
        } catch (Exception ex) {
            LOG.severe("Could not save data. " + ex.getMessage()); // No I18N
        }
    }

    /**
     * Implement LookupListener to handle data change.
     * @param lookupEvent Is not used.
     */
    public void resultChanged(LookupEvent lookupEvent) {
        Data data = (Data) DataLookup.instance().lookup(Data.class);
        setEnabled(data != null);
    }
}
