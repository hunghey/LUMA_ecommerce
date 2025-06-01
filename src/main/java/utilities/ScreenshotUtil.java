package utilities;

import commons.GlobalConstants;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {
    public static String captureScreenshot(WebDriver driver) {
        try {
            // Tạo timestamp để tránh ghi đè file
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

            // Chụp ảnh màn hình
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            // Đường dẫn lưu ảnh
            String screenshotPath = GlobalConstants.getScreenshotpathPath() + timestamp + ".png";

            // Copy ảnh vào thư mục project
            FileUtils.copyFile(srcFile, new File(screenshotPath));

            System.out.println("Screenshot saved: " + screenshotPath);
            return screenshotPath;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
