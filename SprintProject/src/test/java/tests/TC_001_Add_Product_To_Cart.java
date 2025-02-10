/**
 * Created By: Muthu
 * Created On: 10-Feb-2025
 * Evaluated By: 
 */
package tests;

import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import driversetup.SetupDriver;
import utils.ExpWait;
import pages.BasePage;

/**
 * This is the test script for the scenario of adding a product to the cart
 */
public class TC_001_Add_Product_To_Cart {
	

	static BasePage basepage;
	@BeforeClass
	public void init() {
		// Running the test script in chrome driver
		WebDriver drv =  SetupDriver.getDriver("Chrome");
		basepage = new BasePage(drv);
		
		//Using Explicit Wait till the page gets loaded
		
		WebElement ab = basepage.getAbcd(); 
		ab = ExpWait.waitForElement(drv, 10, ab);
	}

}
