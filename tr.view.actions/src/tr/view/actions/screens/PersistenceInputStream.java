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

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import tr.swing.date.combo.DateItem;
import tr.swing.date.combo.DateType;

/**
 * Persistence input that uses an object input stream and file input stream.
 *
 * @author <a href="mailto:jimoore@netspace.net.au">Jeremy Moore</a>
 */
public class PersistenceInputStream {
    
    private final ObjectInputStream in;
    
    public PersistenceInputStream(File file) throws IOException {
        in = new ObjectInputStream(new FileInputStream(file));
    }
    
    public String readString() throws IOException {
        byte[] bytes = readBytes();
        return bytes == null ? null : new String(bytes);
    }
    
    public String[] readStrings() throws IOException {
        int length = in.readInt();
        if (length < 0) {
            return null;
        }
        String[] ss = new String[length];
        for (int i = 0; i < length; i++) {
            ss[i] = readString();
        }
        return ss;
    }
    
    public boolean readBoolean() throws IOException {
        return in.readBoolean();
    }
    
    public int readInt() throws IOException {
        return in.readInt();
    }
    
    public long readLong() throws IOException {
        return in.readLong();
    }
    
    public byte readByte() throws IOException {
        return in.readByte();
    }
    
    public byte[] readBytes() throws IOException {
        int length = in.readInt();
        if (length < 0) {
            return null;
        }
        byte[] bytes = new byte[length];
        for (int i = 0; i < length; i++) {
            bytes[i] = in.readByte();
        }
        return bytes;
    }
    
    public DateItem readDateItem() throws Exception {
        int id = in.readInt();
        if (id == -1) {
            return null;
        }
        String label = readString();
        long value = readLong();
        return new DateItem(DateType.getDateType(id), label, value);
    }
    
    public void close() throws IOException {
        in.close();
    }
    
}
