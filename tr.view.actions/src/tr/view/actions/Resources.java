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

package tr.view.actions;

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
    
//  public static final ImageIcon ICON_PROJECTS = tr.model.Resources.ICON_PROJECTS;
//    public static final ImageIcon ICON_PROJECT = tr.model.Resources.ICON_PROJECT;
//  public static final ImageIcon ICON_PROJECT_OPENED = tr.model.Resources.ICON_PROJECT_OPENED;
//  public static final ImageIcon ICON_SINGLE_ACTIONS = tr.view.Resources.ICON_SINGLE_ACTIONS;
    
//    public static final ImageIcon ICON_THOUGHT = tr.view.Resources.ICON_G_THOUGHT;
//    public static final ImageIcon ICON_PROJECT = tr.model.Resources.ICON_PROJECT;
//    public static final ImageIcon ICON_ASAP = tr.model.Resources.ICON_DOASAP;
//    public static final ImageIcon ICON_DELEGATED = tr.model.Resources.ICON_DELEGATED;
//    public static final ImageIcon ICON_SCHEDULED = tr.model.Resources.ICON_SCHEDULED;
//    public static final ImageIcon ICON_INACTIVE = tr.model.Resources.ICON_INACTIVE;
    
//    public static final ImageIcon ICON_ACTIONS = ResourceUtils.loadInstalledIcon("resource/images/Actions16.gif");
//  public static final ImageIcon ICON_GLASSES = ResourceUtils.loadInstalledIcon("resource/images/Glasses16.gif");
    
//  public static final ImageIcon ICON_REVIEW_ACTIONS = new ImageIcon(Utilities.mergeImages(ICON_ACTIONS.getImage(), ICON_GLASSES.getImage(), 0, 0));
    
//    public static final ImageIcon ICON_ACTIONS_DONE = ResourceUtils.loadInstalledIcon("resource/images/ActionsDone16.gif");
    
//////    public static final ImageIcon ICON_COLUMNS = ResourceUtils.loadInstalledIcon("resource/images/Columns16.gif");
//////    public static final ImageIcon ICON_FILTERS = ResourceUtils.loadInstalledIcon("resource/images/Filters16.gif");
    
//    public static final ImageIcon ICON_PDF = tr.extract.reports.Resources.ICON_PDF;
    
//    public static final ImageIcon ICON_ACTION = tr.model.Resources.ICON_DOASAP;
    
//    public static final ImageIcon ICON_UP = tr.view.Resources.ICON_UP;
//    public static final ImageIcon ICON_DOWN = tr.view.Resources.ICON_DOWN;
//    public static final ImageIcon ICON_PLUS = tr.view.Resources.ICON_PLUS;
//    public static final ImageIcon ICON_MINUS = tr.view.Resources.ICON_MINUS;
}
