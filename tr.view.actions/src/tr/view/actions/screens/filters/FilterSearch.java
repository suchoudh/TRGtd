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
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import org.openide.util.NbBundle;
import tr.model.action.Action;
import tr.model.action.ActionStateDelegated;
import tr.model.project.Project;
import tr.util.Utils;
import tr.view.filters.FilterComboAbstract;

/**
 * MatcherEditor the matches actions for a search string.
 *
 * @author <a href="mailto:jimoore@netspace.net.au">Jeremy Moore</a>
 */
public class FilterSearch extends FilterChoice implements PropertyChangeListener {
    
    public static final byte INDEX = 13;
    
//    private static final byte VERSION = 1;
    
//    private static final Logger LOG = Logger.getLogger("tr.view.actions");
    
    /** Constructs a new instance. */
    public FilterSearch() {
        initialise();
    }
    
    protected void initialise() {
        combo = new SearchComboBox();
        combo.addValueChangeListener(this);
    }
    
    public void propertyChange(PropertyChangeEvent e) {
        String string = (String)combo.getSelectedItem();
        if (string == null || string.trim().length() == 0) {
            fireMatchAll();
        } else {
            fireChanged(new SearchMatcher(string));
        }
    }
    
    public String getLabel() {
        return NbBundle.getMessage(getClass(), "filter-search");
    }
    
    public String[] getSerialValues() {
        SearchComboBox searchCombo = (SearchComboBox)combo;
        if (searchCombo == null || searchCombo.string == null) {
            return null;
        }
        return new String[] { searchCombo.string };
    }
    
    public void setSerialValues(String[] values) {
        if (combo == null) {
            return;
        }
        
        combo.stopChangeEvents();
        
        if (values == null || values.length == 0) {
            combo.setSelectedItem(null);
        } else {
            combo.setSelectedItem(values[0]);
        }
        
        combo.startChangeEvents();
    }
    
    public Object getValueAt() {
        return "";
    }
    
    public byte getIndex() {
        return INDEX;
    }
    
    public boolean equals(Object object) {
        if (!(object instanceof FilterSearch)) {
            return false;
        }
        if (!super.equals(object)) {
            return false;
        }
        SearchComboBox thisSearchCombo = (SearchComboBox)combo;
        SearchComboBox thatSearchCombo = (SearchComboBox)((FilterSearch)object).combo;
        String thisString = (thisSearchCombo == null) ? null : thisSearchCombo.string;
        String thatString = (thatSearchCombo == null) ? null : thatSearchCombo.string;
        return Utils.equal(thisString, thatString);
    }
    
    protected boolean canExcludeNulls() {
        return false;
    }
    
    private static class SearchMatcher implements Matcher<Action> {
        
        private final String search;
        
        public SearchMatcher() {
            this.search = null;
        }
        
        public SearchMatcher(String search) {
            this.search = search.toLowerCase();
        }
        
        public boolean matches(Action action) {
            if (action.getDescription().toLowerCase().contains(search)) {
                return true;
            }
            if (action.getNotes().toLowerCase().contains(search)) {
                return true;
            }            
            if (action.isStateDelegated()) {
                ActionStateDelegated s = (ActionStateDelegated)action.getState();
                if (s != null && s.getTo() != null) {
                    if (s.getTo().toLowerCase().contains(search)) {
                        return true;
                    } 
                }                 
            }
            // search project description.  Mantis #0001376
            Project project = (Project)action.getParent();
            if (project != null) {
                if (project.getDescription().toLowerCase().contains(search)) {
                    return true;
                }
            }
            // end search project description

            return false;
        }
    }
    
    private class SearchComboBoxModel extends DefaultComboBoxModel {
        
        public final Vector<String> searches = new Vector<String>();
        
        public void addSearch(String search) {
            if (search == null) {
                return;
            }
            search = search.trim();
            if (!searches.contains(search)) {
                searches.add(search);
                fireContentsChanged(search, 0, searches.size());
            }
        }
        
        @Override
        public Object getElementAt(int index) {
            return searches.get(index);
        }
        
        @Override
        public int getSize() {
            return searches.size();
        }
    }
    
    private class SearchComboBox extends FilterComboAbstract {
        
        public SearchComboBox() {
            super(new SearchComboBoxModel());
            setEditable(true);
            addActionListener(listener);
        }
        
        public void stopChangeEvents() {
            removeActionListener(listener);
        }
        
        public void startChangeEvents() {
            addActionListener(listener);
        }
        
        private ActionListener listener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setString(null);
                Object object = getSelectedItem();
                if (object instanceof String) {
                    String s = ((String)object).trim();
                    if (s.length() > 0) {
                        setString(s);
                    }
                }
            }
        };
        
        public String string;
        
        private void setString(String newString) {
            if (newString == null || newString.trim().length() == 0) {
                string = null;
            } else {
                string = newString.trim().toLowerCase();
                ((SearchComboBoxModel)getModel()).addSearch(string);
            }
            fireValueChange();
        }
    }
    
//    public void persist(PersistenceOutputStream out) throws Exception {
//        super.persist(out);
//        out.writeByte(VERSION);
//        out.writeStrings(getSerialValues());
//    }
//
//    public void restore(PersistenceInputStream in) throws Exception {
//        super.restore(in);
//        byte version = in.readByte();
//        if (version != VERSION) {
//            throw new Exception("Unknown persistance version for " + getClass().getName());
//        }
//        setSerialValues(in.readStrings());
//    }
    
}

