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
package au.com.trgtd.tr.calendar.ical4j.impl;

import au.com.trgtd.tr.appl.Constants;
import au.com.trgtd.tr.calendar.ical4j.ICal4JWrapper;
import au.com.trgtd.tr.calendar.ical4j.impl.prefs.Options;
import au.com.trgtd.tr.calendar.ical4j.impl.prefs.OptionsPanel;
import au.com.trgtd.tr.calendar.prefs.CalendarPrefs;
import au.com.trgtd.tr.calendar.spi.CalendarSynchronizer;
import au.com.trgtd.tr.calendar.spi.CalendarSynchronizerOptions;
import java.io.File;
import java.util.Date;
import org.openide.util.NbBundle;
import tr.model.Data;
import tr.model.DataLookup;
import tr.model.Item.Item;
import tr.model.action.Action;
import tr.model.action.ActionStateDelegated;
import tr.model.action.ActionStateScheduled;
import tr.model.project.Project;
import tr.model.thought.Thought;
import tr.util.DateUtils;

/**
 * Generate an ICalendar file for the data model.
 *
 * @author jeremyimoore@yahoo.com.au
 */
public class ICalendarSynchronizer implements CalendarSynchronizer {

    private static final String UID_SUFFIX = "@trgtd.com.au";
    private static final String DELEGATED_TO = NbBundle.getMessage(ICalendarSynchronizer.class, "Delegated_to");
    private static ICal4JWrapper ical;
    private static File outfile;
    private static CalendarSynchronizerOptions options;

    public String getID() {
        return "au.com.trgtd.tr.calendar.synchronizer.default";
    }

    public String getName() {
        return NbBundle.getMessage(getClass(), "synchronizer.name");
    }

    public void syncToCalendar() {
        syncToCalendar(null);
    }

    public void syncToCalendar(String filename) {
        Data data = (Data) DataLookup.instance().lookup(Data.class);
        if (data == null) {
            return;
        }

        String path = Options.getICalendarPath();

        File file = new File(path);
        if (file.isFile()) {
            // iCalendar path preference is a file so use it
            path = file.getPath();
        } else if (file.isDirectory()) {
            // iCalendar path preference is a dir so use it with datafile name and .ics extension
            if (filename == null) {
                filename = "ThinkingRock.ics";
            }
            if (path.endsWith(File.separator)) {
                path += filename;
            } else {
                path += File.separator + filename;
            }
        }

        process(data, path, Options.getTimeZoneID());
    }

    public void syncFromCalendar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public CalendarSynchronizerOptions getOptions() {
        if (options == null) {
            options = new OptionsPanel();
        }
        return options;
    }

    /**
     * Generate an iCalendar for the data and file path.
     * @param data The data model.
     * @param path The output file path (including filename).
     */
    private static void process(Data data, String path, String tzid) {

        ical = new ICal4JWrapper(tzid);

        try {
            System.out.print("Generating ICalendar file ... ");
            initialise(path);
            process(data);
            finalise();
            System.out.println("done");
        } catch (Exception ex) {
            System.out.println();
            ex.printStackTrace(System.err);
        }
    }

    /* Initialise the output file. */
    private static void initialise(String filename) throws Exception {
        outfile = new File(filename);
    }

    /* Finalise the output file. */
    private static void finalise() throws Exception {
        ical.write(outfile);
    }

    // Process the data.
    private static void process(Data data) {
        // process top level projects
        for (Project project : data.getRootProjects().getChildren(Project.class)) {
            process(project);
        }
        // process single actions
        for (Action action : data.getRootActions().getChildren(Action.class)) {
            process(action);
        }
    }

    /* process a project (recursively). */
    private static void process(Project project) {
        for (Item child : project.getChildren()) {
            if (child instanceof Action) {
                process((Action) child);
            } else if (child instanceof Project) {
                process((Project) child);
            }
        }
    }

    /* Process an action. */
    private static void process(Action action) {
        if (action.isDone()) {
            return;
        }
        switch (action.getState().getType()) {
            case INACTIVE: {
                processInactive(action);
                break;
            }
            case DOASAP: {
                processDoASAP(action);
                break;
            }
            case DELEGATED: {
                processDelegated(action);
                break;
            }
            case SCHEDULED: {
                processScheduled(action);
                break;
            }
        }
    }

