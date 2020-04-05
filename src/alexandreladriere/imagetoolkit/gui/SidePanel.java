package alexandreladriere.imagetoolkit.gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SidePanel extends JPanel {
    private JLabel resizeGroup;
    private JLabel cropGroup;
    private JLabel rotateGroup;
    private JLabel roundedGroup;
    private JLabel convertGroup;
    private JButton cancelAllButton;
    private JButton saveButton;

    public SidePanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        resizeGroup = new JLabel();
        initLabelGroup(resizeGroup, "src/alexandreladriere/imagetoolkit/resources/resize_icon.png", "Resize");
        this.add(resizeGroup);
        cropGroup = new JLabel();
        initLabelGroup(cropGroup, "src/alexandreladriere/imagetoolkit/resources/crop_icon.png", "Crop");
        this.add(cropGroup);
        rotateGroup = new JLabel();
        initLabelGroup(rotateGroup, "src/alexandreladriere/imagetoolkit/resources/rotate_icon.png", "Rotate");
        this.add(rotateGroup);
        roundedGroup = new JLabel();
        initLabelGroup(roundedGroup, "src/alexandreladriere/imagetoolkit/resources/rounded_icon.png", "Rounded corners");
        this.add(roundedGroup);
        convertGroup = new JLabel();
        initLabelGroup(convertGroup, "src/alexandreladriere/imagetoolkit/resources/convert_icon.png", "Convert");
        this.add(convertGroup);
        cancelAllButton = new JButton("Cancel all");
        this.add(cancelAllButton);
        saveButton = new JButton("Save");
        this.add(saveButton);
    }

    /**
     * Initialize a super button composed of an icon (top) and a name (bottom)
     *
     * @param group    Label that will act like a super button
     * @param iconPath Path of this super button icon
     * @param name     Name of this super button
     */
    // TODO refaire cette fonction
    private void initLabelGroup(JLabel group, String iconPath, String name) {
        group.setLayout(new BorderLayout());
        File input = new File(iconPath);
        try {
            BufferedImage iconBuffered = ImageIO.read(input);
            ImageIcon icon = new ImageIcon(iconBuffered);
            JLabel iconLabel = new JLabel();
            iconLabel.setIcon(icon);
            JLabel nameLabel = new JLabel(name);
            group.add(iconLabel, BorderLayout.NORTH);
            group.add(nameLabel, BorderLayout.SOUTH);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
