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
 * Portions Copyright 2006-2009 Avente Pty Ltd. All Rights Reserved.
 */
package tr.view.process;

import au.com.trgtd.tr.appl.Constants;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Logger;
import java.util.prefs.PreferenceChangeEvent;
import java.util.prefs.PreferenceChangeListener;
import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import net.miginfocom.swing.MigLayout;
import org.openide.util.NbBundle;
import org.openide.util.Utilities;
import org.openide.windows.WindowManager;
import tr.model.Data;
import tr.model.DataLookup;
import tr.model.action.Action;
import tr.model.action.ActionStateASAP;
import tr.model.action.ActionStateDelegated;
import tr.model.action.ActionStateInactive;
import tr.model.action.ActionStateScheduled;
import tr.model.action.Recurrence;
import tr.model.context.Context;
import tr.model.criteria.Criterion;
import tr.model.criteria.Value;
import tr.model.future.Future;
import tr.model.information.Information;
import tr.model.project.Project;
import tr.model.thought.Thought;
import tr.model.topic.Topic;
import tr.model.util.Manager;
import tr.prefs.projects.ProjectsPrefs;
import tr.runtime.Email;
import tr.swing.TRButton;
import tr.swing.TRComboBox;
import tr.swing.TRLabel;
import tr.swing.TRTextField;
import tr.swing.date.field.DateField;
import tr.swing.editorpane.HyperEditorPane;
import tr.swing.mig.MTextArea;
import tr.swing.time.HourSpinner;
import tr.swing.time.MinuteSpinner;
import tr.util.Observable;
import tr.util.Observer;
import tr.view.ViewUtils;
import tr.view.action.StatusComboBoxModel;
import tr.view.action.StatusEnum;
import tr.view.action.prefs.ActionPrefs;
import tr.view.action.recurrence.NewRecurrenceWizard;
import tr.view.action.recurrence.modify.ModifyRecurrenceWizard;
import tr.view.contexts.ContextsComboBox;
import tr.view.contexts.ContextsComboBoxModel;
import tr.view.criteria.CriterionComboBoxModel;
import tr.view.project.chooser.ProjectChooser;
import tr.view.project.chooser.ProjectChooserDialog;
import tr.view.topics.TopicsComboBox;
import tr.view.topics.TopicsComboBoxModel;

/**
 * Process panel.
 *
 * @author Jeremy Moore (jimoore@netspace.net.au)
 * @version 2.0
 */
public class ProcessPanel extends JPanel implements Observer, ProcessCookie {

    /** Creates new form panelProcess */
    public ProcessPanel(ProcessNodeProvider processNodeProvider) {
        this.processNodeProvider = processNodeProvider;
        processNode = new ProcessNode(this);
        data = (Data) DataLookup.instance().lookup(Data.class);
        projects = data.getRootProjects();
        singleActions = data.getRootActions();
        referenceManager = data.getInformationManager();
        somedayManager = data.getFutureManager();
        thoughtManager = data.getThoughtManager();
        thoughtManager.addObserver(this);
        initComponents();
        initPanel();
        initModel();
    }

    private void enableFields(boolean b) {
        thoughtLabel.setEnabled(b);
        thoughtText.setEnabled(b);
        topicLabel.setEnabled(b);
        topicCombo.setEnabled(b);

        actionableYesRadioButton.setEnabled(b);
        actionableNoRadioButton.setEnabled(b);

        // Not Actionable
        deleteRadioButton.setEnabled(b);
        somedayRadioButton.setEnabled(b);
        referenceRadioButton.setEnabled(b);
        tickleDateLabel.setEnabled(b);
        tickleDateField.setEnabled(b);
        notesLabel.setEnabled(b);
        notesField.setEnabled(b);
        notesLabelNA.setEnabled(b);
        notesFieldNA.setEnabled(b);

        // Actionable

        actionableLabel.setEnabled(b);
        successLabel.setEnabled(b);
        successText.setEnabled(b);
        actionLabel.setEnabled(b);
        descriptionLabel.setEnabled(b);
        descriptionText.setEnabled(b);
        contextLabel.setEnabled(b);
        contextCombo.setEnabled(b);
        timeLabel.setEnabled(b);
        timeCombo.setEnabled(b);
        energyLabel.setEnabled(b);
        energyCombo.setEnabled(b);
        priorityLabel.setEnabled(b);
        priorityCombo.setEnabled(b);

        // Status
        statusCombo.setEnabled(b);
        statusLabel.setEnabled(b);
        dueDateLabel.setEnabled(b);
        dueDateField.setEnabled(b);
        startDateLabel.setEnabled(b);
        startDateField.setEnabled(b);

        // Scheduled
        scheduledDateField.setEnabled(b);
        scheduledHourSpinner.setEnabled(b);
        scheduledMinuteSpinner.setEnabled(b);
        durationLabel.setEnabled(b);
        durationHourSpinner.setEnabled(b);
        durationMinuteSpinner.setEnabled(b);
        recurrenceButton.setEnabled(b);
        recurrenceLabel.setEnabled(b);

        // Delegated
        delegatedToLabel.setEnabled(b);
        delegatedToField.setEnabled(b);
        emailButton.setEnabled(b);
        followupLabel.setEnabled(b);
        followupDateField.setEnabled(b);

        // done and created
        doneCheckBox.setEnabled(b);
        doneDateField.setEnabled(b);
        createdDateLabel.setEnabled(b);
        createdDateField.setEnabled(b && ActionPrefs.isEditCreateDate());

        // project
        projectLabel.setEnabled(b);
        addToProjectButton.setEnabled(b);
        addToProjectLabel.setEnabled(b);
        addToProjectField.setEnabled(b);
        addToProjectField.setEditable(false);
        newProjectCheck.setEnabled(b);
        newProjectField.setEnabled(b && newProjectCheck.isSelected());
        newProjectField.setEditable(b && newProjectCheck.isSelected());
    }

