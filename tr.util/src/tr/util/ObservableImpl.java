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

package tr.util;

import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/**
 * Observable implementation that tries to avoid concurrent update exceptions
 * and memory leaks.
 * This class is part of an improved Observer design pattern implementation to
 * that of the java.util package.
 * See the Observer design pattern in "Design Patterns: Elements of
 * Object-Oriented Architecture", Addison-Wesley, Reading, MA, 1995.
 * Gamma, E., Johnson, R. and Vlissides, J.
 *
 * @author Jeremy Moore (jimoore@netspace.net.au)
 */
public abstract class ObservableImpl implements Observable, Serializable {
    
    private static final long serialVersionUID = 2383745834L;
    
    private transient List<WeakReference<Observer>> observers;
    
    /** Constructs a default instance. */
    public ObservableImpl() {
    }
    
    private List<WeakReference<Observer>> getObservers() {
        synchronized(this) {
            if (observers == null) {
                observers = new Vector<WeakReference<Observer>>();
            }
        }
        return observers;
    }
    
    /**
     * Adds an observer to the set of observers for this object, provided that
     * it is not the same as some observer already in the set. The order in
     * which notifications will be delivered to multiple observers is not
     * specified.
     * @param observer The observer to add.
     */
    public void addObserver(Observer observer) {
        if (observer == null) return;
        
        synchronized(this) {
            // make sure observer is not already registered
            for (Iterator<WeakReference<Observer>> i = getObservers().iterator(); i.hasNext(); ) {
                Observer entry = i.next().get();
                if (entry == null) {
                    i.remove();
                } else if (entry == observer) {
                    return;
                }
            }            
            // add new weak reference for observer
            getObservers().add(new WeakReference<Observer>(observer));
        }
    }
    
    /**
     * Removes an observer from the set of observers of this object.
     * @param observer The observer to remove.
     */
    public void removeObserver(Observer observer) {
        if (observer == null) return;
        
        synchronized(this) {
            for (Iterator<WeakReference<Observer>> i = getObservers().iterator(); i.hasNext(); ) {
                Observer entry = i.next().get();
                if (entry == null || entry == observer) {
                    i.remove();
                    break;
                }
            }
        }
    }
    
    /**
     * Removes all observers from the list.
     */
    public void removeObservers() {
        synchronized(this) {
            getObservers().clear();
        }
    }
    
    /**
     * Override to reset all child observers.
     */
    public void resetObservers() {
    }
    
    /**
     * Notify all observers. Each observer has its update method called with two
     * arguments: the observable and null.
     * @param observable The observable.
     */
    public void notifyObservers(Observable observable) {
        notifyObservers(observable, null);
    }
    
    /**
     * Notify all observers. Each observer has its update method called with two
     * arguments: the observable and the object.
     * @param observable The observable.
     * @param object The object or null.
     */
    public void notifyObservers(Observable observable, Object object) {
        synchronized(this) {
            for (Iterator<WeakReference<Observer>> i = getObservers().iterator(); i.hasNext(); ) {
                Observer observer = i.next().get();
                if (observer == null) {
                    i.remove();
                } else {
                    new Notifier(observer, observable, object).start();
                }
            }
        }
    }
    
    private static class Notifier extends Thread {
        private final Observer observer;
        private final Observable observable;
        private final Object object;
        public Notifier(Observer observer, Observable observable, Object object) {
            this.observer = observer;
            this.observable = observable;
            this.object = object;
        }
        public void run() {
            observer.update(observable, object);
        }
    }    
}
