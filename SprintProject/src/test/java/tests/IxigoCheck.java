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
import pages.FlightsResult;
import pages.IxigoBasePage;
import utils.BaseReport;
import utils.Screenshots;

/**
 * This is the test script for the scenario of adding a product to the cart
 */
public class IxigoCheck extends BaseReport{
	
	private static WebDriver driver;
	static IxigoBasePage basepage;
	static FlightsResult flightresult;
	static Screenshots screenshots = new Screenshots();
	@BeforeTest
	public void initialize() {
		driver = SetupDriver.getDriver("chrome", "https://www.ixigo.com/");
	}
	@Test
	public void init() throws Exception {
		// Running the test script in chrome driver
		basepage = new IxigoBasePage(driver);
		Thread.sleep(2000);
		ext_test = ext_reports.createTest("Ixigo Scenario","Navigation Page Step");
		String screenshot= screenshots.takeScreenShot(driver, "Homepage");
		ext_test.addScreenCaptureFromPath(screenshot);
		basepage.searchFlights("Bengaluru", "BLR", "Chennai", "MAA", "February 20");
		Thread.sleep(4000);
		flightresult = new FlightsResult(driver);
		flightresult.bookFlights();
	}

}
