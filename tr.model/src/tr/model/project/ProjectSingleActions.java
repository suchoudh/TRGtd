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

package tr.model.project;

import tr.model.IDGenerator;
import tr.model.Item.Item;
import tr.model.action.Action;
import au.com.thinkingrock.tr.resource.Icons;
import au.com.trgtd.tr.appl.Constants;
import javax.swing.ImageIcon;

/**
 * Project for single actions.
 *
 * @author Jeremy Moore
 */
public class ProjectSingleActions extends Project {
    
    /** Default constructor. */
    public ProjectSingleActions() {
        super(new IDGenerator() {
            public int getNextID() {
                return Constants.ID_ROOT_ACTIONS;
            }
        });
    }
    
    /**
     * Determines whether the item item is user editable.
     * @return false.
     */
    @Override
    public boolean isEditable() {
        return false;
    }    

    /**
     * Determines whether the project is a root project.
     * @return true.
     */
    @Override
    public boolean isRoot() {
        return true;
    }

    /**
     * Determines whether the node can have any children.
     * @return true since it can have children.
     */
    public boolean getAllowsChildren() {
        return true;
    }
    
    /** Overridden to only allow actions to be added. */
    @Override
    public boolean canAdd(Item item) {
        return (item instanceof Action && super.canAdd(item));
    }
    
    /** Overridden to return single actions description. */
    @Override
    public String getDescription() {
        return org.openide.util.NbBundle.getMessage(ProjectSingleActions.class, "Single_Actions");
    }
    
    /**
     * Overridden to get the icon for the projects project node.
     * @param expanded Whether or not the node is expanded.
     * @return The node icon.
     */
    @Override
    public ImageIcon getIcon(boolean expanded) {
        return Icons.SingleActions;
    }
    
}
