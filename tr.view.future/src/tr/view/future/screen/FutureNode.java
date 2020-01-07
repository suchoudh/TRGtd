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

package tr.view.future.screen;

import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;
import org.openide.nodes.Node.Cookie;
import org.openide.util.actions.SystemAction;
import org.openide.util.lookup.Lookups;
import tr.model.Data;
import tr.model.DataLookup;
import tr.model.future.Future;
import tr.model.thought.Thought;
import tr.view.future.FutureDeleteCookie;
import tr.view.future.FutureEditCookie;
import tr.view.future.FutureReprocessCookie;
import tr.view.process.ProcessThoughtsAction;

/**
 * Node for a future item.
 *
 * @author <a href="mailto:jimoore@netspace.net.au">Jeremy Moore</a>
 */
public class FutureNode extends AbstractNode
        implements FutureEditCookie, FutureDeleteCookie, FutureReprocessCookie {
    
    public final Future future;
    
    /** Constructs a new instance. */
    public FutureNode(Future future) {
        super(Children.LEAF, Lookups.singleton(future));
        this.future = future;
    }
    
    @Override
    public String getName() {
        return (future == null) ? "" : future.getDescription();
    }
    
    @Override
    public Cookie getCookie(Class clazz) {
        if (clazz == FutureEditCookie.class) return this;
        if (clazz == FutureDeleteCookie.class) return this;
        if (clazz == FutureReprocessCookie.class) return this;
        return super.getCookie(clazz);
    }
    
    public void editFuture() {
        if (future == null) return;
        
        Data data = (Data)DataLookup.instance().lookup(Data.class);
        if (data == null) return;
        
        FutureTopComponent rtc = FutureTopComponent.findInstance();
        if (rtc == null) return;
        
        rtc.edit();
    }
    
    public void deleteFuture() {
        if (future == null) return;
        
        Data data = (Data)DataLookup.instance().lookup(Data.class);
        if (data == null) return;
        
        data.getFutureManager().remove(future);
    }
    
    public void reprocessFuture() {
        if (future == null) return;
        
        Data data = (Data)DataLookup.instance().lookup(Data.class);
        if (data == null) return;
        
        data.getFutureManager().remove(future);
        
        // add the new thought to the front of the thoughts
        Thought thought = new Thought(data.getNextID());
        thought.setDescription(future.getDescription());
        thought.setTopic(future.getTopic());
        thought.setNotes(future.getNotes());
        data.getThoughtManager().insert(thought, 0);
        
        try {
            // fix hanging - probably due to a windowing issue.
            Thread.sleep(400);
        } catch (InterruptedException ex) {
        }

        // got to process thoughts screen
        ProcessThoughtsAction pta = (ProcessThoughtsAction)SystemAction.get(ProcessThoughtsAction.class);
        pta.performAction();
    }
    
    
    
    
    
    
    
    
}