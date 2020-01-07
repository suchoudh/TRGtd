/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.view.action.recurrence.modify;

import javax.swing.JPanel;
import tr.model.Data;
import tr.model.DataLookup;
import tr.model.action.Recurrence;
import tr.model.project.Project;

public final class RecurrenceProjectPanel extends JPanel {

    public RecurrenceProjectPanel() {
        this.data = (Data) DataLookup.instance().lookup(Data.class);
        initComponents();
    }

    public void setRecurrence(Recurrence recurrence) {
        this.recurrence = recurrence;
        initPanel();
    }

    @Override
    public String getName() {
        return org.openide.util.NbBundle.getMessage(RecurrenceProjectPanel.class, "choose.project");
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        projectLabel = new javax.swing.JLabel();
        projectCombo = new tr.view.project.combo.ProjectsComboBox();

        setMinimumSize(new java.awt.Dimension(250, 23));
        setPreferredSize(new java.awt.Dimension(250, 23));

        projectLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        org.openide.awt.Mnemonics.setLocalizedText(projectLabel, org.openide.util.NbBundle.getMessage(RecurrenceProjectPanel.class, "project")); // NOI18N
        projectLabel.setMaximumSize(new java.awt.Dimension(100, 23));
        projectLabel.setMinimumSize(new java.awt.Dimension(100, 23));
        projectLabel.setPreferredSize(new java.awt.Dimension(100, 23));

        projectCombo.setMaximumSize(new java.awt.Dimension(32767, 23));
        projectCombo.setMinimumSize(new java.awt.Dimension(120, 23));
        projectCombo.setPreferredSize(new java.awt.Dimension(120, 23));
        projectCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                projectComboActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(projectLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(projectCombo, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                .add(projectCombo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(projectLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    public void initPanel() {
        projectCombo.setSelectedItem(recurrence.getProject());
    }

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
//      projectLabel.setEnabled(enabled);
        projectCombo.setEnabled(enabled);
    }

    private void projectComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_projectComboActionPerformed
        if (projectCombo.isEnabled()) {
            recurrence.setProject((Project) projectCombo.getSelectedItem());
        }
    }//GEN-LAST:event_projectComboActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private tr.view.project.combo.ProjectsComboBox projectCombo;
    private javax.swing.JLabel projectLabel;
    // End of variables declaration//GEN-END:variables
    private final Data data;
    private Recurrence recurrence;
}

