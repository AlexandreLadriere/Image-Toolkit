package alexandreladriere.imagetoolkit.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
        }
        if (cmd.equals(gui.getSidePanel().getCropGroup())) {
            isConvert = false;
            isResize = false;
            isCrop = true;
            isRotate = false;
            isRoundedCorners = false;
        }
        if (cmd.equals(gui.getSidePanel().getResizeGroup())) {
            isConvert = false;
            isResize = true;
            isCrop = false;
            isRotate = false;
            isRoundedCorners = false;
        }
        if (cmd.equals(gui.getSidePanel().getRotateGroup())) {
            isConvert = false;
            isResize = false;
            isCrop = false;
            isRotate = true;
            isRoundedCorners = false;
        }
        if (cmd.equals(gui.getSidePanel().getRoundedGroup())) {
            isConvert = false;
            isResize = false;
            isCrop = false;
            isRotate = false;
            isRoundedCorners = true;
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

    }
}