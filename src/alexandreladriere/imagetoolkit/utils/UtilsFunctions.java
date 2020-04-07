package alexandreladriere.imagetoolkit.utils;

public final class UtilsFunctions {

    /**
     * Checks if the given string represents an integer or not
     *
     * @param str String that you want to convert to int
     * @return Boolean to indicates if you can convert it to string ot not
     */
    public static boolean isInteger(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        if (length == 0) {
            return false;
        }
        int i = 0;
        if (str.charAt(0) == '-') {
            if (length == 1) {
                return false;
            }
            i = 1;
        }
        for (; i < length; i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }
}
