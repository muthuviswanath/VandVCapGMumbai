package fundamentals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MouseActions {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://lms.educatio.co.in");
		WebElement ele = driver.findElement(By.xpath("//input[@id='disabled_text']"));
		String script = "document.getElementById('disabled_text').value = 'God save the people of India'";
		RemoteWebDriver rem = (RemoteWebDriver)driver;
		rem.executeScript(script);
		String alert = "window.alert('Have you all stopped throwing away your bags after going to your rooom? ')"; 
		rem.executeScript(alert);
//		WebElement mouseover_button = driver.findElement(By.xpath("//button[@id='mousehover']"));
//		Actions act = new Actions(driver);
//		act.moveToElement(mouseover_button).build().perform();
		
	}
}
