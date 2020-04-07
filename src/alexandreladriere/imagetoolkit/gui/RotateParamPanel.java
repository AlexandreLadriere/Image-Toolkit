package alexandreladriere.imagetoolkit.gui;

import javax.swing.*;
import java.awt.*;

public class RotateParamPanel extends JPanel {

    private JTextField angleTextField;

    public RotateParamPanel() {
        super();
        this.setLayout(new BorderLayout());
        JLabel title = new JLabel("Rotate: ");
        this.add(title, BorderLayout.WEST);
        angleTextField = new JTextField("0.0");
        this.add(angleTextField, BorderLayout.EAST);
    }

    /**
     * Get the angle entered in the text field
     *
     * @return Angle entered in the text field
     */
    public double getAngle() {
        double angle = 0.0;
        try {
            angle = Double.parseDouble(angleTextField.getText());
            return angle;
        } catch (NumberFormatException e) {
            return angle;
        }
    }
}
