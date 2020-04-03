package alexandreladriere.imagetoolkit.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Implement the GUI
 */
public class Gui extends JPanel {
    private BufferedImage original;
    private BufferedImage preview;

    public Gui() {
        this.setLayout(new BorderLayout());
    }
}
