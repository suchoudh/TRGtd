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
package tr.view.criteria;

import au.com.trgtd.tr.appl.Constants;
import java.awt.Font;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;

/**
 * Combo box for energy criteria.
 *
 * @author <a href="mailto:jimoore@netspace.net.au">Jeremy Moore</a>
 */
public class EnergyComboBox extends JComboBox {

    /**
     * Constructs a new default instance.
     */
    public EnergyComboBox() {
        this(new EnergyComboBoxModel());
    }

    /**
     * Constructs a new instance for the given data model.
     * @param model The combo box model.
     */
    public EnergyComboBox(ComboBoxModel model) {
        super(model);
        setFont(getFont().deriveFont(Font.PLAIN));
        setMaximumRowCount(Constants.COMBO_MAX_ROWS);
    }
}
