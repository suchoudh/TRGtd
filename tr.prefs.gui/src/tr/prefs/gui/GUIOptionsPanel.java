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

package tr.prefs.gui;

import au.com.trgtd.tr.appl.InitialAction;
import au.com.trgtd.tr.appl.InitialActionLookup;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
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
import org.openide.util.Lookup;
import org.openide.util.NbBundle;

final class GUIOptionsPanel extends JPanel {
    
    private final GUIOptionsPanelController controller;
    
    GUIOptionsPanel(GUIOptionsPanelController controller) {
        this.controller = controller;
        initComponents();
        add(getView(), BorderLayout.CENTER);
    }

    private JComponent getView() {
        initActions();
        initialActionLabel = new JLabel(getMsg("LBL_InitialWindow"));
        initialActionCombo = new JComboBox(new DefaultComboBoxModel(actions));
        initialActionCombo.setMaximumRowCount(actions.size());
        initialActionCombo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                controller.changed();
            }
        });
        initPositions();
        buttonsPositionLabel = new JLabel(getMsg("LBL_ButtonsPosition"));
        buttonsPositionCombo = new JComboBox(new DefaultComboBoxModel(positions));
        buttonsPositionCombo.setMaximumRowCount(positions.size());
        buttonsPositionCombo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                controller.changed();
            }
        });

        JPanel panel = new JPanel(new MigLayout("", "0[]2[]0", "0[]2[]0"));

        panel.add(initialActionLabel, "align right");
        panel.add(initialActionCombo, "align left, wrap");

        panel.add(buttonsPositionLabel, "align right");
        panel.add(buttonsPositionCombo, "align left, wrap");

        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setBorder(new EmptyBorder(0,0,0,0));
        return scrollPane;
    }

    private String getMsg(String key) {
        return NbBundle.getMessage(getClass(), key);
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
        initialActionCombo.setSelectedItem(getActionItem(GUIPrefs.getInitialActionID()));
        buttonsPositionCombo.setSelectedItem(getPositionItem(GUIPrefs.getButtonsPosition()));
    }

    private void initActions() {
        actions = new Vector<ComboItem>();
        actions.add(new ComboItem(INITIAL_NONE, GUIPrefs.INITIAL_ACTION_ID_NONE));
        Lookup.Result r = InitialActionLookup.instance().lookup(new Lookup.Template(InitialAction.class));
        Collection c = r.allInstances();
        for (Iterator iter = c.iterator(); iter.hasNext(); ) {
            InitialAction action = (InitialAction)iter.next();
            actions.add(new ComboItem(action.getName(), action.getID()));
        }
        Collections.sort(actions);
    }

    private void initPositions() {
        positions = new Vector<ComboItem>();
        positions.add(new ComboItem(TOP, GUIPrefs.BUTTONS_POSITION_TOP));
        positions.add(new ComboItem(BOTTOM, GUIPrefs.BUTTONS_POSITION_BOTTOM));
        positions.add(new ComboItem(LEFT, GUIPrefs.BUTTONS_POSITION_LEFT));
        positions.add(new ComboItem(RIGHT, GUIPrefs.BUTTONS_POSITION_RIGHT));
    }

    void store() {
        ComboItem actionItem = (ComboItem)initialActionCombo.getSelectedItem();
        if (actionItem != null) {
            GUIPrefs.setInitialWindowID(actionItem.value);
        }

        ComboItem positionItem = (ComboItem)buttonsPositionCombo.getSelectedItem();
        if (positionItem != null) {
            GUIPrefs.setButtonsPosition(positionItem.value);
        }
    }

    boolean valid() {
        return true;
    }

    private static final class ComboItem implements Comparable<ComboItem> {
        public String label;
        public String value;
        public ComboItem(String label, String value) {
            this.label = label;
            this.value = value;
        }
        @Override
        public String toString() {
            return label;
        }
        public int compareTo(ComboItem item) {
            if (value.equals(GUIPrefs.INITIAL_ACTION_ID_NONE)) {
                return -1;
            }
            return toString().compareToIgnoreCase(item.toString());
        }
    }

    private ComboItem getActionItem(String value) {
        for (ComboItem item : actions) {
            if (item.value.equals(value)) {
                return item;
            }
        }
        return actions.get(0);
    }

    private ComboItem getPositionItem(String value) {
        for (ComboItem item : positions) {
            if (item.value.equals(value)) {
                return item;
            }
        }
        return positions.get(0);
    }

    private static final Class clazz = GUIOptionsPanel.class;
    private static final String INITIAL_NONE = NbBundle.getMessage(clazz, "LBL_InitialWindowNone");
    private static final String TOP = NbBundle.getMessage(clazz, "LBL_Top");
    private static final String BOTTOM = NbBundle.getMessage(clazz, "LBL_Bottom");
    private static final String LEFT = NbBundle.getMessage(clazz, "LBL_Left");
    private static final String RIGHT = NbBundle.getMessage(clazz, "LBL_Right");
    private static Vector<ComboItem> actions;
    private static Vector<ComboItem> positions;
    private JComboBox buttonsPositionCombo;
    private JLabel buttonsPositionLabel;
    private JComboBox initialActionCombo;
    private JLabel initialActionLabel;

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setMinimumSize(new java.awt.Dimension(0, 0));
        setLayout(new java.awt.BorderLayout());
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
