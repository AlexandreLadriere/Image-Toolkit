package alexandreladriere.imagetoolkit.gui;

import javax.swing.*;
import java.awt.*;

public class SidePanel extends JPanel {
    private JPanel resizeGroup;
    private JPanel cropGroup;
    private JPanel rotateGroup;
    private JPanel roundedGroup;
    private JPanel convertGroup;
    private JButton cancelAllButton;
    private JButton saveButton;

    public SidePanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        resizeGroup = new JPanel();
        resizeGroup.setLayout(new BorderLayout());
        initLabelGroup(resizeGroup, "/alexandreladriere/imagetoolkit/resources/resize_icon.png", "Resize");
        this.add(resizeGroup);
        cropGroup = new JPanel();
        initLabelGroup(cropGroup, "/alexandreladriere/imagetoolkit/resources/crop_icon.png", "Crop");
        this.add(cropGroup);
        rotateGroup = new JPanel();
        initLabelGroup(rotateGroup, "/alexandreladriere/imagetoolkit/resources/rotate_icon.png", "Rotate");
        this.add(rotateGroup);
        roundedGroup = new JPanel();
        initLabelGroup(roundedGroup, "/alexandreladriere/imagetoolkit/resources/rounded_icon.png", "Rounded corners");
        this.add(roundedGroup);
        convertGroup = new JPanel();
        initLabelGroup(convertGroup, "/alexandreladriere/imagetoolkit/resources/convert_icon.png", "Convert");
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
    private void initLabelGroup(JPanel group, String iconPath, String name) {
        group.setLayout(new BorderLayout());
        ImageIcon icon = new ImageIcon(this.getClass().getResource(iconPath));
        JLabel iconLabel = new JLabel();
        iconLabel.setIcon(icon);
        JLabel nameLabel = new JLabel(name);
        group.add(iconLabel, BorderLayout.NORTH);
        group.add(nameLabel, BorderLayout.SOUTH);
    }
}
