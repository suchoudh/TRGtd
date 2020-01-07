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
package tr.extract;

import au.com.trgtd.tr.appl.Constants;
import java.awt.AWTError;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.text.DateFormat;
import java.util.List;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import org.openide.windows.WindowManager;
import tr.extract.Param.Item;
import tr.extract.Param.Type;
import tr.swing.date.combo.DateCombo;
import tr.swing.date.combo.DateItem;
import tr.swing.date.combo.DateType;

/**
 * Parameters dialog.
 *
 * @author Jeremy Moore (jimoore@netspace.net.au)
 */
public class ParamsDialog extends JDialog {

    private static final DateFormat df = Constants.DATE_FORMAT_FIXED;
    private static final Dimension COMBOBOX_SIZE = new Dimension(300, 24);
    private static final Dimension CHECKBOX_SIZE = new Dimension(100, 21);
    private final String id;
    private final List<Param> params;
    private int option;
    private boolean remember;
    private List<JComponent> components;
    private JButton okButton;
    private JButton cancelButton;

    /**
     * Constructs a new instance.
     * @param owner The parent frame.
     * @param title The dialog title.
     * @param params The list of parameters.
     */
    public ParamsDialog(String name, String id, List<Param> params) {
        super(WindowManager.getDefault().getMainWindow(), name, true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.id = id;
        this.params = params;
        construct(name, id, params);
    }

    private void construct(String name, String id, List<Param> params) {

        loadSelectionValues(id, params);

        int rows = params.size();
        int cols = 1;
        int hgap = 0;
        int vgap = 0;

        JPanel panelLabels = new JPanel(new GridLayout(rows, cols, hgap, vgap));
        JPanel panelFields = new JPanel(new GridLayout(rows, cols, hgap, vgap));

        components = new Vector<JComponent>();

        for (Param param : params) {
            if (param.type == Type.CHECKBOX) {
                JCheckBox checkbox = new JCheckBox();
                checkbox.setPreferredSize(CHECKBOX_SIZE);
                checkbox.setSelected(Boolean.parseBoolean(param.getValue()));
                components.add(checkbox);
                panelLabels.add(new JLabel(param.display + "      "));
                panelFields.add(checkbox);
            } else if (param.type == Type.COMBOBOX) {
                List<Item> items = param.getItems();
                if (items != null && items.size() > 0) {
                    JComboBox combo = new JComboBox(items.toArray());
                    combo.setPreferredSize(COMBOBOX_SIZE);
                    if (param.getValue() != null && !param.getValue().trim().equals("")) {
                        // set selected item
                        for (int i = 0; i < items.size(); i++) {
                            Item item = items.get(i);
                            if (item.value.equals(param.getValue())) {
                                combo.setSelectedIndex(i);
                                break;
                            }
                        }
                    }
                    combo.setMaximumRowCount(Constants.COMBO_MAX_ROWS);
                    components.add(combo);
                    panelLabels.add(new JLabel(param.display + "      "));
                    panelFields.add(combo);
                }
            } else if (param.type == Type.DATESCOMBO) {
                List<DateItem> items = param.getDateItems();
                if (items != null && items.size() > 0) {
                    DateCombo combo = new DateCombo(this, items.toArray(new DateItem[0]), false, df);
                    combo.setPreferredSize(COMBOBOX_SIZE);
                    if (param.getValue() != null && !param.getValue().trim().equals("")) {
                        try {
                            long value = Long.parseLong(param.getValue());
                            if (value < 1000) { // assume days
                                combo.setSelectedItem(combo.getDateItem(DateType.DAYS, value));
                            } else { // assume a date value in milliseconds since ...
                                combo.setSelectedItem(combo.getDateItem(DateType.MS, value));
                            }
                        } catch (Exception ex) {
                            combo.setSelectedItem(null);
                        }
                    }
                    combo.setMaximumRowCount(Constants.COMBO_MAX_ROWS);
                    components.add(combo);
                    panelLabels.add(new JLabel(param.display + "      "));
                    panelFields.add(combo);
                }
            }
        }

        JPanel center = new JPanel(new BorderLayout());
        center.setBorder(BorderFactory.createEmptyBorder());
        center.add(BorderLayout.WEST, panelLabels);
        center.add(BorderLayout.CENTER, panelFields);

        JCheckBox rememberCheckBox = new JCheckBox(org.openide.util.NbBundle.getMessage(ParamsDialog.class, "Remember_options"));
        rememberCheckBox.setSelected(false);
        rememberCheckBox.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                remember = ((JCheckBox) evt.getSource()).isSelected();
            }
        });

        JPanel north = new JPanel();
        north.setPreferredSize(new Dimension(0, 16));
        JPanel east = new JPanel();
        east.setPreferredSize(new Dimension(80, 0));
        JPanel west = new JPanel();
        west.setPreferredSize(new Dimension(80, 0));
        JPanel south = new JPanel();
        south.setPreferredSize(new Dimension(0, 16));

        JPanel main = new JPanel(new BorderLayout());
        main.setBorder(BorderFactory.createEmptyBorder());
        main.add(north, BorderLayout.NORTH);
        main.add(center, BorderLayout.CENTER);
        main.add(east, BorderLayout.EAST);
        main.add(west, BorderLayout.WEST);
        main.add(south, BorderLayout.SOUTH);

        JPanel filler = new JPanel(new BorderLayout());
        filler.add(main, BorderLayout.NORTH);
        filler.add(new JPanel(), BorderLayout.CENTER);

        cancelButton = new JButton(org.openide.util.NbBundle.getMessage(ParamsDialog.class, "Cancel"));
        cancelButton.putClientProperty(Constants.BUTTON_TYPE, Constants.BUTTON_TYPE_TEXT);
        cancelButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                cancel();
            }
        });
        okButton = new JButton(org.openide.util.NbBundle.getMessage(ParamsDialog.class, "OK"));
        okButton.putClientProperty(Constants.BUTTON_TYPE, Constants.BUTTON_TYPE_TEXT);
        okButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                ok();
            }
        });
        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.RIGHT, 2, 2));
        buttons.setPreferredSize(new Dimension(0, 36));
        buttons.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 36));
        buttons.add(rememberCheckBox);
        buttons.add(new JLabel("   "));
        buttons.add(cancelButton);
        buttons.add(okButton);

        add(new JScrollPane(filler), BorderLayout.CENTER);
        add(buttons, BorderLayout.SOUTH);

        pack();

        Dimension screenSize;
        try {
            screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        } catch (AWTError awe) {
            screenSize = new Dimension(640, 480);
        }
        Dimension frameSize = getSize();
        if (frameSize.height > screenSize.height) {
            frameSize.height = screenSize.height;
        }
        if (frameSize.width > screenSize.width) {
            frameSize.width = screenSize.width;
        }
        int x = screenSize.width / 2 - frameSize.width / 2;
        int y = screenSize.height / 2 - frameSize.height / 2;
        setLocation(x, y);
    }

    /* Handle OK. */
    private void ok() {
        option = JOptionPane.OK_OPTION;
        setVisible(false);
        dispose();
    }

    /* Handle Cancel. */
    private void cancel() {
        option = JOptionPane.CANCEL_OPTION;
        setVisible(false);
        dispose();
    }

    private void loadSelectionValues(String id, List<Param> params) {
        for (Param param : params) {
            String value = ParamsPrefs.getParam(id, param.id);
            if (value != null) {
                param.setValue(value);
            }
        }
    }

    /** Transfers the user selection values into the parameter values. */
    public void transferSelectionValues() {
        for (int i = 0; i < components.size(); i++) {
            JComponent c = components.get(i);
            if (c instanceof DateCombo) {
                DateCombo dateCombo = (DateCombo) c;
                DateItem dateItem = (DateItem) dateCombo.getSelectedItem();
                params.get(i).setValue(Long.toString(dateItem.value));
            } else if (c instanceof JComboBox) {
                JComboBox combo = (JComboBox) c;
                Item item = (Item) combo.getSelectedItem();
                params.get(i).setValue(item.value);
            } else if (c instanceof JCheckBox) {
                JCheckBox checkbox = (JCheckBox) c;
                params.get(i).setValue(Boolean.toString(checkbox.isSelected()));
            }
        }
    }

    private void storeSelectionValues() {
        if (remember) {
            for (Param param : params) {
                ParamsPrefs.setParam(id, param.id, param.value);
            }
        }
    }

    /**
     * Gets the remember options value.
     * @return the remember options value.
     */
    public boolean remember() {
        return remember;
    }

    /**
     * Shows the dialog and returns the option selected by the user.
     * @return JOptionPane.OK_OPTION or JOptionPane.CANCEL_OPTION
     */
    public int showDialog() {
        option = JOptionPane.CANCEL_OPTION;
        getRootPane().setDefaultButton(okButton);
        setVisible(true);
        if (option == JOptionPane.OK_OPTION) {
            transferSelectionValues();
            storeSelectionValues();
        }
        return option;
    }
}
