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

package tr.view.actions.screens.filters;

import ca.odell.glazedlists.matchers.Matcher;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Date;
import org.openide.util.NbBundle;
import tr.model.action.Action;
import tr.model.action.ActionStateDelegated;
import tr.swing.date.combo.DateItem;
import tr.util.DateUtils;
import tr.view.filters.FilterCombo;
import tr.view.filters.FilterComboDate;

/**
 * MatcherEditor the matches actions for a followup from date.
 *
 * @author <a href="mailto:jimoore@netspace.net.au">Jeremy Moore</a>
 */
public class FilterDateFollowupFrom extends FilterDate
        implements PropertyChangeListener {
    
    public static final byte INDEX = 18;
    
    private final static DateItem[] dateItems = new DateItem[] {
        DateItem.DATE_CHOOSER,
        DateItem.TODAY,
        DateItem.YESTERDAY,
        DateItem.WEEKS_AGO_1,
        DateItem.WEEKS_AGO_2,
        DateItem.WEEKS_AGO_3,
        DateItem.WEEKS_AGO_4
    };
    
    /** Constructs a new instance. */
    public FilterDateFollowupFrom() {
        initialise();
    }
    
    protected void initialise() {
        combo = new FilterComboDate(dateItems, false);
        combo.addValueChangeListener(this);
    }
    
    public String getLabel() {
        return NbBundle.getMessage(getClass(), "filter-followup-from");
    }
    
    public byte getIndex() {
        return INDEX;
    }
    
    public void propertyChange(PropertyChangeEvent e) {
        DateItem item = (DateItem)combo.getSelectedItem();
        if (item == null) {
            fireMatchAll();
        } else {
            fireChanged(new FromDateMatcher(combo.getDate(item), excludeNulls));
        }
    }
    
    private static class FromDateMatcher implements Matcher<Action> {
        
        private final Date matchDate;
        private final boolean excludeNulls;
        
        public FromDateMatcher(Date date, boolean excludeNulls) {
            this.matchDate = DateUtils.getStart(date);
            this.excludeNulls = excludeNulls;
        }
        
        public boolean matches(Action action) {
            if (matchDate == null) {
                return true;
            }
            if (!action.isStateDelegated()) {
                return false;
            }
            ActionStateDelegated state = (ActionStateDelegated)action.getState();
            Date date = state.getDate();
            if (date == null) {
                return ! excludeNulls;
            }
            return ! date.before(matchDate);
        }
    }
    
}

