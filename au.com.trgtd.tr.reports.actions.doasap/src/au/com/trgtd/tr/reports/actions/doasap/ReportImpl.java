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
package au.com.trgtd.tr.reports.actions.doasap;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRXmlDataSource;
import net.sf.jasperreports.view.JasperViewer;
import tr.extract.ExtractActions;
import tr.extract.Param;
import tr.extract.Param.Item;
import tr.extract.ParamBoolean;
import tr.extract.ParamContext;
import tr.extract.ParamList;
import tr.extract.ParamsDialog;
import tr.model.Data;

/**
 * Extract implementation.
 * 
 * @author Jeremy Moore (jimoore@netspace.net.au)
 */
public class ReportImpl extends tr.extract.Extract {

//    private static final Logger LOG = Logger.getLogger("au.com.trgtd.tr.reports");
    private ParamList paramGroup;    
    private ParamContext paramContext;
    private ParamBoolean paramSuccess;
    private ParamBoolean paramCriteria;
    private ParamBoolean paramProject;
    private ParamBoolean paramNotes;

    /** Overridden to return the report ID. */
    public String getID() {
        return "tr.reports.actions.doasap";
    }

    /** Overridden to return the report name. */
    public String getName() {
        return getString("CTL_ReportAction");
    }

    /** Overridden to return report parameters. */
    public List<Param> getParams() {        
        List<Item> groupItems = new Vector<Item>();
        groupItems.add(new Item(getString("param-group-context-only"), "context-only"));
        groupItems.add(new Item(getString("param-group-context-time"), "context-time"));
        groupItems.add(new Item(getString("param-group-context-energy"),"context-energy"));
        groupItems.add(new Item(getString("param-group-context-priority"),"context-priority"));        
        paramGroup = new ParamList("group", getString("param-group"), groupItems);
        paramContext = new ParamContext("paramContext", getString("param-context"), FormatType.XML);
        paramCriteria = new ParamBoolean("paramCriteria", getString("param-criteria"));
        paramSuccess = new ParamBoolean("paramSuccess", getString("param-success"));
        paramProject = new ParamBoolean("paramProject", getString("param-project"));
        paramNotes = new ParamBoolean("paramNotes", getString("param-notes"));
        List<Param> params = new Vector<Param>();
        params.add(paramGroup);
        params.add(paramContext);
        params.add(paramCriteria);
        params.add(paramSuccess);
        params.add(paramProject);
        params.add(paramNotes);
        return params;
    }

    /** Overriden to process the report. */
    public void process(Data data) throws Exception {
        String title = getDialogTitleReport(getName());
        ParamsDialog dlg = new ParamsDialog(title, getID(), getParams());
        if (dlg.showDialog() == JOptionPane.CANCEL_OPTION) {
            return;
        }
        Map<String, Object> rparams = new HashMap<String, Object>();        
        rparams.put("paramContext", paramContext.getValue());                
        rparams.put("paramCriteria", Boolean.parseBoolean(paramCriteria.getValue()));                
        rparams.put("paramSuccess", Boolean.parseBoolean(paramSuccess.getValue()));                
        rparams.put("paramProject", Boolean.parseBoolean(paramProject.getValue()));                
        rparams.put("paramNotes", Boolean.parseBoolean(paramNotes.getValue()));                
        
        String groupBy = paramGroup.getValue();        

        InputStream reportStream;
        if (groupBy.equals("context-time")) {
            reportStream = new FileInputStream(Resources.FILE_DOASAP_BY_CONTEXT_AND_TIME);
        } else if (groupBy.equals("context-energy")) {
            reportStream = new FileInputStream(Resources.FILE_DOASAP_BY_CONTEXT_AND_ENERGY);
        } else if (groupBy.equals("context-priority")) {
            reportStream = new FileInputStream(Resources.FILE_DOASAP_BY_CONTEXT_AND_PRIORITY);
        } else {
            reportStream = new FileInputStream(Resources.FILE_DOASAP_BY_CONTEXT);            
        }
        
        File xmlfile = getTmpFile("Actions.xml");
        ExtractActions.process(data, xmlfile);
                            
        JRXmlDataSource xmlDataSource = new JRXmlDataSource(xmlfile, "/data/actions/action");        
        
        JasperPrint jasperPrint = JasperFillManager.fillReport(reportStream, rparams, xmlDataSource);

        JasperViewer.viewReport(jasperPrint, false);
    }
    
}