    private static void processInactive(Action action) {
        if (!CalendarPrefs.isSyncInactive()) {
            return;
        }
        Date actionDate = DateUtils.clearTime(action.getActionDate());
        if (actionDate == null) {
            return;
        }
        String uid = getUID(action.getID());
        String descr = action.getDescription();
        String context = getContext(action);
        Integer priority = getPriority(action);
        Date startDate = DateUtils.clearTime(action.getStartDate());
        Date dueDate = DateUtils.clearTime(action.getDueDate());

        if (CalendarPrefs.isInactiveAsTodo()) {
            ical.createToDo(uid, startDate, dueDate, descr, getNotes(action), context, priority);
        } else {
            StringBuffer sb = new StringBuffer();
            if (startDate != null) {
                sb.append("Start: " + Constants.DATE_FORMAT_FIXED.format(startDate) + "\r\n");
            }
            if (dueDate != null) {
                sb.append("Due: " + Constants.DATE_FORMAT_FIXED.format(dueDate) + "\r\n");
            }
            String notes = sb.toString() + getNotes(action);
            ical.createAllDayEvent(uid, actionDate, descr, notes, context, priority);
        }
    }

    private static void processDoASAP(Action action) {
        String uid = getUID(action.getID());
        String descr = action.getDescription();
        String context = getContext(action);
        Integer priority = getPriority(action);
        String notes = getNotes(action);
        Date start = DateUtils.clearTime(action.getStartDate());
        Date due = DateUtils.clearTime(action.getDueDate());

        if (due == null) {
            if (CalendarPrefs.isSyncDoasapNoDueDate()) {
                ical.createToDo(uid, start, due, descr, notes, context, priority);
            }
        } else {
            if (CalendarPrefs.isSyncDoasapDueDate()) {
                if (CalendarPrefs.isDoasapDueAsTodo()) {
                    ical.createToDo(uid, start, due, descr, notes, context, priority);
                } else {
                    ical.createAllDayEvent(uid, due, descr, notes, context, priority);
                }
            }
        }
    }

    private static void processDelegated(Action action) {

        Date actionDate = action.getActionDate();
        if (actionDate == null) {
            if (!CalendarPrefs.isSyncDelegatedNoDate()) {
                return;
            }
            // export as To Do with no date
            ActionStateDelegated state = (ActionStateDelegated) action.getState();
            String uid = getUID(action.getID());
            String descr = action.getDescription() + "  " + DELEGATED_TO + ": " + state.getTo();
            String context = getContext(action);
            Integer priority = getPriority(action);
            String notes = getNotes(action);
            ical.createToDo(uid, null, null, descr, notes, context, priority);
        } else { // (actionDate != null)
            if (!CalendarPrefs.isSyncDelegated()) {
                return;
            }
            ActionStateDelegated state = (ActionStateDelegated) action.getState();
            String uid = getUID(action.getID());
            String descr = action.getDescription() + "  " + DELEGATED_TO + ": " + state.getTo();
            String context = getContext(action);
            Integer priority = getPriority(action);
            String notes = getNotes(action);

            if (CalendarPrefs.isDelegatedAsTodo()) {
                ical.createToDo(uid, actionDate, actionDate, descr, notes, context, priority);
            } else {
                ical.createAllDayEvent(uid, actionDate, descr, notes, context, priority);
            }
        }
    }

    private static void processScheduled(Action action) {
        if (!CalendarPrefs.isSyncScheduled()) {
            return;
        }
        ActionStateScheduled state = (ActionStateScheduled) action.getState();
        Date scheduled = state.getDate();
        if (scheduled == null) {
            return;
        }
        int hours = state.getDurationHours();
        int mins = state.getDurationMinutes();
        // if no duration, default to 15 minutes
        if (hours < 1 && mins < 1) {
            hours = 0;
            mins = 15;
        }
        String uid = getUID(action.getID());
        String descr = action.getDescription();
        String context = getContext(action);
        Integer priority = getPriority(action);
        String notes = getNotes(action);

        if (DateUtils.hasTime(scheduled)) {
            ical.createSpecificTimeEvent(uid, scheduled, descr, notes, context, hours, mins, priority);
        } else {
            ical.createAllDayEvent(uid, scheduled, descr, notes, context, priority);
        }
    }

    private static String getUID(int id) {
        return id + UID_SUFFIX;
    }

    private static String getContext(Action action) {
        return action.getContext().getName();
    }

    private static Integer getPriority(Action action) {
        return action.getPriority() == null ? null : action.getPriority().getMappedValue();
    }

    private static String getNotes(Action action) {
        StringBuffer notes = new StringBuffer();
        notes.append(getContext(action));
        if (action.isSingleAction()) {
            Thought thought = action.getThought();
            if (thought != null) {
                notes.append(" {" + thought.getDescription() + "}");
            }
        } else {
            Project project = (Project) action.getParent();
            if (project != null) {
                notes.append(" [" + project.getDescription() + "]");
            }
        }
        notes.append("\r\n");
        notes.append(action.getNotes());
        return notes.toString();
    }
}
