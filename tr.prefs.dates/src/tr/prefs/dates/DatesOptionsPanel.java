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

package tr.prefs.dates;

import java.awt.BorderLayout;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import org.openide.util.NbBundle;

final class DatesOptionsPanel extends javax.swing.JPanel {
    
    private final DatesOptionsPanelController controller;
    
    DatesOptionsPanel(DatesOptionsPanelController controller) {
        this.controller = controller;
        initForm();
    }

    private void initForm() {
        initComponents();
        add(getView(), BorderLayout.CENTER);
    }

    private JComponent getView() {
        dayLabel = new javax.swing.JLabel(getMsg("Dates.FirstDayOfWeek"));
        dayCombo = new javax.swing.JComboBox();
        dayCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                controller.changed();
            }
        });
        
        orderLabel = new javax.swing.JLabel(getMsg("Dates.Order"));
        orderCombo = new javax.swing.JComboBox();
        orderCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                controller.changed();
            }
        });

        JPanel panel = new JPanel(new MigLayout("", "0[]2[]0", "0[]2[]0"));

        panel.add(dayLabel, "align left");
        panel.add(dayCombo, "align left, wrap");

        panel.add(orderLabel, "align right");
        panel.add(orderCombo, "align left, wrap");

        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setBorder(new EmptyBorder(0,0,0,0));
        return scrollPane;
    }

    private String getMsg(String key) {
        return NbBundle.getMessage(DatesOptionsPanel.class, key);
    }

    void load() {
        if (SwingUtilities.isEventDispatchThread()) {
            doLoad();
        } else {
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    doLoad();
                }
            });
        }
    }

    private void doLoad() {
        initDayItems();
        dayCombo.setModel(new DefaultComboBoxModel(days));
        dayCombo.setMaximumRowCount(days.size());
        dayCombo.setSelectedItem(getDayItem(DatesPrefs.getFirstDayOfWeek()));

        initOrderItems();
        orderCombo.setModel(new DefaultComboBoxModel(orders));
        orderCombo.setMaximumRowCount(orders.size());
        orderCombo.setSelectedItem(getOrderItem(DatesPrefs.getDateOrder()));
    }

    private void initDayItems() {
        days = new Vector<ComboItem>();
        days.add(new ComboItem(NbBundle.getMessage(getClass(), "Sunday"), DatesPrefs.SUNDAY));
        days.add(new ComboItem(NbBundle.getMessage(getClass(), "Monday"), DatesPrefs.MONDAY));
    }

    private void initOrderItems() {
        orders = new Vector<ComboItem>();
        orders.add(new ComboItem(NbBundle.getMessage(getClass(), "MMDDYY"), DatesPrefs.MMDDYY));
        orders.add(new ComboItem(NbBundle.getMessage(getClass(), "DDMMYY"), DatesPrefs.DDMMYY));
    }

    void store() {
        ComboItem dayItem = (ComboItem)dayCombo.getSelectedItem();
        if (dayItem != null) {
            DatesPrefs.setFirstDayOfWeek(dayItem.value);
        }
        ComboItem orderItem = (ComboItem)orderCombo.getSelectedItem();
        if (orderItem != null) {
            DatesPrefs.setDateOrder(orderItem.value);
        }
    }

    boolean valid() {
        return true;
    }

    private static final class ComboItem implements Comparable<ComboItem> {
        public final String label;
        public final int value;
        public ComboItem(String label, int value) {
            this.label = label;
            this.value = value;
        }
        @Override
        public String toString() {
            return label;
        }
        public int compareTo(ComboItem item) {
            return item.label.compareToIgnoreCase(label);
        }
    }

    private static Vector<ComboItem> days;

    private ComboItem getDayItem(int value) {
        for (ComboItem item : days) {
            if (item.value == value) {
                return item;
            }
        }
        return days.get(0);
    }

    private static Vector<ComboItem> orders;

    private ComboItem getOrderItem(int value) {
        for (ComboItem item : orders) {
            if (item.value == value) {
                return item;
            }
        }
        return orders.get(0);
    }

    private JComboBox dayCombo;
    private JLabel dayLabel;
    private JComboBox orderCombo;
    private JLabel orderLabel;

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setMinimumSize(new java.awt.Dimension(0, 0));
        setLayout(new java.awt.BorderLayout());
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
