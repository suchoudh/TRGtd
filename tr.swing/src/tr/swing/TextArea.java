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

package tr.swing;

import java.awt.KeyboardFocusManager;

import javax.swing.JTextArea;
import javax.swing.text.Document;

public class TextArea extends JTextArea {
    
//  private static final Border BORDER = (new JTextField()).getBorder();
    
    /**
     * Constructs a new default instance.
     */
    public TextArea() {
        super();
//      setBorder(BORDER);
        initKeymap();
        setLineWrap(true);
        setWrapStyleWord(true);
    }
    
    /**
     * Constructs a new instance with the given document model, and defaults for
     * all of the other arguments (null, 0, 0).
     */
    public TextArea(Document doc) {
        super(doc);
        initKeymap();
    }
    
    /**
     * Constructs a new JTextArea with the specified number of rows and columns,
     * and the given model.
     *
     * @param doc
     * @param text
     * @param rows
     * @param columns
     */
    public TextArea(Document doc, String text, int rows, int columns) {
        super(doc, text, rows, columns);
        initKeymap();
    }
    
    /**
     * Constructs a new empty TextArea with the specified number of rows and
     * columns.
     * @param rows
     * @param columns
     */
    public TextArea(int rows, int columns) {
        super(rows, columns);
        initKeymap();
    }
    
    /**
     * Constructs a new TextArea with the specified text displayed.
     * @param text
     */
    public TextArea(String text) {
        super(text);
        initKeymap();
    }
    
    /**
     * Constructs a new TextArea with the specified text and number of rows and
     * columns.
     * @param text
     * @param rows
     * @param columns
     */
    public TextArea(String text, int rows, int columns) {
        super(text, rows, columns);
        initKeymap();
    }
    
    // Change Tab and Ctrl-Tab to traverse fields.
    private void initKeymap() {
        setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, null);
        setFocusTraversalKeys(KeyboardFocusManager.BACKWARD_TRAVERSAL_KEYS, null);
    }
    
}
