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
package tr.view.action;

import au.com.trgtd.tr.appl.Constants;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import java.util.prefs.PreferenceChangeEvent;
import java.util.prefs.PreferenceChangeListener;
import javax.swing.ComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentListener;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import net.miginfocom.swing.MigLayout;
import org.openide.util.NbBundle;
import org.openide.util.Utilities;
import tr.model.Data;
import tr.model.DataLookup;
import tr.model.action.Action;
import tr.model.action.ActionStateASAP;
import tr.model.action.ActionStateDelegated;
import tr.model.action.ActionStateInactive;
import tr.model.action.ActionStateScheduled;
import tr.model.action.Recurrence;
import tr.model.context.Context;
import tr.model.criteria.Value;
import tr.model.thought.Thought;
import tr.model.topic.Topic;
import tr.runtime.Email;
import tr.swing.TRButton;
import tr.swing.TRComboBox;
import tr.swing.TRLabel;
import tr.swing.TRTextField;
import tr.swing.date.field.DateField;
import tr.swing.document.LazyDocumentListener;
import tr.swing.editorpane.HyperEditorPane;
import tr.swing.mig.MTextArea;
import tr.swing.time.HourSpinner;
import tr.swing.time.MinuteSpinner;
import tr.util.Observable;
import tr.util.Observer;
import tr.util.Utils;
import tr.view.ViewUtils;
import tr.view.action.prefs.ActionPrefs;
import tr.view.action.recurrence.NewRecurrenceWizard;
import tr.view.action.recurrence.modify.ModifyRecurrenceWizard;
import tr.view.contexts.ContextsComboBox;
import tr.view.contexts.ContextsComboBoxModel;
import tr.view.criteria.EnergyComboBoxModel;
import tr.view.criteria.PriorityComboBoxModel;
import tr.view.criteria.TimeComboBoxModel;
import tr.view.topics.TopicsComboBox;
import tr.view.topics.TopicsComboBoxModel;

/**
 * Action panel.
 *
 * @author Jeremy Moore (jimoore@netspace.net.au)
 */
public class ActionPanel extends JPanel implements Observer {

    /** Constructs a new default instance. */
    public ActionPanel() {
        super(new BorderLayout());
        initPanel();
        initModel(null);
        addExternalListeners();
    }

    private Data getData() {
        return (Data) DataLookup.instance().lookup(Data.class);
    }

    @Override
    public void addNotify() {
        super.addNotify();
        addInternalListeners();

    }

    @Override
    public void removeNotify() {
        removeInternalListeners();
        super.removeNotify();
    }

    /** Start editing the current action if possible. */
    public void edit() {
        descriptionText.requestFocusInWindow();
    }

    /**
     * Gets the initialised data model.
     * @return The current action or null if there is none.
     */
    public Action getModel() {
        return action;
    }

    /**
     * Initialises the action data model and view.
     * @param action The action data model.
     */
    public void initModel(Action action) {
        if (this.action != null) {
            this.action.removeObserver(this);
            this.action.removePropertyChangeListenter(Action.PROP_DESCR, descrListener);
            this.action.removePropertyChangeListenter(Action.PROP_TOPIC, topicListener);
            this.action.removePropertyChangeListenter(Action.PROP_CONTEXT, contextListener);
            this.action.removePropertyChangeListenter(Action.PROP_DONE, doneListener);
        }

        this.action = action;
        stateInactive = null;
        stateASAP = null;
        stateScheduled = null;
        stateDelegated = null;
        storeActionState();

        if (this.action != null) {
            this.action.addObserver(this);
            this.action.addPropertyChangeListenter(Action.PROP_DESCR, descrListener);
            this.action.addPropertyChangeListenter(Action.PROP_TOPIC, topicListener);
            this.action.addPropertyChangeListenter(Action.PROP_CONTEXT, contextListener);
            this.action.addPropertyChangeListenter(Action.PROP_DONE, doneListener);
        }

        initView();
    }

