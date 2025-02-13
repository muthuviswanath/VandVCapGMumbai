package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class FlightsResult {
	@FindBy(xpath = "//p[contains(text(),'Sort by')]")
	private WebElement OkDeal_iframe;

	@FindBy(xpath="//button[normalize-space()='Okay, Got it!']")
	private WebElement OkDeal;
	
	WebDriver driver;
	public FlightsResult(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	public void bookFlights() throws Exception {
		Thread.sleep(7000);
		driver.switchTo().frame(0);
		OkDeal.click();
		
	}
}
