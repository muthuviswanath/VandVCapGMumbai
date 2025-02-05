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
import utilities.TakeScreenShot;

public class BookTicket {
	WebDriver drv = new FirefoxDriver();
	Homepage home = new Homepage(drv);
	TrainResults train_results = new TrainResults(drv);
	
	FileInputStream fis;
	Workbook wb;
	@BeforeClass
	public void navigate() throws Exception {
		drv.navigate().to(Homepage.baseURL);
		drv.manage().window().maximize();
		String expected_title = "IRCTC Next Generation eTicketing System";
		Assert.assertEquals(drv.getTitle(),expected_title);	
		TakeScreenShot.takeScreenShot(drv, "Homepage");
	}

	@BeforeTest
	public void initializeTestData() throws Exception{
		fis = new FileInputStream("C:/Users/muthu/OneDrive/Desktop/IRCTC_TestData.xlsx");
		wb = WorkbookFactory.create(fis);
	}
	

	@Test
	public void loginToApp()throws Exception {

		boolean assert_result = home.clickLogin();
		Assert.assertEquals(assert_result,true);
		TakeScreenShot.takeScreenShot(drv, "After_Login_Click");
		Cell username = wb.getSheet("IRCTC_HomePage").getRow(1).getCell(0);
		home.enterUserName(username.toString());
		TakeScreenShot.takeScreenShot(drv, "After_Entering_Username");
		Cell password = wb.getSheet("IRCTC_HomePage").getRow(1).getCell(1);
		home.enterPassword(password.toString());
		TakeScreenShot.takeScreenShot(drv, "After_Entering_Password");
		WebElement captcha =  drv.findElement(By.xpath("//div[@role='form']//input[@placeholder='Enter Captcha'][@id='captcha']"));
		captcha.click();
		Thread.sleep(15000);
		TakeScreenShot.takeScreenShot(drv, "After_Entering_Captcha");
		boolean login_success_msg = home.LoginToAppliation();
		Assert.assertEquals(login_success_msg, true);

		Cell source = wb.getSheet("IRCTC_HomePage").getRow(1).getCell(2);
		home.enterSource(source.toString());
		TakeScreenShot.takeScreenShot(drv, "After_Entering_Source");
		
		Cell destn = wb.getSheet("IRCTC_HomePage").getRow(1).getCell(3);
		home.enterDestination(destn.toString());

		TakeScreenShot.takeScreenShot(drv, "After_Entering_Destination");
		
		Cell travel_date = wb.getSheet("IRCTC_HomePage").getRow(1).getCell(4);
		home.enterTravelDate(travel_date.toString());

		TakeScreenShot.takeScreenShot(drv, "After_Entering_TravelDate");
		home.searchTrains();
		TakeScreenShot.takeScreenShot(drv, "After_Clicking_Search_Trains");


	}
}
