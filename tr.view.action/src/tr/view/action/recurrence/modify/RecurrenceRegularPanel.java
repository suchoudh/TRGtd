/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.view.action.recurrence.modify;

import java.awt.Dialog;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import tr.model.action.Intervals;
import tr.model.action.Period;
import tr.model.action.PeriodMonth;
import tr.model.action.PeriodType;
import tr.model.action.PeriodWeek;
import tr.model.action.PeriodYear;
import tr.model.action.Recurrence;
import tr.view.action.PeriodMonthlyPanel;
import tr.view.action.PeriodWeeklyPanel;
import tr.view.action.PeriodYearlyPanel;

public final class RecurrenceRegularPanel extends JPanel {

    public RecurrenceRegularPanel() {
        initComponents();
    }

    public void setRecurrence(Recurrence recurrence) {
        this.recurrence = recurrence;
        initPanel();
    }

    @Override
    public String getName() {
        return org.openide.util.NbBundle.getMessage(RecurrenceRegularPanel.class, "change.regular.recurrence");
    }

    private Dialog getDialog() {
        return (Dialog) SwingUtilities.getWindowAncestor(this);
    }

    public void initPanel() {
        onLabel = new JLabel(org.openide.util.NbBundle.getMessage(RecurrenceRegularPanel.class, "on"));
        startDateField.setDate(recurrence.getStartDate());
        frequencySpinner.setValue(recurrence.getFrequency());
        periodComboBox.setSelectedItem(recurrence.getPeriod().getType());
        advanceSpinner.setValue(recurrence.getAdvanceNbr());
        endNbrRadioButton.setSelected(recurrence.getEndNbr() != null);
        endNbrSpinner.setValue(recurrence.getEndNbr() == null ? 2 : recurrence.getEndNbr());
        endDateRadioButton.setSelected(recurrence.getEndDate() != null);
        endDateField.setDate(recurrence.getEndDate());
        endNeverRadioButton.setSelected(!endNbrRadioButton.isSelected() && !endDateRadioButton.isSelected());
        initPeriodPanel();

        // show termination date in field
        if (endNbrRadioButton.isSelected()) {
            Date start = recurrence.getStartDate();
            if (start != null) {
                Period per = recurrence.getPeriod();
                int freq = recurrence.getFrequency();
                int endNbr = recurrence.getEndNbr();
                Intervals intervals = new Intervals(per, freq, start);
                Date endDate = Recurrence.getTerminationEndDate(intervals, endNbr);
                endDateField.setDate(endDate);
            }
        }
    }

