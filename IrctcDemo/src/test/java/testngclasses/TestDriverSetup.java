package testngclasses;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utilities.DriverSetup;

public class TestDriverSetup {
	private static WebDriver driver;
	
	@BeforeClass
	public void initialize() {
		driver = DriverSetup.getDriver("safari");
		driver.navigate().to("https://www.google.com");
		driver.manage().window().maximize();
	}
	
	@Test
	public void testTerms() {
		WebElement search = driver.findElement(By.name("q"));
		search.click();
		search.sendKeys("Good Night");

	}
}
