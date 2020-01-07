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

package tr.imports.thoughts;

import java.awt.Component;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileFilter;
import org.openide.util.NbBundle;
import org.openide.windows.WindowManager;
import tr.imports.thoughts.prefs.ImportThoughtsPrefs;
import tr.model.Data;
import tr.model.thought.Thought;
import tr.model.topic.Topic;
import tr.model.util.Manager;
import tr.data.FileFilterImpl;

/**
 * Import thoughts from a text file with a format of one thought per line. If a
 * line has a tab then the try to match the text following the last tab with a
 * topic name and set the thought topic. Set the thought description as the text
 * up to the last tab. If a line has no tab or no topic name match then put the
 * entire line as the thought description and set the topic as none.
 *
 * @author Jeremy Moore (jimoore@netspace.net.au)
 */
public class ImportThoughts {
    
    private static Manager<Thought> thoughts;
    private static Manager<Topic> topics;
    
    /**
     * Start the import thoughts action.
     * @param data The data instance to import into.
     * @return false if the import is not done.
     */
    public static final boolean doImport(Data data) throws Exception {
        
        assert(data != null);
        
        thoughts = data.getThoughtManager();
        topics = data.getTopicManager();
        
        // Get user to choose the import file
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle(org.openide.util.NbBundle.getMessage(ImportThoughts.class, "dialog.title"));
        String[] extns = { "txt" };
        FileFilter filter = new FileFilterImpl(org.openide.util.NbBundle.getMessage(ImportThoughts.class, "Text_Files"), extns, true);
        chooser.setFileFilter(filter);
        File def = new File(ImportThoughtsPrefs.getDefaultFilePath());
        chooser.ensureFileIsVisible(def);
        chooser.setSelectedFile(def);
        Component p = WindowManager.getDefault().getMainWindow();
        int option = chooser.showOpenDialog(p);
        if (option != JFileChooser.APPROVE_OPTION) return false;
        
        // make sure the file can be read
        String path = chooser.getSelectedFile().getPath();
        File file = new File(path);
        if (file.exists() && file.isFile() && file.canRead()) {
            System.out.println("Importing thoughts from " + path);
        } else {
            throw new Exception("The file could not be opened and read.");
        }
        
        // warning and confirmation for large files
        if (file.length() > ImportThoughtsPrefs.getWarningFileSize()) {
            String t = NbBundle.getMessage(ImportThoughts.class, "confirm.title");
//            String m = "The file you are importing is large and will result in approximately " + file.length() / 80 + " new thoughts.    \n "
//                    + "Are you sure that you want to continue?";
                        
            String m = NbBundle.getMessage(ImportThoughts.class, "confirm.message", file.length() / 80);
            
            Object[] options = {NbBundle.getMessage(ImportThoughts.class, "Yes"), NbBundle.getMessage(ImportThoughts.class, "No")};
            int n = JOptionPane.showOptionDialog(p, m, t, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
            if (n != JOptionPane.YES_OPTION) return false;
        }
        
        // process each line as a new thought
        int count = 0;
        BufferedReader input = null;
        try {
            input = getReader(file);
            
            String line = null;
            while ((line = input.readLine()) != null) {
                if ( ! line.trim().equals("") ) {
                    System.out.println(NbBundle.getMessage(ImportThoughts.class, "Importing_line") + ": " + line);
                    Thought thought = new Thought(data.getNextID());
                    thought.setDescription(line);
                    int i = line.lastIndexOf('\t');
                    if (i > -1) {
                        String topicName = line.substring(i + 1);
                        Topic topic = getTopic(topicName);
                        if (topic != null) {
                            thought.setDescription(line.substring(0, i));
                            thought.setTopic(getTopic(topicName));
                        }
                    }
                    thoughts.add(thought);
                    count++;
                }
            }
            
            // save file path for default next time
            ImportThoughtsPrefs.setDefaultFilePath(file.getPath());
            
            notifySuccess(count);
        } catch (Exception ex) {
            notifyFailure(ex);
        } finally {
            try {
                if (input != null) {
                    input.close();
                }
            } catch (IOException ex) {
            }
        }
        return true;
    }
    
    /* Gets the topic for a topic name or null if not found. */
    private static Topic getTopic(String name) {
        for (Topic topic : topics.list()) {
            if (topic.getName().equalsIgnoreCase(name)) {
                return topic;
            }
        }
        return null;
    }
    
    private static BufferedReader getReader(File file) throws Exception {
        String encoding = ImportThoughtsPrefs.getEncoding().trim();
        if (encoding == null || encoding.length() == 0 || !Charset.isSupported(encoding)) {
            return new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        } else {
            return new BufferedReader(new InputStreamReader(new FileInputStream(file), encoding));
        }
        
    }
    
    private static void notifySuccess(final int count) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                String t = NbBundle.getMessage(ImportThoughts.class, "Import_Thoughts");
//              String m = "Completed importing " + count + " thoughts." + "      ";
                String m = NbBundle.getMessage(getClass(), "imported_n_thoughts", count) + "       "; // No I18N
                Component p = WindowManager.getDefault().getMainWindow();
                JOptionPane.showMessageDialog(p, m, t, JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }
    
    private static void notifyFailure(final Exception ex) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                String t = NbBundle.getMessage(ImportThoughts.class, "Import_Thoughts");
                String m = NbBundle.getMessage(ImportThoughts.class, "error_processing_file") + " \n" + ex.getMessage();
                Component p = WindowManager.getDefault().getMainWindow();
                JOptionPane.showMessageDialog(p, m, t, JOptionPane.ERROR_MESSAGE);
            }
        });
    }
    
}
