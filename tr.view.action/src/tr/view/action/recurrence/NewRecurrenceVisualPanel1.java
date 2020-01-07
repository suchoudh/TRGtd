/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.view.action.recurrence;

import javax.swing.JPanel;
import tr.model.Data;
import tr.model.DataLookup;
import tr.model.action.Recurrence;
import tr.model.context.Context;
import tr.model.criteria.Value;
import tr.model.topic.Topic;

public final class NewRecurrenceVisualPanel1 extends JPanel {

    /** Creates new form NewRecurrenceVisualPanel1 */
    public NewRecurrenceVisualPanel1(Recurrence recurrence) {
        this.recurrence = recurrence;        
        initComponents();
        initPanel();
    }

    private final Recurrence recurrence;
    
    @Override
    public String getName() {
        return org.openide.util.NbBundle.getMessage(NewRecurrenceVisualPanel1.class, "enter.action.detail");
    }

    public void initPanel() {
        Data data = (Data)DataLookup.instance().lookup(Data.class);
        if (data == null) {
            return;
        }        
        schdHourSpinner.setVal(recurrence.getScheduleHours());
        schdMinSpinner.setVal(recurrence.getScheduleMins());
        durationHourSpinner.setVal(recurrence.getDurationHours());
        durationMinSpinner.setVal(recurrence.getDurationMins());
        projectCombo.setSelectedItem(recurrence.getProject());
        descriptionTextField.setText(recurrence.getDescription());
        successTextArea.setText(recurrence.getSuccess());
        contextsComboBox.setSelectedItem(recurrence.getContext());
        topicsComboBox.setSelectedItem(recurrence.getTopic());
        timeComboBox.setSelectedItem(recurrence.getTime());
        timeComboBox.setEnabled(data.getTimeCriterion().isUse());
        timeLabel.setEnabled(data.getTimeCriterion().isUse());
        energyComboBox.setSelectedItem(recurrence.getEnergy());
        energyComboBox.setEnabled(data.getEnergyCriterion().isUse());
        energyLabel.setEnabled(data.getEnergyCriterion().isUse());
        priorityComboBox.setSelectedItem(recurrence.getPriority());
        priorityComboBox.setEnabled(data.getPriorityCriterion().isUse());
        priorityLabel.setEnabled(data.getPriorityCriterion().isUse());
        notesEditorPane.setText(recurrence.getNotes());
        notesEditorPane.setEditable(false);
    }    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        projectLabel = new javax.swing.JLabel();
        projectCombo = new tr.view.project.combo.ProjectsComboBox();
        descriptionLabel = new javax.swing.JLabel();
        descriptionTextField = new javax.swing.JTextField();
        successLabel = new javax.swing.JLabel();
        successScrollPane = new javax.swing.JScrollPane();
        successTextArea = new javax.swing.JTextArea();
        contextLabel = new javax.swing.JLabel();
        topicLabel = new javax.swing.JLabel();
        timeLabel = new javax.swing.JLabel();
        notesLabel = new javax.swing.JLabel();
        contextsComboBox = new tr.view.contexts.ContextsComboBox();
        topicsComboBox = new tr.view.topics.TopicsComboBox();
        notesEditorPane = new tr.swing.editorpane.HyperEditorPane();
        timeComboBox = new tr.view.criteria.TimeComboBox();
        energyLabel = new javax.swing.JLabel();
        priorityLabel = new javax.swing.JLabel();
        energyComboBox = new tr.view.criteria.EnergyComboBox();
        priorityComboBox = new tr.view.criteria.PriorityComboBox();
        schdTimeLabel = new javax.swing.JLabel();
        schdHourSpinner = new tr.swing.time.HourSpinner();
        schdMinSpinner = new tr.swing.time.MinuteSpinner();
        durationLabel = new javax.swing.JLabel();
        durationHourSpinner = new tr.swing.time.HourSpinner();
        durationMinSpinner = new tr.swing.time.MinuteSpinner();

        setMaximumSize(new java.awt.Dimension(1024, 480));
        setMinimumSize(new java.awt.Dimension(640, 360));
        setPreferredSize(new java.awt.Dimension(640, 480));

        projectLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        org.openide.awt.Mnemonics.setLocalizedText(projectLabel, org.openide.util.NbBundle.getMessage(NewRecurrenceVisualPanel1.class, "project")); // NOI18N
        projectLabel.setMaximumSize(new java.awt.Dimension(100, 23));
        projectLabel.setMinimumSize(new java.awt.Dimension(100, 23));
        projectLabel.setPreferredSize(new java.awt.Dimension(100, 23));

