package fundamentals;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

public class DemoPage {
	public static void main(String[] args) throws Exception {
		WebDriver drv = new ChromeDriver();
		drv.manage().window().maximize();
		drv.navigate().to("https://lms.educatio.co.in");
		Thread.sleep(2000);
		WebElement radio = drv.findElement(By.xpath("//input[contains(@value,'thon')]"));
		radio.click();
		//Introducing implicit wait
		drv.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebElement clist = drv.findElement(By.xpath("//select[@id='countryselect']"));
		Select country_list = new Select(clist);
		country_list.selectByIndex(2);
		Thread.sleep(500);
		country_list.selectByValue("Nepal");
		Thread.sleep(500);
		country_list.selectByVisibleText("Srilanka");
		country_list.selectByContainsVisibleText("rica");

		Select fruits_list = new Select(drv.findElement(By.xpath("//select[@size='5']")));
		List<WebElement> flist =fruits_list.getOptions();
		for(int i=0; i<flist.size();i++) {
			if(i%2==0) {
				fruits_list.selectByIndex(i);
			}
		}

		//Alerts
		WebElement alerttxtbox = drv.findElement(By.cssSelector("[placeholder='Enter Your Name']"));
		alerttxtbox.sendKeys("Muthu");
		WebElement alrt_btn = drv.findElement(By.xpath("//input[@value='Alert'][@id='alertbtn']"));
		alrt_btn.click();
		Thread.sleep(500);
		Alert a = drv.switchTo().alert();
		System.out.println(a.getText());
		a.accept();

		//Confirm Button
		WebElement cnfrm_button = drv.findElement(By.cssSelector("fieldset > input[value*='firm']"));
		alerttxtbox.sendKeys("Narendra Dhamodar Das Modi");
		cnfrm_button.click();
		Thread.sleep(500);
		Alert cnfrmAlert = drv.switchTo().alert();
		System.out.println(cnfrmAlert.getText());
		cnfrmAlert.dismiss();

//		//Switch to new window, interact with the elements and close it.
//		//Switch back to the parent window and interact with another element.
		String parent_window_handle =  drv.getWindowHandle();
//		System.out.println(parent_window_handle);
//		WebElement open_new_window = drv.findElement(By.xpath("//button[contains(text(),'Open Window')]"));
//		open_new_window.click();
//		Set<String> windows_list = drv.getWindowHandles();
//		System.out.println(windows_list.size());
//		for(String handle: windows_list) {
//			if(!handle.equals(parent_window_handle)) {
//				drv.switchTo().window(handle);
//				WebElement w =  drv.findElement(By.name("q"));
//				w.click();
//				w.sendKeys("Selenium");
//				List<WebElement> suggestion_list = drv.findElements(By.xpath("//ul[@role='listbox']/li"));
//				Thread.sleep(3000);
//				for(WebElement suggestion:suggestion_list) {
//					if(suggestion.getText().contains("selenium web")) {
//						suggestion.click();
//						break;
//					}
//				}
//			}
//		}
//		Thread.sleep(2000);
//		drv.close();
//		drv.switchTo().window(parent_window_handle);
//		System.out.println(drv.getTitle());

		//Switching to multiple tabs
		WebElement new_tabs = drv.findElement(By.xpath("//button[@id='open_new_window']"));
		new_tabs.click();
		Set<String> win_list = drv.getWindowHandles();
		for(String win:win_list) {
			if(drv.switchTo().window(win).getTitle().contains("be")) {
				drv.switchTo().window(win);
				WebElement sq = drv.findElement(By.name("search_query"));
				sq.click();
				sq.sendKeys("Automation Testing");
				Thread.sleep(2000);
				drv.close();
			}		
	}
		Set<String> new_win_list = drv.getWindowHandles();
		for(String han:new_win_list) {
			if(drv.switchTo().window(han).getTitle().contains("le")) {
				drv.switchTo().window(han);
				WebElement w =  drv.findElement(By.name("q"));
				w.click();
				w.sendKeys("Selenium");
				List<WebElement> suggestion_list = drv.findElements(By.xpath("//ul[@role='listbox']/li"));
				Thread.sleep(3000);
				for(WebElement suggestion:suggestion_list) {
					if(suggestion.getText().contains("selenium web")) {
						suggestion.click();
						break;
					}
				}
				drv.close();
			}
			
		}
		
		drv.switchTo().window(parent_window_handle);
		WebElement hidden_text = drv.findElement(By.xpath("//input[@id='displayed-text']"));
		hidden_text.sendKeys("Good Night"); 
		Thread.sleep(2000);
		System.out.println(hidden_text.isDisplayed());
		
		drv.findElement(By.xpath("//input[@id='hide-textbox']")).click();
		Thread.sleep(2000);
		System.out.println(hidden_text.isDisplayed());
		drv.findElement(By.xpath("//input[@id='show-textbox'][@value='Show']")).click();
		System.out.println(hidden_text.isDisplayed());
		
		Thread.sleep(2000);
		
		Actions act = new Actions(drv);
		act.moveToElement(drv.findElement(By.id("courses-iframe"))).perform();
		drv.switchTo().frame("courses-iframe");
		drv.findElement(By.xpath("//label[@for='Python']//input[@type='radio']")).click();
		Thread.sleep(2000);
		drv.switchTo().defaultContent();
		
		RemoteWebDriver rem = (RemoteWebDriver)drv;
		rem.executeScript("window.scrollBy(0,0);");
		Thread.sleep(2000);
		drv.findElement(By.xpath("//input[@id='bmwcheck']")).click();
	}
}







