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

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;
import org.openide.util.NbBundle;
import tr.util.Observable;
import tr.util.Observer;
import tr.view.actions.screens.columns.ActionsColumn;

/**
 * Table model for the columns dialog.
 */
public class ColumnsTableModel extends AbstractTableModel implements Observer {
    
    private static final Logger LOG = Logger.getLogger("tr.view.actions");
    
    /**
     * Creates a new instance for the given action screen definition.
     * @param screendefe The action screen definition.
     */
    public ColumnsTableModel(ActionsScreen actionsScreen) {
        super();
        this.actionsScreen = actionsScreen;
        this.actionsScreen.addObserver(this);
    }
    
    /**
     * Gets the table cell renderer corresponding to the used column.
     * @return The table cell renderer.
     */
    public TableCellRenderer getTableCellRenderer(int column) {
        return renderers[column];
    }
    
    /**
     * Gets the maximum width corresponding to the used column.
     * @return The maximum column width.
     */
    public int getMaximumWidth(int column) {
        return maxwidths[column];
    }
    
    /**
     * Gets the minimum width corresponding to the used column.
     * @return The minimum column width.
     */
    public int getMinimumWidth(int column) {
        return minwidths[column];
    }
    
    /**
     * Gets the preferred width corresponding to the used column.
     * @return The preferred column width.
     */
    public int getPreferredWidth(int column) {
        return prewidths[column];
    }
    
    /** Return the number of columns in the data model. */
    public int getColumnCount() {
        return classes.length;
    }
    
    /** Return the name of the given column in the data model. */
    @Override
    public String getColumnName(int column) {
        return headings[column];
    }
    
    /** Return the column class. */
    @Override
    public Class<?> getColumnClass(int column) {
        return classes[column];
    }
    
    /** Return the number of rows in the data model. */
    public int getRowCount() {
//        return actionsScreen.getColumns().size();
        return ActionsColumn.COLUMN_INDICES.length;
    }
    
    private Map<Byte, ActionsColumn> rowMap;
    
    private Map<Byte, ActionsColumn> getRowMap() {
        if (rowMap == null) {
            rowMap = new HashMap<Byte, ActionsColumn>();
            for (ActionsColumn ac : actionsScreen.getColumns().list()) {
                rowMap.put(ac.getColumnIndex(), ac);
            }
            for (byte index : ActionsColumn.COLUMN_INDICES) {
                if (!rowMap.containsKey(index)) {
                    ActionsColumn ac = ActionsColumn.createColumn(index);
                    actionsScreen.getColumns().add(ac);
                    rowMap.put(index, ac);
                }
            }
        }
        return rowMap;
    }
    
    /** Gets the data model value at the specified table row and column. */
    public Object getValueAt(int row, int column) {
        
        byte index = ActionsColumn.COLUMN_INDICES[row];
        
        ActionsColumn ac = getRowMap().get(index);
        if (ac == null) return "";
        
        switch (column) {
            case (COLUMN_VISIBLE): return Boolean.valueOf(ac.isVisible());
            case (COLUMN_COLUMN) : return ac.toString();
            default: return "";
        }
    }
    
    /** Sets the data model value at the specified table row and column. */
    @Override
    public void setValueAt(Object object, int row, int column) {
        LOG.fine("SetValueAt: row = " + row + " col = " + column);
        
        if (column == COLUMN_VISIBLE && object instanceof Boolean) {
            
            boolean visible = ((Boolean)object).booleanValue();
            byte index = ActionsColumn.COLUMN_INDICES[row];
            
            // Description column must be visible - must have one or more.
            if (index == ActionsColumn.INDEX_DESCR && !visible) {
                return;
            }
            
            ActionsColumn actionsColumn = getRowMap().get(index);
            if (actionsColumn != null) {
                actionsColumn.setVisible(visible);
//              fireTableDataChanged();
            }
            
        }
    }
    
    @Override
    public boolean isCellEditable(int row, int column) {
        return column == COLUMN_VISIBLE;
    }
    
    public void update(Observable o, Object arg) {
        fireTableDataChanged();
    }
    
    private static String getText(String key) {
        return NbBundle.getMessage(ColumnsTableModel.class, key);
    }
    
    private static final int[] maxwidths = { -1, -1 };
    private static final int[] minwidths = { -1, 50 };
    private static final int[] prewidths = { -1, 70 };
    private static final Class[] classes = { String.class, Boolean.class };
    private static final TableCellRenderer[] renderers = { null, null };
    private static final String[] headings = {
        getText("ColumnsDialog.column.column"),
        getText("ColumnsDialog.column.visible"),
    };
    
    private static final byte COLUMN_COLUMN = 0;
    private static final byte COLUMN_VISIBLE = 1;
    
    private final ActionsScreen actionsScreen;
    
}