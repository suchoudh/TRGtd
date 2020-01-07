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

package tr.view.process;

import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;
import org.openide.nodes.Node.Cookie;
import org.openide.util.lookup.Lookups;

/**
 * Node for processing.
 *
 * @author Jeremy Moore (jimoore@netspace.net.au)
 */
public class ProcessNode extends AbstractNode {
    
    public final ProcessCookie processCookie;
    
    /** Constructs a new instance. */
    public ProcessNode(ProcessCookie processCookie) {
        super(Children.LEAF, Lookups.singleton(processCookie));
        this.processCookie = processCookie;
    }
    
    public Cookie getCookie(Class clazz) {
        if (clazz == ProcessCookie.class) {
            return processCookie;
        }
        return super.getCookie(clazz);
    }
    
}