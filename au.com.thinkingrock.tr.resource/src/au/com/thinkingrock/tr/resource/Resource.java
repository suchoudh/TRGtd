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
package au.com.thinkingrock.tr.resource;

import java.net.URL;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileStateInvalidException;
import org.openide.filesystems.FileSystem;
import org.openide.filesystems.Repository;
import org.openide.util.Exceptions;

/**
 * ThinkingRock resources.

 * @author <a href="mailto:jimoore@netspace.net.au">Jeremy Moore</a>
 */
public class Resource {

    public final static String PATH = "au/com/thinkingrock/tr/resource/icons/";

    // Collect
    public final static String Collect = PATH + "Collect.png";
    public final static String Thought = PATH + "Thought.png";
    public final static String ThoughtAdd = PATH + "ThoughtAdd.png";
    public final static String ThoughtDelete = PATH + "ThoughtDelete.png";
    public final static String ThoughtEdit = PATH + "ThoughtEdit.png";
    // Action
    public final static String ActionDoASAP = PATH + "ActionDoASAP.png";
    public final static String ActionInactive = PATH + "ActionInactive.png";
    public final static String ActionDelegated = PATH + "ActionDelegated.png";
    public final static String ActionScheduled = PATH + "ActionScheduled.png";
    public final static String ActionScheduledReg = PATH + "ActionScheduledReg.png";
    public final static String ActionScheduledSub = PATH + "ActionScheduledSub.png";
    public final static String Actions = PATH + "Actions.png";
    public final static String ActionAdd = PATH + "ActionAdd.png";

    // Project
    public final static String Project = PATH + "Project.png";
    public final static String ProjectWarn = PATH + "ProjectWarn.png";
    public final static String ProjectOpen = PATH + "ProjectOpen.png";
    public final static String ProjectOpenWarn = PATH + "ProjectOpenWarn.png";
    public final static String ProjectAdd = PATH + "ProjectAdd.png";
    public final static String Projectise = PATH + "Projectise.png";
    public final static String Projects = PATH + "Projects.png";
    public final static String ProjectsTemplate = PATH + "ProjectsTemplate.png";
    public final static String ProjectTemplate = PATH + "ProjectTemplate.png";
    public final static String ProjectTemplateOpen = PATH + "ProjectTemplateOpen.png";
    public final static String ProjectsFuture = PATH + "ProjectsFuture.png";
    public final static String ProjectFuture = PATH + "ProjectFuture.png";
    public final static String ProjectFutureOpen = PATH + "ProjectFutureOpen.png";
    public final static String SingleActions = PATH + "SingleActions.png";
    // Reference
    public final static String References = PATH + "References.png";
    public final static String Reference = PATH + "Reference.png";
    public final static String ReferenceEdit = PATH + "ReferenceEdit.png";
    public final static String ReferenceDelete = PATH + "ReferenceDelete.png";
    // Someday/Maybe
    public final static String SomedayMaybes = PATH + "SomedayMaybes.png";
    public final static String SomedayMaybe = PATH + "SomedayMaybe.png";
    public final static String SomedayMaybeEdit = PATH + "SomedayMaybeEdit.png";
    public final static String SomedayMaybeDelete = PATH + "SomedayMaybeDelete.png";

    // Process
    public final static String Process = PATH + "Process.png";
    public final static String ProcessThoughts = PATH + "ProcessThoughts.png";
    public final static String Reprocess = PATH + "Reprocess.png";
    // Context
    public final static String Contexts = PATH + "Contexts.png";
    public final static String Context = PATH + "Context.png";
    public final static String ContextAdd = PATH + "ContextAdd.png";
    public final static String ContextDelete = PATH + "ContextDelete.png";
    public final static String ContextEdit = PATH + "ContextEdit.png";

    // Topic
    public final static String Topics = PATH + "Topics.png";
    public final static String Topic = PATH + "Topic.png";
    public final static String TopicAdd = PATH + "TopicAdd.png";
    public final static String TopicDelete = PATH + "TopicDelete.png";
    public final static String TopicEdit = PATH + "TopicEdit.png";
    // Criteria
    public final static String Criteria = PATH + "Criteria.png";
    // Misc
    public final static String PDF = PATH + "PDF.png";
    public final static String Report = PATH + "Report.gif";
    public final static String FiltersEdit = PATH + "FiltersEdit.png";
    public final static String FiltersView = PATH + "FiltersView.png";
    public final static String ColumnsEdit = PATH + "ColumnsEdit.png";
    public final static String ShowDone = PATH + "ShowDone.png";
    public final static String Up = PATH + "Up.png";
    public final static String Down = PATH + "Down.png";
    public final static String Add = PATH + "Add.png";
    public final static String Edit = PATH + "Edit.png";
    public final static String Delete = PATH + "Delete.png";
    public final static String Trash = PATH + "Trash.gif";
    public final static String Archive = PATH + "Archive.gif";
    public final static String Text = PATH + "Text.gif";
    public final static String XML = PATH + "XML.gif";
    public final static String Web = PATH + "Web.png";
    public final static String SortAZ = PATH + "SortAZ.png";
    public final static String SortZA = PATH + "SortZA.png";
    public final static String ZoomIn = PATH + "ZoomIn.png";
    public final static String ZoomOut = PATH + "ZoomOut.png";
    public final static String CheckBox = PATH + "CheckBox.png";
    public final static String CalendarEdit = PATH + "CalendarEdit.png";
    // Help
    public final static String CSHelp = PATH + "CSHelp.png";
    // Data
    public final static String DataNew = PATH + "DataNew.png";
    public final static String DataSave = PATH + "DataSave.png";
    public final static String DataSaveAs = PATH + "DataSaveAs.png";
    public final static String DataSaveTo = PATH + "DataSaveTo.png";
    public final static String DataOpen = PATH + "DataOpen.png";
    // Overview
    public final static String Overview = PATH + "Overview.png";

    public final static URL getOverviewURL() {
        try {
            FileSystem sfs = Repository.getDefault().getDefaultFileSystem();
            FileObject fo = sfs.findResource("Overview/overview.svg");
            return fo.getURL();
        } catch (FileStateInvalidException ex) {
            Exceptions.printStackTrace(ex);
            return null;
        }
    }

}