    private void initFieldValues() {
        if (thought == null) {
            thoughtLabel.setText(getMsg("LBL_Thought"));
            thoughtText.setText("");
            thoughtText.setForeground(Color.black);
            thoughtText.setBackground(Color.white);
            topicCombo.setSelectedItem(null);
            descriptionText.setText("");
            notesFieldNA.setText("");
            notesField.setText("");
            newProjectField.setText("");
        } else {
            thoughtLabel.setText(getMsg("LBL_ThoughtN", countUnprocessedThoughts()));
            thoughtText.setText(thought.getDescription());
            thoughtText.setForeground(thought.getTopic().getForeground());
            thoughtText.setBackground(thought.getTopic().getBackground());
            topicCombo.setSelectedItem(thought.getTopic());
            descriptionText.setText(thought.getDescription());
            notesFieldNA.setText(thought.getNotes());
            notesField.setText(thought.getNotes());
            newProjectField.setText(thought.getDescription());
        }

        actionableYesRadioButton.setSelected(false);
        actionableNoRadioButton.setSelected(false);

        if (action == null) {

            LOG.info("Action == null");

            // Not Actionable
            deleteRadioButton.setSelected(false);
            somedayRadioButton.setSelected(true);
            referenceRadioButton.setSelected(false);
            tickleDateField.setDate(null);
            // Actionable
            successText.setText("");
            contextCombo.setSelectedItem(null);
            timeCombo.setSelectedItem(null);
            energyCombo.setSelectedItem(null);
            priorityCombo.setSelectedItem(null);
            // Status
            switch (ProjectsPrefs.getNewActionState()) {
                case DOASAP:
                    statusCombo.setSelectedItem(StatusEnum.DO_ASAP);
                    break;
                case DELEGATED:
                    statusCombo.setSelectedItem(StatusEnum.DELEGATED);
                    break;
                case INACTIVE:
                    statusCombo.setSelectedItem(StatusEnum.INACTIVE);
                    break;
                case SCHEDULED:
                    statusCombo.setSelectedItem(StatusEnum.SCHEDULED);
                    break;
            }
            dueDateField.setDate(null);
            startDateField.setDate(null);
            // Scheduled
            scheduledDateField.setDate(null);
            scheduledHourSpinner.setVal(0);
            scheduledMinuteSpinner.setVal(0);
            durationHourSpinner.setVal(0);
            durationMinuteSpinner.setVal(0);
            recurrenceButton.setText(LBL_CREATE);
            // Delegated
            delegatedToField.setText("");
            followupDateField.setDate(null);
            // done and created
            doneCheckBox.setSelected(false);
            doneDateField.setDate(null);
            createdDateField.setDate(Calendar.getInstance().getTime());
        } else {

            LOG.info("Action != null");
            
            // Not Actionable
            deleteRadioButton.setSelected(false);
            somedayRadioButton.setSelected(true);
            referenceRadioButton.setSelected(false);
            tickleDateField.setDate(null);
            notesField.setText(action.getNotes());
            notesFieldNA.setText(action.getNotes());
            // Actionable
            successText.setText(action.getSuccess());
            if (action.getDescription().trim().length() > 0) {
                descriptionText.setText(action.getDescription());
            }
            contextCombo.setSelectedItem(action.getContext());
            timeCombo.setSelectedItem(action.getTime());
            energyCombo.setSelectedItem(action.getEnergy());
            priorityCombo.setSelectedItem(action.getPriority());
            // Status
            switch (action.getState().getType()) {
                case DELEGATED: {
                    statusCombo.setSelectedItem(StatusEnum.DELEGATED);
                    ActionStateDelegated s = (ActionStateDelegated) action.getState();
                    delegatedToField.setText(s.getTo());
                    followupDateField.setDate(s.getDate());
                    break;
                }
                case DOASAP: {
                    statusCombo.setSelectedItem(StatusEnum.DO_ASAP);
                    break;
                }
                case INACTIVE: {
                    statusCombo.setSelectedItem(StatusEnum.INACTIVE);
                    break;
                }
                case SCHEDULED: {
                    statusCombo.setSelectedItem(StatusEnum.SCHEDULED);
                    ActionStateScheduled s = (ActionStateScheduled) action.getState();
                    scheduledDateField.setDate(s.getDate());
                    Calendar c = Calendar.getInstance();
                    c.setTime(s.getDate());
                    scheduledHourSpinner.setVal(c.get(Calendar.HOUR_OF_DAY));
                    scheduledMinuteSpinner.setVal(c.get(Calendar.MINUTE));
                    durationHourSpinner.setVal(s.getDurationHours());
                    durationMinuteSpinner.setVal(s.getDurationMinutes());
                    recurrenceButton.setText(LBL_CREATE);
                    break;
                }
            }
            dueDateField.setDate(action.getDueDate());
            startDateField.setDate(action.getStartDate());

            // done and created
            doneCheckBox.setSelected(false);
            doneDateField.setDate(null);
            createdDateField.setDate(action.getCreated());

            newProjectField.setText(descriptionText.getText());
        }

        Project project = (action == null ? null : (Project) action.getParent());
        if (project == null || project.isRoot()) {
            addToProject = null;
            addToProjectField.setText("");
        } else {
            addToProject = project;
            addToProjectField.setText(project.getDescription());
        }
        newProjectCheck.setSelected(false);
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
    private ActionListener actionListenerThoughtTopic;
//  private DocumentListener docListenerThoughtText;
    private FocusListener focusListenerThoughtText;
    private ActionListener actionListenerDelete;
    private ActionListener actionListenerSomeday;
    private ActionListener actionListenerReference;
    private HyperlinkListener hyperlinkListener;
    private ActionListener actionListenerEmail;
    private PropertyChangeListener doneDatePropertyChangeListener;
    private PropertyChangeListener scheduledDateListener;
    private ActionListener doneCheckBoxActionListener;
    private ItemListener statusListener;
    private ActionListener recurrenceButtonListener;
    private ActionListener addToProjectButtonListener;
    private ActionListener newProjectCheckBoxListener;
    private FocusListener newProjectTextFocusListener;
    private ActionListener actionableYesListener;
    private ActionListener actionableNoListener;
    private PreferenceChangeListener prefsChangeListener;
    private Observer criteriaObserver;

    private void addListeners() {

        actionListenerThoughtTopic = new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                changedTopic();
            }
        };
        topicCombo.addActionListener(actionListenerThoughtTopic);

//      docListenerThoughtText = new LazyDocumentListener() {
//          public void update() {
//              changedDescription();
//          }
//      };
//      thoughtText.getDocument().addDocumentListener(docListenerThoughtText);

        focusListenerThoughtText = new FocusAdapter() {

            @Override
            public void focusLost(FocusEvent e) {
                changedDescription();
            }
        };
        thoughtText.addFocusListener(focusListenerThoughtText);

