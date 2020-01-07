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
import tr.swing.date.combo.DateItem;
import tr.util.DateUtils;
import tr.view.filters.FilterCombo;
import tr.view.filters.FilterComboDate;

/**
 * MatcherEditor the matches actions for a start to date.
 *
 * @author <a href="mailto:jimoore@netspace.net.au">Jeremy Moore</a>
 */
public class FilterDateStartTo extends FilterDate
        implements PropertyChangeListener {
    
    public static final byte INDEX = 15;
    
    private final static DateItem[] dateItems = new DateItem[] {
        DateItem.DATE_CHOOSER,
        DateItem.YESTERDAY,
        DateItem.TODAY,
        DateItem.TOMORROW,
        DateItem.WEEKS_1,
        DateItem.WEEKS_2,
        DateItem.WEEKS_3,
        DateItem.WEEKS_4
    };
    
    /** Constructs a new instance. */
    public FilterDateStartTo() {
        initialise();
    }
    
    protected void initialise() {
        combo = new FilterComboDate(dateItems, false);
        combo.addValueChangeListener(this);
    }
    
    public void propertyChange(PropertyChangeEvent e) {
        DateItem item = (DateItem)combo.getSelectedItem();
        if (item == null) {
            fireMatchAll();
        } else {
            fireChanged(new ToDateMatcher(combo.getDate(item), excludeNulls));
        }
    }
    
    public String getLabel() {
        return NbBundle.getMessage(getClass(), "filter-start-to");
    }
    
    public byte getIndex() {
        return INDEX;
    }
    
    private static class ToDateMatcher implements Matcher<Action> {
        
        private final Date matchDate;
        private final boolean excludeNulls;
        
        public ToDateMatcher(Date date, boolean excludeNulls) {
            this.matchDate = DateUtils.getEnd(date);
            this.excludeNulls = excludeNulls;
        }
        
        public boolean matches(Action action) {
            if (matchDate == null) {
                return true;
            }
            Date date = action.getStartDate();
            if (date == null) {
                return ! excludeNulls;
            }
            return ! date.after(matchDate);
        }
    }
    
}

