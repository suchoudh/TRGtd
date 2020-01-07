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

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;

/**
 * Extends <code>javax.swing.ButtonGroup</code> to provide methods that allow
 * working with button references instead of button models.
 */
public class JButtonGroup extends ButtonGroup {
    
    /* Used to deselect all buttons in the group. */
    private static final AbstractButton dummyButton = new JButton();
    
    /* Stores a reference to the currently selected button in the group. */
    private AbstractButton selectedButton;
    
    /** Creates an empty <code>JButtonGroup</code> */
    public JButtonGroup() {
        super();
        add(dummyButton);
    }
    
    /**
     * Creates a <code>JButtonGroup</code> object from an array of buttons and
     * adds the buttons to the group No button will be selected initially.
     * @param buttons An array of <code>AbstractButton</code>s
     */
    public JButtonGroup(AbstractButton[] buttons) {
        add(buttons);
        add(dummyButton);
    }
    
    /**
     * Adds a button to the group.
     * @param button An <code>AbstractButton</code> reference
     */
    public void add(AbstractButton button) {
        if (button == null || buttons.contains(button)) {
            return;
        }
        super.add(button);
        if (getSelection() == button.getModel()) {
            selectedButton = button;
        }
    }
    
    /**
     * Adds an array of buttons to the group.
     * @param newButtons An array of <code>AbstractButton</code>s
     */
    public void add(AbstractButton[] newButtons) {
        if (newButtons == null) {
            return;
        }
        for (int i = 0; i < newButtons.length; i++) {
            add(newButtons);
        }
    }
    
    /**
     * Removes a button from the group.
     * @param button The button to be removed.
     */
    public void remove(AbstractButton button) {
        if (button != null) {
            if (selectedButton == button) {
                selectedButton = null;
            }
            super.remove(button);
        }
    }
    
    /**
     * Removes all the buttons in the array from the group.
     * @param oldButtons An array of <code>AbstractButton</code>s.
     */
    public void remove(AbstractButton[] oldButtons) {
        if (oldButtons == null) {
            return;
        }
        for (int i = 0; i < oldButtons.length; i++) {
            remove(oldButtons);
        }
    }
    
    /**
     * Sets the selected button in the group Only one button in the group can be
     * selected.
     * @param button An <code>AbstractButton</code> reference.
     * @param selected An <code>boolean</code> representing the selection state
     * of the button.
     */
    public void setSelected(AbstractButton button, boolean selected) {
        if (button != null && buttons.contains(button)) {
            setSelected(button.getModel(), selected);
            if (getSelection() == button.getModel()) {
                selectedButton = button;
            }
        }
    }
    
    /**
     * Sets the selected button model in the group.
     * @param model A <code>ButtonModel</code> reference.
     * @param selected An <code>boolean</code> representing the selection state
     * of the button.
     */
    public void setSelected(ButtonModel model, boolean selected) {
        AbstractButton button = getButton(model);
        if (buttons.contains(button)) {
            super.setSelected(model, selected);
            if (model != dummyButton.getModel()) {
                selectedButton = button;
            }
        }
    }
    
    /**
     * Returns the <code>AbstractButton</code> whose <code>ButtonModel</code>
     * is given. If the model does not belong to a button in the group, returns
     * null.
     * @param model A <code>ButtonModel</code> that should belong to a button in
     * the group.
     * @return An <code>AbstractButton</code> reference whose model is
     * <code>model</code> if the button belongs to the group, <code>null</code>
     * otherwise.
     */
    public AbstractButton getButton(ButtonModel model) {
        for (Iterator i = buttons.iterator(); i.hasNext();) {
            AbstractButton ab = (AbstractButton)i.next();
            if (ab.getModel() == model) {
                return ab;
            }
        }
        return null;
    }
    
    /**
     * Returns the selected button in the group.
     * @return A reference to the currently selected button in the group or
     * <code>null</code> if no button is selected.
     */
    public AbstractButton getSelected() {
        if (selectedButton == dummyButton) return null;
        
        return selectedButton;
    }
    
    public ButtonModel getSelection() {
        if (selectedButton == dummyButton) return null;
        
        return super.getSelection();
    }
    
    /**
     * Returns whether the button is selected.
     * @param button An <code>AbstractButton</code> reference.
     * @return <code>true</code> if the button is selected, <code>false</code>
     * otherwise.
     */
    public boolean isSelected(AbstractButton button) {
        if (button == dummyButton) {
            return false;
        }
        return button == selectedButton;
    }
    
    /**
     * Returns the buttons in the group as a <code>List</code>
     * @return a <code>List</code> containing the buttons in the group, in the
     * order they were added to the group.
     */
    public List getButtons() {
        List<AbstractButton> allButtons = new LinkedList<AbstractButton>(buttons);
        allButtons.remove(dummyButton);
        return Collections.unmodifiableList(allButtons);
    }
    
    /**
     * Checks whether the group contains the given button
     * @return <code>true</code> if the button is contained in the group,
     *         <code>false</code> otherwise.
     */
    public boolean contains(AbstractButton button) {
        if (button == dummyButton) {
            return false;
        }
        return buttons.contains(button);
    }
    
    /** Unselects all buttons. */
    public void unselectAll() {
        setSelected(dummyButton, true);
    }
    
}
