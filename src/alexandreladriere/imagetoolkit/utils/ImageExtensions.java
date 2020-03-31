package alexandreladriere.imagetoolkit.utils;

public enum ImageExtensions {
    PNG("png"),
    JPG("jpg"),
    JPEG("jpeg"),
    GIF("gif"),
    BMP("bmp");

    private String extension;

    ImageExtensions(String extension) {
        this.extension = extension;
    }

    /**
     * Check if the given string is in the enum list
     *
     * @param s Extension you want to check
     * @return A boolean to indicate if the given string is in the list
     */
    public static boolean contains(String s) {
        for (ImageExtensions imageExtension : values())
            if (imageExtension.toString().equals(s))
                return true;
        return false;
    }

    /**
     * toString method
     *
     * @return Returns the extension
     */
    public String toString() {
        return extension;
    }
}
