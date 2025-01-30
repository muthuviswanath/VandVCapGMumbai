package fundamentals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MouseActions {
	public static void main(String[] args) throws Exception{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://lms.educatio.co.in");
		WebElement ele = driver.findElement(By.xpath("//input[@id='disabled_text']"));
		String script = "document.getElementById('disabled_text').value = 'God save the people of India'";
		RemoteWebDriver rem = (RemoteWebDriver)driver;
		rem.executeScript(script);
		String alert = "window.alert('Have you all stopped throwing away your bags after going to your rooom? ')"; 
		rem.executeScript(alert);
		Thread.sleep(2000);
		Alert a = driver.switchTo().alert();
		a.accept();
		
//		String myscrollscript = "window.scrollBy(0,950)";
//		rem.executeScript(myscrollscript);
//		Thread.sleep(2000);
//		"//button[@id='mousehover']"
		WebElement mouseover_button = driver.findElement(By.xpath("//button[@id='mousehover']"));
		
		Actions act = new Actions(driver);
		act.moveToElement(mouseover_button).click().perform();
		Thread.sleep(2000);
		WebElement top_option = driver.findElement(By.xpath("//a[contains(text(),'Top')]"));
		act.moveToElement(top_option).click().perform();
		
//		act.click(driver.findElement(By.xpath())).build().perform();
		
		
//		//Scroll to the bottom of the webpage
//		String scrollToBottom = "window.scrollBy(0,document.body.scrollHeight);";
//		rem.executeScript(scrollToBottom);
		
		
	}
}
