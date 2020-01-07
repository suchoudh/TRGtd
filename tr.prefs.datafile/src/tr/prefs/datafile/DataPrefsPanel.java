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

package tr.prefs.datafile;

import java.awt.BorderLayout;
import java.awt.Component;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import net.miginfocom.swing.MigLayout;
import org.openide.windows.WindowManager;

final class DataPrefsPanel extends JPanel {
    
    private final DataOptionsPanelController controller;

    DataPrefsPanel(DataOptionsPanelController controller) {
        this.controller = controller;
        initForm();
    }

    void load() {
        folderText.setText(DataPrefs.getRecoveryPath());
    }

    void store() {
        if (valid()) {
            DataPrefs.setRecoveryPath(tidyPath(folderText.getText()));
        }
    }

    boolean valid() {
        String path = tidyPath(folderText.getText());
        return path.length() == 0 || (new File(path)).isDirectory();
    }

    private String tidyPath(String path) {
        path = path.trim();
        while (path.endsWith(File.separator)) {
            path = path.substring(0, path.length() - 1).trim();
        }
        return path;
    }

    private void initForm() {
        initComponents();
        add(getView(), BorderLayout.CENTER);
    }

    private JComponent getView() {

        folderLabel = new JLabel(Resources.getText("CTL_Folder"));

        folderText = new JTextField();
        folderText.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent arg0) {
                controller.changed();
            }
            public void removeUpdate(DocumentEvent arg0) {
                controller.changed();
            }
            public void changedUpdate(DocumentEvent arg0) {
                controller.changed();
            }            
        });

        browseButton = new JButton(Resources.getText("CTL_Browse"));
        browseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browse();
            }
        });

        JPanel panel = new JPanel(new MigLayout("", "0[]2[grow]2[]0", "0[]0"));

        panel.add(folderLabel,  "align left");
        panel.add(folderText,   "align left, growx 100");
        panel.add(browseButton, "align left");

        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setBorder(new EmptyBorder(0,0,0,0));
        return scrollPane;
    }

    private void browse() {
        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fc.setSelectedFile(new File(folderText.getText()));
        Component p = WindowManager.getDefault().getMainWindow();
        int returnVal = fc.showOpenDialog(p);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            try {
                folderText.setText(fc.getSelectedFile().getCanonicalPath());
            } catch (Exception ex) {
                folderText.setText("");
            }
        }
    }

    private JButton browseButton;
    private JLabel folderLabel;
    private JTextField folderText;

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(new java.awt.BorderLayout());
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
