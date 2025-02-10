package driversetup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SetupDriver {
	private static WebDriver driver;

	private SetupDriver() {
	}
	
	public static WebDriver getDriver(String browsername) {
		if(driver==null) {
			switch (browsername.toLowerCase()) {
			case "chrome":
				WebDriverManager.chromedriver().setup();
				ChromeOptions chrome_options = new ChromeOptions();
				chrome_options.addArguments("--disable-popup-blocking");
				driver = new ChromeDriver(chrome_options);
				break;
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				FirefoxOptions firefox_options = new FirefoxOptions();
				firefox_options.addPreference("dom.disable_open_during_load",true);
				driver = new FirefoxDriver(firefox_options);

				break;
			
			case "edge":
				WebDriverManager.edgedriver().setup();
				EdgeOptions edge_options = new EdgeOptions();
				edge_options.addArguments("--disable-popup-blocking");
				driver = new EdgeDriver(edge_options);
				break;

			default:
				throw new IllegalArgumentException("Unsupported Browser");
			}
		}
		driver.manage().window().maximize();
		return driver;

	} 
	
	public static void quitDriver() {
		if(driver != null) {
			driver.quit();
			driver = null;
		}
	}
}