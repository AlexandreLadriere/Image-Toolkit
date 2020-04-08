package alexandreladriere.imagetoolkit.gui.custompanels;

import javax.swing.*;
import java.awt.*;

public class ResizeParamPanel extends JPanel {

    private JTextField heightTextField;
    private JTextField widthTextField;

    public ResizeParamPanel() {
        super();
        this.setLayout(new BorderLayout());
        JLabel title = new JLabel("Resize: ");
        this.add(title, BorderLayout.CENTER);
    }
}
