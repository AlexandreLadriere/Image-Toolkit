package alexandreladriere.imagetoolkit.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Implement the mother class of the preview panel
 */
public class PreviewPanel extends JPanel {
    protected BufferedImage preview;

    protected JButton applyButton;
    protected JButton cancelButton;
    protected JLabel previewLabel;
    protected JLabel hwLabel;

    /**
     * Default constructor
     *
     * @param preview Input image (before transformation)
     */
    public PreviewPanel(BufferedImage preview) {
        this.preview = preview;
        this.setLayout(new BorderLayout());

        applyButton = new JButton("Apply");
        cancelButton = new JButton("Cancel");
        previewLabel = new JLabel("Preview");
        initWidthHeight();
        // North Panel
        JPanel northPanel = new JPanel();
        northPanel.setLayout(new BorderLayout());
        northPanel.add(previewLabel, BorderLayout.CENTER);
        northPanel.add(hwLabel, BorderLayout.EAST);
        this.add(northPanel, BorderLayout.NORTH);
    }

    /**
     * Initialize the width and height label of the preview label
     */
    protected void initWidthHeight() {
        hwLabel = new JLabel("(height: " + preview.getHeight() + "px ; width: " + preview.getWidth() + "px)");
    }
}
