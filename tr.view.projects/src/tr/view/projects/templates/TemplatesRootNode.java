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

package tr.view.projects.templates;

import au.com.thinkingrock.tr.resource.Icons;
import java.awt.Image;
import org.openide.actions.PasteAction;
import org.openide.util.actions.SystemAction;
import tr.model.project.Project;
import tr.view.projects.AddProjectAction;
import tr.view.projects.CollapseAllAction;
import tr.view.projects.ExpandAllAction;
import tr.view.projects.ToggleShowDoneAction;

/**
 * The root node for templates.
 *
 * @author Jeremy Moore (jimoore@netspace.net.au)
 */
public class TemplatesRootNode extends TemplatesProjectNode {
    
    /** Constructs a new instance. */
    public TemplatesRootNode(Project root, boolean showDone) {
        super(root, showDone);
    }
    
    @Override
    public Image getIcon(int type) {
        return Icons.ProjectsTemplate.getImage();        
    }
    
    @Override
    public Image getOpenedIcon(int type) {
        return Icons.ProjectsTemplate.getImage();        
    }
    
    @Override
    public javax.swing.Action[] getActions(boolean popup) {
        return new javax.swing.Action[] {
            SystemAction.get(ExpandAllAction.class),
            SystemAction.get(CollapseAllAction.class),
            null,
//            SystemAction.get(ShowDoneAction.class),
//            SystemAction.get(HideDoneAction.class),
            SystemAction.get(ToggleShowDoneAction.class),            
            null,
            SystemAction.get(AddProjectAction.class),
            null,
            SystemAction.get(PasteAction.class),
        };
    }
    
    @Override
    public boolean canCopy() {
        return false;
    }
    
    @Override
    public boolean canCut() {
        return false;
    }
    
    @Override
    public boolean canDestroy() {
        return false;
    }
    
    @Override
    public boolean canRename() {
        return false;
    }
        
    @Override
    public boolean canAddAction() {
        return false;
    }
    
}