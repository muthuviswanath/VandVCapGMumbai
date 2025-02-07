package testngclasses;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Cross extends CrossBrowserBase{

	@Test
	@Parameters("query")
	public void googleSearch(String query) throws Exception{
		drv.navigate().to("https://www.google.com");
		WebDriverWait wait = new WebDriverWait(drv, Duration.ofSeconds(5));
		WebElement ele = wait.until(ExpectedConditions.visibilityOf(drv.findElement(By.name("q"))));
		ele.click();
		ele.sendKeys(query);
		ele.submit();
		Reporter.log("Browser:" + drv + " | Page Title: " + drv.getTitle());
		Thread.sleep(5000);
		
	}
}
