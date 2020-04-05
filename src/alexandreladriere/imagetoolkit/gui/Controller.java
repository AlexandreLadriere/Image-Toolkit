package alexandreladriere.imagetoolkit.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Implements the controller of the GUI
 */
public class Controller implements ActionListener {

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
}