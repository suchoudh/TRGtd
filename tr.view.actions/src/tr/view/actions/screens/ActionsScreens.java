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

import au.com.trgtd.tr.appl.Constants;
import java.util.logging.Logger;
import tr.model.util.Manager;
import tr.swing.date.combo.DateItem;
import tr.view.actions.screens.columns.ActionsColumn;
import tr.view.actions.screens.filters.ActionsFilter;
import tr.view.actions.screens.filters.FilterDate;
import tr.view.actions.screens.filters.FilterDateActionTo;
import tr.view.actions.screens.filters.FilterContext;
import tr.view.actions.screens.filters.FilterDone;
import tr.view.actions.screens.filters.FilterDateDoneFrom;
import tr.view.actions.screens.filters.FilterDateDoneTo;
import tr.view.actions.screens.filters.FilterDateDueFrom;
import tr.view.actions.screens.filters.FilterDateDueTo;
import tr.view.actions.screens.filters.FilterDateFollowupFrom;
import tr.view.actions.screens.filters.FilterDateFollowupTo;
import tr.view.actions.screens.filters.FilterDateScheduleFrom;
import tr.view.actions.screens.filters.FilterDateScheduleTo;
import tr.view.actions.screens.filters.FilterSearch;
import tr.view.actions.screens.filters.FilterStatus;
import tr.view.actions.screens.filters.FilterTopic;
import tr.view.filters.ContextAll;
import tr.view.filters.TopicAll;

/**
 * Actions screens.
 *
 * @author Jeremy Moore (jimoore@netspace.net.au)
 */
public final class ActionsScreens {
    
    private static final Logger LOG = Logger.getLogger("tr.view.actions");
    
    private Manager<ActionsScreen> screens;
    
    /** Constructor. */
    public ActionsScreens() {
    }
    
    public Manager<ActionsScreen> getScreens() {
        if (screens == null) {
            screens = new Manager<ActionsScreen>();
        }
        return screens;
    }
    
    public void setScreens(Manager<ActionsScreen> screens) {
        this.screens = screens;
    }
    
