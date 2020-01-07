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

import tr.swing.date.combo.DateItem;
import tr.swing.date.combo.DateType;

/**
 *
 * @author Jeremy Moore (jimoore@netspace.net.au)
 */
public class PersistenceDateItem {
    
    private final DateItem item;
    
    /** Constructs a new instance. */
    public PersistenceDateItem(DateItem item) {
        this.item = item;
    }
    
    public void persist(PersistenceOutputStream out) throws Exception {
        out.writeInt(item.type.id);
        out.writeString(item.label);
        out.writeLong(item.value);
    }
    
    public DateItem restore(PersistenceInputStream in) throws Exception {
        int id = in.readInt();
        String label = in.readString();
        long value = in.readLong();
        return new DateItem(DateType.getDateType(id), label, value);
    }
    
}
