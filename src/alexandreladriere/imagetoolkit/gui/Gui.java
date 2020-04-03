package alexandreladriere.imagetoolkit.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Gui extends JPanel {
    BufferedImage original;
    BufferedImage preview;

    public Gui() {
        this.setLayout(new BorderLayout());
    }
}
