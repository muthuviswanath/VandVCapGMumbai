package testngclasses;

import java.io.FileReader;
import java.util.Properties;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import objectrepository.Homepage;

public class BookTicket {
	WebDriver drv = new ChromeDriver();
	Homepage home = new Homepage(drv);
	@BeforeClass
	public void navigate() {
		drv.navigate().to(Homepage.baseURL);
	}
	@Test(enabled = false)
	public void searchTrains() throws Exception {
		FileReader fread = new FileReader("./utilities/testdata.properties");
		Properties props = new Properties();
		props.load(fread);
		home.SearchTrain(props.getProperty("source"),props.getProperty("destination"));
	}

	@Test
	public void searchForTrains() throws Exception{
		JSONParser jparse = new JSONParser();
		FileReader fread = new FileReader("D:/Capgemini_Mumbai_AutomationTesting/mytestdata.json");
		Object obj = jparse.parse(fread);

		JSONObject jobj = (JSONObject)obj;
		
		home.SearchTrain(jobj.get("source").toString(), jobj.get("destination").toString());
	}
}
