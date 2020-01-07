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
package tr.swing.editorpane;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.util.Date;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentListener;
import javax.swing.event.HyperlinkListener;
import javax.swing.text.BadLocationException;
import org.openide.util.NbBundle;
import tr.prefs.dates.DatesPrefs;

/**
 * Component for editable text with hyperlink code recognition and rendering.
 *
 * @author Jeremy Moore (jimoore@netspace.net.au)
 */
public class HyperEditorPane extends JPanel {
    
    /** Constructs a new instance. */
    public HyperEditorPane() {
        initComponents();
    }
    
    private void initComponents() {
        toolBar = new JToolBar();

        toolBar.setBorder(new EmptyBorder(0,0,0,0));
        toolBar.setBorderPainted(false);
        toolBar.setMargin(new Insets(0,0,0,0));



        scrollPane = new JScrollPane();
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        
        hyperPane = new JEditorPaneExt();
        hyperPane.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hyperPaneMouseClicked(evt);
            }
        });
        hyperPane.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    editButtonActionPerformed(null);
                } else if ((e.getModifiersEx() & INSERT_MASK) == INSERT_MASK) {
                    if (e.getKeyCode() == INSERT_DATE_KEY) {
                        dateButtonActionPerformed(null);
                    } else if (e.getKeyCode() == INSERT_TIME_KEY) {
                        timeButtonActionPerformed(null);
                    }
                }
            }
        });
        
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(50, 45));

        
        toolBar.setFloatable(false);
        toolBar.setMaximumSize(new Dimension(0, 0));
        toolBar.setMinimumSize(new Dimension(0, 23));
        
//      editButton = new JToggleButton();
        editButton = new JButton();
        editButton.setPreferredSize(BUTTON_SIZE);
        editButton.setIcon(new ImageIcon(getClass().getResource("/tr/swing/editorpane/IconEdit16.gif")));
        editButton.setToolTipText(NbBundle.getMessage(getClass(), "EditButtonToolTip"));
        editButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });
        toolBar.add(editButton);
        
        urlButton = new JButton();
        urlButton.setPreferredSize(BUTTON_SIZE);
        urlButton.setIcon(new ImageIcon(getClass().getResource("/tr/swing/editorpane/IconURL16.gif")));
        urlButton.setToolTipText(NbBundle.getMessage(getClass(), "URLButtonToolTip"));
        urlButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                urlButtonActionPerformed(evt);
            }
        });
        toolBar.add(urlButton);
        
        fileButton = new JButton();
        fileButton.setPreferredSize(BUTTON_SIZE);
        fileButton.setIcon(new ImageIcon(getClass().getResource("/tr/swing/editorpane/IconFile16.gif")));
        fileButton.setToolTipText(NbBundle.getMessage(getClass(), "FileButtonToolTip"));
        fileButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                fileButtonActionPerformed(evt);
            }
        });
        toolBar.add(fileButton);
        
        dateButton = new JButton();
        dateButton.setPreferredSize(BUTTON_SIZE);
        dateButton.setIcon(new ImageIcon(getClass().getResource("/tr/swing/editorpane/IconDate16.png")));
        dateButton.setToolTipText(NbBundle.getMessage(getClass(), "TodayButtonToolTip"));
        dateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                dateButtonActionPerformed(evt);
            }
        });
        toolBar.add(dateButton);
        
        timeButton = new JButton();
        timeButton.setPreferredSize(BUTTON_SIZE);
        timeButton.setIcon(new ImageIcon(getClass().getResource("/tr/swing/editorpane/IconTime16.png")));
        timeButton.setToolTipText(NbBundle.getMessage(getClass(), "NowButtonToolTip"));
        timeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                timeButtonActionPerformed(evt);
            }
        });
        
        toolBar.add(timeButton);
