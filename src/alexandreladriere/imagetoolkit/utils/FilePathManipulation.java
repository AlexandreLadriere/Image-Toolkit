package alexandreladriere.imagetoolkit.utils;

/**
 * Implement basic file path manipulations
 */
public final class FilePathManipulation {
    /**
     * Get the extension of a file from its path
     *
     * @param filePath Path of the file you want to get the extension
     * @return extension of the given path (with the dot, e.g. ".png"). If there is no extension, it will return an empty string
     */
    public static String getExtension(String filePath) {
        String extension = "";

        int i = filePath.lastIndexOf('.');
        int p = Math.max(filePath.lastIndexOf('/'), filePath.lastIndexOf('\\'));

        if (i > p) {
            extension = filePath.substring(i + 1); // Remove the dot
        }
        return extension;
    }
}
