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
            // convert
        }
        if (cmd.equals(gui.getSidePanel().getCropGroup())) {
            // crop
        }
        if (cmd.equals(gui.getSidePanel().getResizeGroup())) {
            // resize
        }
        if (cmd.equals(gui.getSidePanel().getRotateGroup())) {
            // rotate
        }
        if (cmd.equals(gui.getSidePanel().getRoundedGroup())) {
            // rounded corners
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