//        add(toolBar, BorderLayout.PAGE_START);
        add(toolBar, BorderLayout.NORTH);
        scrollPane.setViewportView(hyperPane);
        add(scrollPane, BorderLayout.CENTER);
        
        // Change to render mode when panel has lost focus
        hyperPane.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                urlButton.setFocusable(true);
                fileButton.setFocusable(true);
                dateButton.setFocusable(true);
                timeButton.setFocusable(true);
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (e.getOppositeComponent() != editButton
                        && e.getOppositeComponent() != urlButton
                        && e.getOppositeComponent() != fileButton
                        && e.getOppositeComponent() != dateButton
                        && e.getOppositeComponent() != timeButton) {
                    setEditable(false);
                    editButton.setFocusable(true);
                    urlButton.setFocusable(false);
                    fileButton.setFocusable(false);
                    dateButton.setFocusable(false);
                    timeButton.setFocusable(false);
                }
            }
        });
        
        setEditable(true);
    }
    
    private void hyperPaneMouseClicked(final MouseEvent evt) {
        if (evt.getClickCount() == 2) {
//          if (!hyperPane.isEditable()) {
            if (hyperPane.isEnabled() && !hyperPane.isEditable()) {
                evt.consume();
                editButton.requestFocusInWindow();
                editButtonActionPerformed(null);
            }
        }
    }
    
    private void editButtonActionPerformed(ActionEvent evt) {
        setEditable(!hyperPane.isEditable());
        if (hyperPane.isEditable()) {
            hyperPane.requestFocusInWindow();
            try {
                hyperPane.setCaretPosition(hyperPane.getText().length());
            } catch (Exception ex) {
            }
        } else {
            editButton.requestFocusInWindow();
        }
    }
    
    private void urlButtonActionPerformed(ActionEvent evt) {
        URLDialog dialog = new URLDialog(null, urlButton, org.openide.util.NbBundle.getMessage(HyperEditorPane.class, "insert.web.url"));
        int choice = dialog.showDialog();
        if (choice == JOptionPane.CANCEL_OPTION) {
            if (hyperPane.isEditable()) {
                hyperPane.requestFocusInWindow();
            }
            return;
        }
        
        String urlText = dialog.getURL().trim();
        String urlDesc = dialog.getLinkText().trim();
        
        // default protocol to HTTP if there isn't one
        if (!urlText.contains("://")) {
            urlText = "http://" + urlText;
        }
        
        // validate URL
        try {
            URL url = new URL(urlText);
        } catch (MalformedURLException ex) {
            LOG.severe(ex.getMessage());
            if (hyperPane.isEditable()) {
                hyperPane.requestFocusInWindow();
            }
            return;
        }
        
        String url = (urlDesc.length()==0) ? "["+urlText+"]" : "["+urlText+"|"+urlDesc+"]";
        insert(url);
    }
    
    private void fileButtonActionPerformed(ActionEvent evt) {
        // dialog to enter a file path or browse and select a file
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle(org.openide.util.NbBundle.getMessage(HyperEditorPane.class, "insert.file.url"));
        int option = chooser.showOpenDialog(null);
        if (option != JFileChooser.APPROVE_OPTION) {
            if (hyperPane.isEditable()) {
                hyperPane.requestFocusInWindow();
            }
            return;
        }
        // Validate file: make sure the file exists.
        String path = chooser.getSelectedFile().getPath();
        File file = new File(path);
        if (!file.exists()) {
            LOG.severe("File does not exist.");
            if (hyperPane.isEditable()) {
                hyperPane.requestFocusInWindow();
            }
            return;
        }
        // determine file URL
        String url = null;
        try {
            url = file.toURL().toExternalForm();
        } catch (MalformedURLException ex) {
            LOG.severe(ex.getMessage());
            if (hyperPane.isEditable()) {
                hyperPane.requestFocusInWindow();
            }
            return;
        }
        
        insert("[" + url + "]");
    }
    
    private void dateButtonActionPerformed(ActionEvent evt) {
        String date = DatesPrefs.formatLong(new Date());
        insert(date);
    }
    
    private void timeButtonActionPerformed(ActionEvent evt) {
        String time = DateFormat.getTimeInstance().format(new Date());
        insert(time);
    }
    
    private void insert(String str) {
        // save editing mode
        boolean editing = hyperPane.isEditable();
        
        // turn on editing mode if it's not already
        if (!editing) {
            setEditable(true);
        }
        
        try {
            hyperPane.textDocument.insertString(hyperPane.getCaretPosition(), str, null);
        } catch (BadLocationException ex) {
        }
        
        // restore editing mode
        if (editing) {
            hyperPane.requestFocusInWindow();
        } else {
            setEditable(false);
        }
    }
    
    /* Returns an empty string if index is zero or the character immediately
     * before index is a whitespace character, otherwise returns a single space
     * character. */
    private String getSeparator(String string, int index) {
        if (index < 1) {
            return "";
        }
        Pattern p = Pattern.compile("\\s"); // whitespace
        Matcher m = p.matcher(string.substring(index - 1, index));
        return m.matches() ? "" : " ";
    }
    
    /**
     * Overridden to disable the component including all sub-components.
     * @param enabled If true the component is enabled, otherwise it is disabled.
     */
    @Override
    public void setEnabled(boolean enabled) {
        hyperPane.setEnabled(enabled);
        editButton.setEnabled(enabled);
        fileButton.setEnabled(enabled);
        urlButton.setEnabled(enabled);
        dateButton.setEnabled(enabled);
        timeButton.setEnabled(enabled);        
        if (enabled) {
            setEditable(isEditable());
        } else {            
            hyperPane.setBackground(UIManager.getDefaults().getColor("TextArea.inactiveBackground"));
        }        
    }
    
    /**
     * Overrides JEditorPane.setEditable() to switch between editing text mode
     * and rendering HTML mode.
     * @param editable If true and not already in text edit mode, switch to text
     * edit mode. If false and not already in render mode, then switch to HTML
     * render mode.
     */
    public void setEditable(boolean editable) {
        hyperPane.setEditable(editable);
        if (editable) {
            hyperPane.setBackground(Color.white);
            editButton.setBackground(Color.darkGray);
        } else {
            hyperPane.setBackground(COLOR_NOTES);
            editButton.setBackground(Color.lightGray);
        }
    }
    
    /** Wraps JEditorPane.isEditable() */
    public boolean isEditable() {
        return hyperPane.isEditable();
    }
    
    /**
     * Overrides JEditorPane.getText() to get the text regardless of mode (edit
     * text or render HTML).
     */
    public String getText() {
        return hyperPane.getText();
    }
    
    /**
     * Overrides JEditorPane.setText(...) to set the text regardless of mode
     * (edit text or render HTML).
     */
    public void setText(String text) {
        hyperPane.setText(text);
    }
    
    /**
     * Adds a document listener.
     * @param listener The document listener to add.
     */
    public void addDocumentListener(DocumentListener listener) {
        hyperPane.textDocument.addDocumentListener(listener);
    }
    
    /**
     * Removes a document listener.
     * @param listener The document listener to remove.
     */
    public void removeDocumentListener(DocumentListener listener) {
        hyperPane.textDocument.removeDocumentListener(listener);
    }
    
    
    /** Wraps JEditorPane.addHyperlinkListener(...) */
    public void addHyperlinkListener(HyperlinkListener listener) {
        hyperPane.addHyperlinkListener(listener);
    }
    
    /** Wraps JEditorPane.removeHyperlinkListener(...) */
    public void removeHyperlinkListener(HyperlinkListener listener) {
        hyperPane.removeHyperlinkListener(listener);
    }
    
    /** Provides the underlying JEditorPane. */
    public JEditorPane getJEditorPane() {
        return hyperPane;
    }
    
    /** Provides the edit button. */
