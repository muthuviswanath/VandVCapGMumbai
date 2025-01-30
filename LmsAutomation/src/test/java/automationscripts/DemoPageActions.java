package automationscripts;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import objectrepository.DemoPage;

public class DemoPageActions {
	static WebDriver drv = new ChromeDriver();
	static String baseURL = "https://lms.educatio.co.in";
	
	void scenarioInitialization() {
		drv.navigate().to(baseURL);
		drv.manage().window().maximize();
		drv.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	static void clickRadioButtons(DemoPage demo) {
		try {
			Thread.sleep(2000);
			demo.choosePython();
			Thread.sleep(2000);
			demo.chooseJava();
			Thread.sleep(2000);
			demo.chooseC();
			}
			catch(Exception e) {
				String error_msg = e.getMessage();
				System.err.println(error_msg);
			}
	}
	
	static <T> void selectDropDown(DemoPage demo,String SelectOption, T value) {
		if(value instanceof Integer && SelectOption.equals("Index")) 
		{
			demo.dropdownByIndex(Integer.valueOf(value.toString()));
		}
		else if(value instanceof String && SelectOption.equals("VisibleText"))
		{
			demo.dropdownByVisibleText(value.toString());
		}
		else if(value instanceof String && SelectOption.equals("Value")) 
		{
			demo.dropdownByValue(value.toString());
		}
		else if(value instanceof String && SelectOption.equals("Partial")) {
			demo.dropdownByPartialVisibleText(value.toString());
		}
		else {
			System.err.println("Invalid Arguments.");
		}
	}
	public static void main(String[] args) {
		DemoPageActions dpa = new DemoPageActions();
		dpa.scenarioInitialization();
		DemoPage dp = new DemoPage(drv);
		clickRadioButtons(dp);
		selectDropDown(dp,"Index",2);
		selectDropDown(dp,"VisibleText","Nepal");
		selectDropDown(dp,"Value","SL");
		selectDropDown(dp,"Partial","rica");
		
	}
}
