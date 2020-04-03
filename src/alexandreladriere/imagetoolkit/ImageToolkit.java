package alexandreladriere.imagetoolkit;

import alexandreladriere.imagetoolkit.utils.FilePathManipulation;
import alexandreladriere.imagetoolkit.utils.ImageExtensions;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.RoundRectangle2D;
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
     * @param outPath   Destination path to save the image to (with file name)
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
     * @param outPath Destination path to save the image to (with file name)
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
     * @param outPath Destination path to save the image to (with file name)
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
                ImageIO.write(rotated, extensionOut, output);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Crop the given images (the crop is a rectangle crop)
     *
     * @param inPath  Path of the image that you want to crop (with file name)
     * @param outPath Destination path (with file name)
     * @param startX  X of the upper left corner of the rectangle
     * @param startY  Y of the upper left corner of the rectangle
     * @param endX    X of the lower right corner of the rectangle
     * @param endY    Y of the lower right corner of the rectangle
     */
    public static void crop(String inPath, String outPath, int startX, int startY, int endX, int endY) {
        String extensionIn = FilePathManipulation.getExtension(inPath).toLowerCase();
        String extensionOut = FilePathManipulation.getExtension(outPath).toLowerCase();
        // checks if the given file format is supported
        if (ImageExtensions.contains(extensionIn) && ImageExtensions.contains(extensionOut)) {
            File input = new File(inPath);
            try {
                BufferedImage image = ImageIO.read(input);
                BufferedImage cropped = crop(image, startX, startY, endX, endY, extensionOut.equals(ImageExtensions.PNG.toString()));
                File output = new File(outPath);
                ImageIO.write(cropped, extensionOut, output);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Transform the corners of the given image to rounded corners
     *
     * @param inPath       Path of the image that you want to crop (with file name)
     * @param outPath      (Destination path (with file name)
     * @param cornerRadius Radius that you want for the curve of the corners
     */
    public static void makeRoundedCorner(String inPath, String outPath, int cornerRadius) {
        String extensionIn = FilePathManipulation.getExtension(inPath).toLowerCase();
        String extensionOut = FilePathManipulation.getExtension(outPath).toLowerCase();
        // checks if the given file format is supported
        if (ImageExtensions.contains(extensionIn) && ImageExtensions.contains(extensionOut)) {
            File input = new File(inPath);
            try {
                BufferedImage image = ImageIO.read(input);
                File output = new File(outPath);
                BufferedImage rounded = makeRoundedCorner(image, cornerRadius, extensionOut.equals(ImageExtensions.PNG.toString()));
                ImageIO.write(rounded, extensionOut, output);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Convert the given image
     *
     * @param inPath  Path of the image that you want to convert (with file name)
     * @param outPath Destination path (with file name)
     */
    public static void convert(String inPath, String outPath) {
        String extensionIn = FilePathManipulation.getExtension(inPath).toLowerCase();
        String extensionOut = FilePathManipulation.getExtension(outPath).toLowerCase();
        // checks if the given file format is supported
        if (ImageExtensions.contains(extensionIn) && ImageExtensions.contains(extensionOut)) {
            File input = new File(inPath);
            try {
                BufferedImage image = ImageIO.read(input);
                File output = new File(outPath);
                ImageIO.write(image, extensionOut, output);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Crop the given image, according to the given positions (which is a rectangle)
     *
     * @param img    Image that you want to crop
     * @param startX X of the upper left corner
     * @param startY Y of the upper left corner
     * @param endX   X of the lower right corner
     * @param endY   Y of the lower right corner
     * @param isPng  Boolean to indicates if the image is a png or not, in order to know if we can use alpha or not (true: png; false: not png)
     * @return The cropped image
     */
    public static BufferedImage crop(BufferedImage img, int startX, int startY, int endX, int endY, boolean isPng) {
        BufferedImage tmp = img.getSubimage(startX, startY, img.getWidth() - (startX + (img.getWidth() - endX)), img.getHeight() - (startY + (img.getHeight() - endY)));
        int rgbType;
        if (isPng) {
            rgbType = BufferedImage.TYPE_INT_ARGB; // allows alpha for png format
        } else {
            rgbType = BufferedImage.TYPE_INT_RGB;
        }
        BufferedImage cropped = new BufferedImage(tmp.getWidth(), tmp.getHeight(), rgbType);
        Graphics g = cropped.createGraphics();
        g.drawImage(tmp, 0, 0, null);
        return cropped;
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
    public static BufferedImage resize(BufferedImage img, int height, int width, int scaleType, boolean isPng) {
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
    public static BufferedImage rotate(BufferedImage img, double angle, boolean isPng) {
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

    /**
     * Make rounded corner to the given image
     *
     * @param image        Image that you want to transform
     * @param cornerRadius Radius that you want for the curve of the corners
     * @param isPng        Boolean to indicates if the image is a png or not, in order to know if we can use alpha or not (true: png; false: not png)
     * @return Input image with rounded corner
     */
    public static BufferedImage makeRoundedCorner(BufferedImage image, int cornerRadius, boolean isPng) {
        int w = image.getWidth();
        int h = image.getHeight();
        int rgbType;
        if (isPng) {
            rgbType = BufferedImage.TYPE_INT_ARGB; // allows alpha for png format
        } else {
            rgbType = BufferedImage.TYPE_INT_RGB;
        }
        BufferedImage output = new BufferedImage(w, h, rgbType);
        Graphics2D g2 = output.createGraphics();
        g2.setComposite(AlphaComposite.Src);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.WHITE);
        g2.fill(new RoundRectangle2D.Float(0, 0, w, h, cornerRadius, cornerRadius));
        g2.setComposite(AlphaComposite.SrcIn);
        g2.drawImage(image, 0, 0, null);
        g2.dispose();
        return output;
    }
}
