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

package tr.view.future.screen;

import ca.odell.glazedlists.BasicEventList;
import ca.odell.glazedlists.EventList;
import ca.odell.glazedlists.FilterList;
import ca.odell.glazedlists.SortedList;
import ca.odell.glazedlists.matchers.MatcherEditor;
import ca.odell.glazedlists.swing.EventSelectionModel;
import ca.odell.glazedlists.swing.EventTableModel;
import ca.odell.glazedlists.swing.TableComparatorChooser;
import ca.odell.glazedlists.util.concurrent.Lock;
import java.awt.BorderLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Vector;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import org.jdesktop.swingx.JXTable;
import org.jdesktop.swingx.table.TableColumnExt;
import org.openide.util.actions.SystemAction;
import tr.model.Data;
import tr.model.DataLookup;
import tr.model.future.Future;
import tr.model.topic.Topic;
import tr.model.util.Manager;
import tr.util.Observable;
import tr.util.Observer;
import tr.view.future.FutureDeleteAction;
import tr.view.future.FutureEditAction;

/**
 * Panel for future items table.
 *
 * @author <a href="mailto:jimoore@netspace.net.au">Jeremy Moore</a>
 */
public class FuturesPanel extends JPanel implements ListSelectionListener, Observer {
    
    /**
     * Creates a new instance for the given future item provider and filters.
     */
    public FuturesPanel(FutureNodeProvider futuresProvider, MatcherEditor matcherEditor) {
        super();
        this.refsProvider = futuresProvider;
        this.refsMatcherEditor = matcherEditor;
        this.data = (Data)DataLookup.instance().lookup(Data.class);
        initComponents();
    }
    
    private void initComponents() {
        initTable();
        initPanel();
    }
    
