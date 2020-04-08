package alexandreladriere.imagetoolkit.gui.custompanels;

import javax.swing.*;
import java.awt.*;

public class ConvertParamPanel extends JPanel {
    public ConvertParamPanel() {
        super();
        this.setLayout(new BorderLayout());
        JLabel title = new JLabel("Convert: ");
        this.add(title, BorderLayout.CENTER);
    }
}
