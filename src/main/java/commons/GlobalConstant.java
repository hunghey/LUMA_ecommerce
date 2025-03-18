package commons;

import java.nio.file.Paths;

public class GlobalConstant {
    public static final String PROJECT_PATH = System.getProperty("user.dir");
    public static final String OS_NAME = System.getProperty("os.name");
    public static final String SEPARATOR = System.getProperty("file.separator");

    public static final long SHORT_TIMEOUT =10;
    public static final long LONG_TIMEOUT = 30;

    public static final String DEV_ADMIN_URL="";

    public static String getUploadPath() {
        return Paths.get(PROJECT_PATH, "src", "test", "resources", "images").toString() + SEPARATOR;
    }

    public static String getScreenshotpathPath() {
        return Paths.get(PROJECT_PATH, "src", "test", "resources","screenshots").toString() + SEPARATOR;
    }

}
