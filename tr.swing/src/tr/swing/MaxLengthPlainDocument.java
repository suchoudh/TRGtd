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

import java.awt.Toolkit;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 * A plain document that limits the number of input characters allowed.  This
 * class can be used to limit the number of characters in a JTextField.  For
 * example, to limit a JTextField to 6 imput characters:
 *
 * 		...
 * 		JTextField t = new JTextField();
 * 		t.setDocument(new MaxLengthPlainDocument(6));
 * 		...
 *
 * @author Jeremy Moore (jeremyimoore@yahoo.com.au)
 */
public class MaxLengthPlainDocument extends PlainDocument {
    
    private final int maxLength;
    private final boolean beep;
    
    /**
     * Constructs a new instance for the specified maximum length.
     * @param maxLength The maximum number of input characters allowed.
     * @param beep If true a beep will sound when the user tries to exceed the
     * maximum number of input characters.
     */
    public MaxLengthPlainDocument(int maxLength, boolean beep) {
        this.maxLength = maxLength;
        this.beep = beep;
    }
    
    /**
     * Overridden to check and limit the number of characters.
     */
    public void insertString(int offset, String s, AttributeSet a) throws BadLocationException {
        if (offset + s.length() <= maxLength) {
            super.insertString(offset, s, a);
        } else {
            if (beep) Toolkit.getDefaultToolkit().beep();
        }
    }
    
}
