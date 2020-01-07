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

package tr.view.projects;

import java.io.File;
import org.openide.modules.InstalledFileLocator;
import org.openide.util.NbBundle;

/**
 * Resources.
 *
 * @author Jeremy Moore (jimoore@netspace.net.au)
 */
public class Resources {
    /**
     * Gets the text for the given key from the resource Bundle.properties file.
     * @param key The key value.
     * @return the text value if the key exists, otherwise the key.
     */
    public static String getText(String key) {
        try {
            return NbBundle.getMessage(Resources.class, key);
        } catch (Exception ex) {
            return key;
        }
    }
    
//    public static final ImageIcon ICON_PROJECT = tr.model.Resources.ICON_PROJECT;
    
//    public static final ImageIcon ICON_SINGLE_ACTIONS = tr.view.Resources.ICON_SINGLE_ACTIONS;
    
//    public static final ImageIcon ICON_ACTION = tr.model.Resources.ICON_DOASAP;
    
//    public static final ImageIcon ICON_G_ADD_SGB = tr.view.Resources.ICON_G_ADD_SGB;
    
//    public static final ImageIcon ICON_G_ADD_ACTION =
//            new ImageIcon(Utilities.mergeImages(ICON_ACTION.getImage(), ICON_G_ADD_SGB.getImage(), 7, 7));
    
//    public static final ImageIcon ICON_G_ADD_PROJECT =
//            new ImageIcon(Utilities.mergeImages(ICON_PROJECT.getImage(), ICON_G_ADD_SGB.getImage(), 7, 7));
    
//    public static final ImageIcon ICON_G_PROJECTISE =
//            new ImageIcon(Utilities.mergeImages(ICON_PROJECT.getImage(), tr.view.Resources.ICON_G_CONVERT.getImage(), 7, 7));
    
//    public static final ImageIcon ICON_G_TOGGLE_SHOW_DONE =
//            new ImageIcon(Utilities.mergeImages(tr.view.Resources.ICON_TICKBOX.getImage(), tr.view.Resources.ICON_G_VIEW.getImage(), 7, 7));
    
    public static final File FILE_RPT_ACTION = getInstalledFile("resource/reports/Action.jasper");
    public static final File FILE_RPT_PROJECT = getInstalledFile("resource/reports/Project.jasper");

    private static final File getInstalledFile(String path) {
        File file = InstalledFileLocator.getDefault().locate(path, null, false);
        if (file != null && file.isFile()) {
            return file;
        }
        return null;
    }
    
}
