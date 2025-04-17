package util;

import java.util.ResourceBundle;

public class ExtractString {
    private static final ResourceBundle resourceBundle;

    static {resourceBundle=ResourceBundle.getBundle("properties/pageText");}

    public static String getString(String key){
        return resourceBundle.getString(key);
    }
}
