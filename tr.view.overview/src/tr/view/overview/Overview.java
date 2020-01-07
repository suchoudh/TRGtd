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

package tr.view.overview;

import java.awt.Cursor;
import javax.swing.Action;
import org.apache.batik.swing.JSVGCanvas;
import org.apache.batik.swing.svg.SVGLoadEventDispatcherAdapter;
import org.apache.batik.swing.svg.SVGLoadEventDispatcherEvent;
import org.openide.util.actions.SystemAction;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.events.Event;
import org.w3c.dom.events.EventListener;
import org.w3c.dom.events.EventTarget;
import tr.data.NewAction;
import tr.model.Data;
import tr.model.DataLookup;
import tr.view.collect.CollectThoughtsAction;
import tr.util.ObservableImpl;
import tr.view.actions.RAAction;
import tr.view.contexts.ContextsAction;
import tr.view.criteria.CriteriaAction;
import tr.view.future.FuturesAction;
import tr.view.process.ProcessThoughtsAction;
import tr.view.projects.ProjectsAction;
import tr.view.reference.ReferencesAction;
import tr.view.topics.TopicsAction;

/**
 * Overview screen which notifies listeners when the user makes a selection.
 *
 * @author jeremyimoore@yahoo.com.au
 */
public class Overview extends ObservableImpl {
    
    private static final Cursor HAND_CURSOR = new Cursor(Cursor.HAND_CURSOR);
    private static final Cursor NORMAL_CURSOR = new Cursor(Cursor.DEFAULT_CURSOR);
    
    private final JSVGCanvas canvas;
    
    /** Screen selection enum type. */
    public static enum Screen {
        NEW("new", (Action)SystemAction.get(NewAction.class)),
        CONTEXTS("contexts", (Action)SystemAction.get(ContextsAction.class)),
        TOPICS("topics", (Action)SystemAction.get(TopicsAction.class)),
        CRITERIA("criteria", (Action)SystemAction.get(CriteriaAction.class)),
        COLLECT("collect", (Action)SystemAction.get(CollectThoughtsAction.class)),
        PROCESS("process", (Action)SystemAction.get(ProcessThoughtsAction.class)),
        INFORMATION("info", (Action)SystemAction.get(ReferencesAction.class)),
        FUTURE("future", (Action)SystemAction.get(FuturesAction.class)),
        ACTIONS("actions", (Action)SystemAction.get(RAAction.class)),
        PROJECTS("projects", (Action)SystemAction.get(ProjectsAction.class)),
        DOASAP("doasap", (Action)SystemAction.get(RAAction.class)),
        DELEGATED("delegated", (Action)SystemAction.get(RAAction.class)),
        SCHEDULED("scheduled", (Action)SystemAction.get(RAAction.class)),
        DONE("done", (Action)SystemAction.get(RAAction.class));
        final String id;
        final Action action;
        Screen(String id, Action action) {
            this.id = id;
            this.action = action;
        }
    }
    
    /** Constructs a new instance. */
    public Overview() {
        canvas = new JSVGCanvas();
        canvas.setDocumentState(JSVGCanvas.ALWAYS_DYNAMIC);
        canvas.addSVGLoadEventDispatcherListener(new SVGLoadEventDispatcherAdapter() {
            @Override
            public void svgLoadEventDispatchStarted(SVGLoadEventDispatcherEvent e) {
                registerListeners(canvas.getSVGDocument());
            }
        });
    }
    
