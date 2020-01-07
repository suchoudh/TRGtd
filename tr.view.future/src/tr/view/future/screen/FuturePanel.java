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

package tr.view.future.screen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Date;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.event.DocumentListener;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import org.openide.util.NbBundle;
import org.openide.util.Utilities;
import tr.model.future.Future;
import tr.model.topic.Topic;
import tr.swing.document.LazyDocumentListener;
import tr.view.topics.TopicsComboBox;
import tr.view.topics.TopicsComboBoxModel;

/**
 * Future item panel.
 *
 * @author <a href="mailto:jimoore@netspace.net.au">Jeremy Moore</a>
 */
public class FuturePanel extends JPanel {
    
    private static final Logger LOG = Logger.getLogger("tr.view.future");
    
    private Future future;
    private boolean updating;
    
    /** Constructs a new instance. */
    public FuturePanel() {
        super();
        initComponents();
        initModel(null);
    }
    
    /**
     * Initialises the future item data model and view.
     * @param future The future item.
     */
    public void initModel(Future future) {
        this.future = future;
        initView();
    }
    
    /* Initialises the view form field values for the data model. */
    private void initView() {
        updating = true;
        if (future == null) {
            descriptionText.setText("");
            topicCombo.setSelectedIndex(0);
            notesEditorPane.setText("");
            tickleDateField.setDate(null);
            setEnabled(false);
        } else {
            descriptionText.setText(future.getDescription());
            topicCombo.setSelectedItem(future.getTopic());
            notesEditorPane.setText(future.getNotes());
            tickleDateField.setDate(future.getTickle());
            setEnabled(true);
        }
        updating = false;
    }
    
    /** Enable or disable fields. */
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        descriptionLabel.setEnabled(enabled);
        descriptionText.setEnabled(enabled);
        topicLabel.setEnabled(enabled);
        topicCombo.setEnabled(enabled);
        notesLabel.setEnabled(enabled);
        notesEditorPane.setEnabled(enabled);
        notesEditorPane.setEditable(false);
        tickleLabel.setEnabled(enabled);
        tickleDateField.setEnabled(enabled);
    }
    
    public void addNotify() {
        super.addNotify();
        addListeners();
    }
    
    public void removeNotify() {
        removeListeners();
        super.removeNotify();
    }
    
    public void deactivate() {
        // focus retention problem on Mac
        if (Utilities.getOperatingSystem() == Utilities.OS_MAC) {
            if (descriptionText.hasFocus()) {
                changedDescription();
            }
        }
    }
    
    private void addListeners() {
        descriptionFocusListener = new FocusAdapter() {
            public void focusLost(FocusEvent evt) {
                changedDescription();
            }
        };
        descriptionText.addFocusListener(descriptionFocusListener);
        
        topicActionListener = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                changedTopic();
            }
        };
        topicCombo.addActionListener(topicActionListener);
        
