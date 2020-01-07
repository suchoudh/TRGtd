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
package tr.view.contexts.screen;

import ca.odell.glazedlists.BasicEventList;
import ca.odell.glazedlists.EventList;
import ca.odell.glazedlists.SortedList;
import ca.odell.glazedlists.swing.EventSelectionModel;
import ca.odell.glazedlists.swing.EventTableModel;
import ca.odell.glazedlists.swing.TableComparatorChooser;
import ca.odell.glazedlists.util.concurrent.Lock;
import java.awt.BorderLayout;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Vector;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import org.jdesktop.swingx.JXTable;
import org.jdesktop.swingx.table.TableColumnExt;
import org.openide.util.actions.SystemAction;
import tr.model.Data;
import tr.model.DataLookup;
import tr.model.context.Context;
import tr.model.util.Manager;
import tr.util.Observable;
import tr.util.Observer;
import tr.view.contexts.DeleteContextAction;
import tr.view.contexts.EditContextAction;
import tr.view.contexts.dialog.ContextDialog;

/**
 * Context panel.
 *
 * @author <a href="mailto:jimoore@netspace.net.au">Jeremy Moore</a>
 */
public class ContextsPanel extends JPanel implements ListSelectionListener, Observer {
    
    /**
     * Creates a new instance for the given context node provider.
     */
    public ContextsPanel(ContextNodeProvider contextProvider) {
        super();
        this.contextProvider = contextProvider;
        this.data = (Data)DataLookup.instance().lookup(Data.class);
        initTable();
        initPanel();
    }
    
