package driversetup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SetupDriver {
	private static WebDriver driver;
	private SetupDriver() {
	}
	
	@BeforeClass
	public static WebDriver getDriver(String browsername,String url) {
		if(driver==null) {
			switch (browsername.toLowerCase()) {
			case "chrome":
				System.setProperty("webdriver.chrome.driver", "./chromedriver/chromedriver.exe");
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--disable-popup-blocking");
				options.addArguments("--disable-notifications");
				driver = new ChromeDriver(options);
				driver.navigate().to(url);
				break;
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				FirefoxOptions firefox_options = new FirefoxOptions();
				firefox_options.addPreference("dom.disable_open_during_load",true);
				driver = new FirefoxDriver(firefox_options);
				driver.navigate().to(url);
				break;

			case "edge":
				WebDriverManager.edgedriver().setup();
				EdgeOptions edge_options = new EdgeOptions();
				edge_options.addArguments("--disable-popup-blocking");
				driver = new EdgeDriver(edge_options);
				driver.navigate().to(url);
				break;

			default:
				throw new IllegalArgumentException("Unsupported Browser");
			}
		}
		driver.manage().window().maximize();
		return driver;

	} 

	@AfterClass
	public static void quitDriver() {
		if(driver != null) {
			driver.quit();
			driver = null;
		}
	}
}