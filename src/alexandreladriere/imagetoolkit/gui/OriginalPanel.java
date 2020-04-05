package alexandreladriere.imagetoolkit.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Implement the original panel
 */
public class OriginalPanel extends PreviewPanel {
    private FileDialog dialog;
    private JButton openFile;

    /**
     * Default constructor
     *
     * @param original Buffered image that you want to display
     */
    public OriginalPanel(BufferedImage original) {
        super(original);
        previewLabel.setText("Original");
        // South panel will not be the same as the preview panel
        southPanel = new JPanel();
        southPanel.setLayout(new BorderLayout());
        dialog = new FileDialog((Frame) null, "Select Image to Open");
        dialog.setMode(FileDialog.LOAD);
        openFile = new JButton("Open image");
        // TODO add to panel button open image
        // TODO create and add a JLabel to display image path
        // TODO make default constructor without args for preview and original panel
    }

    /**
     * Get the FileDialog object of the panel
     *
     * @return FileDialog object of the panel
     */
    public FileDialog getDialog() {
        return dialog;
    }

    /**
     * Get the OpenFile button
     *
     * @return OpenFile button
     */
    public JButton getOpenFile() {
        return openFile;
    }
}
