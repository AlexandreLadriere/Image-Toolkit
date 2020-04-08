package alexandreladriere.imagetoolkit.gui.custompanels;

import alexandreladriere.imagetoolkit.utils.UtilsFunctions;

import javax.swing.*;
import java.awt.*;

public class ResizeParamPanel extends JPanel {

    private JTextField heightTextField;
    private JTextField widthTextField;
    private JTextField ratioTextField;
    private JRadioButton ratioRadioButton;

    public ResizeParamPanel() {
        super();
        this.setLayout(new BorderLayout());
        JLabel title = new JLabel("Resize");
        this.add(title, BorderLayout.NORTH);

        JPanel ratioPanel = new JPanel();
        ratioPanel.setLayout(new BorderLayout());
        ratioRadioButton = new JRadioButton();
        ratioRadioButton.setSelected(true);
        JLabel ratioTitle = new JLabel("ratio: ");
        ratioTextField = new JTextField("100");
        ratioPanel.add(ratioRadioButton, BorderLayout.WEST);
        ratioPanel.add(ratioTitle, BorderLayout.CENTER);
        ratioPanel.add(ratioTextField, BorderLayout.EAST);
        this.add(ratioPanel, BorderLayout.CENTER);

        JPanel newDimPanel = new JPanel();
        newDimPanel.setLayout(new BorderLayout());
        JLabel pxTitle = new JLabel("px");
        // newDimPanel - North Panel
        JPanel NDnorthPanel = new JPanel();
        NDnorthPanel.setLayout(new BorderLayout());
        JLabel newHeightTitle = new JLabel("New height: ");
        heightTextField = new JTextField("100");
        NDnorthPanel.add(newHeightTitle, BorderLayout.WEST);
        NDnorthPanel.add(heightTextField, BorderLayout.CENTER);
        NDnorthPanel.add(pxTitle, BorderLayout.EAST);
        newDimPanel.add(NDnorthPanel, BorderLayout.NORTH);
        // newDimPanel - South Panel
        JPanel NDsouthPanel = new JPanel();
        NDsouthPanel.setLayout(new BorderLayout());
        JLabel newWidthTitle = new JLabel("New width: ");
        widthTextField = new JTextField("100");
        NDsouthPanel.add(newWidthTitle, BorderLayout.WEST);
        NDsouthPanel.add(widthTextField, BorderLayout.CENTER);
        NDsouthPanel.add(pxTitle, BorderLayout.EAST);
        newDimPanel.add(NDsouthPanel, BorderLayout.SOUTH);

        this.add(newDimPanel, BorderLayout.SOUTH);
        // TODO disable text field according to radio button
    }

    /**
     * Get the width entered by the user
     *
     * @return Width in the text field (default = 100)
     */
    public int getWidth() {
        String widthStr = widthTextField.getText();
        int widthInt = 0;
        if (UtilsFunctions.isInteger(widthStr)) {
            widthInt = Integer.parseInt(widthStr);
        }
        return widthInt;
    }

    /**
     * Get the height entered by the user
     *
     * @return Height entered in the text field (default = 100)
     */
    public int getHeight() {
        String heightStr = heightTextField.getText();
        int heightInt = 0;
        if (UtilsFunctions.isInteger(heightStr)) {
            heightInt = Integer.parseInt(heightStr);
        }
        return heightInt;
    }

    /**
     * Get the ratio entered by the user
     *
     * @return Ratio entered in the text field (default = 100)
     */
    public int getRatio() {
        String ratioStr = ratioTextField.getText();
        int ratioInt = 0;
        if (UtilsFunctions.isInteger(ratioStr)) {
            ratioInt = Integer.parseInt(ratioStr);
        }
        return ratioInt;
    }

    /**
     * Get the ratio radio button
     *
     * @return Ratio radio button
     */
    public JRadioButton getRatioRadioButton() {
        return ratioRadioButton;
    }
}