    /* Initialises the view form field values for the data model. */
    private void initView() {
        updating = true;

        if (action == null) {
            descriptionText.setText("");
            thoughtText.setText("");
            successText.setText("");
            topicCombo.setSelectedItem(null);
            contextCombo.setSelectedItem(null);
            statusCombo.setSelectedItem(null);
            followupDateField.setDate(null);
            scheduledDateField.setDate(null);
            scheduledHourSpinner.setVal(0);
            scheduledMinuteSpinner.setVal(0);
            durationHourSpinner.setVal(0);
            durationMinuteSpinner.setVal(0);
            timeCombo.setSelectedItem(null);
            energyCombo.setSelectedItem(null);
            priorityCombo.setSelectedItem(null);
            notesField.setText("");
            createdDateField.setDate(null);
            startDateField.setDate(null);
            dueDateField.setDate(null);
            doneCheckBox.setSelected(false);
            doneDateField.setDate(null);
            setEnabled(false);
        } else {
            descriptionText.setText(action.getDescription());
            Thought thought = action.getThought();
            thoughtText.setText((thought == null) ? "" : thought.getDescription());
            successText.setText(action.getSuccess());
            topicCombo.setSelectedItem(action.getTopic());
            contextCombo.setSelectedItem(action.getContext());
            statusCombo.setSelectedItem(null);
            if (action.isStateInactive()) {
                statusCombo.setSelectedItem(StatusEnum.INACTIVE);
                this.setStatusInactive();
            } else if (action.isStateASAP()) {
                statusCombo.setSelectedItem(StatusEnum.DO_ASAP);
                ActionStateASAP state = (ActionStateASAP) action.getState();
                setStatusDoASAP();
            }
            if (action.isStateDelegated()) {
                statusCombo.setSelectedItem(StatusEnum.DELEGATED);
                ActionStateDelegated state = (ActionStateDelegated) action.getState();
                delegatedToField.setText(state.getTo());
                followupDateField.setDate(state.getDate());
                setStatusDelegated();
            } else { // not delegated
                delegatedToField.setText("");
                followupDateField.setDate(null);
            }

            if (action.isStateScheduled()) {
                statusCombo.setSelectedItem(StatusEnum.SCHEDULED);
                ActionStateScheduled state = (ActionStateScheduled) action.getState();
                scheduledDateField.setDate(state.getDate());
                if (state.getDate() == null) {
                    scheduledHourSpinner.setValue(new Integer(0));
                    scheduledMinuteSpinner.setValue(new Integer(0));
                    durationHourSpinner.setValue(new Integer(0));
                    durationMinuteSpinner.setValue(new Integer(0));
                } else {
                    Calendar c = Calendar.getInstance();
                    c.setTime(state.getDate());
                    scheduledHourSpinner.setVal(c.get(Calendar.HOUR_OF_DAY));
                    scheduledMinuteSpinner.setVal(c.get(Calendar.MINUTE));
                    durationHourSpinner.setVal(state.getDurationHours());
                    durationMinuteSpinner.setVal(state.getDurationMinutes());
                }
                setStatusScheduled();
            } else { // not scheduled
                scheduledDateField.setDate(null);
                scheduledHourSpinner.setValue(new Integer(0));
                scheduledMinuteSpinner.setValue(new Integer(0));
                durationHourSpinner.setValue(new Integer(0));
                durationMinuteSpinner.setValue(new Integer(0));
            }

            timeCombo.setSelectedItem(action.getTime());
            energyCombo.setSelectedItem(action.getEnergy());
            priorityCombo.setSelectedItem(action.getPriority());
            notesField.setText(action.getNotes());
            createdDateField.setDate(action.getCreated());
            startDateField.setDate(action.getStartDate());
            dueDateField.setDate(action.getDueDate());
            doneCheckBox.setSelected(action.isDone());
            doneDateField.setDate(action.getDoneDate());
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
        successText.setEnabled(enabled);
        topicLabel.setEnabled(enabled);
        topicCombo.setEnabled(enabled);
        contextLabel.setEnabled(enabled);
        contextCombo.setEnabled(enabled);
        statusLabel.setEnabled(enabled);
        statusCombo.setEnabled(enabled);
        delegatedToLabel.setEnabled(enabled);
        delegatedToField.setEnabled(enabled);
        emailButton.setEnabled(enabled);
        followupLabel.setEnabled(enabled);
        followupDateField.setEnabled(enabled);
        scheduledLabel.setEnabled(enabled);
        scheduledDateField.setEnabled(enabled);
        scheduledHourSpinner.setEnabled(enabled);
        scheduledMinuteSpinner.setEnabled(enabled);
        durationLabel.setEnabled(enabled);
        durationHourSpinner.setEnabled(enabled);
        durationMinuteSpinner.setEnabled(enabled);

        if (enabled && action.isStateScheduled()) {
            recurrenceLabel.setEnabled(scheduledDateField.getDate() != null);
            recurrenceButton.setEnabled(scheduledDateField.getDate() != null);
            ActionStateScheduled state = (ActionStateScheduled) action.getState();
            if (state.getRecurrence() == null) {
                recurrenceButton.setText(getMsg("recurrence.create"));
            } else {
                recurrenceButton.setText(getMsg("recurrence.modify"));
            }
        }

        notesLabel.setEnabled(enabled);
        notesField.setEnabled(enabled);
        notesField.setEditable(false);
        createdDateLabel.setEnabled(enabled);
        createdDateField.setEnabled(enabled && ActionPrefs.isEditCreateDate());
        startDateLabel.setEnabled(enabled);
        startDateField.setEnabled(enabled);
        dueDateLabel.setEnabled(enabled);
        dueDateField.setEnabled(enabled);
        doneCheckBox.setEnabled(enabled);
        doneDateField.setEnabled(enabled && action.canSetDone(true));

        timeLabel.setEnabled(enabled);
        timeCombo.setEnabled(enabled);
        energyLabel.setEnabled(enabled);
        energyCombo.setEnabled(enabled);
        priorityLabel.setEnabled(enabled);
        priorityCombo.setEnabled(enabled);
    }

    public void focus() {
        descriptionText.requestFocusInWindow();
    }

    public void refresh() {
        setEnabled(action != null);
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

    /* Stores current action state for restore if user changes and changes back. */
    private void storeActionState() {
        if (action == null) {
            return;
        }
        if (action.isStateInactive()) {
            stateInactive = (ActionStateInactive) action.getState();
        } else if (action.isStateASAP()) {
            stateASAP = (ActionStateASAP) action.getState();
        } else if (action.isStateScheduled()) {
            stateScheduled = (ActionStateScheduled) action.getState();
        } else if (action.isStateDelegated()) {
            stateDelegated = (ActionStateDelegated) action.getState();
        }
    }

    private void hyperlink(javax.swing.event.HyperlinkEvent evt) {
        URL url = evt.getURL();
        if (url == null) {
            return;
        }
        if (evt.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
            tr.runtime.Open.open(url);
        }
    }

    private void recurrenceActionPerformed(java.awt.event.ActionEvent evt) {
        if (updating || action == null) {
            return;
        }

        if (!action.isStateScheduled()) {
            return;
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
            recurrenceButton.setText(getMsg("recurrence.create"));
        } else {
            recurrenceButton.setText(getMsg("recurrence.modify"));
        }

    }

    private void changedDurationMinutes() {
        if (updating || action == null) {
            return;
        }

        if (!action.isStateScheduled()) {
            return;
        }

        stateScheduled = (ActionStateScheduled) action.getState();
        if (stateScheduled.getDate() == null) {
            durationMinuteSpinner.setVal(0);
        } else {
            stateScheduled.setDurationMins(durationMinuteSpinner.getVal());
        }

    }

    private void changedDurationHours() {
        if (updating || action == null) {
            return;
        }

        if (!action.isStateScheduled()) {
            return;
        }

        stateScheduled = (ActionStateScheduled) action.getState();
        if (stateScheduled.getDate() == null) {
            durationHourSpinner.setVal(0);
        } else {
            stateScheduled.setDurationHours(durationHourSpinner.getVal());
        }
    }

    private void changedScheduledDate(Date date) {
        if (updating || action == null) {
            return;
        }

        if (!action.isStateScheduled()) {
            return;
        }

        stateScheduled = (ActionStateScheduled) action.getState();

        if (date == null) {
            stateScheduled.setDate(null);
            scheduledHourSpinner.setVal(0);
            scheduledMinuteSpinner.setVal(0);
            durationHourSpinner.setVal(0);
            durationMinuteSpinner.setVal(0);
            recurrenceLabel.setEnabled(false);
            recurrenceButton.setEnabled(false);
        } else {
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            cal.set(Calendar.HOUR_OF_DAY, scheduledHourSpinner.getVal());
            cal.set(Calendar.MINUTE, scheduledMinuteSpinner.getVal());
            cal.set(Calendar.SECOND, 0);
            cal.set(Calendar.MILLISECOND, 0);
            stateScheduled.setDate(cal.getTime());
            scheduledHourSpinner.setEnabled(true);
            scheduledMinuteSpinner.setEnabled(true);
            durationHourSpinner.setEnabled(true);
            durationMinuteSpinner.setEnabled(true);
            durationLabel.setEnabled(true);
            recurrenceLabel.setEnabled(true);
            recurrenceButton.setEnabled(true);
        }

    }

    private void changedFollowupDate(Date date) {
        if (updating || action == null) {
            return;
        }

        if (action.isStateDelegated()) {
            stateDelegated = (ActionStateDelegated) action.getState();
            stateDelegated.setDate(date);
        }

    }

    private void changedPriority() {
        if (updating || action == null) {
            return;
        }

        action.setPriority((Value) priorityCombo.getSelectedItem());
    }

    private void changedTime() {
        if (updating || action == null) {
            return;
        }

        action.setTime((Value) timeCombo.getSelectedItem());
    }

    private void changedEnergy() {
        if (updating || action == null) {
            return;
        }

        action.setEnergy((Value) energyCombo.getSelectedItem());
    }

    private void changedStatus() {
        if (updating || action == null) {
            return;
        }

        StatusEnum status = (StatusEnum) statusCombo.getSelectedItem();
        switch (status) {
            case INACTIVE:
                action.setState(getStateInactive());
                setStatusInactive();
                break;

            case DO_ASAP:
                action.setState(getStateASAP());
                setStatusDoASAP();
                break;

            case SCHEDULED:
                action.setState(getStateScheduled());
                setStatusScheduled();
                break;

            case DELEGATED:
                action.setState(getStateDelegated());
                setStatusDelegated();
                break;

        }

        setEnabled(true);
    }

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {
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

    private void changedScheduledHour() {
        if (updating || action == null) {
            return;
        }

        if (!action.isStateScheduled()) {
            return;
        }

        stateScheduled = (ActionStateScheduled) action.getState();

        if (stateScheduled.getDate() == null) {
            scheduledHourSpinner.setVal(0);
        } else {
            Calendar c = Calendar.getInstance();
            c.setTime(stateScheduled.getDate());
            c.set(Calendar.HOUR_OF_DAY, scheduledHourSpinner.getVal());
            c.set(Calendar.SECOND, 0);

            stateScheduled.setDate(c.getTime());
            scheduledDateField.setDate(c.getTime());
        }

    }

    private void changedScheduledMinute() {
        if (updating || action == null) {
            return;
        }

        if (!action.isStateScheduled()) {
            return;
        }

        stateScheduled = (ActionStateScheduled) action.getState();

        if (stateScheduled.getDate() == null) {
            scheduledMinuteSpinner.setVal(0);
        } else {
            Calendar c = Calendar.getInstance();
            c.setTime(stateScheduled.getDate());
            c.set(Calendar.MINUTE, scheduledMinuteSpinner.getVal());
            c.set(Calendar.SECOND, 0);
            stateScheduled.setDate(c.getTime());
            scheduledDateField.setDate(c.getTime());
        }
    }

    private void changedDoneDate(Date date) {
        if (updating || action == null) {
            return;
        }
        action.setDoneDate(doneDateField.getDate());
    }

    private void changedDone() {
        if (updating || action == null) {
            return;
        }
        if (action.canSetDone(doneCheckBox.isSelected())) {
            action.setDone(doneCheckBox.isSelected());
            doneDateField.setDate(action.getDoneDate());
            doneDateField.setEnabled(action.canSetDone(true));
        }
    }

    private void changedCreatedDate(Date date) {
        if (updating || action == null) {
            return;
        }
        action.setCreated(date);
    }

    private void changedStartDate(Date date) {
        if (updating || action == null) {
            return;
        }
        action.setStartDate(date);
    }

    private void changedDueDate(Date date) {
        if (updating || action == null) {
            return;
        }
        action.setDueDate(dueDateField.getDate());
    }

    private void changedContext(java.awt.event.ActionEvent evt) {
        if (updating || action == null) {
            return;
        }
        TRComboBox combo = (TRComboBox) evt.getSource();
        action.setContext((Context) combo.getSelectedItem());
    }

    private void changedTopic(java.awt.event.ActionEvent evt) {
        if (updating || action == null) {
            return;
        }
        TRComboBox combo = (TRComboBox) evt.getSource();
        action.setTopic((Topic) combo.getSelectedItem());
    }

    private void changedPrefs(PreferenceChangeEvent e) {
        String key = e.getKey();
        if (key.equals(ActionPrefs.KEY_EDIT_CREATE_DATE)) {
            createdDateField.setEnabled(action != null && ActionPrefs.isEditCreateDate());
            return;
        }
        if (key.equals(ActionPrefs.KEY_NOTE_DELEGATE_EMAIL)) {
            // no need to do anything
            return;
        }
        if (key.equals(ActionPrefs.KEY_SHOW_DUE)) {
            changedStatus();
            return;
        }
        if (key.equals(ActionPrefs.KEY_SHOW_START)) {
            changedStatus();
            return;
        }
        if (key.equals(ActionPrefs.KEY_SHOW_SUCCESS)) {
            removeAll();
            add(createPanel(), BorderLayout.CENTER);
            if (isShowing()) {
                revalidate();
                repaint();
            }
            return;
        }
    }

    // in case one or more criteria have change use.
    private void changedCriteria() {
        removeAll();
        add(createPanel(), BorderLayout.CENTER);
        if (isShowing()) {
            revalidate();
            repaint();
        }
    }

    private void descriptionTextFocusGained(java.awt.event.FocusEvent evt) {
        if (descriptionText.getText().equals(DEFAULT_DESCRIPTION)) {
            descriptionText.setSelectionStart(0);
            descriptionText.setSelectionEnd(DEFAULT_DESCRIPTION.length());
        }
    }

    private ActionStateInactive getStateInactive() {
        if (stateInactive == null) {
            if (action.isStateInactive()) {
                stateInactive = (ActionStateInactive) action.getState();
            } else {
                stateInactive = new ActionStateInactive();
            }
        }
        return stateInactive;
    }

    private ActionStateASAP getStateASAP() {
        if (stateASAP == null) {
            if (action.isStateASAP()) {
                stateASAP = (ActionStateASAP) action.getState();
            } else {
                stateASAP = new ActionStateASAP();
            }
        }
        return stateASAP;
    }

    private ActionStateDelegated getStateDelegated() {
        if (stateDelegated == null) {
            if (action.isStateDelegated()) {
                stateDelegated = (ActionStateDelegated) action.getState();
            } else {
                stateDelegated = new ActionStateDelegated();
            }
        }
        return stateDelegated;
    }

    private ActionStateScheduled getStateScheduled() {
        if (stateScheduled == null) {
            if (action.isStateScheduled()) {
                stateScheduled = (ActionStateScheduled) action.getState();
            } else {
                stateScheduled = new ActionStateScheduled();
            }
        }
        return stateScheduled;
    }

    private void changedDescription() {
        if (updating || action == null) {
            return;
        }
        action.setDescription(descriptionText.getText());
    }

    private void changedSuccess() {
        if (updating || action == null) {
            return;
        }
        action.setSuccess(successText.getText());
    }

    private void changedDelegatedTo() {
        if (updating || action == null) {
            return;
        }
        if (action.isStateDelegated()) {
            stateDelegated = (ActionStateDelegated) action.getState();
            stateDelegated.setTo(delegatedToField.getText());
        }
    }

    private void changedNotes() {
        if (updating || action == null) {
            return;
        }
        action.setNotes(notesField.getText());
    }

    private static String getMsg(String key) {
        return NbBundle.getMessage(ActionPanel.class, key);
    }

    private ComboBoxModel getTimeComboBoxModel() {
        return new TimeComboBoxModel();
    }

    private ComboBoxModel getEnergyComboBoxModel() {
        return new EnergyComboBoxModel();
    }

    private ComboBoxModel getPriorityComboBoxModel() {
        return new PriorityComboBoxModel();
    }
    /** Action description changes. */
    private final PropertyChangeListener descrListener = new PropertyChangeListener() {

        public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
            if (descriptionText.hasFocus()) {
                return; // assume caused by user input to this panel
            }
            if (!descriptionText.getText().equals(action.getDescription())) {
                descriptionText.setText(action.getDescription());
            }
        }
    };
    /** Action topic changes. */
    private final PropertyChangeListener topicListener = new PropertyChangeListener() {

        public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
            if (topicCombo.hasFocus()) {
                return; // assume caused by user input to this panel
            }
            if (!Utils.equal(action.getTopic(), topicCombo.getSelectedItem())) {
                topicCombo.setSelectedItem(action.getTopic());
            }
        }
    };
    /** Action context changes. */
    private final PropertyChangeListener contextListener = new PropertyChangeListener() {

        public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
            if (contextCombo.hasFocus()) {
                return; // assume caused by user input to this panel
            }
            if (!Utils.equal(action.getContext(), contextCombo.getSelectedItem())) {
                contextCombo.setSelectedItem(action.getContext());
            }
        }
    };
    /** Action done changes. */
    private final PropertyChangeListener doneListener = new PropertyChangeListener() {

        public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
            if (doneCheckBox.isSelected() != action.isDone()) {
                doneCheckBox.setSelected(action.isDone());
                doneDateField.setDate(action.getDoneDate());
                doneDateField.setEnabled(action.canSetDone(true));
            }
        }
    };

    /** Handle observed changes to the action. */
    public void update(Observable obs, Object arg) {
        if (action == null) {
            return;
        }
        EventQueue.invokeLater(new Runnable() {

            public void run() {
                // for postpone action date
                dueDateField.setDate(action.getDueDate());
                startDateField.setDate(action.getStartDate());
                if (action.isStateDelegated()) {
                    ActionStateDelegated s = (ActionStateDelegated) action.getState();
                    followupDateField.setDate(s.getDate());
                } else if (action.isStateScheduled()) {
                    // handle possible recurrence change to scheduled state
                    if (!notesField.getText().equals(action.getNotes())) {
                        notesField.setText(action.getNotes());
                    }
                    if (!successText.getText().equals(action.getSuccess())) {
                        successText.setText(action.getSuccess());
                    }
                    ActionStateScheduled ass = (ActionStateScheduled) action.getState();
                    if (ass.getDate() == null) {
                        scheduledHourSpinner.setValue(new Integer(0));
                        scheduledMinuteSpinner.setValue(new Integer(0));
                        durationHourSpinner.setValue(new Integer(0));
                        durationMinuteSpinner.setValue(new Integer(0));
                    } else {
                        Calendar c = Calendar.getInstance();
                        c.setTime(ass.getDate());
                        scheduledHourSpinner.setVal(c.get(Calendar.HOUR_OF_DAY));
                        scheduledMinuteSpinner.setVal(c.get(Calendar.MINUTE));
                        durationHourSpinner.setVal(ass.getDurationHours());
                        durationMinuteSpinner.setVal(ass.getDurationMinutes());
                        scheduledDateField.setDate(ass.getDate());
                    }
                }
            }
        });
    }

    private void addInternalListeners() {
        docListenerDescription = new LazyDocumentListener() {

            public void update() {
                changedDescription();
            }
        };
        descriptionText.getDocument().addDocumentListener(docListenerDescription);

        docListenerSuccess = new LazyDocumentListener() {

            public void update() {
                changedSuccess();
            }
        };

        successText.getDocument().addDocumentListener(docListenerSuccess);

        docListenerDelegatedTo = new LazyDocumentListener() {

            public void update() {
                changedDelegatedTo();
            }
        };

        delegatedToField.getDocument().addDocumentListener(docListenerDelegatedTo);

        docListenerNotes = new LazyDocumentListener() {

            public void update() {
                changedNotes();
            }
        };
        notesField.addDocumentListener(docListenerNotes);

        focusAdapterDescription = new FocusAdapter() {

            @Override
            public void focusGained(FocusEvent evt) {
                descriptionTextFocusGained(evt);
            }
        };

        descriptionText.addFocusListener(focusAdapterDescription);

        actionListenerTopic = new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                changedTopic(evt);
            }
        };

        topicCombo.addActionListener(actionListenerTopic);

        actionListenerContext = new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                changedContext(evt);
            }
        };
        contextCombo.addActionListener(actionListenerContext);

        // Scheduled
        scheduledDatePropertyChangeListener = new PropertyChangeListener() {

            public void propertyChange(PropertyChangeEvent e) {
                changedScheduledDate((Date) e.getNewValue());
            }
        };

        scheduledDateField.addPropertyChangeListener("value", scheduledDatePropertyChangeListener);

        changeListenerScheduledHour = new ChangeListener() {

            public void stateChanged(ChangeEvent evt) {
                changedScheduledHour();
            }
        };

        scheduledHourSpinner.addChangeListener(changeListenerScheduledHour);

        changeListenerScheduledMinute = new ChangeListener() {

            public void stateChanged(ChangeEvent evt) {
                changedScheduledMinute();
            }
        };

        scheduledMinuteSpinner.addChangeListener(changeListenerScheduledMinute);

        changeListenerDurationHour = new ChangeListener() {

            public void stateChanged(ChangeEvent evt) {
                changedDurationHours();
            }
        };
        durationHourSpinner.addChangeListener(changeListenerDurationHour);

        changeListenerDurationMinute = new ChangeListener() {

            public void stateChanged(ChangeEvent evt) {
                changedDurationMinutes();
            }
        };
        durationMinuteSpinner.addChangeListener(changeListenerDurationMinute);

        actionListenerRecurrence = new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                recurrenceActionPerformed(evt);
            }
        };
        recurrenceButton.addActionListener(actionListenerRecurrence);

        actionListenerEmail = new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                emailActionPerformed(evt);
            }
        };
        emailButton.addActionListener(actionListenerEmail);

        actionListenerStatusCombo = new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                changedStatus();
            }
        };
        statusCombo.addActionListener(actionListenerStatusCombo);

        actionListenerPriorityCombo = new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                changedPriority();
            }
        };
        priorityCombo.addActionListener(actionListenerPriorityCombo);

        actionListenerEnergyCombo = new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                changedEnergy();
            }
        };
        energyCombo.addActionListener(actionListenerEnergyCombo);

        actionListenerTimeCombo = new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                changedTime();
            }
        };
        timeCombo.addActionListener(actionListenerTimeCombo);

        followupDatePropertyChangeListener = new PropertyChangeListener() {

            public void propertyChange(PropertyChangeEvent e) {
                changedFollowupDate((Date) e.getNewValue());
            }
        };
        followupDateField.addPropertyChangeListener("value", followupDatePropertyChangeListener);

        createdDatePropertyChangeListener = new PropertyChangeListener() {

            public void propertyChange(PropertyChangeEvent e) {
                changedCreatedDate((Date) e.getNewValue());
            }
        };
        createdDateField.addPropertyChangeListener("value", createdDatePropertyChangeListener);

        startDatePropertyChangeListener = new PropertyChangeListener() {

            public void propertyChange(PropertyChangeEvent e) {
                changedStartDate((Date) e.getNewValue());
            }
        };
        startDateField.addPropertyChangeListener("value", startDatePropertyChangeListener);

        dueDatePropertyChangeListener = new PropertyChangeListener() {

            public void propertyChange(PropertyChangeEvent e) {
                changedDueDate((Date) e.getNewValue());
            }
        };
        dueDateField.addPropertyChangeListener("value", dueDatePropertyChangeListener);

        // Done CheckBox
        doneCheckBoxActionListener = new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                changedDone();
            }
        };
        doneCheckBox.addActionListener(doneCheckBoxActionListener);

        doneDatePropertyChangeListener = new PropertyChangeListener() {

            public void propertyChange(PropertyChangeEvent e) {
                changedDoneDate((Date) e.getNewValue());
            }
        };
        doneDateField.addPropertyChangeListener("value", doneDatePropertyChangeListener);

        notesHyperlinkListener = new HyperlinkListener() {

            public void hyperlinkUpdate(HyperlinkEvent evt) {
                hyperlink(evt);
            }
        };
        notesField.addHyperlinkListener(notesHyperlinkListener);
    }

    private void removeInternalListeners() {
        descriptionText.getDocument().removeDocumentListener(docListenerDescription);
        docListenerDescription = null;
        descriptionText.removeFocusListener(focusAdapterDescription);
        focusAdapterDescription = null;
        successText.getDocument().removeDocumentListener(docListenerSuccess);
        docListenerSuccess = null;
        contextCombo.removeActionListener(actionListenerContext);
        actionListenerContext = null;
        topicCombo.removeActionListener(actionListenerTopic);
        actionListenerTopic = null;
        statusCombo.removeActionListener(actionListenerStatusCombo);
        actionListenerStatusCombo = null;
        scheduledDateField.removePropertyChangeListener(scheduledDatePropertyChangeListener);
        scheduledDatePropertyChangeListener = null;
        scheduledHourSpinner.removeChangeListener(changeListenerScheduledHour);
        changeListenerScheduledHour = null;
        scheduledMinuteSpinner.removeChangeListener(changeListenerScheduledMinute);
        changeListenerScheduledMinute = null;
        durationHourSpinner.removeChangeListener(changeListenerDurationHour);
        changeListenerDurationHour = null;
        durationMinuteSpinner.removeChangeListener(changeListenerDurationMinute);
        changeListenerDurationMinute = null;
        recurrenceButton.removeActionListener(actionListenerRecurrence);
        actionListenerRecurrence = null;
        delegatedToField.getDocument().removeDocumentListener(docListenerDelegatedTo);
        docListenerDelegatedTo = null;
        emailButton.removeActionListener(actionListenerEmail);
        actionListenerEmail = null;
        followupDateField.removePropertyChangeListener(followupDatePropertyChangeListener);
        followupDatePropertyChangeListener = null;
        timeCombo.removeActionListener(actionListenerTimeCombo);
        actionListenerTimeCombo = null;
        energyCombo.removeActionListener(actionListenerEnergyCombo);
        actionListenerEnergyCombo = null;
        priorityCombo.removeActionListener(actionListenerPriorityCombo);
        actionListenerPriorityCombo = null;
        notesField.removeDocumentListener(docListenerNotes);
        docListenerNotes = null;
        notesField.removeHyperlinkListener(notesHyperlinkListener);
        notesHyperlinkListener = null;
        createdDateField.removePropertyChangeListener(createdDatePropertyChangeListener);
        createdDatePropertyChangeListener = null;
        startDateField.removePropertyChangeListener(startDatePropertyChangeListener);
        startDatePropertyChangeListener = null;
        dueDateField.removePropertyChangeListener(dueDatePropertyChangeListener);
        dueDatePropertyChangeListener = null;
        doneCheckBox.removeActionListener(doneCheckBoxActionListener);
        doneCheckBoxActionListener = null;
        doneDateField.removePropertyChangeListener(doneDatePropertyChangeListener);
        doneDatePropertyChangeListener = null;
    }

    private void addExternalListeners() {
        prefsChangeListener = new PreferenceChangeListener() {

            public void preferenceChange(PreferenceChangeEvent evt) {
                changedPrefs(evt);
            }
        };
        ActionPrefs.prefs.addPreferenceChangeListener(prefsChangeListener);

        criteriaObserver = new Observer() {

            public void update(Observable obs, Object arg) {
                changedCriteria();
            }
        };
        Data data = getData();
        if (data != null) {
            getData().getTimeCriterion().addObserver(criteriaObserver);
            getData().getEnergyCriterion().addObserver(criteriaObserver);
            getData().getPriorityCriterion().addObserver(criteriaObserver);
        }
    }

    private void initPanel() {
        scheduledLabel = new TRLabel();
        scheduledHourSpinner = new HourSpinner();
        scheduledMinuteSpinner = new MinuteSpinner();
        durationLabel = new TRLabel();
        durationHourSpinner = new HourSpinner();
        durationMinuteSpinner = new MinuteSpinner();
        recurrenceLabel = new TRLabel();
        recurrenceButton = new TRButton();
        scheduledDateField = new DateField();
        delegatedToLabel = new TRLabel();
        delegatedToField = new TRTextField();
        emailButton = new TRButton();
        followupLabel = new TRLabel();
        followupDateField = new DateField();
        descriptionLabel = new TRLabel();
        descriptionText = new TRTextField();
        thoughtLabel = new TRLabel();
        thoughtText = new TRTextField();
        successLabel = new TRLabel();
        successText = new MTextArea();
        contextLabel = new TRLabel();
        contextsModel = new ContextsComboBoxModel(false);
        contextCombo = new ContextsComboBox(contextsModel);
        topicLabel = new TRLabel();
        topicsModel = new TopicsComboBoxModel(false);
        topicCombo = new TopicsComboBox(topicsModel);
        statusLabel = new TRLabel();
        statusCombo = new TRComboBox();
//        statusCombo.setPreferredSize(SIZE_STATUS_COMBO);
//        statusCombo.setMinimumSize(SIZE_STATUS_COMBO);
//        statusCombo.setMaximumSize(SIZE_STATUS_COMBO);

        priorityLabel = new TRLabel();
        energyLabel = new TRLabel();
        energyCombo = new TRComboBox();
        timeLabel = new TRLabel();
        timeCombo = new TRComboBox();
        priorityCombo = new TRComboBox();
        notesLabel = new TRLabel();
        notesField = new HyperEditorPane();
        createdDateLabel = new TRLabel();
        startDateLabel = new TRLabel();
        dueDateLabel = new TRLabel();
        doneCheckBox = new JCheckBox();
        createdDateField = new DateField();
        startDateField = new DateField();
        dueDateField = new DateField();
        doneDateField = new DateField();

        scheduledLabel.setText(getMsg("LBL_ScheduledFor")); // NOI18N
        scheduledHourSpinner.setMaximumSize(new Dimension(46, 23));
        scheduledHourSpinner.setMinimumSize(new Dimension(46, 23));
        scheduledHourSpinner.setPreferredSize(new Dimension(46, 23));
        scheduledMinuteSpinner.setMaximumSize(new Dimension(46, 23));
        scheduledMinuteSpinner.setMinimumSize(new Dimension(46, 23));
        scheduledMinuteSpinner.setPreferredSize(new Dimension(46, 23));

        durationLabel.setText(getMsg("LBL_Duration")); // NOI18N
        durationHourSpinner.setMaximumSize(new Dimension(46, 23));
        durationHourSpinner.setMinimumSize(new Dimension(46, 23));
        durationHourSpinner.setPreferredSize(new Dimension(46, 23));
        durationMinuteSpinner.setMaximumSize(new Dimension(46, 23));
        durationMinuteSpinner.setMinimumSize(new Dimension(46, 23));
        durationMinuteSpinner.setPreferredSize(new Dimension(46, 23));

        recurrenceLabel.setText(getMsg("LBL_Recurrence")); // NOI18N
        recurrenceButton.setText(NbBundle.getMessage(ActionPanel.class, "recurrence.create")); // NOI18N

        scheduledDateField.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        scheduledDateField.setMaximumSize(new Dimension(120, 23));
        scheduledDateField.setMinimumSize(new Dimension(120, 23));
        scheduledDateField.setPreferredSize(new Dimension(120, 23));

        delegatedToLabel.setText(getMsg("LBL_DelegatedTo")); // NOI18N
        delegatedToField.setMaximumSize(new Dimension(210, 23));
        delegatedToField.setMinimumSize(new Dimension(210, 23));
        delegatedToField.setPreferredSize(new Dimension(210, 23));
        emailButton.setText(getMsg("LBL_Email"));
        followupLabel.setText(getMsg("LBL_FollowUp")); // NOI18N
        followupDateField.setMaximumSize(new Dimension(110, 23));
        followupDateField.setMinimumSize(new Dimension(110, 23));
        followupDateField.setPreferredSize(new Dimension(110, 23));

        descriptionLabel.setText(getMsg("LBL_Description")); // NOI18N

        thoughtLabel.setText(getMsg("LBL_Thought")); // NOI18N
        thoughtText.setBackground(UIManager.getDefaults().getColor("Panel.background"));
        thoughtText.setEnabled(false);

        successLabel.setText(NbBundle.getMessage(ActionPanel.class, "ActionPanel.success")); // NOI18N

        contextLabel.setText(getMsg("LBL_Context")); // NOI18N
        contextCombo.setMaximumRowCount(Constants.COMBO_MAX_ROWS);

        topicLabel.setText(getMsg("LBL_Topic")); // NOI18N

        statusLabel.setText(getMsg("LBL_Status")); // NOI18N
        statusCombo.setModel(new StatusComboBoxModel());

        timeLabel.setText(getMsg("LBL_SimpleTime")); // NOI18N
        timeCombo.setModel(getTimeComboBoxModel());

        energyLabel.setText(getMsg("LBL_Energy")); // NOI18N
        energyCombo.setModel(getEnergyComboBoxModel());

        priorityLabel.setText(getMsg("LBL_Priority")); // NOI18N
        priorityCombo.setModel(getPriorityComboBoxModel());

        notesLabel.setText(getMsg("LBL_Notes")); // NOI18N
        notesField.setMinimumSize(new java.awt.Dimension(100, 62));

        createdDateLabel.setText(getMsg("LBL_Created")); // NOI18N

        startDateLabel.setText(NbBundle.getMessage(ActionPanel.class, "PanelAction.start")); // NOI18N

        dueDateLabel.setText(NbBundle.getMessage(ActionPanel.class, "PanelAction.due")); // NOI18N

        doneCheckBox.setText(getMsg("LBL_Done")); // NOI18N
        doneCheckBox.setHorizontalTextPosition(SwingConstants.LEADING);

        add(createPanel(), BorderLayout.CENTER);
    }

    private JPanel createPanel() {

        JPanel panel;

        if (ViewUtils.isAquaLaF()) {
            if (ActionPrefs.isShowSuccess()) {
                panel = new JPanel(new MigLayout(getMIGCons(), "2[]4[grow]4[]4[]2",
                        "2[]2[]2[]2[]2[]2[]2[]2[]2[]2[grow]2[]2"));
            } else {
                panel = new JPanel(new MigLayout(getMIGCons(), "2[]4[grow]4[]4[]2",
                        "2[]2[]2[]2[]2[]2[]2[]2[]2[grow]2[]2"));
            }
        } else {
            if (ActionPrefs.isShowSuccess()) {
                panel = new JPanel(new MigLayout(getMIGCons(), "2[]4[grow]4[]4[]2", 
                        "2[top]2[top]2[top]2[top]2[center]2[top]2[center]2[top]2[center]2[top, grow]2[center]2[top]2"));
            } else {
                panel = new JPanel(new MigLayout(getMIGCons(), "2[]4[grow]4[]4[]2", 
                        "2[top]2[top]2[top]2[center]2[top]2[center]2[top]2[center]2[top, grow]2[center]2[top]2"));
            }
        }

        panel.add(descriptionLabel, "align right");
        panel.add(descriptionText, "span, growx, wrap");

        panel.add(thoughtLabel, "align right");
        panel.add(thoughtText, "span, growx, wrap");

        if (ActionPrefs.isShowSuccess()) {
            if (ViewUtils.isAquaLaF()) {
                panel.add(successLabel, "align right top");
                panel.add(successText, "gapleft 3, gapright 3, growx, span, wrap");
            } else {
                panel.add(successLabel, "align right top");
                panel.add(successText, "growx, span, wrap");
            }
        }

        panel.add(topicLabel, "align right");
        panel.add(topicCombo, "align left, wrap");

        ViewUtils.addSeparator(panel);

        JComponent[][] comps = new JComponent[4][2];
        int compsIndex = 0;
        comps[compsIndex][0] = contextLabel;
        comps[compsIndex][1] = contextCombo;
        Data data = getData();
        if (data.getTimeCriterion().isUse()) {
            compsIndex++;
            comps[compsIndex][0] = timeLabel;
            comps[compsIndex][1] = timeCombo;
        }
        if (data.getEnergyCriterion().isUse()) {
            compsIndex++;
            comps[compsIndex][0] = energyLabel;
            comps[compsIndex][1] = energyCombo;
        }
        if (data.getPriorityCriterion().isUse()) {
            compsIndex++;
            comps[compsIndex][0] = priorityLabel;
            comps[compsIndex][1] = priorityCombo;
        }
        if (compsIndex == 0) {
            panel.add(comps[0][0], "align right");
            panel.add(comps[0][1], "align left, wrap");
        } else if (compsIndex == 1) {
            panel.add(comps[0][0], "align right");
            panel.add(comps[0][1], "align left, split 3");
            panel.add(comps[1][0], "align right");
            panel.add(comps[1][1], "align left, wrap");
        } else if (compsIndex == 2) {
            panel.add(comps[0][0], "align right");
            panel.add(comps[0][1], "align left, split 5");
            panel.add(comps[1][0], "align right");
            panel.add(comps[1][1], "align left");
            panel.add(comps[2][0], "align right");
            panel.add(comps[2][1], "align left, wrap");
        } else if (compsIndex == 3) {
            panel.add(comps[0][0], "align right");
            panel.add(comps[0][1], "align left, split 7");
            panel.add(comps[1][0], "align right");
            panel.add(comps[1][1], "align left");
            panel.add(comps[2][0], "align right");
            panel.add(comps[2][1], "align left");
            panel.add(comps[3][0], "align right");
            panel.add(comps[3][1], "align left, wrap");
        }

        ViewUtils.addSeparator(panel);

        if (ViewUtils.isAquaLaF()) {
            panel.add(statusLabel, "align right top, gaptop 4");
            panel.add(getStatusPanel(Rows.One), "align left, growx 100, wrap");
        } else {
            panel.add(statusLabel, "align right top");
            panel.add(getStatusPanel(Rows.One), "align left, growx 100, wrap");
        } 

        ViewUtils.addSeparator(panel);

        if (ViewUtils.isAquaLaF()) {
            panel.add(notesLabel, "align right top, gaptop 4, growy 0");
            panel.add(notesField, "span, gapleft 3, gapright 3, align left, growx, growy 100, wrap");
        } else {
            panel.add(notesLabel, "align right top, growy 0");
            panel.add(notesField, "span, align left, growx, growy 100, wrap");
        }

        ViewUtils.addSeparator(panel);

        panel.add(doneCheckBox, "align right");
        panel.add(doneDateField, "align left, split 3");
        panel.add(createdDateLabel, "align left");
        panel.add(createdDateField, "align left, wrap");

        return panel;
    }
    
    private MigLayout statusLayoutA1 = new MigLayout(getMIGCons("insets 0px"), "0[grow]0", "0[]0");
    private MigLayout statusLayoutA2 = new MigLayout(getMIGCons("insets 0px"), "0[grow]0", "0[]2:2:2[]0");
    private MigLayout statusLayoutM1 = new MigLayout(getMIGCons("insets 0px"), "0[grow]0", "0[top]0");
    private MigLayout statusLayoutM2 = new MigLayout(getMIGCons("insets 0px"), "0[grow]0", "0[top]2[top]0");

    private enum Rows {
        One, Two
    };

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

    private String getMIGCons() {
        return DEBUG_MIG_LAYOUT ? "debug" : "";
    }

    private String getMIGCons(String c) {
        assert (c != null && c.trim().length() > 0);

        return DEBUG_MIG_LAYOUT ? "debug, " + c : c;
    }

    private static final boolean DEBUG_MIG_LAYOUT = false;
    
