package alexandreladriere.imagetoolkit.gui.custompanels;

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

    /**
     * Get the convert group composed of an icon and a label
     *
     * @return Convert group composed of a label and an icon
     */
    public JPanel getConvertGroup() {
        return convertGroup;
    }

    /**
     * Get the crop group composed of an icon and a label
     *
     * @return Crop group composed of a label and an icon
     */
    public JPanel getCropGroup() {
        return cropGroup;
    }

    /**
     * Get the resize group composed of an icon and a label
     *
     * @return Resize group composed of a label and an icon
     */
    public JPanel getResizeGroup() {
        return resizeGroup;
    }

    /**
     * Get the rotate group composed of an icon and a label
     *
     * @return Rotate group composed of a label and an icon
     */
    public JPanel getRotateGroup() {
        return rotateGroup;
    }

    /**
     * Get the rounded corner group composed of an icon and a label
     *
     * @return Rounded corner group composed of a label and an icon
     */
    public JPanel getRoundedGroup() {
        return roundedGroup;
    }

    /**
     * Get the Cancel all button
     *
     * @return Cancel All button
     */
    public JButton getCancelAllButton() {
        return cancelAllButton;
    }

    /**
     * Get the Save button
     *
     * @return Save button
     */
    public JButton getSaveButton() {
        return saveButton;
    }
}