    private void initTable() {
        if (data == null) return;
        
        refsList = data.getFutureManager().list();
        
        refsEventList = new BasicEventList<Future>();
        refsEventList.addAll(refsList);
        
        FilterList refsFilterList = new FilterList(refsEventList, refsMatcherEditor);
        
        data.getFutureManager().addObserver(this);
        
        refsSortedList = new SortedList<Future>(refsFilterList);
        refsTableFormat = new FuturesTableFormat();
        refsTableModel = new EventTableModel<Future>(refsSortedList, refsTableFormat);
        
        futuresTable = new JXTable(refsTableModel);
        futuresTable.getTableHeader().setDefaultRenderer(new JTableHeader().getDefaultRenderer());
        futuresTable.getSelectionMapper().setEnabled(false);
        futuresTable.setSortable(false);
        futuresTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        futuresTable.setColumnControlVisible(true);
        futuresTable.setColumnSelectionAllowed(false);
        futuresTable.setCellSelectionEnabled(false);
        futuresTable.setRowSelectionAllowed(true);
        futuresTable.setShowGrid(false);
        futuresTable.setShowHorizontalLines(false);
        futuresTable.setShowVerticalLines(false);
//      futuresTable.setGridColor(Color.lightGray);
        
        selectionModel = new EventSelectionModel<Future>(refsSortedList);
        selectionModel.addListSelectionListener(this);
        selectionModel.setSelectionMode(EventSelectionModel.SINGLE_SELECTION);
        selectionModel.setEnabled(true);
        futuresTable.setSelectionModel(selectionModel);
        
        for (int c = 0; c < refsTableFormat.getColumnCount(); c++) {
            futuresTable.getColumnModel().getColumn(c).setPreferredWidth(refsTableFormat.getColumnWidth(c));
        }
        
        futuresTable.setDefaultRenderer(FuturesTableFormat.ColoredDate.class,
                new FuturesTableFormat.ColoredDateRenderer());
        futuresTable.setDefaultRenderer(FuturesTableFormat.ColoredString.class,
                new FuturesTableFormat.ColoredStringRenderer());
        futuresTable.setDefaultRenderer(Topic.class,
                new FuturesTableFormat.TopicRenderer());
        
        tableSorter = new TableComparatorChooser(futuresTable, refsSortedList, true);
        
        futuresTable.addKeyListener(new KeyAdapter() {
            @Override
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
        futuresTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    edit();
                }
            }
        });
    }
    
    private void initPanel() {
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(futuresTable);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
    }
    
    /** Edit the selected item. */
    private void edit() {
        SystemAction.get(FutureEditAction.class).actionPerformed(null);
    }
    
    /** Delete the selected item. */
    private void delete() {
        SystemAction.get(FutureDeleteAction.class).actionPerformed(null);
    }
    
    /**
     * Handle table selection change by calling provider for the new selection.
     * @param e The list selection event.
     */
    public void valueChanged(ListSelectionEvent e) {
        if (e.getValueIsAdjusting()) return;
        
        Collection<FutureNode> nodes = new Vector<FutureNode>();
        
        for (Future future : selectionModel.getSelected()) {
            nodes.add(new FutureNode(future));
        }
        
        refsProvider.provide(nodes);
    }
    
    /** Handle future item add, remove and change events. */
    public void update(final Observable observable, final Object object) {
        if (object instanceof Manager.EventAdd) {
            Manager.EventAdd event = (Manager.EventAdd)object;
            Lock lock = refsEventList.getReadWriteLock().writeLock();
            lock.lock();
            refsEventList.add((Future)event.item);
            lock.unlock();
        } else if (object instanceof Manager.EventRemove) {
            Manager.EventRemove event = (Manager.EventRemove)object;
            Lock lock = refsEventList.getReadWriteLock().writeLock();
            lock.lock();
            refsEventList.remove(event.item);
            lock.unlock();
        } else if (observable instanceof Future) {
            if (object == Future.Change.NOTES) return;
            
            Lock lock = refsEventList.getReadWriteLock().writeLock();
            lock.lock();
            Future future = (Future)observable;
            int index = refsEventList.indexOf(future);
            if (index > -1) {
                refsEventList.set(index, future);
            }
            lock.unlock();
        }
        futuresTable.invalidate();
        futuresTable.repaint();
    }
    
    /** Preferences for the panel. */
    static class Preferences implements Serializable {
        private static final long serialVersionUID = 43433L;
        private final int[] modelIndex;
        private final int[] columnWidth;
        private final boolean[] columnVisible;
        private final int[] columnOrder;
        private final List<Integer> sortingColumns;
        private final List<Boolean> sortingReverse;
        // constructor saves preferences
        private Preferences(FuturesPanel panel) {
            JXTable table = panel.futuresTable;
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
        
        private void restore(FuturesPanel panel) {
            if (panel == null) return;
            if (panel.futuresTable == null) return;
            if (panel.refsTableFormat == null) return;
            // restore column widths and visibility:
            for (int i = 0; i < modelIndex.length; i++) {
                String id = panel.refsTableFormat.getColumnName(modelIndex[i]);
                TableColumnExt tce = panel.futuresTable.getColumnExt(id);
                if (panel.refsTableFormat.isResizable(modelIndex[i])) {
                    tce.setPreferredWidth(columnWidth[i]);
                } else {
                    int w = panel.refsTableFormat.getColumnWidth(modelIndex[i]);
                    tce.setMaxWidth(w);
                    tce.setMinWidth(w);
                }
                tce.setVisible(columnVisible[i]);
            }
            // restore column order:
            Object[] ids = new Object[columnOrder.length];
            for (int i = 0; i < ids.length; i++) {
                ids[i] = panel.refsTableFormat.getColumnName(columnOrder[i]);
            }
            panel.futuresTable.setColumnSequence(ids);
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
    
    private final static Logger LOG = Logger.getLogger("tr.view.future");
    
    private final FutureNodeProvider refsProvider;
    private final MatcherEditor refsMatcherEditor;
    private final Data data;
    
    private JXTable futuresTable;
    private FuturesTableFormat refsTableFormat;
    private EventTableModel<Future> refsTableModel;
    private Collection<Future> refsList;
    private EventList<Future> refsEventList;
    private EventSelectionModel<Future> selectionModel;
    private SortedList<Future> refsSortedList;
    private TableComparatorChooser<Future> tableSorter;
}
