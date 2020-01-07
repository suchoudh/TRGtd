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

package tr.extract.exports.actions;

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
        return "actions-xml";
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
        List<Item> uptoItems = new Vector<Item>();
        uptoItems.add(new Item(getString("today"), "today"));
        uptoItems.add(new Item(getString("tomorrow"), "tomorrow"));
        uptoItems.add(new Item(getString("one-week"), "one-week"));
        uptoItems.add(new Item(getString("two-weeks"), "two-weeks"));
        uptoItems.add(new Item(getString("three-weeks"), "three-weeks"));
        uptoItems.add(new Item(getString("four-weeks"), "four-weeks"));  
        uptoItems.add(new Item(getString("latest"), "latest"));          
        params.add(new ParamList("upto", getString("param-upto"), uptoItems));
        params.add(new ParamBoolean("include-done", getString("param-include-done")));
        params.add(new ParamBoolean("include-inactive", getString("param-include-inactive")));
        params.add(new ParamBoolean("include-doasap", getString("param-include-doasap")));
        params.add(new ParamBoolean("include-scheduled", getString("param-include-scheduled")));
        params.add(new ParamBoolean("include-delegated", getString("param-include-delegated")));        
        List<Item> dateFormatItems = new Vector<Item>();
        dateFormatItems.add(new Item("YYYYMMDDhhmmss", "f1"));
        dateFormatItems.add(new Item("DAY DD MMM YYYY hh:mm:ss", "f2"));
        params.add(new ParamList("date-format", getString("param-date-format"), dateFormatItems));        
        List<Item> fieldItems = new Vector<Item>();
        fieldItems.add(new Item("", "none"));
        fieldItems.add(new Item(getString("field-key"), "field-key"));
        fieldItems.add(new Item(getString("field-desc"), "field-desc"));
        fieldItems.add(new Item(getString("field-notes"), "field-notes"));
        fieldItems.add(new Item(getString("field-created"), "field-created"));
        fieldItems.add(new Item(getString("field-done"), "field-done"));
        fieldItems.add(new Item(getString("field-done-date"), "field-done-date"));
        fieldItems.add(new Item(getString("field-thought-key"), "field-thought-key"));
        fieldItems.add(new Item(getString("field-thought-desc"), "field-thought-desc"));
        fieldItems.add(new Item(getString("field-parent-key"), "field-parent-key"));
        fieldItems.add(new Item(getString("field-parent-desc"), "field-parent-desc"));
        fieldItems.add(new Item(getString("field-topic-key"), "field-topic-key"));
        fieldItems.add(new Item(getString("field-topic-desc"), "field-topic-desc"));
        fieldItems.add(new Item(getString("field-context-key"), "field-context-key"));
        fieldItems.add(new Item(getString("field-context-desc"), "field-context-desc"));
        fieldItems.add(new Item(getString("field-state"), "field-state"));
        fieldItems.add(new Item(getString("field-action-date"), "field-action-date"));
        fieldItems.add(new Item(getString("field-scheduled-datetime"), "field-scheduled-datetime"));
        fieldItems.add(new Item(getString("field-scheduled-duration"), "field-scheduled-duration"));
        fieldItems.add(new Item(getString("field-delegated-to"), "field-delegated-to"));        
        fieldItems.add(new Item(getString("field-success"), "field-success"));
        fieldItems.add(new Item(getString("field-start-date"), "field-start-date"));
        fieldItems.add(new Item(getString("field-due-date"), "field-due-date"));
        fieldItems.add(new Item(getString("field-time"), "field-time"));
        fieldItems.add(new Item(getString("field-energy"), "field-energy"));
        fieldItems.add(new Item(getString("field-priority"), "field-priority"));  
        fieldItems.add(new Item(getString("field-project-path"), "field-project-path"));
        
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
        params.add(new ParamList("field-20", getString("param-field-20"), fieldItems));        
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
        
        URL xslURL = getClass().getResource("actions-xml.xsl");
        File outfile = getOutFile("actions-" + getTimeStamp() + ".xml");
        String encoding = ExtractPrefs.getEncoding();                  
        
        transformXSL(xmlfile, xslURL, params, outfile, encoding, true);
        
        openTextFile(outfile);
    }
    
}
