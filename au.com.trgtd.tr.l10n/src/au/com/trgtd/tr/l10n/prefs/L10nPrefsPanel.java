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
package au.com.trgtd.tr.l10n.prefs;

import au.com.trgtd.tr.l10n.L10nUtils;
import au.com.trgtd.tr.l10n.Locale;
import java.awt.BorderLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import org.openide.util.NbBundle;

/**
 * TR member options panel.
 *  
 * @author <a href="mailto:jimoore@netspace.net.au">Jeremy Moore</a>
 */
public class L10nPrefsPanel extends javax.swing.JPanel {
   
    private final L10nPrefsOptionsPanelController controller;

    L10nPrefsPanel(L10nPrefsOptionsPanelController controller) {
        this.controller = controller;
        initComponents();
        add(getView(), BorderLayout.CENTER);
    }

    private JComponent getView() {
        enabledCheckBox = new JCheckBox(getMsg("access"));
        enabledCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                localeCombo.setEnabled(enabledCheckBox.isSelected());
            }
        });
        localeLabel = new JLabel(getMsg("locale"));
        localeCombo = new JComboBox(new DefaultComboBoxModel(Locale.values()));

        JPanel panel = new JPanel(new MigLayout("", "0[]2[]0", "0[]2[]0"));

        panel.add(enabledCheckBox, "span, wrap");

        panel.add(localeLabel, "align right, gapleft 30");
        panel.add(localeCombo, "align left, wrap");

        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setBorder(new EmptyBorder(0,0,0,0));
        return scrollPane;
    }

    private String getMsg(String key) {
        return NbBundle.getMessage(getClass(), key);
    }

    void load() {
        enabledCheckBox.setSelected(L10nPrefs.isEnabled());
        localeCombo.setSelectedItem(L10nPrefs.getLocale());
        localeCombo.setEnabled(enabledCheckBox.isSelected());        
    }

    void store() {
        boolean enabled = enabledCheckBox.isSelected();
        Locale locale = (Locale)localeCombo.getSelectedItem();
        if (locale == null) {
            locale = Locale.none;
        }
        
        L10nPrefs.setEnabled(enabled);
        L10nPrefs.setLanguage(locale);

        if (!enabled || locale == Locale.none) {
            L10nUtils.getDefault().setLocale(Locale.none);
        } else {
            L10nUtils.getDefault().setLocale(locale);
        }
    }

    boolean valid() {
        return true;
    }

    private JCheckBox enabledCheckBox;
    private JComboBox localeCombo;
    private JLabel localeLabel;
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(new java.awt.BorderLayout());
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
