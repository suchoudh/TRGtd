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
package au.com.trgtd.tr.report.projects.future;

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
import tr.extract.ExtractProjectOutline;
import tr.extract.Param;
import tr.extract.Param.Item;
import tr.extract.ParamBoolean;
import tr.extract.ParamList;
import tr.extract.ParamTopic;
import tr.extract.ParamsDialog;
import tr.model.Data;
import tr.model.project.Project;

/**
 * Extract implementation.
 * 
 * @author Jeremy Moore (jimoore@netspace.net.au)
 */
public class ReportImpl extends tr.extract.Extract {

//  private static final Logger LOG = Logger.getLogger("au.com.trgtd.tr.reports");
    
    private ParamTopic paramTopic;
    private ParamBoolean paramActions;
    private ParamList paramSort;

    /** Overridden to return the report ID. */
    public String getID() {
        return "au.com.trgtd.tr.report.projects.future";
    }

    /** Overridden to return the report name. */
    public String getName() {
        return getString("CTL_ReportAction");
    }

    /** Overridden to return report parameters. */
    public List<Param> getParams() {        
        paramTopic = new ParamTopic("paramTopic", getString("param-topic"), FormatType.XML);        
        paramActions = new ParamBoolean("paramActions", getString("param-actions"));        
        List<Item> sortItems = new Vector<Item>();
        sortItems.add(new Item(getString("param-sort-none"), "none"));
        sortItems.add(new Item(getString("param-sort-descr"), "descr"));
        sortItems.add(new Item(getString("param-sort-priority"), "priority"));
        sortItems.add(new Item(getString("param-sort-date"), "date"));
        paramSort = new ParamList("paramSort", getString("param-sort"), sortItems);                
        List<Param> params = new Vector<Param>();
        params.add(paramTopic);
        params.add(paramActions);
        params.add(paramSort);
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
        rparams.put("paramTopic", paramTopic.getValue());        
        if (!paramSort.getValue().equals("none")) {
            rparams.put("paramSortText", getString("param-sort-" + paramSort.getValue()));                                    
        }

        InputStream reportStream = new FileInputStream(Resources.FILE_REPORT);
        
        File xmlfile = getTmpFile("FutureProjects.xml");
        
        List<Project> projects = data.getRootFutures().getChildren(Project.class);
        
        boolean includeActions = Boolean.parseBoolean(paramActions.getValue());
        
        ExtractProjectOutline.process(xmlfile, projects, paramTopic.getValue(), "all", "all", includeActions, paramSort.getValue());
                            
        JRXmlDataSource xmlDataSource = new JRXmlDataSource(xmlfile, "/data/item");        
        
        JasperPrint jasperPrint = JasperFillManager.fillReport(reportStream, rparams, xmlDataSource);

        JasperViewer.viewReport(jasperPrint, false);
    }

//    public void process(List<Project> projects) throws Exception {
//        Map<String, Object> rparams = new HashMap<String, Object>();        
//        rparams.put("paramTopic", "all");                        
//
//        InputStream reportStream = new FileInputStream(Resources.FILE_REPORT);
//        
//        File xmlfile = getTmpFile("FutureProjects.xml");
//        
//        ExtractProjectOutline.process(xmlfile, projects, "all", "all", "all", true);
//                            
//        JRXmlDataSource xmlDataSource = new JRXmlDataSource(xmlfile, "/data/item");        
//        
//        JasperPrint jasperPrint = JasperFillManager.fillReport(reportStream, rparams, xmlDataSource);
//
//        JasperViewer.viewReport(jasperPrint, false);
//    }    
    
}
