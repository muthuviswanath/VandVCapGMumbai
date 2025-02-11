package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ExpWait;

public class IxigoBasePage {
	private WebDriver driver;
	
	@FindBy(xpath = "//iframe[@id='wiz-iframe-intent']")
	private WebElement pop_up;

	@FindBy(xpath = "//p[contains(text(),'BOM - Mumbai')]")
	private WebElement click_from;
	
	@FindBy(xpath = "//input[@value='Mumbai']")
	private WebElement from_input_default;
	
	@FindBy(xpath = "//label[text()='From']/following::input")
	private WebElement from_input;
	
	@FindBy(xpath = "//span[@class='text-primary text-sm']")
	private List<WebElement>  select_from_airport_list;
	
	@FindBy(xpath = "//label[text()='To']/following::input")
	private WebElement to_input;
	
	@FindBy(xpath = "//span")
	private List<WebElement>  select_to_airport_list;
	
	@FindBy(xpath = "//button//abbr")
	private List<WebElement>  select_date;

	@FindBy(xpath = "//button[text()='Search']")
	WebElement search_button;
		
	public IxigoBasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	public WebDriver getDriver() {
		return driver;
	}


	public WebElement getPop_up() {
		return pop_up;
	}


	public WebElement getClick_from() {
		return click_from;
	}


	public WebElement getFrom_input_default() {
		return from_input_default;
	}


	public WebElement getFrom_input() {
		return from_input;
	}


	public List<WebElement> getSelect_from_airport_list() {
		return select_from_airport_list;
	}


	public WebElement getTo_input() {
		return to_input;
	}


	public List<WebElement> getSelect_to_airport_list() {
		return select_to_airport_list;
	}


	public List<WebElement> getSelect_date() {
		return select_date;
	}


	public WebElement getSearch_button() {
		return search_button;
	}
	
	public void searchFlights(String source, String src_code, String destn, String destn_code, String date) throws Exception {
		ExpWait.waitForElement(driver, 10, pop_up);
		if (pop_up.isDisplayed()) {
			pop_up.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.navigate().to("https://www.ixigo.com");
			ExpWait.waitForElement(driver, 10, click_from);
			click_from.click();
			from_input_default.sendKeys(Keys.DELETE);
			from_input.sendKeys(source);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			for(WebElement source_list: select_from_airport_list) {
				if(source_list.getText().contains(src_code)) {
					source_list.click();
					break;
				}
			}
			to_input.sendKeys(destn);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			Thread.sleep(2000);
			for(WebElement destn_list: select_to_airport_list) {
				if(destn_list.getText().contains(destn_code)) {
					destn_list.click();
					break;
				}
			}
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			for(WebElement dates: select_date) {
				if(dates.getDomAttribute("aria-label").contains(date)) {
					dates.click();
					break;
				}
			}
			search_button.click();
		}
		else {
			ExpWait.waitForElement(driver, 10, click_from);
			click_from.click();
			from_input_default.sendKeys(Keys.DELETE);
			from_input.sendKeys(source);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			for(WebElement source_list: select_from_airport_list) {
				if(source_list.getText().contains(src_code)) {
					source_list.click();
					break;
				}
			}
			to_input.sendKeys(destn);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			for(WebElement destn_list: select_to_airport_list) {
				if(destn_list.getText().contains(destn_code)) {
					destn_list.click();
					break;
				}
			}
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			for(WebElement dates: select_date) {
				if(dates.getDomAttribute("aria-label").contains(date)) {
					dates.click();
					break;
				}
			}
			search_button.click();
		}
	}


}
