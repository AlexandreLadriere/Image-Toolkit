package alexandreladriere.imagetoolkit;

import alexandreladriere.imagetoolkit.utils.FilePathManipulation;
import alexandreladriere.imagetoolkit.utils.ImageExtensions;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Implement the model
 */
public final class ImageToolkit {
    /**
     * Resize an image
     *
     * @param inPath    Path of the image you want to resize (with filename)
     * @param outPath   Destination path to save the image to
     * @param newWidth  New width
     * @param newHeight New height
     * @param smooth    Indicates if you want a smooth and slow resize or a fast resize (true: smooth, false: fast)
     */
    public static void resize(String inPath, String outPath, int newWidth, int newHeight, boolean smooth) {
        String extension = FilePathManipulation.getExtension(inPath);
        // checks if the given file format is supported
        if (ImageExtensions.contains(extension)) {
            File input = new File(inPath);
            try {
                BufferedImage image = ImageIO.read(input);
                int scaleType = Image.SCALE_DEFAULT;
                if (smooth) {
                    scaleType = Image.SCALE_SMOOTH;
                } else {
                    scaleType = Image.SCALE_FAST;
                }
                BufferedImage resized = resize(image, newHeight, newWidth, scaleType);
                File output = new File(outPath);
                ImageIO.write(resized, extension, output);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Resize the given BufferedImage
     *
     * @param img    Image that you want to resize
     * @param height New height
     * @param width  New width
     * @return The resized image
     */
    private static BufferedImage resize(BufferedImage img, int height, int width, int scaleType) {
        Image tmp = img.getScaledInstance(width, height, scaleType);
        BufferedImage resized = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = resized.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();
        return resized;
    }
}
