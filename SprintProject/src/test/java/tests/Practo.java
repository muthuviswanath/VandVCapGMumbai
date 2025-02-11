package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.LoginPage;
import pages.PractoBase;
import utils.ExcelReader;

public class Practo {
	public static void main(String[] args)throws Exception {
		WebDriver drv  = new ChromeDriver();
		drv.navigate().to("https://www.practo.com");
		drv.manage().window().maximize();
		drv.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		PractoBase practobase = new PractoBase(drv);
		practobase.clickLogin();
		LoginPage login = new LoginPage(drv);
		String uname = ExcelReader.getCellData("./src/test/resources/exceldata/TestData.xlsx", "Sheet1", 1, 0);
		String pwd = ExcelReader.getCellData("./src/test/resources/exceldata/TestData.xlsx", "Sheet1", 1, 1);
		login.login(uname, pwd);
	}
}
