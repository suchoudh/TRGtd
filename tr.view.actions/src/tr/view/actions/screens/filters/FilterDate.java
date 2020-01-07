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

import java.util.logging.Logger;
import tr.swing.date.combo.DateItem;
import tr.swing.date.combo.DateType;
import tr.util.Utils;
import tr.view.filters.FilterCombo;
import tr.view.filters.FilterComboDate;

/**
 * Abstract base class for date matcher editors.
 *
 * @author <a href="mailto:jimoore@netspace.net.au">Jeremy Moore</a>
 */
public abstract class FilterDate extends ActionsFilter {
    
    private static final Logger LOG = Logger.getLogger("tr.view.actions");
//    private static final byte VERSION = 1;
    
    protected FilterComboDate combo;
    
//    /** @since 2.0.1 */
//    protected boolean excludeNulls;
    
    /** Constructs a new instance. */
    public FilterDate() {
        super();
    }
    
//    public final boolean excludeNulls() {
//        return excludeNulls;
//    }
//    
    protected boolean canExcludeNulls() {
        return true;
    }
    
//    public final void setExcludeNulls(boolean b) {
//        this.excludeNulls = b;
//    }
    
    /** Gets the component. */
    public final FilterCombo getFilterCombo() {
        return combo;
    }
    
    public String[] getSerialValues() {
        if (combo == null) return null;
        
        String selected = "";
        
        DateItem item = (DateItem)combo.getSelectedItem();
        if (item != null && item.type != DateType.NONE) {
            selected = String.valueOf(item.value);
        }
        
        return new String[] { selected, Boolean.toString(excludeNulls) };
    }
    
    public void setSerialValues(String[] values) {
        if (combo == null) return;
        
        combo.stopChangeEvents();
        
        if (values == null || values.length < 1) {
            combo.setSelectedItem(null);
        } else {
            try {
                long value = Long.parseLong(values[0]);
                if (value < 1000) { // assume days
                    combo.setSelectedItem(combo.getDateItem(DateType.DAYS, value));
                } else { // assume a date value in milliseconds since ...
                    combo.setSelectedItem(combo.getDateItem(DateType.MS, value));
                }
            } catch (Exception ex) {
                combo.setSelectedItem(null);
            }
            
            if (values.length > 1) {
                try {
                    excludeNulls = Boolean.parseBoolean(values[1]);
                } catch (Exception ex) {
                }
            }
        }
        
        combo.startChangeEvents();
    }
    
    public boolean equals(Object object) {
        if (!(object instanceof FilterDate)) {
            return false;
        }
        if (!super.equals(object)) {
            return false;
        }
        DateItem thisDateItem = (DateItem)combo.getSelectedItem();
        DateItem thatDateItem = (DateItem)((FilterDate)object).combo.getSelectedItem();
        return Utils.equal(thisDateItem, thatDateItem);
    }
    
//    public void persist(PersistenceOutputStream out) throws Exception {
//        super.persist(out);
//        out.writeByte(VERSION);
//        out.writeDateItem(combo == null ? null : (DateItem)combo.getSelectedItem());
//        out.writeBoolean(excludeNulls);
//    }
//
//    public void restore(PersistenceInputStream in) throws Exception {
//        super.restore(in);
//        byte version = in.readByte();
//        if (version != VERSION) {
//            throw new Exception("Unknown persistance version for " + getClass().getName());
//        }
//        getFilterCombo().setSelectedItem((DateItem)in.readDateItem());
//        excludeNulls = in.readBoolean();
//    }
    
}
