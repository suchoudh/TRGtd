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

package tr.datastore.xstream;

import java.io.File;
import org.openide.modules.ModuleInstall;

/**
 * Module installer
 *
 * @author Jeremy Moore (jeremyimoore@yahoo.com.au)
 */
public class Installer extends ModuleInstall {
    
    /**
     * Sets the datafile path to open if there is a value for the tr.datafile
     * property and the value is an existing file.
     */
    @Override
    public void restored() {
        String path = System.getProperty("tr.datafile");
        if (path == null) return;
        
        File file = new File(path);
        if (file.isFile()) {
            XStreamDataStore.instance().setPath(path);
        }
    }
    
}
