/**
 * Created By: Muthu
 * Created On: 10-Feb-2025
 * Evaluated By: 
 */
package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import driversetup.SetupDriver;
import pages.IxigoBasePage;

/**
 * This is the test script for the scenario of adding a product to the cart
 */
public class IxigoCheck {
	
	private static WebDriver driver;
	static IxigoBasePage basepage;
	@BeforeTest
	public void initialize() {
		driver = SetupDriver.getDriver("chrome", "https://www.ixigo.com/");
	}
	@Test
	public void init() throws Exception {
		// Running the test script in chrome driver
		basepage = new IxigoBasePage(driver);
		Thread.sleep(2000);
		basepage.searchFlights("Bengaluru", "BLR", "Chennai", "MAA", "February 16");
	}

}
