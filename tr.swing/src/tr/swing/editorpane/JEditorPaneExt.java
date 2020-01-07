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

import java.awt.KeyboardFocusManager;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JEditorPane;
import javax.swing.JTextField;
import javax.swing.text.Document;
import javax.swing.text.EditorKit;
import javax.swing.text.html.HTMLEditorKit;

/**
 * JEditorPane extension for editable text with hyperlink code recognition and
 * rendering.
 *
 * @author Jeremy Moore (jimoore@netspace.net.au)
 */
public class JEditorPaneExt extends JEditorPane {
    
    private final static String CONTENT_TYPE_TEXT = "text/plain";
    private final static String CONTENT_TYPE_HTML = "text/html";
    private final EditorKit editorKitTEXT = createEditorKitForContentType(CONTENT_TYPE_TEXT);
    private final EditorKit editorKitHTML = new HTMLEditorKit();

    final Document textDocument;
    
    /* Store text while in HTML mode. */
    private transient String text = "";
    
    /** Constructs a new instance. */
    public JEditorPaneExt() {
        super();
        super.putClientProperty(JEditorPane.HONOR_DISPLAY_PROPERTIES, Boolean.TRUE);
        super.setFont(new JTextField().getFont());
        super.setEditorKitForContentType(CONTENT_TYPE_TEXT, editorKitTEXT);
        super.setEditorKitForContentType(CONTENT_TYPE_HTML, editorKitHTML);
        // must start in text mode to be recognised as a palette bean component
        super.setContentType(CONTENT_TYPE_TEXT);
        textDocument = super.getDocument();
        super.setEditable(true);
        super.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_TAB) {
                    e.consume();
                    KeyboardFocusManager.getCurrentKeyboardFocusManager().focusNextComponent();
                }
                if (e.getKeyCode() == KeyEvent.VK_TAB && e.isShiftDown()) {
                    e.consume();
                    KeyboardFocusManager.getCurrentKeyboardFocusManager().focusPreviousComponent();
                }
            }
        });
    }
    
    /**
     * Overridden to switch between editing text mode and rendering HTML mode.
     * @param editable If true and not already in text edit mode, switch to text
     * edit mode. If false and not already in render mode, then switch to HTML
     * render mode.
     */
    @Override
    public void setEditable(boolean editable) {
        // must be a change from editable to not editable or vice versa
        if (editable == super.isEditable()) {
            return;
        }
        if (editable) {
            super.setContentType(CONTENT_TYPE_TEXT);
            // use the same text document to keep document listeners
            if (textDocument != null) {
                super.setDocument(textDocument);
            }
            super.setText(text);
            super.setEditable(true);
        } else {
            super.setEditable(false);
            text = super.getText();
            super.setContentType(CONTENT_TYPE_HTML);
            super.setText(Utils.text2html(text));
            if (hasFocus()) {
                transferFocus();
            }
        }
    }
    
    /** Overridden to return text regardless of mode (editing or rendering). */
    @Override
    public String getText() {
        if (isEditable()) {
            return super.getText();
        } else {
            return text;
        }
    }
    
    /** Overridden to set text regardless of mode (editing or rendering). */
    @Override
    public void setText(String text) {
        if (isEditable()) {
            this.text = text;
            super.setText(text);
        } else {
            setEditable(true);
            this.text = text;
            super.setText(text);
            setEditable(false);
        }
    }
    
}
