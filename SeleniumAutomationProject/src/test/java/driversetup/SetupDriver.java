package driversetup;

import java.util.HashMap;
import java.util.Map;

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
		if (driver == null) {
			switch (browsername.toLowerCase()) {
			case "chrome":
				System.setProperty("webdriver.chrome.driver", "./chromedriver/chromedriver.exe");
				ChromeOptions options = new ChromeOptions();

				Map<String, Object> prefs = new HashMap<>();
				prefs.put("profile.default_content_setting_values.notifications", 1);
				prefs.put("profile.default_content_setting_values.geolocation", 1);
				options.setExperimentalOption("prefs", prefs);

				driver = new ChromeDriver(options);
				break;

			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				FirefoxOptions firefoxOptions = new FirefoxOptions();
				firefoxOptions.addPreference("permissions.default.desktop-notification", 1);
				firefoxOptions.addPreference("geo.enabled", true);
				firefoxOptions.addPreference("geo.prompt.testing", true);
				driver = new FirefoxDriver(firefoxOptions);
				break;

			case "edge":
				WebDriverManager.edgedriver().setup();
				EdgeOptions edgeOptions = new EdgeOptions();

				Map<String, Object> edgePrefs = new HashMap<>();
				edgePrefs.put("profile.default_content_setting_values.notifications", 1);
				edgePrefs.put("profile.default_content_setting_values.geolocation", 1);
				edgeOptions.setExperimentalOption("prefs", edgePrefs);

				driver = new EdgeDriver(edgeOptions);
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