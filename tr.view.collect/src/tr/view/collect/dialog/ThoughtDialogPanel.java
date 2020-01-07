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
package tr.view.collect.dialog;

import java.net.URL;
import javax.swing.JTextField;
import javax.swing.event.HyperlinkEvent;
import org.openide.util.NbBundle;
import tr.model.thought.Thought;
import tr.model.topic.Topic;
import tr.view.topics.TopicsComboBox;
import tr.view.topics.TopicsComboBoxModel;

/**
 * Thought panel.
 *
 * @author Jeremy Moore (jimoore@netspace.net.au)
 */
public class ThoughtDialogPanel extends javax.swing.JPanel {
    
    /** Constructs a new default instance. */
    public ThoughtDialogPanel() {
        initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        thoughtLabel = new javax.swing.JLabel();
        thoughtTextField = new javax.swing.JTextField();
        topicLabel = new javax.swing.JLabel();
        topicsModel = new TopicsComboBoxModel(false);
        topicCombo = new TopicsComboBox(topicsModel);
        notesEditorPane = new tr.swing.editorpane.HyperEditorPane();
        notesLabel = new javax.swing.JLabel();

        thoughtLabel.setBackground(javax.swing.UIManager.getDefaults().getColor("Nb.ScrollPane.Border.color"));
        thoughtLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        thoughtLabel.setText(NbBundle.getMessage(ThoughtDialogPanel.class, "thought")); // NOI18N

        thoughtTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                descriptionFocusGained(evt);
            }
        });

        topicLabel.setBackground(javax.swing.UIManager.getDefaults().getColor("Nb.ScrollPane.Border.color"));
        topicLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        topicLabel.setText(NbBundle.getMessage(ThoughtDialogPanel.class, "topic")); // NOI18N

        topicCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                topicActionPerformed(evt);
            }
        });

        notesEditorPane.addHyperlinkListener(new javax.swing.event.HyperlinkListener() {
            public void hyperlinkUpdate(javax.swing.event.HyperlinkEvent evt) {
                hyperlink(evt);
            }
        });

        notesLabel.setBackground(javax.swing.UIManager.getDefaults().getColor("Nb.ScrollPane.Border.color"));
        notesLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        notesLabel.setText(NbBundle.getMessage(ThoughtDialogPanel.class, "notes")); // NOI18N

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                    .add(notesLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, thoughtLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, topicLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, notesEditorPane, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .add(thoughtTextField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .add(topicCombo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 200, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(thoughtTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 22, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(thoughtLabel))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(topicLabel)
                    .add(topicCombo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 22, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(notesEditorPane, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE))
                    .add(layout.createSequentialGroup()
                        .add(41, 41, 41)
                        .add(notesLabel)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    
    private void descriptionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_descriptionFocusGained
        notesEditorPane.setEditable(true);
        notesEditorPane.getEditButton().setFocusable(false);
        notesEditorPane.getURLButton().setFocusable(false);
        notesEditorPane.getFileButton().setFocusable(false);
        notesEditorPane.getDateButton().setFocusable(false);
        notesEditorPane.getTimeButton().setFocusable(false);
    }//GEN-LAST:event_descriptionFocusGained
    
    private static final JTextField JTEXTFIELD = new JTextField();
    
    private void topicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_topicActionPerformed
        Topic topic = (Topic)topicCombo.getSelectedItem();
        if (topic == null) {
            thoughtTextField.setBackground(JTEXTFIELD.getBackground());
            thoughtTextField.setForeground(JTEXTFIELD.getForeground());
        } else {
            thoughtTextField.setBackground(topic.getBackground());
            thoughtTextField.setForeground(topic.getForeground());
        }
    }//GEN-LAST:event_topicActionPerformed
    
    private void hyperlink(javax.swing.event.HyperlinkEvent evt) {//GEN-FIRST:event_hyperlink
        URL url = evt.getURL();
        if (url == null) {
            return;
        }
        if (evt.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
            tr.runtime.Open.open(url);
        }
    }//GEN-LAST:event_hyperlink
    
    public void setDescription(String description) {
        thoughtTextField.setText(description);
    }
    
    public void setTopic(Topic topic) {
        topicCombo.setSelectedItem(topic);
    }
    
    public void setNotes(String notes) {
        notesEditorPane.setText(notes);
    }
    
    public String getDescription() {
        return thoughtTextField.getText();
    }
    
    public Topic getTopic() {
        return (Topic)topicCombo.getSelectedItem();
    }
    
    public String getNotes() {
        return notesEditorPane.getText();
    }
    
    public void focus() {
        thoughtTextField.requestFocusInWindow();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private tr.swing.editorpane.HyperEditorPane notesEditorPane;
    private javax.swing.JLabel notesLabel;
    private javax.swing.JLabel thoughtLabel;
    private javax.swing.JTextField thoughtTextField;
    private javax.swing.JComboBox topicCombo;
    private javax.swing.JLabel topicLabel;
    // End of variables declaration//GEN-END:variables
    
    private TopicsComboBoxModel topicsModel;
    private Thought thought;
    
}