    private void initTable() {
        if (data == null) return;
        
        contextList = data.getContextManager().list();
        contextEventList = new BasicEventList<Context>();
        contextEventList.addAll(contextList);
        
        data.getContextManager().addObserver(this);
        
        contextSortedList = new SortedList<Context>(contextEventList);
        contextSortedList.setMode(SortedList.AVOID_MOVING_ELEMENTS);
        
        contextTableFormat = new ContextsTableFormat();
        contextEventTableModel = new EventTableModel<Context>(contextSortedList, contextTableFormat);
        
        contextTable = new JXTable(contextEventTableModel);
        contextTable.getTableHeader().setDefaultRenderer(new JTableHeader().getDefaultRenderer());
        contextTable.getSelectionMapper().setEnabled(false);
        contextTable.setSortable(false);
        contextTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        contextTable.setColumnControlVisible(true);
        contextTable.setColumnSelectionAllowed(false);
        contextTable.setCellSelectionEnabled(false);
        contextTable.setRowSelectionAllowed(true);
        contextTable.setShowGrid(false);
        contextTable.setShowHorizontalLines(false);
        contextTable.setShowVerticalLines(false);
//      contextTable.setGridColor(Color.lightGray);
        
        selectionModel = new EventSelectionModel<Context>(contextSortedList);
        selectionModel.addListSelectionListener(this);
        selectionModel.setSelectionMode(selectionModel.MULTIPLE_INTERVAL_SELECTION);
        selectionModel.setEnabled(true);
        contextTable.setSelectionModel(selectionModel);
        
        for (int c = 0; c < contextTableFormat.getColumnCount(); c++) {
            contextTable.getColumnModel().getColumn(c).setPreferredWidth(contextTableFormat.getColumnWidth(c));
        }
        
        contextTable.setDefaultRenderer(Context.class, new ContextsTableFormat.ContextRenderer());
        
        tableSorter = new TableComparatorChooser<Context>(contextTable, contextSortedList, true);
        
        contextTable.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    e.consume();
                    edit();
                } else if (e.getKeyCode() == KeyEvent.VK_DELETE) {
                    e.consume();
                    delete();
                }
            }
        });
        contextTable.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    edit();
                }
            }
        });
    }
    
    /** Preferences for the context panel. */
    static class Preferences implements Serializable {
        private static final long serialVersionUID = 6587787564L;
        private final int[] modelIndex;
        private final int[] columnWidth;
        private final boolean[] columnVisible;
        private final int[] columnOrder;
        private final List<Integer> sortingColumns;
        private final List<Boolean> sortingReverse;
        // constructor saves preferences
        private Preferences(ContextsPanel panel) {
            JXTable table = panel.contextTable;
            this.modelIndex = new int[table.getColumnCount(true)];
            this.columnWidth = new int[table.getColumnCount(true)];
            this.columnVisible = new boolean[table.getColumnCount(true)];
            this.columnOrder = new int[table.getColumnCount(false)];
            // save column widths and visibility:
            List<TableColumn> columns = table.getColumns(true);
            for (int i = 0; i < columns.size(); i++) {
                TableColumn c = columns.get(i);
                modelIndex[i] = c.getModelIndex();
                columnWidth[i] = c.getWidth();
                columnVisible[i] = table.getColumnExt(c.getIdentifier()).isVisible();
            }
            // save column order:
            for (int i = 0; i < table.getColumnCount(); i++) {
                columnOrder[i] = table.getColumn(i).getModelIndex();
            }
            // save column sorting:
            sortingColumns = panel.tableSorter.getSortingColumns();
            sortingReverse = new Vector<Boolean>();
            for (Integer column : sortingColumns) {
                sortingReverse.add(new Boolean(panel.tableSorter.isColumnReverse(column)));
            }
        }
        
        private void restore(ContextsPanel panel) {
            if (panel == null) return;
            if (panel.contextTable == null) return;
            if (panel.contextTableFormat == null) return;
            // restore column widths and visibility:
            for (int i = 0; i < modelIndex.length; i++) {
                String id = panel.contextTableFormat.getColumnName(modelIndex[i]);
                TableColumnExt tce = panel.contextTable.getColumnExt(id);
                if (panel.contextTableFormat.isResizable(modelIndex[i])) {
                    tce.setPreferredWidth(columnWidth[i]);
                } else {
                    int w = panel.contextTableFormat.getColumnWidth(modelIndex[i]);
                    tce.setMaxWidth(w);
                    tce.setMinWidth(w);
                }
                tce.setVisible(columnVisible[i]);
            }
            // restore column order:
            Object[] ids = new Object[columnOrder.length];
            for (int i = 0; i < ids.length; i++) {
                ids[i] = panel.contextTableFormat.getColumnName(columnOrder[i]);
            }
            panel.contextTable.setColumnSequence(ids);
            // restore column sorting:
            panel.tableSorter.clearComparator();
            for (int i = 0; i < sortingColumns.size(); i++) {
                int column = sortingColumns.get(i);
                boolean reverse = sortingReverse.get(i);
                panel.tableSorter.appendComparator(column, 0, reverse);
            }
        }
    }
    
    public Preferences getPreferences() {
        return new Preferences(this);
    }
    
    public void setPreferences(Preferences preferences) {
        if (preferences != null) {
            preferences.restore(this);
        }
    }
    
    private void initPanel() {
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(contextTable);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        setLayout(new BorderLayout());
        setBorder(new EmptyBorder(new Insets(2, 2, 2, 2)));
        add(scrollPane, BorderLayout.CENTER);
    }
    
    /** Edit the selected context. */
    private void edit() {
        SystemAction.get(EditContextAction.class).actionPerformed(null);
    }
    
    /** Delete the selected context. */
    private void delete() {
        SystemAction.get(DeleteContextAction.class).actionPerformed(null);
    }
    
    /** Get a context dialog. */
    private ContextDialog getContextDialog() {
        contextDialog = new ContextDialog(data);
        return contextDialog;
    }
    
    /**
     * Handle table selection change by calling context provider for the new
     * selection.
     * @param e The list selection event.
     */
    public void valueChanged(ListSelectionEvent e) {
        if (e.getValueIsAdjusting()) return;
        
        Collection<ContextNode> nodes = new Vector<ContextNode>();
        for (Context context : selectionModel.getSelected()) {
            nodes.add(new ContextNode(data.getContextManager(), context));
        }
        contextProvider.provide(nodes);
    }
    
    /**
     * Handle context manager add and remove events.
     */
    public void update(final Observable observable, final Object object) {
//////        if (object instanceof Manager.EventAdd) {
//////            Manager.EventAdd event = (Manager.EventAdd)object;
//////            Lock lock = contextEventList.getReadWriteLock().writeLock();
//////            lock.lock();
//////            contextEventList.add((Context)event.item);
//////            lock.unlock();
//////        } else if (object instanceof Manager.EventRemove) {
//////            Manager.EventRemove event = (Manager.EventRemove)object;
//////            Lock lock = contextEventList.getReadWriteLock().writeLock();
//////            lock.lock();
//////            contextEventList.remove(event.item);
//////            lock.unlock();
//////        }
        if (object instanceof Manager.EventAdd) {
            Manager.EventAdd event = (Manager.EventAdd)object;
            Lock lock = contextEventList.getReadWriteLock().writeLock();
            lock.lock();
            contextEventList.add((Context)event.item);
            lock.unlock();
        } else if (object instanceof Manager.EventRemove) {
            Manager.EventRemove event = (Manager.EventRemove)object;
            Lock lock = contextEventList.getReadWriteLock().writeLock();
            lock.lock();
            contextEventList.remove(event.item);
            lock.unlock();
        } else if (observable instanceof Context) {
            Lock lock = contextEventList.getReadWriteLock().writeLock();
            lock.lock();
            Context item = (Context)observable;
            int index = contextEventList.indexOf(item);
            if (index > -1) {
                contextEventList.set(index, item);
            }
            lock.unlock();
        }
        contextTable.invalidate();
        contextTable.repaint();
    }
    
    private final Data data;
    private final ContextNodeProvider contextProvider;
    private JXTable contextTable;
    private ContextsTableFormat contextTableFormat;
    private Collection<Context> contextList;
    private EventList<Context> contextEventList;
    private EventSelectionModel<Context> selectionModel;
    private EventTableModel<Context> contextEventTableModel;
    private ListSelectionModel tableSelectionModel;
    private SortedList<Context> contextSortedList;
    private TableComparatorChooser<Context> tableSorter;
    private ContextDialog contextDialog;
    
}
