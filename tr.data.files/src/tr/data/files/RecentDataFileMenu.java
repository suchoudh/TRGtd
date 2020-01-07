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
package tr.data.files;

import java.awt.event.ActionEvent;
import java.util.Vector;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import org.openide.awt.Actions;
import org.openide.util.NbBundle;
import org.openide.util.actions.SystemAction;

/**
 * Recent data files menu.
 *
 * @author Jeremy Moore (jimoore@netspace.net.au)
 */
public class RecentDataFileMenu extends Actions.MenuItem {

    private JComponent[] presenters;

    /** Constructs a new instance. */
    public RecentDataFileMenu() {
        super(new FakeAction(), false);
    }

    @Override
    public JComponent[] getMenuPresenters() {
        if (presenters == null) {
            initialise();
        }
        return presenters;
    }

    @Override
    public JComponent[] synchMenuPresenters(JComponent[] items) {
        return getMenuPresenters();
    }

    /** Initialise menu presenters. */
    void initialise() {
        Vector<String> paths = Prefs.getPaths();
        if (paths == null || paths.size() == 0) {
            JMenuItem menuItem = new JMenuItem(NbBundle.getMessage(RecentDataFileMenu.class, "open.recent"));
            menuItem.setEnabled(false);
            presenters = new JComponent[]{menuItem};
        } else {
            JMenu menu = new JMenu(NbBundle.getMessage(RecentDataFileMenu.class, "open.recent"));
            for (String path : paths) {
                menu.add(new RecentDataFileOpenAction(path));
            }
            menu.add(new JSeparator());
            menu.add(SystemAction.get(RecentDataFilesClearAction.class));
            presenters = new JComponent[]{menu};
        }
    }

    private static class FakeAction extends AbstractAction {
        public void actionPerformed(ActionEvent actionEvent) {
        }
    }
}