//        notesDocumentListener = new DocumentListener() {
//            public void changedUpdate(DocumentEvent arg0) { changedNotes(); }
//            public void insertUpdate(DocumentEvent arg0) { changedNotes(); }
//            public void removeUpdate(DocumentEvent arg0) { changedNotes(); }
//        };
        notesDocumentListener = new LazyDocumentListener() {
            public void update() {
                changedNotes();
            }
        };
        notesEditorPane.addDocumentListener(notesDocumentListener);
        
        notesHyperlinkListener = new HyperlinkListener() {
            public void hyperlinkUpdate(HyperlinkEvent evt) {
                hyperlink(evt);
            }
        };
        notesEditorPane.addHyperlinkListener(notesHyperlinkListener);
        
        tickleDatePropertyChangeListener = new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent e) {
                changedTickle((Date)e.getNewValue());
            }
        };
        tickleDateField.addPropertyChangeListener("value", tickleDatePropertyChangeListener);
    }
    
    private void removeListeners() {
        descriptionText.removeFocusListener(descriptionFocusListener);
        topicCombo.removeActionListener(topicActionListener);
        notesEditorPane.removeDocumentListener(notesDocumentListener);
        notesEditorPane.removeHyperlinkListener(notesHyperlinkListener);
        this.tickleDateField.removePropertyChangeListener(tickleDatePropertyChangeListener);
        
        descriptionFocusListener = null;
        topicActionListener = null;
        notesDocumentListener = null;
        notesHyperlinkListener = null;
        tickleDatePropertyChangeListener = null;
    }
    
    private void hyperlink(HyperlinkEvent evt) {
        if (evt.getURL() == null) return;
        
        if (evt.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
            tr.runtime.Open.open(evt.getURL());
        }
    }
    
    /** Start editing if possible. */
    public void edit() {
        if (future == null) return;
        
        descriptionText.requestFocus();
    }
    
    private void changedDescription() {
        if (future == null) return;
        
        future.setDescription(descriptionText.getText());
    }
    
    private void changedTopic() {
        if (future == null) return;
        
        future.setTopic((Topic)topicCombo.getSelectedItem());
    }
    
    private void changedNotes() {
        if (future == null) return;
        
        future.setNotes(notesEditorPane.getText());
    }
    
    private void changedTickle(Date date) {
        if (future == null) return;
        
        future.setTickle(date);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        descriptionLabel = new javax.swing.JLabel();
        descriptionText = new javax.swing.JTextField();
        notesLabel = new javax.swing.JLabel();
        notesEditorPane = new tr.swing.editorpane.HyperEditorPane();
        topicLabel = new javax.swing.JLabel();
        topicsModel = new TopicsComboBoxModel(false);
        topicCombo = new TopicsComboBox(topicsModel);
        ;
        tickleLabel = new javax.swing.JLabel();
        tickleDateField = new tr.swing.date.field.DateField();

        descriptionLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        descriptionLabel.setText(NbBundle.getMessage(FuturePanel.class, "description")); // NOI18N

        notesLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        notesLabel.setText(NbBundle.getMessage(FuturePanel.class, "notes")); // NOI18N

        topicLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        topicLabel.setText(org.openide.util.NbBundle.getMessage(FuturePanel.class, "topic")); // NOI18N

        topicCombo.setMaximumSize(new java.awt.Dimension(250, 23));
        topicCombo.setMinimumSize(new java.awt.Dimension(250, 23));
        topicCombo.setPreferredSize(new java.awt.Dimension(250, 23));

        tickleLabel.setText(NbBundle.getMessage(FuturePanel.class, "FuturePanel.tickle")); // NOI18N

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                        .add(descriptionLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(topicLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                        .add(notesLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE))
                    .add(tickleLabel))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(descriptionText, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .add(topicCombo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(notesEditorPane, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .add(tickleDateField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(descriptionLabel)
                    .add(descriptionText, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(4, 4, 4)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(topicLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 22, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(topicCombo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(32, 32, 32)
                        .add(notesLabel))
                    .add(layout.createSequentialGroup()
                        .add(0, 0, 0)
                        .add(notesEditorPane, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(tickleLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(tickleDateField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .add(23, 23, 23))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel descriptionLabel;
    private javax.swing.JTextField descriptionText;
    private tr.swing.editorpane.HyperEditorPane notesEditorPane;
    private javax.swing.JLabel notesLabel;
    private tr.swing.date.field.DateField tickleDateField;
    private javax.swing.JLabel tickleLabel;
    private javax.swing.JComboBox topicCombo;
    private javax.swing.JLabel topicLabel;
    // End of variables declaration//GEN-END:variables
    
    private TopicsComboBoxModel topicsModel;
    private FocusListener descriptionFocusListener;
    private ActionListener topicActionListener;
    private DocumentListener notesDocumentListener;
    private HyperlinkListener notesHyperlinkListener;
    private PropertyChangeListener tickleDatePropertyChangeListener;
    
}
