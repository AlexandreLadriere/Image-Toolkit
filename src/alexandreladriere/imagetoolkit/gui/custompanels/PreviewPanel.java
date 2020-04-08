package alexandreladriere.imagetoolkit.gui.custompanels;

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
    protected JPanel paramPanel;
    protected CardLayout paramCardLayout;
    protected String[] paramPanelName = {"RESIZE", "CROP", "ROUNDED_CORNER", "CONVERT", "ROTATE"};
    protected JPanel resizeCard;
    protected JPanel rotateCard;
    protected JPanel cropCard;
    protected JPanel roundedCornerCard;
    protected JPanel convertCard;

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
        // South panel - Card layout
        paramCardLayout = new CardLayout();
        rotateCard = new RotateParamPanel();
        resizeCard = new ResizeParamPanel();
        roundedCornerCard = new RoundedCornersParamPanel();
        cropCard = new CropParamPanel();
        convertCard = new ConvertParamPanel();
        paramPanel = new JPanel();
        paramPanel.setLayout(paramCardLayout);
        paramPanel.add(resizeCard, paramPanelName[0]);
        paramPanel.add(rotateCard, paramPanelName[4]);
        paramPanel.add(roundedCornerCard, paramPanelName[2]);
        paramPanel.add(convertCard, paramPanelName[3]);
        paramPanel.add(cropCard, paramPanelName[1]);
        southPanel.add(paramPanel, BorderLayout.CENTER);
        southPanel.add(southEastPanel, BorderLayout.EAST);
        this.add(southPanel, BorderLayout.SOUTH);
    }

    /**
     * Initialize the parameters for the "Rounded corners" option
     */
    public void initRoundedCornersParam() {
        paramCardLayout.show(paramPanel, paramPanelName[2]);
    }

    /**
     * Initialize the parameters for the "Resize" option
     */
    public void initResizeParam() {
        paramCardLayout.show(paramPanel, paramPanelName[0]);
    }

    /**
     * Initialize the parameters for the "Crop" option
     */
    public void initCropParam() {
        paramCardLayout.show(paramPanel, paramPanelName[1]);
    }

    /**
     * Initialize the parameters for the "Convert" option
     */
    public void initConvertParam() {
        paramCardLayout.show(paramPanel, paramPanelName[3]);
    }

    /**
     * Initialize the parameters for the "Rotate" option
     */
    public void initRotateParam() {
        paramCardLayout.show(paramPanel, paramPanelName[4]);
    }

    /**
     * Initialize the width and height label of the preview label
     */
    public void initWidthHeight(BufferedImage preview) {
        this.preview = preview;
        hwLabel.setText("(height: " + preview.getHeight() + "px ; width: " + preview.getWidth() + "px)");
    }

    /**
     * Update the image label to display
     *
     * @param img Image that you want to display inside the label
     */
    public void updateImageLabel(BufferedImage img) {
        imageLabel.setIcon(new ImageIcon(img));
    }

    /**
     * Get the "Apply" button
     *
     * @return Apply button
     */
    public JButton getApplyButton() {
        return applyButton;
    }

    /**
     * Get the "Cancel" button
     *
     * @return Cancel button
     */
    public JButton getCancelButton() {
        return cancelButton;
    }

    /**
     * Get the current card in the card layout
     *
     * @return Current card in the card layout
     */
    public JPanel getParamCurrentPanel() {
        JPanel currentPanel = null;

        for (Component component : paramPanel.getComponents()) {
            if (component.isVisible()) {
                if (component instanceof JPanel)
                    currentPanel = (JPanel) component;
                else if (component instanceof JScrollPane)
                    currentPanel = (JPanel) ((JScrollPane) component).getViewport().getComponent(0);
            }
        }
        return currentPanel;
    }
}
