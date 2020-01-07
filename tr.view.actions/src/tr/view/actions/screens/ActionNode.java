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
package tr.view.actions.screens;

import java.util.Calendar;
import java.util.Date;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;
import org.openide.util.actions.SystemAction;
import org.openide.util.lookup.Lookups;
import tr.model.Data;
import tr.model.DataLookup;
import tr.model.action.Action;
import tr.model.action.ActionStateDelegated;
import tr.model.action.ActionStateScheduled;
import tr.model.context.Context;
import tr.model.context.ContextChangeCookie;
import tr.model.thought.Thought;
import tr.model.topic.Topic;
import tr.model.topic.TopicChangeCookie;
import tr.view.DeleteAction;
import tr.view.DeleteCookie;
import tr.view.ReprocessAction;
import tr.view.ReprocessCookie;
import tr.view.WindowUtils;
import tr.view.contexts.ContextChangeAction;
import tr.view.process.ProcessThoughtsAction;
import tr.view.projects.PostponeActionAction;
import tr.view.projects.PostponeActionAction.Periods;
import tr.view.projects.PostponeActionCookie;
import tr.view.topics.TopicChangeAction;

/**
 * Node for a TR action.
 *
 * @author Jeremy Moore (jimoore@netspace.net.au)
 */
public class ActionNode extends AbstractNode 
        implements TopicChangeCookie, ContextChangeCookie, DeleteCookie,
                    SetDoneCookie, ReprocessCookie, PostponeActionCookie {

    public final Action action;

    /** Constructs a new instance. */
    public ActionNode(Action action) {
        super(Children.LEAF, Lookups.singleton(action));
        this.action = action;
    }

    @Override
    public String toString() {
        return action.getDescription();
    }
    
    @Override
    public javax.swing.Action[] getActions(boolean popup) {
        return new javax.swing.Action[] {
            SystemAction.get(ReprocessAction.class),
            SystemAction.get(PostponeActionAction.class),
            SystemAction.get(ContextChangeAction.class),
            SystemAction.get(TopicChangeAction.class),
            SystemAction.get(SetDoneAction.class),
            SystemAction.get(DeleteAction.class),
        };
    }

    @Override
    public Cookie getCookie(Class clazz) {
        if (clazz == DeleteCookie.class) {
            return this;
        }
        if (clazz == TopicChangeCookie.class) {
            return this;
        }
        if (clazz == ContextChangeCookie.class) {
            return this;
        }
        if (clazz == SetDoneCookie.class) {
            return this;
        }
        if (clazz == ReprocessCookie.class) {
            return this;
        }
        if (clazz == PostponeActionCookie.class) {
            return this;
        }
        return super.getCookie(clazz);
    }

    public Action getAction() {
        return action;
    }
    
    public void delete() {
        action.getParent().remove(action);
    }

    public void setDone(boolean done) {
        action.setDone(done);
    }

    public void reprocess(boolean now) {
        if (action == null) {
            return;
        }
        Data data = (Data) DataLookup.instance().lookup(Data.class);
        if (data == null) {
            return;
        }

        ProcessThoughtsAction processThoughtsAction = null;        
        if (now) {
            processThoughtsAction = (ProcessThoughtsAction)SystemAction.get(ProcessThoughtsAction.class);
            if (processThoughtsAction != null) {
                WindowUtils.closeWindows();
            }            
        }

        // delete the action
//        removeListeners();
        action.removeFromParent();
//        fireNodeDestroyed(); // added 08/04/08

        // add the new thought to the front of the thoughts
        Thought thought = new Thought(data.getNextID());
        thought.setDescription(action.getDescription());
        thought.setTopic(action.getTopic());
        thought.setAction(action);
        data.getThoughtManager().insert(thought, 0);

//        try {
//            // hack to fix hanging - probably due to a windowing issue.
//            Thread.sleep(400);
//        } catch (InterruptedException ex) {
//        }

        if (now && processThoughtsAction != null) {
            // got to process thoughts screen
            processThoughtsAction.performAction();
        }
    }

    public void setTopic(Topic topic) {
        action.setTopic(topic);
    }

    public void setContext(Context context) {
        action.setContext(context);
    }

    private Date add(Date date, int n, Periods periods) {
        Calendar calendar = Calendar.getInstance();
        if (date != null) {
            calendar.setTime(date);            
        }        
        switch (periods) {
            case DAYS: {
                calendar.add(Calendar.DAY_OF_YEAR, n);
                break;
            }
            case WEEKS: {
                calendar.add(Calendar.WEEK_OF_YEAR, n);
                break;
            }
            case MONTHS: {
                calendar.add(Calendar.MONTH, n);
                break;
            }
            case YEARS: {
                calendar.add(Calendar.YEAR, n);
                break;
            }
        }
        return calendar.getTime();                                        
    }
    
    public void postponeAction(int n, Periods periods) {
        switch (action.getState().getType()) {
            case DOASAP: {
                action.setDueDate(add(action.getDueDate(), n, periods));
                break;
            }
            case INACTIVE: {
                action.setStartDate(add(action.getStartDate(), n, periods));
                break;
            }
            case SCHEDULED: {
                ActionStateScheduled state = (ActionStateScheduled)action.getState(); 
                state.setDate(add(state.getDate(), n, periods));
                break;
            }
            case DELEGATED: {
                ActionStateDelegated state = (ActionStateDelegated)action.getState(); 
                state.setDate(add(state.getDate(), n, periods));                
                break;
            }
        }        
    }

}