//  public JToggleButton getEditButton() {
    public JButton getEditButton() {
        return editButton;
    }
    
    /** Provides the URL button. */
    public JButton getURLButton() {
        return urlButton;
    }
    
    /** Provides the file button. */
    public JButton getFileButton() {
        return fileButton;
    }
    
    /** Provides the date button. */
    public JButton getDateButton() {
        return dateButton;
    }
    
    /** Provides the time button. */
    public JButton getTimeButton() {
        return timeButton;
    }
    
    private static final Logger LOG = Logger.getLogger("tr.swing.editorpane");
    private JEditorPaneExt hyperPane;
//  private JToggleButton editButton;
    private JButton editButton;
    private JButton fileButton;
    private JButton urlButton;
    private JScrollPane scrollPane;
    private JToolBar toolBar;
    private JButton dateButton;
    private JButton timeButton;
    
    private static final int INSERT_MASK = KeyEvent.CTRL_DOWN_MASK | KeyEvent.ALT_DOWN_MASK;
    private static final int INSERT_DATE_KEY = KeyEvent.VK_D;
    private static final int INSERT_TIME_KEY = KeyEvent.VK_T;
    // Note: RGB(255,255,204) is a web safe colour
    private static final Color COLOR_NOTES = new Color(255, 255, 204);
    private static final Dimension BUTTON_SIZE = new Dimension(20, 20);
    
    @Override
    public void addFocusListener(FocusListener l) {
        hyperPane.addFocusListener(l);
    }
    
    @Override
    public void removeFocusListener(FocusListener l) {
        hyperPane.removeFocusListener(l);
    }
    
}
