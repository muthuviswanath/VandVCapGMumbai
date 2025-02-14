package tests;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BestBuy {
	public static void main(String[] args) throws Exception {
		
		ChromeOptions options = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values.geolocation", 1);
		options.setExperimentalOption("prefs", prefs);
		WebDriver drv = new ChromeDriver(options);
		drv.navigate().to("http://www.bestbuy.com");
		drv.findElement(By.xpath("//img[@alt='United States']")).click();
		Thread.sleep(3000);
		drv.findElement(By.xpath("//input[@id='gh-search-input']")).click();
		drv.findElement(By.xpath("//input[@id='gh-search-input']")).sendKeys("out of the stock");
	}
}
