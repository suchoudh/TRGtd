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

import javax.swing.ImageIcon;
import tr.model.IDGenerator;
import tr.model.Item.Item;

/**
 * This class represents a list of brainstorming items.
 *
 * @author Jeremy Moore (jimoore@netspace.net.au)
 */
public class BrainstormItemList extends BrainstormItem {
    
    /** 
     * Constructs a new instance.
     */
    public BrainstormItemList(IDGenerator idGenerator) {
        super(idGenerator);
    }
        
    @Override
    public ImageIcon getIcon(boolean opened) {
       // TODO Get icon for BrainstormItemList.
       return null;        
    }

    @Override
    public Item copy(IDGenerator idGenerator) {
        BrainstormItemList copy = new BrainstormItemList(idGenerator);
        copy.parent = this.parent;
        copy.description = this.description;
        copy.topic = this.topic; 
        copy.notes = this.notes;
        return copy;
    }

    public boolean canAdd(Item item) {
        return item instanceof BrainstormItem;
    }
    
}