        actionableYesListener = new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {
                changedToActionable();
            }
        };
        actionableYesRadioButton.addActionListener(actionableYesListener);

        actionableNoListener = new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {
                changedToNotActionable();
            }
        };
        actionableNoRadioButton.addActionListener(actionableNoListener);

        actionListenerEmail = new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                emailActionPerformed();
            }
        };
        emailButton.addActionListener(actionListenerEmail);


        hyperlinkListener = new HyperlinkListener() {

            public void hyperlinkUpdate(HyperlinkEvent evt) {
                hyperlink(evt);
            }
        };
        notesField.addHyperlinkListener(hyperlinkListener);
        notesFieldNA.addHyperlinkListener(hyperlinkListener);

        actionListenerDelete = new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                enableDisableNotActionable();
            }
        };
        deleteRadioButton.addActionListener(actionListenerDelete);

        actionListenerSomeday = new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                enableDisableNotActionable();
            }
        };
        somedayRadioButton.addActionListener(actionListenerSomeday);

        actionListenerReference = new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                enableDisableNotActionable();
            }
        };
        referenceRadioButton.addActionListener(actionListenerReference);

        // Done CheckBox
        doneCheckBoxActionListener = new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                doneCheckBoxChanged();
            }
        };
        doneCheckBox.addActionListener(doneCheckBoxActionListener);

        // Done Date
        doneDatePropertyChangeListener = new PropertyChangeListener() {

            public void propertyChange(PropertyChangeEvent e) {
                changedDoneDate();
            }
        };
        doneDateField.addPropertyChangeListener("value", doneDatePropertyChangeListener);

        // status
        statusListener = new ItemListener() {

            public void itemStateChanged(ItemEvent e) {
                changedStatus();
            }
        };
        statusCombo.addItemListener(statusListener);

        recurrenceButtonListener = new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                recurrenceButtonActionPerformed(e);
            }
        };
        recurrenceButton.addActionListener(recurrenceButtonListener);

        scheduledDateListener = new PropertyChangeListener() {

            public void propertyChange(PropertyChangeEvent arg0) {
                changedScheduledDate();
            }
        };
        scheduledDateField.addPropertyChangeListener(scheduledDateListener);

        newProjectCheckBoxListener = new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                newProjectActionPerformed(e);
            }
        };
        newProjectCheck.addActionListener(newProjectCheckBoxListener);

        newProjectTextFocusListener = new FocusAdapter() {

            @Override
            public void focusGained(FocusEvent e) {
                newProjectTextFocusGained(e);
            }
        };
        newProjectField.addFocusListener(newProjectTextFocusListener);

        addToProjectButtonListener = new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                addToProjectButtonActionPerformed(e);
            }
        };
        addToProjectButton.addActionListener(addToProjectButtonListener);

        prefsChangeListener = new PreferenceChangeListener() {

            public void preferenceChange(PreferenceChangeEvent e) {
                changedPrefs(e);
            }
        };

        ActionPrefs.prefs.addPreferenceChangeListener(prefsChangeListener);

        criteriaObserver = new Observer() {

            public void update(Observable observable, Object arguement) {
                changedCriteria();
            }
        };

        data.getTimeCriterion().addObserver(criteriaObserver);
        data.getEnergyCriterion().addObserver(criteriaObserver);
        data.getPriorityCriterion().addObserver(criteriaObserver);

    }

    private void removeListeners() {
        topicCombo.removeActionListener(actionListenerThoughtTopic);
        actionListenerThoughtTopic = null;
        thoughtText.removeFocusListener(focusListenerThoughtText);
        focusListenerThoughtText = null;
        actionableYesRadioButton.removeActionListener(actionableYesListener);
        actionableYesListener = null;
        actionableNoRadioButton.removeActionListener(actionableNoListener);
        actionableNoListener = null;
        emailButton.removeActionListener(actionListenerEmail);
        actionListenerEmail = null;
        notesField.removeHyperlinkListener(hyperlinkListener);
        notesFieldNA.removeHyperlinkListener(hyperlinkListener);
        hyperlinkListener = null;
        deleteRadioButton.removeActionListener(actionListenerDelete);
        actionListenerDelete = null;
        somedayRadioButton.removeActionListener(actionListenerSomeday);
        actionListenerSomeday = null;
        referenceRadioButton.removeActionListener(actionListenerReference);
        actionListenerReference = null;
        doneCheckBox.removeActionListener(doneCheckBoxActionListener);
        doneCheckBoxActionListener = null;
        doneDateField.removePropertyChangeListener(doneDatePropertyChangeListener);
        doneDatePropertyChangeListener = null;
        recurrenceButton.removeActionListener(recurrenceButtonListener);
        recurrenceButtonListener = null;
        scheduledDateField.removePropertyChangeListener(scheduledDateListener);
        scheduledDateListener = null;
        newProjectCheck.removeActionListener(newProjectCheckBoxListener);
        newProjectCheckBoxListener = null;
        newProjectField.removeFocusListener(newProjectTextFocusListener);
        newProjectTextFocusListener = null;
        addToProjectButton.removeActionListener(addToProjectButtonListener);
        addToProjectButtonListener = null;
        ActionPrefs.prefs.removePreferenceChangeListener(prefsChangeListener);
        prefsChangeListener = null;
        data.getTimeCriterion().removeObserver(criteriaObserver);
        data.getEnergyCriterion().removeObserver(criteriaObserver);
        data.getPriorityCriterion().removeObserver(criteriaObserver);
        criteriaObserver = null;
    }

    private void changedDescription() {
        if (thought != null) {
            thought.setDescription(thoughtText.getText());
        }
    }

    private void changedTopic() {
        if (thought != null) {
            thought.setTopic((Topic) topicCombo.getSelectedItem());
        }
    }

    private void changedToActionable() {
        panelChoice.removeAll();
        panelChoice.add(getPanelActionable(), BorderLayout.CENTER);
        panelChoice.revalidate();
        panelChoice.repaint();
        notesField.setEditable(false);
        if (ActionPrefs.isShowSuccess()) {
            successText.requestFocusInWindow();
        } else {
            descriptionText.requestFocusInWindow();
        }
        // transfer notes
        if (!notesField.getText().equals(notesFieldNA.getText())) {
            notesField.setText(notesFieldNA.getText());
        }
    }

    private void changedToNotActionable() {
        panelChoice.removeAll();
        panelChoice.add(getPanelNotActionable(), BorderLayout.CENTER);
        panelChoice.revalidate();
        panelChoice.repaint();
        notesFieldNA.setEditable(false);
        if (deleteRadioButton.isSelected()) {
            deleteRadioButton.requestFocusInWindow();
        } else if (somedayRadioButton.isSelected()) {
            somedayRadioButton.requestFocusInWindow();
        } else {
            referenceRadioButton.requestFocusInWindow();
        }
        // transfer notes
        if (!notesFieldNA.getText().equals(notesField.getText())) {
            notesFieldNA.setText(notesField.getText());
        }
    }

    private void emailActionPerformed() {
        String to = delegatedToField.getText();
        if (Utilities.getOperatingSystem() == Utilities.OS_LINUX && to.indexOf("@") == -1) {
            JOptionPane.showMessageDialog(null, getMsg("ERR_EmailRequired"), "", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        String subject = descriptionText.getText();
        String body = notesField.getText();
        Email.email(to, subject, body, ActionPrefs.getEmailEncoding());
        Date today = Calendar.getInstance().getTime();
        if (ActionPrefs.isNoteDelegateEmail()) {
            addToNotes(getMsg("MSG_EmailSent") + " " + Constants.DATE_FORMAT_FIXED.format(today));
        }
    }

    private void changedScheduledDate() {
        recurrenceButton.setEnabled(scheduledDateField.getDate() != null);
    }

    private void changedStatus() {
//      LOG.info("ChangedStatus");

        StatusEnum status = (StatusEnum) statusCombo.getSelectedItem();

        if (status == null) {
            SwingUtilities.invokeLater(new Runnable() {

                public void run() {
                    statusCombo.setSelectedItem(StatusEnum.DO_ASAP);
                }
            });
            setStatusDoASAP();
            return;
        }

        switch (status) {
            case DELEGATED:
                setStatusDelegated();
                return;
            case DO_ASAP:
                setStatusDoASAP();
                return;
            case INACTIVE:
                setStatusInactive();
                return;
            case SCHEDULED:
                setStatusScheduled();
                recurrenceButton.setEnabled(scheduledDateField.getDate() != null);
                return;
        }
    }

    private void changedDoneDate() {
        doneCheckBox.setSelected(doneDateField.getDate() != null);
    }

    private void doneCheckBoxChanged() {
        if (doneCheckBox.isSelected()) {
            if (doneDateField.getDate() == null) {
                doneDateField.setDate(Calendar.getInstance().getTime());
            }
        } else { // not done
            doneDateField.setDate(null);
        }
    }

    private void changedPrefs(PreferenceChangeEvent e) {
        String key = e.getKey();
        if (key.equals(ActionPrefs.KEY_EDIT_CREATE_DATE)) {
            createdDateField.setEnabled(thought != null && ActionPrefs.isEditCreateDate());
            return;
        }
        if (key.equals(ActionPrefs.KEY_NOTE_DELEGATE_EMAIL)) {
            // no need to do anything
            return;
        }
        if (key.equals(ActionPrefs.KEY_SHOW_DUE)) {
            // force rebuild of status panel
            if (actionableYesRadioButton.isSelected()) {
                changedStatus();
            }
            return;
        }
        if (key.equals(ActionPrefs.KEY_SHOW_START)) {
            // force rebuild of status panel
            if (actionableYesRadioButton.isSelected()) {
                changedStatus();
            }
            return;
        }
        if (key.equals(ActionPrefs.KEY_SHOW_SUCCESS)) {
            // force rebuild of actionable panel
            panelActionable = null;
            if (actionableYesRadioButton.isSelected()) {
                changedToActionable();
            }
            return;
        }
    }

    // in case one or more criteria have change use.
    private void changedCriteria() {
        panelActionable = null;
        if (actionableYesRadioButton.isSelected()) {
            changedToActionable();
        }
    }

    private void addToNotes(String text) {
        String notes = notesField.getText().trim();
        if (notes.contains(text)) {
            return;
        }
        if (notes.length() == 0) {
            notesField.setText(text);
        } else {
            notesField.setText(notes + "\n" + text);
        }
    }

    private void hyperlink(HyperlinkEvent evt) {
        URL url = evt.getURL();
        if (url == null) {
            return;
        }
        if (evt.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
            tr.runtime.Open.open(url);
        }
    }

    private void enableDisableNotActionable() {
        tickleDateLabel.setEnabled(somedayRadioButton.isSelected());
        tickleDateField.setEnabled(somedayRadioButton.isSelected());
        if (deleteRadioButton.isSelected()) {
            notesLabelNA.setEnabled(false);
            notesFieldNA.setEnabled(false);
            notesFieldNA.setEditable(false);
        } else {
            notesLabelNA.setEnabled(true);
            notesFieldNA.setEnabled(true);
        }
    }

    private Thought getNextUnprocessedThought() {
        for (Thought t : thoughtManager.list()) {
            if (!t.isProcessed()) {
                return t;
            }
        }
        return null;
    }

    private int countUnprocessedThoughts() {
        int c = 0;
        for (Thought t : thoughtManager.list()) {
            if (!t.isProcessed()) {
                c++;
            }
        }
        return c;
    }

    private Observer thoughtObserver = new Observer() {
        public void update(Observable observable, Object arg) {
            assert (observable instanceof Thought);
            if (arg == Thought.Change.DESCRIPTION) {
                if (!thoughtText.getText().equals(thought.getDescription())) {
                    thoughtText.setText(thought.getDescription());
                }
            } else if (arg == Thought.Change.TOPIC) {
                topicCombo.setSelectedItem(thought.getTopic());
                thoughtText.setForeground(thought.getTopic().getForeground());
                thoughtText.setBackground(thought.getTopic().getBackground());
            }
        }
    };

    /* Initialise the model for processing the current thought. */
    public synchronized void initModel() {
        if (thought != null) {
            thought.removeObserver(this);
        }
        thought = getNextUnprocessedThought();

        if (thought == null) {
            action = null;
            enableFields(false);
            processNodeProvider.provide(null);
        } else {
            if (thought.getAction() != null) {
                action = thought.getAction();
            } else {
                action = new Action(data);
                action.setDescription(thought.getDescription());
                action.setNotes(thought.getNotes());
                action.setTopic(thought.getTopic());                
                switch (ProjectsPrefs.getNewActionState()) {
                    case DELEGATED:
                        action.setState(new ActionStateDelegated());
                        break;
                    case DOASAP:
                        action.setState(new ActionStateASAP());
                        break;
                    case INACTIVE:
                        action.setState(new ActionStateInactive());
                        break;
                    case SCHEDULED:
                        action.setState(new ActionStateScheduled());
                        break;
                }
            }
            thought.addObserver(thoughtObserver);
            recurrenceProject = null;
            enableFields(true);
            processNodeProvider.provide(processNode);
        }

        initFieldValues();

        actionableYesRadioButton.setSelected(true);

        changedToActionable();
        changedStatus();

        actionableYesRadioButton.requestFocusInWindow();
    }

    /**
     * Determines whether processing is valid.
     * @return null if processing is valid, otherwise a message containing the
     * problems.
     */
    public String validateProcessing() {

        StringBuffer sb = new StringBuffer();

        if (actionableNoRadioButton.isSelected()) {
            if (!deleteRadioButton.isSelected() && thoughtText.getText().trim().equals("")) {
                sb.append(getMsg("no.thought.description") + "\n");
            }
        } else {
            if (descriptionText.getText().trim().length() == 0) {
                sb.append(getMsg("no.action.description") + "\n");
            }
            if (statusCombo.getSelectedItem() == StatusEnum.SCHEDULED) {
                if (scheduledDateField.getDate() == null) {
                    sb.append(getMsg("no.scheduled.date") + "\n");
                }
            }
            if (statusCombo.getSelectedItem() == StatusEnum.DELEGATED) {
                if (delegatedToField.getText().trim().equals("")) {
                    sb.append(getMsg("no.delegate") + "\n");
                }
            }
        }
        return sb.length() > 0 ? sb.toString() : null;
    }

    /** Process the current item. */
    public void process() {
        if (thought == null || action == null) {
            return;
        }

        String probs = validateProcessing();
        if (probs != null) {
            String t = getMsg("dialog.problems.title");
            String m = getMsg("dialog.problems.message") + "\n\n" + probs + "\n";
            JOptionPane.showMessageDialog(null, m, t, JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (actionableNoRadioButton.isSelected()) {
            if (deleteRadioButton.isSelected()) {
                thoughtManager.remove(thought);
            } else if (referenceRadioButton.isSelected()) {
                Information reference = new Information(data.getNextID());
                reference.setTopic((Topic) topicCombo.getSelectedItem());
                reference.setDescription(thoughtText.getText());
                reference.setNotes(notesFieldNA.getText());
                referenceManager.add(reference);
            } else if (somedayRadioButton.isSelected()) {
                Future someday = new Future(data.getNextID());
                someday.setThought(thought);
                someday.setDescription(thoughtText.getText());
                someday.setTopic((Topic) topicCombo.getSelectedItem());
                someday.setTickle(tickleDateField.getDate());
                someday.setNotes(notesFieldNA.getText());
                somedayManager.add(someday);
            }
        } else { // actionable
            action.setThought(thought);
            action.setSuccess(successText.getText());
            action.setDescription(descriptionText.getText());
            action.setTopic((Topic) topicCombo.getSelectedItem());
            action.setContext((Context) contextCombo.getSelectedItem());
            action.setTime((Value) timeCombo.getSelectedItem());
            action.setEnergy((Value) energyCombo.getSelectedItem());
            action.setPriority((Value) priorityCombo.getSelectedItem());
            action.setNotes(notesField.getText());
            action.setDone(doneCheckBox.isSelected());
            action.setDoneDate(doneDateField.getDate());
            action.setCreated(createdDateField.getDate());
            StatusEnum status = (StatusEnum) statusCombo.getSelectedItem();
            switch (status) {
                case DELEGATED:
                    ActionStateDelegated stateDelegated = new ActionStateDelegated();
                    stateDelegated.setDate(followupDateField.getDate());
                    stateDelegated.setTo(delegatedToField.getText());
                    action.setState(stateDelegated);
                    action.setDueDate(dueDateField.getDate());
                    action.setStartDate(startDateField.getDate());
                    break;
                case DO_ASAP:
                    action.setState(new ActionStateASAP());
                    action.setDueDate(dueDateField.getDate());
                    action.setStartDate(startDateField.getDate());
                    break;
                case INACTIVE:
                    action.setState(new ActionStateInactive());
                    action.setDueDate(dueDateField.getDate());
                    action.setStartDate(startDateField.getDate());
                    break;
                case SCHEDULED:
                    if (!action.isStateScheduled()) {
                        action.setState(new ActionStateScheduled());
                    }
                    ActionStateScheduled stateScheduled = (ActionStateScheduled) action.getState();
                    Calendar c = Calendar.getInstance();
                    c.setTime(scheduledDateField.getDate());
                    c.set(Calendar.HOUR_OF_DAY, scheduledHourSpinner.getVal());
                    c.set(Calendar.MINUTE, scheduledMinuteSpinner.getVal());
                    stateScheduled.setDate(c.getTime());
                    stateScheduled.setDurationHours(durationHourSpinner.getVal());
                    stateScheduled.setDurationMins(durationMinuteSpinner.getVal());
                    action.setDueDate(null);
                    action.setStartDate(null);
                    break;
            }

            if (newProjectCheck.isSelected()) {
                Project project = new Project(data);
                project.setThought(thought);
                String desc = newProjectField.getText().trim();
                project.setDescription(desc.length() > 0 ? desc : thought.getDescription());
                project.setTopic(action.getTopic());
                project.setDone(false);
                project.setVision(action.getSuccess());
                project.setNotes(thought.getNotes());
                project.add(action);
                // add to selected project or projects root
                if (addToProject == null) {
                    projects.add(project);
                } else {
                    project.setSequencing(addToProject.isSequencing());
                    project.setSequenceType(addToProject.getSequenceType());
                    project.setPriority(addToProject.getPriority());
                    addToProject.add(project);
                }
            } else { // do not create new project
                // add action to selected project or as a single action
                if (addToProject == null) {
                    singleActions.add(action);
                } else {
                    addToProject.add(action);
                }
            }

            if (action.getPriority() == null) {
                action.setPriority(((Project) action.getParent()).getPriority());
            }

            // recurrence: need to transfer any actions created by recurrence
            if (action.isStateScheduled()) {
                Recurrence recurrence = action.getRecurrence();
                if (recurrence != null) {
                    if (recurrenceProject != null) {
                        Project parent = (Project) action.getParent();
                        if (parent != null) {
                            for (Action a : recurrenceProject.getChildren(Action.class)) {
                                if (a.getID() != action.getID()) {
                                    parent.add(a);
                                }
                            }
                        }
                    }
                    // set correct recurrence project
                    recurrence.setProject((Project) action.getParent());
                }
            }
        }

        thought.setProcessed(true);

        initModel();
    }

    public void takeFocus() {
        actionableYesRadioButton.requestFocusInWindow();
    }

    /** Handle thought manager change */
    public void update(Observable observable, Object arg) {
        if (observable == thoughtManager) {
            if (thought == null) {
                initModel();
            }
        }
    }

    private void initPanel() {
        initFields();
        add(createPanel(), BorderLayout.CENTER);
    }

    private void initFields() {
        thoughtLabel = new TRLabel(getMsg("LBL_Thought"));
        thoughtText = new TRTextField();

        topicLabel = new TRLabel(LBL_TOPIC);
        topicCombo = new TopicsComboBox(new TopicsComboBoxModel(false));

        actionableYesRadioButton = new JRadioButton(LBL_YES);
        actionableNoRadioButton = new JRadioButton(LBL_NO);

        actionableButtonGroup = new ButtonGroup();
        actionableButtonGroup.add(actionableNoRadioButton);
        actionableButtonGroup.add(actionableYesRadioButton);

        // NOT ACTIONABLE
//      deleteLabel.setIcon(Icons.Trash);
//      deleteLabel.setText(getMsg(LBL_DELETE));
        deleteRadioButton = new JRadioButton();
        deleteRadioButton.setText(LBL_DELETE);

//      futureLabel.setIcon(Icons.SomedayMaybe);
//      futureLabel.setText(getMsg(LBL_SOMEDAY));
        somedayRadioButton = new JRadioButton();
        somedayRadioButton.setText(LBL_SOMEDAY);
        tickleDateLabel = new TRLabel(LBL_TICKLE_DATE);
        tickleDateField = new DateField();

//      informationLabel.setIcon(Icons.Reference);
//      informationLabel.setText(getMsg(LBL_REFERENCE));
        referenceRadioButton = new JRadioButton();
        referenceRadioButton.setText(LBL_REFERENCE);

        notesLabelNA = new TRLabel(LBL_NOTES);
        notesFieldNA = new HyperEditorPane();
        notesFieldNA.setMinimumSize(SIZE_NOTES_EDITOR);

        notesLabel = new TRLabel(LBL_NOTES);
        notesField = new HyperEditorPane();
        notesField.setMinimumSize(SIZE_NOTES_EDITOR);

        // ACTIONABLE
        actionableLabel = new TRLabel(LBL_ACTIONABLE);
        successLabel = new TRLabel(LBL_SUCCESS);
        successText = new MTextArea();

        actionLabel = new TRLabel(LBL_NEXT_ACTION);

        descriptionLabel = new TRLabel(LBL_DESCRIPTION);
        descriptionText = new TRTextField();

        contextLabel = new TRLabel(LBL_CONTEXT);
        
        contextCombo = new ContextsComboBox(new ContextsComboBoxModel(false));



        timeLabel = new TRLabel(LBL_TIME);
        timeCombo = new TRComboBox(getTimeComboBoxModel());
        energyLabel = new TRLabel(LBL_ENERGY);
        energyCombo = new TRComboBox(getEnergyComboBoxModel());
        priorityLabel = new TRLabel(LBL_PRIORITY);


        priorityCombo = new TRComboBox(getPriorityComboBoxModel());

        statusLabel = new TRLabel(LBL_STATUS);
        statusCombo = new TRComboBox(new StatusComboBoxModel());

        recurrenceLabel = new TRLabel(LBL_RECURRENCE);
        recurrenceButton = new TRButton(LBL_CREATE);

        dueDateLabel = new TRLabel(LBL_DUE_DATE);
        dueDateField = new DateField();
        startDateLabel = new TRLabel(LBL_START_DATE);
        startDateField = new DateField();
        notActionableButtonGroup = new ButtonGroup();
        notActionableButtonGroup.add(deleteRadioButton);
        notActionableButtonGroup.add(somedayRadioButton);
        notActionableButtonGroup.add(referenceRadioButton);
        scheduledHourSpinner = new HourSpinner();
        scheduledMinuteSpinner = new MinuteSpinner();
        durationLabel = new TRLabel(LBL_DURATION);
        durationHourSpinner = new HourSpinner();
        durationMinuteSpinner = new MinuteSpinner();
        scheduledDateField = new DateField();
        delegatedToLabel = new TRLabel(LBL_DELEGATE);
        delegatedToField = new TRTextField();
        delegatedToField.setPreferredSize(SIZE_DELEGATE_TEXT);
        delegatedToField.setMinimumSize(SIZE_DELEGATE_TEXT);
        delegatedToField.setMaximumSize(SIZE_DELEGATE_TEXT);
        emailButton = new TRButton(LBL_EMAIL);
        followupLabel = new TRLabel(LBL_FOLLOWUP);
        followupDateField = new DateField();
        doneCheckBox = new JCheckBox(LBL_DONE);
        doneCheckBox.setHorizontalTextPosition(SwingConstants.LEADING);
        doneDateField = new DateField();
        createdDateLabel = new TRLabel(LBL_CREATED);
        createdDateField = new DateField();

        projectLabel = new TRLabel(LBL_PROJECT);

        newProjectCheck = new JCheckBox(LBL_NEW_PROJECT);
        newProjectCheck.setHorizontalTextPosition(SwingConstants.LEADING);
        newProjectField = new TRTextField();
        addToProjectField = new TRTextField();
        addToProjectLabel = new TRLabel(LBL_ADD_TO_PROJECT);
        addToProjectButton = new TRButton("...");
        addToProjectButton.setPreferredSize(SIZE_PROJECT_BUTTON);
        addToProjectButton.setMinimumSize(SIZE_PROJECT_BUTTON);
        addToProjectButton.setMaximumSize(SIZE_PROJECT_BUTTON);
    }

    private JPanel createPanel() {

        JPanel panel;

        if (ViewUtils.isAquaLaF()) {
            panel = new JPanel(new MigLayout(getMIGCons(), "[][grow]", "4[]2[]2[]2[]2[grow]0"));
        } else {
            panel = new JPanel(new MigLayout(getMIGCons(), "[][grow]", "4[center]2[top]2[center]2[center]2[grow]0"));
        }

        ViewUtils.addSeparator(panel, thoughtLabel);

        panel.add(thoughtText, "align left, span, growx 100, split 3");
        panel.add(topicLabel,  "align left");
        panel.add(topicCombo,  "align left, wrap");

        ViewUtils.addSeparator(panel, actionableLabel);

        panel.add(actionableYesRadioButton, "align left, split 2");
        panel.add(actionableNoRadioButton,  "align left, wrap");

        panelChoice = new JPanel(new BorderLayout());

        panel.add(panelChoice, "span, grow");

        return panel;
    }

    private JPanel getPanelNotActionable() {
        if (panelNotActionable == null) {
            panelNotActionable = new JPanel(new MigLayout(getMIGCons(), "0[grow]0", "2[]2[]2[]2[]2[]4[grow]4"));

            ViewUtils.addSeparator(panelNotActionable, LBL_NOT_ACTIONABLE);

            panelNotActionable.add(deleteRadioButton, "sx, wrap");

            panelNotActionable.add(somedayRadioButton, "sx, split 3, align left");
            panelNotActionable.add(tickleDateLabel, "align left, gapleft 12");
            panelNotActionable.add(tickleDateField, "align left, wrap");

            panelNotActionable.add(referenceRadioButton, "sx, wrap");

            ViewUtils.addSeparator(panelNotActionable);

            panelNotActionable.add(notesLabelNA, "span, split 2, align left top, growx 0, growy 0");
            panelNotActionable.add(notesFieldNA, "span, grow");
        }
        return panelNotActionable;
    }

    private JPanel getPanelActionable() {
        if (panelActionable == null) {
            if (ActionPrefs.isShowSuccess()) {
                panelActionable = new JPanel(new MigLayout(getMIGCons(), "0[][grow]0", "0[]2[]2[]2[grow]2[]2[]2[]2"));
                ViewUtils.addSeparator(panelActionable, successLabel);
                panelActionable.add(successText, "span, growx, wrap");
            } else {
                panelActionable = new JPanel(new MigLayout(getMIGCons(), "0[][grow]0", "0[]2[grow]2[]2[]2[]2"));
            }

            ViewUtils.addSeparator(panelActionable, actionLabel);

            panelActionable.add(getPanelAction(), "span, grow, wrap");

            ViewUtils.addSeparator(panelActionable, projectLabel);

//            panelActionable.add(newProjectCheck, "span, split 2, align left, grow 0");
            panelActionable.add(newProjectCheck, "align left, grow 0");
            panelActionable.add(newProjectField, "align left, growx 100, growy 0, wrap");

//            panelActionable.add(addToProjectLabel,  "gapleft 5, gapright 6, span, split 3, align left, growx 0, growy 0");
            panelActionable.add(addToProjectLabel,  "split 2, gapleft 5, gapright 6, align left, growx 0, growy 0");
//            panelActionable.add(addToProjectButton, "gapright 6, align left, grow 0");
            panelActionable.add(addToProjectButton, "gapright 6, align left, grow 0");
            panelActionable.add(addToProjectField,  "align left, growx 100, growy 0, wrap");
        }
        return panelActionable;
    }

    private String getMIGCons() {
        return DEBUG_MIG_LAYOUT ? "debug" : "";
    }

    private String getMIGCons(String c) {
        assert(c != null && c.trim().length() > 0);

        return DEBUG_MIG_LAYOUT ? "debug, " + c : c;
    }

    private MigLayout statusLayoutA1 = new MigLayout(getMIGCons("insets 0px"), "0[grow]0", "0[]0");
    private MigLayout statusLayoutA2 = new MigLayout(getMIGCons("insets 0px"), "0[grow]0", "0[]2:2:2[]0");
    private MigLayout statusLayoutM1 = new MigLayout(getMIGCons("insets 0px"), "0[grow]0", "0[top]0");
    private MigLayout statusLayoutM2 = new MigLayout(getMIGCons("insets 0px"), "0[grow]0", "0[top]2[top]0");

    private enum Rows {One, Two};

    private JPanel getStatusPanel(Rows rows) {

        if (statusPanel == null) {
            statusPanel = new JPanel();
            statusPanel.setOpaque(false);
            statusPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
        } else {
            statusPanel.removeAll();            
        }

        if (ViewUtils.isAquaLaF()) {
            statusPanel.setLayout(rows == Rows.One ? statusLayoutA1 : statusLayoutA2);
        } else {
            statusPanel.setLayout(rows == Rows.One ? statusLayoutM1 : statusLayoutM2);
        }
        return statusPanel;
    }

    private void setStatusDelegated() {
        boolean focus = statusCombo.hasFocus();

        JPanel panel = getStatusPanel(Rows.Two);
        panel.add(statusCombo, "span, split");
        if (ActionPrefs.isShowDueDate()) {
            panel.add(dueDateLabel, "");
            panel.add(dueDateField, "");
        }
        if (ActionPrefs.isShowStartDate()) {
            panel.add(startDateLabel, "");
            panel.add(startDateField, "");
        }
        panel.add(fillerLabel1, "wrap");

        panel.add(delegatedToLabel, "gapleft 4, span, split 5");
        panel.add(delegatedToField, "");
        panel.add(emailButton, "gapleft 2");
        panel.add(followupLabel, "");
        panel.add(followupDateField, "wrap");
        panel.revalidate();
        panel.repaint();

        if (focus) {
            statusCombo.requestFocusInWindow();
        }
    }

    private void setStatusDoASAP() {
        boolean focus = statusCombo.hasFocus();

        JPanel panel = getStatusPanel(Rows.One);
        panel.add(statusCombo, "span, split");
        if (ActionPrefs.isShowDueDate()) {
            panel.add(dueDateLabel, "");
            panel.add(dueDateField, "");
        }
        if (ActionPrefs.isShowStartDate()) {
            panel.add(startDateLabel, "");
            panel.add(startDateField, "");
        }
        panel.add(fillerLabel2, "wrap");

        panel.revalidate();
        panel.repaint();

        if (focus) {
            statusCombo.requestFocusInWindow();
        }
    }

    private void setStatusInactive() {
        boolean focus = statusCombo.hasFocus();

        JPanel panel = getStatusPanel(Rows.One);
        panel.add(statusCombo, "span, split");
        if (ActionPrefs.isShowDueDate()) {
            panel.add(dueDateLabel, "");
            panel.add(dueDateField, "");
        }
        if (ActionPrefs.isShowStartDate()) {
            panel.add(startDateLabel, "");
            panel.add(startDateField, "");
        }
        panel.add(fillerLabel3, "wrap");

        panel.revalidate();
        panel.repaint();

        if (focus) {
            statusCombo.requestFocusInWindow();
        }
    }

    private void setStatusScheduled() {
        boolean focus = statusCombo.hasFocus();

        JPanel panel = getStatusPanel(Rows.Two);
        panel.add(statusCombo, "span, split 7");
        panel.add(scheduledDateField, "gapleft 2");
        panel.add(scheduledHourSpinner, "gapleft 0");
        panel.add(scheduledMinuteSpinner, "gapleft 0");
        panel.add(durationLabel, "gapleft 4");
        panel.add(durationHourSpinner, "gapleft 2");
        panel.add(durationMinuteSpinner, "gapleft 0, wrap");

        panel.add(recurrenceLabel, "gapleft 4, split 2");
        panel.add(recurrenceButton, "gapleft 2, wrap");
        panel.revalidate();
        panel.repaint();

        if (focus) {
            statusCombo.requestFocusInWindow();
        }
    }

    private JPanel getPanelAction() {
        if (panelAction == null) {

            if (ViewUtils.isAquaLaF()) {
                panelAction = new JPanel(new MigLayout(getMIGCons(), "2[]4[grow]4[]4[]2", "0[]2[]2[]2[]2[]2[grow]2[]2[]0"));
            } else {
                panelAction = new JPanel(new MigLayout(getMIGCons(), "2[]4[grow]4[]4[]2", "0[top]2[top]2[]2[top]2[]2[top,grow]2[]2[top]0"));
            }

            panelAction.add(descriptionLabel, "align right");
            panelAction.add(descriptionText, "span, growx, wrap");

            panelAction.add(contextLabel, "align right");
            panelAction.add(contextCombo, "align left, span, split");
            if (data.getTimeCriterion().isUse()) {
                panelAction.add(timeLabel, "align right");
                panelAction.add(timeCombo, "align left");
            }
            if (data.getEnergyCriterion().isUse()) {
                panelAction.add(energyLabel, "align right");
                panelAction.add(energyCombo, "align left");
            }
            if (data.getPriorityCriterion().isUse()) {
                panelAction.add(priorityLabel, "align right");
                panelAction.add(priorityCombo, "align left");
            }
            panelAction.add(fillerLabel4, "wrap");

            ViewUtils.addSeparator(panelAction);
            
            if (ViewUtils.isAquaLaF()) {
                panelAction.add(statusLabel, "align right top, gaptop 4");
                panelAction.add(getStatusPanel(Rows.One), "align left, growx 100, wrap");
            } else {
                panelAction.add(statusLabel, "align right top");
                panelAction.add(getStatusPanel(Rows.One), "align left, growx 100, wrap");
            } 

            ViewUtils.addSeparator(panelAction);

            if (ViewUtils.isAquaLaF()) {
                panelAction.add(notesLabel, "align right top, gaptop 4, growx 0, growy 0");
                panelAction.add(notesField, "span, gapleft 3, gapright 3, grow");
            } else {
                panelAction.add(notesLabel, "align right top, growx 0, growy 0");
                panelAction.add(notesField, "span, grow");
            }

            ViewUtils.addSeparator(panelAction);

            panelAction.add(doneCheckBox, "align right, grow 0");
            panelAction.add(doneDateField, "align left, split 3, grow 0");
            panelAction.add(createdDateLabel, "align left, grow 0");
            panelAction.add(createdDateField, "align left, grow 0, wrap");
        }

        return panelAction;
    }

    private ComboBoxModel getTimeComboBoxModel() {
        if (data != null) {
            Criterion criterion = data.getTimeCriterion();
            if (criterion != null) {
                return new CriterionComboBoxModel(criterion);
            }
        }
        return new DefaultComboBoxModel();
    }

    private ComboBoxModel getEnergyComboBoxModel() {
        if (data != null) {
            Criterion criterion = data.getEnergyCriterion();
            if (criterion != null) {
                return new CriterionComboBoxModel(criterion);
            }
        }
        return new DefaultComboBoxModel();
    }

    private ComboBoxModel getPriorityComboBoxModel() {
        if (data != null) {
            Criterion criterion = data.getPriorityCriterion();
            if (criterion != null) {
                return new CriterionComboBoxModel(criterion);
            }
        }
        return new DefaultComboBoxModel();
    }

    private void recurrenceButtonActionPerformed(ActionEvent e) {
        if (statusCombo.getSelectedItem() != StatusEnum.SCHEDULED) {
            return;
        }
        action.setThought(thought);
        action.setSuccess(successText.getText());
        action.setDescription(descriptionText.getText());
        action.setTopic((Topic) topicCombo.getSelectedItem());
        action.setContext((Context) contextCombo.getSelectedItem());
        action.setTime((Value) timeCombo.getSelectedItem());
        action.setEnergy((Value) energyCombo.getSelectedItem());
        action.setPriority((Value) priorityCombo.getSelectedItem());
        action.setNotes(notesField.getText());
        action.setDone(doneCheckBox.isSelected());
        action.setDoneDate(doneDateField.getDate());
        action.setCreated(createdDateField.getDate());
        if (!action.isStateScheduled()) {
            action.setState(new ActionStateScheduled());
        }
        ActionStateScheduled state = (ActionStateScheduled) action.getState();
        state.setDate(scheduledDateField.getDate());
        state.setDurationHours(durationHourSpinner.getVal());
        state.setDurationMins(durationMinuteSpinner.getVal());
        if (recurrenceProject == null) {
            recurrenceProject = new Project(data);
            recurrenceProject.add(action);
        }
        Recurrence recurrence = action.getRecurrence();
        if (recurrence == null) {
            NewRecurrenceWizard wizard = new NewRecurrenceWizard();
            wizard.start(action);
        } else {
            ModifyRecurrenceWizard wizard = new ModifyRecurrenceWizard();
            wizard.start(action);
        }
        // update button text if necessary
        if (action.getRecurrence() == null) {
            recurrenceButton.setText(LBL_CREATE);
        } else {
            recurrenceButton.setText(LBL_MODIFY);
        }
    }

    private void newProjectTextFocusGained(java.awt.event.FocusEvent evt) {
        if (newProjectField.getText().equals(thought.getDescription())) {
            newProjectField.selectAll();
        }
    }

    private void newProjectActionPerformed(java.awt.event.ActionEvent evt) {
        newProjectField.setEnabled(newProjectCheck.isSelected());
    }

    private void addToProjectButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if (projectChooser == null) {
            projectChooser = new ProjectChooser(WindowManager.getDefault().getMainWindow());
        }
        ProjectChooserDialog dialog = projectChooser.getDialog();
        Project newProject = dialog.select(addToProject, addToProjectButton);
        if (!dialog.cancelled()) {
            addToProject = newProject;
            if (addToProject == null) {
                addToProjectField.setText("");
            } else {
                addToProjectField.setText(addToProject.getDescription());
            }
        }
    }


    private static String getMsg(String key) {
        return NbBundle.getMessage(ProcessPanel.class, key);
    }

    private static String getMsg(String key, int n) {
        return NbBundle.getMessage(ProcessPanel.class, key, n);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(new java.awt.BorderLayout());
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    private final static Logger LOG = Logger.getLogger("tr.view.process");

    private static final boolean DEBUG_MIG_LAYOUT = false;

    private static final String LBL_TOPIC = getMsg("LBL_Topic");
    private static final String LBL_ACTIONABLE = getMsg("LBL_Actionable");
    private static final String LBL_YES = getMsg("LBL_Yes");
    private static final String LBL_NO = getMsg("LBL_No");
    private static final String LBL_NOT_ACTIONABLE = getMsg("LBL_NotActionable");
    private static final String LBL_DELETE = getMsg("LBL_Delete");
    private static final String LBL_SOMEDAY = getMsg("LBL_SomedayMaybe");
    private static final String LBL_REFERENCE = getMsg("LBL_Reference");
    private static final String LBL_TICKLE_DATE = getMsg("LBL_TickleDate");
    private static final String LBL_SUCCESS = getMsg("LBL_SuccessfulOutcome");
    private static final String LBL_NEXT_ACTION = getMsg("LBL_NextAction");
    private static final String LBL_DESCRIPTION = getMsg("LBL_Description");
    private static final String LBL_CONTEXT = getMsg("LBL_Context");
    private static final String LBL_TIME = getMsg("LBL_Time");
    private static final String LBL_ENERGY = getMsg("LBL_Energy");
    private static final String LBL_PRIORITY = getMsg("LBL_Priority");
    private static final String LBL_STATUS = getMsg("LBL_Status");
    private static final String LBL_DUE_DATE = getMsg("LBL_DueDate");
    private static final String LBL_START_DATE = getMsg("LBL_StartDate");
    private static final String LBL_DURATION = getMsg("LBL_Duration");
    private static final String LBL_RECURRENCE = getMsg("LBL_Recurrence");
    private static final String LBL_CREATE = getMsg("LBL_Create");
    private static final String LBL_MODIFY = getMsg("LBL_Modify");
    private static final String LBL_DELEGATE = getMsg("LBL_Delegate");
    private static final String LBL_EMAIL = getMsg("LBL_Email");
    private static final String LBL_FOLLOWUP = getMsg("LBL_Followup");
    private static final String LBL_PROJECT = getMsg("LBL_Project");
    private static final String LBL_ADD_TO_PROJECT = getMsg("LBL_AddToProject");
    private static final String LBL_NEW_PROJECT = getMsg("LBL_NewProject");
    private static final String LBL_DONE = getMsg("LBL_Done");
    private static final String LBL_CREATED = getMsg("LBL_Created");
    private static final String LBL_NOTES = getMsg("LBL_Notes");
    private static final Dimension SIZE_DELEGATE_TEXT = new Dimension(200, 23);
    private static final Dimension SIZE_PROJECT_BUTTON = new Dimension(20, 20);
//  private static final Dimension SIZE_STATUS_COMBO = new Dimension(120, 23);
    private static final Dimension SIZE_NOTES_EDITOR = new Dimension(100, 62);
    private static final TRLabel fillerLabel1 = new TRLabel("");
    private static final TRLabel fillerLabel2 = new TRLabel("");
    private static final TRLabel fillerLabel3 = new TRLabel("");
    private static final TRLabel fillerLabel4 = new TRLabel("");
    private final Data data;
    private final ProcessNodeProvider processNodeProvider;
    private final ProcessNode processNode;
    private final Project projects;
    private final Project singleActions;
    private final Manager<Thought> thoughtManager;
    private final Manager<Information> referenceManager;
    private final Manager<Future> somedayManager;
    private Thought thought;
    private Action action;
    private Project addToProject;
    private Project recurrenceProject;
    private ProjectChooser projectChooser;
    private TRLabel thoughtLabel;
    private TRTextField thoughtText;
    private TRLabel topicLabel;
    private JComboBox topicCombo;
    private ButtonGroup actionableButtonGroup;
    private JRadioButton actionableYesRadioButton;
    private JRadioButton actionableNoRadioButton;

    // Not Actionable
    private ButtonGroup notActionableButtonGroup;
    private JRadioButton deleteRadioButton;
    private JRadioButton somedayRadioButton;
    private JRadioButton referenceRadioButton;
    private TRLabel tickleDateLabel;
    private DateField tickleDateField;
    private TRLabel notesLabel;
    private HyperEditorPane notesField;
    private TRLabel notesLabelNA;
    private HyperEditorPane notesFieldNA;

    // Actionable
    private TRLabel actionableLabel;
    private TRLabel successLabel;
    private TRLabel actionLabel;
    private TRLabel projectLabel;

    private MTextArea successText;
    private TRLabel descriptionLabel;
    private TRTextField descriptionText;
    private TRLabel contextLabel;
    private JComboBox contextCombo;
    private TRLabel timeLabel;
    private JComboBox timeCombo;
    private TRLabel energyLabel;
    private JComboBox energyCombo;
    private TRLabel priorityLabel;
    private JComboBox priorityCombo;

    // Status
    private JComboBox statusCombo;
    private TRLabel statusLabel;
    private TRLabel dueDateLabel;
    private DateField dueDateField;
    private TRLabel startDateLabel;
    private DateField startDateField;

    // Scheduled
    private DateField scheduledDateField;
    private HourSpinner scheduledHourSpinner;
    private MinuteSpinner scheduledMinuteSpinner;
    private TRLabel durationLabel;
    private HourSpinner durationHourSpinner;
    private MinuteSpinner durationMinuteSpinner;
    private TRButton recurrenceButton;
    private TRLabel recurrenceLabel;

    // Delegated
    private TRLabel delegatedToLabel;
    private TRTextField delegatedToField;
    private TRButton emailButton;
    private TRLabel followupLabel;
    private DateField followupDateField;

    // done and created
    private JCheckBox doneCheckBox;
    private DateField doneDateField;
    private TRLabel createdDateLabel;
    private DateField createdDateField;

    // project
    private JCheckBox newProjectCheck;
    private TRTextField newProjectField;
    private TRButton addToProjectButton;
    private TRLabel addToProjectLabel;
    private TRTextField addToProjectField;

    // panels
    private JPanel panelChoice;
    private JPanel panelNotActionable;
    private JPanel panelActionable;
    private JPanel panelAction;
    private JPanel statusPanel;


}
