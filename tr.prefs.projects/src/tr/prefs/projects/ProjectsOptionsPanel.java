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

package tr.prefs.projects;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
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

final class ProjectsOptionsPanel extends JPanel {
    
    private final ProjectsOptionsPanelController controller;
    
    ProjectsOptionsPanel(ProjectsOptionsPanelController controller) {
        this.controller = controller;
        initComponents();
        add(getView(), BorderLayout.CENTER);
    }

    private JComponent getView() {
        autoSeqCheckBox = new JCheckBox(getMsg("Pref_AutoSequence"));        
        autoSeqCheckBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                controller.changed();
            }
        });
        startDateCheckBox = new JCheckBox(getMsg("Pref_StartDate"));
        startDateCheckBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                controller.changed();
            }
        });
        dueDateCheckBox = new JCheckBox(getMsg("Pref_DueDate"));
        dueDateCheckBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                controller.changed();
            }
        });
        createDateCheckBox = new JCheckBox(getMsg("CTL_editCreateDate"));
        createDateCheckBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                controller.changed();
            }
        });

        actionStatesLabel = new JLabel(getMsg("DefaultActionState"));
        states = new Vector<ProjectsPrefs.ActionState>();
        states.add(ProjectsPrefs.ActionState.INACTIVE);
        states.add(ProjectsPrefs.ActionState.DOASAP);
        states.add(ProjectsPrefs.ActionState.SCHEDULED);
        states.add(ProjectsPrefs.ActionState.DELEGATED);
        actionStatesCombo = new JComboBox(new DefaultComboBoxModel(states));
        actionStatesCombo.setMaximumRowCount(states.size());

        JPanel panel = new JPanel(new MigLayout("", "0[]2[]0", "0[]2[]2[]2[]2[]0"));

        panel.add(autoSeqCheckBox,    "align left, span, wrap");
        panel.add(startDateCheckBox,  "align left, span, wrap");
        panel.add(dueDateCheckBox,    "align left, span, wrap");
        panel.add(createDateCheckBox, "align left, span, wrap");

        panel.add(actionStatesLabel, "align left, gapleft 8");
        panel.add(actionStatesCombo, "align left, wrap");

        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setBorder(new EmptyBorder(0,0,0,0));
        return scrollPane;
    }

    private String getMsg(String key) {
        return NbBundle.getMessage(getClass(), key);
    }

    void load() {
        autoSeqCheckBox.setSelected(ProjectsPrefs.isSequencing());
        startDateCheckBox.setSelected(ProjectsPrefs.isIncludeStartDate());
        dueDateCheckBox.setSelected(ProjectsPrefs.isIncludeDueDate());
        actionStatesCombo.setSelectedItem(ProjectsPrefs.getNewActionState());
        createDateCheckBox.setSelected(ProjectsPrefs.isEditCreateDate());
    }

    void store() {
        ProjectsPrefs.setSequencing(autoSeqCheckBox.isSelected());
        ProjectsPrefs.setIncludeStartDate(startDateCheckBox.isSelected());
        ProjectsPrefs.setIncludeDueDate(dueDateCheckBox.isSelected());
        ProjectsPrefs.setNewActionState((ProjectsPrefs.ActionState)actionStatesCombo.getSelectedItem());
        ProjectsPrefs.setEditCreateDate(createDateCheckBox.isSelected());
    }

    boolean valid() {
        return true;
    }

    private Vector<ProjectsPrefs.ActionState> states;
    private JComboBox actionStatesCombo;
    private JCheckBox autoSeqCheckBox;
    private JCheckBox dueDateCheckBox;
    private JCheckBox createDateCheckBox;
    private JLabel actionStatesLabel;
    private JCheckBox startDateCheckBox;
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(new java.awt.BorderLayout());
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
