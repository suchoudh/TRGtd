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

import javax.swing.DefaultComboBoxModel;
import tr.model.criteria.Criterion;
import tr.util.Observable;
import tr.util.Observer;

/**
 * Criterion ComboBoxModel.
 */
public class CriterionComboBoxModel extends DefaultComboBoxModel implements Observer {
    
    private final Criterion criterion;
    
    /**
     * Constructs a new instance for the given criterion.
     * @param criterion The criterion.
     */
    public CriterionComboBoxModel(Criterion criterion) {
        super();
        this.criterion = criterion;
        this.criterion.addObserver(this);
    }
    
    /**
     * Implement ListModel.getElementAt(int index).
     */
    @Override
    public Object getElementAt(int index) {
        return criterion.values.get(index);
    }
    
    /**
     * Implement ListModel.getSize().
     */
    @Override
    public int getSize() {
        return criterion.values.size();
    }
    
    /**
     * Implement Observer to fire contents changed.
     */
    public void update(Observable o, Object arg) {
        fireContentsChanged(this, 0, getSize());
    }
    
}