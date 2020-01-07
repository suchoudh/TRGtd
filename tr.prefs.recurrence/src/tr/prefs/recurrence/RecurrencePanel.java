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

package tr.prefs.recurrence;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import net.miginfocom.swing.MigLayout;
import org.openide.util.NbBundle;

final class RecurrencePanel extends javax.swing.JPanel {
    
    private final RecurrenceOptionsPanelController controller;
    
    RecurrencePanel(RecurrenceOptionsPanelController controller) {
        this.controller = controller;
        initComponents();
        add(getView(), BorderLayout.CENTER);
    }

    private JComponent getView() {
        headingLabel = new JLabel(getMsg("nbr.future"));
        headingLabel.setFont(headingLabel.getFont().deriveFont(Font.BOLD));

        weekdayLabel = new JLabel(getMsg("nbr.future.weekday"));
        weekdayField = new JSpinner();
        weekdayField.addChangeListener(changeListener);

        dayLabel = new JLabel(getMsg("nbr.future.day"));
        dayField = new JSpinner();
        dayField.addChangeListener(changeListener);

        weekLabel = new JLabel(getMsg("nbr.future.week"));
        weekField = new JSpinner();
        weekField.addChangeListener(changeListener);

        monthLabel = new JLabel(getMsg("nbr.future.month"));
        monthField = new JSpinner();
        monthField.addChangeListener(changeListener);
        
        yearLabel = new JLabel(getMsg("nbr.future.year"));
        yearField = new JSpinner();
        yearField.addChangeListener(changeListener);

        JPanel panel = new JPanel(new MigLayout("", "0[]2[]2[]2[]2[]2[]0", "0[]2[]2[]0"));

        panel.add(headingLabel, "align left, span, wrap");

        panel.add(weekdayLabel, "align right, gapleft 12");
        panel.add(weekdayField, "align left, w 60!");
        panel.add(dayLabel,     "align right, gapleft 12");
        panel.add(dayField,     "align left, w 60!");
        panel.add(weekLabel,    "align right, gapleft 12");
        panel.add(weekField,    "align left, w 60!, wrap");

        panel.add(monthLabel,   "align right, gapleft 12");
        panel.add(monthField,   "align left, w 60!");
        panel.add(yearLabel,    "align right, gapleft 12");
        panel.add(yearField,    "align left, w 60!, wrap");

        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setBorder(new EmptyBorder(0,0,0,0));
        return scrollPane;
    }

    private String getMsg(String key) {
        return NbBundle.getMessage(getClass(), key);
    }

    void load() {
        weekdayField.setValue(Integer.valueOf(RecurrencePrefs.getNbrFutureWeekday()));
        dayField.setValue(Integer.valueOf(RecurrencePrefs.getNbrFutureDay()));
        weekField.setValue(Integer.valueOf(RecurrencePrefs.getNbrFutureWeek()));
        monthField.setValue(Integer.valueOf(RecurrencePrefs.getNbrFutureMonth()));
        yearField.setValue(Integer.valueOf(RecurrencePrefs.getNbrFutureYear()));
    }

    void store() {
        RecurrencePrefs.setNbrFutureWeekday(((Integer)weekdayField.getValue()).intValue());
        RecurrencePrefs.setNbrFutureDay(((Integer)dayField.getValue()).intValue());
        RecurrencePrefs.setNbrFutureWeek(((Integer)weekField.getValue()).intValue());
        RecurrencePrefs.setNbrFutureMonth(((Integer)monthField.getValue()).intValue());
        RecurrencePrefs.setNbrFutureYear(((Integer)yearField.getValue()).intValue());
    }

    boolean valid() {
        return true;
    }

    private ChangeListener changeListener = new ChangeListener() {
        public void stateChanged(ChangeEvent evt) {
            controller.changed();
        }
    };

    private JLabel dayLabel;
    private JSpinner dayField;
    private JLabel headingLabel;
    private JLabel monthLabel;
    private JSpinner monthField;
    private JLabel weekLabel;
    private JSpinner weekField;
    private JLabel weekdayLabel;
    private JSpinner weekdayField;
    private JLabel yearLabel;
    private JSpinner yearField;
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(new java.awt.BorderLayout());
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
