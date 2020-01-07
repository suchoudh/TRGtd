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
package tr.swing.date.chooser;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import org.openide.util.NbBundle;
import tr.prefs.dates.DatesPrefs;

/**
 * Custom dialog box to enter dates. The <code>DateChooser</code> class
 * presents a calendar and allows the user to visually select a day, month and
 * year so that it is impossible to enter an invalid date.
 */
public class DateChooserDialog extends JDialog implements ItemListener,
        MouseListener, FocusListener, KeyListener, ActionListener {

    private static final Class clazz = DateChooserDialog.class;
    
    private static final String JANUARY = NbBundle.getMessage(clazz, "january"); // No I18N

    private static final String FEBRUARY = NbBundle.getMessage(clazz, "february"); // No I18N
    private static final String MARCH = NbBundle.getMessage(clazz, "march"); // No I18N
    private static final String APRIL = NbBundle.getMessage(clazz, "april"); // No I18N
    private static final String MAY = NbBundle.getMessage(clazz, "may"); // No I18N
    private static final String JUNE = NbBundle.getMessage(clazz, "june"); // No I18N
    private static final String JULY = NbBundle.getMessage(clazz, "july"); // No I18N
    private static final String AUGUST = NbBundle.getMessage(clazz, "august"); // No I18N
    private static final String SEPTEMBER = NbBundle.getMessage(clazz, "september"); // No I18N
    private static final String OCTOBER = NbBundle.getMessage(clazz, "october"); // No I18N
    private static final String NOVEMBER = NbBundle.getMessage(clazz, "november"); // No I18N
    private static final String DECEMBER = NbBundle.getMessage(clazz, "december"); // No I18N
    private static final String MON = NbBundle.getMessage(clazz, "mon"); // No I18N
    private static final String TUE = NbBundle.getMessage(clazz, "tue"); // No I18N
    private static final String WED = NbBundle.getMessage(clazz, "wed"); // No I18N
    private static final String THU = NbBundle.getMessage(clazz, "thu"); // No I18N
    private static final String FRI = NbBundle.getMessage(clazz, "fri"); // No I18N
    private static final String SAT = NbBundle.getMessage(clazz, "sat"); // No I18N
    private static final String SUN = NbBundle.getMessage(clazz, "sun"); // No I18N
    
    private static final Color SELECTED_FG_COLOR = UIManager.getDefaults().getColor("List.selectionForeground");
    private static final Color SELECTED_BG_COLOR = UIManager.getDefaults().getColor("List.selectionBackground");
    private static final Color DESELECTED_FG_COLOR = UIManager.getDefaults().getColor("List.foreground");
    private static final Color DESELECTED_BG_COLOR = UIManager.getDefaults().getColor("List.background");
    public static final String DEFAULT_TITLE = org.openide.util.NbBundle.getMessage(DateChooserDialog.class, "date.chooser");
    private static final DateFormat DF = new SimpleDateFormat("EEE, d MMM yyyy");
    /** Names of the months. */
    private static final String[] MONTHS = new String[] {
        JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER 
    };
    /* Month index for January. */
    private static final int MONTH_INDEX_JANUARY = 0;
    /* Month index for December. */
    private static final int MONTH_INDEX_DECEMBER = 11;
    private static final ImageIcon ICON_BACK = new ImageIcon(DateChooserDialog.class.getResource("/tr/swing/date/chooser/Back16.gif"));
    private static final ImageIcon ICON_NEXT = new ImageIcon(DateChooserDialog.class.getResource("/tr/swing/date/chooser/Next16.gif"));
    /** First day of the week. */
    private int FIRST_DAY;
    /** Names of the days of the week. */
    private String[] DAYS;
    /** Names of the days of the week when first day is Sunday. */
    private static final String[] DAYS_SUN_FIRST = new String[]{SUN, MON, TUE, WED, THU, FRI, SAT, SUN};
    /** Names of the days of the week when first day is Monday. */
    private static final String[] DAYS_MON_FIRST = new String[]{MON, TUE, WED, THU, FRI, SAT, SUN, MON};
    //    private static final Dimension DAY_BOX_SIZE = new Dimension(32, 32);
    private static final Dimension DAY_BOX_SIZE = new Dimension(36, 36);
    /* Text color of the days of the weeks, used as column headers in the calendar. */
    private static final Color HEADINGS_FOREGROUND = Color.black;//    /* Text color of the days' numbers in the calendar. */
//    private static final Color DAYS_FOREGROUND = Color.blue;    
//    /* Background color of the days in the calendar. */
//    private static final Color DAYS_BACKGROUND = Color.white;    
//    /* Background color of the selected day in the calendar. */
//    private static final Color SELECTED_DAY_FOREGROUND = Color.white;    
//    /* Text color of the selected day in the calendar. */
//    private static final Color SELECTED_DAY_BACKGROUND = Color.blue;

    /* Text color of the days' numbers in the calendar. */
    private static final Color DAYS_FOREGROUND = DESELECTED_FG_COLOR;
    /* Background color of the days in the calendar. */
    private static final Color DAYS_BACKGROUND = DESELECTED_BG_COLOR;
    /* Background color of the selected day in the calendar. */
    private static final Color SELECTED_DAY_FOREGROUND = SELECTED_FG_COLOR;
    /* Text color of the selected day in the calendar. */
    private static final Color SELECTED_DAY_BACKGROUND = SELECTED_BG_COLOR;
    /* Text color of the selected day in the calendar. */
    private static final Color GRID_BACKGROUND = Color.lightGray;
    /* Empty border, used when the calendar does not have the focus. */
////    private static final Border EMPTY_BORDER = BorderFactory.createEmptyBorder(1, 1, 1, 1);
    private static final Border EMPTY_BORDER = BorderFactory.createEmptyBorder(0, 0, 0, 0);//    private static final Border GRID_BORDER
//            = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED, Color.darkGray, Color.lightGray);
//    private static final Border GRID_BORDER = BorderFactory.createLineBorder(Color.lightGray);
//////    /* Border used to highlight the selected day when the calendar has the focus. */
////////    private static final Border FOCUSED_BORDER = BorderFactory.createLineBorder(Color.yellow, 1);
//////    private static final Border FOCUSED_BORDER = GRID_BORDER;
    /* First year that can be selected. */
    private static final int FIRST_YEAR = 1900;
    /* Last year that can be selected. */
    private static final int LAST_YEAR = 2100;
    /* Auxiliary variable to compute dates. */
    private GregorianCalendar calendar;
    private JEditorPane todayPane;
    /*
     * Calendar, as a matrix of labels. The first row represents the first week
     * of the month, the second row, the second week, and so on. Each column
     * represents a day of the week, the first is Sunday, and the last is
     * Saturday. The label's text is the number of the corresponding day.
     */
    private JLabel[][] days;
    /*
     * Day selection control. It is just a panel that can receive the focus. The
     * actual user interaction is driven by the <code>DateChooser</code>
     * class.
     */
    private FocusablePanel daysGrid;
    
    private JPanel headGrid;
    /* Month selection control. */
    private JComboBox month;
    /* Last month button. */
    private JButton monthLast;
    /* Next month button. */
    private JButton monthNext;
    /* Last year button. */
    private JButton yearLast;
    /* Next year button. */
    private JButton yearNext;
    /* Year selection control. */
    private JComboBox year;
    /* "Clear" button. */
    private JButton clear;
    /* "Ok" button. */
    private JButton okButton;
    /* "Cancel" button. */
    private JButton cancelButton;
    /*
     * Day of the week (0=Sunday) corresponding to the first day of the selected
     * month. Used to calculate the position, in the calendar ({@link #days}),
     * corresponding to a given day.
     */
    private int offset;
    /* Last day of the selected month. */
    private int lastDay;
    /* Selected day. */
    private JLabel day;
    /*
     * <code>true</code> if the "Ok" button was clicked to close the dialog
     * box, <code>false</code> otherwise.
     */
    private boolean okay;
    /*
     * <code>true</code> if the "Cancel" button was clicked to close the dialog
     * box, <code>false</code> otherwise.
     */
    private boolean cancel;

    /*
     * Custom panel that can receive the focus. Used to implement the calendar
     * control.
     */
    private static class FocusablePanel extends JPanel {

        /**
         * Constructs a new <code>FocusablePanel</code> with the given layout
         * manager.
         * @param layout The layout manager
         */
        public FocusablePanel(LayoutManager layout) {
            super(layout);
        }

        /**
         * Always returns <code>true</code>, since
         * <code>FocusablePanel</code> can receive the focus.
         * @return <code>true</code>
         */
        @Override
        public boolean isFocusable() {
            return true;
        }
    }

    /* Initialises this <code>DateChooser</code> object. Creates the controls,
     * registers listeners and initialises the dialog box. */
    private void construct() {
        // Escape key to cancel
        ActionListener cancelListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cancel = true;
                setVisible(false);
//              dispose();
            }
        };
        KeyStroke stroke = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0);
        getRootPane().registerKeyboardAction(cancelListener, stroke, JComponent.WHEN_IN_FOCUSED_WINDOW);

        calendar = new GregorianCalendar();

        month = new JComboBox(MONTHS);
        month.setPreferredSize(new Dimension(110, 23));
        month.addItemListener(this);
        month.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    goLastMonth();
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    goNextMonth();
                }
            }
        });

        monthLast = new JButton();
        monthLast.setFocusable(false);
        monthLast.setIcon(ICON_BACK);
        monthLast.setMargin(new Insets(0, 0, 0, 0));
        monthLast.setMaximumSize(new Dimension(18, 23));
        monthLast.setMinimumSize(new Dimension(18, 23));
        monthLast.setPreferredSize(new Dimension(18, 23));
        monthLast.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                goLastMonth();
            }
        });
        monthNext = new JButton();
        monthNext.setFocusable(false);
        monthNext.setIcon(ICON_NEXT);
        monthNext.setMargin(new Insets(0, 0, 0, 0));
        monthNext.setMaximumSize(new Dimension(18, 23));
        monthNext.setMinimumSize(new Dimension(18, 23));
        monthNext.setPreferredSize(new Dimension(18, 23));
        monthNext.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                goNextMonth();
            }
        });

        year = new JComboBox();
        year.setPreferredSize(new Dimension(110, 23));
        for (int i = FIRST_YEAR; i <= LAST_YEAR; i++) {
            year.addItem(Integer.toString(i));

        }
        year.addItemListener(this);
        year.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    goLastYear();
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    goNextYear();
                }
            }
        });

        yearLast = new JButton();
        yearLast.setFocusable(false);
        yearLast.setIcon(ICON_BACK);
        yearLast.setMargin(new Insets(0, 0, 0, 0));
        yearLast.setMaximumSize(new Dimension(18, 23));
        yearLast.setMinimumSize(new Dimension(18, 23));
        yearLast.setPreferredSize(new Dimension(18, 23));
        yearLast.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                goLastYear();
            }
        });
        yearNext = new JButton();
        yearNext.setFocusable(false);
        yearNext.setIcon(ICON_NEXT);
        yearNext.setMargin(new Insets(0, 0, 0, 0));
        yearNext.setMaximumSize(new Dimension(18, 23));
        yearNext.setMinimumSize(new Dimension(18, 23));
        yearNext.setPreferredSize(new Dimension(18, 23));
        yearNext.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                goNextYear();
            }
        });

        days = new JLabel[7][7];
        for (int i = 0; i < 7; i++) {
            days[0][i] = new JLabel(DAYS[i], JLabel.CENTER);
            days[0][i].setOpaque(true);
            days[0][i].setForeground(HEADINGS_FOREGROUND);
            days[0][i].setPreferredSize(DAY_BOX_SIZE);
            days[0][i].setMaximumSize(DAY_BOX_SIZE);
            days[0][i].setMinimumSize(DAY_BOX_SIZE);
            days[0][i].setFont(days[0][i].getFont().deriveFont(Font.BOLD));
        }
        for (int i = 1; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                days[i][j] = new JLabel(" ", JLabel.CENTER);
                days[i][j].setOpaque(true);
                days[i][j].setForeground(DAYS_FOREGROUND);
                days[i][j].setBackground(DAYS_BACKGROUND);
                days[i][j].addMouseListener(this);
                days[i][j].setPreferredSize(DAY_BOX_SIZE);
                days[i][j].setMaximumSize(DAY_BOX_SIZE);
                days[i][j].setMinimumSize(DAY_BOX_SIZE);
                days[i][j].setFont(days[i][j].getFont().deriveFont(Font.BOLD));
            }
        }

        clear = new JButton(org.openide.util.NbBundle.getMessage(DateChooserDialog.class, "clear"));
        clear.addActionListener(this);
        okButton = new JButton(org.openide.util.NbBundle.getMessage(DateChooserDialog.class, "select"));
        okButton.addActionListener(this);

        getRootPane().setDefaultButton(okButton);

        cancelButton = new JButton(org.openide.util.NbBundle.getMessage(DateChooserDialog.class, "cancel"));
        cancelButton.addActionListener(this);

        JPanel monthPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        monthPanel.add(monthLast);
        monthPanel.add(month);
        monthPanel.add(monthNext);

        JPanel yearPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        yearPanel.add(yearLast);
        yearPanel.add(year);
        yearPanel.add(yearNext);

        JPanel monthYear = new JPanel();
        monthYear.add(monthPanel);
        monthYear.add(yearPanel);

        headGrid = new JPanel(new GridLayout(1, 7, 1, 1));
        headGrid.addFocusListener(this);
        headGrid.addKeyListener(this);
        for (int j = 0; j < 7; j++) {
            headGrid.add(days[0][j]);
        }
        headGrid.setBorder(EMPTY_BORDER);

        daysGrid = new FocusablePanel(new GridLayout(6, 7, 1, 1));
        daysGrid.addFocusListener(this);
        daysGrid.addKeyListener(this);
        for (int i = 1; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                daysGrid.add(days[i][j]);
            }
        }
        daysGrid.setBackground(GRID_BACKGROUND);

        JPanel daysPanel = new JPanel(new BorderLayout());
        daysPanel.add(headGrid, BorderLayout.NORTH);
        daysPanel.add(daysGrid, BorderLayout.CENTER);

        todayPane = new JEditorPane();
        todayPane.setEditable(false);
        todayPane.setBackground(monthPanel.getBackground());
        todayPane.setContentType("text/html");
        String today = org.openide.util.NbBundle.getMessage(DateChooserDialog.class, "today.is");
