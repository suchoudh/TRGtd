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

package tr.runtime;

import java.io.File;
import java.net.URL;

/**
 * Runtime commands for opening a file.
 *
 * @author Jeremy Moore (jimoore@netspace.net.au)
 */
public class Open {
    
    /**
     * Try to open a file using the runtime exec facility.
     * @param file the file to open.
     */
    public static final void openFile(File file) {
        if (file == null) return;
        
        // TODO: test that the file is a file and is readable.
        
        String filename = getFilePath(file);
        
        if (Runtime.macosx) {
            Runtime.exec(new String[] {"open", filename});
        } else if (Runtime.linux || Runtime.unix) {
            Runtime.exec(new String[] {"xdg-open", filename});
        } else if (Runtime.win95 || Runtime.win98) {
            Runtime.exec(new String[] {"command.com", "/C", "start", filename});
        } else if (Runtime.windows) {
            Runtime.exec(new String[] {"cmd.exe", "/C", "start", filename});
        } else {
            Runtime.exec(new String[] {"open", filename});
        }
    }
    
    /* Gets the file path for opening on the various platforms.  */
    private static String getFilePath(File file) {
        if (file == null) return null;
        
        String path = file.getPath();
        
        if (Runtime.windows || Runtime.linux) {
            path = "file:///" + path.replace("\u0020", "%20");
        }
        
        return path;
    }
    
    /**
     * Try to open a text file using the runtime exec facility.
     * @param file the file to open.
     */
    public static final void openTextFile(File file) {
        if (file == null) return;
        
        // TODO: test that the file is a file and is readable.
        
        String filename = getFilePath(file);
        
        if (Runtime.macosx) {
            Runtime.exec(new String[] {"open", "-t", filename});
        } else if (Runtime.linux || Runtime.unix) {
            Runtime.exec(new String[] {"xdg-open", filename});
        } else if (Runtime.win95 || Runtime.win98) {
            Runtime.exec(new String[] {"command.com", "/C", "start", filename});
        } else if (Runtime.windows) {
            Runtime.exec(new String[] {"cmd.exe", "/C", "start", filename});
        } else {
            Runtime.exec(new String[] {"open", filename});
        }
    }
    
    /**
     * Try to open a url in the default browser using the runtime exec facility.
     * @param url the URL to open.
     */
    public static final void open(URL url) {
        if (url == null) return;
        
        String urlString = url.toExternalForm().replace("\u0020", "%20");
        
        if (Runtime.windows) {
            urlString = urlString.replace("\u0026", "^&");
        }
        
        if (Runtime.macosx) {
            Runtime.exec(new String[] {"open", urlString});
        } else if (Runtime.linux || Runtime.unix) {
            Runtime.exec(new String[] {"xdg-open", urlString});
        } else if (Runtime.win95 || Runtime.win98) {
            Runtime.exec(new String[] {"command.com", "/c", "start", urlString});
        } else if (Runtime.windows) {
            Runtime.exec(new String[] {"cmd.exe", "/c", "start", urlString});
        } else {
            Runtime.exec(new String[] {"open", urlString});
        }
    }
    
}
