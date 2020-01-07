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

import tr.view.DeleteAction;
import ca.odell.glazedlists.BasicEventList;
import ca.odell.glazedlists.EventList;
import ca.odell.glazedlists.FilterList;
import ca.odell.glazedlists.SortedList;
import ca.odell.glazedlists.event.ListEvent;
import ca.odell.glazedlists.event.ListEventListener;
import ca.odell.glazedlists.gui.TableFormat;
import ca.odell.glazedlists.matchers.CompositeMatcherEditor;
import ca.odell.glazedlists.matchers.MatcherEditor;
import ca.odell.glazedlists.swing.EventSelectionModel;
import ca.odell.glazedlists.swing.EventTableModel;
import ca.odell.glazedlists.swing.TableComparatorChooser;
import ca.odell.glazedlists.util.concurrent.Lock;
import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import org.jdesktop.swingx.JXTable;
import org.openide.nodes.Node;
import org.openide.util.actions.SystemAction;
import org.openide.windows.TopComponent;
import tr.model.Data;
import tr.model.DataLookup;
import tr.model.action.Action;
import tr.model.project.Project;
import tr.services.Services;
import tr.swing.StyledString;
import tr.swing.StyledStringRenderer;
import tr.util.LazyNotifier;
import tr.util.Observable;
import tr.util.Observer;
import tr.view.actions.RAProjectsTreeTopComponent;
import tr.view.actions.RASingleActionsTopComponent;
import tr.view.actions.prefs.ActionsPrefs;
import tr.view.actions.screens.filters.FilterDone;
import tr.view.actions.screens.columns.ActionsColumn;
import tr.view.actions.screens.filters.ActionsFilter;
import tr.view.collect.AddThoughtsAction;
import tr.view.projects.ProjectsTreeTopComponent;
import tr.view.projects.actions.SingleActionsTopComponent;

/**
 * Review actions panel.
 *
 * @author <a href="mailto:jimoore@netspace.net.au">Jeremy Moore</a>
 */
public class ReviewActionsPanel extends JPanel implements ListSelectionListener, Observer {

    /** Creates new form ReviewActionsPanel */
    public ReviewActionsPanel(ActionsScreen screen,
            ItemCountShower itemCountShower,
            ReviewActionsFilters filters,
            ReviewActionsTopComponent tcReviewActions,
            ActionsProvider actionsProvider) {

        this.screen = screen;
        this.itemCountShower = itemCountShower;
        this.filters = filters;
        this.tcReviewActions = tcReviewActions;
        this.actionsProvider = actionsProvider;
        data = (Data) DataLookup.instance().lookup(Data.class);
        tcSingleActions = RASingleActionsTopComponent.findInstance();
        tcProjectsTree = RAProjectsTreeTopComponent.findInstance();
        initComponents();
        selectionNotifier = new LazyNotifier(ActionsPrefs.getViewDelay()) {
            public void changed() {
                view();
            }
        };
    }

