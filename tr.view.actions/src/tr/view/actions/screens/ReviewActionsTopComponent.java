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
import au.com.thinkingrock.tr.resource.Icons;
import au.com.trgtd.tr.appl.Constants;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.Timer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import org.apache.commons.lang.StringEscapeUtils;
import org.openide.awt.Toolbar;
import org.openide.util.HelpCtx;
import org.openide.util.Lookup;
import org.openide.util.LookupEvent;
import org.openide.util.LookupListener;
import org.openide.util.NbBundle;
import org.openide.util.actions.SystemAction;
import org.openide.util.lookup.AbstractLookup;
import org.openide.util.lookup.InstanceContent;
import org.openide.windows.TopComponent;
import org.openide.windows.WindowManager;
import tr.extract.Extract;
import tr.extract.Param;
import tr.extract.XSLFO;
import tr.model.Data;
import tr.model.DataLookup;
import tr.model.action.Action;
import tr.model.action.ActionStateScheduled;
import tr.prefs.gui.GUIPrefs;
import tr.swing.StyledString;
import tr.util.HTML;
import tr.view.ReprocessAction;
import tr.view.Window;
import tr.view.actions.prefs.ActionsPrefs;
import tr.view.actions.screens.columns.ActionsColumn;
import tr.view.actions.screens.filters.ActionsFilter;
import tr.view.contexts.ContextChangeAction;
import tr.view.projects.PostponeActionAction;
import tr.view.topics.TopicChangeAction;

/**
 * Top component for the review actions windows.
 *
 * @author <a href="mailto:jimoore@netspace.net.au">Jeremy Moore</a>
 */
public final class ReviewActionsTopComponent extends Window implements ActionsProvider, ItemCountShower {

    private final static String PREFERRED_ID = "ReviewActionsTopComponent";
    private final static Logger LOG = Logger.getLogger("tr.view.actions");
    private final ComponentListener windowListener = new WindowListener();
    private final InstanceContent content = new InstanceContent();
    private final ActionsScreen screen;
    private final ReviewActionsFilters filters;
    private ReviewActionsPanel panel;
    private JToolBar toolbar;
    private JToggleButton viewFiltersButton;
    private JButton editFiltersButton;
    private JButton editColumnsButton;
    private JButton pdfButton;
    private JSplitPane splitPane;
    private Lookup lookup;
    private Lookup.Result dataLookupResult;
    private boolean activated;    

