package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class NoBrokerCheck {
	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver drv = new ChromeDriver(options);
		drv.navigate().to("https://www.nobroker.in");
		drv.manage().window().maximize();
		drv.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		drv.findElement(By.xpath("//div[contains(text(),'Bangalore')]")).click();
		Actions actions = new Actions(drv);
        int xOffset = 50; // Adjust X offset as needed
        int yOffset = 100; // Adjust Y offset as needed
        actions.moveToElement(drv.findElement(By.xpath("//div[contains(text(),'Bangalore')]"))).moveByOffset(xOffset, yOffset).click().perform();
	}
}
