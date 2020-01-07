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

package au.com.trgtd.tr.extract.projects;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import tr.extract.Extract;
import tr.extract.Param;
import tr.extract.Param.Item;
import tr.extract.ParamBoolean;
import tr.extract.ParamContext;
import tr.extract.ParamList;
import tr.extract.ParamTopic;
import tr.extract.ParamsDialog;
import tr.extract.prefs.ExtractPrefs;
import tr.model.Data;

/**
 * Export to an XML file extract implementation.
 *
 * @author Jeremy Moore (jimoore@netspace.net.au)
 */
public class ExportXML extends Extract {
    
    /** Overridden to return the extract ID. */
    public String getID() {
        return "au.com.trgtd.tr.extract.projects.ExportXML";
    }
    
    /** Overridden to return the export name. */
    public String getName() {
        return getString("CTL_ExportXMLAction");
    }
    
    /** Overridden to return report parameters. */
    public List<Param> getParams() {
        List<Param> params = new Vector<Param>();        
        params.add(new ParamTopic("topic", getString("param-topic"), FormatType.XML));
        params.add(new ParamContext("context", getString("param-context"), FormatType.XML, false));
        params.add(new ParamBoolean("include-done", getString("param-include-done")));
        params.add(new ParamBoolean("include-inactive", getString("param-include-inactive")));
        params.add(new ParamBoolean("include-doasap", getString("param-include-doasap")));
        params.add(new ParamBoolean("include-scheduled", getString("param-include-scheduled")));
        params.add(new ParamBoolean("include-delegated", getString("param-include-delegated")));        
        List<Item> dateFormatItems = new Vector<Item>();
        dateFormatItems.add(new Item("YYYYMMDDhhmmss", "f1"));
        dateFormatItems.add(new Item("DAY DD MMM YYYY hh:mm:ss", "f2"));
        params.add(new ParamList("date-format", getString("param-date-format"), dateFormatItems));        
        
        List<Item> pFieldItems = new Vector<Item>();
        pFieldItems.add(new Item("", "none"));
        pFieldItems.add(new Item(getString("p-created-date"), "p-field-created"));
        pFieldItems.add(new Item(getString("p-thought-desc"), "p-field-thought-desc"));
        pFieldItems.add(new Item(getString("p-topic-desc"), "p-field-topic-desc"));
        pFieldItems.add(new Item(getString("p-desc"), "p-field-desc"));
        pFieldItems.add(new Item(getString("p-purpose"), "p-field-purpose"));
        pFieldItems.add(new Item(getString("p-success"), "p-field-success"));
        pFieldItems.add(new Item(getString("p-brainstorming"), "p-field-brainstorming"));
        pFieldItems.add(new Item(getString("p-organising"), "p-field-organising"));
        pFieldItems.add(new Item(getString("p-notes"), "p-field-notes"));
        pFieldItems.add(new Item(getString("p-done"), "p-field-done"));
        pFieldItems.add(new Item(getString("p-done-date"), "p-field-done-date"));
        pFieldItems.add(new Item(getString("p-start-date"), "p-field-start-date"));
        pFieldItems.add(new Item(getString("p-due-date"), "p-field-due-date"));

        params.add(new ParamList("p-field-1", getString("param-p-field-1"), pFieldItems));
        params.add(new ParamList("p-field-2", getString("param-p-field-2"), pFieldItems));
        params.add(new ParamList("p-field-3", getString("param-p-field-3"), pFieldItems));
        params.add(new ParamList("p-field-4", getString("param-p-field-4"), pFieldItems));
        params.add(new ParamList("p-field-5", getString("param-p-field-5"), pFieldItems));
        params.add(new ParamList("p-field-6", getString("param-p-field-6"), pFieldItems));
        params.add(new ParamList("p-field-7", getString("param-p-field-7"), pFieldItems));
        params.add(new ParamList("p-field-8", getString("param-p-field-8"), pFieldItems));
        params.add(new ParamList("p-field-9", getString("param-p-field-9"), pFieldItems));
        params.add(new ParamList("p-field-10", getString("param-p-field-10"), pFieldItems));
        params.add(new ParamList("p-field-11", getString("param-p-field-11"), pFieldItems));
        params.add(new ParamList("p-field-12", getString("param-p-field-12"), pFieldItems));
        params.add(new ParamList("p-field-13", getString("param-p-field-13"), pFieldItems));
        
        List<Item> fieldItems = new Vector<Item>();
        fieldItems.add(new Item("", "none"));
        fieldItems.add(new Item(getString("desc"), "field-desc"));
        fieldItems.add(new Item(getString("notes"), "field-notes"));
        fieldItems.add(new Item(getString("created-date"), "field-created"));
        fieldItems.add(new Item(getString("done"), "field-done"));
        fieldItems.add(new Item(getString("done-date"), "field-done-date"));
        fieldItems.add(new Item(getString("thought-desc"), "field-thought-desc"));
        fieldItems.add(new Item(getString("topic-desc"), "field-topic-desc"));
        fieldItems.add(new Item(getString("context-desc"), "field-context-desc"));
        fieldItems.add(new Item(getString("status"), "field-state"));
        fieldItems.add(new Item(getString("action-date"), "field-action-date"));
        fieldItems.add(new Item(getString("scheduled-datetime"), "field-scheduled-datetime"));
        fieldItems.add(new Item(getString("scheduled-duration"), "field-scheduled-duration"));
        fieldItems.add(new Item(getString("delegated-to"), "field-delegated-to"));        
        fieldItems.add(new Item(getString("success"), "field-success"));
        fieldItems.add(new Item(getString("start-date"), "field-start-date"));
        fieldItems.add(new Item(getString("due-date"), "field-due-date"));
        fieldItems.add(new Item(getString("time"), "field-time"));
        fieldItems.add(new Item(getString("energy"), "field-energy"));
        fieldItems.add(new Item(getString("priority"), "field-priority"));                
        
        params.add(new ParamList("field-1", getString("param-field-1"), fieldItems));
        params.add(new ParamList("field-2", getString("param-field-2"), fieldItems));
        params.add(new ParamList("field-3", getString("param-field-3"), fieldItems));
        params.add(new ParamList("field-4", getString("param-field-4"), fieldItems));
        params.add(new ParamList("field-5", getString("param-field-5"), fieldItems));
        params.add(new ParamList("field-6", getString("param-field-6"), fieldItems));
        params.add(new ParamList("field-7", getString("param-field-7"), fieldItems));
        params.add(new ParamList("field-8", getString("param-field-8"), fieldItems));
        params.add(new ParamList("field-9", getString("param-field-9"), fieldItems));
        params.add(new ParamList("field-10", getString("param-field-10"), fieldItems));
        params.add(new ParamList("field-11", getString("param-field-11"), fieldItems));
        params.add(new ParamList("field-12", getString("param-field-12"), fieldItems));
        params.add(new ParamList("field-13", getString("param-field-13"), fieldItems));
        params.add(new ParamList("field-14", getString("param-field-14"), fieldItems));
        params.add(new ParamList("field-15", getString("param-field-15"), fieldItems));
        params.add(new ParamList("field-16", getString("param-field-16"), fieldItems));
        params.add(new ParamList("field-17", getString("param-field-17"), fieldItems));        
        params.add(new ParamList("field-18", getString("param-field-18"), fieldItems));        
        params.add(new ParamList("field-19", getString("param-field-19"), fieldItems));        
        return params;
    }
    
    /** Overriden to process the report. */
    public void process(Data data) throws Exception {
        
        List<Param> params = getParams();
        
        // show dialog for parameters
        String title = getDialogTitleExport(getName());
        ParamsDialog dlg = new ParamsDialog(title, getID(), params);
        if (dlg.showDialog() == JOptionPane.CANCEL_OPTION) {
            return;
        }
        
        File xmlfile = getTmpFile("data.xml");
        extractData(data, xmlfile, FormatType.XML);
        
        URL xslURL = getClass().getResource("projects-xml.xsl");
        File outfile = getOutFile("projects-" + getTimeStamp() + ".xml");
        String encoding = ExtractPrefs.getEncoding();                  
        
        transformXSL(xmlfile, xslURL, params, outfile, encoding, true);
        
        openTextFile(outfile);
    }
    
}
