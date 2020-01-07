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

package tr.view.actions.screens;

import javax.swing.JDialog;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import org.openide.util.NbBundle;
import org.openide.windows.WindowManager;

/**
 * Review actions screen columns dialog.
 *
 * @author Jeremy Moore (jimoore@netspace.net.au)
 */
public class ColumnsDialog extends JDialog {
    
    /** Creates new form ColumnsDialog */
    public ColumnsDialog(ActionsScreen screen) {
        super(WindowManager.getDefault().getMainWindow(), true);
        this.screen = screen;
        initComponents();
    }    

    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        scrollPane = new javax.swing.JScrollPane();
        table = getTable();
        bottomPanel = new javax.swing.JPanel();
        closeButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(getText("ColumnsDialog.title")); // NOI18N
        setModal(true);
        scrollPane.setFocusable(false);
        scrollPane.setOpaque(false);
        scrollPane.setPreferredSize(new java.awt.Dimension(300, 500));
        table.setFocusable(false);
        table.setGridColor(java.awt.SystemColor.control);
        table.setRowSelectionAllowed(false);
        table.setShowHorizontalLines(false);
        table.setShowVerticalLines(false);
        scrollPane.setViewportView(table);

        getContentPane().add(scrollPane, java.awt.BorderLayout.CENTER);

        bottomPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 20, 5));

        bottomPanel.setFocusable(false);
        closeButton.setText(getText("ColumnsDialog.close")); // NOI18N
        closeButton.setFocusCycleRoot(true);
        closeButton.setSelected(true);
        getRootPane().setDefaultButton(closeButton);

        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeActionPerformed(evt);
            }
        });

        bottomPanel.add(closeButton);

        getContentPane().add(bottomPanel, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeActionPerformed
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeActionPerformed
    
    private JTable getTable() {
        JTable t = new JTable(getTableModel());
        
        // left justify headings
        JTableHeader tableHeader = t.getTableHeader();
        TableCellRenderer tcr = tableHeader.getDefaultRenderer();
        if (tcr instanceof DefaultTableCellRenderer) {
            ((DefaultTableCellRenderer)tcr).setHorizontalAlignment(SwingConstants.LEFT);
        }
        
        // set renderers and column sizes
        for (int column = 0; column < getTableModel().getColumnCount(); column++) {
            TableColumn tc = t.getColumnModel().getColumn(column);
            if (tableModel.getTableCellRenderer(column) != null) {
                tc.setCellRenderer(tableModel.getTableCellRenderer(column));
            }
            if (tableModel.getMaximumWidth(column) > -1) {
                tc.setMaxWidth(tableModel.getMaximumWidth(column));
            }
            if (tableModel.getMinimumWidth(column) > -1) {
                tc.setMinWidth(tableModel.getMinimumWidth(column));
            }
            if (tableModel.getPreferredWidth(column) > -1) {
                tc.setPreferredWidth(tableModel.getPreferredWidth(column));
            }
        }
        
        t.setRowHeight(24);
        
        return t;
    }
    
    private TableModel getTableModel() {
        if (tableModel == null) {
            tableModel = new ColumnsTableModel(screen);
        }
        return tableModel;
    }
    
    private String getText(String key) {
        return NbBundle.getMessage(getClass(), key);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bottomPanel;
    private javax.swing.JButton closeButton;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
    
    private final ActionsScreen screen;
    private ColumnsTableModel tableModel;
    
}
