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
package tr.view.collect.screen;

import java.awt.BorderLayout;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableColumn;
import org.jdesktop.swingx.JXTable;
import tr.model.Data;
import tr.model.DataLookup;
import tr.model.thought.Thought;
import tr.view.collect.dialog.ThoughtDialog;

/**
 * Collect thoughts panel.
 *
 * @author Jeremy Moore (jimoore@netspace.net.au)
 */
public class CollectThoughtsPanel extends JPanel {
    
    /**
     * Creates a new instance for the given thought node provider.
     */
    public CollectThoughtsPanel(ThoughtNodeProvider thoughtProvider) {
        super();
        this.thoughtProvider = thoughtProvider;
        data = (Data)DataLookup.instance().lookup(Data.class);
        tableModel = new CollectThoughtsTableModel(data);
        initComponents();
    }
    
    private void initComponents() {
        initTable();
        initBodyPanel();
        initPanel();
    }
    
    private void initTable() {
        table = new JXTable(tableModel);
        table.setColumnControlVisible(true);
        table.setSortable(false);
        table.setEnabled(true);
        table.setFocusable(true);
        table.setShowGrid(true);
        table.setColumnSelectionAllowed(false);
        table.setCellSelectionEnabled(false);
        table.setRowSelectionAllowed(true);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    e.consume();
                    modify();
                } else if (e.getKeyCode() == KeyEvent.VK_DELETE) {
                    e.consume();
                    delete();
                }
            }
        });
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    modify();
                }
            }
        });
        ListSelectionModel rowSM = table.getSelectionModel();
        rowSM.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    rowSelectionChanged();
                }
            }
        });
        for (int i = 0; i < CollectThoughtsTableModel.CLASSES.length; i++) {
            TableColumn tc = table.getColumnModel().getColumn(i);
            if (tableModel.renderers[i] != null) {
                tc.setCellRenderer(tableModel.renderers[i]);
            }
            if (CollectThoughtsTableModel.MAX_WIDTHS[i] > -1) {
                tc.setMaxWidth(CollectThoughtsTableModel.MAX_WIDTHS[i]);
            }
            if (CollectThoughtsTableModel.MIN_WIDTHS[i] > -1) {
                tc.setMinWidth(CollectThoughtsTableModel.MIN_WIDTHS[i]);
            }
            if (CollectThoughtsTableModel.PREF_WIDTHS[i] > -1) {
                tc.setPreferredWidth(CollectThoughtsTableModel.PREF_WIDTHS[i]);
            }
        }
        tableScrollPane = new JScrollPane(table);
        tableScrollPane.setBorder(null);
        tableScrollPane.getVerticalScrollBar().setUnitIncrement(5);
        tableScrollPane.getHorizontalScrollBar().setUnitIncrement(5);
    }
    
    private void rowSelectionChanged() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow < 0) {
            thoughtProvider.provide(null);
            return;
        }
        Thought thought = tableModel.getValueAt(selectedRow);
        if (thought == null) {
            thoughtProvider.provide(null);
            return;
        }
        thoughtProvider.provide(new ThoughtNode(data.getThoughtManager(), thought));
    }
    
    private void initBodyPanel() {
        bodyPanel = new JPanel();
        bodyPanel.setLayout(new BorderLayout());
        bodyPanel.add(tableScrollPane, BorderLayout.CENTER);
    }
    
    private void initPanel() {
        setLayout(new BorderLayout());
        setBorder(new EmptyBorder(new Insets(2, 2, 2, 2)));
        add(bodyPanel, BorderLayout.CENTER);
    }
    
    public void create() {
        table.clearSelection();
        getThoughtDialog().showCreateDialog();
    }
    
    public void modify() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow < 0) return;
        
        Thought thought = tableModel.getValueAt(selectedRow);
        if (thought == null) return;
        
        getThoughtDialog().showModifyDialog(thought);
        
        selectRow(selectedRow);
    }
    
    private ThoughtDialog getThoughtDialog() {
// Changed since Java bug causes lost default button and no focus indication on
// GUI components after dispose() and subsequent show().
// See http://bugs.sun.com/bugdatabase/view_bug.do?bug_id=6199625
//        if (thoughtDialog == null) {
//            Component location = (Component)toolbar;
//            thoughtDialog = new ThoughtDialog(null, location, data);
//        }
//        return thoughtDialog;
// Instead create a new dialog every time - probably gobbles up memory.
        thoughtDialog = new ThoughtDialog(data);
        return thoughtDialog;
    }
    
    public void delete() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow < 0) return;
        
        Thought thought = tableModel.getValueAt(selectedRow);
        if (thought == null) return;
        
        data.getThoughtManager().remove(thought);
        
        try {
            Thread.sleep(400);
        } catch (InterruptedException ex) {
        }
        
        int rowCount = table.getRowCount();
        if (selectedRow < rowCount) {
            selectRow(selectedRow);
        } else if (rowCount > 0) {
            selectRow(rowCount - 1);
        }
    }
    
    private void selectRow(final int row) {
        if (row < 0 || row >= table.getRowCount()) {
            return;
        }
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                table.requestFocusInWindow();
                table.changeSelection(row, 0, false, false);
            }
        });
    }
    
    private final Data data;
    private final ThoughtNodeProvider thoughtProvider;
    private final CollectThoughtsTableModel tableModel;
    private JPanel bodyPanel;
    private JScrollPane tableScrollPane;
    private JXTable table;
    private ThoughtDialog createDialog;
    private ThoughtDialog thoughtDialog;

}