    public void takeFocus() {
        if (table != null) {
            table.requestFocusInWindow();
        }
    }

//    private static long tblCounter = 0;
    private void initTable() {
        if (data == null) {
            return;
        }
        actionsList = Services.instance.getAllActions();

        actionsEventList = new BasicEventList<Action>();
        actionsEventList.addAll(actionsList);

        actionsFilterList = new FilterList(actionsEventList, filters.getMatcherEditor());
        actionsFilterList.addListEventListener(new ListEventListener() {
            public void listChanged(ListEvent e) {
                itemCountShower.showItemCount(e.getSourceList().size());
                // fix problem of number of selected rows increasing by clearing 
                selectionModel.clearSelection();
            }
        });

        itemCountShower.showItemCount(actionsFilterList.size());

        Services.instance.addActionsObserver(this);

        actionsSortedList = new SortedList<Action>(actionsFilterList);

        actionsTableFormat = new ReviewActionsTableFormat(screen);

        actionsTableModel = new EventTableModel<Action>(actionsSortedList, actionsTableFormat);
        actionsTable = new JXTable(actionsTableModel);

        actionsTable.getTableHeader().setDefaultRenderer(new JTableHeader().getDefaultRenderer());
        actionsTable.getSelectionMapper().setEnabled(false);

        actionsTable.setSortable(false);

//      actionsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        actionsTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        
        actionsTable.setColumnControlVisible(false);
        actionsTable.setColumnSelectionAllowed(false);
        actionsTable.setCellSelectionEnabled(false);
        actionsTable.setRowSelectionAllowed(true);
        actionsTable.setShowGrid(false);
        actionsTable.setShowHorizontalLines(false);
        actionsTable.setShowVerticalLines(false);
//      actionsTable.setGridColor(Color.lightGray);

        selectionModel = new EventSelectionModel<Action>(actionsSortedList);

        selectionModel.addListSelectionListener(this);

//      selectionModel.setSelectionMode(EventSelectionModel.SINGLE_SELECTION);
        selectionModel.setSelectionMode(EventSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        
        selectionModel.setEnabled(true);
        actionsTable.setSelectionModel(selectionModel);

        // set column information
        for (int c = 0; c < actionsTableFormat.getColumnCount(); c++) {
            TableColumn tc = actionsTable.getColumnModel().getColumn(c);
            tc.setIdentifier(actionsTableFormat.getID(c));
            tc.setResizable(actionsTableFormat.isResizable(c));
            tc.setMinWidth(actionsTableFormat.getMinWidth(c));
            tc.setMaxWidth(actionsTableFormat.getMaxWidth(c));
            tc.setPreferredWidth(actionsTableFormat.getWidth(c));
        }

        // set columns visible
        for (TableColumn tc : actionsTable.getColumns(true)) {
            Byte id = (Byte) tc.getIdentifier();
            ActionsColumn column = screen.getColumns().get(tc.getModelIndex());
            actionsTable.getColumnExt(id).setVisible(column.isVisible());
        }

        actionsTable.setDefaultRenderer(StyledString.class, new StyledStringRenderer());

        tableSorter = new TableComparatorChooser(actionsTable, actionsSortedList, true);

        actionsTable.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getModifiers() != 0) {
                    return;
                }
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    e.consume();
                    edit();
                } else if (e.getKeyCode() == KeyEvent.VK_F6) {
                    e.consume();
                    addThoughts();
                } else if (e.getKeyCode() == KeyEvent.VK_DELETE) {
                    e.consume();
                    delete();
                }
            }
        });
        actionsTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    edit();
                }
            }
        });

        orderColumns();
        sortColumns();
    }
    
    private void delete() {        
        List<Action> selected = selectionModel.getSelected();
        if (selected == null || selected.size() == 0) {
            return;            
        }        
        Node[] nodes = new Node[selected.size()];        
        for (int i = 0; i < selected.size(); i++) {
            nodes[i] = new ActionNode(selected.get(i));
        }        
        SystemAction.get(DeleteAction.class).performAction(nodes);        
    }
    
    private void addThoughts() {
        AddThoughtsAction action = (AddThoughtsAction) SystemAction.get(AddThoughtsAction.class);
        if (action != null) {
            action.performAction();
        }
    }

    private FilterDone getDoneFilter() {
        MatcherEditor matcherEditor = filters.getMatcherEditor();
        if (matcherEditor instanceof CompositeMatcherEditor) {
            CompositeMatcherEditor cme = (CompositeMatcherEditor) matcherEditor;
            for (Object filter : cme.getMatcherEditors().toArray()) {
                if (filter instanceof FilterDone) {
                    return (FilterDone) filter;
                }
            }
        }
        return null;
    }

    private boolean isShowDone() {
        FilterDone doneFilter = getDoneFilter();

        return (doneFilter == null) ? true : doneFilter.isShowDone();
    }

////private JTable getTable() {
    public JTable getTable() {
        initTable();
        return actionsTable;
    }

    public TableFormat getTableFormat() {
        return actionsTableFormat;
    }

