package alexandreladriere.imagetoolkit;

import alexandreladriere.imagetoolkit.utils.FilePathManipulation;
import alexandreladriere.imagetoolkit.utils.ImageExtensions;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Implement the model
 */
public final class ImageToolkit {
    /**
     * Resize an image according to the given dimensions
     *
     * @param inPath    Path of the image you want to resize (with filename)
     * @param outPath   Destination path to save the image to
     * @param newWidth  New width
     * @param newHeight New height
     * @param smooth    Indicates if you want a smooth and slow resize or a fast resize (true: smooth, false: fast)
     */
    public static void resize(String inPath, String outPath, int newWidth, int newHeight, boolean smooth) {
        String extensionIn = FilePathManipulation.getExtension(inPath).toLowerCase();
        String extensionOut = FilePathManipulation.getExtension(outPath).toLowerCase();
        // checks if the given file format is supported
        if (ImageExtensions.contains(extensionIn) && ImageExtensions.contains(extensionOut)) {
            File input = new File(inPath);
            try {
                BufferedImage image = ImageIO.read(input);
                int scaleType;
                if (smooth) {
                    scaleType = Image.SCALE_SMOOTH;
                } else {
                    scaleType = Image.SCALE_FAST;
                }
                BufferedImage resized = resize(image, newHeight, newWidth, scaleType, extensionOut.equals(ImageExtensions.PNG.toString()));
                File output = new File(outPath);
                ImageIO.write(resized, extensionOut, output); // à verifier
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Resize an image according to the given ratio (can be used to convert image to another format if ratio = 100)
     *
     * @param inPath  Path of the image you want to resize (with filename)
     * @param outPath Destination path to save the image to
     * @param ratio   Scale ratio (in %)
     * @param smooth  Indicates if you want a smooth and slow resize or a fast resize (true: smooth, false: fast)
     */
    public static void resize(String inPath, String outPath, int ratio, boolean smooth) {
        String extensionIn = FilePathManipulation.getExtension(inPath).toLowerCase();
        String extensionOut = FilePathManipulation.getExtension(outPath).toLowerCase();
        // checks if the given file format is supported
        if (ImageExtensions.contains(extensionIn) && ImageExtensions.contains(extensionOut)) {
            File input = new File(inPath);
            try {
                BufferedImage image = ImageIO.read(input);
                int scaleType;
                if (smooth) {
                    scaleType = Image.SCALE_SMOOTH;
                } else {
                    scaleType = Image.SCALE_FAST;
                }
                double factor = (double) ratio / (double) 100;
                int newWidth = (int) Math.round((double) image.getWidth() * factor);
                int newHeight = (int) Math.round((double) image.getHeight() * factor);
                BufferedImage resized = resize(image, newHeight, newWidth, scaleType, extensionOut.equals(ImageExtensions.PNG.toString()));
                File output = new File(outPath);
                ImageIO.write(resized, extensionOut, output);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Rotates the given image according to the given angle
     *
     * @param inPath  Path of the image you want to resize (with filename)
     * @param outPath Destination path to save the image to
     * @param angle   Angle of rotation
     */
    public static void rotate(String inPath, String outPath, double angle) {
        String extensionIn = FilePathManipulation.getExtension(inPath).toLowerCase();
        String extensionOut = FilePathManipulation.getExtension(outPath).toLowerCase();
        // checks if the given file format is supported
        if (ImageExtensions.contains(extensionIn) && ImageExtensions.contains(extensionOut)) {
            File input = new File(inPath);
            try {
                BufferedImage image = ImageIO.read(input);
                BufferedImage rotated = rotate(image, angle, extensionOut.equals(ImageExtensions.PNG.toString()));
                File output = new File(outPath);
                ImageIO.write(rotated, extensionOut, output); // à verifier
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Resize the given BufferedImage
     *
     * @param img       Image that you want to resize
     * @param height    New height
     * @param width     New width
     * @param scaleType Image scale type (smooth and slow: Image.SCALE_SMOOTH or fast: Image.SCALE_FAST)
     * @param isPng     Boolean to indicates if the image is a png or not, in order to know if we can use alpha or not (true: png; false: not png)
     * @return The resized image
     */
    private static BufferedImage resize(BufferedImage img, int height, int width, int scaleType, boolean isPng) {
        Image tmp = img.getScaledInstance(width, height, scaleType);
        int rgbType;
        if (isPng) {
            rgbType = BufferedImage.TYPE_INT_ARGB; // allows alpha for png format
        } else {
            rgbType = BufferedImage.TYPE_INT_RGB;
        }
        BufferedImage resized = new BufferedImage(width, height, rgbType);
        Graphics2D g2d = resized.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();
        return resized;
    }

    /**
     * Rotate the given BufferedImage according to the given angle
     *
     * @param img   Image that you want to rotate
     * @param angle Angle of rotation
     * @param isPng Boolean to indicates if the image is a png or not, in order to know if we can use alpha or not (true: png; false: not png)
     * @return The rotated image
     */
    private static BufferedImage rotate(BufferedImage img, double angle, boolean isPng) {
        int rgbType;
        if (isPng) {
            rgbType = BufferedImage.TYPE_INT_ARGB; // allows alpha for png format
        } else {
            rgbType = BufferedImage.TYPE_INT_RGB;
        }
        final double rads = Math.toRadians(angle);
        final double sin = Math.abs(Math.sin(rads));
        final double cos = Math.abs(Math.cos(rads));
        final int w = (int) Math.floor(img.getWidth() * cos + img.getHeight() * sin);
        final int h = (int) Math.floor(img.getHeight() * cos + img.getWidth() * sin);
        final BufferedImage rotatedImage = new BufferedImage(w, h, rgbType);
        final AffineTransform at = new AffineTransform();
        at.translate(w / (double) 2, h / (double) 2);
        at.rotate(rads, 0, 0);
        at.translate(-img.getWidth() / (double) 2, -img.getHeight() / (double) 2);
        final AffineTransformOp rotateOp = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
        rotateOp.filter(img, rotatedImage);
        return rotatedImage;
    }
}
