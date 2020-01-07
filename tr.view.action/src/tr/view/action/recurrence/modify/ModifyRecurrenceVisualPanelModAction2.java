/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.view.action.recurrence.modify;

import au.com.trgtd.tr.appl.Constants;
import java.util.Date;
import javax.swing.JPanel;
import tr.model.action.Action;
import tr.model.action.ActionStateScheduled;
import tr.model.action.Recurrence;

public final class ModifyRecurrenceVisualPanelModAction2 extends JPanel {

    private static long counter;
    private final Date currentStartDate;
    private final Date currentActionDate;

    /** Creates new form NewRecurrenceVisualPanel1 */
    public ModifyRecurrenceVisualPanelModAction2(Recurrence recurrence, Action action) {
        this.currentStartDate = recurrence.getStartDate();
        this.currentActionDate = ((ActionStateScheduled) action.getState()).getDate();
        initComponents();
        initPanel();
    }

    @Override
    public String getName() {
        return org.openide.util.NbBundle.getMessage(ModifyRecurrenceVisualPanelModAction2.class, "finalise.changes");
    }

    public Boolean isUpdate() {
        return updateCheckBox.isSelected();
    }

    public Boolean isUpdateAll() {
        return isUpdate() && updateAllRadioButton.isSelected();
    }

    public Date getUpdateDate() {
        if (!isUpdate()) {
            return null;
        }
        if (isUpdateAll()) {
            return null;
        }
        if (updateStartDateRadioButton.isSelected()) {
            return currentStartDate;
        }
        if (updateActionDateRadioButton.isSelected()) {
            return currentActionDate;
        }
        if (updateEnterDateRadioButton.isSelected()) {
            return updateEnterDateField.getDate();
        }
        return null;
    }

    private void updateChanged() {
        putClientProperty("state.change", Long.valueOf(++counter));
        enableDisableFields();
    }

    private void enableDisableFields() {
        updateAllRadioButton.setEnabled(isUpdate());
        updateActionDateRadioButton.setEnabled(isUpdate());
        updateStartDateRadioButton.setEnabled(isUpdate());
        updateEnterDateRadioButton.setEnabled(isUpdate());
        updateEnterDateField.setEnabled(isUpdate() && updateEnterDateRadioButton.isSelected());
    }

    private void initPanel() {
        updateCheckBox.setSelected(true);
        updateActionDateRadioButton.setSelected(true);        
        String strActionDate = Constants.DATE_FORMAT_FIXED.format(currentActionDate);
        updateActionDateRadioButton.setText(updateActionDateRadioButton.getText() + " (" + strActionDate + ")");
        String strStartDate = Constants.DATE_FORMAT_FIXED.format(currentStartDate);
        updateStartDateRadioButton.setText(updateStartDateRadioButton.getText() + " (" + strStartDate + ")");
        updateChanged();
    }

    public boolean isFormValid() {
        return !isUpdate() || isUpdateAll() || getUpdateDate() != null;
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        movebuttonGroup = new javax.swing.ButtonGroup();
        updateCheckBox = new javax.swing.JCheckBox();
        updateAllRadioButton = new javax.swing.JRadioButton();
        updateStartDateRadioButton = new javax.swing.JRadioButton();
        updateActionDateRadioButton = new javax.swing.JRadioButton();
        updateEnterDateRadioButton = new javax.swing.JRadioButton();
        updateEnterDateField = new tr.swing.date.field.DateField();
        fillerLabel = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(1024, 768));
        setMinimumSize(new java.awt.Dimension(640, 480));
        setPreferredSize(new java.awt.Dimension(640, 480));