    public static final Manager<ActionsScreen> createDefaultScreens() {
        LOG.info("Creating default actions screens.");
        
        Manager<ActionsScreen> screens = new Manager<ActionsScreen>();
        
        // Actions screen
        ActionsScreen screen = ActionsScreen.create("screen-actions");
        screen.getColumns().get(ActionsColumn.INDEX_ICON).setVisible(true);
        screen.getColumns().get(ActionsColumn.INDEX_DESCR).setVisible(true);
        screen.getColumns().get(ActionsColumn.INDEX_DONE).setVisible(true);
        screen.getColumns().get(ActionsColumn.INDEX_ACTION_DATE).setVisible(true);
        screen.getColumns().get(ActionsColumn.INDEX_DELEGATED_TO).setVisible(true);
        screen.getColumns().get(ActionsColumn.INDEX_CONTEXT).setVisible(true);
        screen.getColumns().get(ActionsColumn.INDEX_TOPIC).setVisible(true);
        screen.getColumns().get(ActionsColumn.INDEX_FROM_ICON).setVisible(true);
        screen.getColumns().get(ActionsColumn.INDEX_FROM_DESCR).setVisible(true);
        screen.getColumns().get(ActionsColumn.INDEX_FROM_TOPIC).setVisible(true);
        
        ActionsFilter filter = screen.getFilters().get(FilterDone.INDEX);
        filter.setUsed(true);
        filter.setShown(true);
        filter.setSerialValues(new String[] {FilterDone.ToDo.ID});
        filter = screen.getFilters().get(FilterStatus.INDEX);
        filter.setUsed(true);
        filter.setShown(true);
        filter.setSerialValues(new String[] {FilterStatus.All.ID});
        filter = screen.getFilters().get(FilterContext.INDEX);
        filter.setUsed(true);
        filter.setShown(true);
        filter.setSerialValues(new String[] { ContextAll.ID});
        filter = screen.getFilters().get(FilterTopic.INDEX);
        filter.setUsed(true);
        filter.setShown(true);
//        filter.setSerialValues(new String[] { MatcherEditorTopic.TopicAll.ID});
        filter.setSerialValues(new String[] { TopicAll.ID});
        FilterDate dateFilter = (FilterDate)screen.getFilters().get(FilterDateActionTo.INDEX);
        dateFilter.setUsed(true);
        dateFilter.setShown(true);
        dateFilter.getFilterCombo().setSelectedItem(DateItem.TODAY);
        dateFilter.setExcludeNulls(false);
        filter = screen.getFilters().get(FilterSearch.INDEX);
        filter.setUsed(true);
        filter.setShown(true);
        
        screens.add(screen);
        
        // Do ASAP
        screen = ActionsScreen.create("screen-do-asap");
        screen.getColumns().get(ActionsColumn.INDEX_ICON).setVisible(true);
        screen.getColumns().get(ActionsColumn.INDEX_DESCR).setVisible(true);
        screen.getColumns().get(ActionsColumn.INDEX_CREATED_DATE).setVisible(true);
        screen.getColumns().get(ActionsColumn.INDEX_DONE).setVisible(true);
        screen.getColumns().get(ActionsColumn.INDEX_DUE_DATE).setVisible(true);
        screen.getColumns().get(ActionsColumn.INDEX_START_DATE).setVisible(true);
        screen.getColumns().get(ActionsColumn.INDEX_CONTEXT).setVisible(true);
        screen.getColumns().get(ActionsColumn.INDEX_TOPIC).setVisible(true);
        screen.getColumns().get(ActionsColumn.INDEX_FROM_ICON).setVisible(true);
        screen.getColumns().get(ActionsColumn.INDEX_FROM_DESCR).setVisible(true);
        screen.getColumns().get(ActionsColumn.INDEX_FROM_TOPIC).setVisible(true);
        
        filter = screen.getFilters().get(FilterDone.INDEX);
        filter.setUsed(true);
        filter.setShown(true);
        filter.setSerialValues(new String[] {FilterDone.ToDo.ID});
        filter = screen.getFilters().get(FilterStatus.INDEX);
        filter.setUsed(true);
        filter.setShown(false);
        filter.setSerialValues(new String[] {FilterStatus.ChoiceDoASAP.ID});
        filter = screen.getFilters().get(FilterContext.INDEX);
        filter.setUsed(true);
        filter.setShown(true);
        filter.setSerialValues(new String[] { ContextAll.ID});
        filter = screen.getFilters().get(FilterTopic.INDEX);
        filter.setUsed(true);
        filter.setShown(true);
        filter.setSerialValues(new String[] { TopicAll.ID});
        filter = screen.getFilters().get(FilterSearch.INDEX);
        filter.setUsed(true);
        filter.setShown(true);
        dateFilter = (FilterDate)screen.getFilters().get(FilterDateDueFrom.INDEX);
        dateFilter.setUsed(true);
        dateFilter.setShown(true);
        dateFilter.getFilterCombo().setSelectedItem(DateItem.WEEKS_AGO_4);
        dateFilter.setExcludeNulls(false);
        dateFilter = (FilterDate)screen.getFilters().get(FilterDateDueTo.INDEX);
        dateFilter.setUsed(true);
        dateFilter.setShown(true);
        dateFilter.getFilterCombo().setSelectedItem(DateItem.TOMORROW);
        dateFilter.setExcludeNulls(false);
        
        screens.add(screen);
        
        // Delegated
        screen = ActionsScreen.create("screen-delegated");
        screen.getColumns().get(ActionsColumn.INDEX_ICON).setVisible(true);
        screen.getColumns().get(ActionsColumn.INDEX_DESCR).setVisible(true);
        screen.getColumns().get(ActionsColumn.INDEX_DONE).setVisible(true);
        screen.getColumns().get(ActionsColumn.INDEX_DUE_DATE).setVisible(true);
        screen.getColumns().get(ActionsColumn.INDEX_START_DATE).setVisible(true);
        screen.getColumns().get(ActionsColumn.INDEX_FOLLOWUP_DATE).setVisible(true);
        screen.getColumns().get(ActionsColumn.INDEX_DELEGATED_TO).setVisible(true);
        screen.getColumns().get(ActionsColumn.INDEX_CONTEXT).setVisible(true);
        screen.getColumns().get(ActionsColumn.INDEX_TOPIC).setVisible(true);
        screen.getColumns().get(ActionsColumn.INDEX_FROM_ICON).setVisible(true);
        screen.getColumns().get(ActionsColumn.INDEX_FROM_DESCR).setVisible(true);
        screen.getColumns().get(ActionsColumn.INDEX_FROM_TOPIC).setVisible(true);
        
        filter = screen.getFilters().get(FilterDone.INDEX);
        filter.setUsed(true);
        filter.setShown(true);
        filter.setSerialValues(new String[] {FilterDone.ToDo.ID});
        filter = screen.getFilters().get(FilterStatus.INDEX);
        filter.setUsed(true);
        filter.setShown(false);
        filter.setSerialValues(new String[] {FilterStatus.ChoiceDelegated.ID});
        filter = screen.getFilters().get(FilterContext.INDEX);
        filter.setUsed(true);
        filter.setShown(true);
        filter.setSerialValues(new String[] { ContextAll.ID});
        filter = screen.getFilters().get(FilterTopic.INDEX);
        filter.setUsed(true);
        filter.setShown(true);
        filter.setSerialValues(new String[] {TopicAll.ID});
        filter = screen.getFilters().get(FilterSearch.INDEX);
        filter.setUsed(true);
        filter.setShown(true);
        dateFilter = (FilterDate)screen.getFilters().get(FilterDateFollowupFrom.INDEX);
        dateFilter.setUsed(true);
        dateFilter.setShown(true);
        dateFilter.getFilterCombo().setSelectedItem(DateItem.WEEKS_AGO_4);
        dateFilter.setExcludeNulls(false);
        dateFilter = (FilterDate)screen.getFilters().get(FilterDateFollowupTo.INDEX);
        dateFilter.setUsed(true);
        dateFilter.setShown(true);
        dateFilter.getFilterCombo().setSelectedItem(DateItem.TOMORROW);
        dateFilter.setExcludeNulls(false);
        
        screens.add(screen);
        
        // Scheduled screen
        screen = ActionsScreen.create("screen-scheduled");
        screen.getColumns().get(ActionsColumn.INDEX_ICON).setVisible(true);
        screen.getColumns().get(ActionsColumn.INDEX_DESCR).setVisible(true);
        screen.getColumns().get(ActionsColumn.INDEX_DONE).setVisible(true);
        screen.getColumns().get(ActionsColumn.INDEX_SCHEDULE_DATE).setVisible(true);
        screen.getColumns().get(ActionsColumn.INDEX_CONTEXT).setVisible(true);
        screen.getColumns().get(ActionsColumn.INDEX_TOPIC).setVisible(true);
        screen.getColumns().get(ActionsColumn.INDEX_FROM_ICON).setVisible(true);
        screen.getColumns().get(ActionsColumn.INDEX_FROM_DESCR).setVisible(true);
        screen.getColumns().get(ActionsColumn.INDEX_FROM_TOPIC).setVisible(true);
        
        filter = screen.getFilters().get(FilterDone.INDEX);
        filter.setUsed(true);
        filter.setShown(true);
        filter.setSerialValues(new String[] {FilterDone.ToDo.ID});
        filter = screen.getFilters().get(FilterStatus.INDEX);
        filter.setUsed(true);
        filter.setShown(false);
        filter.setSerialValues(new String[] {FilterStatus.ChoiceScheduled.ID});
        filter = screen.getFilters().get(FilterContext.INDEX);
        filter.setUsed(true);
        filter.setShown(true);
        filter.setSerialValues(new String[] { ContextAll.ID});
        filter = screen.getFilters().get(FilterTopic.INDEX);
        filter.setUsed(true);
        filter.setShown(true);
        filter.setSerialValues(new String[] {TopicAll.ID});
        filter = screen.getFilters().get(FilterSearch.INDEX);
        filter.setUsed(true);
        filter.setShown(true);
        dateFilter = (FilterDate)screen.getFilters().get(FilterDateScheduleFrom.INDEX);
        dateFilter.setUsed(true);
        dateFilter.setShown(true);
        dateFilter.getFilterCombo().setSelectedItem(DateItem.TODAY);
        dateFilter.setExcludeNulls(false);
        dateFilter = (FilterDate)screen.getFilters().get(FilterDateScheduleTo.INDEX);
        dateFilter.setUsed(true);
        dateFilter.setShown(true);
        dateFilter.getFilterCombo().setSelectedItem(DateItem.TOMORROW);
        dateFilter.setExcludeNulls(false);
        
        screens.add(screen);
        
        // Done screen
        screen = ActionsScreen.create("screen-done");
        screen.getColumns().get(ActionsColumn.INDEX_ICON).setVisible(true);
        screen.getColumns().get(ActionsColumn.INDEX_DESCR).setVisible(true);
        screen.getColumns().get(ActionsColumn.INDEX_CREATED_DATE).setVisible(true);
        screen.getColumns().get(ActionsColumn.INDEX_DONE).setVisible(true);
        screen.getColumns().get(ActionsColumn.INDEX_DONE_DATE).setVisible(true);
        screen.getColumns().get(ActionsColumn.INDEX_DELEGATED_TO).setVisible(true);
        screen.getColumns().get(ActionsColumn.INDEX_CONTEXT).setVisible(true);
        screen.getColumns().get(ActionsColumn.INDEX_TOPIC).setVisible(true);
        screen.getColumns().get(ActionsColumn.INDEX_FROM_ICON).setVisible(true);
        screen.getColumns().get(ActionsColumn.INDEX_FROM_DESCR).setVisible(true);
        screen.getColumns().get(ActionsColumn.INDEX_FROM_TOPIC).setVisible(true);
        
        filter = screen.getFilters().get(FilterDone.INDEX);
        filter.setUsed(true);
        filter.setShown(false);
        filter.setSerialValues(new String[] {FilterDone.Done.ID});
        filter = screen.getFilters().get(FilterContext.INDEX);
        filter.setUsed(true);
        filter.setShown(true);
        filter.setSerialValues(new String[] { ContextAll.ID});
        filter = screen.getFilters().get(FilterTopic.INDEX);
        filter.setUsed(true);
        filter.setShown(true);
        filter.setSerialValues(new String[] {TopicAll.ID});
        dateFilter = (FilterDate)screen.getFilters().get(FilterDateDoneFrom.INDEX);
        dateFilter.setUsed(true);
        dateFilter.setShown(true);
        dateFilter.getFilterCombo().setSelectedItem(DateItem.WEEKS_AGO_4);
        dateFilter.setExcludeNulls(false);
        dateFilter = (FilterDate)screen.getFilters().get(FilterDateDoneTo.INDEX);
        dateFilter.setUsed(true);
        dateFilter.setShown(true);
        dateFilter.getFilterCombo().setSelectedItem(DateItem.TODAY);
        dateFilter.setExcludeNulls(false);
        filter = screen.getFilters().get(FilterSearch.INDEX);
        filter.setUsed(true);
        filter.setShown(true);
        
        screens.add(screen);
        
        return screens;
    }
    
}

