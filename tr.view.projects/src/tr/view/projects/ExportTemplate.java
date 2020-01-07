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
package tr.view.projects;

import java.awt.Component;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import org.apache.commons.lang.StringEscapeUtils;
import org.openide.filesystems.FileUtil;
import org.openide.util.NbBundle;
import org.openide.windows.WindowManager;
import tr.data.FileFilterImpl;
import tr.model.Item.Item;
import tr.model.action.Action;
import tr.model.action.ActionStateASAP;
import tr.model.action.ActionStateDelegated;
import tr.model.action.ActionStateInactive;
import tr.model.action.ActionStateScheduled;
import tr.model.criteria.Value;
import tr.model.project.Project;
import tr.model.thought.Thought;

/**
 * Export a project template.
 *
 * @author jeremyimoore@yahoo.com.au
 */
public class ExportTemplate {
    
    private static final Logger LOG = Logger.getLogger("tr.view.projects.ExportTemplate");    
    private static final int VERSION_MAJOR = 1;     
    private static final int VERSION_MINOR = 0;     
    private static final String VERSION = VERSION_MAJOR + "." + VERSION_MINOR;    
    private static final String EXTN = "trpt";
    private static final String EXTN_NAME = NbBundle.getMessage(ExportTemplate.class, "template.file.extension.name");    
    
    public ExportTemplate() {        
    }
    
    /**
     * Export a project template to an XML file.
     * @param project the project.
     */
    public void export(Project project) {
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle(NbBundle.getMessage(ExportTemplate.class, "export.template.file.chooser.title"));
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        FileFilter filter = new FileFilterImpl(EXTN_NAME, new String[] {EXTN}, true);        
        chooser.setFileFilter(filter);
        Component p = WindowManager.getDefault().getMainWindow();
        int returnVal = chooser.showDialog(p, NbBundle.getMessage(ExportTemplate.class, "export.template.file.chooser.button"));
        if (returnVal != JFileChooser.APPROVE_OPTION) {
            return;
        }
        
        String path = chooser.getSelectedFile().getPath();
        String extn = FileUtil.getExtension(path);
        if (extn == null || extn.length() == 0) {
            path += "." + EXTN;
        }
        File outfile = new File(path);
        if (outfile.exists()) {
            String t = NbBundle.getMessage(ExportTemplate.class, "export.template.file.chooser.title");
            String m = NbBundle.getMessage(ExportTemplate.class, "confirm.replace.file");
            int r = JOptionPane.showConfirmDialog(p, m, t, JOptionPane.YES_NO_OPTION);
            if (r != JOptionPane.YES_OPTION) {
                return;                
            } 
            outfile.delete();
        }
        
        try {
            Writer writer = initialise(outfile);
            process(project, writer);
            finalise(writer);
        } catch (Exception ex) {
            LOG.severe("Export project template failed: " + ex.getMessage());
        }
    }

    /* Initialise the output XML file stream, etc. */
    private Writer initialise(File xmlfile) throws Exception {
        if (xmlfile.exists()) {
            xmlfile.delete();
        }
        OutputStream fout = new FileOutputStream(xmlfile);
        OutputStream bout = new BufferedOutputStream(fout);
        OutputStreamWriter out = new OutputStreamWriter(bout, "UTF-8");
        out.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n");        
        out.write("<template version=\"" + VERSION  + "\">\r\n");
        return out;
    }

    /* Finalise the output XML file stream, etc. */
    private void finalise(Writer out) throws Exception {
        out.write("</template>\r\n");
        out.flush();
        out.close();
    }

    private void process(Project project, Writer out) {
        try {
            LOG.info("Export project template ... ");
            out.write("<project>\r\n");        
            writeProject(project, out);
            out.write("</project>\r\n");        
            LOG.info("Export project template ... done");
        } catch (Exception ex) {
            LOG.severe("Export project template failed: " + ex.getMessage());
        }
    }

