package testngclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class CrossBrowserBase {
	protected WebDriver drv;

	@Parameters("browsers")
	@BeforeMethod
	public void browserSetup(String browser_name) {
		if(browser_name.equalsIgnoreCase("chrome")) {
			drv = new ChromeDriver();
		}
		else if(browser_name.equalsIgnoreCase("firefox")) {
			drv = new FirefoxDriver();
		}
		else {
			throw new IllegalArgumentException("Invalid browser object: " + browser_name);
		}
	}
	
	@AfterMethod
	public void tearDown() {
		if(drv !=null) {
			drv.quit();
		}
	}
}
