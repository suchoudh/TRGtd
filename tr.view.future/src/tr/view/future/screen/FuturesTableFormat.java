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

import au.com.thinkingrock.tr.resource.Icons;
import au.com.trgtd.tr.appl.Constants;
import ca.odell.glazedlists.gui.AdvancedTableFormat;
import java.awt.Color;
import java.awt.Component;
import java.text.DateFormat;
import java.util.Comparator;
import java.util.Date;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import org.openide.util.NbBundle;
import tr.model.future.Future;
import tr.model.topic.Topic;
import tr.util.DateUtils;

/**
 * Someday/Maybe table format.
 *
 * @author <a href="mailto:jimoore@netspace.net.au">Jeremy Moore</a>
 */
public class FuturesTableFormat implements AdvancedTableFormat {
    
    private static Class clazz = FuturesTableFormat.class;
    
    public int getColumnCount() {
        return 5;
    }
    
    public String getColumnName(int column) {
        switch (column) {
            case 0: return "";
            case 1: return NbBundle.getMessage(clazz, "created"); // NOI18N;
            case 2: return NbBundle.getMessage(clazz, "description"); // NOI18N;
            case 3: return NbBundle.getMessage(clazz, "topic"); // NOI18N;
            case 4: return NbBundle.getMessage(clazz, "tickle"); // NOI18N;
        }
        throw new IllegalStateException();
    }
    
    public Object getColumnValue(Object baseObject, int column) {
        
        Future future = (Future)baseObject;
        
        Color bg = future.getTopic().getBackground();
        Color fg = future.getTopic().getForeground();
        
        switch (column) {
            case 0: return Icons.SomedayMaybe;
            case 1: return new ColoredDate(future.getCreated(), bg, fg);
            case 2: return new ColoredString(future.getDescription(), bg, fg);
            case 3: return future.getTopic();
            case 4: return new ColoredDate(future.getTickle(), bg, fg);
        }
        throw new IllegalStateException();
    }
    
    public Class getColumnClass(int column) {
        switch (column) {
            case 0: return Icon.class;
            case 1: return ColoredDate.class;
            case 2: return ColoredString.class;
            case 3: return Topic.class;
            case 4: return ColoredDate.class;
        }
        throw new IllegalStateException();
    }
    
    public Comparator getColumnComparator(int column) {
        switch (column) {
            case 0: return null;
            case 1: return new ColoredDateComparator();
            case 2: return new ColoredStringComparator();
            case 3: return new TopicComparator();
            case 4: return new ColoredDateComparator();
        }
        throw new IllegalStateException();
    }
    
    /*
     * Get the preferred column widths. Uses 10 times more than desired to force
     * proportions and not absolute widths.
     */
    public int getColumnWidth(int column) {
        switch (column) {
            case 0: return 20;
            case 1: return 1400;
            case 2: return 4000;
            case 3: return 1000;
            case 4: return 1000;
        }
        throw new IllegalStateException();
    }
    
    /*
     * Determines whether each column should be resizable.
     */
    public boolean isResizable(int column) {
        switch (column) {
            case 0: return false;
            case 1: return true;
            case 2: return true;
            case 3: return true;
            case 4: return true;
        }
        throw new IllegalStateException();
    }
    
    public static class ColoredDate {
        public final Date date;
        public final Color bg;
        public final Color fg;
        public ColoredDate(Date date, Color bg, Color fg) {
            this.date = date;
            this.fg = fg;
            this.bg = bg;
        }
    }
    
    public static class ColoredString {
        public final String string;
        public final Color bg;
        public final Color fg;
        public ColoredString(String string, Color bg, Color fg) {
            this.string = string;
            this.fg = fg;
            this.bg = bg;
        }
    }
    
    public static class ColoredDateComparator implements Comparator {
        public int compare(Object o1, Object o2) {
            Date d1 = DateUtils.clearTime(((ColoredDate)o1).date);
            Date d2 = DateUtils.clearTime(((ColoredDate)o2).date);
//////      return d1.compareTo(d2);
            if (d1 == d2) {
                return 0;
            }
            if (d1 == null) {
                Date today = DateUtils.getEnd(new Date());
                return (d2.after(today)) ? -1 : 1;
            }
            if (d2 == null) {
                Date today = DateUtils.getEnd(new Date());
                return (d1.after(today)) ? 1 : -1;
            }
            return d1.compareTo(d2);
        }
    }
    
    public static class ColoredStringComparator implements Comparator {
        public int compare(Object o1, Object o2) {
            String s1 = ((ColoredString)o1).string;
            String s2 = ((ColoredString)o2).string;
            return s1.compareToIgnoreCase(s2);
        }
    }
    
    public static class TopicComparator implements Comparator {
        public int compare(Object o1, Object o2) {
            Topic t1 = (Topic)o1;
            Topic t2 = (Topic)o2;
            return t1.compareTo(t2);
        }
    }
    
    public static class ColoredDateRenderer extends DefaultTableCellRenderer {
        
        private final DateFormat df = Constants.DATE_FORMAT_FIXED;
        
        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int col) {
            
            JLabel label = new JLabel("");
            label.setOpaque(true);
            
            if (value instanceof ColoredDate) {
                ColoredDate cd = (ColoredDate)value;
                if (isSelected) {
                    label.setBackground(table.getSelectionBackground());
                    label.setForeground(table.getSelectionForeground());
                } else {
                    label.setBackground(cd.bg);
                    label.setForeground(cd.fg);
                }
                if (cd.date != null) {
                    label.setText(df.format(cd.date));
                }
            }
            
            return label;
        }
    }
    
    public static class ColoredStringRenderer extends DefaultTableCellRenderer {
        
        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int col) {
            
            JLabel label = new JLabel("");
            label.setOpaque(true);
            
            if (value instanceof ColoredString) {
                ColoredString cs = (ColoredString)value;
                if (isSelected) {
                    label.setBackground(table.getSelectionBackground());
                    label.setForeground(table.getSelectionForeground());
                } else {
                    label.setBackground(cs.bg);
                    label.setForeground(cs.fg);
                }
                label.setText(cs.string);
            }
            
            return label;
        }
    }
    
    public static class TopicRenderer extends DefaultTableCellRenderer {
        
        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int col) {
            
            JLabel label = new JLabel("");
            
            label.setOpaque(true);
            
            if (value instanceof Topic) {
                Topic topic = (Topic)value;
                if (isSelected) {
                    label.setBackground(table.getSelectionBackground());
                    label.setForeground(table.getSelectionForeground());
                } else {
                    label.setBackground(topic.getBackground());
                    label.setForeground(topic.getForeground());
                }
                label.setText(topic.getName());
            }
            
            return label;
        }
    }
}