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
package tr.view.project;

import tr.swing.mig.MTextArea;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.net.URL;
import java.util.prefs.PreferenceChangeEvent;
import java.util.prefs.PreferenceChangeListener;
import javax.swing.ComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.DocumentListener;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import net.miginfocom.swing.MigLayout;
import org.openide.util.Lookup;
import org.openide.util.LookupEvent;
import org.openide.util.LookupListener;
import org.openide.util.NbBundle;
import org.openide.windows.WindowManager;
import tr.model.Data;
import tr.model.DataLookup;
import tr.model.criteria.Value;
import tr.model.project.Project;
import tr.model.project.Sequencing;
import tr.model.topic.Topic;
import tr.prefs.projects.ProjectsPrefs;
import tr.swing.TRComboBox;
import tr.swing.TRLabel;
import tr.swing.TRTextField;
import tr.swing.date.field.DateField;
import tr.swing.document.LazyDocumentListener;
import tr.swing.editorpane.HyperEditorPane;
import tr.util.Observable;
import tr.util.Observer;
import tr.util.Utils;
import tr.view.ViewUtils;
import tr.view.criteria.PriorityComboBoxModel;
import tr.view.topics.TopicsComboBox;
import tr.view.topics.TopicsComboBoxModel;

/**
 * Project panel.
 *
 * @author Jeremy Moore
 */
public final class ProjectPanel extends JPanel { // implements Observer {

    /** Constructs a new instance. */
    public ProjectPanel() {
        super();
        initComponents();
        initPanel();
        initModel(null);
        result = DataLookup.instance().lookup(new Lookup.Template(Data.class));
        result.addLookupListener(new LookupListener() {

            public void resultChanged(LookupEvent lookupEvent) {
                dataChanged();
            }
        });
        dataChanged();
    }

    private void dataChanged() {
        Data data = this.getData();
        if (data == null) {
            return;
        }
        if (observerCriterion == null) {
            observerCriterion = new Observer() {

                public void update(Observable observable, Object arguement) {
                    showHideCriteria();
                }
            };
        }
        getData().getPriorityCriterion().addObserver(observerCriterion);
    }

    private Data getData() {
        return (Data) DataLookup.instance().lookup(Data.class);
    }

    @Override
    public void addNotify() {
        super.addNotify();
        addListeners();
    }

    @Override
    public void removeNotify() {
        removeListeners();
        super.removeNotify();
    }

    /** Start editing the current action if possible. */
    public void edit() {
        descriptionText.requestFocusInWindow();
    }

    private ComboBoxModel getPriorityComboBoxModel() {
        return new PriorityComboBoxModel();
    }

    private void descriptionTextFocusGained(FocusEvent evt) {
        if (descriptionText.getText().equals(DEFAULT_DESCRIPTION)) {
            descriptionText.setSelectionStart(0);
            descriptionText.setSelectionEnd(DEFAULT_DESCRIPTION.length());
        }
    }

    private void topicComboActionPerformed(ActionEvent evt) {
        if (updating || project == null) {
            return;
        }
        TRComboBox combo = (TRComboBox) evt.getSource();

        project.setTopic((Topic) combo.getSelectedItem());
    }

    private void priorityComboActionPerformed(java.awt.event.ActionEvent evt) {
        if (updating || project == null) {
            return;
        }
        project.setPriority((Value) priorityCombo.getSelectedItem());
    }

    private void sequencingComboActionPerformed(ActionEvent evt) {
        if (updating || project == null) {
            return;
        }
        project.setSequenceType((Sequencing) sequencingCombo.getSelectedItem());
    }

    private void sequencingCheckBoxActionPerformed(ActionEvent evt) {
        if (updating || project == null) {
            return;
        }
        project.setSequencing(sequencingCheckBox.isSelected());

        sequencingCombo.setEnabled(sequencingCheckBox.isSelected());
    }

    private void completedCheckBoxActionPerformed(ActionEvent evt) {
        if (updating || project == null) {
            return;
        }
        if (doneCheckBox.isSelected() && !project.canSetDone(true)) {
            doneCheckBox.setSelected(false);
            String t = "";
            String m = org.openide.util.NbBundle.getMessage(ProjectPanel.class, "message.can.not.set.done");
            Component p = WindowManager.getDefault().getMainWindow();
            JOptionPane.showMessageDialog(p, m, t, JOptionPane.WARNING_MESSAGE);
        } else {
            project.setDone(doneCheckBox.isSelected());
            doneDateField.setDate(project.getDoneDate());
        }
        doneDateField.setEnabled(project.isDone());
    }