    /* SVG element id and corresponding screen array. */
    private static final Object[][] screenIDs = new Object[][] {
        {Screen.NEW.id, Screen.NEW},
        {Screen.NEW.id + "-text", Screen.NEW},
        {Screen.NEW.id + "-icon", Screen.NEW},
        {Screen.CONTEXTS.id, Screen.CONTEXTS},
        {Screen.CONTEXTS.id + "-text", Screen.CONTEXTS},
        {Screen.CONTEXTS.id + "-icon", Screen.CONTEXTS},
        {Screen.TOPICS.id, Screen.TOPICS},
        {Screen.TOPICS.id + "-text", Screen.TOPICS},
        {Screen.TOPICS.id + "-icon", Screen.TOPICS},
        {Screen.CRITERIA.id, Screen.CRITERIA},
        {Screen.CRITERIA.id + "-text", Screen.CRITERIA},
        {Screen.CRITERIA.id + "-icon", Screen.CRITERIA},
        {Screen.COLLECT.id, Screen.COLLECT},
        {Screen.COLLECT.id + "-text", Screen.COLLECT},
        {Screen.COLLECT.id + "-icon", Screen.COLLECT},
        {Screen.INFORMATION.id, Screen.INFORMATION},
        {Screen.INFORMATION.id + "-text", Screen.INFORMATION},
        {Screen.INFORMATION.id + "-icon", Screen.INFORMATION},
        {Screen.PROCESS.id, Screen.PROCESS},
        {Screen.PROCESS.id + "-text", Screen.PROCESS},
        {Screen.PROCESS.id + "-icon", Screen.PROCESS},
        {Screen.FUTURE.id, Screen.FUTURE},
        {Screen.FUTURE.id + "-text", Screen.FUTURE},
        {Screen.FUTURE.id + "-icon", Screen.FUTURE},
        {Screen.ACTIONS.id, Screen.ACTIONS},
        {Screen.ACTIONS.id + "-text", Screen.ACTIONS},
        {Screen.ACTIONS.id + "-icon", Screen.ACTIONS},
        {Screen.PROJECTS.id, Screen.PROJECTS},
        {Screen.PROJECTS.id + "-text", Screen.PROJECTS},
        {Screen.PROJECTS.id + "-icon", Screen.PROJECTS},
        {Screen.DOASAP.id, Screen.DOASAP},
        {Screen.DOASAP.id + "-text", Screen.DOASAP},
        {Screen.DOASAP.id + "-icon", Screen.DOASAP},
        {Screen.DELEGATED.id, Screen.DELEGATED},
        {Screen.DELEGATED.id + "-text", Screen.DELEGATED},
        {Screen.DELEGATED.id + "-icon", Screen.DELEGATED},
        {Screen.SCHEDULED.id, Screen.SCHEDULED},
        {Screen.SCHEDULED.id + "-text", Screen.SCHEDULED},
        {Screen.SCHEDULED.id + "-icon", Screen.SCHEDULED},
        {Screen.DONE.id, Screen.DONE},
        {Screen.DONE.id + "-text", Screen.DONE},
        {Screen.DONE.id + "-icon", Screen.DONE},
    };
    
    /* Register click listeners for SVG elements using id and screen array. */
    private void registerListeners(Document document) {
        for (int i = 0; i < screenIDs.length; i++) {
            String id = (String)screenIDs[i][0];
            Screen s = (Screen)screenIDs[i][1];
            Element e = document.getElementById(id);
            if (e instanceof EventTarget) {
                EventTarget et = (EventTarget)e;
                et.addEventListener("click", new OnClickAction(s), false);
                et.addEventListener("mouseover", new OnMouseOverAction(s), false);
                et.addEventListener("mousemove", new OnMouseMoveAction(s), false);
                et.addEventListener("mouseout", new OnMouseOutAction(), false);
            }
        }
    }
    
    /* Listener for clicks. */
    private class OnClickAction implements EventListener {
        private final Screen screen;
        public OnClickAction(Screen screen) {
            super();
            this.screen = screen;
        }
        public void handleEvent(Event evt) {
            Data data = (Data)DataLookup.instance().lookup(Data.class);
            if (screen == Screen.NEW || data != null) {
                notifyObservers(Overview.this, screen);
            }
        }
    }
    
    /* Listener for mouse over events. */
    private class OnMouseOverAction implements EventListener {
        private final Screen screen;
        public OnMouseOverAction(Screen screen) {
            super();
            this.screen = screen;
        }
        public void handleEvent(Event evt) {
            Data data = (Data)DataLookup.instance().lookup(Data.class);
            if (screen == Screen.NEW || data != null) {
                canvas.setCursor(HAND_CURSOR);
            }
        }
    }
    
    /* Listener for mouse move (while over) events. */
    private class OnMouseMoveAction implements EventListener {
        private final Screen screen;
        public OnMouseMoveAction(Screen screen) {
            super();
            this.screen = screen;
        }
        public void handleEvent(Event evt) {
            Data data = (Data)DataLookup.instance().lookup(Data.class);
            if (screen == Screen.NEW || data != null) {
                canvas.setCursor(HAND_CURSOR);
            }
        }
    }
    
    /* Listener for mouse out events. */
    private class OnMouseOutAction implements EventListener {
        public void handleEvent(Event evt) {
            canvas.setCursor(NORMAL_CURSOR);
        }
    }
    
    /**
     * Gets the SVG canvas component.
     * @return the canvas.
     */
    public JSVGCanvas getSVGCanvas() {
        return canvas;
    }
    
}