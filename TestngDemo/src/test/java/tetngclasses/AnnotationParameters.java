package tetngclasses;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import objectrepository.DemoPagePom;

public class AnnotationParameters {
	//@Beforeclass - Initialize the web browser
	//@Test - more than one test method not in any chronological/natural sort / alphabetical order

	WebDriver drv= new ChromeDriver();
	DemoPagePom demo_page = new DemoPagePom(drv);
	@BeforeClass
	public void click_Radio() {
		drv.get("file:///C:/Users/muthu/OneDrive/Desktop/sample_html/demopage.html");
		drv.manage().window().maximize();
		drv.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@Test(priority = 1)
	public void clickRadio() {
		demo_page.clickPythonRadio();
	}
	@Test(dataProvider = "anyname",priority = 2)
	public void alertMe(String name) throws Exception {
		demo_page.alertMessage(name);
	}
	
	@DataProvider(name = "anyname")
	public Object[][] provideData(){
		return new Object[][] {
			{"something"}
		};
	}
	
	@AfterClass
	public void tearDown() {
		drv.quit();
	}
	
}
