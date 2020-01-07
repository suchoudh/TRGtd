package tr.extract.prefs;

import java.awt.BorderLayout;
import java.awt.Component;
import java.io.File;
import java.nio.charset.Charset;
import java.util.Vector;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import net.miginfocom.swing.MigLayout;
import org.openide.util.NbBundle;
import org.openide.windows.WindowManager;

final class ExtractPanel extends JPanel {
    
    private final ExtractOptionsPanelController controller;
    
    ExtractPanel(ExtractOptionsPanelController controller) {
        this.controller = controller;
        initForm();
    }

    private void initForm() {
        initComponents();
        initFields();
        add(getView(), BorderLayout.CENTER);
    }

    private JComponent getView() {
        JPanel panel = new JPanel(new MigLayout("", "0[]2[grow]2[]0", "0[]2[]0"));
        
        panel.add(folderLabel,  "align right");
        panel.add(folderField,  "align left, growx 100");
        panel.add(browseButton, "align left, wrap");

        panel.add(encodingLabel, "align right");
        panel.add(encodingCombo, "align left, wrap");

        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setBorder(new EmptyBorder(0,0,0,0));
        return scrollPane;
    }

    private void initFields() {
        folderLabel = new JLabel(getMsg("Output"));
        folderField = new JTextField();
        folderField.getDocument().addDocumentListener(new FolderDocumentListener());
        browseButton = new JButton(getMsg("Browse"));
        browseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browse(evt);
            }
        });
        encodingLabel = new JLabel(getMsg("Encoding"));
        encodingCombo = new JComboBox();
        encodingCombo.setEditable(true);
        encodingCombo.setModel(getEncodingModel());
    }
    
    // Document listener for the folder text field.
    private class FolderDocumentListener implements DocumentListener {
        public void insertUpdate(DocumentEvent e) {
            ExtractPanel.this.controller.changed();
        }
        public void removeUpdate(DocumentEvent e) {
            ExtractPanel.this.controller.changed();
        }
        public void changedUpdate(DocumentEvent e) {
            ExtractPanel.this.controller.changed();
        }
    }

    private ComboBoxModel getEncodingModel() {
        Vector<String> encodings = new Vector<String>();
        encodings.add("");
        encodings.addAll(Charset.availableCharsets().keySet());
        return new DefaultComboBoxModel(encodings);
    }

    void load() {
        folderField.setText(ExtractPrefs.getPath());
        encodingCombo.setSelectedItem(ExtractPrefs.getEncoding());
    }

    void store() {
        if (isValidPath()) {
            ExtractPrefs.setPath(getPath());
        }
        if (isValidEncoding()) {
            ExtractPrefs.setEncoding(getEncoding());
        }
    }

    boolean valid() {
        return isValidPath() && isValidEncoding();
    }

    private boolean isValidEncoding() {
        String encoding = getEncoding();
        if (encoding.length() == 0) {
            return true;
        }
        try {
            return Charset.isSupported(encoding);
        } catch (Exception ex) {
            return false;
        }
    }

    private String getEncoding() {
        String encoding = (String)encodingCombo.getSelectedItem();
        return encoding == null ? "" : encoding.trim();
    }

    private boolean isValidPath() {
        String path = getPath();
        return path.length() == 0 || (new File(path)).isDirectory();
    }

    private String getPath() {
        String path = folderField.getText().trim();
        while (path.endsWith(File.separator)) {
            path = path.substring(0, path.length() - 1).trim();
        }
        return path;
    }

    private void browse(java.awt.event.ActionEvent evt) {
        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fc.setSelectedFile(new File(folderField.getText()));
        Component p = WindowManager.getDefault().getMainWindow();
        int returnVal = fc.showOpenDialog(p);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            try {
                folderField.setText(fc.getSelectedFile().getCanonicalPath());
            } catch (Exception ex) {
                folderField.setText("");
            }
        }
    }

    private String getMsg(String key) {
        return NbBundle.getMessage(ExtractPanel.class, key);
    }

    private javax.swing.JComboBox encodingCombo;
    private javax.swing.JLabel encodingLabel;
    private javax.swing.JButton browseButton;
    private javax.swing.JLabel folderLabel;
    private javax.swing.JTextField folderField;
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(new java.awt.BorderLayout());
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
