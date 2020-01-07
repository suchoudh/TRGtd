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
 * Portions Copyright 2006-2009 Avente Pty Ltd. All Rights Reserved.
 */
package tr.view.filters;

import au.com.trgtd.tr.appl.Constants;
import org.openide.util.NbBundle;
import tr.model.IDGenerator;
import tr.model.criteria.Value;

/**
 * Value for edit of multiple values for MS Windows systems only.
 *
 * @author Jeremy Moore (jimoore@netspace.net.au)
 */
public class ValueMultipleEdit extends Value {
    
    public static final String ID = "ValueMultipleEdit";
    
    private static final IDGenerator ID_GENERATOR = new IDGenerator() {
        public int getNextID() {
            return Constants.ID_FILTER_MULTIPLE_EDIT;
        }
    };
    
    public ValueMultipleEdit() {
        super(NbBundle.getMessage(ValueMultipleEdit.class, "windows-multiple-edit"), ID_GENERATOR);
    }
    
    public boolean equals(Object object) {
        return object instanceof ValueMultipleEdit;
    }
    
}
