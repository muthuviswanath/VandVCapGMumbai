package tests;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NoBrokerCheck {
    public static void main(String[] args) {
        // Set up ChromeDriver
        System.setProperty("webdriver.chrome.driver", "./chromedriver/chromedriver.exe");
        WebDriver drv = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(drv, Duration.ofSeconds(10));

        try {
            // Open NoBroker
        	drv.get("https://www.nobroker.in");
        	drv.manage().window().maximize();
        	
        	Thread.sleep(8000);
            drv.findElement(By.xpath("//button[text()='Post Free Property Ad']")).click();
            Thread.sleep(8000);
    		wait = new WebDriverWait(drv, Duration.ofSeconds(20));
    		WebElement add_name = drv.findElement(By.xpath("//input[@id='userName']"));
            WebElement add_email= drv.findElement(By.xpath("//input[@id='userEmail']"));
            WebElement add_phone = drv.findElement(By.xpath("//input[@id='userPhone']"));
            WebElement add_city= drv.findElement(By.xpath("//div[@class='css-151xaom-placeholder nb-select__placeholder']"));
    		add_name.sendKeys("Muthu");
    		Thread.sleep(3000);
    		add_email.sendKeys("muthuviswanath@outlook.com");
    		Thread.sleep(3000);
    		add_phone.sendKeys("7904093412");
    		Thread.sleep(3000);
    		WebElement iframe = drv.findElement(By.xpath("//iframe[@id='webWidget']"));
    		if (iframe.isDisplayed()) {
    			drv.switchTo().frame(iframe);
    			WebElement minimizeButton = drv.findElement(By.xpath("//button[@aria-label='Minimize widget']"));
    			minimizeButton.click();
    			drv.switchTo().defaultContent();
    			Thread.sleep(8000);
    		}
    		WebElement select_city = drv.findElement(By.xpath("//div[@class='css-151xaom-placeholder nb-select__placeholder']"));
        Thread.sleep(8000);
    		select_city.click();
    		WebElement cityOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Mumbai']")));
    		cityOption.click();
    		// Click at Specific Coordinates
    		int xCoordinate = 1093;
    		int yCoordinate = 269;

    		RemoteWebDriver r = (RemoteWebDriver) drv;
    		String script = "var event = new MouseEvent('click', {" +
    				"bubbles: true, cancelable: true, view: window, " +
    				"clientX: " + xCoordinate + ", clientY: " + yCoordinate + " " +
    				"}); " +
    				"document.elementFromPoint(" + xCoordinate + ", " + yCoordinate + ").dispatchEvent(event);";

    		r.executeScript(script);
    		Thread.sleep(5000);
    	
    		
    		
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            drv.quit();
        }
    }
}


