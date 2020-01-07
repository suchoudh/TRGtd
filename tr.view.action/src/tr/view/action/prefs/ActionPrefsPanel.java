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

package tr.view.action.prefs;

import java.awt.BorderLayout;
import java.nio.charset.Charset;
import java.util.Vector;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import org.openide.util.NbBundle;

final class ActionPrefsPanel extends JPanel {
    
    private final ActionOptionsPanelController controller;
    
    ActionPrefsPanel(ActionOptionsPanelController controller) {
        this.controller = controller;
        initForm();
    }

    void load() {
        noteEmailCheckBox.setSelected(ActionPrefs.isNoteDelegateEmail());
        successCheckBox.setSelected(ActionPrefs.isShowSuccess());
        startDateCheckBox.setSelected(ActionPrefs.isShowStartDate());
        dueDateCheckBox.setSelected(ActionPrefs.isShowDueDate());
        editCreateDateCheckBox.setSelected(ActionPrefs.isEditCreateDate());
        encodingCombo.setSelectedItem(ActionPrefs.getEmailEncoding());
    }

    void store() {
        ActionPrefs.setNoteDelegateEmail(noteEmailCheckBox.isSelected());
        ActionPrefs.setShowSuccess(successCheckBox.isSelected());
        ActionPrefs.setShowStartDate(startDateCheckBox.isSelected());
        ActionPrefs.setShowDueDate(dueDateCheckBox.isSelected());
        ActionPrefs.setEditCreateDate(editCreateDateCheckBox.isSelected());
        if (isValidEncoding()) {
            ActionPrefs.setEmailEncoding(getEncoding());
        }
    }

    boolean valid() {
        return isValidEncoding();
    }

    private String getMsg(String key) {
        return NbBundle.getMessage(ActionPrefsPanel.class, key);
    }

    private void initForm() {
        initComponents();
        add(getView(), BorderLayout.CENTER);
    }

    private JComponent getView() {
        noteEmailCheckBox = new JCheckBox(getMsg("CTL_NoteEmail"));
        noteEmailCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                controller.changed();
            }
        });
        successCheckBox = new JCheckBox(getMsg("CTL_IncludeSuccess"));
        successCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                controller.changed();
            }
        });
        startDateCheckBox = new JCheckBox(getMsg("CTL_IncludeStartDate"));
        startDateCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                controller.changed();
            }
        });
        dueDateCheckBox = new JCheckBox(getMsg("CTL_IncludeDueDate"));
        dueDateCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                controller.changed();
            }
        });
        editCreateDateCheckBox = new JCheckBox(getMsg("CTL_EditCreateDate"));
        editCreateDateCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                controller.changed();
            }
        });

        encodingLabel = new JLabel(getMsg("CTL_EmailEncoding"));
        encodingCombo = new JComboBox(getEncodingModel());

        JPanel panel = new JPanel(new MigLayout("", "0[]0", "0[]2[]2[]2[]2[]2[]0"));
        panel.add(successCheckBox, "align left, wrap");
        panel.add(dueDateCheckBox, "align left, wrap");
        panel.add(startDateCheckBox, "align left, wrap");
        panel.add(editCreateDateCheckBox, "align left, wrap");
        panel.add(noteEmailCheckBox, "align left, wrap");
        panel.add(encodingLabel, "span, split 2, gapleft 6, align left");
        panel.add(encodingCombo, "align left, wrap");

        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setBorder(new EmptyBorder(0,0,0,0));
        return scrollPane;
    }

    private ComboBoxModel getEncodingModel() {
        Vector<String> encodings = new Vector<String>();
        encodings.add("");
        encodings.addAll(Charset.availableCharsets().keySet());
        return new DefaultComboBoxModel(encodings);
    }

    private boolean isValidEncoding() {
        String encoding = getEncoding();
        return encoding.length() == 0 || Charset.isSupported(encoding);
    }

    private String getEncoding() {
        String encoding = (String)encodingCombo.getSelectedItem();
        return encoding == null ? "" : encoding;
    }

    private JCheckBox successCheckBox;
    private JCheckBox dueDateCheckBox;
    private JCheckBox startDateCheckBox;
    private JCheckBox editCreateDateCheckBox;
    private JCheckBox noteEmailCheckBox;
    private JComboBox encodingCombo;
    private JLabel encodingLabel;

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(new java.awt.BorderLayout());
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
