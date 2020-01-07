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
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import tr.swing.date.combo.DateItem;

/**
 * Persistence that uses an object output stream and file output stream.
 *
 * @author <a href="mailto:jimoore@netspace.net.au">Jeremy Moore</a>
 */
public class PersistenceOutputStream {
    
    private final ObjectOutputStream out;
    
    public PersistenceOutputStream(File file) throws IOException {
        out = new ObjectOutputStream(new FileOutputStream(file));
    }
    
    public void writeString(String s) throws IOException {
        if (s == null) {
            out.writeByte(0);
        } else {
            out.writeInt(s.length());
            out.writeBytes(s);
        }
    }
    
    public void writeStrings(String[] ss) throws IOException {
        if (ss == null) {
            out.writeInt(-1);
        } else {
            out.writeInt(ss.length);
            for (String s : ss)
                writeString(s);
        }
    }
    
    public void writeBoolean(boolean b) throws IOException {
        out.writeBoolean(b);
    }
    
    public void writeInt(int i) throws IOException {
        out.writeInt(i);
    }
    
    public void writeLong(long l) throws IOException {
        out.writeLong(l);
    }
    
    public void writeByte(byte b) throws IOException {
        out.writeByte(b);
    }
    
    public void writeBytes(byte[] bs) throws IOException {
        if (bs == null) {
            out.writeInt(-1);
        } else {
            out.writeInt(bs.length);
            out.write(bs);
        }
    }
    
    public void writeDateItem(DateItem item) throws Exception {
        if (item == null) {
            writeInt(-1);
        } else {
            writeInt(item.type.id);
            writeString(item.label);
            writeLong(item.value);
        }
    }
    
    public void flush() throws IOException {
        out.flush();
    }
    
    public void close() throws IOException {
        out.close();
    }
    
}
