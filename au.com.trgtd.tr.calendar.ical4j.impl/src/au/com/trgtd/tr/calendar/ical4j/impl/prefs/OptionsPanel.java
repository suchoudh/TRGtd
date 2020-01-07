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
package au.com.trgtd.tr.calendar.ical4j.impl.prefs;

import au.com.trgtd.tr.appl.Constants;
import au.com.trgtd.tr.calendar.prefs.TimeZones;
import au.com.trgtd.tr.calendar.spi.CalendarSynchronizerOptions;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Collections;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import net.miginfocom.swing.MigLayout;
import org.openide.util.NbBundle;

/**
 * Options panel.
 *
 * @author jeremyimoore@yahoo.com.au
 */
public class OptionsPanel extends JPanel implements CalendarSynchronizerOptions {

    private boolean changed;

    public OptionsPanel() {
        initComponents();
        add(getView(), BorderLayout.CENTER);
    }

    private JComponent getView() {
        folderLabel = new JLabel(getMsg("folderLabel"));
        folderField = new JTextField();
        folderField.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent evt) {
                changed = true;
            }
            public void removeUpdate(DocumentEvent evt) {
                changed = true;
            }
            public void changedUpdate(DocumentEvent evt) {
                changed = true;
            }
        });
        folderButton = new JButton(getMsg("folderButton"));
        folderButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                browse();
            }
        });
        timezoneLabel = new JLabel(getMsg("timezoneLabel"));
        timezoneCombo = new JComboBox();
        timezoneCombo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                changed = true;
            }
        });
        JPanel panel = new JPanel(new MigLayout("", "4[]2[grow]2[]4", "4[]4"));
        panel.add(folderLabel,   "align left");
        panel.add(folderField,   "align left, growx 100");
        panel.add(folderButton,  "align left, wrap");
        panel.add(timezoneLabel, "align left");
        panel.add(timezoneCombo, "align left, wrap");
        return panel;
    }

    public boolean changed() {
        return changed;
    }

    public void load() {
        initTimeZoneItems();
        timezoneCombo.setModel(new DefaultComboBoxModel(tzlist));
        timezoneCombo.setMaximumRowCount(Constants.COMBO_MAX_ROWS);
        timezoneCombo.setSelectedItem(Options.getTimeZoneID());
        folderField.setText(Options.getICalendarPath());
        changed = false;
    }

    private static Vector<String> tzlist;

    private void initTimeZoneItems() {
        tzlist = new Vector<String>();
        tzlist.add("");
        for (String id : TimeZones.IDS) {
            tzlist.add(id);
        }
        Collections.sort(tzlist);
    }

    public void store() {
        if (isValidPath()) {
            Options.setICalendarPath(tidyPath(folderField.getText()));
        } else {
            Options.setICalendarPath("");
        }
        String tzid = (String)timezoneCombo.getSelectedItem();
        if (tzid != null) {
            Options.setTimeZoneID(tzid);
        }
        changed = false;
    }

    public JPanel getPanel() {
        return this;
    }

    public boolean valid() {
        return isValidPath();
    }

    private boolean isValidPath() {
        String path = tidyPath(folderField.getText());
        return path.length() == 0 || (new File(path)).isDirectory();
    }

    private String tidyPath(String path) {
        path = path.trim();
        while (path.endsWith(File.separator)) {
            path = path.substring(0, path.length() - 1).trim();
        }
        return path;
    }

    @Override
    public void enable(boolean b) {
        folderLabel.setEnabled(b);
        folderButton.setEnabled(b);
        folderField.setEnabled(b);
        timezoneLabel.setEnabled(b);
        timezoneCombo.setEnabled(b);
    }

    private void browse() {
        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fc.setSelectedFile(new File(folderField.getText()));
        int returnVal = fc.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            try {
                folderField.setText(fc.getSelectedFile().getCanonicalPath());
            } catch (Exception ex) {
                folderField.setText("");
            }
        }
    }

    public static String getMsg(String key) {
        return NbBundle.getMessage(OptionsPanel.class, key);
    }

    private JButton folderButton;
    private JLabel folderLabel;
    private JTextField folderField;
    private JComboBox timezoneCombo;
    private JLabel timezoneLabel;

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(new java.awt.BorderLayout());
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
