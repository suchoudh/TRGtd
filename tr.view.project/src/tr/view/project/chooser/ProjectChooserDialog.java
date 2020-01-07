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
package tr.view.project.chooser;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import org.openide.util.NbBundle;
import org.openide.util.Utilities;
import tr.model.project.Project;

/**
 * Custom dialog box to choose a project.
 */
public class ProjectChooserDialog extends JDialog implements FocusListener, ActionListener {

    private static final Class CLASS = ProjectChooserDialog.class;
    private static final String TITLE = NbBundle.getMessage(CLASS, "dialog.title");
    
    private ProjectsPanel panel;
    private JButton okayButton;
    private JButton cancelButton;
    private boolean okay;
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

        okayButton = new JButton(NbBundle.getMessage(ProjectChooserDialog.class, "dialog.okay"));
        okayButton.addActionListener(this);

        getRootPane().setDefaultButton(okayButton);

        cancelButton = new JButton(NbBundle.getMessage(ProjectChooserDialog.class, "dialog.cancel"));
        cancelButton.addActionListener(this);

        JPanel buttonsPanel = new JPanel();
        if (Utilities.isWindows()) {
            buttonsPanel.add(okayButton);
            buttonsPanel.add(cancelButton);            
        } else {
            buttonsPanel.add(cancelButton);            
            buttonsPanel.add(okayButton);
        }

        panel = new ProjectsPanel();
        panel.addActionListener(this);
        
        JPanel mainPanel = new JPanel(new BorderLayout());        
        
        mainPanel.add(buttonsPanel, BorderLayout.SOUTH);
        mainPanel.add(panel, BorderLayout.CENTER);

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

        setResizable(true);

//      daysGrid.requestFocusInWindow();
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


    /**
     * Called when the "Ok" button is pressed. Just sets a flag and hides the
     * dialog box.
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == okayButton || e.getSource() == panel) {
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
    }

    /**
     * Called when the calendar loses the focus. Just re-sets the selected day
     * so that it is redrawn without the border that indicate focus.
     */
    public void focusLost(FocusEvent e) {
    }


    /*
     * Constructs a new instance for the given window owner and default title.
     * @param owner The owning window.
     * @param firstDay The first day must be Calendar.SUNDAY or Calendar.Monday.
     */
    public ProjectChooserDialog(Frame owner) {
        this(owner, TITLE);
    }

    /*
     * Constructs a new instance for the given window owner.
     * @param owner The owning window.
     * @param title The dialog title.
     * @param firstDay The first day must be Calendar.SUNDAY or Calendar.Monday.
     */
    public ProjectChooserDialog(Frame owner, String title) {
        super(owner, title, true);
        construct();        
        initialise();
    }

    /*
     * Constructs a new instance for the given dialog owner and default title.
     * @param owner The owning dialog.
     * @param firstDay The first day must be Calendar.SUNDAY or Calendar.Monday.
     */
    public ProjectChooserDialog(Dialog owner) {
        this(owner, TITLE);
    }

    /*
     * Constructs a new instance for the given window owner.
     * @param owner The owning dialog.
     * @param title The dialog title.
     * @param firstDay The first day must be Calendar.SUNDAY or Calendar.Monday.
     */
    public ProjectChooserDialog(Dialog owner, String title) {
        super(owner, title, true);
        construct();
        initialise();
    }

    private void initialise() {
//      setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
    }

    /**
     * Selects a project.
     */
    public Project select(Project project, Component component) {
        okay = false;
        cancel = false;
        if (component != null) {
            setLocationRelativeTo(component);
        }

        panel.refreshModel();
        panel.setSelected(project);
        
//      daysGrid.requestFocusInWindow();

        setVisible(true);
        
        if (!okay) {
            return null;
        }
  
        return panel.getSelected();
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
