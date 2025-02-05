package utilities;
import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakeScreenShot {
	static int imgcount = 1;
	public static void takeScreenShot(WebDriver drv,String filename) throws Exception {

		File ss = ((TakesScreenshot)drv).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(ss, new File("./screenshots/Step_"+ (imgcount++) +"_"+filename+".png"));
	}
}

