package tr.view.action.recurrence.modify;

import javax.swing.JPanel;
import org.openide.util.NbBundle;

public final class ModifyRecurrenceVisualPanelRemRecur1 extends JPanel {

    /** Creates new form NewRecurrenceVisualPanel1 */
    public ModifyRecurrenceVisualPanelRemRecur1() {
        initComponents();
    }

    @Override
    public String getName() {
        return NbBundle.getMessage(ModifyRecurrenceVisualPanelRemRecur1.class, "confirm.recurrence.removal");
    }

    public void initPanel() {
        String m = NbBundle.getMessage(ModifyRecurrenceVisualPanelRemRecur1.class, "recurrence.removal.explain");
        messageTextArea.setText(m.toString());        
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        messageTextArea = new javax.swing.JTextArea();

        messageTextArea.setColumns(20);
        messageTextArea.setEditable(false);
        messageTextArea.setLineWrap(true);
        messageTextArea.setRows(5);
        messageTextArea.setWrapStyleWord(true);
        messageTextArea.setBorder(null);
        messageTextArea.setFocusable(false);
        messageTextArea.setOpaque(false);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 558, Short.MAX_VALUE)
            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(layout.createSequentialGroup()
                    .add(0, 0, Short.MAX_VALUE)
                    .add(messageTextArea, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 514, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 352, Short.MAX_VALUE)
            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(layout.createSequentialGroup()
                    .add(0, 0, Short.MAX_VALUE)
                    .add(messageTextArea, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 308, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea messageTextArea;
    // End of variables declaration//GEN-END:variables
}

