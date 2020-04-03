import javax.swing.*;

/**
 * Main class
 */
public class Main extends JFrame {

    public Main() {
        super("ImageToolkit - Alexandre Ladrière - 2020");
        setResizable(true);
        // Gui gui = new Gui();
        // setContentPane(gui);
        pack();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Main();
    }
}
