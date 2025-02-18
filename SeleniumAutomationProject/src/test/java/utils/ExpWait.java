package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExpWait {

	static public WebElement waitForElement(WebDriver drv, int waittime,WebElement ele) {
		WebDriverWait exp_wait = new WebDriverWait(drv, Duration.ofSeconds(waittime));
		return exp_wait.until(ExpectedConditions.visibilityOf(ele));
	}
}