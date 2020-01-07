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
import java.util.Collections;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import org.openide.util.Lookup;
import org.openide.util.LookupEvent;
import org.openide.util.LookupListener;
import org.openide.util.NbBundle;
import org.openide.util.Utilities;
import tr.model.Data;
import tr.model.DataLookup;
import tr.model.action.Action;
import tr.model.topic.Topic;
import tr.model.util.Manager;
import tr.util.Observable;
import tr.util.Observer;
import tr.view.filters.FilterComboAbstract;
import tr.view.filters.MultiChoiceDialog;
import tr.view.filters.TopicAll;
import tr.view.filters.TopicMultiple;
import tr.view.filters.TopicMultipleEdit;

/**
 * MatcherEditor the matches information references for a topic selection.
 *
 * @author <a href="mailto:jimoore@netspace.net.au">Jeremy Moore</a>
 */
public class FilterTopic extends FilterChoice implements PropertyChangeListener {
    
    public static final byte INDEX = 6;
    
    /** Constructs a new instance. */
    public FilterTopic() {
        initialise();
    }
    
    protected void initialise() {
        combo = new TopicsComboBox();
        combo.addValueChangeListener(this);
    }
    
    public void propertyChange(PropertyChangeEvent e) {
        Topic topic = (Topic)combo.getSelectedItem();
        if (topic == null) {
            fireMatchAll();
        } else if (topic instanceof TopicAll) {
            fireMatchAll();
        } else if (topic instanceof TopicMultiple) {
            TopicMultiple multiple = (TopicMultiple)topic;
            fireChanged(new TopicMatcher(multiple.getChosen()));
        } else {
            fireChanged(new TopicMatcher(topic));
        }
    }
    
    public String getLabel() {
        return NbBundle.getMessage(getClass(), "filter-topic");
    }
    
    public byte getIndex() {
        return INDEX;
    }
    
    public String[] getSerialValues() {
        if (combo == null) {
            return null;
        }
        Topic topic = (Topic)combo.getSelectedItem();
        if (topic == null) {
            return null;
        }
        if (topic instanceof TopicAll) {
            return new String[] { TopicAll.ID };
        }
        if (topic instanceof TopicMultiple) {
            Vector<Topic> chosen = ((TopicMultiple)topic).getChosen();
            if (chosen == null || chosen.size() == 0) {
                return null;
            }
            Vector<String> values = new Vector<String>();
            for (Topic t : chosen) {
                if (t != null) {
                    values.add(t.getName());
                }
            }
            return values.toArray(new String[0]);
        }
        return new String[] { topic.getName() };
    }
    
    public void setSerialValues(String[] values) {
        if (combo == null) {
            return;
        }
        
        combo.stopChangeEvents();
        
        if (values == null || values.length == 0) {
            combo.setSelectedItem(null);
        } else if (values.length == 1) {
            if (values[0].equals(TopicAll.ID)) {
                combo.setSelectedIndex(0); // all
            } else {
                combo.setSelectedItem(getTopic(values[0]));
            }
        } else if (values.length > 1) {
            Object object = combo.getItemAt(1);
            if (object instanceof TopicMultiple) {
                TopicMultiple multiple = (TopicMultiple)object;
                Vector<Topic> chosen = new Vector<Topic>();
                for (String name : values) {
                    Topic topic = getTopic(name);
                    if (topic != null) {
                        chosen.add(topic);
                    }
                }
                multiple.setChosen(chosen);
            }
            combo.setSelectedIndex(1); // multiple
        }
        
        combo.startChangeEvents();
    }
    
    private Topic getTopic(String name) {
        if (name == null) {
            return null;
        }
        Data data = (Data)DataLookup.instance().lookup(Data.class);
        Manager<Topic> manager = data.getTopicManager();
        for (Topic topic : manager.list()) {
            if (topic.getName().equals(name)) {
                return topic;
            }
        }
        return null;
    }
    
    protected boolean canExcludeNulls() {
        return false;
    }
    
    private static class TopicMatcher implements Matcher<Action> {
        private final boolean all;
        private final List<Topic> topics;
        
