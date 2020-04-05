package alexandreladriere.imagetoolkit.gui;

import alexandreladriere.imagetoolkit.utils.FilePathManipulation;
import alexandreladriere.imagetoolkit.utils.ImageExtensions;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Implement the GUI
 */
public class Gui extends JPanel {
    private BufferedImage original;
    private String originalPath;
    private BufferedImage preview;
    private PreviewPanel previewPanel;
    private OriginalPanel originalPanel;

    public Gui() {
        this.setLayout(new BorderLayout());
        previewPanel = new PreviewPanel();
        originalPanel = new OriginalPanel();
        // Center panel
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());
        centerPanel.add(previewPanel, BorderLayout.WEST);

        originalPanel.getOpenFile().addActionListener(new Controller(this));
        centerPanel.add(originalPanel, BorderLayout.EAST);
        this.add(centerPanel, BorderLayout.CENTER);
    }

    /**
     * Initialize the original image preview
     *
     * @param imagePath Path of the image that you want to display
     */
    public void initOriginalImage(String imagePath) {
        originalPath = imagePath;
        originalPanel.getImagePathLabel().setText(originalPath);
        String extensionIn = FilePathManipulation.getExtension(imagePath).toLowerCase();
        // checks if the given file format is supported
        if (ImageExtensions.contains(extensionIn)) {
            File input = new File(originalPath);
            try {
                System.out.println(input);
                original = ImageIO.read(input);
                originalPanel.updateImageLabel(original);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Get the original panel
     *
     * @return Original panel
     */
    public OriginalPanel getOriginalPanel() {
        return originalPanel;
    }

    /**
     * Set the path of the original image
     *
     * @param originalPath path of the original image
     */
    public void setOriginalPath(String originalPath) {
        this.originalPath = originalPath;
    }
}
