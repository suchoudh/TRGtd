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

package tr.view.criteria;

import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import org.openide.util.NbBundle;
import tr.model.IDGenerator;
import tr.model.criteria.Criterion;
import tr.model.criteria.Value;
import tr.util.Observer;

/**
 * Table model for priority criterion.
 */
public class PriorityTableModel extends CriterionTableModel implements Observer {
    
    /**
     * Creates a new instance for the given data model.
     * @param criterion The data model.
     */
    public PriorityTableModel(Criterion criterion, IDGenerator idGenerator) {
        super(criterion, idGenerator);
    }
    
    /**
     * Return the number of columns in the data model.
     */
    @Override
    public int getColumnCount() {
        return CLASSES.length;
    }
    
    /**
     * Return the column class.
     * @param column The table column.
     */
    @Override
    public Class getColumnClass(int column) {
        return CLASSES[column];
    }
    
    /**
     * Return the name of the given column in the data model.
     * @param column The table column.
     */
    @Override
    public String getColumnName(int column) {
        return HEADINGS[column];
    }
    
    /**
     * Return the number of rows in the data model.
     */
    public int getRowCount() {
        return criterion.values.size();
    }
    
    /**
     * Return the context for the specified table row.
     * @param row The table row.
     */
    public Value getValueAt(int row) {
        return criterion.values.get(row);
    }
    
    /**
     * Gets the data model value for a particular table cell.
     * @param row The table row.
     * @param column The table column.
     * @return The value for the cell.
     */
    public Object getValueAt(int row, int column) {
        switch (column) {
            case 0: return getValueAt(row).getName();
            case 1: return getValueAt(row).getMappedValue();
        }
        return "";
    }
    
    /**
     * Determines whether a particular cell is editable.
     * @param row The table row.
     * @param column The table column.
     * @return true iff the cell is editable.
     */
    @Override
    public boolean isCellEditable(int row, int column) {
        return true;
    }
    
    /**
     * Sets the value for a particular cell.
     * @param row The table row.
     * @param column The table column.
     */
    @Override
    public void setValueAt(Object value, int row, int column) {
        if (row < criterion.values.size()) {
            if (column == 0 && value instanceof String) {
                criterion.values.get(row).setName((String)value);
                return;
            } 
            if (column == 1) {
                if (value instanceof Integer) {
                    Integer iValue = (Integer)value;
                    if (iValue < 0) {
                        iValue = 0;
                    } else if (iValue > 9) {
                        iValue = 9;
                    }
                    criterion.values.get(row).setMappedValue(iValue);                    
                } else {
                    criterion.values.get(row).setMappedValue(null);                                        
                }
            }
        }
    }
        
//    public synchronized boolean moveDown(int row) {
//        if (row < 0 || row > criterion.values.size() - 2) {
//            return false;
//        }
//        Value value = criterion.values.get(row);        
//        criterion.values.set(row, criterion.values.get(row + 1));
//        criterion.values.set(row + 1, value);
//        return true;
//    }
//    
//    public synchronized boolean moveUp(int row) {
//        if (row < 1 || row > criterion.values.size() - 1) {
//            return false;
//        }
//        Value value = criterion.values.get(row);        
//        criterion.values.set(row, criterion.values.get(row - 1));
//        criterion.values.set(row - 1, value);        
//        return true;
//    }
//    
//    public synchronized boolean removeRow(int row) {
//        if (row < 0 || row > criterion.values.size() - 1) {
//            return false;
//        }
//        return criterion.values.remove(criterion.values.get(row));        
//    }
//    
//    public synchronized boolean addRow() {
//        return criterion.values.add(new Value("", idGenerator));
//    }
//    
//    /** Handle criteria changes. */
//    public void update(Observable observable, Object arg) {
//        fireTableDataChanged();
//    }
    
    /** Column headings */
    public static final String[] HEADINGS = { 
        NbBundle.getMessage(PriorityTableModel.class, "value"),  
        NbBundle.getMessage(PriorityTableModel.class, "mapping")  
    };
    
    /** Column classes */
    public static final Class[] CLASSES = { String.class, Integer.class };
    
    /** Column cell renderers */
    public static final TableCellRenderer[] RENDERERS = { null, null };
    
    /** Column cell editors */
    public static final TableCellEditor[] EDITORS = { null, null };
        
    @Override
    public int[] getMaxWidths() {
        return MAX_WIDTHS;
    }

    @Override
    public int[] getMinWidths() {
        return MIN_WIDTHS;
    }

    @Override
    public int[] getPrefWidths() {
        return PREF_WIDTHS;
    }    
    
    /** Column cell maximum widths */
    public static final int[] MAX_WIDTHS = { 200, 100 };
    
    /** Column cell minimum widths */
    public static final int[] MIN_WIDTHS = { 200, 100 };
    
    /** Column cell preferred widths */
    public static final int[] PREF_WIDTHS = { 200, 100 };
    
//    private final Criterion criterion;
//    private final IDGenerator idGenerator;
    
}