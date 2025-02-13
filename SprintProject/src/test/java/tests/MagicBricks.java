package tests;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MagicBricks {
	public static void main(String[] args) throws Exception{
		WebDriver drv = new ChromeDriver();
		drv.navigate().to("https://www.magicbricks.com");
		drv.manage().window().maximize();
		Thread.sleep(10000);
		WebElement buylink = drv.findElement(By.linkText("Buy"));
		Thread.sleep(10000);
		Actions act = new Actions(drv);
		act.moveToElement(buylink).perform();
		String parent_handle = drv.getWindowHandle();
		Thread.sleep(10000);
		drv.findElement(By.xpath("//a[contains(text(),'Ready to Move')]")).click();
		Set<String> winhandles = drv.getWindowHandles();
		for(String handles:winhandles) {
			if(!handles.equals(parent_handle)) {
				drv.switchTo().window(handles);
				break;
			}
		}
		Thread.sleep(10000);
		RemoteWebDriver rdrv = (RemoteWebDriver) drv;
		rdrv.executeScript("document.scrollBy(0,400)");
	}
}
