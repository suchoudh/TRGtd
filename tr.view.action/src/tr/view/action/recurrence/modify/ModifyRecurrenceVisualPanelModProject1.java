package tr.view.action.recurrence.modify;

import au.com.trgtd.tr.appl.Constants;
import java.util.Date;
import javax.swing.JPanel;
import tr.model.action.Action;
import tr.model.action.ActionStateScheduled;
import tr.model.action.Recurrence;
import tr.model.project.Project;
import tr.util.Utils;

public final class ModifyRecurrenceVisualPanelModProject1 extends JPanel {

    private static long counter;
    private final Project currentProject;
    private final Date currentStartDate;
    private final Date currentActionDate;

    /** Creates new form NewRecurrenceVisualPanel1 */
    public ModifyRecurrenceVisualPanelModProject1(Recurrence recurrence, Action action) {
        this.currentProject = recurrence.getProject();
        this.currentStartDate = recurrence.getStartDate();
        this.currentActionDate = ((ActionStateScheduled) action.getState()).getDate();
        initComponents();
        initPanel();
    }

    @Override
    public String getName() {
        return org.openide.util.NbBundle.getMessage(ModifyRecurrenceVisualPanelModProject1.class, "change.project.details");
    }

    public Boolean isMoveAll() {
        return moveAllRadioButton.isSelected();
    }

    public Date getMoveDate() {
        if (isMoveAll()) {
            return null;
        }
        if (moveStartDateRadioButton.isSelected()) {
            return currentStartDate;
        }
        if (moveActionDateRadioButton.isSelected()) {
            return currentActionDate;
        }
        return null;
    }

    public Project getNewProject() {
        return (Project) projectNewComboBox.getSelectedItem();
    }

    private void moveChanged() {
        stateChange();
        enableDisableFields();
    }

    private void projectChanged() {
        stateChange();
    }

    private void stateChange() {
        putClientProperty("state.change", ++counter);
    }

    private void enableDisableFields() {
        projectCurrentComboBox.setEnabled(false);
        moveAllRadioButton.setEnabled(true);
        moveActionDateRadioButton.setEnabled(true);
        moveStartDateRadioButton.setEnabled(true);
    }

    private void initPanel() {
        projectCurrentComboBox.setSelectedItem(currentProject);
        projectNewComboBox.setSelectedItem(null);
//      moveAllRadioButton.setSelected(true);        
        moveActionDateRadioButton.setSelected(true);        
        String strActionDate = Constants.DATE_FORMAT_FIXED.format(currentActionDate);
        moveActionDateRadioButton.setText(moveActionDateRadioButton.getText() + " (" + strActionDate + ")");
        String strStartDate = Constants.DATE_FORMAT_FIXED.format(currentStartDate);
        moveStartDateRadioButton.setText(moveStartDateRadioButton.getText() + " (" + strStartDate + ")");
        moveChanged();
    }

    public boolean isFormValid() {
        if (Utils.equal(currentProject, getNewProject())) {
            return false;
        }
        return isMoveAll() || getMoveDate() != null;
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        movebuttonGroup = new javax.swing.ButtonGroup();
        moveStartDateRadioButton = new javax.swing.JRadioButton();
        moveActionDateRadioButton = new javax.swing.JRadioButton();
        projectCurrentLabel = new javax.swing.JLabel();
        projectCurrentComboBox = new tr.view.project.combo.ProjectsComboBox();
        projectNewLabel = new javax.swing.JLabel();
        projectNewComboBox = new tr.view.project.combo.ProjectsComboBox();
        fillerLabel = new javax.swing.JLabel();
        moveAllRadioButton = new javax.swing.JRadioButton();
        moveLabel = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(1024, 768));
        setMinimumSize(new java.awt.Dimension(480, 360));
        setPreferredSize(new java.awt.Dimension(640, 480));

