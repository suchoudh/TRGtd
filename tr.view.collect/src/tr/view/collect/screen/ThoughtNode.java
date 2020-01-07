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
package tr.view.collect.screen;

import java.util.logging.Logger;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;
import org.openide.nodes.Node.Cookie;
import org.openide.util.lookup.Lookups;
import tr.model.Data;
import tr.model.DataLookup;
import tr.model.thought.Thought;
import tr.model.util.Manager;
import tr.view.collect.DeleteThoughtCookie;
import tr.view.collect.EditThoughtCookie;
import tr.view.collect.dialog.ThoughtDialog;

/**
 * Node for a thought.
 *
 * @author Jeremy Moore (jimoore@netspace.net.au)
 */
public class ThoughtNode extends AbstractNode implements EditThoughtCookie, DeleteThoughtCookie {
    
    private static final Logger LOG = Logger.getLogger("tr.view.collect");
    
    public final Manager<Thought> manager;
    public final Thought thought;
    
    /** Constructs a new instance. */
    public ThoughtNode(Manager<Thought>manager, Thought thought) {
        super(Children.LEAF, Lookups.singleton(thought));
        this.manager = manager;
        this.thought = thought;
    }
    
    @Override
    public String getName() {
        return thought.getDescription();
    }
    
    @Override
    public Cookie getCookie(Class clazz) {
        if (clazz == EditThoughtCookie.class) return this;
        if (clazz == DeleteThoughtCookie.class) return this;                        
        return super.getCookie(clazz);
    }

    public void editThought() {
        Data data = (Data)DataLookup.instance().lookup(Data.class);
        if (data != null) {
            new ThoughtDialog(data).showModifyDialog(thought);            
        }
    }
    
    public void deleteThought() {
        manager.remove(thought);        
    }
    
}