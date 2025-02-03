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
		try {Thread.sleep(2000);}catch(Exception e) {System.out.println(e.getMessage());}
	}
	@Test(dataProvider = "anyname",dependsOnMethods = "clickRadio", priority = 3)
	public void alertMe(String name) throws Exception {
		Thread.sleep(2000);
		demo_page.alertMessage(name);
		Thread.sleep(5000);
	}
	
	@Parameters("username")
	@Test(dependsOnMethods = "clickRadio", priority = 2)
	public void anotherAlert(String param) throws Exception{
		Thread.sleep(2000);
		demo_page.alertMessage(param);
		Thread.sleep(5000);
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
