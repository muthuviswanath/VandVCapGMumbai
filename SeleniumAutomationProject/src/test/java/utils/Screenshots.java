package utils;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshots {

    // Capture screenshot and save as a file
    public String takeScreenShot(WebDriver drv, String filename) throws Exception {
        if (drv == null) {
            System.err.println("Error: WebDriver instance is null in takeScreenShot.");
            return "";
        }

        // ✅ Ensure the screenshots directory exists
        String screenshotDir = System.getProperty("user.dir") + "/screenshots";
        File dir = new File(screenshotDir);
        if (!dir.exists()) {
            dir.mkdirs(); // Create directory if it doesn't exist
        }

        // ✅ Remove invalid characters from filename
        filename = filename.replaceAll("[^a-zA-Z0-9-_]", "_");

        File screenshot = ((TakesScreenshot) drv).getScreenshotAs(OutputType.FILE);
        String screenshotName = filename + ".png";
        String screenshotPath = screenshotDir + File.separator + screenshotName;

        FileUtils.copyFile(screenshot, new File(screenshotPath));

        return screenshotPath;
    }
}
