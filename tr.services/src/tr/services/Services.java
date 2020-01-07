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

package tr.services;

import java.util.Collections;
import java.util.List;
import java.util.Vector;
import org.openide.util.Lookup;
import org.openide.util.LookupEvent;
import org.openide.util.LookupListener;
import tr.model.Data;
import tr.model.DataLookup;
import tr.model.action.Action;
import tr.model.project.Project;
import tr.util.Observable;
import tr.util.ObservableImpl;
import tr.util.Observer;

/**
 * TR Services.
 *
 * @author Jeremy Moore (jimoore@netspace.net.au)
 */

// TODO: change to proper service mechanism.

public class Services {
    
    /** Singleton instance. */
    public static final Services instance = new Services();
    
    private final Lookup.Result lookupResult;
    private final ActionsObserver actionsObserver;
    private final ObservableImpl actionsObservable;
    
    private Services() {
        actionsObserver = new ActionsObserver();
        actionsObservable = new ObservableImpl() {};
        dataChanged();
        
        lookupResult = DataLookup.instance().lookup(new Lookup.Template(Data.class));
        lookupResult.addLookupListener(new LookupListener() {
            public void resultChanged(LookupEvent lookupEvent) {
                dataChanged();
            }
        });
    }
    
    private void dataChanged() {
        actionsObservable.removeObservers();
        
        Data data = (Data)DataLookup.instance().lookup(Data.class);
        if (data != null) {
            data.getRootActions().addObserver(actionsObserver);
            data.getRootProjects().addObserver(actionsObserver);
        }
    }
    
    /**
     * Gets all single actions (i.e. actions that are not within a project).
     * @return a list containing all single actions.
     */
    public List<Action> getSingleActions() {
        Data data = (Data)DataLookup.instance().lookup(Data.class);
        if (data == null) {
            return Collections.emptyList();
        }
        
        return data.getRootActions().getChildren(Action.class);
    }
    
    /**
     * Gets all actions that are in a project.
     * @return a list containing project actions.
     */
    public List<Action> getProjectActions() {
        Data data = (Data)DataLookup.instance().lookup(Data.class);
        if (data == null) {
            return Collections.emptyList();
        }
        
        List<Action> actions = new Vector<Action>();
        
        for (Project project : getProjects()) {
            actions.addAll(project.getChildren(Action.class));
        }
        
        return actions;
    }
    
    /**
     * Gets all actions.
     * @return a list containing all actions.
     */
    public List<Action> getAllActions() {
        List<Action> actions = new Vector<Action>();
        actions.addAll(getProjectActions());
        actions.addAll(getSingleActions());
        return actions;
    }
    
    /**
     * Gets all projects.
     * @return a list containing all projects.
     */
    public List<Project> getProjects() {
        
        Data data = (Data)DataLookup.instance().lookup(Data.class);
        if (data == null) {
            return Collections.emptyList();
        }
        
        List<Project> projects = new Vector<Project>();
        
        addSubprojects(data.getRootProjects(), projects);
        
        return projects;
    }
    
    private void addSubprojects(Project project, List<Project> projects) {
        
        List<Project> subprojects = project.getChildren(Project.class);
        
        projects.addAll(subprojects);
        
        for (Project subproject : subprojects) {
            addSubprojects(subproject, projects);
        }
    }
    
    /**
     * Gets all decendant actions of a project.
     * @param project the given project.
     * @return a list of decendant actions.
     */
    public List<Action> getActionDecendants(Project project) {
        return getActionDecendants(project, new Vector<Action>());
    }
    
    /* Gets all decendant actions for a project recursively. */
    private List<Action> getActionDecendants(Project project, List<Action> decendants) {
        if (project == null) {
            return decendants;
        }        
        decendants.addAll(project.getChildren(Action.class));
        
        for (Project subProject : project.getChildren(Project.class)) {
            decendants.addAll(getActionDecendants(subProject, decendants));
        }
        
        return decendants;
    }
            
    private final class ActionsObserver implements Observer {
        public void update(Observable observable, Object argument) {
            actionsObservable.notifyObservers(observable, argument);
        }
    }
    
    public void addActionsObserver(Observer observer) {
        actionsObservable.addObserver(observer);
    }
    
    public void removeActionsObserver(Observer observer) {
        actionsObservable.removeObserver(observer);
    }
    
}
