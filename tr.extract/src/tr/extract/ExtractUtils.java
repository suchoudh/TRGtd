/*
 * The contents of this file are subject to the terms of the Common Development
 * and Distribution License (the License). You may not use this file except in
 * compliance with the License.
 *
 * You can get action copy of the License at http://www.thinkingrock.com.au/cddl.html
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
package tr.extract;

import au.com.trgtd.tr.appl.Constants;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Logger;
import tr.extract.Extract.FormatType;
import tr.extract.criteria.ValueIDsProviderEnergy;
import tr.extract.criteria.ValueIDsProviderPriority;
import tr.extract.criteria.ValueIDsProviderTime;
import tr.model.action.Action;
import tr.model.action.ActionStateDelegated;
import tr.model.action.ActionStateScheduled;
import tr.model.criteria.Value;
import tr.model.project.Project;

/**
 * Extract projects outline data as XML.
 *
 * @author jeremyimoore@yahoo.com.au
 */
public class ExtractUtils {

    public static final Logger LOG = Logger.getLogger("tr.extract");
    public static final DateFormat DFN = Constants.DATE_FORMAT_FIXED;
    public static final DateFormat DFT = Constants.DATE_TIME_FORMAT_FIXED;

    /* Initialise the output XML file stream, etc. */
    public static synchronized Writer initialise(File xmlfile) throws Exception {
        if (xmlfile.exists()) {
            xmlfile.delete();
        }
        OutputStream fout = new FileOutputStream(xmlfile);
        OutputStream bout = new BufferedOutputStream(fout);
        OutputStreamWriter out = new OutputStreamWriter(bout, "UTF-8");
        out.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n");
        out.write("<data>\r\n");
        return out;
    }

    /* Finalise the output XML file stream, etc. */
    public static synchronized void finalise(Writer out) throws Exception {
        out.write("</data>\r\n");
        out.flush();
        out.close();
    }

    public static synchronized String getState(Action a) {
        return getState(a, DFN, DFT);        
    }    
    
    public static synchronized String getState(Action a, DateFormat dfn, DateFormat dft) {
        StringBuffer sb = new StringBuffer();
        if (a.isStateASAP()) {
            sb.append("\u2605");
            sb.append(a.getDueDate() == null ? "" : " " + org.openide.util.NbBundle.getMessage(ExtractUtils.class, "Due") + ": " + dfn.format(a.getDueDate()));
        } else if (a.isStateDelegated()) {
            ActionStateDelegated s = (ActionStateDelegated) a.getState();
            sb.append("\u261E");
            sb.append(s.getTo() == null ? "" : " " + escape(s.getTo()));
            sb.append(s.getDate() == null ? "" : " " + org.openide.util.NbBundle.getMessage(ExtractUtils.class, "Followup_Abbrev") + ": " + dfn.format(s.getDate()));
            sb.append(a.getDueDate() == null ? "" : " " + org.openide.util.NbBundle.getMessage(ExtractUtils.class, "Due") + ": " + dfn.format(a.getDueDate()));
        } else if (a.isStateScheduled()) {
            ActionStateScheduled s = (ActionStateScheduled) a.getState();
            sb.append(s.getRecurrence() == null ? "\u2637" : "\u27F3");
            Date d = s.getDate();
            if (d != null) {
                sb.append(" ");
                sb.append(hasTime(d) ? dft.format(s.getDate()) : dfn.format(s.getDate()));
            }
            if (s.getDurationHours() > 0 || s.getDurationMinutes() > 0) {
                sb.append(" ");
                if (s.getDurationHours() > 0) {
                    sb.append(s.getDurationHours() + "h");
                }
                if (s.getDurationMinutes() > 0) {
                    sb.append(s.getDurationMinutes() + "m");
                }
            }
        } else if (a.isStateInactive()) {
            sb.append("\u2606");
            sb.append(a.getStartDate() == null ? "" : " " + org.openide.util.NbBundle.getMessage(ExtractUtils.class, "Start") + ": " + dfn.format(a.getStartDate()));
            sb.append(a.getDueDate() == null ? "" : " " + org.openide.util.NbBundle.getMessage(ExtractUtils.class, "Due") + ": " + dfn.format(a.getDueDate()));
        }
        return sb.length() == 0 ? "" : sb.toString();
    }

