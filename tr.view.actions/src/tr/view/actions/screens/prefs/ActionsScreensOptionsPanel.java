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

package tr.view.actions.screens.prefs;

import au.com.thinkingrock.tr.resource.Icons;
import javax.swing.JPanel;
import tr.model.util.Manager;
import tr.view.actions.screens.ActionsScreen;
import tr.view.actions.screens.ActionsScreens;
import tr.view.actions.screens.dao.ScreensDAO;
import tr.view.actions.screens.dao.ScreensDAOProvider;

final class ActionsScreensOptionsPanel extends JPanel {
    
    ActionsScreensOptionsPanel(ActionsScreensOptionsPanelController controller) {
        this.controller = controller;
        initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        tableScrollPane = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        toolbar = new javax.swing.JToolBar();
        addButton = new javax.swing.JButton();
        delButton = new javax.swing.JButton();
        downButton = new javax.swing.JButton();
        upButton = new javax.swing.JButton();

        setBackground(java.awt.Color.white);
        setPreferredSize(new java.awt.Dimension(580, 430));

        mainPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
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

        downButton.setIcon(Icons.Down);
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
                .addContainerGap()
                .add(toolbar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(2, 2, 2)
                .add(tableScrollPane, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE)
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(mainPanelLayout.createSequentialGroup()
                .add(mainPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(mainPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .add(tableScrollPane, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE))
                    .add(mainPanelLayout.createSequentialGroup()
                        .add(37, 37, 37)
                        .add(toolbar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 112, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(mainPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(mainPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    
    private void selectTableRow(int row) {
        table.changeSelection(row, 0, false, false);
    }
    
    private void upActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upActionPerformed
        int row = table.getSelectedRow();
        if (row == -1) return;
        
        ActionsScreensOptionsTableModel tm = (ActionsScreensOptionsTableModel)table.getModel();
        if (tm == null) return;
        
        if (tm.moveUp(row)) {
            selectTableRow(row - 1);
        }
    }//GEN-LAST:event_upActionPerformed
    
    private void downActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_downActionPerformed
        int row = table.getSelectedRow();
        if (row == -1) return;
        
        ActionsScreensOptionsTableModel tm = (ActionsScreensOptionsTableModel)table.getModel();
        if (tm == null) return;
        
        if (tm.moveDown(row)) {
            selectTableRow(row + 1);
        }
    }//GEN-LAST:event_downActionPerformed
    
    private void removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeActionPerformed
        int row = table.getSelectedRow();
        if (row == -1) return;
        
        ActionsScreensOptionsTableModel tm = (ActionsScreensOptionsTableModel)table.getModel();
        if (tm == null) return;
        
        if (tm.removeRow(row)) {
            if (row < table.getRowCount()) {
                selectTableRow(row);
            } else if (row > 0) {
                selectTableRow(row - 1);
            }
        }
    }//GEN-LAST:event_removeActionPerformed
    
    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        ActionsScreensOptionsTableModel tm = (ActionsScreensOptionsTableModel)table.getModel();
        if (tm == null) return;
        
        if (tm.addRow()) {
            int row = table.getRowCount() - 1;
            table.changeSelection(row, 0, false, false);
            table.requestFocus();
            table.editCellAt(row, 0);
        }
    }//GEN-LAST:event_addActionPerformed
    
    void load() {
        items = new Manager<ActionsScreensItem>();
        
        ActionsScreens screens = ScreensDAOProvider.instance().provide().getData();
        
        for (ActionsScreen screen : screens.getScreens().list()) {
            items.add(new ActionsScreensItem(screen.toString(), screen));
        }
        
        table.setModel(new ActionsScreensOptionsTableModel(items));
    }
    
    void store() {
        
        Manager<ActionsScreen> screens = new Manager<ActionsScreen>();
        
        for (ActionsScreensItem item : items.list()) {
            if (item.screen == null) {
                screens.add(ActionsScreen.create(item.name));
            } else {
                item.screen.setKey(item.name);
                screens.add(item.screen);
            }
        }
        
        ScreensDAO screensDAO = ScreensDAOProvider.instance().provide();
        screensDAO.getData().setScreens(screens);
        try {
            screensDAO.persist();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    boolean valid() {
        return true;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton delButton;
    private javax.swing.JButton downButton;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JTable table;
    private javax.swing.JScrollPane tableScrollPane;
    private javax.swing.JToolBar toolbar;
    private javax.swing.JButton upButton;
    // End of variables declaration//GEN-END:variables
    
    private final ActionsScreensOptionsPanelController controller;    
    private Manager<ActionsScreensItem> items;
    
}
