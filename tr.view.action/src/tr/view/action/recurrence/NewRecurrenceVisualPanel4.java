/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.view.action.recurrence;

import au.com.trgtd.tr.appl.Constants;
import java.awt.Dialog;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import tr.model.action.Intervals;
import tr.model.action.Period;
import tr.model.action.PeriodDay;
import tr.model.action.PeriodMonth;
import tr.model.action.PeriodType;
import tr.model.action.PeriodWeek;
import tr.model.action.PeriodWeekday;
import tr.model.action.PeriodYear;
import tr.model.action.Recurrence;
import tr.util.DateUtils;
import tr.view.action.PeriodMonthlyPanel;
import tr.view.action.PeriodWeeklyPanel;
import tr.view.action.PeriodYearlyPanel;

public final class NewRecurrenceVisualPanel4 extends JPanel {

    private static int counter;
    private final Recurrence recurrence;
    private final Date actionScheduledDate;
    private Map<PeriodType, Period> mapPeriods;
    private Map<PeriodType, Integer> mapAdvanceNbrs;
    private PeriodWeeklyPanel periodWeeklyPanel;
    private PeriodMonthlyPanel periodMonthlyPanel;
    private PeriodYearlyPanel periodYearlyPanel;

    public NewRecurrenceVisualPanel4(Recurrence recurrence, Date actionScheduledDate) {
        this.recurrence = recurrence;
        this.actionScheduledDate = actionScheduledDate;
        initComponents();
        initPeriods();
        initPanel();
    }

    private void initPeriods() {
        setPeriod(new PeriodWeekday());
        setPeriod(new PeriodDay());
        setPeriod(new PeriodWeek());
        setPeriod(new PeriodMonth());
        setPeriod(new PeriodYear());
        setPeriod(recurrence.getPeriod());
        setAdvanceNbr(recurrence.getPeriod().getType(), recurrence.getAdvanceNbr());
    }

    private Period getPeriod(PeriodType type) {
        if (mapPeriods == null) {
            mapPeriods = new HashMap<PeriodType, Period>();
        }
        return mapPeriods.get(type);
    }

    private void setPeriod(Period period) {
        if (mapPeriods == null) {
            mapPeriods = new HashMap<PeriodType, Period>();
        }
        mapPeriods.put(period.getType(), period);
    }

    private Integer getAdvanceNbr(PeriodType type) {
        if (mapAdvanceNbrs == null) {
            mapAdvanceNbrs = new HashMap<PeriodType, Integer>();
        }
        Integer n = mapAdvanceNbrs.get(type);
        if (n == null || n < 1) {
            n = getPeriod(type).getDefaultAdvanceNbr();
        }
        return n;
    }

    private void setAdvanceNbr(PeriodType type, Integer advanceNbr) {
        if (mapAdvanceNbrs == null) {
            mapAdvanceNbrs = new HashMap<PeriodType, Integer>();
        }
        mapAdvanceNbrs.put(type, advanceNbr);
    }

    @Override
    public String getName() {
        return org.openide.util.NbBundle.getMessage(NewRecurrenceVisualPanel4.class, "define.regular.recurrence");
    }

    public void stateChange() {
        putClientProperty("state.change", Long.valueOf(++counter));
    }

    public void initPanel() {
        startDateField.setDate(recurrence.getStartDate());
        frequencySpinner.setValue(recurrence.getFrequency());
        periodComboBox.setSelectedItem(recurrence.getPeriod().getType());
        advanceSpinner.setValue(recurrence.getAdvanceNbr());
        endNbrRadioButton.setSelected(recurrence.getEndNbr() != null);
        endNbrSpinner.setValue(recurrence.getEndNbr() == null ? 2 : recurrence.getEndNbr());
        endDateRadioButton.setSelected(recurrence.getEndDate() != null);
        endDateField.setDate(recurrence.getEndDate());
        endNeverRadioButton.setSelected(!endNbrRadioButton.isSelected() && !endDateRadioButton.isSelected());
        enableDisableComponents();
    }

