package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;


public class MultiplTestCases {
	WebDriver driver;
	WebElement e;
	@BeforeMethod
	public void init() {
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));


	}

	@Test
	public void chechNames() {

		e =  driver.findElement(By.name("q"));
		e.sendKeys("Hello");

	}

	@Test
	public void chechName() {

		e =  driver.findElement(By.name("q"));
		e.sendKeys("Bye");

	}

	@Test
	public void chechNaam() {

		e =  driver.findElement(By.name("q"));
		e.sendKeys("Thank You");

	}
	@AfterMethod
	public void tearDown() {
		if(driver != null) {
			driver.quit();
			driver = null;
		}
	}
}
