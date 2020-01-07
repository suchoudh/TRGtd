package tr.swing;

import java.util.Vector;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.UIManager;

public class TRComboBox extends JComboBox {

    public TRComboBox() {
    }

    public TRComboBox(Vector<?> model) {
        super(model);
    }

    public TRComboBox(Object[] model) {
        super(model);
    }

    public TRComboBox(ComboBoxModel model) {
        super(model);
    }

    @Override
    public int getHeight() {
        if ("Aqua".equals(UIManager.getLookAndFeel().getID())) {
            return super.getHeight();
        } else {
            return 23;
        }
    }

}
