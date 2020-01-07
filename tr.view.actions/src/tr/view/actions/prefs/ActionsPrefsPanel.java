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
package tr.view.actions.prefs;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
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
import tr.extract.Param.Item;
import tr.extract.ParamFont;

final class ActionsPrefsPanel extends JPanel {
    
    private final ActionsOptionsPanelController controller;
    
    ActionsPrefsPanel(ActionsOptionsPanelController controller) {
        this.controller = controller;
        initForm();
    }

    void load() {
        colourCheck.setSelected(ActionsPrefs.isReportUseColour());
        strikeCheck.setSelected(ActionsPrefs.isReportStrikeDone());
        items = (Vector<Item>) (new ParamFont(null, null)).getItems();
        fontCombo.setModel(new DefaultComboBoxModel(items));
        String font = ActionsPrefs.getReportFont();
        for (Item item : items) {
            if (item.value.equals(font)) {
                fontCombo.setSelectedItem(item);
                break;
            }
        }
    }

    void store() {
        ActionsPrefs.setReportUseColour(colourCheck.isSelected());
        ActionsPrefs.setReportStrikeDone(strikeCheck.isSelected());
        Item item = (Item) fontCombo.getSelectedItem();
        if (item != null) {
            ActionsPrefs.setReportFont(item.value);
        }
    }

    boolean valid() {
        return true;
    }

    private void initForm() {
        initComponents();
        add(getView(), BorderLayout.CENTER);
    }

    private JComponent getView() {
        titleLabel = new JLabel(getMsg("report.heading"));
        titleLabel.setFont(titleLabel.getFont().deriveFont(Font.BOLD));        
        fontLabel = new JLabel(getMsg("report.font"));
        fontCombo = new JComboBox();
        fontCombo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                controller.changed();
            }
        });
        colourCheck = new JCheckBox(getMsg("use.color"));
        strikeCheck = new JCheckBox(getMsg("strike.done"));

        JPanel panel = new JPanel(new MigLayout("", "0[]0", "0[]4[]2[]2[]0"));
        panel.add(titleLabel,  "align left, wrap");
        panel.add(fontLabel,   "align left, split 2");
        panel.add(fontCombo,   "align left, wrap");
        panel.add(colourCheck, "align left, wrap");
        panel.add(strikeCheck, "align left, wrap");
        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setBorder(new EmptyBorder(0,0,0,0));
        return scrollPane;
    }

    private String getMsg(String key) {
        return NbBundle.getMessage(ActionsPrefsPanel.class, key);
    }

    private JLabel titleLabel;
    private JLabel fontLabel;
    private JComboBox fontCombo;
    private JCheckBox colourCheck;
    private JCheckBox strikeCheck;
    private Vector<Item> items;

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(new java.awt.BorderLayout());
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
