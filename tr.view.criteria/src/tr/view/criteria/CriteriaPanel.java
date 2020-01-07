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
package tr.view.criteria;

import au.com.thinkingrock.tr.resource.Icons;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import org.jdesktop.swingx.JXTable;
import tr.model.Data;
import tr.model.DataLookup;
import tr.model.criteria.Criterion;

final class CriteriaPanel extends JPanel {

    private final Data data;
    private final Map<String, CriterionTableModel> map;

    /**
     * Constructs a new instance.
     * @param data The data model.
     */
    public CriteriaPanel() {
        this.data = (Data) DataLookup.instance().lookup(Data.class);
        this.map = new HashMap<String, CriterionTableModel>();
        initComponents();
        criteriaComboActionPerformed(null);
    }

    private DefaultTableModel getTableModel() {
        String HEADING_VALUES = org.openide.util.NbBundle.getMessage(CriteriaPanel.class, "heading.values");
        return new javax.swing.table.DefaultTableModel(new Object[][]{}, new String[]{HEADING_VALUES}) {
            public Class getColumnClass(int columnIndex) {
                return String.class;
            }
        };
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        criteriaCombo = new javax.swing.JComboBox();
        criteriaLabel = new javax.swing.JLabel();
        mainPanel = new javax.swing.JPanel();
        useCheckBox = new javax.swing.JCheckBox();
        tableScrollPane = new javax.swing.JScrollPane();
        table = getTable();
        toolbar = new javax.swing.JToolBar();
        addButton = new javax.swing.JButton();
        delButton = new javax.swing.JButton();
        downButton = new javax.swing.JButton();
        upButton = new javax.swing.JButton();

        criteriaCombo.setModel(getCriteraComboBoxModel());
        criteriaCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                criteriaComboActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(criteriaLabel, org.openide.util.NbBundle.getMessage(CriteriaPanel.class, "criterion")); // NOI18N

        mainPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        org.openide.awt.Mnemonics.setLocalizedText(useCheckBox, org.openide.util.NbBundle.getMessage(CriteriaPanel.class, "use.this.criterion")); // NOI18N
        useCheckBox.setMargin(new java.awt.Insets(0, 0, 0, 0));
        useCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                useActionPerformed(evt);
            }
        });

        table.setModel(getTableModel());
        tableScrollPane.setViewportView(table);

        toolbar.setFloatable(false);
        toolbar.setOrientation(1);
        toolbar.setMargin(new java.awt.Insets(2, 2, 2, 2));

        addButton.setIcon(Icons.Add);
        addButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addButton.setMaximumSize(new java.awt.Dimension(24, 24));
        addButton.setMinimumSize(new java.awt.Dimension(24, 24));
        addButton.setPreferredSize(new java.awt.Dimension(24, 24));
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        toolbar.add(addButton);

        delButton.setIcon(Icons.Delete);
        delButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        delButton.setMaximumSize(new java.awt.Dimension(24, 24));
        delButton.setMinimumSize(new java.awt.Dimension(24, 24));
        delButton.setPreferredSize(new java.awt.Dimension(24, 24));
        delButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeActionPerformed(evt);
            }
        });
        toolbar.add(delButton);

        downButton.setIcon(Icons.Down  );
        downButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        downButton.setMaximumSize(new java.awt.Dimension(24, 24));
        downButton.setMinimumSize(new java.awt.Dimension(24, 24));
        downButton.setPreferredSize(new java.awt.Dimension(24, 24));
        downButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                downActionPerformed(evt);
            }
        });
        toolbar.add(downButton);

        upButton.setIcon(Icons.Up);
        upButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        upButton.setMaximumSize(new java.awt.Dimension(24, 24));
        upButton.setMinimumSize(new java.awt.Dimension(24, 24));
        upButton.setPreferredSize(new java.awt.Dimension(24, 24));
        upButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upActionPerformed(evt);
            }
        });
        toolbar.add(upButton);

        org.jdesktop.layout.GroupLayout mainPanelLayout = new org.jdesktop.layout.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(mainPanelLayout.createSequentialGroup()
                .add(mainPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(mainPanelLayout.createSequentialGroup()
                        .add(9, 9, 9)
                        .add(toolbar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(1, 1, 1)
                        .add(tableScrollPane, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE))
                    .add(mainPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .add(useCheckBox)))
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(useCheckBox)
                .add(mainPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(mainPanelLayout.createSequentialGroup()
                        .add(12, 12, 12)
                        .add(tableScrollPane, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
                    .add(mainPanelLayout.createSequentialGroup()
                        .add(30, 30, 30)
                        .add(toolbar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 112, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, mainPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                        .add(criteriaLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 67, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(criteriaCombo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 210, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(criteriaLabel)
                    .add(criteriaCombo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(mainPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private JTable getTable() {
        JXTable jxtable = new JXTable();
        jxtable.setColumnControlVisible(false);
        jxtable.setSortable(false);
        jxtable.setShowGrid(false);
        jxtable.setColumnSelectionAllowed(false);
        jxtable.setCellSelectionEnabled(false);
        jxtable.setRowSelectionAllowed(true);
        jxtable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        return jxtable;
    }

    private void useActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_useActionPerformed
        Criterion criterion = (Criterion) criteriaCombo.getSelectedItem();
        if (criterion == null) {
            return;
        }
        criterion.setUse(useCheckBox.isSelected());
    }//GEN-LAST:event_useActionPerformed

    private void downActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_downActionPerformed
        int row = table.getSelectedRow();
        if (row == -1) {
            return;
        }
        CriterionTableModel tm = (CriterionTableModel) table.getModel();
        if (tm == null) {
            return;
        }
        table.requestFocusInWindow();

        if (tm.moveDown(row)) {
            selectTableRow(row + 1);
        }
    }//GEN-LAST:event_downActionPerformed

    private void upActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upActionPerformed
        int row = table.getSelectedRow();
        if (row == -1) {
            return;
        }
        CriterionTableModel tm = (CriterionTableModel) table.getModel();
        if (tm == null) {
            return;
        }
        table.requestFocusInWindow();

        if (tm.moveUp(row)) {
            selectTableRow(row - 1);
        }

    }//GEN-LAST:event_upActionPerformed

    private void removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeActionPerformed
        int row = table.getSelectedRow();
        if (row == -1) {
            return;
        }
        CriterionTableModel tm = (CriterionTableModel) table.getModel();
        if (tm == null) {
            return;
        }
        if (tm.removeRow(row)) {
            if (row < table.getRowCount()) {
                selectTableRow(row);
            } else if (row > 0) {
                selectTableRow(row - 1);
            }
        }
    }//GEN-LAST:event_removeActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        CriterionTableModel tm = (CriterionTableModel) table.getModel();
        if (tm == null) {
            return;
        }
        if (tm.addRow()) {
            int row = table.getRowCount() - 1;
            table.changeSelection(row, 0, false, false);
            table.requestFocus();
            table.editCellAt(row, 0);
        }
    }//GEN-LAST:event_addActionPerformed

    private void selectTableRow(final int row) {
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                table.requestFocusInWindow();
                table.changeSelection(row, 0, false, false);
            }
        });
    }

    private void criteriaComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_criteriaComboActionPerformed
        Criterion criterion = (Criterion) criteriaCombo.getSelectedItem();
        if (criterion == null) {
            table.setModel(null);
            return;
        }
        CriterionTableModel ctm = map.get(criterion.getName());
        if (ctm == null) {
            if ("priority".equals(criterion.key)) {
                ctm = new PriorityTableModel(criterion, data);                                
            } else {
                ctm = new CriterionTableModel(criterion, data);                
            }
            map.put(criterion.getName(), ctm);
        }
        table.setModel(ctm);
        
        
        
        //
        for (int i = 0; i < ctm.getColumnCount(); i++) {
            TableColumn tc = table.getColumnModel().getColumn(i);
            if (ctm.getMaxWidths()[i] > -1) {
                tc.setMaxWidth(ctm.getMaxWidths()[i]);
            }
            if (ctm.getMinWidths()[i] > -1) {
                tc.setMinWidth(ctm.getMaxWidths()[i]);
            }
            if (ctm.getPrefWidths()[i] > -1) {
                tc.setPreferredWidth(ctm.getPrefWidths()[i]);
            }
        }
        
        useCheckBox.setSelected(criterion.isUse());
    }//GEN-LAST:event_criteriaComboActionPerformed
    
    private ComboBoxModel getCriteraComboBoxModel() {
        if (data == null) {
            return new DefaultComboBoxModel();
        }
        Vector<Criterion> criteria = new Vector<Criterion>();
        criteria.add(data.getTimeCriterion());
        criteria.add(data.getEnergyCriterion());
        criteria.add(data.getPriorityCriterion());
        return new DefaultComboBoxModel(criteria);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JComboBox criteriaCombo;
    private javax.swing.JLabel criteriaLabel;
    private javax.swing.JButton delButton;
    private javax.swing.JButton downButton;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JTable table;
    private javax.swing.JScrollPane tableScrollPane;
    private javax.swing.JToolBar toolbar;
    private javax.swing.JButton upButton;
    private javax.swing.JCheckBox useCheckBox;
    // End of variables declaration//GEN-END:variables
    
}