    private void changedCreatedDate() {
        if (updating || project == null) {
            return;
        }
        project.setCreated(createdDateField.getDate());
    }

    private void changedStartDate() {
        if (updating || project == null) {
            return;
        }
        project.setStartDate(startDateField.getDate());
    }

    private void changedDueDate() {
        if (updating || project == null) {
            return;
        }
        project.setDueDate(dueDateField.getDate());
    }

    private void changedCompletedDate() {
        if (updating || project == null) {
            return;
        }
        project.setDoneDate(doneDateField.getDate());
    }

    private void notesEditorPaneHyperlinkAction(HyperlinkEvent evt) {
        URL url = evt.getURL();
        if (url == null) {
            return;
        }
        if (evt.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
            tr.runtime.Open.open(url);
        }
    }

    private void addListeners() {

        prefsChangeListener = new PreferenceChangeListener() {
            public void preferenceChange(PreferenceChangeEvent arg0) {
                changedPrefs();
            }
        };
        ProjectsPrefs.prefs.addPreferenceChangeListener(prefsChangeListener);

        docListenerDescription = new LazyDocumentListener() {
            public void update() {
                changedDescription();
            }
        };
        descriptionText.getDocument().addDocumentListener(docListenerDescription);

        actionListenerPriorityCombo = new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                priorityComboActionPerformed(evt);
            }
        };
        priorityCombo.addActionListener(actionListenerPriorityCombo);

        docListenerPurpose = new LazyDocumentListener() {

            public void update() {
                changedPurpose();
            }
        };
        purposeTextArea.getDocument().addDocumentListener(docListenerPurpose);

        docListenerBrainstorm = new LazyDocumentListener() {

            public void update() {
                changedBrainstorm();
            }
        };
        brainstormTextArea.getDocument().addDocumentListener(docListenerBrainstorm);

        docListenerOrganise = new LazyDocumentListener() {

            public void update() {
                changedOrganise();
            }
        };
        organiseTextArea.getDocument().addDocumentListener(docListenerOrganise);

        docListenerVision = new LazyDocumentListener() {

            public void update() {
                changedVision();
            }
        };
        visionTextArea.getDocument().addDocumentListener(docListenerVision);

        docListenerNotes = new LazyDocumentListener() {

            public void update() {
                changedNotes();
            }
        };
        notesEditorPane.addDocumentListener(docListenerNotes);

        focusAdapterDescription = new FocusAdapter() {

            @Override
            public void focusGained(FocusEvent evt) {
                descriptionTextFocusGained(evt);
            }
        };
        descriptionText.addFocusListener(focusAdapterDescription);

        actionListenerTopic = new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                topicComboActionPerformed(evt);
            }
        };
        topicCombo.addActionListener(actionListenerTopic);

        actionListenerSequencingCombo = new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                sequencingComboActionPerformed(evt);
            }
        };
        sequencingCombo.addActionListener(actionListenerSequencingCombo);

        actionListenerSequencingCheckBox = new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                sequencingCheckBoxActionPerformed(evt);
            }
        };
        sequencingCheckBox.addActionListener(actionListenerSequencingCheckBox);

        createdDatePropertyChangeListener = new PropertyChangeListener() {

            public void propertyChange(PropertyChangeEvent e) {
                changedCreatedDate();
            }
        };
        createdDateField.addPropertyChangeListener("value", createdDatePropertyChangeListener);

        startDatePropertyChangeListener = new PropertyChangeListener() {

            public void propertyChange(PropertyChangeEvent e) {
                changedStartDate();
            }
        };
        startDateField.addPropertyChangeListener("value", startDatePropertyChangeListener);

        dueDatePropertyChangeListener = new PropertyChangeListener() {

            public void propertyChange(PropertyChangeEvent e) {
                changedDueDate();
            }
        };
        dueDateField.addPropertyChangeListener("value", dueDatePropertyChangeListener);

        actionListenerCompletedCheckBox = new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                completedCheckBoxActionPerformed(evt);
            }
        };
        doneCheckBox.addActionListener(actionListenerCompletedCheckBox);

        completedDatePropertyChangeListener = new PropertyChangeListener() {

            public void propertyChange(PropertyChangeEvent e) {
                changedCompletedDate();
            }
        };
        doneDateField.addPropertyChangeListener("value", completedDatePropertyChangeListener);

        hyperlinkListener = new HyperlinkListener() {

            public void hyperlinkUpdate(HyperlinkEvent evt) {
                notesEditorPaneHyperlinkAction(evt);
            }
        };
        notesEditorPane.addHyperlinkListener(hyperlinkListener);
    }

    private void removeListeners() {
        ProjectsPrefs.prefs.removePreferenceChangeListener(prefsChangeListener);
        prefsChangeListener = null;
        descriptionText.getDocument().removeDocumentListener(docListenerDescription);
        purposeTextArea.getDocument().removeDocumentListener(docListenerPurpose);
        brainstormTextArea.getDocument().removeDocumentListener(docListenerBrainstorm);
        organiseTextArea.getDocument().removeDocumentListener(docListenerOrganise);
        visionTextArea.getDocument().removeDocumentListener(docListenerVision);
        notesEditorPane.removeDocumentListener(docListenerNotes);
        descriptionText.removeFocusListener(focusAdapterDescription);
        topicCombo.removeActionListener(actionListenerTopic);
        sequencingCombo.removeActionListener(actionListenerSequencingCombo);
        sequencingCheckBox.removeActionListener(actionListenerSequencingCheckBox);
        createdDateField.removePropertyChangeListener(createdDatePropertyChangeListener);
        createdDatePropertyChangeListener = null;
        startDateField.removePropertyChangeListener(startDatePropertyChangeListener);
        startDatePropertyChangeListener = null;
        dueDateField.removePropertyChangeListener(dueDatePropertyChangeListener);
        dueDatePropertyChangeListener = null;
        doneCheckBox.removeActionListener(actionListenerCompletedCheckBox);
        actionListenerSequencingCheckBox = null;
        doneDateField.removePropertyChangeListener(completedDatePropertyChangeListener);
        completedDatePropertyChangeListener = null;
        notesEditorPane.removeHyperlinkListener(hyperlinkListener);
        priorityCombo.removeActionListener(actionListenerPriorityCombo);
        docListenerDescription = null;
        docListenerPurpose = null;
        docListenerVision = null;
        docListenerBrainstorm = null;
        docListenerOrganise = null;
        docListenerNotes = null;
        focusAdapterDescription = null;
        actionListenerTopic = null;
        actionListenerSequencingCombo = null;
        actionListenerCompletedCheckBox = null;
        hyperlinkListener = null;
        actionListenerPriorityCombo = null;
    }

    /**
     * Gets the initialised data model.
     * @return The current project or null if there is none.
     */
    public Project getModel() {
        return project;
    }

    /**
     * Initialises the project data model and view.
     * @param project The project data model.
     */
    public void initModel(Project project) {
        if (Utils.equal(this.project, project)) {
            return;
        }

        if (this.project != null) {
//          this.project.removeObserver(this);
            this.project.removePropertyChangeListenter(Project.PROP_DONE, doneListener);
            this.project.removePropertyChangeListenter(Project.PROP_DESCR, descrListener);
            this.project.removePropertyChangeListenter(Project.PROP_TOPIC, topicListener);
        }

        this.project = project;

        if (this.project != null) {
//          this.project.addObserver(this);
            this.project.addPropertyChangeListenter(Project.PROP_DONE, doneListener);
            this.project.addPropertyChangeListenter(Project.PROP_DESCR, descrListener);
            this.project.addPropertyChangeListenter(Project.PROP_TOPIC, topicListener);
        }
        initView();
    }

    /* Initialises the view form field values for the data model. */
    private void initView() {
        updating = true;
        if (project == null) {
            descriptionText.setText("");
            topicCombo.setSelectedItem(null);
            priorityCombo.setSelectedItem(null);
            purposeTextArea.setText("");
            visionTextArea.setText("");
            brainstormTextArea.setText("");
            organiseTextArea.setText("");
            notesEditorPane.setText("");
            sequencingCheckBox.setSelected(false);
            sequencingCombo.setSelectedItem(null);
            startDateField.setDate(null);
            dueDateField.setDate(null);
            createdDateField.setDate(null);
            doneCheckBox.setSelected(false);
            doneDateField.setDate(null);
            setEnabled(false);
        } else {
            descriptionText.setText(project.getDescription());
            topicCombo.setSelectedItem(project.getTopic());
            priorityCombo.setSelectedItem(project.getPriority());
            purposeTextArea.setText(project.getPurpose());
            visionTextArea.setText(project.getVision());
            brainstormTextArea.setText(project.getBrainstorming());
            organiseTextArea.setText(project.getOrganising());
            notesEditorPane.setText(project.getNotes());
            boolean sequence = ProjectsPrefs.isSequencing();
            sequencingCheckBox.setVisible(sequence);
            sequencingCombo.setVisible(sequence);
            sequencingCheckBox.setSelected(project.isSequencing());
            sequencingCombo.setSelectedItem(project.getSequenceType());
            startDateField.setDate(project.getStartDate());
            dueDateField.setDate(project.getDueDate());
            createdDateField.setDate(project.getCreated());
            doneCheckBox.setSelected(project.isDone());
            doneDateField.setDate(project.getDoneDate());
            setEnabled(true);
        }
        updating = false;
    }

    /** Override to enable/disable fields. */
    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        descriptionLabel.setEnabled(enabled);
        descriptionText.setEnabled(enabled);
        topicLabel.setEnabled(enabled);
        topicCombo.setEnabled(enabled);
        purposeLabel.setEnabled(enabled);
        purposeTextArea.setEnabled(enabled);
        visionLabel.setEnabled(enabled);
        visionTextArea.setEnabled(enabled);
        brainstormLabel.setEnabled(enabled);
        brainstormTextArea.setEnabled(enabled);
        organiseLabel.setEnabled(enabled);
        organiseTextArea.setEnabled(enabled);
        notesLabel.setEnabled(enabled);
        notesEditorPane.setEnabled(enabled);
        notesEditorPane.setEditable(false);
        createdDateLabel.setEnabled(enabled);
        createdDateField.setEnabled(enabled && ProjectsPrefs.isEditCreateDate());

        startDateLabel.setEnabled(enabled);
        startDateField.setEnabled(enabled);
        startDateLabel.setVisible(ProjectsPrefs.isIncludeStartDate());
        startDateField.setVisible(ProjectsPrefs.isIncludeStartDate());
        dueDateLabel.setEnabled(enabled);
        dueDateField.setEnabled(enabled);
        dueDateLabel.setVisible(ProjectsPrefs.isIncludeDueDate());
        dueDateField.setVisible(ProjectsPrefs.isIncludeDueDate());
        sequencingCheckBox.setEnabled(enabled);
        sequencingCombo.setEnabled(enabled && project.isSequencing());

        doneCheckBox.setEnabled(enabled);
        doneDateField.setEnabled(enabled && project.canSetDone(true));
        priorityLabel.setEnabled(enabled);
        priorityCombo.setEnabled(enabled);
        showHideCriteria();

        changedPrefs();
    }

    private void showHideCriteria() {
        Data data = getData();
        priorityLabel.setVisible(data.getPriorityCriterion().isUse());
        priorityCombo.setVisible(data.getPriorityCriterion().isUse());
    }

    public void focus() {
        descriptionText.requestFocus();
    }

    private void changedPrefs() {
        removeAll();
        JPanel panel = createPanel();
        add(panel, BorderLayout.CENTER);
        panel.revalidate();
        panel.repaint();
    }

    private void changedDescription() {
        if (updating || project == null) {
            return;
        }
        project.setDescription(descriptionText.getText());
    }

    private void changedPurpose() {
        if (updating || project == null) {
            return;
        }
        project.setPurpose(purposeTextArea.getText());
    }

    private void changedVision() {
        if (updating || project == null) {
            return;
        }
        project.setVision(visionTextArea.getText());
    }

    private void changedBrainstorm() {
        if (updating || project == null) {
            return;
        }
        project.setBrainstorming(brainstormTextArea.getText());
    }

    private void changedOrganise() {
        if (updating || project == null) {
            return;
        }
        project.setOrganising(organiseTextArea.getText());
    }

    private void changedNotes() {
        if (updating || project == null) {
            return;
        }
        project.setNotes(notesEditorPane.getText());
    }
    /** Action description changes. */
    private final PropertyChangeListener descrListener = new PropertyChangeListener() {

        public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
            if (descriptionText.hasFocus()) {
                return; // assume caused by user input to this panel

            }
            if (!descriptionText.getText().equals(project.getDescription())) {
                descriptionText.setText(project.getDescription());
            }
        }
    };
    /** Project topic listener. */
    private final PropertyChangeListener topicListener = new PropertyChangeListener() {

        public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
            if (topicCombo.hasFocus()) {
                return; // assume caused by user input to this panel

            }
            if (!Utils.equal(project.getTopic(), topicCombo.getSelectedItem())) {
                topicCombo.setSelectedItem(project.getTopic());
            }

        }
    };
    /** Project done listener. */
    private final PropertyChangeListener doneListener = new PropertyChangeListener() {

        public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
            if (doneCheckBox.isSelected() != project.isDone()) {
                doneCheckBox.setSelected(project.isDone());
                doneDateField.setDate(project.getDoneDate());
                doneDateField.setEnabled(project.canSetDone(true));
            }
        }
    };

    private void initPanel() {
        descriptionLabel = new TRLabel();
        descriptionLabel.setText(NbBundle.getMessage(ProjectPanel.class, "ProjectPanel.description")); // NOI18N
        descriptionText = new TRTextField();
        topicLabel = new TRLabel();
        topicLabel.setText(NbBundle.getMessage(ProjectPanel.class, "ProjectPanel.topic")); // NOI18N
        topicsModel = new TopicsComboBoxModel(false);
        topicCombo = new TopicsComboBox(topicsModel);
        priorityLabel = new TRLabel();
        priorityLabel.setText(NbBundle.getMessage(ProjectPanel.class, "LBL_Priority")); // NOI18N
        priorityCombo = new TRComboBox();
        priorityCombo.setModel(getPriorityComboBoxModel());
        sequencingCheckBox = new JCheckBox();
        sequencingCheckBox.setHorizontalTextPosition(JCheckBox.LEFT);
        sequencingCheckBox.setText(NbBundle.getMessage(ProjectPanel.class, "ProjectPanel.sequencing")); // NOI18N
        sequencingCombo = new TRComboBox();
        sequencingCombo.setModel(new SequencingModel());
        dueDateLabel = new TRLabel();
        dueDateLabel.setText(NbBundle.getMessage(ProjectPanel.class, "ProjectPanel.due")); // NOI18N
        dueDateField = new DateField();
        startDateLabel = new TRLabel();
        startDateLabel.setText(NbBundle.getMessage(ProjectPanel.class, "ProjectPanel.start")); // NOI18N
        startDateField = new DateField();
        purposeLabel = new TRLabel();
        purposeLabel.setText(NbBundle.getMessage(ProjectPanel.class, "ProjectPanel.purpose")); // NOI18N
        purposeTextArea = new MTextArea();
        visionLabel = new TRLabel();
        visionLabel.setText(NbBundle.getMessage(ProjectPanel.class, "ProjectPanel.vision")); // NOI18N
        visionTextArea = new MTextArea();
        brainstormLabel = new TRLabel();
        brainstormLabel.setText(NbBundle.getMessage(ProjectPanel.class, "ProjectPanel.brainstorming")); // NOI18N
        brainstormTextArea = new MTextArea();
        organiseLabel = new TRLabel();
        organiseLabel.setText(NbBundle.getMessage(ProjectPanel.class, "ProjectPanel.organising")); // NOI18N
        organiseTextArea = new MTextArea();
        notesLabel = new TRLabel();
        notesLabel.setText(NbBundle.getMessage(ProjectPanel.class, "ProjectPanel.notes")); // NOI18N
        notesEditorPane = new HyperEditorPane();
        notesEditorPane.setMinimumSize(new Dimension(50, 62));
        notesEditorPane.setPreferredSize(new Dimension(50, 62));

        doneCheckBox = new JCheckBox();
        doneCheckBox.setHorizontalTextPosition(JCheckBox.LEFT);
        doneCheckBox.setText(NbBundle.getMessage(ProjectPanel.class, "ProjectPanel.completed")); // NOI18N
        doneDateField = new DateField();
        createdDateLabel = new TRLabel();
        createdDateLabel.setText(NbBundle.getMessage(ProjectPanel.class, "ProjectPanel.created")); // NOI18N
        createdDateField = new DateField();

        add(createPanel(), BorderLayout.CENTER);
    }

    private MigLayout layoutA1 = new MigLayout(getMIGCons(), "2[]4[grow]4[]4[]4[]4[]2", "2[]2[]2[]2[]2[]2[]2[]2[]2[]2[]2[grow]2[]2[]2");
    private MigLayout layoutA2 = new MigLayout(getMIGCons(), "2[]4[grow]4[]4[]4[]4[]2", "2[]2[]2[]2[]2[]2[]2[]2[]2[grow]2[]2[]2");
    private MigLayout layoutM1 = new MigLayout(getMIGCons(), "2[]4[grow]4[]4[]4[]4[]2", "2[top]2[top]2[center]2[top]2[center]2[top]2[top]2[top]2[top]2[center]2[grow]2[center]2[top]2");
    private MigLayout layoutM2 = new MigLayout(getMIGCons(), "2[]4[grow]4[]4[]4[]4[]2", "2[top]2[top]2[center]2[top]2[top]2[top]2[top]2[center]2[grow]2[center]2[top]2");

    private JPanel createPanel() {
        
        JComponent[][] includedOptionalComponents = new JComponent[3][2];
        int includedOptionalComponentsCount = 0;
        if (ProjectsPrefs.isIncludeDueDate()) {
            includedOptionalComponents[includedOptionalComponentsCount][0] = dueDateLabel;
            includedOptionalComponents[includedOptionalComponentsCount][1] = dueDateField;
            includedOptionalComponentsCount++;
        }
        if (ProjectsPrefs.isIncludeStartDate()) {
            includedOptionalComponents[includedOptionalComponentsCount][0] = startDateLabel;
            includedOptionalComponents[includedOptionalComponentsCount][1] = startDateField;
            includedOptionalComponentsCount++;
        }
        if (ProjectsPrefs.isSequencing()) {
            includedOptionalComponents[includedOptionalComponentsCount][0] = sequencingCheckBox;
            includedOptionalComponents[includedOptionalComponentsCount][1] = sequencingCombo;
            includedOptionalComponentsCount++;
        }

        JPanel panel;
        if (includedOptionalComponentsCount > 0) {
            panel = ViewUtils.isAquaLaF() ? new JPanel(layoutA1) : new JPanel(layoutM1);
        } else {
            panel = ViewUtils.isAquaLaF() ? new JPanel(layoutA2) : new JPanel(layoutM2);
        }

        panel.add(descriptionLabel, "align right");
        panel.add(descriptionText, "span, growx 100, wrap");

        panel.add(topicLabel, "align right");
        panel.add(topicCombo, "split 3, align left");
        panel.add(priorityLabel, "align left");
        panel.add(priorityCombo, "align left, wrap");

        ViewUtils.addSeparator(panel);

        if (includedOptionalComponentsCount > 0) {
            for (int i = 0; i < includedOptionalComponentsCount; i++) {
                includedOptionalComponents[i][0].setVisible(true);
                includedOptionalComponents[i][0].setEnabled(true);
                includedOptionalComponents[i][1].setVisible(true);
                includedOptionalComponents[i][1].setEnabled(true);
            }
            if (includedOptionalComponentsCount == 1) {
                panel.add(includedOptionalComponents[0][0], "align right");
                panel.add(includedOptionalComponents[0][1], "align left, wrap");
            } else if (includedOptionalComponentsCount == 2) {
                panel.add(includedOptionalComponents[0][0], "align right");
                panel.add(includedOptionalComponents[0][1], "align left, split 3");
                panel.add(includedOptionalComponents[1][0], "align left");
                panel.add(includedOptionalComponents[1][1], "align left, wrap");
            } else if (includedOptionalComponentsCount == 3) {
                panel.add(includedOptionalComponents[0][0], "align right");
                panel.add(includedOptionalComponents[0][1], "align left, split 5");
                panel.add(includedOptionalComponents[1][0], "align left");
                panel.add(includedOptionalComponents[1][1], "align left");
                panel.add(includedOptionalComponents[2][0], "align left");
                panel.add(includedOptionalComponents[2][1], "align left, wrap");
            }
            ViewUtils.addSeparator(panel);
        }

        if (ViewUtils.isAquaLaF()) {
            panel.add(purposeLabel, "align right");
            panel.add(purposeTextArea, "gapleft 3, gapright 3, span, growx 100, growy 0, wrap");
            panel.add(visionLabel, "align right");
            panel.add(visionTextArea, "gapleft 3, gapright 3, span, growx 100, growy 0, wrap");
            panel.add(brainstormLabel, "align right");
            panel.add(brainstormTextArea, "gapleft 3, gapright 3, span, growx 100, growy 0, wrap");
            panel.add(organiseLabel, "align right");
            panel.add(organiseTextArea, "gapleft 3, gapright 3, span, growx 100, growy 0, wrap");
        } else {
            panel.add(purposeLabel, "align right");
            panel.add(purposeTextArea, "span, growx 100, growy 0, wrap");
            panel.add(visionLabel, "align right");
            panel.add(visionTextArea, "span, growx 100, growy 0, wrap");
            panel.add(brainstormLabel, "align right");
            panel.add(brainstormTextArea, "span, growx 100, growy 0, wrap");
            panel.add(organiseLabel, "align right");
            panel.add(organiseTextArea, "span, growx 100, growy 0, wrap");
        }

        ViewUtils.addSeparator(panel);

        if (ViewUtils.isAquaLaF()) {
            panel.add(notesLabel, "align right top, gaptop 4, growy 0");
            panel.add(notesEditorPane, "span, gapleft 3, gapright 3, align left, grow, wrap");
        } else {
            panel.add(notesLabel, "align right top, growy 0");
            panel.add(notesEditorPane, "span, align left, grow, wrap");
        }

        ViewUtils.addSeparator(panel);

        panel.add(doneCheckBox, "align right");
        panel.add(doneDateField, "align left, split 3");
        panel.add(createdDateLabel, "align left");
        panel.add(createdDateField, "align left, wrap");

        return panel;
    }

    private String getMIGCons() {
        return DEBUG_MIG_LAYOUT ? "debug" : "";
    }

    private String getMIGCons(String c) {
        assert (c != null && c.trim().length() > 0);

        return DEBUG_MIG_LAYOUT ? "debug, " + c : c;
    }

    private static final boolean DEBUG_MIG_LAYOUT = false;