        movebuttonGroup.add(moveStartDateRadioButton);
        org.openide.awt.Mnemonics.setLocalizedText(moveStartDateRadioButton, org.openide.util.NbBundle.getMessage(ModifyRecurrenceVisualPanelModProject1.class, "dated.from.recurrence.start.date")); // NOI18N
        moveStartDateRadioButton.setMaximumSize(new java.awt.Dimension(178, 23));
        moveStartDateRadioButton.setMinimumSize(new java.awt.Dimension(178, 23));
        moveStartDateRadioButton.setPreferredSize(new java.awt.Dimension(178, 23));
        moveStartDateRadioButton.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        moveStartDateRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moveStartDateRadioButtonActionPerformed(evt);
            }
        });

        movebuttonGroup.add(moveActionDateRadioButton);
        org.openide.awt.Mnemonics.setLocalizedText(moveActionDateRadioButton, org.openide.util.NbBundle.getMessage(ModifyRecurrenceVisualPanelModProject1.class, "dated.from.selected.action.date")); // NOI18N
        moveActionDateRadioButton.setMaximumSize(new java.awt.Dimension(178, 23));
        moveActionDateRadioButton.setMinimumSize(new java.awt.Dimension(178, 23));
        moveActionDateRadioButton.setPreferredSize(new java.awt.Dimension(178, 23));
        moveActionDateRadioButton.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        moveActionDateRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moveActionDateRadioButtonActionPerformed(evt);
            }
        });

        projectCurrentLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        org.openide.awt.Mnemonics.setLocalizedText(projectCurrentLabel, org.openide.util.NbBundle.getMessage(ModifyRecurrenceVisualPanelModProject1.class, "current.project")); // NOI18N
        projectCurrentLabel.setMaximumSize(new java.awt.Dimension(100, 23));
        projectCurrentLabel.setMinimumSize(new java.awt.Dimension(100, 23));
        projectCurrentLabel.setPreferredSize(new java.awt.Dimension(100, 23));

        projectCurrentComboBox.setEnabled(false);
        projectCurrentComboBox.setMaximumSize(new java.awt.Dimension(32767, 23));
        projectCurrentComboBox.setMinimumSize(new java.awt.Dimension(41, 23));
        projectCurrentComboBox.setPreferredSize(new java.awt.Dimension(41, 23));

        projectNewLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        org.openide.awt.Mnemonics.setLocalizedText(projectNewLabel, org.openide.util.NbBundle.getMessage(ModifyRecurrenceVisualPanelModProject1.class, "new.project")); // NOI18N
        projectNewLabel.setMaximumSize(new java.awt.Dimension(100, 23));
        projectNewLabel.setMinimumSize(new java.awt.Dimension(100, 23));
        projectNewLabel.setPreferredSize(new java.awt.Dimension(100, 23));

        projectNewComboBox.setMaximumSize(new java.awt.Dimension(32767, 23));
        projectNewComboBox.setMinimumSize(new java.awt.Dimension(41, 23));
        projectNewComboBox.setPreferredSize(new java.awt.Dimension(41, 23));
        projectNewComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                projectNewComboBoxActionPerformed(evt);
            }
        });

        fillerLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        fillerLabel.setMaximumSize(new java.awt.Dimension(100, 23));
        fillerLabel.setMinimumSize(new java.awt.Dimension(100, 23));
        fillerLabel.setPreferredSize(new java.awt.Dimension(100, 23));

        movebuttonGroup.add(moveAllRadioButton);
        org.openide.awt.Mnemonics.setLocalizedText(moveAllRadioButton, org.openide.util.NbBundle.getMessage(ModifyRecurrenceVisualPanelModProject1.class, "all")); // NOI18N
        moveAllRadioButton.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        moveAllRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moveAllRadioButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(moveLabel, org.openide.util.NbBundle.getMessage(ModifyRecurrenceVisualPanelModProject1.class, "modify.project.move")); // NOI18N
        moveLabel.setMaximumSize(new java.awt.Dimension(150, 23));
        moveLabel.setMinimumSize(new java.awt.Dimension(150, 23));
        moveLabel.setPreferredSize(new java.awt.Dimension(150, 23));

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(moveLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(projectCurrentLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 101, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(projectNewLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 101, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(projectNewComboBox, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
                            .add(projectCurrentComboBox, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)))
                    .add(layout.createSequentialGroup()
                        .add(fillerLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 101, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(moveAllRadioButton, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE)
                            .add(moveStartDateRadioButton, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, moveActionDateRadioButton, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE))))
                .addContainerGap())
        );

        layout.linkSize(new java.awt.Component[] {projectCurrentLabel, projectNewLabel}, org.jdesktop.layout.GroupLayout.HORIZONTAL);

        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(projectCurrentLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(projectCurrentComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(projectNewLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(projectNewComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(moveLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(fillerLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(layout.createSequentialGroup()
                        .add(moveAllRadioButton)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(moveStartDateRadioButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(moveActionDateRadioButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(273, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void moveActionDateRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moveActionDateRadioButtonActionPerformed
        moveChanged();
}//GEN-LAST:event_moveActionDateRadioButtonActionPerformed

    private void projectNewComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_projectNewComboBoxActionPerformed
        projectChanged();
}//GEN-LAST:event_projectNewComboBoxActionPerformed

    private void moveStartDateRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moveStartDateRadioButtonActionPerformed
        moveChanged();
}//GEN-LAST:event_moveStartDateRadioButtonActionPerformed

    private void moveAllRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moveAllRadioButtonActionPerformed
        moveChanged();
    }//GEN-LAST:event_moveAllRadioButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel fillerLabel;
    private javax.swing.JRadioButton moveActionDateRadioButton;
    private javax.swing.JRadioButton moveAllRadioButton;
    private javax.swing.JLabel moveLabel;
    private javax.swing.JRadioButton moveStartDateRadioButton;
    private javax.swing.ButtonGroup movebuttonGroup;
    private tr.view.project.combo.ProjectsComboBox projectCurrentComboBox;
    private javax.swing.JLabel projectCurrentLabel;
    private tr.view.project.combo.ProjectsComboBox projectNewComboBox;
    private javax.swing.JLabel projectNewLabel;
    // End of variables declaration//GEN-END:variables
}

