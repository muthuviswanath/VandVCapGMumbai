package tetngclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGAnnotations {
	WebDriver drv;

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Before Suite: Setup system properties for the entire suite.");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("Before Test: Setup test-specific configurations.");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("Before Class: Setup configurations for the class.");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before Method: Setup configurations for each test method.");
		drv = new ChromeDriver();
	}

	@Test(groups = {"smoke"})
	public void testPageTitle() {
		drv.navigate().to("file:///D:/CapG_Mumbai/test_html/TestngAnnotations.html");
		String actual_title = drv.getTitle();
		assert actual_title.equals("Test Page");
		Reporter.log("Title fetched successfully");
	}
	
	@Test(groups = {"regression"})
	public void clickButton() {
		drv.navigate().to("file:///D:/CapG_Mumbai/test_html/TestngAnnotations.html");
		WebElement button = drv.findElement(By.id("ClickMe"));
		button.click();
		Reporter.log("Button Clicked successfully");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("After Method: Closing the browser after every test method execution");
		if(drv != null) {
			drv.quit();
		}
	}
	@AfterClass
	public void afterClass() {
		System.out.println("After Class: Clean up al the test methods in the class");
	} 
	@AfterTest
	public void afterTest() {
		System.out.println("After Test: Clean all the test in the <test> tag");
	}
	@AfterSuite
	public void afterSuite() {
		System.out.println("After Suite: Clean up the entire suite");
	}

	@BeforeGroups("smoke")
	public void beforeSmokeGroup() {
		System.out.println("Before Smoke Group: Setting the environment for Smoke Testing");
	}
	
	@AfterGroups("smoke")
	public void afterSmokeGroup() {
		System.out.println("After Smoke Group: cleaning the environment for Smoke Testing");
	}
	
	@BeforeGroups("regression")
	public void beforeRegressionGroup() {
		System.out.println("Before Regression Group: Setting the environment for Regression Testing");
	}
	
	@AfterGroups("regression")
	public void afterRegressionGroup() {
		System.out.println("After Regression Group: cleaning the environment for Regression Testing");
	}
	
	@DataProvider(name = "testdata")
	public Object[][] testDataProvider(){
		return new Object[][] {
			{"Name"},
			{"Nonsense"}
			
		};
	}
	@Test(dataProvider = "testdata")
	public void usingTestDataProvider(String data) {
		Reporter.log("Data Provier for this test method: " + data);
	}
}