//  private static final Logger LOG = Logger.getLogger("tr.view.project");
    private final static String DEFAULT_DESCRIPTION = NbBundle.getMessage(ProjectPanel.class, "new.project");
    private TRLabel descriptionLabel;
    private TRTextField descriptionText;
    private TRLabel topicLabel;
    private TRComboBox topicCombo;
    private TRLabel priorityLabel;
    private TRComboBox priorityCombo;
    private JCheckBox sequencingCheckBox;
    private TRComboBox sequencingCombo;
    private TRLabel dueDateLabel;
    private DateField dueDateField;
    private TRLabel startDateLabel;
    private DateField startDateField;
    private TRLabel purposeLabel;
    private MTextArea purposeTextArea;
    private TRLabel visionLabel;
    private MTextArea visionTextArea;
    private TRLabel brainstormLabel;
    private MTextArea brainstormTextArea;
    private TRLabel organiseLabel;
    private MTextArea organiseTextArea;
    private TRLabel notesLabel;
    private HyperEditorPane notesEditorPane;
    private JCheckBox doneCheckBox;
    private DateField doneDateField;
    private TRLabel createdDateLabel;
    private DateField createdDateField;
    private Lookup.Result result;
    private Project project;
    private ComboBoxModel topicsModel;
    private boolean updating;
    private DocumentListener docListenerDescription;
    private DocumentListener docListenerPurpose;
    private DocumentListener docListenerVision;
    private DocumentListener docListenerBrainstorm;
    private DocumentListener docListenerOrganise;
    private DocumentListener docListenerNotes;
    private FocusAdapter focusAdapterDescription;
    private ActionListener actionListenerTopic;
    private ActionListener actionListenerPriorityCombo;
    private ActionListener actionListenerSequencingCombo;
    private ActionListener actionListenerSequencingCheckBox;
    private ActionListener actionListenerCompletedCheckBox;
    private PropertyChangeListener createdDatePropertyChangeListener;
    private PropertyChangeListener startDatePropertyChangeListener;
    private PropertyChangeListener dueDatePropertyChangeListener;
    private PropertyChangeListener completedDatePropertyChangeListener;
    private HyperlinkListener hyperlinkListener;
    private Observer observerCriterion;
    private PreferenceChangeListener prefsChangeListener;

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(new java.awt.BorderLayout());
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