//        todayPane.setText("<html><body><p align='center' style='font-family:sans-serif;font-size:90%'>"
//                + today + " <a href=''>" + DF.format(new Date()) + "</a></p><br></body></html>");
        todayPane.setText("<html><body><p align='center' style='font-family:sans-serif'>"
                + today + " <a href=''>" + DF.format(new Date()) + "</a></p><br></body></html>");

        todayPane.addHyperlinkListener(new HyperlinkListener() {
            public void hyperlinkUpdate(HyperlinkEvent e) {
                if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
                    goToday();
                }
            }
        });

        daysPanel.add(todayPane, BorderLayout.SOUTH);

        JPanel buttons = new JPanel();
        buttons.add(clear);
        buttons.add(okButton);
        buttons.add(cancelButton);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(monthYear, BorderLayout.NORTH);
        mainPanel.add(daysPanel, BorderLayout.CENTER);
        mainPanel.add(buttons, BorderLayout.SOUTH);

        JPanel fillBottomPanel = new JPanel();
        fillBottomPanel.setPreferredSize(new Dimension(0, 32));
        JPanel fillWestPanel = new JPanel();
        fillWestPanel.setPreferredSize(new Dimension(32, 0));
        JPanel fillEastPanel = new JPanel();
        fillEastPanel.setPreferredSize(new Dimension(32, 0));

        Container dialog = getContentPane();
        dialog.setLayout(new BorderLayout());
        dialog.add(mainPanel, BorderLayout.CENTER);
        dialog.add(fillBottomPanel, BorderLayout.SOUTH);
        dialog.add(fillWestPanel, BorderLayout.WEST);
        dialog.add(fillEastPanel, BorderLayout.EAST);

        pack();

        setResizable(false);

        daysGrid.requestFocusInWindow();
    }

    /* Gets the selected day, as an <code>int</code>. Parses the text of the
     * selected label in the calendar to get the day.
     * @return the selected day or -1 if there is no day selected. */
    private int getSelectedDay() {
        if (day == null) {
            return -1;
        }
        try {
            return Integer.parseInt(day.getText());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    /* Sets the selected day. The day is specified as the label control, in the
     * calendar, corresponding to the day to select.
     * @param newDay The day to select. */
    private void setSelected(JLabel newDay) {
        if (day != null) {
            day.setForeground(DAYS_FOREGROUND);
            day.setBackground(DAYS_BACKGROUND);
        }
        day = newDay;
        day.setForeground(SELECTED_DAY_FOREGROUND);
        day.setBackground(SELECTED_DAY_BACKGROUND);

        daysGrid.requestFocusInWindow();
    }

//    /**
//     * Make sure no days are selected.
//     * @since 2.0.2
//     */
//    private void clearSelection() {
//        System.out.println("A ******" + " DateChooserDialog.clearSelection() ******" );
//        day = null;
//        if (days != null) {
//            System.out.println("B ******" + " DateChooserDialog.clearSelection() ******" );
//            for (int i = 1; i < 7; i++) {
//                System.out.println("C ******" + " DateChooserDialog.clearSelection() ******" );                
//                for (int j = 0; j < 7; j++) {
//                    System.out.println("D ******" + " DateChooserDialog.clearSelection() ******" );                
//                    days[i][j].setForeground(DAYS_FOREGROUND);
//                    days[i][j].setBackground(DAYS_BACKGROUND);
//                }
//            }
//        }
//    }

    private void goToday() {
        Calendar cal = Calendar.getInstance();
        year.setSelectedIndex(cal.get(Calendar.YEAR) - FIRST_YEAR);
        month.setSelectedIndex(cal.get(Calendar.MONTH) - Calendar.JANUARY);
        setSelected(cal.get(Calendar.DAY_OF_MONTH));
    }

    private void goLastMonth() {
        int i = month.getSelectedIndex() - 1;
        if (i >= MONTH_INDEX_JANUARY) {
            month.setSelectedIndex(i);
            update();
        } else {
            month.setSelectedIndex(MONTH_INDEX_DECEMBER);
            goLastYear();
        }
    }

    private void goNextMonth() {
        int i = month.getSelectedIndex() + 1;
        if (i <= MONTH_INDEX_DECEMBER) {
            month.setSelectedIndex(i);
            update();
        } else {
            month.setSelectedIndex(MONTH_INDEX_JANUARY);
            goNextYear();
        }
    }

    private void goLastYear() {
        int i = year.getSelectedIndex() - 1;
        if (i > -1) {
            year.setSelectedIndex(i);
            update();
        }
    }

    private void goNextYear() {
        int i = year.getSelectedIndex() + 1;
        if (i < year.getItemCount()) {
            year.setSelectedIndex(i);
            update();
        }
    }

    /* Sets the selected day. The day is specified as the number of the day, in
     * the month, to selected. The function compute the corresponding control to
     * select.
     * @param newDay The day to select. */
    private void setSelected(int newDay) {
        setSelected(days[(newDay + offset - 1) / 7 + 1][(newDay + offset - 1) % 7]);
    }

    /* Updates the calendar. This function updates the calendar panel to reflect
     * the month and year selected. It keeps the same day of the month that was
     * selected, except if it is beyond the last day of the month. In this case,
     * the last day of the month is selected. */
    private void update() {

        int iday = getSelectedDay();

        for (int i = 0; i < 7; i++) {
            days[1][i].setText(" ");
            days[5][i].setText(" ");
            days[6][i].setText(" ");
        }

        calendar.set(Calendar.DATE, 1);
        calendar.set(Calendar.MONTH, month.getSelectedIndex() + Calendar.JANUARY);
        calendar.set(Calendar.YEAR, year.getSelectedIndex() + FIRST_YEAR);

        offset = calendar.get(Calendar.DAY_OF_WEEK) - Calendar.SUNDAY;

        if (FIRST_DAY == Calendar.MONDAY) {
            offset = (offset > 0) ? offset - 1 : 6;
        }

        lastDay = calendar.getActualMaximum(Calendar.DATE);
        for (int i = 0; i < lastDay; i++) {
            days[(i + offset) / 7 + 1][(i + offset) % 7].setText(String.valueOf(i + 1));
        }

        if (iday != -1) {
            if (iday > lastDay) {
                iday = lastDay;
            }
            setSelected(iday);
        }

    }

    /**
     * Called when the "Ok" button is pressed. Just sets a flag and hides the
     * dialog box.
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == okButton) {
            okay = true;
        } else if (e.getSource() == cancelButton) {
            cancel = true;
        }
        setVisible(false);
//      dispose();
    }

    /**
     * Called when the calendar gains the focus. Just re-sets the selected day
     * so that it is redrawn with the border that indicate focus.
     */
    public void focusGained(FocusEvent e) {
        setSelected(day);
    }

    /**
     * Called when the calendar loses the focus. Just re-sets the selected day
     * so that it is redrawn without the border that indicate focus.
     */
    public void focusLost(FocusEvent e) {
//////        setSelected(day);
    }

    /**
     * Called when a new month or year is selected. Updates the calendar to
     * reflect the selection.
     */
    public void itemStateChanged(ItemEvent e) {
        update();
    }

    /**
     * Called when a key is pressed and the calendar has the focus. Handles the
     * arrow keys so that the user can select a day using the keyboard.
     */
    public void keyPressed(KeyEvent e) {
        int iday = getSelectedDay();
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                if (iday > 1) {
                    setSelected(iday - 1);
                }
                break;
            case KeyEvent.VK_RIGHT:
                if (iday < lastDay) {
                    setSelected(iday + 1);
                }
                break;
            case KeyEvent.VK_UP:
                if (iday > 7) {
                    setSelected(iday - 7);
                }
                break;
            case KeyEvent.VK_DOWN:
                if (iday <= lastDay - 7) {
                    setSelected(iday + 7);
                }
                break;
        }
    }

    /**
     * Called when the mouse is clicked on a day in the calendar. Selects the
     * clicked day.
     */
    public void mouseClicked(MouseEvent e) {
        JLabel theDay = (JLabel) e.getSource();
        if (!theDay.getText().equals(" ")) {
            setSelected(theDay);
        }
        // if double click then automatically okay the dialog
        if (e.getClickCount() > 1) {
            okay = true;
            cancel = false;
            setVisible(false);
        } else {
            daysGrid.requestFocus();
        }
    }

    public void keyReleased(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    /*
     * Constructs a new instance for the given window owner and default title.
     * @param owner The owning window.
     * @param firstDay The first day must be Calendar.SUNDAY or Calendar.Monday.
     */
    public DateChooserDialog(Frame owner) {
        this(owner, DEFAULT_TITLE);
    }

    /*
     * Constructs a new instance for the given window owner.
     * @param owner The owning window.
     * @param title The dialog title.
     * @param firstDay The first day must be Calendar.SUNDAY or Calendar.Monday.
     */
    public DateChooserDialog(Frame owner, String title) {
        super(owner, title, true);
        initialise();
    }

    /*
     * Constructs a new instance for the given dialog owner and default title.
     * @param owner The owning dialog.
     * @param firstDay The first day must be Calendar.SUNDAY or Calendar.Monday.
     */
    public DateChooserDialog(Dialog owner) {
        this(owner, DEFAULT_TITLE);
    }

    /*
     * Constructs a new instance for the given window owner.
     * @param owner The owning dialog.
     * @param title The dialog title.
     * @param firstDay The first day must be Calendar.SUNDAY or Calendar.Monday.
     */
    public DateChooserDialog(Dialog owner, String title) {
        super(owner, title, true);
        initialise();
    }

    private void initialise() {
//        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        FIRST_DAY = DatesPrefs.getFirstDayOfWeek();
        DAYS = (FIRST_DAY == DatesPrefs.MONDAY) ? DAYS_MON_FIRST : DAYS_SUN_FIRST;
    }

    /**
     * Selects a date. Displays the dialog box, with a given date as the
     * selected date, and allows the user select a new date.
     * @param date The initial date.
     * @param component The component to position the dialog relative to.
     * @return the new date selected or <code>null</code> if the user press
     * "Cancel" or closes the dialog box
     */
    public Date select(Date date, Component component) {
        // lazy construction to minimise memory retention
        if (calendar == null) {
            construct();
        } 

        int hour = 0, min = 0, sec = 0, msec = 0;

        if (date == null) {
            date = new Date();
            calendar.setTime(date);
        } else {
            calendar.setTime(date);
            hour = calendar.get(Calendar.HOUR_OF_DAY);
            min = calendar.get(Calendar.MINUTE);
            sec = calendar.get(Calendar.SECOND);
            msec = calendar.get(Calendar.MILLISECOND);
        }
        int _year = calendar.get(Calendar.YEAR);
        int _month = calendar.get(Calendar.MONTH);
        int _day = calendar.get(Calendar.DATE);

        year.setSelectedIndex(_year - FIRST_YEAR);
        month.setSelectedIndex(_month - Calendar.JANUARY);

        
//            // @since 2.0.2
//            clearSelection();
        
        setSelected(_day);

        okay = false;
        cancel = false;

        if (component != null) {
            setLocationRelativeTo(component);
        }

        daysGrid.requestFocusInWindow();

        setVisible(true);

        if (!okay) {
            return null;
        }

        calendar.set(Calendar.DATE, getSelectedDay());
        calendar.set(Calendar.MONTH, month.getSelectedIndex() + Calendar.JANUARY);
        calendar.set(Calendar.YEAR, year.getSelectedIndex() + FIRST_YEAR);

        // restore time values
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, min);
        calendar.set(Calendar.SECOND, sec);
        calendar.set(Calendar.MILLISECOND, msec);

        return calendar.getTime();
    }

    /**
     * Determines whether the cancel button was activated.
     * @return true iff the cancel button was activated.
     */
    public boolean cancelled() {
        return cancel;
    }

    /**
     * Determines whether the ok button was activated.
     * @return true iff the ok button was activated.
     */
    public boolean okayed() {
        return okay;
    }
}
