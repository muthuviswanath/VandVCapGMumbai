package utilities;
import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakeScreenShot{
	static int imgcount = 1;
	public String takeScreenShot(WebDriver drv,String filename) throws Exception {
		String screenshotPath = System.getProperty("user.dir") + "/test-output/screenshots";
		File screenshot = ((TakesScreenshot) drv).getScreenshotAs(OutputType.FILE);        
		String screenshotName = "Step_" + (imgcount++) + "_"+filename+".png";
		screenshotPath = screenshotPath + File.separator + screenshotName;
		FileUtils.copyFile(screenshot, new File(screenshotPath));
		return screenshotPath;
	}
}

