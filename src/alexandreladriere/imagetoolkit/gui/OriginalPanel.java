package alexandreladriere.imagetoolkit.gui;

import javax.swing.*;
import java.awt.*;

/**
 * Implement the original panel
 */
public class OriginalPanel extends PreviewPanel {
    private FileDialog dialog;
    private JButton openFile;
    private JLabel imagePathLabel;

    /**
     * Default constructor
     */
    public OriginalPanel() {
        super();
        previewLabel.setText("Original");
        // South panel will not be the same as the preview panel
        southPanel = new JPanel();
        southPanel.setLayout(new BorderLayout());
        dialog = new FileDialog((Frame) null, "Select Image to Open");
        dialog.setMode(FileDialog.LOAD);
        openFile = new JButton("Open image");
        imagePathLabel = new JLabel("");
        southPanel.add(imagePathLabel, BorderLayout.CENTER);
        southPanel.add(openFile, BorderLayout.EAST);
        this.add(southPanel, BorderLayout.SOUTH);
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

    /**
     * Get the image path label
     *
     * @return Image path label
     */
    public JLabel getImagePathLabel() {
        return imagePathLabel;
    }

    /**
     * Set the image path label
     *
     * @param imagePathLabel The image path label
     */
    public void setImagePathLabel(JLabel imagePathLabel) {
        this.imagePathLabel = imagePathLabel;
    }
}
