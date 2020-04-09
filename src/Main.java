import alexandreladriere.imagetoolkit.ImageToolkit;

/**
 * Main class
 */
public class Main {
    public static void main(String[] args) {
        if (args[0].toLowerCase().equals("resize") && args.length == 6) {
            ImageToolkit.resize(args[1], args[2], Integer.parseInt(args[3]), Integer.parseInt(args[4]), Boolean.parseBoolean(args[5]));
        } else if (args[0].toLowerCase().equals("resize_ratio") && args.length == 5) {
            ImageToolkit.resize(args[1], args[2], Integer.parseInt(args[3]), Boolean.parseBoolean(args[4]));
        } else if (args[0].toLowerCase().equals("convert") && args.length == 3) {
            ImageToolkit.convert(args[1], args[2]);
        }
    }
}
