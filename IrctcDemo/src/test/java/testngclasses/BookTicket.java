package testngclasses;




import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import objectrepository.Homepage;
import objectrepository.TrainResults;
import utilities.BaseReport;
import utilities.TakeScreenShot;

public class BookTicket extends BaseReport{
	WebDriver drv = new FirefoxDriver();
	Homepage home = new Homepage(drv);
	TrainResults train_results = new TrainResults(drv);
	TakeScreenShot ts = new TakeScreenShot();
	String screenshot;
	FileInputStream fis;
	Workbook wb;
	@BeforeClass
	public void navigate() throws Exception {
		drv.navigate().to(Homepage.baseURL);
		drv.manage().window().maximize();
		String expected_title = "IRCTC Next Generation eTicketing System";
		ext_test = ext_reports.createTest("IRCTC Search Trains Scenario","Navigation Page Step");
		Assert.assertEquals(drv.getTitle(),expected_title);	
		screenshot= ts.takeScreenShot(drv, "Homepage");
		ext_test.addScreenCaptureFromPath(screenshot);
		
	}

	@BeforeTest
	public void initializeTestData() throws Exception{
		fis = new FileInputStream("C:/Users/muthu/OneDrive/Desktop/IRCTC_TestData.xlsx");
		wb = WorkbookFactory.create(fis);
	}
	

	@Test
	public void loginToApp()throws Exception {

		boolean assert_result = home.clickLogin();
		ext_test = ext_reports.createTest("IRCTC Search Trains Scenario","After Login");
		Assert.assertEquals(assert_result,true);
		screenshot= ts.takeScreenShot(drv, "After_Login_Click");
		ext_test.addScreenCaptureFromPath(screenshot);
		
		Cell username = wb.getSheet("IRCTC_HomePage").getRow(1).getCell(0);
		home.enterUserName(username.toString());
		ext_test = ext_reports.createTest("IRCTC Search Trains Scenario","Entering User Name");
		screenshot= ts.takeScreenShot(drv, "After_Entering_Username");
		ext_test.addScreenCaptureFromPath(screenshot);
		
		Cell password = wb.getSheet("IRCTC_HomePage").getRow(1).getCell(1);
		home.enterPassword(password.toString());
		screenshot= ts.takeScreenShot(drv, "After_Entering_Password");
		ext_test = ext_reports.createTest("IRCTC Search Trains Scenario","Entering Password");
		screenshot= ts.takeScreenShot(drv, "After_Entering_Password");
		ext_test.addScreenCaptureFromPath(screenshot);
		
		WebElement captcha =  drv.findElement(By.xpath("//div[@role='form']//input[@placeholder='Enter Captcha'][@id='captcha']"));
		captcha.click();
		Thread.sleep(15000);
		screenshot= ts.takeScreenShot(drv, "After_Entering_Captcha");
		boolean login_success_msg = home.LoginToAppliation();
		ext_test = ext_reports.createTest("IRCTC Search Trains Scenario","After Login");
		Assert.assertEquals(login_success_msg, true);
		screenshot= ts.takeScreenShot(drv, "After_Login");
		ext_test.addScreenCaptureFromPath(screenshot);

		Cell source = wb.getSheet("IRCTC_HomePage").getRow(1).getCell(2);
		home.enterSource(source.toString());
		ext_test = ext_reports.createTest("IRCTC Search Trains Scenario","After_Entering_Source");
		screenshot= ts.takeScreenShot(drv, "After_Entering_Source");
		ext_test.addScreenCaptureFromPath(screenshot);
		
		Cell destn = wb.getSheet("IRCTC_HomePage").getRow(1).getCell(3);
		home.enterDestination(destn.toString());
		ext_test = ext_reports.createTest("IRCTC Search Trains Scenario","After_Entering_Destination");
		screenshot= ts.takeScreenShot(drv, "After_Entering_Destination");
		ext_test.addScreenCaptureFromPath(screenshot);
		
		Cell travel_date = wb.getSheet("IRCTC_HomePage").getRow(1).getCell(4);
		home.enterTravelDate(travel_date.toString());

		screenshot= ts.takeScreenShot(drv, "After_Entering_TravelDate");
		home.searchTrains();
		ext_test = ext_reports.createTest("IRCTC Search Trains Scenario","After Searching the trains");
		screenshot= ts.takeScreenShot(drv, "After_Clicking_Search_Trains");
		ext_test.addScreenCaptureFromPath(screenshot);
		

	}
}