//    private Action getSelectedActions() {
//        EventList<Action> selected = selectionModel.getSelected();
//        if (selected.size() > 0) {
//            return selected.get(0);
//        } else {
//            return null;
//        }
//    }

    private void edit() {
        EventQueue.invokeLater(new Runnable() {

            public void run() {
//              Action action = getSelectedActions();
//              if (action == null) {
//                  return;
//              }                
                EventList<Action> selected = selectionModel.getSelected();
                if (selected.size() != 1) {
                    return;
                }               
                Action action = selected.get(0);

                if (action.isSingleAction()) {
                    if (tcSingleActions != null) {
                        tcSingleActions.setShowDone(isShowDone());
                        tcSingleActions.edit(action);
                    }
                } else {
                    if (tcProjectsTree != null) {
                        tcProjectsTree.setShowDone(isShowDone());
                        tcProjectsTree.edit(action);
                    }
                }
            }
        });
    }

    public void view() {
//      Action action = getSelectedActions();
//      if (action == null) {
//          return;
//      }        
        EventList<Action> selected = selectionModel.getSelected();
        if (selected.size() != 1) {
            return;
        }               
        
        Action action = selected.get(0);        
        
        if (action.isSingleAction()) {
            if (tcSingleActions != null) {
//                if (tcSingleActions.isSelected(action)) {
//                    return;
//                } else {
                tcSingleActions.setShowDone(isShowDone());
                tcSingleActions.select(action);
//                }
            }
        } else {
            if (tcProjectsTree != null) {
//                if (tcProjectsTree.isSelected(action)) {
//                    return;
//                } else {
                tcProjectsTree.setShowDone(isShowDone());
                tcProjectsTree.select(action);
//                }                
            }
        }

        // get focus back on table (esp. for MacOSX)
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                table.requestFocusInWindow();
            }
        });
    }

    // Order the columns.
    private void orderColumns() {
        assert (actionsTable != null);

        byte[] order = screen.getColumnOrder();

        assert (order != null);

        TableColumnModel tcm = actionsTable.getColumnModel();

        for (int i = 0; i < order.length; i++) {

            Byte id = new Byte(order[i]);

            int p = tcm.getColumnIndex(id);
            if (p > -1) {
                tcm.moveColumn(p, i);
            }
        }
    }

    // Sort the columns.
    private void sortColumns() {
        byte[] columns = screen.getSortColumns();
        byte[] status = screen.getSortStates();
        if (columns == null || status == null || columns.length != status.length) {
            return;
        }
        for (int i = 0; i < columns.length; i++) {
            try {
                tableSorter.appendComparator(columns[i], 0, ((status[i] == SORT_DESCENDING) ? true : false));
            } catch (Exception ex) {
            }
        }
    }

    /** Save the window state. */
    public void save() {
//        LOG.info("ReviewActionsPanel.save()");
//        LOG.info("ActionsScreen: " + screen.getKey());

        // set visible
        for (TableColumn tc : actionsTable.getColumns(true)) {
            Byte id = (Byte) tc.getIdentifier();
            ActionsColumn column = screen.getColumns().get(tc.getModelIndex());
            column.setVisible(actionsTable.getColumnExt(id).isVisible());
        }

        TableColumnModel tcm = table.getColumnModel();
        TableColumn tc;

        // save column order and widths
        byte[] order = new byte[tcm.getColumnCount()];

        for (int i = 0; i < tcm.getColumnCount(); i++) {

            tc = tcm.getColumn(i);

            order[i] = (byte) tc.getModelIndex();

            screen.getColumns().get(tc.getModelIndex()).setWidth(tc.getWidth());
        }
        screen.setColumnOrder(order);

        // save sorted columns and sort order
        List<Integer> sortColumnsList = tableSorter.getSortingColumns();
        byte[] sortColumns = new byte[sortColumnsList.size()];
        byte[] sortStatus = new byte[sortColumnsList.size()];

        for (int i = 0; i < sortColumnsList.size(); i++) {

            sortColumns[i] = ActionsColumn.COLUMN_INDICES[sortColumnsList.get(i)];

            if (tableSorter.isColumnReverse(sortColumnsList.get(i))) {
                sortStatus[i] = SORT_DESCENDING;
            } else {
                sortStatus[i] = SORT_ASCENDING;
            }
        }
        screen.setSortColumns(sortColumns);
        screen.setSortStatus(sortStatus);
    }

    /**
     * Receiving a table row selection changed event. 
     * @param e The event
     */
    public void valueChanged(ListSelectionEvent e) {
        if (e.getValueIsAdjusting()) {
            return;
        }
        
        actionsProvider.provide(selectionModel.getSelected());        
        
        // hack to stop selection if window is not active
        // TODO: fix selection mechanism properly
        TopComponent tc = (TopComponent)itemCountShower;
        if (!tc.isShowing()) {
            return;
        }
        
        selectionNotifier.fire();
    }

    private void clearSelection() {
        selectionModel.removeListSelectionListener(this);
        selectionModel.clearSelection();
        selectionModel.addListSelectionListener(this);
    }

    /**
     * As an observer of single actions and projects (and their children) we are 
     * receiving notification of a change.
     * @param observable The action or project that has changed.
     * @param argument The change details argument.
     */
    public void update(final Observable observable, final Object argument) {

        if (argument == Action.FIELD.Notes) {
            return;            
        }
        
        EventQueue.invokeLater(new Runnable() {

            public void run() {
                if (observable instanceof Action) {
                    Action observedAction = (Action) observable;                    
                    for (Action selectedAction : selectionModel.getSelected()) {
                        if (selectedAction.getID() != observedAction.getID()) {
                            clearSelection();
                            break;
                        }                       
                    } 
                    refresh();
                    return;
                }

                if (observable instanceof Project) {
                    Project obsProject = (Project) observable;
                    clearSelection();
                    if (argument == null) {
                        // change to project itself
                        actionsTable.validate();
                        actionsTable.repaint();
                        refresh();
                    } else if (argument instanceof Action) {
                        // added or removed action
                        Action action = (Action) argument;
                        Lock lock = actionsEventList.getReadWriteLock().writeLock();
                        lock.lock();
                        if (obsProject.contains(action)) {
                            actionsEventList.add(action);
                            lock.unlock();
                        } else {
                            actionsEventList.remove(action);
                            lock.unlock();
                            selectionModel.clearSelection();
                            actionsProvider.provide(Collections.EMPTY_LIST);  
                        }
                    } else if (argument instanceof Project) {
                        // added or removed project
                        Project argProject = (Project) argument;

                        List<Action> actions = Services.instance.getActionDecendants(argProject);
                        if (actions == null || actions.isEmpty()) {
                            return;
                        }
                        Lock lock = actionsEventList.getReadWriteLock().writeLock();
                        lock.lock();
                        if (obsProject.contains(argProject)) { // added argProject

                            actionsEventList.addAll(actions);
                        } else { // removed argProject

                            actionsEventList.removeAll(actions);
                        }
                        lock.unlock();
                    }
                }
            }
        });
    }

    public void refresh() {

        final ListSelectionListener lsl = this;

        EventQueue.invokeLater(new Runnable() {

            public void run() {
                // remove selection listener to try and avoid the selected table 
                // row from being re-selected and causing view() to be called 
                // (which requests table focus).
                selectionModel.removeListSelectionListener(lsl);

                actionsSortedList.setComparator(actionsSortedList.getComparator());

                // TODO Find a better way to fire update on filters
                for (ActionsFilter filter : screen.getFilters()) {
                    filter.getFilterCombo().fireValueChange();
                }


                // add back selection listener 
                selectionModel.addListSelectionListener(lsl);
            }
        });

    }

    public void refreshColumns() {
        if (actionsTable == null) {
            return;
        }
        for (TableColumn tc : actionsTable.getColumns(true)) {
            Byte id = (Byte) tc.getIdentifier();
            ActionsColumn column = screen.getColumns().get(tc.getModelIndex());
            actionsTable.getColumnExt(id).setVisible(column.isVisible());
        }
    }

    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        tableScrollPane = new javax.swing.JScrollPane();
        table = getTable();

        setLayout(new java.awt.BorderLayout());

        tableScrollPane.setViewportView(table);

        add(tableScrollPane, java.awt.BorderLayout.CENTER);

    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable table;
    private javax.swing.JScrollPane tableScrollPane;
    // End of variables declaration//GEN-END:variables
    private static final Logger LOG = Logger.getLogger("tr.view.actions");
    public static final byte SORT_ASCENDING = 1;
    public static final byte SORT_DESCENDING = 2;
    private static SingleActionsTopComponent tcSingleActions;
    private static ProjectsTreeTopComponent tcProjectsTree;
    private final ReviewActionsTopComponent tcReviewActions;
    private final ActionsScreen screen;
    private final Data data;
    private final ItemCountShower itemCountShower;
    private final ReviewActionsFilters filters;
    private final LazyNotifier selectionNotifier;
    private final ActionsProvider actionsProvider;
    public JXTable actionsTable;
    private ReviewActionsTableFormat actionsTableFormat;
    private EventTableModel<Action> actionsTableModel;
    private Collection<Action> actionsList;
    private EventList<Action> actionsEventList;
    private FilterList<Action> actionsFilterList;
    public SortedList<Action> actionsSortedList;
    private EventSelectionModel<Action> selectionModel;
    private TableComparatorChooser<Action> tableSorter;
}