    public static synchronized String getSymbol(Action action) {
        switch (action.getState().getType()) {
            case DOASAP:
                return "\u2605";
            case SCHEDULED: {
                ActionStateScheduled state = (ActionStateScheduled) action.getState();
                return state.getRecurrence() == null ? "\u2637" : "\u27F3";
            }
            case DELEGATED:
                return "\u261E";
            case INACTIVE:
                return "\u2606";
            default:
                return "";
        }
    }

    public static synchronized String getDuration(ActionStateScheduled s) {
        StringBuffer sb = new StringBuffer();
        if (s.getDurationHours() > 0 || s.getDurationMinutes() > 0) {
            sb.append(" ");
            if (s.getDurationHours() > 0) {
                sb.append(s.getDurationHours() + "h");
            }
            if (s.getDurationMinutes() > 0) {
                sb.append(s.getDurationMinutes() + "m");
            }
        }
        return sb.toString();
    }

    public static synchronized String getActionDate(Action action) {
        Date date = action.getActionDate();
        if (date == null) {
            return "";
        }
        return action.isStateScheduled() ? DFT.format(date) : DFN.format(date);
    }

    public static synchronized String getActionDateIndex(Action action) {
        return Long.toString(action.getActionDate() == null ? Long.MAX_VALUE : action.getActionDate().getTime());
    }

    public static synchronized String getCriteria(Action action) {
        String result =
                getTime(action.getTime()) + " " +
                getEnergy(action.getEnergy()) + " " +
                getPriority(action.getPriority());
        return result.trim();
    }

    public static synchronized String getTime(Value time) {
        return time == null ? "" : "\u25F7" + escape(time.getName());
    }

    public static synchronized String getEnergy(Value energy) {
        return energy == null ? "" : "\u26A1" + escape(energy.getName());
    }

    public static synchronized String getPriority(Value priority) {
        return priority == null ? "" : "\u2690" + escape(priority.getName());
    }

    public static synchronized String getTimeIndex(Value value) {
        if (value == null) {
            return Integer.toString(Integer.MAX_VALUE);
        }
        return Integer.toString(ValueIDsProviderTime.instance.getIDs().indexOf(value.getID()));
    }

    public static synchronized String getEnergyIndex(Value value) {
        if (value == null) {
            return Integer.toString(Integer.MAX_VALUE);
        }
        return Integer.toString(ValueIDsProviderEnergy.instance.getIDs().indexOf(value.getID()));
    }

    public static synchronized String getPriorityIndex(Value value) {
        if (value == null) {
            return Integer.toString(Integer.MAX_VALUE);
        }
        return Integer.toString(ValueIDsProviderPriority.instance.getIDs().indexOf(value.getID()));
    }

    public static synchronized String getContext(Action action) {
        String context = action.getContext().getName().trim();
        if (!context.startsWith("@")) {
            context = "@" + context;
        }
        return escape(context);
    }

    public static synchronized String getTopic(Action action) {
        return "\u2302" + escape(action.getTopic().getName());
    }

    public static synchronized boolean hasTime(Date date) {
        if (date == null) {
            return false;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.HOUR) > 0 ||
                calendar.get(Calendar.MINUTE) > 0 ||
                calendar.get(Calendar.SECOND) > 0;
    }

    public static String getProjectPath(Project project, String path) {
        if (path.length() > 0) {
            path = project.getDescription() + "/" + path;
        } else {
            path = project.getDescription();
        }
        Object object = project.getParent();
        if (object instanceof Project) {
            Project parent = (Project) object;
            if (!parent.isRoot()) {
                return getProjectPath(parent, path);
            }
        }
        return path;
    }
    
    /*
     * Escapes the characters in action String using XML entities.  For example:
     * "bread" & "butter" => &quot;bread&quot; &amp; &quot;butter&quot;.
     * @param string The string.
     * @return The escaped string.
     */
    public static synchronized String escape(String string) {
        return FormatType.XML.escape(string);
    }
}