        projectCombo.setEnabled(false);
        projectCombo.setMinimumSize(new java.awt.Dimension(480, 23));
        projectCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                projectComboActionPerformed(evt);
            }
        });

        descriptionLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        org.openide.awt.Mnemonics.setLocalizedText(descriptionLabel, org.openide.util.NbBundle.getMessage(NewRecurrenceVisualPanel1.class, "description")); // NOI18N
        descriptionLabel.setMaximumSize(new java.awt.Dimension(100, 23));
        descriptionLabel.setMinimumSize(new java.awt.Dimension(100, 23));
        descriptionLabel.setPreferredSize(new java.awt.Dimension(100, 23));

        descriptionTextField.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        descriptionTextField.setMinimumSize(new java.awt.Dimension(490, 23));
        descriptionTextField.setPreferredSize(new java.awt.Dimension(490, 23));
        descriptionTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                descriptionTextFieldFocusLost(evt);
            }
        });

        successLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        org.openide.awt.Mnemonics.setLocalizedText(successLabel, org.openide.util.NbBundle.getMessage(NewRecurrenceVisualPanel1.class, "success")); // NOI18N
        successLabel.setMaximumSize(new java.awt.Dimension(100, 23));
        successLabel.setMinimumSize(new java.awt.Dimension(100, 23));
        successLabel.setPreferredSize(new java.awt.Dimension(100, 23));

        successTextArea.setColumns(20);
        successTextArea.setRows(2);
        successTextArea.setMinimumSize(new java.awt.Dimension(490, 23));
        successTextArea.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                successTextAreaFocusLost(evt);
            }
        });
        successScrollPane.setViewportView(successTextArea);

        contextLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        org.openide.awt.Mnemonics.setLocalizedText(contextLabel, org.openide.util.NbBundle.getMessage(NewRecurrenceVisualPanel1.class, "context")); // NOI18N
        contextLabel.setMaximumSize(new java.awt.Dimension(100, 23));
        contextLabel.setMinimumSize(new java.awt.Dimension(100, 23));
        contextLabel.setPreferredSize(new java.awt.Dimension(100, 23));

        topicLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        org.openide.awt.Mnemonics.setLocalizedText(topicLabel, org.openide.util.NbBundle.getMessage(NewRecurrenceVisualPanel1.class, "topic")); // NOI18N
        topicLabel.setMaximumSize(new java.awt.Dimension(90, 23));
        topicLabel.setMinimumSize(new java.awt.Dimension(90, 23));
        topicLabel.setPreferredSize(new java.awt.Dimension(90, 23));

        timeLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        org.openide.awt.Mnemonics.setLocalizedText(timeLabel, org.openide.util.NbBundle.getMessage(NewRecurrenceVisualPanel1.class, "time")); // NOI18N
        timeLabel.setMaximumSize(new java.awt.Dimension(100, 23));
        timeLabel.setMinimumSize(new java.awt.Dimension(100, 23));
        timeLabel.setPreferredSize(new java.awt.Dimension(100, 23));

        notesLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        org.openide.awt.Mnemonics.setLocalizedText(notesLabel, org.openide.util.NbBundle.getMessage(NewRecurrenceVisualPanel1.class, "notes")); // NOI18N
        notesLabel.setMaximumSize(new java.awt.Dimension(100, 23));
        notesLabel.setMinimumSize(new java.awt.Dimension(100, 23));
        notesLabel.setPreferredSize(new java.awt.Dimension(100, 23));

        contextsComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contextsComboBoxActionPerformed(evt);
            }
        });

        topicsComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                topicsComboBoxActionPerformed(evt);
            }
        });

        notesEditorPane.setMinimumSize(new java.awt.Dimension(490, 42));
        notesEditorPane.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                notesEditorPaneFocusLost(evt);
            }
        });

        timeComboBox.setMaximumSize(new java.awt.Dimension(120, 23));
        timeComboBox.setMinimumSize(new java.awt.Dimension(120, 23));
        timeComboBox.setPreferredSize(new java.awt.Dimension(120, 23));
        timeComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timeComboBoxActionPerformed(evt);
            }
        });

        energyLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        org.openide.awt.Mnemonics.setLocalizedText(energyLabel, org.openide.util.NbBundle.getMessage(NewRecurrenceVisualPanel1.class, "energy")); // NOI18N
        energyLabel.setMaximumSize(new java.awt.Dimension(50, 23));
        energyLabel.setMinimumSize(new java.awt.Dimension(50, 23));
        energyLabel.setPreferredSize(new java.awt.Dimension(50, 23));

        priorityLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        org.openide.awt.Mnemonics.setLocalizedText(priorityLabel, org.openide.util.NbBundle.getMessage(NewRecurrenceVisualPanel1.class, "priority")); // NOI18N
        priorityLabel.setMaximumSize(new java.awt.Dimension(50, 23));
        priorityLabel.setMinimumSize(new java.awt.Dimension(50, 23));
        priorityLabel.setPreferredSize(new java.awt.Dimension(50, 23));

        energyComboBox.setMaximumSize(new java.awt.Dimension(120, 23));
        energyComboBox.setMinimumSize(new java.awt.Dimension(120, 23));
        energyComboBox.setPreferredSize(new java.awt.Dimension(120, 23));
        energyComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                energyComboBoxActionPerformed(evt);
            }
        });

        priorityComboBox.setMaximumSize(new java.awt.Dimension(120, 23));
        priorityComboBox.setMinimumSize(new java.awt.Dimension(120, 23));
        priorityComboBox.setPreferredSize(new java.awt.Dimension(120, 23));
        priorityComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priorityComboBoxActionPerformed(evt);
            }
        });

        schdTimeLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        org.openide.awt.Mnemonics.setLocalizedText(schdTimeLabel, org.openide.util.NbBundle.getMessage(NewRecurrenceVisualPanel1.class, "schedule.time")); // NOI18N
        schdTimeLabel.setMaximumSize(new java.awt.Dimension(100, 23));
        schdTimeLabel.setMinimumSize(new java.awt.Dimension(100, 23));
        schdTimeLabel.setPreferredSize(new java.awt.Dimension(100, 23));

        schdHourSpinner.setMaximumSize(new java.awt.Dimension(50, 23));
        schdHourSpinner.setMinimumSize(new java.awt.Dimension(50, 23));
        schdHourSpinner.setPreferredSize(new java.awt.Dimension(50, 23));
        schdHourSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                schdHourSpinnerStateChanged(evt);
            }
        });

        schdMinSpinner.setMaximumSize(new java.awt.Dimension(50, 23));
        schdMinSpinner.setMinimumSize(new java.awt.Dimension(50, 23));
        schdMinSpinner.setPreferredSize(new java.awt.Dimension(50, 23));
        schdMinSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                schdMinSpinnerStateChanged(evt);
            }
        });

        durationLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        org.openide.awt.Mnemonics.setLocalizedText(durationLabel, org.openide.util.NbBundle.getMessage(NewRecurrenceVisualPanel1.class, "schedule.duration")); // NOI18N
        durationLabel.setMaximumSize(new java.awt.Dimension(70, 23));
        durationLabel.setMinimumSize(new java.awt.Dimension(70, 23));
        durationLabel.setPreferredSize(new java.awt.Dimension(70, 23));

        durationHourSpinner.setMaximumSize(new java.awt.Dimension(50, 23));
        durationHourSpinner.setMinimumSize(new java.awt.Dimension(50, 23));
        durationHourSpinner.setPreferredSize(new java.awt.Dimension(50, 23));
        durationHourSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                durationHourSpinnerStateChanged(evt);
            }
        });

        durationMinSpinner.setMaximumSize(new java.awt.Dimension(50, 23));
        durationMinSpinner.setMinimumSize(new java.awt.Dimension(50, 23));
        durationMinSpinner.setPreferredSize(new java.awt.Dimension(50, 23));
        durationMinSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                durationMinSpinnerStateChanged(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(schdTimeLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(projectLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(descriptionLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(successLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(contextLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(timeLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(notesLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(contextsComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 193, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(topicLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 48, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(topicsComboBox, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE))
                    .add(layout.createSequentialGroup()
                        .add(schdHourSpinner, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(0, 0, 0)
                        .add(schdMinSpinner, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(durationLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(durationHourSpinner, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(0, 0, 0)
                        .add(durationMinSpinner, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(projectCombo, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
                    .add(descriptionTextField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
                    .add(successScrollPane, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
                    .add(notesEditorPane, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
                    .add(layout.createSequentialGroup()
                        .add(timeComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(energyLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(energyComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(priorityLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(priorityComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        layout.linkSize(new java.awt.Component[] {contextsComboBox, topicsComboBox}, org.jdesktop.layout.GroupLayout.HORIZONTAL);

        layout.linkSize(new java.awt.Component[] {contextLabel, descriptionLabel, notesLabel, projectLabel, schdTimeLabel, successLabel, timeLabel}, org.jdesktop.layout.GroupLayout.HORIZONTAL);

        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(schdTimeLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(schdHourSpinner, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(schdMinSpinner, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(durationLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(durationHourSpinner, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(durationMinSpinner, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(projectLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(projectCombo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(descriptionLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(descriptionTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(successLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(successScrollPane, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(contextLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(contextsComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(topicLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(topicsComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(timeLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(timeComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(energyLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(energyComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(priorityLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(priorityComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(notesLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(notesEditorPane, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE))
                .addContainerGap())
        );

        layout.linkSize(new java.awt.Component[] {contextLabel, descriptionLabel, notesLabel, projectLabel, schdTimeLabel, successLabel, timeLabel}, org.jdesktop.layout.GroupLayout.VERTICAL);

    }// </editor-fold>//GEN-END:initComponents
    
    private void contextsComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contextsComboBoxActionPerformed
        recurrence.setContext((Context) contextsComboBox.getSelectedItem());
}//GEN-LAST:event_contextsComboBoxActionPerformed

    private void schdHourSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_schdHourSpinnerStateChanged
        recurrence.setScheduleHours(schdHourSpinner.getVal());
    }//GEN-LAST:event_schdHourSpinnerStateChanged

    private void schdMinSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_schdMinSpinnerStateChanged
        recurrence.setScheduleMins(schdMinSpinner.getVal());
    }//GEN-LAST:event_schdMinSpinnerStateChanged

    private void durationHourSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_durationHourSpinnerStateChanged
        recurrence.setDurationHours(durationHourSpinner.getVal());
    }//GEN-LAST:event_durationHourSpinnerStateChanged

    private void durationMinSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_durationMinSpinnerStateChanged
        recurrence.setDurationMins(durationMinSpinner.getVal());
    }//GEN-LAST:event_durationMinSpinnerStateChanged

    private void projectComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_projectComboActionPerformed
//      recurrence.setProject((Project) projectCombo.getSelectedItem());
    }//GEN-LAST:event_projectComboActionPerformed

    private void descriptionTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_descriptionTextFieldFocusLost
        recurrence.setDescription(descriptionTextField.getText());
    }//GEN-LAST:event_descriptionTextFieldFocusLost

    private void successTextAreaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_successTextAreaFocusLost
        recurrence.setSuccess(successTextArea.getText());
    }//GEN-LAST:event_successTextAreaFocusLost

    private void topicsComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_topicsComboBoxActionPerformed
        recurrence.setTopic((Topic) topicsComboBox.getSelectedItem());
    }//GEN-LAST:event_topicsComboBoxActionPerformed

    private void timeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timeComboBoxActionPerformed
        recurrence.setTime((Value) timeComboBox.getSelectedItem());
    }//GEN-LAST:event_timeComboBoxActionPerformed

    private void energyComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_energyComboBoxActionPerformed
        recurrence.setEnergy((Value) energyComboBox.getSelectedItem());
    }//GEN-LAST:event_energyComboBoxActionPerformed

    private void priorityComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priorityComboBoxActionPerformed
        recurrence.setPriority((Value) priorityComboBox.getSelectedItem());
    }//GEN-LAST:event_priorityComboBoxActionPerformed

    private void notesEditorPaneFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_notesEditorPaneFocusLost
        recurrence.setNotes(notesEditorPane.getText());
    }//GEN-LAST:event_notesEditorPaneFocusLost

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel contextLabel;
    private tr.view.contexts.ContextsComboBox contextsComboBox;
    private javax.swing.JLabel descriptionLabel;
    private javax.swing.JTextField descriptionTextField;
    private tr.swing.time.HourSpinner durationHourSpinner;
    private javax.swing.JLabel durationLabel;
    private tr.swing.time.MinuteSpinner durationMinSpinner;
    private tr.view.criteria.EnergyComboBox energyComboBox;
    private javax.swing.JLabel energyLabel;
    private tr.swing.editorpane.HyperEditorPane notesEditorPane;
    private javax.swing.JLabel notesLabel;
    private tr.view.criteria.PriorityComboBox priorityComboBox;
    private javax.swing.JLabel priorityLabel;
    private tr.view.project.combo.ProjectsComboBox projectCombo;
    private javax.swing.JLabel projectLabel;
    private tr.swing.time.HourSpinner schdHourSpinner;
    private tr.swing.time.MinuteSpinner schdMinSpinner;
    private javax.swing.JLabel schdTimeLabel;
    private javax.swing.JLabel successLabel;
    private javax.swing.JScrollPane successScrollPane;
    private javax.swing.JTextArea successTextArea;
    private tr.view.criteria.TimeComboBox timeComboBox;
    private javax.swing.JLabel timeLabel;
    private javax.swing.JLabel topicLabel;
    private tr.view.topics.TopicsComboBox topicsComboBox;
    // End of variables declaration//GEN-END:variables
    
}

