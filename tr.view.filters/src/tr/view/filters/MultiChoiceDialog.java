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
 * Portions Copyright 2006-2009 Avente Pty Ltd. All Rights Reserved.
 */
package tr.view.filters;

import java.awt.Component;
import java.util.Collections;
import java.util.Vector;
import javax.swing.JDialog;
import org.openide.windows.WindowManager;

/**
 * A multiple choice dialog.
 *
 * @author <a href="mailto:jimoore@netspace.net.au">Jeremy Moore</a>
 */
public class MultiChoiceDialog<T extends Comparable<? super T>> extends JDialog {
    
    /** Creates new form MultiChoiceDialog */
//  public MultiChoiceDialog(Component comp, Vector<T> all, Vector<T> chosen) {
    public MultiChoiceDialog(Component comp, Vector<T> all, Vector<T> chosen, boolean sort) {
        super(WindowManager.getDefault().getMainWindow(), true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.all = all;
        this.sort = sort;
        if (sort) {
            Collections.sort(all);
        }
        setLocationRelativeTo(comp);
        initComponents();
        Vector<T> c = new Vector<T>(chosen);
        if (sort) {
            Collections.sort(chosen);
        }
        setChosen(c);
    }
    
    public void setVisible(boolean visible) {
        if (visible) {
            okay = false;
            super.setVisible(true);
        } else {
            super.setVisible(false);
            super.dispose();
        }
    }
    
    public boolean isOkay() {
        return okay;
    }
    
    public void setChosen(Vector<T> chosen) {
        this.chosen = chosen;
        
        choice = new Vector<T>();
        
        for (T t : all) {
            if (!chosen.contains(t)) {
                choice.add(t);
            }
        }
        
        if (sort) {
            Collections.sort(choice);
            Collections.sort(chosen);
        }
        
        choiceList.setListData(choice);
        chosenList.setListData(chosen);
    }
    
    public Vector<T> getChosen() {
        return chosen;
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        toolbar = new javax.swing.JToolBar();
        acceptButton = new javax.swing.JButton();
        rejectButton = new javax.swing.JButton();
        acceptAllButton = new javax.swing.JButton();
        rejectAllButton = new javax.swing.JButton();
        okButton = new javax.swing.JButton();
        choiceScrollPane = new javax.swing.JScrollPane();
        choiceList = new javax.swing.JList();
        chosenScrollPane = new javax.swing.JScrollPane();
        chosenList = new javax.swing.JList();
        choiceLabel = new javax.swing.JLabel();
        chosenLabel = new javax.swing.JLabel();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        toolbar.setFloatable(false);
        toolbar.setOrientation(1);
        toolbar.setMargin(new java.awt.Insets(2, 2, 2, 2));

        acceptButton.setFont(new java.awt.Font("Serif", 1, 10));
        acceptButton.setText(">");
        acceptButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        acceptButton.setMaximumSize(new java.awt.Dimension(28, 28));
        acceptButton.setMinimumSize(new java.awt.Dimension(28, 28));
        acceptButton.setPreferredSize(new java.awt.Dimension(28, 28));
        acceptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptActionPerformed(evt);
            }
        });
        toolbar.add(acceptButton);

        rejectButton.setFont(new java.awt.Font("Serif", 1, 10));
        rejectButton.setText("<");
        rejectButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        rejectButton.setMaximumSize(new java.awt.Dimension(28, 28));
        rejectButton.setMinimumSize(new java.awt.Dimension(28, 28));
        rejectButton.setPreferredSize(new java.awt.Dimension(28, 28));
        rejectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rejectActionPerformed(evt);
            }
        });
        toolbar.add(rejectButton);

        acceptAllButton.setFont(new java.awt.Font("Serif", 1, 10));
        acceptAllButton.setText(">>");
        acceptAllButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        acceptAllButton.setMaximumSize(new java.awt.Dimension(28, 28));
        acceptAllButton.setMinimumSize(new java.awt.Dimension(28, 28));
        acceptAllButton.setPreferredSize(new java.awt.Dimension(28, 28));
        acceptAllButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptAllActionPerformed(evt);
            }
        });
        toolbar.add(acceptAllButton);

        rejectAllButton.setFont(new java.awt.Font("Serif", 1, 10));
        rejectAllButton.setText("<<");
        rejectAllButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        rejectAllButton.setMaximumSize(new java.awt.Dimension(28, 28));
        rejectAllButton.setMinimumSize(new java.awt.Dimension(28, 28));
        rejectAllButton.setPreferredSize(new java.awt.Dimension(28, 28));
        rejectAllButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rejectAllActionPerformed(evt);
            }
        });
        toolbar.add(rejectAllButton);

        okButton.setText(org.openide.util.NbBundle.getMessage(MultiChoiceDialog.class, "ok")); // NOI18N
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okActionPerformed(evt);
            }
        });

        choiceList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                choiceListMouseClicked(evt);
            }
        });
        choiceScrollPane.setViewportView(choiceList);

        chosenList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                chosenListMouseClicked(evt);
            }
        });
        chosenScrollPane.setViewportView(chosenList);

        choiceLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        choiceLabel.setText(org.openide.util.NbBundle.getMessage(MultiChoiceDialog.class, "available")); // NOI18N

        chosenLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        chosenLabel.setText(org.openide.util.NbBundle.getMessage(MultiChoiceDialog.class, "selection")); // NOI18N

        cancelButton.setText(org.openide.util.NbBundle.getMessage(MultiChoiceDialog.class, "cancel")); // NOI18N
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(choiceScrollPane, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                            .add(choiceLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(toolbar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(chosenScrollPane, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                            .add(chosenLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(cancelButton)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(okButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(choiceLabel)
                            .add(chosenLabel))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(chosenScrollPane, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                            .add(choiceScrollPane, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)))
                    .add(layout.createSequentialGroup()
                        .add(44, 44, 44)
                        .add(toolbar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(okButton)
                    .add(cancelButton)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        setVisible(false);
    }//GEN-LAST:event_cancelButtonActionPerformed
    
    private void chosenListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chosenListMouseClicked
        if (evt.getClickCount() == 2) {
            rejectSelected();
        }
    }//GEN-LAST:event_chosenListMouseClicked
    
    private void choiceListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_choiceListMouseClicked
        if (evt.getClickCount() == 2) {
            acceptSelected();
        }
    }//GEN-LAST:event_choiceListMouseClicked
    
    private void okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okActionPerformed
        okay = true;
        setVisible(false);
    }//GEN-LAST:event_okActionPerformed
    
    private void rejectAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rejectAllActionPerformed
        rejectAll();
    }//GEN-LAST:event_rejectAllActionPerformed
    
    private void acceptAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceptAllActionPerformed
        acceptAll();
    }//GEN-LAST:event_acceptAllActionPerformed
    
    private void rejectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rejectActionPerformed
        rejectSelected();
    }//GEN-LAST:event_rejectActionPerformed
    
    private void acceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceptActionPerformed
        acceptSelected();
    }//GEN-LAST:event_acceptActionPerformed
    
    // move selected choice items to chosen
    private synchronized void acceptSelected() {
        try {
            int[] indices = choiceList.getSelectedIndices();
            if (indices == null || indices.length < 1) return;
            
            Vector<T> selected = new Vector<T>(indices.length);
            
            for (int i = 0; i < indices.length; i++) {
                selected.add(choice.get(indices[i]));
            }
            
            for (T t : selected) {
                choice.remove(t);
                chosen.add(t);
            }
            
            if (sort) {
                Collections.sort(choice);
                Collections.sort(chosen);
            }
            
            choiceList.setListData(choice);
            chosenList.setListData(chosen);
            
        } catch (IndexOutOfBoundsException ex) {
            // Ignore - happens if you hold shift down and double-click.
        }
    }
    
    // move selected chosen items to available
    private synchronized void rejectSelected() {
        try {
            int[] indices = chosenList.getSelectedIndices();
            if (indices == null || indices.length < 1) return;
            
            Vector<T> selected = new Vector<T>(indices.length);
            for (int i = 0; i < indices.length; i++) {
                selected.add(chosen.get(indices[i]));
            }
            
            for (T t : selected) {
                chosen.remove(t);
                choice.add(t);
            }
            
            if (sort) {
                Collections.sort(choice);
                Collections.sort(chosen);
            }
            
            choiceList.setListData(choice);
            chosenList.setListData(chosen);
            
        } catch (IndexOutOfBoundsException ex) {
            // happens if you hold shift down and double-click - ignore
        }
    }
    
    // move all items to chosen
    private synchronized void acceptAll() {
        choice.clear();
        chosen.clear();
        
        for (T t : all) {
            chosen.add(t);
        }
        
        if (sort) {
            Collections.sort(choice);
            Collections.sort(chosen);
        }
        
        choiceList.setListData(choice);
        chosenList.setListData(chosen);
    }
    
    // move all items to choice
    private synchronized void rejectAll() {
        chosen.clear();
        choice.clear();
        
        for (T t : all) {
            choice.add(t);
        }
        
        if (sort) {
            Collections.sort(choice);
            Collections.sort(chosen);            
        }
        
        choiceList.setListData(choice);
        chosenList.setListData(chosen);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton acceptAllButton;
    private javax.swing.JButton acceptButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel choiceLabel;
    private javax.swing.JList choiceList;
    private javax.swing.JScrollPane choiceScrollPane;
    private javax.swing.JLabel chosenLabel;
    private javax.swing.JList chosenList;
    private javax.swing.JScrollPane chosenScrollPane;
    private javax.swing.JButton okButton;
    private javax.swing.JButton rejectAllButton;
    private javax.swing.JButton rejectButton;
    private javax.swing.JToolBar toolbar;
    // End of variables declaration//GEN-END:variables
    
    private final Vector<T> all;
    private final boolean sort;
    private Vector<T> choice;
    private Vector<T> chosen;
    private boolean okay;
}
