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

import java.io.File;
import javax.swing.ImageIcon;
import org.openide.modules.InstalledFileLocator;

/**
 * Resource handling static methods.
 *
 * @author Jeremy Moore (jimoore@netspace.net.au)
 */
public class ResourceUtils {
    
    /* Private constructor. */
    private ResourceUtils() {
    }
    
    /**
     * Loads and returns an IconImage for the path of an installed icon file.
     * @param path The icon path (e.g. "resource/images/MyIcon16.gif").
     */
    public static ImageIcon loadInstalledIcon(String path) {
        File file = InstalledFileLocator.getDefault().locate(path, null, false);
        if (file != null && file.isFile()) {
            try {
                return new ImageIcon(file.toURL());
            } catch (Exception ex) {
                System.err.println("Could not load image for path: " + path);
                ex.printStackTrace(System.err);
            }
        }
        return new ImageIcon(); // return a default one.
    }
    
}