        public TopicMatcher() {
            this.all = true;
            this.topics = null;
        }
        
        public TopicMatcher(Topic topic) {
            this.all = false;
            this.topics = new Vector<Topic>();
            this.topics.add(topic);
        }
        
        public TopicMatcher(List<Topic> topics) {
            this.all = false;
            this.topics = topics;
        }
        
        public boolean matches(Action action) {
            if (all) {
                return true;
            }            
            for (Topic topic : topics) {
                if (action.getTopic().equals(topic)) {
                    return true;
                }
            }            
            return false;
        }
    }
    
    private class TopicsComboBoxModel extends DefaultComboBoxModel implements Observer {
        private final TopicAll all;
        private final TopicMultiple multiple;
        private final TopicMultipleEdit multipleEdit;
        private Manager<Topic> topicManager;
        private List<Topic> topics;
        private Lookup.Result result;
        /**
         * Creates a new instance for the given data model.
         * @param data The data model.
         */
        public TopicsComboBoxModel() {
            super();
            all = new TopicAll();
            multiple = new TopicMultiple();
            multipleEdit = new TopicMultipleEdit();
            initialise();
        }
        
        private void initialise() {
            if (topicManager != null) {
                topicManager.removeObserver(this);
            }
            Data data = (Data)DataLookup.instance().lookup(Data.class);
            if (data == null) {
                topicManager = null;
                topics = new Vector<Topic>();
            } else {
                topicManager = data.getTopicManager();
                topicManager.addObserver(this);
                topics = topicManager.list();
                Collections.sort(topics);
            }
            topics.add(0, all);
            topics.add(1, multiple);
//            if (Utilities.isWindows()) {
            if (!Utilities.isMac()) {
                topics.add(2, multipleEdit);
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
            return topics.get(index);
        }
        
        /** Implement ListModel.getSize(). */
        public int getSize() {
            return topics.size();
        }
        
        /** Implement Observer to fire contents changed. */
        public void update(Observable o, Object arg) {
            initialise();
            fireContentsChanged(this, 0, getSize());
        }
    }
    
    public class TopicsComboBox extends FilterComboAbstract {
        
        private final ActionListener listener;
        
        public TopicsComboBox() {
            super(new TopicsComboBoxModel());
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
                if (object instanceof TopicMultiple) {
                    TopicMultiple tm = (TopicMultiple)object;
                    Vector<Topic> all;
                    Data data = (Data)DataLookup.instance().lookup(Data.class);
                    if (data == null) {
                        all = new Vector<Topic>();
                    } else {
                        all = data.getTopicManager().list();
                    }
                    MultiChoiceDialog d = new MultiChoiceDialog<Topic>(TopicsComboBox.this, all, tm.getChosen(), true);
                    d.setTitle(NbBundle.getMessage(getClass(), "filter-topic"));
                    d.setLocationRelativeTo(TopicsComboBox.this);
                    d.setVisible(true);
                    if (d.isOkay()) {
                        tm.setChosen(d.getChosen());
                    }
                }
                fireValueChange();
            }
        };
        
        private Object lastSelectedItem;
        
        private final class WindowsActionListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                Object object = getSelectedItem();
                if (object instanceof TopicMultipleEdit) {
                    TopicsComboBoxModel model = (TopicsComboBoxModel)getModel();
                    TopicMultiple tm = model.multiple;
                    Vector<Topic> all;
                    Data data = (Data)DataLookup.instance().lookup(Data.class);
                    if (data == null) {
                        all = new Vector<Topic>();
                    } else {
                        all = data.getTopicManager().list();
                    }
                    MultiChoiceDialog d = new MultiChoiceDialog<Topic>(TopicsComboBox.this, all, tm.getChosen(), true);
                    d.setTitle(NbBundle.getMessage(getClass(), "filter-topic"));
                    d.setLocationRelativeTo(TopicsComboBox.this);
                    d.setVisible(true);
                    if (d.isOkay()) {
                        tm.setChosen(d.getChosen());
                        setSelectedItem(tm);
                        lastSelectedItem = tm;
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