    private ReviewActionsTopComponent(ActionsScreen screen) {
        this.screen = screen;
        this.filters = new ReviewActionsFilters(screen);
        setName(screen.toString());
        setToolTipText(NbBundle.getMessage(ReviewActionsTopComponent.class, "TTT_ReviewActionsTopComponent"));
        setIcon(Icons.Actions.getImage());
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(new java.awt.BorderLayout());

    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    /**
     * Create a ReviewActionsTopComponent instance.
     */
    public static synchronized ReviewActionsTopComponent createInstance(ActionsScreen screen) {
        return new ReviewActionsTopComponent(screen);
    }

    @Override
    public int getPersistenceType() {
        return TopComponent.PERSISTENCE_NEVER;
    }

    @Override
    protected void componentOpened() {
        super.componentOpened();

        // initialise panel if necessary
        if (panel == null) {
            removeAll();

            getToolBar();

            String position = GUIPrefs.getButtonsPosition();
            if (position.equals(GUIPrefs.BUTTONS_POSITION_TOP)) {
                toolbar.setOrientation(JToolBar.HORIZONTAL);
                add(toolbar, BorderLayout.NORTH);
            } else if (position.equals(GUIPrefs.BUTTONS_POSITION_BOTTOM)) {
                toolbar.setOrientation(JToolBar.HORIZONTAL);
                add(toolbar, BorderLayout.SOUTH);
            } else if (position.equals(GUIPrefs.BUTTONS_POSITION_LEFT)) {
                toolbar.setOrientation(JToolBar.VERTICAL);
                add(toolbar, BorderLayout.WEST);
            } else if (position.equals(GUIPrefs.BUTTONS_POSITION_RIGHT)) {
                toolbar.setOrientation(JToolBar.VERTICAL);
                add(toolbar, BorderLayout.EAST);
            }

            panel = new ReviewActionsPanel(screen, this, filters, this, this);

            splitPane = new JSplitPane();
            splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
            splitPane.setTopComponent(filters.getPanel());
            splitPane.setBottomComponent(panel);
            splitPane.setBorder(BorderFactory.createEmptyBorder());
            splitPane.setDividerSize(0);
            splitPane.setDividerLocation(0);
            add(splitPane, BorderLayout.CENTER);
        }

        panel.refresh();

        // data lookup listener to force panel initialisation if data changes
        if (dataLookupResult == null) {
            dataLookupResult = DataLookup.instance().lookup(new Lookup.Template(Data.class));
            dataLookupResult.addLookupListener(new LookupListener() {

                public void resultChanged(LookupEvent lookupEvent) {
                    removeAll();
                    if (panel != null) {
                        panel.save();
                        panel = null;
                    }
                }
            });
        }
    }

    @Override
    protected void componentActivated() {
        super.componentActivated();
        if (panel != null) {
            panel.view();
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                showHideFilters();
                if (panel != null) {
                    panel.takeFocus();
                }
            }
        });
        activated = true;
    }

    @Override
    protected void componentClosed() {
        removeAll();
        if (activated && panel != null) {
            panel.save();
        }
        super.componentClosed();
    }

    @Override
    public String preferredID() {
        return PREFERRED_ID;
    }

    @Override
    public Lookup getLookup() {
        if (panel == null) {
            return super.getLookup();
        }
        if (lookup == null) {
            lookup = new AbstractLookup(content);
            content.set(Collections.singleton(panel), null);
        }
        return lookup;
    }

    @Override
    public HelpCtx getHelpCtx() {
        return new HelpCtx("review.actions");
    }

    /** Shows the number of items in the title. */
    public void showItemCount(final int count) {
        EventQueue.invokeLater(new Runnable() {

            public void run() {
                setName(screen.toString() + " (" + count + ")");
            }
        });
    }

    private JToolBar getToolBar() {
        if (toolbar == null) {
            SystemAction[] actions = new SystemAction[] {
                null,
                SystemAction.get(ReprocessAction.class),
                SystemAction.get(PostponeActionAction.class),                
                SystemAction.get(ContextChangeAction.class),
                SystemAction.get(TopicChangeAction.class),
                SystemAction.get(SetDoneAction.class),
                SystemAction.get(DeleteAction.class),
            };
            toolbar = SystemAction.createToolbarPresenter(actions);
            viewFiltersButton = new JToggleButton();
            viewFiltersButton.setSelected(screen.isShowFilters());
            viewFiltersButton.setAction(new ViewFiltersAction());
            toolbar.add(viewFiltersButton, 0);
            editFiltersButton = new JButton(new EditFiltersAction());
            toolbar.add(editFiltersButton, 0);
            editColumnsButton = new JButton(new EditColumnsAction());
            toolbar.add(editColumnsButton, 0);
            pdfButton = new JButton(new PDFAction());
            toolbar.add(pdfButton, 0);
            toolbar.setUI((new Toolbar()).getUI());
            toolbar.setFloatable(false);

            Dimension buttonSize = Constants.TOOLBAR_BUTTON_SIZE;
            for (Component component : toolbar.getComponents()) {
                if (component instanceof AbstractButton) {
                    component.setPreferredSize(buttonSize);
                    component.setMinimumSize(buttonSize);
                    component.setMaximumSize(buttonSize);
                    component.setSize(buttonSize);
                }
            }
        }
        return toolbar;
    }

    private void showHideFilters() {
        if (viewFiltersButton.isSelected()) {
            splitPane.setDividerLocation(getFiltersHeight());
        } else {
            splitPane.setDividerLocation(0);
        }
    }

    private synchronized int getFiltersHeight() {
        try {
            int n = filters.getPanel().getComponentCount();
            if (n <= 0) {
                return 0;
            }
            int tw = panel.getWidth();
            if (tw <= 0) {
                return 0;
            }
            int cw = filters.getComponentWidth() + 1;
            if (cw <= 0) {
                return 0;
            }
            int ch = filters.getComponentHeight() + 1;
            if (ch <= 0) {
                return 0;
            }

            int h = 2;

            while (n > 0) {
                h += ch;
                n -= (tw / cw);
            }

            return h;

        } catch (NullPointerException ex) {
            return 0;
        }
    }

    private class ViewFiltersAction extends AbstractAction {
        public ViewFiltersAction() {
            super("", Icons.FiltersView);
            putValue(SHORT_DESCRIPTION, NbBundle.getMessage(getClass(), "CTL_ViewFiltersAction"));
        }
        public void actionPerformed(ActionEvent e) {
            EventQueue.invokeLater(new Runnable() {

                public void run() {
                    screen.setShowFilters(viewFiltersButton.isSelected());
                    showHideFilters();
                }
            });
        }
    }

    private class EditFiltersAction extends AbstractAction {
        public EditFiltersAction() {
            super("", Icons.FiltersEdit);
            putValue(SHORT_DESCRIPTION, NbBundle.getMessage(getClass(), "CTL_EditFiltersAction"));
        }
        public void actionPerformed(final ActionEvent e) {
            EventQueue.invokeLater(new Runnable() {
                public void run() {
                    FiltersDialog dialog = new FiltersDialog(screen);
                    dialog.setLocationRelativeTo((Component) e.getSource());
                    int result = dialog.showDialog();
                    if (result == JOptionPane.OK_OPTION) {
                        panel.refresh();
                        splitPane.setTopComponent(filters.getPanel(true));
                        showHideFilters();
                    }
                }
            });
        }
    }

    private class EditColumnsAction extends AbstractAction {
        public EditColumnsAction() {
            super("", Icons.ColumnsEdit);
            putValue(SHORT_DESCRIPTION, NbBundle.getMessage(getClass(), "CTL_EditColumnsAction"));
        }
        public void actionPerformed(final ActionEvent e) {
            EventQueue.invokeLater(new Runnable() {
                public void run() {
                    ColumnsDialog dialog = new ColumnsDialog(screen);
                    dialog.setLocationRelativeTo((Component) e.getSource());
                    dialog.setVisible(true);
                    panel.refreshColumns();
                    panel.validate();
                    panel.repaint();
                }
            });
        }
    }

    private class PDFAction extends AbstractAction {
        public PDFAction() {
            super("", Icons.PDF);
            putValue(SHORT_DESCRIPTION, NbBundle.getMessage(getClass(), "CTL_PDFAction"));
        }
        public void actionPerformed(final ActionEvent e) {
            EventQueue.invokeLater(new Runnable() {
                public void run() {
                    try {
                        printPDF();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            });
        }
    }

    private void printPDF() throws Exception {
        // get extract file
        String prefix = "tr-actions-screen-";
        String timestamp = Extract.getTimeStamp();
        File xmlfile = Extract.getTmpFile(prefix + timestamp + ".xml");
        File outfile = Extract.getOutFile(prefix + timestamp + ".pdf");
        URL xslfo = getClass().getResource("tr-actions-screen.fo.xml");
        List<Param> params = new Vector<Param>();
        params.add(new Param("font", ActionsPrefs.getReportFont()));
        extractData(xmlfile);
        XSLFO.transform(xmlfile, xslfo.openStream(), params, outfile);
        Extract.openFile(outfile);
    }
    private static final DateFormat DF = new SimpleDateFormat("dd MMM yyyy");
    private static final String EOL = "\r\n";

    private void extractData(File xmlfile) throws Exception {

        boolean useColour = ActionsPrefs.isReportUseColour();
        boolean strikeDone = ActionsPrefs.isReportStrikeDone();

        if (xmlfile.exists()) {
            xmlfile.delete();
        }
        OutputStream fout = new FileOutputStream(xmlfile);
        OutputStream bout = new BufferedOutputStream(fout);
        OutputStreamWriter out = new OutputStreamWriter(bout, "UTF-8");

//        TableFormat tableFormat = panel.getTableFormat();

        out.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + EOL);
        out.write("<actions-screen>" + EOL);

        Calendar calendar = Calendar.getInstance();
        out.write("<date>" + DF.format(calendar.getTime()) + "</date>" + EOL);
        out.write("<title>" + escape(getName()) + "</title>" + EOL);

        if (viewFiltersButton.isSelected()) {
            out.write("<filters>" + EOL);
            for (ActionsFilter filter : screen.getFilters()) {
                Object value = filter.getFilterCombo().getSelectedItem();
                if (value != null) {
                    out.write("<filter>" + EOL);
                    out.write("<label>" + escape(filter.getLabel()) + "</label>" + EOL);
                    out.write("<value>" + escape(value.toString()) + "</value>" + EOL);
                    out.write("</filter>" + EOL);
                }
            }
            out.write("</filters>" + EOL);
        }

        out.write("<table>" + EOL);

        out.write("<widths>" + EOL);

        JTable table = panel.actionsTable;
        TableColumnModel tcm = table.getColumnModel();

        float totalWidth = table.getColumnModel().getTotalColumnWidth();

        totalWidth -= ((tcm.getColumnCount() - 1) * 2);

        for (int i = 0; i < tcm.getColumnCount(); i++) {
            TableColumn tc = tcm.getColumn(i);
            int width = (int) ((tc.getWidth() / totalWidth) * 277.0f);
            out.write("<column>" + width + "mm" + "</column>" + EOL);
        }
        out.write("</widths>" + EOL);

        out.write("<headings>" + EOL);
        for (int i = 0; i < tcm.getColumnCount(); i++) {
            TableColumn tc = tcm.getColumn(i);
            int col = tcm.getColumn(i).getModelIndex();
            Class clazz = table.getModel().getColumnClass(col);
            if (clazz == Boolean.class || clazz == Icon.class) {
                out.write("<column></column>" + EOL);
            } else {
                out.write("<column>" + escape(tc.getHeaderValue().toString()) + "</column>" + EOL);
            }
        }
        out.write("</headings>" + EOL);

        int rows = table.getModel().getRowCount();
        int cols = table.getModel().getColumnCount();
        for (int row = 0; row < rows; row++) {
            out.write("<row>" + EOL);
            for (int i = 0; i < tcm.getColumnCount(); i++) {
                int col = tcm.getColumn(i).getModelIndex();
                Object value = table.getModel().getValueAt(row, col);

                String fg = "black";
                String bg = "white";
                boolean strike = false;

                if (value instanceof StyledString) {
                    StyledString ss = (StyledString) value;
                    if (useColour) {
                        fg = HTML.format(ss.getForeground());
                        bg = HTML.format(ss.getBackground());
                    }
                    if (strikeDone) {
                        strike = ss.isStrike();
                    }
                }

                String type = "";
                String symbol = "";
                if (value instanceof Boolean) {
                    type = "boolean";
                } else if (value instanceof Icon) {
                    type = "icon";
                    if (col == ActionsColumn.INDEX_ICON) {
                        symbol = getType(panel.actionsSortedList.get(row));
                    } else if (col == ActionsColumn.INDEX_FROM_ICON) {
                        symbol = getFromType(panel.actionsSortedList.get(row));
                    }
                }
//              out.write("<col type='" + type + "' symbol='" + symbol + "'>"  + (value == null ? "" : escape(value.toString())) + "</col>"  + EOL);
                out.write("<col type='" + type + "' symbol='" + symbol + "' fg='" + fg + "' bg='" + bg + "' strike='" + Boolean.toString(strike) + "'>" + (value == null ? "" : escape(value.toString())) + "</col>" + EOL);
            }
            out.write("</row>" + EOL);
        }

        out.write("</table>" + EOL);

        out.write("</actions-screen>" + EOL);
        out.close();
    }

    private String escape(String string) {
        return StringEscapeUtils.escapeXml(string);
    }

    private String getType(Action action) {
        if (action.isStateASAP()) {
            return "doasap";    // "\u26A1";

        } else if (action.isStateDelegated()) {
            return "delegated"; //  "\u261E";

        } else if (action.isStateScheduled()) {
//          return "scheduled"; // "\u2637";
            ActionStateScheduled ss = (ActionStateScheduled) action.getState();
            return (ss.getRecurrence() == null ? "scheduled" : "recurrent");
        } else if (action.isStateInactive()) {
            return "inactive";  // "\u2307";

        } else {
            return "";
        }
    }

    private String getFromType(Action action) {
        if (action.isSingleAction()) {
            return (action.getThought() == null) ? "" : "thought";  // "\u26AA";

        } else {
            return (action.getParent() == null) ? "" : "project";   // "\u2630";

        }
    }

    @Override
    protected void componentHidden() {
        super.componentHidden();
        JFrame frame = (JFrame) WindowManager.getDefault().getMainWindow();
        frame.removeComponentListener(windowListener);
    }

    @Override
    protected void componentShowing() {
        super.componentShowing();
        JFrame frame = (JFrame) WindowManager.getDefault().getMainWindow();
        frame.addComponentListener(windowListener);
    }

    public class WindowListener implements ComponentListener {

        private final static int DELAY = 1000;
        private final Timer timer;

        public WindowListener() {
            timer = new Timer(DELAY, new AbstractAction() {

                public void actionPerformed(ActionEvent e) {
                    doAction();
                }
            });
            timer.setRepeats(false);
        }

        private void doAction() {
            EventQueue.invokeLater(new Runnable() {

                public void run() {
                    showHideFilters();
                }
            });
        }

        public void componentResized(ComponentEvent e) {
            timer.start();
        }

        public void componentMoved(ComponentEvent e) {
        }

        public void componentShown(ComponentEvent e) {
        }

        public void componentHidden(ComponentEvent e) {
        }
    }

    public void provide(final List<Action> actions) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                Collection collection = new Vector();                
                if (panel != null) {
                    collection.add(panel);
                }
                if (actions != null) {
                    for (Action action : actions) {
                        collection.add(new ActionNode(action));                        
                    }
                }
                content.set(collection, null);
            };
        });
    }
        
}
