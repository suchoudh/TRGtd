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
import org.openide.util.Lookup;
import org.openide.util.LookupEvent;
import org.openide.util.LookupListener;
import org.openide.util.NbBundle;
import org.openide.util.Utilities;
import tr.model.Data;
import tr.model.DataLookup;
import tr.model.action.Action;
import tr.model.criteria.Value;
import tr.model.util.Manager;
import tr.util.Observable;
import tr.util.Observer;
import tr.view.filters.FilterComboAbstract;
import tr.view.filters.MultiChoiceDialog;
import tr.view.filters.ValueAll;
import tr.view.filters.ValueMultiple;
import tr.view.filters.ValueMultipleEdit;

/**
 * MatcherEditor the matches the energy criterion.
 *
 * @author <a href="mailto:jimoore@netspace.net.au">Jeremy Moore</a>
 */
//public class FilterCriterionEnergy extends FilterChoice
//        implements PropertyChangeListener {
public class FilterCriterionEnergy extends FilterCriterion implements PropertyChangeListener {
    
    public static final byte INDEX = 4;
    public static final String ID = "energy";
    
    private static final Logger LOG = Logger.getLogger("tr.view.actions");
    
    /** Constructs a new instance. */
    public FilterCriterionEnergy() {
        initialise();
    }
    
    protected void initialise() {
        combo = new EnergyCombo();
        combo.addValueChangeListener(this);
    }
    
    public void propertyChange(PropertyChangeEvent e) {
        Value value = (Value)combo.getSelectedItem();
        if (value == null) {
            fireMatchAll();
        } else if (value instanceof ValueAll) {
            fireMatchAll();
        } else if (value instanceof ValueMultiple) {
            ValueMultiple multiple = (ValueMultiple)value;
            fireChanged(new ValueMatcher(multiple.getChosen(), excludeNulls));
        } else {
            fireChanged(new ValueMatcher(value, excludeNulls));
        }
    }
    
    public String getLabel() {
        return NbBundle.getMessage(getClass(), "filter-energy");
    }
    
    protected Value getValue(String id) {
        Data data = (Data)DataLookup.instance().lookup(Data.class);
        Manager<Value> manager = data.getEnergyCriterion().values;
        for (Value value : manager.list()) {
            try {
                if (value.getID() == Integer.parseInt(id)) {
                    return value;
                }
            } catch (Exception ex) {
            }
        }
        return null;
    }
    
    public byte getIndex() {
        return INDEX;
    }
    
    private static class ValueMatcher implements Matcher<Action> {
        
        private final List<Value> values;
        private final boolean excludeNulls;
        
        public ValueMatcher(Value value, boolean excludeNulls) {
            this.values = new Vector<Value>();
            this.values.add(value);
            this.excludeNulls = excludeNulls;
        }
        
        public ValueMatcher(List<Value> values, boolean excludeNulls) {
            this.values = values;
            this.excludeNulls = excludeNulls;
        }
        
        public boolean matches(Action action) {
            if (action.getEnergy() == null) {
                return ! excludeNulls;
            }
            for (Value value : values) {
                if (value.equals(action.getEnergy())) {
                    return true;
                }
            }
            return false;
        }
    }
    
    private class EnergyComboBoxModel extends DefaultComboBoxModel implements Observer {
        private final ValueAll all;
        private final ValueMultiple multiple;
        private final ValueMultipleEdit multipleEdit;
        private Manager<Value> valueManager;
        private List<Value> values;
        private Lookup.Result result;
        /**
         * Creates a new instance for the given data model.
         * @param data The data model.
         */
        public EnergyComboBoxModel() {
            super();
            all = new ValueAll();
            multiple = new ValueMultiple();
            multipleEdit = new ValueMultipleEdit();
            initialise();
        }
        
        private void initialise() {
            if (valueManager != null) {
                valueManager.removeObserver(this);
            }
            
            Data data = (Data)DataLookup.instance().lookup(Data.class);
            if (data == null) {
                valueManager = null;
                values = new Vector<Value>();
            } else {
                valueManager = data.getEnergyCriterion().values;
                valueManager.addObserver(this);
                values = valueManager.list();
            }
            values.add(0, all);
            values.add(1, multiple);
//            if (Utilities.isWindows()) {
            if (!Utilities.isMac()) {
                values.add(2, multipleEdit);
            }
            // data lookup listener to force panel initialisation if data changes
            if (result == null) {
                result = DataLookup.instance().lookup(new Lookup.Template(Data.class));
                result.addLookupListener(new LookupListener() {
                    public void resultChanged(LookupEvent lookupEvent) {
                        update(null, null);
                    }
                });
            }
        }
        
        /** Implement ListModel.getElementAt(int index). */
        public Object getElementAt(int index) {
            return values.get(index);
        }
        
        /** Implement ListModel.getSize(). */
        public int getSize() {
            return values.size();
        }
        
        /** Implement Observer to fire contents changed. */
        public void update(Observable o, Object arg) {
            initialise();
            fireContentsChanged(this, 0, getSize());
        }
    }
    
    public class EnergyCombo extends FilterComboAbstract {
        
        private final ActionListener listener;
        
        public EnergyCombo() {
            super(new EnergyComboBoxModel());
//            if (Utilities.isWindows()) {
            if (!Utilities.isMac()) {
                listener = new WindowsActionListener();
            } else {
                listener = new RealActionListener();
            }
            addActionListener(listener);
        }
        
        public void stopChangeEvents() {
            removeActionListener(listener);
        }
        
        public void startChangeEvents() {
            addActionListener(listener);
            // for MS-Windows:
            lastSelectedItem = getSelectedItem();
        }
        
        private final class RealActionListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                Object object = getSelectedItem();
                if (object instanceof ValueMultiple) {
                    ValueMultiple m = (ValueMultiple)object;
                    Vector<Value> all;
                    Data data = (Data)DataLookup.instance().lookup(Data.class);
                    if (data == null) {
                        all = new Vector<Value>();
                    } else {
                        all = data.getEnergyCriterion().values.list();
                    }
                    MultiChoiceDialog d = new MultiChoiceDialog<Value>(EnergyCombo.this, all, m.getChosen(), false);
                    d.setTitle(NbBundle.getMessage(getClass(), "filter-energy"));
                    d.setLocationRelativeTo(EnergyCombo.this);
                    d.setVisible(true);
                    if (d.isOkay()) {
                        m.setChosen(d.getChosen());
                    }
                }
                fireValueChange();
            }
        }
        
        private Object lastSelectedItem;
        
        private final class WindowsActionListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                Object object = getSelectedItem();
                if (object instanceof ValueMultipleEdit) {
                    EnergyComboBoxModel model = (EnergyComboBoxModel)getModel();
                    ValueMultiple m = model.multiple;
                    Vector<Value> all;
                    Data data = (Data)DataLookup.instance().lookup(Data.class);
                    if (data == null) {
                        all = new Vector<Value>();
                    } else {
                        all = data.getEnergyCriterion().values.list();
                    }
                    MultiChoiceDialog d = new MultiChoiceDialog<Value>(EnergyCombo.this, all, m.getChosen(), false);
                    d.setTitle(NbBundle.getMessage(getClass(), "filter-energy"));
                    d.setLocationRelativeTo(EnergyCombo.this);
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

