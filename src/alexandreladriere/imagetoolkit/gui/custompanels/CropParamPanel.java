package alexandreladriere.imagetoolkit.gui.custompanels;

import javax.swing.*;
import java.awt.*;

public class CropParamPanel extends JPanel {
    public CropParamPanel() {
        super();
        this.setLayout(new BorderLayout());
        JLabel title = new JLabel("Crop: ");
        this.add(title, BorderLayout.CENTER);
    }
}
