import alexandreladriere.imagetoolkit.ImageToolkit;

/**
 * Main class
 */
public class Main {
    public static void main(String[] args) {
        // System.out.println(ImageExtensions.contains(".jpg"));
        // System.out.println(FilePathManipulation.getExtension("/src/extensions/text.test.txt"));
        ImageToolkit.resize("C:\\Users\\Alexandre\\Desktop\\JAVA\\Snake\\src\\resources\\apple.png", "C:\\Users\\Alexandre\\Desktop\\JAVA\\Image Toolkit\\test.png", 500, 50, true);
    }
}
