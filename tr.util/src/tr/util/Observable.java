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

/**
 * Observable interface.
 * This interface is part of an improved Observer design pattern implementation
 * to that of the java.util package.
 * See the Observer design pattern in "Design Patterns: Elements of
 * Object-Oriented Architecture", Addison-Wesley, Reading, MA, 1995.
 * Gamma, E., Johnson, R. and Vlissides, J.
 */
public interface Observable {
    /**
     * Adds an observer.
     * @param observer The observer to add.
     */
    public void addObserver(Observer observer);
    
    /**
     * Removes a observer.
     * @param observer The observer to remove.
     */
    public void removeObserver(Observer observer);
    
    /**
     * Removes all observers.
     */
    public void removeObservers();
    
    /**
     * Reset all child observers.
     */
    public void resetObservers();
    
}
