package alexandreladriere.imagetoolkit.gui;

import alexandreladriere.imagetoolkit.ImageToolkit;
import alexandreladriere.imagetoolkit.gui.custompanels.ResizeParamPanel;
import alexandreladriere.imagetoolkit.gui.custompanels.RotateParamPanel;
import alexandreladriere.imagetoolkit.gui.custompanels.RoundedCornersParamPanel;
import alexandreladriere.imagetoolkit.utils.FilePathManipulation;
import alexandreladriere.imagetoolkit.utils.ImageExtensions;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

/**
 * Implements the controller of the GUI
 */
public class Controller implements ActionListener, MouseListener {

    private Gui gui;

    private boolean isRoundedCorners = false;
    private boolean isResize = true;
    private boolean isCrop = false;
    private boolean isConvert = false;
    private boolean isRotate = false;

    /**
     * Default constructor
     *
     * @param gui Gui
     */
    public Controller(Gui gui) {
        this.gui = gui;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Object cmd = actionEvent.getSource();
        // Open original image
        if (cmd.equals(gui.getOriginalPanel().getOpenFile())) {
            gui.getOriginalPanel().getDialog().setVisible(true);
            gui.initOriginalImage(gui.getOriginalPanel().getDialog().getDirectory() + '/' + gui.getOriginalPanel().getDialog().getFile());
        }
        if (cmd.equals(gui.getPreviewPanel().getApplyButton()) && isRoundedCorners) {
            RoundedCornersParamPanel paramPanel = (RoundedCornersParamPanel) gui.getPreviewPanel().getParamCurrentPanel();
            BufferedImage newPreview = ImageToolkit.makeRoundedCorner(gui.getPreview(), paramPanel.getRadius(), FilePathManipulation.getExtension(gui.getOriginalPath()).equals(ImageExtensions.PNG.toString()));
            gui.setPreview(newPreview);
            gui.getPreviewPanel().initWidthHeight(newPreview);
        }
        if (cmd.equals(gui.getPreviewPanel().getApplyButton()) && isResize) {
            ResizeParamPanel paramPanel = (ResizeParamPanel) gui.getPreviewPanel().getParamCurrentPanel();
            BufferedImage newPreview;
            if (paramPanel.getRatioRadioButton().isSelected()) {
                newPreview = ImageToolkit.resize(gui.getPreview(), paramPanel.getRatio(), Image.SCALE_SMOOTH, FilePathManipulation.getExtension(gui.getOriginalPath()).equals(ImageExtensions.PNG.toString()));
                // TODO not working
            } else {
                newPreview = ImageToolkit.resize(gui.getPreview(), paramPanel.getHeight(), paramPanel.getWidth(), Image.SCALE_SMOOTH, FilePathManipulation.getExtension(gui.getOriginalPath()).equals(ImageExtensions.PNG.toString()));
            }
            gui.setPreview(newPreview);
            gui.getPreviewPanel().initWidthHeight(newPreview);
        }
        if (cmd.equals(gui.getPreviewPanel().getApplyButton()) && isCrop) {

        }
        if (cmd.equals(gui.getPreviewPanel().getApplyButton()) && isRotate) {
            RotateParamPanel paramPanel = (RotateParamPanel) gui.getPreviewPanel().getParamCurrentPanel();
            BufferedImage newPreview = ImageToolkit.rotate(gui.getOriginal(), paramPanel.getAngle(), FilePathManipulation.getExtension(gui.getOriginalPath()).equals(ImageExtensions.PNG.toString()));
            gui.setPreview(newPreview);
            gui.getPreviewPanel().initWidthHeight(newPreview);
        }
        if (cmd.equals(gui.getPreviewPanel().getApplyButton()) && isConvert) {

        }
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        Object cmd = mouseEvent.getSource();
        if (cmd.equals(gui.getSidePanel().getConvertGroup())) {
            isConvert = true;
            isResize = false;
            isCrop = false;
            isRotate = false;
            isRoundedCorners = false;
            gui.getPreviewPanel().initConvertParam();
        }
        if (cmd.equals(gui.getSidePanel().getCropGroup())) {
            isConvert = false;
            isResize = false;
            isCrop = true;
            isRotate = false;
            isRoundedCorners = false;
            gui.getPreviewPanel().initCropParam();
        }
        if (cmd.equals(gui.getSidePanel().getResizeGroup())) {
            isConvert = false;
            isResize = true;
            isCrop = false;
            isRotate = false;
            isRoundedCorners = false;
            gui.getPreviewPanel().initResizeParam();
        }
        if (cmd.equals(gui.getSidePanel().getRotateGroup())) {
            isConvert = false;
            isResize = false;
            isCrop = false;
            isRotate = true;
            isRoundedCorners = false;
            gui.getPreviewPanel().initRotateParam();
        }
        if (cmd.equals(gui.getSidePanel().getRoundedGroup())) {
            isConvert = false;
            isResize = false;
            isCrop = false;
            isRotate = false;
            isRoundedCorners = true;
            gui.getPreviewPanel().initRoundedCornersParam();
        }
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        Object cmd = mouseEvent.getSource();
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        Object cmd = mouseEvent.getSource();
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {
        Object cmd = mouseEvent.getSource();
    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {
        Object cmd = mouseEvent.getSource();
    }
}