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

package tr.swing.date.combo;

import java.io.Serializable;

/**
 * Date type enum.
 *
 * @author Jeremy Moore (jimoore@netspace.net.au)
 */
public enum DateType implements Serializable {
    
    NONE(0), DAYS(1), MS(2), CHOOSER(3);
    
    public final int id;
    
    private DateType(int id) {
        this.id = id;
    }
    
    public static DateType getDateType(int id) {
        if (id == DAYS.id) return DAYS;
        if (id == MS.id) return MS;
        return NONE;
    }
    
    public String toString() {
        if (id == DAYS.id) return "DAYS";
        if (id == MS.id) return "MS";
        return "NONE";
    }
    
}
