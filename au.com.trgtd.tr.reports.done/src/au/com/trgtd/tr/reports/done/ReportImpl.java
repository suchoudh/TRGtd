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
package au.com.trgtd.tr.reports.done;

import au.com.trgtd.tr.appl.Constants;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.query.JRXPathQueryExecuterFactory;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.util.JRXmlUtils;
import net.sf.jasperreports.view.JasperViewer;
import org.w3c.dom.Document;
import tr.extract.ExtractActions;
import tr.extract.Param;
import tr.extract.ParamBoolean;
import tr.extract.ParamContext;
import tr.extract.ParamDateList;
import tr.extract.ParamTopic;
import tr.extract.ParamsDialog;
import tr.model.Data;
import tr.swing.date.combo.DateItem;
import tr.util.DateUtils;

/**
 * Extract implementation.
 * 
 * @author Jeremy Moore (jimoore@netspace.net.au)
 */
public class ReportImpl extends tr.extract.Extract {

    private static final String ID = "tr.reports.actions.done";
    private static final DateFormat DF = Constants.DATE_FORMAT_FIXED;

    private ParamDateList paramDateFrom;
    private ParamDateList paramDateTo;
    private ParamBoolean paramSuccess;
    private ParamBoolean paramCriteria;
    private ParamBoolean paramProject;
    private ParamBoolean paramNotes;
    
    private ParamTopic paramTopic;
    private ParamContext paramContext;

    /** Overridden to return the report ID. */
    public String getID() {
        return ID;
    }

    /** Overridden to return the report name. */
    public String getName() {
        return getString("CTL_ReportAction");
    }

    /** Overridden to return report parameters. */
    public List<Param> getParams() {
        List<Param> params = new Vector<Param>();

        paramTopic = new ParamTopic("paramTopic", getString("param-topic"), FormatType.XML);
        params.add(paramTopic);

        paramContext = new ParamContext("paramContext", getString("param-context"), FormatType.XML);
        params.add(paramContext);
        
        List<DateItem> fromDateItems = new Vector<DateItem>();
        fromDateItems.add(DateItem.DATE_CHOOSER);
        fromDateItems.add(DateItem.TOMORROW);
        fromDateItems.add(DateItem.TODAY);
        fromDateItems.add(DateItem.YESTERDAY);
        fromDateItems.add(DateItem.WEEKS_AGO_1);
        fromDateItems.add(DateItem.WEEKS_AGO_2);
        fromDateItems.add(DateItem.WEEKS_AGO_3);
        fromDateItems.add(DateItem.WEEKS_AGO_4);
        paramDateFrom = new ParamDateList("from", getString("param-from"), fromDateItems);
        params.add(paramDateFrom);

        List<DateItem> toDateItems = new Vector<DateItem>();
        toDateItems.add(DateItem.DATE_CHOOSER);
        toDateItems.add(DateItem.YESTERDAY);
        toDateItems.add(DateItem.TODAY);
        toDateItems.add(DateItem.TOMORROW);
        toDateItems.add(DateItem.WEEKS_1);
        toDateItems.add(DateItem.WEEKS_2);
        toDateItems.add(DateItem.WEEKS_3);
        toDateItems.add(DateItem.WEEKS_4);
        paramDateTo = new ParamDateList("to", getString("param-to"), toDateItems);
        params.add(paramDateTo);

        paramCriteria = new ParamBoolean("paramCriteria", getString("param-criteria"));
        params.add(paramCriteria);
        paramSuccess = new ParamBoolean("paramSuccess", getString("param-success"));
        params.add(paramSuccess);
        paramProject = new ParamBoolean("paramProject", getString("param-project"));
        params.add(paramProject);
        paramNotes = new ParamBoolean("paramNotes", getString("param-notes"));
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

        Date dateFrom = null;
        Date dateUpTo = null;
        long n = Long.parseLong(paramDateFrom.getValue());
        if (n < 1000) {
            Calendar c = Calendar.getInstance();
            c.add(Calendar.DAY_OF_YEAR, (int) n);
            dateFrom = c.getTime();
        } else {
            dateFrom = new Date(n);
        }
        n = Long.parseLong(paramDateTo.getValue());
        if (n < 1000) {
            Calendar c = Calendar.getInstance();
            c.add(Calendar.DAY_OF_YEAR, (int) n);
            dateUpTo = c.getTime();
        } else {
            dateUpTo = new Date(n);
        }
        if (DateUtils.isSameDay(dateFrom, dateUpTo)) {
            rparams.put("paramDateRangeText", " For: " + DF.format(dateFrom));
        } else {
            rparams.put("paramDateRangeText", " From: " + DF.format(dateFrom) + "  To: " + DF.format(dateUpTo));
        }
        rparams.put("paramFrom", dateFrom.getTime());
        rparams.put("paramTo", dateUpTo.getTime());
        rparams.put("paramCriteria", Boolean.parseBoolean(paramCriteria.getValue()));
        rparams.put("paramSuccess", Boolean.parseBoolean(paramSuccess.getValue()));
        rparams.put("paramProject", Boolean.parseBoolean(paramProject.getValue()));
        rparams.put("paramNotes", Boolean.parseBoolean(paramNotes.getValue()));

        File xmlfile = getTmpFile("Actions.xml");
//      ExtractActions.process(data, xmlfile);
        ExtractActions.process(data, xmlfile, paramTopic.getValue(), paramContext.getValue());

        Document document = JRXmlUtils.parse(JRLoader.getURLInputStream(xmlfile.toURI().toString()));
        rparams.put(JRXPathQueryExecuterFactory.PARAMETER_XML_DATA_DOCUMENT, document);

        File resourcePath = Resources.FILE_RPT_ACTIONS_DONE.getParentFile();
        rparams.put("SUBREPORT_DIR", resourcePath.getPath() + File.separator);

        InputStream reportStream = new FileInputStream(Resources.FILE_RPT_ACTIONS_DONE);

        JasperPrint jasperPrint = JasperFillManager.fillReport(reportStream, rparams);

        JasperViewer.viewReport(jasperPrint, false);
    }
}
