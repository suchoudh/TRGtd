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

package tr.view.actions.screens.filters;

import ca.odell.glazedlists.matchers.Matcher;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;
import java.util.Vector;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import org.openide.util.NbBundle;
import org.openide.util.Utilities;
import tr.model.action.Action;
import tr.util.Utils;
import tr.view.filters.Choice;
import tr.view.filters.ChoiceAll;
import tr.view.filters.ChoiceMultiple;
import tr.view.filters.ChoiceMultipleEdit;
import tr.view.filters.FilterComboAbstract;
import tr.view.filters.MultiChoiceDialog;

/**
 * MatcherEditor the matches information references for a topic selection.
 *
 * @author <a href="mailto:jimoore@netspace.net.au">Jeremy Moore</a>
 */
public class FilterStatus extends FilterChoice implements PropertyChangeListener {
    
    public static final byte INDEX = 1;
    
    private static final Logger LOG = Logger.getLogger("tr.view.actions");
    
    /** Constructs a new instance. */
    public FilterStatus() {
        initialise();
    }
    
    protected void initialise() {
        combo = new StatusComboBox();
        combo.addValueChangeListener(this);
    }
    
    public void propertyChange(PropertyChangeEvent e) {
        Choice choice = (Choice)combo.getSelectedItem();
        if (choice == null) {
            fireMatchAll();
        } else if (choice instanceof All) {
            fireMatchAll();
        } else if (choice instanceof Multiple) {
            Multiple m = (Multiple)choice;
            fireChanged(new StatusMatcher(m.getChosen()));
        } else {
            fireChanged(new StatusMatcher(choice));
        }
    }
    
    public String getLabel() {
        return NbBundle.getMessage(getClass(), "filter-status");
    }
    
    public String[] getSerialValues() {
        if (combo == null) {
            return null;
        }
        Choice item = (Choice)combo.getSelectedItem();
        if (item == null) {
            return null;
        }
        if (item instanceof Multiple) {
            Multiple m = (Multiple)item;
            if (m == null || m.getChosen() == null) {
                return null;
            }
            String[] values = new String[m.getChosen().size()];
            for (int i = 0; i < values.length; i++) {
                values[i] = ((Choice)m.getChosen().get(i)).getID();
            }
            return values;
        }
        return new String[] { item.getID() };
    }
    
    public void setSerialValues(String[] values) {
        if (combo == null) return;
        
        combo.stopChangeEvents();
        
        if (values == null || values.length == 0) {
            combo.setSelectedItem(null);
        } else if (values.length == 1) {
            combo.setSelectedItem(getChoice(values[0]));
        } else if (values.length > 1) {
            combo.setSelectedIndex(1); // multiple
            Multiple multiple = (Multiple)combo.getItemAt(1);
            multiple.setChosen(new Vector<Choice>());
            for (String id : values) {
                multiple.getChosen().add(getChoice(id));
            }
            combo.setSelectedItem(multiple);
        }
        
        combo.startChangeEvents();
    }
    
    public boolean equals(Object object) {
        if (!(object instanceof FilterStatus)) {
            return false;
        }
        if (!super.equals(object)) {
            return false;
        }
        Choice thisChoice = (Choice)combo.getSelectedItem();
        Choice thatChoice = (Choice)((FilterChoice)object).combo.getSelectedItem();
        return Utils.equal(thisChoice, thatChoice);
    }
    
    private Choice getChoice(String id) {
        if (id == null) return null;
        if (id.equals(All.ID)) return new All();
        if (id.equals(ChoiceDoASAP.ID)) return new ChoiceDoASAP();
        if (id.equals(ChoiceInactive.ID)) return new ChoiceInactive();
        if (id.equals(ChoiceDelegated.ID)) return new ChoiceDelegated();
        if (id.equals(ChoiceScheduled.ID)) return new ChoiceScheduled();
        return null;
    }
    
    public byte getIndex() {
        return INDEX;
    }
    
    protected boolean canExcludeNulls() {
        return false;
    }
    
    public class All extends ChoiceAll {
        public static final String ID = "0";
        public String getID() {
            return ID;
        }
    }
    private class Multiple extends ChoiceMultiple {
        public static final String ID = "1";
        public String getID() {
            return ID;
        }
    }
    public class ChoiceDelegated extends Choice {
        public static final String ID = "2";
        public String getID() {
            return ID;
        }
        public String getLabel() {
            return NbBundle.getMessage(getClass(), "filter-status-delegated");
        }
    }
    public class ChoiceDoASAP extends Choice {
        public static final String ID = "3";
        public String getID() {
            return ID;
        }
        public String getLabel() {
            return NbBundle.getMessage(getClass(), "filter-status-doasap");
        }
    }
    public class ChoiceInactive extends Choice {
        public static final String ID = "4";
        public String getID() {
            return ID;
        }
        public String getLabel() {
            return NbBundle.getMessage(getClass(), "filter-status-inactive");
        }
    }
    public class ChoiceScheduled extends Choice {
        public static final String ID = "5";
        public String getID() {
            return ID;
        }
        public String getLabel() {
            return NbBundle.getMessage(getClass(), "filter-status-scheduled");
        }
    }
    
