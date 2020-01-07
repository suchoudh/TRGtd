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
import tr.model.Item.AbstractItem;
import tr.model.Item.Item;
import tr.model.Item.ItemList;
import tr.model.topic.Topic;
import tr.util.Utils;

/**
 * This class represents a brainstorming idea.
 *
 * @author Jeremy Moore (jimoore@netspace.net.au)
 */
public class BrainstormItem extends AbstractItem {
    
    protected Topic topic;
    protected String notes;
    
    /**
     * Creates a new instance.
     */
    public BrainstormItem(IDGenerator idGenerator) {
        super(idGenerator);
    }
    
    
    public String getNotes() {
        return notes;
    }
    
    public void setNotes(String notes) {
        if (Utils.equal(this.notes, notes)) return;
        
        this.notes = notes;
        
        notifyObservers(this);
    }
    
    public Topic getTopic() {
        if (topic == null) {
            return Topic.getDefault();
        }
        if (topic.getName().equals(Topic.getDefault().getName())) {
            return Topic.getDefault();
        }
        return topic;
    }
    
    public void setTopic(Topic topic) {
        if (Utils.equal(this.topic, topic)) return;
        
        if (this.topic != null) {
            this.topic.removeObserver(this);
        }
        
        this.topic = topic;
        
        if (this.topic != null) {
            this.topic.addObserver(this);
        }
        
        notifyObservers(this);
    }
    
    public boolean equals(Object object) {
        if (!(object instanceof BrainstormItem)) return false;
        
        BrainstormItem bs = (BrainstormItem)object;
        
        if (!Utils.equal(topic, bs.topic)) return false;
        if (!Utils.equal(notes, bs.notes)) return false;
        
        return super.equals(object);
    }
    
    /**
     * Gets the icon representing the action item.
     * @param expanded is not applicable and is ignored.
     * @return The icon.
     */
    public ImageIcon getIcon(boolean expanded) {
        // TODO
        // return Resources.ICON_BRAINSTORM_ITEM;
        return null;
    }
    
    /* Observable implementation */
    /**
     * Resets observing of state, topic and context.
     */
    public void resetObservers() {
        if (topic != null) {
            topic.addObserver(this);
        }
        super.resetObservers();
    }
    
    /**
     * Makes a copy of the action item. The copy has a new ID and creation date.
     * @param idGeneratorid The id generator.
     * @return the copy.
     */
    public Item copy(IDGenerator idGenerator) {
        BrainstormItem copy = new BrainstormItem(idGenerator);
        copy.parent = this.parent;
        copy.description = this.description;
        copy.topic = this.topic;
        copy.notes = this.notes;
        return copy;
    }
    
    /**
     * Removes this action item from its parent item list.
     */
    public void removeFromParent() {
        if (parent != null) {
            parent.remove(this);
        }
    }
    
    /**
     * Determines whether this item is directly or indirectly within a given
     * list.
     * @param list The given list.
     */
    public boolean isWithin(ItemList list) {
        if (list == null || parent == null) {
            return false;
        }
        if (list == parent) {
            return true;
        }
        return parent.isWithin(list);
    }
    /* End of Item implementation */
    
    
    
    public int compareTo(Item item) {
        if (item instanceof BrainstormItem) {
            return getDescription().compareToIgnoreCase(((BrainstormItem)item).getDescription());
        }
        throw new ClassCastException(item.getClass().toString());
    }
    
}