    private void initPeriodPanel() {
        PeriodType periodType = recurrence.getPeriod().getType();
        Period period = recurrence.getPeriod();

        periodPanel.removeAll();

        switch (periodType) {
            case WEEK: {
                periodPanel.add(onLabel);
                if (periodWeeklyPanel == null) {
                    periodWeeklyPanel = new PeriodWeeklyPanel();
                    periodWeeklyPanel.setPeriodWeek((PeriodWeek) period);
                }
                periodPanel.add(periodWeeklyPanel);
                break;
            }
            case MONTH: {
                if (periodMonthlyPanel == null) {
                    periodMonthlyPanel = new PeriodMonthlyPanel(getDialog(), (PeriodMonth) period);
                }
                periodPanel.add(periodMonthlyPanel);
                break;
            }
            case YEAR: {
                if (periodYearlyPanel == null) {
                    periodYearlyPanel = new PeriodYearlyPanel(getDialog(), (PeriodYear) period);
                }
                periodPanel.add(periodYearlyPanel);
                break;
            }
        }
    }

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        advanceSpinner.setEnabled(enabled);
        endDateRadioButton.setEnabled(enabled);
        endDateField.setEnabled(enabled && endDateRadioButton.isSelected());
        endNbrLabel.setEnabled(enabled);
        endNbrRadioButton.setEnabled(enabled);
        endNbrSpinner.setEnabled(enabled && endNbrRadioButton.isSelected());
        endNeverRadioButton.setEnabled(enabled);
        frequencySpinner.setEnabled(enabled);
        periodComboBox.setEnabled(enabled);
        periodPanel.setEnabled(enabled);
        startDateField.setEnabled(enabled);
        if (periodWeeklyPanel != null) {
            periodWeeklyPanel.setEnabled(enabled);
        }
        if (periodMonthlyPanel != null) {
            periodMonthlyPanel.setEnabled(enabled);
        }
        if (periodYearlyPanel != null) {
            periodYearlyPanel.setEnabled(enabled);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup = new javax.swing.ButtonGroup();
        startLabel = new javax.swing.JLabel();
        startDateField = new tr.swing.date.field.DateField();
        periodLabel = new javax.swing.JLabel();
        frequencySpinner = new javax.swing.JSpinner();
        periodPanel = new javax.swing.JPanel();
        advanceLabel1 = new javax.swing.JLabel();
        advanceSpinner = new javax.swing.JSpinner();
        advanceLabel2 = new javax.swing.JLabel();
        endLabel = new javax.swing.JLabel();
        endNeverRadioButton = new javax.swing.JRadioButton();
        endNbrRadioButton = new javax.swing.JRadioButton();
        endNbrSpinner = new javax.swing.JSpinner();
        endNbrLabel = new javax.swing.JLabel();
        endDateRadioButton = new javax.swing.JRadioButton();
        endDateField = new tr.swing.date.field.DateField();
        periodComboBox = new tr.view.action.recurrence.PeriodTypeComboBox();

        setMaximumSize(new java.awt.Dimension(1024, 184));
        setMinimumSize(new java.awt.Dimension(680, 184));

        startLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        org.openide.awt.Mnemonics.setLocalizedText(startLabel, org.openide.util.NbBundle.getMessage(RecurrenceRegularPanel.class, "start.date")); // NOI18N
        startLabel.setMaximumSize(new java.awt.Dimension(100, 23));
        startLabel.setMinimumSize(new java.awt.Dimension(100, 23));
        startLabel.setPreferredSize(new java.awt.Dimension(100, 23));

        periodLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        org.openide.awt.Mnemonics.setLocalizedText(periodLabel, org.openide.util.NbBundle.getMessage(RecurrenceRegularPanel.class, "periods")); // NOI18N
        periodLabel.setMaximumSize(new java.awt.Dimension(100, 23));
        periodLabel.setMinimumSize(new java.awt.Dimension(100, 23));
        periodLabel.setPreferredSize(new java.awt.Dimension(100, 23));

        frequencySpinner.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
        frequencySpinner.setMaximumSize(new java.awt.Dimension(50, 23));
        frequencySpinner.setMinimumSize(new java.awt.Dimension(50, 23));
        frequencySpinner.setPreferredSize(new java.awt.Dimension(50, 23));

        periodPanel.setMaximumSize(new java.awt.Dimension(530, 26));
        periodPanel.setMinimumSize(new java.awt.Dimension(530, 26));
        periodPanel.setPreferredSize(new java.awt.Dimension(530, 26));
        periodPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        advanceLabel1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        org.openide.awt.Mnemonics.setLocalizedText(advanceLabel1, org.openide.util.NbBundle.getMessage(RecurrenceRegularPanel.class, "generate")); // NOI18N
        advanceLabel1.setMaximumSize(new java.awt.Dimension(100, 23));
        advanceLabel1.setMinimumSize(new java.awt.Dimension(100, 23));
        advanceLabel1.setPreferredSize(new java.awt.Dimension(100, 23));

        advanceSpinner.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
        advanceSpinner.setMaximumSize(new java.awt.Dimension(50, 23));
        advanceSpinner.setMinimumSize(new java.awt.Dimension(50, 23));
        advanceSpinner.setPreferredSize(new java.awt.Dimension(50, 23));

        org.openide.awt.Mnemonics.setLocalizedText(advanceLabel2, org.openide.util.NbBundle.getMessage(RecurrenceRegularPanel.class, "periods.in.advance")); // NOI18N
        advanceLabel2.setMaximumSize(new java.awt.Dimension(67, 23));
        advanceLabel2.setMinimumSize(new java.awt.Dimension(67, 23));
        advanceLabel2.setPreferredSize(new java.awt.Dimension(67, 23));

        endLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        org.openide.awt.Mnemonics.setLocalizedText(endLabel, org.openide.util.NbBundle.getMessage(RecurrenceRegularPanel.class, "terminate")); // NOI18N
        endLabel.setMaximumSize(new java.awt.Dimension(100, 23));
        endLabel.setMinimumSize(new java.awt.Dimension(100, 23));
        endLabel.setPreferredSize(new java.awt.Dimension(100, 23));

        buttonGroup.add(endNeverRadioButton);
        org.openide.awt.Mnemonics.setLocalizedText(endNeverRadioButton, org.openide.util.NbBundle.getMessage(RecurrenceRegularPanel.class, "never")); // NOI18N
        endNeverRadioButton.setMaximumSize(new java.awt.Dimension(90, 23));
        endNeverRadioButton.setMinimumSize(new java.awt.Dimension(90, 23));
        endNeverRadioButton.setPreferredSize(new java.awt.Dimension(90, 23));

        buttonGroup.add(endNbrRadioButton);
        org.openide.awt.Mnemonics.setLocalizedText(endNbrRadioButton, org.openide.util.NbBundle.getMessage(RecurrenceRegularPanel.class, "after")); // NOI18N
        endNbrRadioButton.setMaximumSize(new java.awt.Dimension(90, 23));
        endNbrRadioButton.setMinimumSize(new java.awt.Dimension(90, 23));
        endNbrRadioButton.setPreferredSize(new java.awt.Dimension(90, 23));

        endNbrSpinner.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(2), Integer.valueOf(2), null, Integer.valueOf(1)));
        endNbrSpinner.setMaximumSize(new java.awt.Dimension(50, 23));
        endNbrSpinner.setMinimumSize(new java.awt.Dimension(50, 23));
        endNbrSpinner.setPreferredSize(new java.awt.Dimension(50, 23));

        org.openide.awt.Mnemonics.setLocalizedText(endNbrLabel, org.openide.util.NbBundle.getMessage(RecurrenceRegularPanel.class, "periods")); // NOI18N
        endNbrLabel.setMaximumSize(new java.awt.Dimension(80, 23));
        endNbrLabel.setMinimumSize(new java.awt.Dimension(80, 23));
        endNbrLabel.setPreferredSize(new java.awt.Dimension(80, 23));

        buttonGroup.add(endDateRadioButton);
        org.openide.awt.Mnemonics.setLocalizedText(endDateRadioButton, org.openide.util.NbBundle.getMessage(RecurrenceRegularPanel.class, "after")); // NOI18N
        endDateRadioButton.setMaximumSize(new java.awt.Dimension(90, 23));
        endDateRadioButton.setMinimumSize(new java.awt.Dimension(90, 23));
        endDateRadioButton.setPreferredSize(new java.awt.Dimension(90, 23));

        periodComboBox.setMaximumSize(new java.awt.Dimension(125, 23));
        periodComboBox.setMinimumSize(new java.awt.Dimension(125, 23));
        periodComboBox.setPreferredSize(new java.awt.Dimension(125, 23));

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(startLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(endLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(advanceLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(periodLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(advanceSpinner, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(advanceLabel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE))
                    .add(layout.createSequentialGroup()
                        .add(endNeverRadioButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(endNbrRadioButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(endNbrSpinner, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(endNbrLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(endDateRadioButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(endDateField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(startDateField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(periodPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(layout.createSequentialGroup()
                        .add(frequencySpinner, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(periodComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(startLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(startDateField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, periodComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, frequencySpinner, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, periodLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(periodPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(advanceSpinner, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(advanceLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(advanceLabel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, endLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, endNeverRadioButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, endNbrRadioButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, endNbrSpinner, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, endNbrLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, endDateRadioButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, endDateField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        layout.linkSize(new java.awt.Component[] {frequencySpinner, periodLabel}, org.jdesktop.layout.GroupLayout.VERTICAL);

        layout.linkSize(new java.awt.Component[] {advanceLabel1, advanceLabel2, advanceSpinner}, org.jdesktop.layout.GroupLayout.VERTICAL);

        layout.linkSize(new java.awt.Component[] {endDateField, endDateRadioButton, endLabel, endNbrLabel, endNbrRadioButton, endNbrSpinner, endNeverRadioButton}, org.jdesktop.layout.GroupLayout.VERTICAL);

    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel advanceLabel1;
    private javax.swing.JLabel advanceLabel2;
    private javax.swing.JSpinner advanceSpinner;
    private javax.swing.ButtonGroup buttonGroup;
    private tr.swing.date.field.DateField endDateField;
    private javax.swing.JRadioButton endDateRadioButton;
    private javax.swing.JLabel endLabel;
    private javax.swing.JLabel endNbrLabel;
    private javax.swing.JRadioButton endNbrRadioButton;
    private javax.swing.JSpinner endNbrSpinner;
    private javax.swing.JRadioButton endNeverRadioButton;
    private javax.swing.JSpinner frequencySpinner;
    private tr.view.action.recurrence.PeriodTypeComboBox periodComboBox;
    private javax.swing.JLabel periodLabel;
    private javax.swing.JPanel periodPanel;
    private tr.swing.date.field.DateField startDateField;
    private javax.swing.JLabel startLabel;
    // End of variables declaration//GEN-END:variables
    private Recurrence recurrence;
    private PeriodWeeklyPanel periodWeeklyPanel;
    private PeriodMonthlyPanel periodMonthlyPanel;
    private PeriodYearlyPanel periodYearlyPanel;
    private JLabel onLabel;
}