        org.openide.awt.Mnemonics.setLocalizedText(updateCheckBox, org.openide.util.NbBundle.getMessage(ModifyRecurrenceVisualPanelModAction2.class, "update.values")); // NOI18N
        updateCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateCheckBoxActionPerformed(evt);
            }
        });

        movebuttonGroup.add(updateAllRadioButton);
        org.openide.awt.Mnemonics.setLocalizedText(updateAllRadioButton, org.openide.util.NbBundle.getMessage(ModifyRecurrenceVisualPanelModAction2.class, "all")); // NOI18N
        updateAllRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateAllRadioButtonActionPerformed(evt);
            }
        });

        movebuttonGroup.add(updateStartDateRadioButton);
        org.openide.awt.Mnemonics.setLocalizedText(updateStartDateRadioButton, org.openide.util.NbBundle.getMessage(ModifyRecurrenceVisualPanelModAction2.class, "dated.from.recurrence.start.date")); // NOI18N
        updateStartDateRadioButton.setMaximumSize(new java.awt.Dimension(178, 23));
        updateStartDateRadioButton.setMinimumSize(new java.awt.Dimension(178, 23));
        updateStartDateRadioButton.setPreferredSize(new java.awt.Dimension(178, 23));
        updateStartDateRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateStartDateRadioButtonActionPerformed(evt);
            }
        });

        movebuttonGroup.add(updateActionDateRadioButton);
        org.openide.awt.Mnemonics.setLocalizedText(updateActionDateRadioButton, org.openide.util.NbBundle.getMessage(ModifyRecurrenceVisualPanelModAction2.class, "dated.from.selected.action.date")); // NOI18N
        updateActionDateRadioButton.setMaximumSize(new java.awt.Dimension(178, 23));
        updateActionDateRadioButton.setMinimumSize(new java.awt.Dimension(178, 23));
        updateActionDateRadioButton.setPreferredSize(new java.awt.Dimension(178, 23));
        updateActionDateRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionDateRadioButtonActionPerformed(evt);
            }
        });

        movebuttonGroup.add(updateEnterDateRadioButton);
        org.openide.awt.Mnemonics.setLocalizedText(updateEnterDateRadioButton, org.openide.util.NbBundle.getMessage(ModifyRecurrenceVisualPanelModAction2.class, "dated.from")); // NOI18N
        updateEnterDateRadioButton.setMaximumSize(new java.awt.Dimension(100, 23));
        updateEnterDateRadioButton.setMinimumSize(new java.awt.Dimension(100, 23));
        updateEnterDateRadioButton.setPreferredSize(new java.awt.Dimension(100, 23));
        updateEnterDateRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateEnterDateRadioButtonActionPerformed(evt);
            }
        });

        updateEnterDateField.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                updateEnterDateFieldPropertyChange(evt);
            }
        });

        fillerLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        fillerLabel.setMaximumSize(new java.awt.Dimension(100, 23));
        fillerLabel.setMinimumSize(new java.awt.Dimension(100, 23));
        fillerLabel.setPreferredSize(new java.awt.Dimension(100, 23));

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(updateCheckBox, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE)
                    .add(layout.createSequentialGroup()
                        .add(fillerLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(updateAllRadioButton, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                                .add(updateEnterDateRadioButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 150, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(updateEnterDateField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(org.jdesktop.layout.GroupLayout.LEADING, updateStartDateRadioButton, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE)
                            .add(updateActionDateRadioButton, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(updateCheckBox)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, fillerLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, updateAllRadioButton, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .add(7, 7, 7)
                .add(updateStartDateRadioButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(updateActionDateRadioButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(updateEnterDateField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(updateEnterDateRadioButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(326, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    private void updateEnterDateRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateEnterDateRadioButtonActionPerformed
        updateChanged();
}//GEN-LAST:event_updateEnterDateRadioButtonActionPerformed

    private void updateActionDateRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionDateRadioButtonActionPerformed
        updateChanged();
}//GEN-LAST:event_updateActionDateRadioButtonActionPerformed

    private void updateStartDateRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateStartDateRadioButtonActionPerformed
        updateChanged();
}//GEN-LAST:event_updateStartDateRadioButtonActionPerformed

    private void updateEnterDateFieldPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_updateEnterDateFieldPropertyChange
        updateChanged();
}//GEN-LAST:event_updateEnterDateFieldPropertyChange

    private void updateCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateCheckBoxActionPerformed
        updateChanged();
}//GEN-LAST:event_updateCheckBoxActionPerformed

    private void updateAllRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateAllRadioButtonActionPerformed
        updateChanged();
}//GEN-LAST:event_updateAllRadioButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel fillerLabel;
    private javax.swing.ButtonGroup movebuttonGroup;
    private javax.swing.JRadioButton updateActionDateRadioButton;
    private javax.swing.JRadioButton updateAllRadioButton;
    private javax.swing.JCheckBox updateCheckBox;
    private tr.swing.date.field.DateField updateEnterDateField;
    private javax.swing.JRadioButton updateEnterDateRadioButton;
    private javax.swing.JRadioButton updateStartDateRadioButton;
    // End of variables declaration//GEN-END:variables
}

