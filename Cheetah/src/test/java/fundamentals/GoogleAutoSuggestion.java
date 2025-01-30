package fundamentals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleAutoSuggestion {
	public static void main(String[] args) throws Exception{
		WebDriver drv = new ChromeDriver();
		drv.manage().window().maximize();
		drv.navigate().to("https://www.google.com");
		WebElement w =  drv.findElement(By.name("q"));
		w.click();
		w.sendKeys("Selenium");
		List<WebElement> suggestion_list = drv.findElements(By.xpath("//ul[@role='listbox']/li"));
		Thread.sleep(3000);
		for(WebElement suggestion:suggestion_list) {
			if(suggestion.getText().equalsIgnoreCase("selenium testing")) {
				suggestion.click();
				break;
			}
		}
		Thread.sleep(3000);
		System.out.println("Time for Lunch. Have a feast.");
	}
}