    private void enableDisableComponents() {
        endDateField.setEnabled(endDateRadioButton.isSelected());
        endNbrSpinner.setEnabled(endNbrRadioButton.isSelected());
    }

    private void setEndValues() {
        if (endNbrRadioButton.isSelected()) {
            recurrence.setEndNbr((Integer) endNbrSpinner.getValue());
            recurrence.setEndDate(null);

            // show termination date in field
            Date start = recurrence.getStartDate();
            if (start != null) {
                Period per = recurrence.getPeriod();
                int freq = recurrence.getFrequency();
                int endNbr = recurrence.getEndNbr();
                Intervals intervals = new Intervals(per, freq, start);
                Date endDate = Recurrence.getTerminationEndDate(intervals, endNbr);
                endDateField.setDate(endDate);
            }

            return;
        }
        if (endDateRadioButton.isSelected()) {
            recurrence.setEndNbr(null);
            recurrence.setEndDate(this.endDateField.getDate());
            return;
        }
    }

    public boolean isValidForm() {
        if (startDateField.getDate() == null) {
            errorLabel1.setText(org.openide.util.NbBundle.getMessage(NewRecurrenceVisualPanel4.class, "start.date.must.be.entered"));
            return false;
        }
        if (actionScheduledDate != null) {
            if (startDateField.getDate().before(DateUtils.clearTime(actionScheduledDate))) {
                String d = Constants.DATE_FORMAT_FIXED.format(actionScheduledDate);
                errorLabel1.setText(org.openide.util.NbBundle.getMessage(NewRecurrenceVisualPanel4.class, "start.date.not.before.action.date", d));
                errorLabel2.setText(org.openide.util.NbBundle.getMessage(NewRecurrenceVisualPanel4.class, "start.date.not.before.action.date.hint"));
                return false;
            }
        }
        if (endDateRadioButton.isSelected() && endDateField.getDate() == null) {
            errorLabel1.setText(org.openide.util.NbBundle.getMessage(NewRecurrenceVisualPanel4.class, "termination.date.must.be.entered"));
            return false;
        }
        errorLabel1.setText("");
        errorLabel2.setText("");
        return true;
    }

    private Dialog getDialog() {
        return (Dialog) SwingUtilities.getWindowAncestor(this);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup = new javax.swing.ButtonGroup();
        startLabel = new javax.swing.JLabel();
        startDateField = new tr.swing.date.field.DateField();
        periodLabel = new javax.swing.JLabel();
        frequencySpinner = new javax.swing.JSpinner();
        periodComboBox = new tr.view.action.recurrence.PeriodTypeComboBox();
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
        errorLabel1 = new javax.swing.JLabel();
        errorLabel2 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(1024, 768));
        setMinimumSize(new java.awt.Dimension(480, 360));

        startLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        org.openide.awt.Mnemonics.setLocalizedText(startLabel, org.openide.util.NbBundle.getMessage(NewRecurrenceVisualPanel4.class, "start.date")); // NOI18N
        startLabel.setMaximumSize(new java.awt.Dimension(100, 23));
        startLabel.setMinimumSize(new java.awt.Dimension(100, 23));
        startLabel.setPreferredSize(new java.awt.Dimension(100, 23));

