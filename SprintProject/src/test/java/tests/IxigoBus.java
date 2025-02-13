package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

import driversetup.SetupDriver;

public class IxigoBus {
	static WebDriver driver;
	public static void main(String[] args) {
		driver = SetupDriver.getDriver("chrome", "https://www.ixigo.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//iframe[@id='wiz-iframe-intent']")).click();
		driver.get("https://www.ixigo.com");
		driver.findElement(By.xpath("//a[@href='/buses']")).click();
		driver.navigate().back();
	}
}
