/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.view.action.recurrence.modify;

import javax.swing.JPanel;
import tr.model.action.Recurrence;

public final class ModifyRecurrenceVisualPanelModAction1 extends JPanel {

    /** Creates new form NewRecurrenceVisualPanel1 */
    public ModifyRecurrenceVisualPanelModAction1(Recurrence recurrence) {
        this.recurrence = recurrence;
        initComponents();
        initPanel();        
    }

    @Override
    public String getName() {
        return org.openide.util.NbBundle.getMessage(ModifyRecurrenceVisualPanelModAction1.class, "change.action.values");
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        actionPanel = new tr.view.action.recurrence.modify.RecurrenceActionPanel();

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, actionPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(actionPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    public void initPanel() {
        actionPanel.setRecurrence(recurrence);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private tr.view.action.recurrence.modify.RecurrenceActionPanel actionPanel;
    // End of variables declaration//GEN-END:variables
    private final Recurrence recurrence;
}

