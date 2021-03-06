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

package tr.swing.editorpane;

import javax.swing.JPanel;

/**
 * Panel for URL entry.
 *
 * @author Jeremy Moore (jimoore@netscape.net.au)
 */
final class URLDialogPanel extends JPanel {
    
    /** Creates new form URLPanel */
    public URLDialogPanel() {
        initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        urlLabel = new javax.swing.JLabel();
        urlTextField = new javax.swing.JTextField();
        urlHintLabel = new javax.swing.JLabel();
        textLabel = new javax.swing.JLabel();
        textHintLabel = new javax.swing.JLabel();
        textTextField = new javax.swing.JTextField();

        setPreferredSize(new java.awt.Dimension(500, 130));

        urlLabel.setText(org.openide.util.NbBundle.getMessage(URLDialogPanel.class, "url")); // NOI18N

        urlHintLabel.setForeground(javax.swing.UIManager.getDefaults().getColor("controlDkShadow"));
        urlHintLabel.setText(org.openide.util.NbBundle.getMessage(URLDialogPanel.class, "url.hint")); // NOI18N

        textLabel.setText(org.openide.util.NbBundle.getMessage(URLDialogPanel.class, "text")); // NOI18N

        textHintLabel.setForeground(javax.swing.UIManager.getDefaults().getColor("controlDkShadow"));
        textHintLabel.setText(org.openide.util.NbBundle.getMessage(URLDialogPanel.class, "text.hint")); // NOI18N

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(urlLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 41, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(urlTextField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(textLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 41, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(7, 7, 7)
                        .add(textTextField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED))
                    .add(urlHintLabel)
                    .add(textHintLabel))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(urlLabel)
                    .add(urlTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(2, 2, 2)
                .add(urlHintLabel)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(textLabel)
                    .add(textTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(2, 2, 2)
                .add(textHintLabel)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    public void initView() {
        urlTextField.requestFocusInWindow();
        urlTextField.setText(DEFAULT_START);
        urlTextField.setCaretPosition(DEFAULT_START.length());
    }        
    
    public String getURL() {
        return urlTextField.getText();
    }

    public String getLinkText() {
        return textTextField.getText();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel textHintLabel;
    private javax.swing.JLabel textLabel;
    private javax.swing.JTextField textTextField;
    private javax.swing.JLabel urlHintLabel;
    private javax.swing.JLabel urlLabel;
    private javax.swing.JTextField urlTextField;
    // End of variables declaration//GEN-END:variables
    
//  public final static String DEFAULT_START = "http://www.";    
    public final static String DEFAULT_START = "";    
    
}
