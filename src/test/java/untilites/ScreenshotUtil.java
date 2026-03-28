package untilites;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.apache.commons.io.FileUtils;
public class ScreenshotUtil {

    public static String captureScreenshot(WebDriver driver, String scenarioName) {

        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

        String filePath = System.getProperty("user.dir")
                + "/screenshots/" + scenarioName + "_" + timeStamp + ".png";

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(src, new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return filePath;
    }
    public static byte[] captureScreenshotForReport(WebDriver driver) {

        TakesScreenshot ts = (TakesScreenshot) driver;
        return ts.getScreenshotAs(OutputType.BYTES);
    }
    public static void deleteOldScreenshots() {

        File folder = new File(System.getProperty("user.dir") + "/screenshots");

        if (folder.exists()) {

            File[] files = folder.listFiles();

            if (files != null) {
                for (File file : files) {
                    file.delete();
                }
            }
        }
    }

}
