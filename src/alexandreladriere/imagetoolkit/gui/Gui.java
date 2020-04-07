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
    private Controller controller;
    private BufferedImage original;
    private String originalPath;
    private BufferedImage preview;
    private PreviewPanel previewPanel;
    private OriginalPanel originalPanel;
    private SidePanel sidePanel;

    public Gui() {
        controller = new Controller(this);
        this.setLayout(new BorderLayout());
        initPreviewPanel();
        originalPanel = new OriginalPanel();
        // Center panel
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());
        centerPanel.add(previewPanel, BorderLayout.WEST);

        originalPanel.getOpenFile().addActionListener(controller);
        centerPanel.add(originalPanel, BorderLayout.EAST);
        this.add(centerPanel, BorderLayout.CENTER);
        // West Panel
        sidePanel = new SidePanel();
        initSidePanelListeners();
        this.add(sidePanel, BorderLayout.WEST);
    }

    /**
     * Initialize the preview panel
     */
    private void initPreviewPanel() {
        previewPanel = new PreviewPanel();
        previewPanel.getCancelButton().addActionListener(controller);
        previewPanel.getApplyButton().addActionListener(controller);
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
                original = ImageIO.read(input);
                preview = original;
                originalPanel.updateImageLabel(original);
                originalPanel.initWidthHeight(original);
                previewPanel.updateImageLabel(original);
                previewPanel.initWidthHeight(original);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Initialize all side panel buttons by adding interaction listeners
     */
    private void initSidePanelListeners() {
        sidePanel.getCancelAllButton().addActionListener(controller);
        sidePanel.getSaveButton().addActionListener(controller);
        sidePanel.getConvertGroup().addMouseListener(controller);
        sidePanel.getCropGroup().addMouseListener(controller);
        sidePanel.getResizeGroup().addMouseListener(controller);
        sidePanel.getRotateGroup().addMouseListener(controller);
        sidePanel.getRoundedGroup().addMouseListener(controller);
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

    /**
     * Get the side panel object
     *
     * @return Side panel object
     */
    public SidePanel getSidePanel() {
        return sidePanel;
    }

    /**
     * Get the preview panel
     *
     * @return Preview panel
     */
    public PreviewPanel getPreviewPanel() {
        return previewPanel;
    }

    /**
     * Get the original image
     *
     * @return Original image
     */
    public BufferedImage getOriginal() {
        return original;
    }

    /**
     * Get the preview image
     *
     * @return Preview image
     */
    public BufferedImage getPreview() {
        return preview;
    }

    /**
     * Set the preview image
     *
     * @param preview New preview image
     */
    public void setPreview(BufferedImage preview) {
        this.preview = preview;
        previewPanel.updateImageLabel(preview);
    }

    /**
     * Get the path of the original image
     *
     * @return Path of the original image
     */
    public String getOriginalPath() {
        return originalPath;
    }
}