    private static class StatusMatcher implements Matcher<Action> {
        
        private final List<Choice> choices;
        
        public StatusMatcher(Choice choice) {
            this.choices = new Vector<Choice>();
            this.choices.add(choice);
        }
        
        public StatusMatcher(List<Choice> choices) {
            this.choices = choices;
        }
        
        public boolean matches(Action action) {
            for (Choice choice : choices) {
                if (choice instanceof All) {
                    return true;
                }
                if (action.isStateASAP() && choice instanceof ChoiceDoASAP) {
                    return true;
                }
                if (action.isStateInactive() && choice instanceof ChoiceInactive) {
                    return true;
                }
                if (action.isStateScheduled() && choice instanceof ChoiceScheduled) {
                    return true;
                }
                if (action.isStateDelegated() && choice instanceof ChoiceDelegated) {
                    return true;
                }
            }
            return false;
        }
    }
    
    private class StatusComboBoxModel extends DefaultComboBoxModel {
        
        private final Choice all = new All();
        private final Multiple multiple = new Multiple();
        private final ChoiceMultipleEdit multipleEdit = new ChoiceMultipleEdit();
        private final Choice doasap = new ChoiceDoASAP();
        private final Choice inactive = new ChoiceInactive();
        private final Choice delegated = new ChoiceDelegated();
        private final Choice scheduled = new ChoiceScheduled();
        private final Choice[] items;
        
        public StatusComboBoxModel() {
            super();
//            if (Utilities.isWindows()) {
            if (!Utilities.isMac()) {
                items = new Choice[] {
                    all,
                    multiple,
                    multipleEdit,
                    doasap,
                    inactive,
                    delegated,
                    scheduled,
                };
            } else {
                items = new Choice[] {
                    all,
                    multiple,
                    doasap,
                    inactive,
                    delegated,
                    scheduled,
                };
            }
        }
        
        public Object getElementAt(int index) {
            return items[index];
        }
        
        public int getSize() {
            return items.length;
        }
    }
    
    public class StatusComboBox extends FilterComboAbstract {
        
        private final Vector<Choice> options = new Vector<Choice>();
        private final ActionListener listener;
        private Object lastSelectedItem;
        
        public StatusComboBox() {
            super(new StatusComboBoxModel());
            options.add(new ChoiceDoASAP());
            options.add(new ChoiceInactive());
            options.add(new ChoiceDelegated());
            options.add(new ChoiceScheduled());
//            if (Utilities.isWindows()) {
            if (!Utilities.isMac()) {
                listener = new WindowsActionListener();
            } else {
                listener = new RealActionListener();
            }
        }
        
        public void startChangeEvents() {
            addActionListener(listener);
            // for MS-Windows:
            lastSelectedItem = getSelectedItem();
        }
        
        public void stopChangeEvents() {
            removeActionListener(listener);
        }
        
        private final class RealActionListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                Object object = getSelectedItem();
                if (object instanceof Multiple) {
                    Multiple m = (Multiple)object;
                    MultiChoiceDialog d = new MultiChoiceDialog<Choice>(StatusComboBox.this, options, m.getChosen(), true);
                    d.setTitle(NbBundle.getMessage(getClass(), "filter-status"));
                    d.setLocationRelativeTo(StatusComboBox.this);
                    d.setVisible(true);
                    if (d.isOkay()) {
                        m.setChosen(d.getChosen());
                    }
                }
                fireValueChange();
            }
        };
        
        private final class WindowsActionListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                Object object = getSelectedItem();
                if (object instanceof ChoiceMultipleEdit) {
                    StatusComboBoxModel model = (StatusComboBoxModel)getModel();
                    Multiple m = model.multiple;
                    MultiChoiceDialog d = new MultiChoiceDialog<Choice>(StatusComboBox.this, options, m.getChosen(), true);
                    d.setTitle(NbBundle.getMessage(getClass(), "filter-topic"));
                    d.setLocationRelativeTo(StatusComboBox.this);
                    d.setVisible(true);
                    if (d.isOkay()) {
                        m.setChosen(d.getChosen());
                        setSelectedItem(m);
                        lastSelectedItem = m;
                    } else {
                        setSelectedItem(lastSelectedItem);
                    }
                } else {
                    lastSelectedItem = object;
                }
                fireValueChange();
            }
        }
    }
    
}