//  private static final Logger LOG = Logger.getLogger("tr.view.action");
    private static final String DEFAULT_DESCRIPTION = getMsg("new.action");
    private static final TRLabel fillerLabel1 = new TRLabel("");
    private static final TRLabel fillerLabel2 = new TRLabel("");
    private static final TRLabel fillerLabel3 = new TRLabel("");
    private Action action;
    private ActionStateInactive stateInactive;
    private ActionStateASAP stateASAP;
    private ActionStateDelegated stateDelegated;
    private ActionStateScheduled stateScheduled;
    private ComboBoxModel topicsModel;
    private ComboBoxModel contextsModel;
    private boolean updating;
    private DocumentListener docListenerDescription;
    private FocusAdapter focusAdapterDescription;
    private DocumentListener docListenerSuccess;
    private DocumentListener docListenerDelegatedTo;
    private DocumentListener docListenerNotes;
    private ActionListener actionListenerTopic;
    private ActionListener actionListenerContext;
    private ActionListener actionListenerRecurrence;
    private ActionListener actionListenerEmail;
    private ActionListener actionListenerStatusCombo;
    private ActionListener actionListenerPriorityCombo;
    private ActionListener actionListenerEnergyCombo;
    private ActionListener actionListenerTimeCombo;
    private ChangeListener changeListenerScheduledHour;
    private ChangeListener changeListenerScheduledMinute;
    private ChangeListener changeListenerDurationHour;
    private ChangeListener changeListenerDurationMinute;
    private HyperlinkListener notesHyperlinkListener;
    private ActionListener doneCheckBoxActionListener;
    private PropertyChangeListener followupDatePropertyChangeListener;
    private PropertyChangeListener createdDatePropertyChangeListener;
    private PropertyChangeListener startDatePropertyChangeListener;
    private PropertyChangeListener dueDatePropertyChangeListener;
    private PropertyChangeListener doneDatePropertyChangeListener;
    private PropertyChangeListener scheduledDatePropertyChangeListener;
    private Observer criteriaObserver;
    private PreferenceChangeListener prefsChangeListener;
    private TRLabel descriptionLabel;
    private TRTextField descriptionText;
    private TRLabel thoughtLabel;
    private TRTextField thoughtText;
    private TRLabel successLabel;
    private MTextArea successText;
    private TRLabel contextLabel;
    private TRComboBox contextCombo;
    private TRComboBox topicCombo;
    private TRLabel topicLabel;
    private DateField createdDateField;
    private TRLabel createdDateLabel;
    private TRLabel delegatedToLabel;
    private TRTextField delegatedToField;
    private JCheckBox doneCheckBox;
    private DateField doneDateField;
    private DateField dueDateField;
    private TRLabel dueDateLabel;
    private HourSpinner durationHourSpinner;
    private TRLabel durationLabel;
    private MinuteSpinner durationMinuteSpinner;
    private TRButton emailButton;
    private TRComboBox energyCombo;
    private TRLabel energyLabel;
    private DateField followupDateField;
    private TRLabel followupLabel;
    private HyperEditorPane notesField;
    private TRLabel notesLabel;
    private TRComboBox priorityCombo;
    private TRLabel priorityLabel;
    private TRButton recurrenceButton;
    private TRLabel recurrenceLabel;
    private DateField scheduledDateField;
    private HourSpinner scheduledHourSpinner;
    private TRLabel scheduledLabel;
    private MinuteSpinner scheduledMinuteSpinner;
    private DateField startDateField;
    private TRLabel startDateLabel;
    private TRComboBox statusCombo;
    private TRLabel statusLabel;
    private TRComboBox timeCombo;
    private TRLabel timeLabel;
    private JPanel statusPanel;
}
