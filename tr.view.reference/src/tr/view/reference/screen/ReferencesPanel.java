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

package tr.view.reference.screen;

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
import tr.model.information.Information;
import tr.model.topic.Topic;
import tr.model.util.Manager;
import tr.util.Observable;
import tr.util.Observer;
import tr.view.reference.ReferenceDeleteAction;
import tr.view.reference.ReferenceEditAction;

/**
 * Panel for referenced information table.
 *
 * @author <a href="mailto:jimoore@netspace.net.au">Jeremy Moore</a>
 */
public class ReferencesPanel extends JPanel implements ListSelectionListener, Observer {
    
    /**
     * Creates a new instance for the given reference provider and filters.
     */
    public ReferencesPanel(ReferenceNodeProvider refsProvider, MatcherEditor matcherEditor) {
        super();
        this.refsProvider = refsProvider;
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
        
        refsList = data.getInformationManager().list();
        
        refsEventList = new BasicEventList<Information>();
        refsEventList.addAll(refsList);
        
        FilterList refsFilterList = new FilterList(refsEventList, refsMatcherEditor);
        
        data.getInformationManager().addObserver(this);
        
        refsSortedList = new SortedList<Information>(refsFilterList);
        refsTableFormat = new ReferencesTableFormat();
        refsTableModel = new EventTableModel<Information>(refsSortedList, refsTableFormat);
        
        refsTable = new JXTable(refsTableModel);
        refsTable.getTableHeader().setDefaultRenderer(new JTableHeader().getDefaultRenderer());
        refsTable.getSelectionMapper().setEnabled(false);
        refsTable.setSortable(false);
        refsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        refsTable.setColumnControlVisible(true);
        refsTable.setColumnSelectionAllowed(false);
        refsTable.setCellSelectionEnabled(false);
        refsTable.setRowSelectionAllowed(true);
        refsTable.setShowGrid(false);
        refsTable.setShowHorizontalLines(false);
        refsTable.setShowVerticalLines(false);
//      refsTable.setGridColor(Color.lightGray);
        
        selectionModel = new EventSelectionModel<Information>(refsSortedList);
        selectionModel.addListSelectionListener(this);
        selectionModel.setSelectionMode(EventSelectionModel.SINGLE_SELECTION);
        selectionModel.setEnabled(true);
        refsTable.setSelectionModel(selectionModel);
        
        for (int c = 0; c < refsTableFormat.getColumnCount(); c++) {
            refsTable.getColumnModel().getColumn(c).setPreferredWidth(refsTableFormat.getColumnWidth(c));
        }
        
        refsTable.setDefaultRenderer(ReferencesTableFormat.ColoredDate.class,
                new ReferencesTableFormat.ColoredDateRenderer());
        refsTable.setDefaultRenderer(ReferencesTableFormat.ColoredString.class,
                new ReferencesTableFormat.ColoredStringRenderer());
        refsTable.setDefaultRenderer(Topic.class,
                new ReferencesTableFormat.TopicRenderer());
        
        tableSorter = new TableComparatorChooser(refsTable, refsSortedList, true);
        
        refsTable.addKeyListener(new KeyAdapter() {
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
        refsTable.addMouseListener(new MouseAdapter() {
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
        scrollPane.setViewportView(refsTable);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
    }
    
    /** Edit the selected item. */
    private void edit() {
        SystemAction.get(ReferenceEditAction.class).actionPerformed(null);
    }
    
    /** Delete the selected item. */
    private void delete() {
        SystemAction.get(ReferenceDeleteAction.class).actionPerformed(null);
    }
    
    /**
     * Handle table selection change by calling provider for the new selection.
     * @param e The list selection event.
     */
    public void valueChanged(ListSelectionEvent e) {
        if (e.getValueIsAdjusting()) return;
        
        Collection<ReferenceNode> nodes = new Vector<ReferenceNode>();
        
        for (Information info : selectionModel.getSelected()) {
            nodes.add(new ReferenceNode(info));
        }
        
        refsProvider.provide(nodes);
    }
    
    /** Handle information add, remove and change events. */
    public void update(final Observable observable, final Object object) {
        if (object instanceof Manager.EventAdd) {
            Manager.EventAdd event = (Manager.EventAdd)object;
            Lock lock = refsEventList.getReadWriteLock().writeLock();
            lock.lock();
            refsEventList.add((Information)event.item);
            lock.unlock();
        } else if (object instanceof Manager.EventRemove) {
            Manager.EventRemove event = (Manager.EventRemove)object;
            Lock lock = refsEventList.getReadWriteLock().writeLock();
            lock.lock();
            refsEventList.remove(event.item);
            lock.unlock();
        } else if (observable instanceof Information) {
            if (object == Information.Change.NOTES) return;
            
            Lock lock = refsEventList.getReadWriteLock().writeLock();
            lock.lock();
            Information item = (Information)observable;
            int index = refsEventList.indexOf(item);
            if (index > -1) {
                refsEventList.set(index, item);
            }
            lock.unlock();
        }
        refsTable.invalidate();
        refsTable.repaint();
    }
    
    /** Preferences for the panel. */
    static class Preferences implements Serializable {
        private static final long serialVersionUID = 943043L;
        private final int[] modelIndex;
        private final int[] columnWidth;
        private final boolean[] columnVisible;
        private final int[] columnOrder;
        private final List<Integer> sortingColumns;
        private final List<Boolean> sortingReverse;
        // constructor saves preferences
        private Preferences(ReferencesPanel panel) {
            JXTable table = panel.refsTable;
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
        
        private void restore(ReferencesPanel panel) {
            if (panel == null) return;
            if (panel.refsTable == null) return;
            if (panel.refsTableFormat == null) return;
            // restore column widths and visibility:
            for (int i = 0; i < modelIndex.length; i++) {
                String id = panel.refsTableFormat.getColumnName(modelIndex[i]);
                TableColumnExt tce = panel.refsTable.getColumnExt(id);
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
            panel.refsTable.setColumnSequence(ids);
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
    
    private final static Logger LOG = Logger.getLogger("tr.view.reference");
    
    private final ReferenceNodeProvider refsProvider;
    private final MatcherEditor refsMatcherEditor;
    private final Data data;
    
    private JXTable refsTable;
    private ReferencesTableFormat refsTableFormat;
    private EventTableModel<Information> refsTableModel;
    private Collection<Information> refsList;
    private EventList<Information> refsEventList;
    private EventSelectionModel<Information> selectionModel;
    private SortedList<Information> refsSortedList;
    private TableComparatorChooser<Information> tableSorter;
}
