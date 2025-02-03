package tetngclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class SeleniumTest {
	WebDriver drv;
	
	@BeforeMethod
	public void init() {
		drv = new ChromeDriver();
	}
	
	@Test(dataProvider = ("usernames, links"))
	public void test(String username, String url) throws Exception{
		drv.navigate().to(url);
		WebElement ele = drv.findElement(By.name("q"));
		Thread.sleep(2000);
		ele.sendKeys(username);
		Thread.sleep(2000);
		System.out.println("List of usernames:" + username);
	}
	
	
	@DataProvider(name = "usernames, links")
	public Object[][] getDummyData(){
		return new Object[][] {
			{"Siddhi","https://www.google.com"}
		};
		
	}
	@AfterMethod
	public void tearDown() {
		if(drv != null) {
			drv.quit();
		}
	}

}