    /* Extract a project (and its children) to XML. */
    public void writeProject(Project project, Writer out) throws Exception {
//      Integer id;    
//      String description;
        out.write("<descr>" + escape(project.getDescription()) + "</descr>\r\n");
//      Date created;
//      Thought thought;
//        Thought thought = project.getThought();
//        if (thought != null) {
//            out.write("<thought>" + escape(thought.getDescription()) + "</thought>\r\n");
//        }
//      Topic topic;
        out.write("<topic>" + escape(project.getTopic().getName()) + "</topic>\r\n");
//      String purpose;
        out.write("<purpose>" + escape(project.getPurpose()) + "</purpose>\r\n");
//      String success;
        out.write("<success>" + escape(project.getVision()) + "</success>\r\n");
//      String brainstorming;
        out.write("<brainstorming>" + escape(project.getBrainstorming()) + "</brainstorming>\r\n");
//      String organising;
        out.write("<organising>" + escape(project.getOrganising()) + "</organising>\r\n");
//      boolean done;        
//      Date doneDate;
//      boolean sequence;
        out.write("<sequence>" + project.isSequencing() + "</sequence>\r\n");
//      Sequencing sequencing;
        out.write("<sequence-into>" + project.isSequenceIntoSubProjects() + "</sequence-into>\r\n");
//      Date dueDate;
//      String notes;
        out.write("<notes>" + escape(project.getNotes().trim()) + "</notes>\r\n");

        Value priority = project.getPriority();
        if (priority != null) {
            out.write("<priority>" + escape(priority.getName()) + "</priority>\r\n");                    
        }

//      Date startDate;
//      Date modified;
//      Project parent;        
//      Vector<Item> children;
        for (Item child : project.getChildren()) {
            if (child instanceof Project) {
                out.write("<child type='project'>\r\n");                        
                writeProject((Project)child, out);              
                out.write("</child>\r\n");                        
            } else if (child instanceof Action) {
                out.write("<child type='action'>\r\n");                        
                writeAction((Action)child, out);                
                out.write("</child>\r\n");        
            }
        }        
    }
    
    public void writeAction(Action action, Writer out) throws Exception {
//      Integer id;
//      Date created;
//      Thought thought;        
        Thought thought = action.getThought();
        if (thought != null) {
            out.write("<thought>" + escape(thought.getDescription()) + "</thought>\r\n");
        }
//      Project parent;         
//      String description;
        out.write("<descr>" + escape(action.getDescription()) + "</descr>\r\n");
//      Topic topic;
        out.write("<topic>" + escape(action.getTopic().getName()) + "</topic>\r\n");
//      Context context;
        out.write("<context>" + escape(action.getContext().getName()) + "</context>\r\n");
//      String notes;
        out.write("<notes>" + escape(action.getNotes().trim()) + "</notes>\r\n");
//      boolean done;
//      Date doneDate;        
        Value time = action.getTime();
        if (time != null) {
            out.write("<time>" + escape(time.getName()) + "</time>\r\n");                    
        }        
        Value energy = action.getEnergy();
        if (energy != null) {
            out.write("<energy>" + escape(energy.getName()) + "</energy>\r\n");                    
        }
        Value priority = action.getPriority();
        if (priority != null) {
            out.write("<priority>" + escape(priority.getName()) + "</priority>\r\n");                    
        }        
//      String success;
        out.write("<success>" + escape(action.getSuccess()) + "</success>\r\n");
//      Date startDate;
//      Date dueDate;           
//      Date modified;                
//      ActionState state;
        switch (action.getState().getType()) {
            case DELEGATED: {
                writeStateDelegated((ActionStateDelegated)action.getState(), out);
                break;
            }                
            case SCHEDULED: {
                writeStateScheduled((ActionStateScheduled)action.getState(), out);
                break;
            }
            case INACTIVE: {
                writeStateInactive((ActionStateInactive)action.getState(), out);                
                break;
            }
            case DOASAP: {
                writeStateDoASAP((ActionStateASAP)action.getState(), out);                                
                break;
            }
            default:    
        }        
    }

    private void writeStateDelegated(ActionStateDelegated s, Writer out) throws Exception {
        out.write("<state type='DELEGATED'>");                        
        out.write("<delegate>" + escape(s.getTo()) + "</delegate>\r\n");                        
        out.write("</state>");                        
    }
    
    private void writeStateScheduled(ActionStateScheduled s, Writer out) throws Exception {
        out.write("<state type='SCHEDULED'>");                        
        out.write("</state>");                            
    }

    private void writeStateInactive(ActionStateInactive s, Writer out) throws Exception {
        out.write("<state type='INACTIVE'>");                        
        out.write("</state>");                        
    }
    
    private void writeStateDoASAP(ActionStateASAP s, Writer out) throws Exception {
        out.write("<state type='DOASAP'>");                        
        out.write("</state>");                        
    }
    
    /*
     * Escapes the characters in a String using XML entities.  For example:
     * "bread" & "butter" => &quot;bread&quot; &amp; &quot;butter&quot;.
     * @param string The string.
     * @return The escaped string.
     */
    private String escape(String string) {
        return StringEscapeUtils.escapeXml(string);
    }

}
