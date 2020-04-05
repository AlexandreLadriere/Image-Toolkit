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
    protected JLabel imageLabel;

    protected JPanel southPanel;

    /**
     * Default constructor
     */
    public PreviewPanel() {
        this.setLayout(new BorderLayout());

        applyButton = new JButton("Apply");
        cancelButton = new JButton("Cancel");
        previewLabel = new JLabel("Preview");
        // initWidthHeight();
        hwLabel = new JLabel();
        // North Panel
        JPanel northPanel = new JPanel();
        northPanel.setLayout(new BorderLayout());
        northPanel.add(previewLabel, BorderLayout.CENTER);
        northPanel.add(hwLabel, BorderLayout.EAST);
        this.add(northPanel, BorderLayout.NORTH);
        // Center
        imageLabel = new JLabel();
        this.add(imageLabel, BorderLayout.CENTER);
        // South Panel
        southPanel = new JPanel();
        southPanel.setLayout(new BorderLayout());
        // South east panel
        JPanel southEastPanel = new JPanel();
        southEastPanel.setLayout(new BorderLayout());
        southEastPanel.add(cancelButton, BorderLayout.CENTER);
        southEastPanel.add(applyButton, BorderLayout.EAST);
        southPanel.add(southEastPanel, BorderLayout.EAST);
        this.add(southPanel, BorderLayout.SOUTH);
    }

    /**
     * Initialize the width and height label of the preview label
     */
    protected void initWidthHeight(BufferedImage preview) {
        this.preview = preview;
        hwLabel.setText("(height: " + preview.getHeight() + "px ; width: " + preview.getWidth() + "px)");
    }

    /**
     * Update the image label to display
     *
     * @param img Image that you want to display inside the label
     */
    protected void updateImageLabel(BufferedImage img) {
        imageLabel.setIcon(new ImageIcon(img));
    }
}