        startDateField.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                startDateFieldPropertyChange(evt);
            }
        });

        periodLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        org.openide.awt.Mnemonics.setLocalizedText(periodLabel, org.openide.util.NbBundle.getMessage(NewRecurrenceVisualPanel4.class, "period")); // NOI18N
        periodLabel.setMaximumSize(new java.awt.Dimension(100, 23));
        periodLabel.setMinimumSize(new java.awt.Dimension(100, 23));
        periodLabel.setPreferredSize(new java.awt.Dimension(100, 23));

        frequencySpinner.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
        frequencySpinner.setMaximumSize(new java.awt.Dimension(50, 23));
        frequencySpinner.setMinimumSize(new java.awt.Dimension(50, 23));
        frequencySpinner.setPreferredSize(new java.awt.Dimension(50, 23));
        frequencySpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                frequencySpinnerStateChanged(evt);
            }
        });

        periodComboBox.setMaximumSize(new java.awt.Dimension(125, 23));
        periodComboBox.setMinimumSize(new java.awt.Dimension(125, 23));
        periodComboBox.setPreferredSize(new java.awt.Dimension(125, 23));
        periodComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                periodActionPerformed(evt);
            }
        });

        periodPanel.setMaximumSize(new java.awt.Dimension(530, 26));
        periodPanel.setMinimumSize(new java.awt.Dimension(530, 26));
        periodPanel.setPreferredSize(new java.awt.Dimension(530, 26));
        periodPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        advanceLabel1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        org.openide.awt.Mnemonics.setLocalizedText(advanceLabel1, org.openide.util.NbBundle.getMessage(NewRecurrenceVisualPanel4.class, "generate")); // NOI18N
        advanceLabel1.setMaximumSize(new java.awt.Dimension(100, 23));
        advanceLabel1.setMinimumSize(new java.awt.Dimension(100, 23));
        advanceLabel1.setPreferredSize(new java.awt.Dimension(100, 23));

        advanceSpinner.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
        advanceSpinner.setMaximumSize(new java.awt.Dimension(50, 23));
        advanceSpinner.setMinimumSize(new java.awt.Dimension(50, 23));
        advanceSpinner.setPreferredSize(new java.awt.Dimension(50, 23));
        advanceSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                advanceSpinnerStateChanged(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(advanceLabel2, org.openide.util.NbBundle.getMessage(NewRecurrenceVisualPanel4.class, "periods.in.advance")); // NOI18N
        advanceLabel2.setMaximumSize(new java.awt.Dimension(67, 23));
        advanceLabel2.setMinimumSize(new java.awt.Dimension(67, 23));
        advanceLabel2.setPreferredSize(new java.awt.Dimension(67, 23));

        endLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        org.openide.awt.Mnemonics.setLocalizedText(endLabel, org.openide.util.NbBundle.getMessage(NewRecurrenceVisualPanel4.class, "terminate")); // NOI18N
        endLabel.setMaximumSize(new java.awt.Dimension(100, 23));
        endLabel.setMinimumSize(new java.awt.Dimension(100, 23));
        endLabel.setPreferredSize(new java.awt.Dimension(100, 23));

        buttonGroup.add(endNeverRadioButton);
        org.openide.awt.Mnemonics.setLocalizedText(endNeverRadioButton, org.openide.util.NbBundle.getMessage(NewRecurrenceVisualPanel4.class, "never")); // NOI18N
        endNeverRadioButton.setMaximumSize(new java.awt.Dimension(90, 23));
        endNeverRadioButton.setMinimumSize(new java.awt.Dimension(90, 23));
        endNeverRadioButton.setPreferredSize(new java.awt.Dimension(90, 23));
        endNeverRadioButton.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        endNeverRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endNeverRadioButtonActionPerformed(evt);
            }
        });

        buttonGroup.add(endNbrRadioButton);
        org.openide.awt.Mnemonics.setLocalizedText(endNbrRadioButton, org.openide.util.NbBundle.getMessage(NewRecurrenceVisualPanel4.class, "after")); // NOI18N
        endNbrRadioButton.setMaximumSize(new java.awt.Dimension(62, 23));
        endNbrRadioButton.setMinimumSize(new java.awt.Dimension(62, 23));
        endNbrRadioButton.setPreferredSize(new java.awt.Dimension(90, 23));
        endNbrRadioButton.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        endNbrRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endNbrRadioButtonActionPerformed(evt);
            }
        });

        endNbrSpinner.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(2), Integer.valueOf(2), null, Integer.valueOf(1)));
        endNbrSpinner.setMaximumSize(new java.awt.Dimension(50, 23));
        endNbrSpinner.setMinimumSize(new java.awt.Dimension(50, 23));
        endNbrSpinner.setPreferredSize(new java.awt.Dimension(50, 23));
        endNbrSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                endNbrSpinnerStateChanged(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(endNbrLabel, org.openide.util.NbBundle.getMessage(NewRecurrenceVisualPanel4.class, "periods")); // NOI18N
        endNbrLabel.setMaximumSize(new java.awt.Dimension(90, 23));
        endNbrLabel.setMinimumSize(new java.awt.Dimension(90, 23));
        endNbrLabel.setPreferredSize(new java.awt.Dimension(90, 23));

        buttonGroup.add(endDateRadioButton);
        org.openide.awt.Mnemonics.setLocalizedText(endDateRadioButton, org.openide.util.NbBundle.getMessage(NewRecurrenceVisualPanel4.class, "after")); // NOI18N
        endDateRadioButton.setMaximumSize(new java.awt.Dimension(90, 23));
        endDateRadioButton.setMinimumSize(new java.awt.Dimension(90, 23));
        endDateRadioButton.setPreferredSize(new java.awt.Dimension(90, 23));
        endDateRadioButton.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        endDateRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endDateRadioButtonActionPerformed(evt);
            }
        });

        endDateField.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                endDateFieldPropertyChange(evt);
            }
        });

        errorLabel1.setForeground(java.awt.Color.red);
        errorLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        errorLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        errorLabel1.setMaximumSize(new java.awt.Dimension(1024, 23));
        errorLabel1.setMinimumSize(new java.awt.Dimension(16, 23));
        errorLabel1.setOpaque(true);
        errorLabel1.setPreferredSize(new java.awt.Dimension(16, 23));

        errorLabel2.setForeground(java.awt.Color.red);
        errorLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        errorLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        errorLabel2.setMaximumSize(new java.awt.Dimension(1024, 23));
        errorLabel2.setMinimumSize(new java.awt.Dimension(16, 23));
        errorLabel2.setOpaque(true);
        errorLabel2.setPreferredSize(new java.awt.Dimension(16, 23));

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                                    .add(org.jdesktop.layout.GroupLayout.LEADING, startLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .add(periodLabel, 0, 0, Short.MAX_VALUE)
                                    .add(org.jdesktop.layout.GroupLayout.LEADING, endLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .add(org.jdesktop.layout.GroupLayout.LEADING, advanceLabel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(startDateField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(layout.createSequentialGroup()
                                        .add(frequencySpinner, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                        .add(periodComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                    .add(layout.createSequentialGroup()
                                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                                            .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                                                .add(advanceSpinner, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                                .add(advanceLabel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                                                .add(endNeverRadioButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                                .add(endNbrRadioButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                                .add(endNbrSpinner, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                                .add(endNbrLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                        .add(endDateRadioButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                        .add(endDateField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                                .add(org.jdesktop.layout.GroupLayout.LEADING, errorLabel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .add(org.jdesktop.layout.GroupLayout.LEADING, errorLabel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 658, Short.MAX_VALUE))))
                    .add(layout.createSequentialGroup()
                        .add(138, 138, 138)
                        .add(periodPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 543, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(30, 30, 30)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.CENTER)
                    .add(startLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(startDateField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, periodLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, frequencySpinner, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, periodComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(2, 2, 2)
                .add(periodPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(advanceLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(advanceSpinner, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(advanceLabel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(endLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(endNeverRadioButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                .add(org.jdesktop.layout.GroupLayout.TRAILING, endNbrLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(org.jdesktop.layout.GroupLayout.TRAILING, endNbrRadioButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(org.jdesktop.layout.GroupLayout.TRAILING, endNbrSpinner, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(endDateRadioButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(endDateField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .add(18, 18, 18)
                .add(errorLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(errorLabel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(101, Short.MAX_VALUE))
        );

        layout.linkSize(new java.awt.Component[] {frequencySpinner, periodComboBox, periodLabel}, org.jdesktop.layout.GroupLayout.VERTICAL);

        layout.linkSize(new java.awt.Component[] {advanceLabel1, advanceLabel2, advanceSpinner}, org.jdesktop.layout.GroupLayout.VERTICAL);

    }// </editor-fold>//GEN-END:initComponents

    private void endNbrRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endNbrRadioButtonActionPerformed
        stateChange();
        setEndValues();
        enableDisableComponents();
    }//GEN-LAST:event_endNbrRadioButtonActionPerformed

    private void periodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_periodActionPerformed

        PeriodType periodType = (PeriodType) periodComboBox.getSelectedItem();

        Period period = getPeriod(periodType);
        Integer advanceNbr = getAdvanceNbr(periodType);

        recurrence.setPeriod(period);
        recurrence.setAdvanceNbr(advanceNbr);

        periodPanel.removeAll();

        switch (periodType) {
            case WEEK: {
                periodPanel.add(new JLabel(org.openide.util.NbBundle.getMessage(NewRecurrenceVisualPanel4.class, "on")));
                if (periodWeeklyPanel == null) {
                    periodWeeklyPanel = new PeriodWeeklyPanel();
                    periodWeeklyPanel.setPeriodWeek((PeriodWeek) period);
                }
                periodWeeklyPanel.notifyStartDate(startDateField.getDate());
                periodPanel.add(periodWeeklyPanel);
                break;
            }
            case MONTH: {
                if (periodMonthlyPanel == null) {
                    periodMonthlyPanel = new PeriodMonthlyPanel(getDialog(), (PeriodMonth) period);
                }
                periodMonthlyPanel.notifyStartDate(startDateField.getDate());
                periodPanel.add(periodMonthlyPanel);
                break;
            }
            case YEAR: {
                if (periodYearlyPanel == null) {
                    periodYearlyPanel = new PeriodYearlyPanel(getDialog(), (PeriodYear) period);
                }
                periodYearlyPanel.notifyStartDate(startDateField.getDate());
                periodPanel.add(periodYearlyPanel);
                break;
            }
        }

        advanceSpinner.setValue(advanceNbr);

        stateChange();
        setEndValues();

        periodPanel.validate();
        periodPanel.repaint();
    }//GEN-LAST:event_periodActionPerformed

    private void advanceSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_advanceSpinnerStateChanged
        Integer oldValue = getAdvanceNbr(recurrence.getPeriod().getType());
        Integer newValue = (Integer) advanceSpinner.getValue();
        if (oldValue != newValue) {
            recurrence.setAdvanceNbr(newValue);
            setAdvanceNbr(recurrence.getPeriod().getType(), recurrence.getAdvanceNbr());
            stateChange();
        }
    }//GEN-LAST:event_advanceSpinnerStateChanged

    private void startDateFieldPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_startDateFieldPropertyChange
        if (evt.getPropertyName().equals("value")) {
            recurrence.setStartDate(startDateField.getDate());
            putClientProperty("start", startDateField.getDate());
            stateChange();
            setEndValues();
        }
    }//GEN-LAST:event_startDateFieldPropertyChange

    private void endNeverRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endNeverRadioButtonActionPerformed
        stateChange();
        setEndValues();
        enableDisableComponents();
    }//GEN-LAST:event_endNeverRadioButtonActionPerformed

    private void endDateRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endDateRadioButtonActionPerformed
        stateChange();
        setEndValues();
        enableDisableComponents();
    }//GEN-LAST:event_endDateRadioButtonActionPerformed

    private void endNbrSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_endNbrSpinnerStateChanged
        stateChange();
        setEndValues();
    }//GEN-LAST:event_endNbrSpinnerStateChanged

    private void endDateFieldPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_endDateFieldPropertyChange
        stateChange();
        setEndValues();
    }//GEN-LAST:event_endDateFieldPropertyChange

private void frequencySpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_frequencySpinnerStateChanged
    recurrence.setFrequency((Integer) frequencySpinner.getValue());
    stateChange();
    setEndValues();
}//GEN-LAST:event_frequencySpinnerStateChanged

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
    private javax.swing.JLabel errorLabel1;
    private javax.swing.JLabel errorLabel2;
    private javax.swing.JSpinner frequencySpinner;
    private tr.view.action.recurrence.PeriodTypeComboBox periodComboBox;
    private javax.swing.JLabel periodLabel;
    private javax.swing.JPanel periodPanel;
    private tr.swing.date.field.DateField startDateField;
    private javax.swing.JLabel startLabel;
    // End of variables declaration//GEN-END:variables
}

