package alexandreladriere.imagetoolkit.gui;

import alexandreladriere.imagetoolkit.utils.UtilsFunctions;

import javax.swing.*;
import java.awt.*;

public class RoundedCornersParamPanel extends JPanel {

    private JTextField radiusTextField;

    public RoundedCornersParamPanel() {
        super();
        this.setLayout(new BorderLayout());
        JLabel title = new JLabel(" Corner radius: ");
        this.add(title, BorderLayout.WEST);
        radiusTextField = new JTextField("0");
        this.add(radiusTextField, BorderLayout.EAST);
    }

    /**
     * Get the radius entered in the text field (0 if not an integer)
     *
     * @return Radius entered in the text field (0 if not an integer)
     */
    public int getRadius() {
        String radiusStr = radiusTextField.getText();
        int radiusInt = 0;
        if (UtilsFunctions.isInteger(radiusStr)) {
            radiusInt = Integer.parseInt(radiusStr);
        }
        return radiusInt;
    }
}
