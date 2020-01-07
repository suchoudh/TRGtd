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
package au.com.trgtd.tr.reports.actions.scheduled;

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
import net.sf.jasperreports.engine.data.JRXmlDataSource;
import net.sf.jasperreports.view.JasperViewer;
import tr.extract.ExtractActions;
import tr.extract.Param;
import tr.extract.ParamBoolean;
import tr.extract.ParamDateList;
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

    private static final String ID = "tr.reports.actions.scheduled";
    private static final DateFormat DF = Constants.DATE_FORMAT_FIXED;

//    private enum FromDateType {
//
//        EARLIEST(),
//        WEEKS_AGO_4(),
//        WEEKS_AGO_3(),
//        WEEKS_AGO_2(),
//        WEEKS_AGO_1(),
//        YESTERDAY(),
//        TODAY(),
//        TOMORROW();
//
//        public Long getTime() {
//            switch (this) {
//                case EARLIEST:
//                    return Long.valueOf(0);
//                case WEEKS_AGO_4:
//                    return getTime(-28);
//                case WEEKS_AGO_3:
//                    return getTime(-21);
//                case WEEKS_AGO_2:
//                    return getTime(-14);
//                case WEEKS_AGO_1:
//                    return getTime(-7);
//                case YESTERDAY:
//                    return getTime(-1);
//                case TODAY:
//                    return getTime(0);
//                case TOMORROW:
//                    return getTime(1);
//                default:
//                    return getTime(0);
//            }
//        }
//
//        private Long getTime(int daysDifference) {
//            Calendar calendar = Calendar.getInstance();
//            calendar.add(Calendar.DAY_OF_YEAR, daysDifference);
//            return Long.valueOf(DateUtils.getStart(calendar.getTime()).getTime());
//        }
//    }
//
//    private enum ToDateType {
//
//        YESTERDAY(),
//        TODAY(),
//        TOMORROW(),
//        WEEKS_AHEAD_1(),
//        WEEKS_AHEAD_2(),
//        WEEKS_AHEAD_3(),
//        WEEKS_AHEAD_4(),
//        LATEST();
//
//        public Long getTime() {
//            switch (this) {
//                case YESTERDAY:
//                    return getTime(-1);
//                case TODAY:
//                    return getTime(0);
//                case TOMORROW:
//                    return getTime(1);
//                case WEEKS_AHEAD_1:
//                    return getTime(7);
//                case WEEKS_AHEAD_2:
//                    return getTime(14);
//                case WEEKS_AHEAD_3:
//                    return getTime(21);
//                case WEEKS_AHEAD_4:
//                    return getTime(28);
//                case LATEST:
//                    return Long.MAX_VALUE;
//                default:
//                    return getTime(0);
//            }
//        }
//
//        private Long getTime(int daysDifference) {
//            Calendar calendar = Calendar.getInstance();
//            calendar.add(Calendar.DAY_OF_YEAR, daysDifference);
//            return Long.valueOf(DateUtils.getEnd(calendar.getTime()).getTime());
//        }
//    }

//    private ParamList paramFrom;
//    private ParamList paramTo;
    private ParamDateList paramDateFrom;
    private ParamDateList paramDateTo;

    private ParamBoolean paramSuccess;
    private ParamBoolean paramCriteria;
    private ParamBoolean paramProject;
    private ParamBoolean paramNotes;

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
    
//        List<Item> fromItems = new Vector<Item>();
//        fromItems.add(new Item("tomorrow", FromDateType.TOMORROW.getTime().toString()));
//        fromItems.add(new Item("today", FromDateType.TODAY.getTime().toString()));
//        fromItems.add(new Item("yesterday", FromDateType.YESTERDAY.getTime().toString()));
//        fromItems.add(new Item("one week ago", FromDateType.WEEKS_AGO_1.getTime().toString()));
//        fromItems.add(new Item("two weeks ago", FromDateType.WEEKS_AGO_2.getTime().toString()));
//        fromItems.add(new Item("three weeks ago", FromDateType.WEEKS_AGO_3.getTime().toString()));
//        fromItems.add(new Item("four weeks ago", FromDateType.WEEKS_AGO_4.getTime().toString()));
//        fromItems.add(new Item("the earliest", FromDateType.EARLIEST.getTime().toString()));
//        paramFrom = new ParamList("from", getString("param-from"), fromItems);
//        params.add(paramFrom);
//        List<Item> toItems = new Vector<Item>();
//        toItems.add(new Item("yesterday", ToDateType.YESTERDAY.getTime().toString()));
//        toItems.add(new Item("today", ToDateType.TODAY.getTime().toString()));
//        toItems.add(new Item("tomorrow", ToDateType.TOMORROW.getTime().toString()));
//        toItems.add(new Item("one week ahead", ToDateType.WEEKS_AHEAD_1.getTime().toString()));
//        toItems.add(new Item("two weeks ahead", ToDateType.WEEKS_AHEAD_2.getTime().toString()));
//        toItems.add(new Item("three weeks ahead", ToDateType.WEEKS_AHEAD_3.getTime().toString()));
//        toItems.add(new Item("four weeks ahead", ToDateType.WEEKS_AHEAD_4.getTime().toString()));
//        toItems.add(new Item("the latest", ToDateType.LATEST.getTime().toString()));
//        paramTo = new ParamList("to", getString("param-to"), toItems);
//        params.add(paramTo);
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

//    private String getDateText(Long time) {
//        if (time == 0) {
//            return "the earliest";
//        }
//        if (time == Long.MAX_VALUE) {
//            return "the latest";
//        }
//        return DF.format(new Date(time));
//    }
    
    /** Overriden to process the report. */
    public void process(Data data) throws Exception {
        String title = getDialogTitleReport(getName());
        ParamsDialog dlg = new ParamsDialog(title, getID(), getParams());
        if (dlg.showDialog() == JOptionPane.CANCEL_OPTION) {
            return;
        }
        Map<String, Object> rparams = new HashMap<String, Object>();
                
//        Long timeFrom = Long.parseLong(paramFrom.getValue());
//        Long timeUpTo = Long.parseLong(paramTo.getValue());
//        Date dateFrom = new Date(timeFrom);
//        Date dateUpTo = new Date(timeUpTo);
//        if (DateUtils.isSameDay(dateFrom, dateUpTo)) {
//            rparams.put("paramDateRangeText", " For: " + getDateText(timeFrom));
//        } else {
//            rparams.put("paramDateRangeText", " From: " + getDateText(timeFrom) + "  To: " + getDateText(timeUpTo));
//        }
//        rparams.put("paramFrom", Long.parseLong(paramFrom.getValue()));
//        rparams.put("paramTo", Long.parseLong(paramTo.getValue()));
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

        InputStream reportStream = new FileInputStream(Resources.FILE_RPT_SCHEDULED);            

        File xmlfile = getTmpFile("Actions.xml");
        ExtractActions.process(data, xmlfile);

        JRXmlDataSource xmlDataSource = new JRXmlDataSource(xmlfile, "/data/actions/action");
        JasperPrint jasperPrint = JasperFillManager.fillReport(reportStream, rparams, xmlDataSource);
        JasperViewer.viewReport(jasperPrint, false);
    }

}
