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
package tr.view;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.UIManager;

/**
 * Utilities for views.
 *
 * @author Jeremy Moore
 */
public class ViewUtils {

    //  private static final Color LABEL_COLOR = new Color(0, 70, 213);
//  private static final Color LINE_FG_COLOR = new Color(153, 153, 153);
//  private static final Color LINE_FG_COLOR = new Color(204, 204, 204);
//  private static final Color LINE_BG_COLOR = new Color(255, 255, 255);
    private static final Color COLOR_SEP_LINE = new Color(153, 153, 153);
    private static final Color COLOR_SEP_TEXT = Color.BLACK;
    private static final Color COLOR_PANEL_BG = UIManager.getColor("Panel.background");
    private static final Font FONT_BOLD = (new JLabel()).getFont().deriveFont(Font.BOLD);

    public static final void addSeparator(JPanel panel) {
        JSeparator separator = new JSeparator();
        separator.setOpaque(true);
        separator.setBackground(COLOR_SEP_LINE);
        separator.setForeground(COLOR_PANEL_BG);
//        separator.setPreferredSize(new Dimension(100,1));
//      panel.add(separator, "gapbottom 0, gaptop 0, span, growx, wrap");
        panel.add(separator, "gaptop 1, gapbottom 1, aligny center, span, growx, wrap");
    }

    public static final void addSeparator(JPanel panel, String text) {
        addSeparator(panel, new JLabel(text));
    }

    public static final void addSeparator(JPanel panel, JLabel label) {
        label.setForeground(COLOR_SEP_TEXT);
        label.setFont(FONT_BOLD);
        JSeparator separ = new JSeparator();
        separ.setOpaque(true);
        separ.setBackground(COLOR_SEP_LINE);
        separ.setForeground(COLOR_PANEL_BG);
//        panel.add(label, "gapbottom 0, gaptop 0, span, split 2, aligny center");
//        panel.add(separ, "gapbottom 0, gaptop 0, gapleft rel, growx, wrap");
        panel.add(label, "span, split 2, aligny center");
        panel.add(separ, "gapleft rel, growx, wrap");
    }

    public static final boolean isAquaLaF() {
        return "Aqua".equals(UIManager.getLookAndFeel().getID());
    }

}
