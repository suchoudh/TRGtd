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

package tr.view.future.filters;

import ca.odell.glazedlists.matchers.Matcher;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.Serializable;
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
import tr.model.future.Future;
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
 * MatcherEditor the matches a topic selection.
 *
 * @author <a href="mailto:jimoore@netspace.net.au">Jeremy Moore</a>
 */
public class MatcherEditorTopic extends MatcherEditorBase implements PropertyChangeListener {
    
    private final TopicsComboBoxModel comboModel;
    private final TopicsComboBox comboBox;
    
    /** Constructs a new instance. */
    public MatcherEditorTopic() {
        comboModel = new TopicsComboBoxModel();
        comboBox = new TopicsComboBox(comboModel);
        comboBox.addValueChangeListener(this);
    }
    
    public Component getComponent() {
        return comboBox;
    }
    
    public void propertyChange(PropertyChangeEvent e) {
        Topic topic = (Topic)comboBox.getSelectedItem();
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
    
    public Serializable getSerializable() {
        return (Serializable)comboBox.getSelectedItem();
    }
    
    public void setSerializable(Serializable serializable) {
        comboBox.stopChangeEvents();
        if (serializable instanceof TopicAll) {
            comboBox.setSelectedItem((TopicAll)serializable);
            fireMatchAll();
        } else if (serializable instanceof TopicMultiple) {
//            TopicMultiple multiple = (TopicMultiple)serializable;
//            comboBox.setSelectedItem(multiple);
//            fireChanged(new TopicMatcher(multiple.getChosen()));
            TopicMultiple tm = (TopicMultiple)serializable;
            comboModel.multiple.setChosen(tm.getChosen());
            comboBox.setSelectedItem(comboModel.multiple);
            fireChanged(new TopicMatcher(comboModel.multiple.getChosen()));
        } else if (serializable instanceof Topic) {
            Topic topic = (Topic)serializable;
            comboBox.setSelectedItem(topic);
            fireChanged(new TopicMatcher(topic));
        }
        comboBox.startChangeEvents();
    }
    
    private static class TopicMatcher implements Matcher<Future> {
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
        
        public boolean matches(Future future) {
            if (all) {
                return true;
            }
            for (Topic topic : topics) {
                if (topic.equals(future.getTopic())) {
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
            if (Utilities.isWindows()) {
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
        
        public TopicsComboBox(TopicsComboBoxModel model) {
            super(model);
//          setPreferredSize(new Dimension(120, 24));
            if (Utilities.isWindows()) {
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
                    TopicMultiple tm = comboModel.multiple;
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

