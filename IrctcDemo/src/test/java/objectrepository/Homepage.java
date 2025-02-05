package objectrepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExpWait;

public class Homepage {
	public static String baseURL = "https://www.irctc.co.in/nget/train-search";
	@FindBy(xpath = "//input[@aria-controls='pr_id_1_list']")
	private WebElement source_txtbox;
	
	@FindBy(xpath = "//span[contains(@class,'modal-title')]")
	private WebElement modal_title;

	@FindBy(xpath="//ul[@id='pr_id_1_list']//li//span")
	private List<WebElement> src_suggestion_list;
	
	@FindBy(xpath = "//span[contains(@class,'ng-star-inserted')]")
	private WebElement welcome_text;

	@FindBy(xpath = "//input[@aria-controls='pr_id_2_list']")
	private WebElement destn_txtbox;

	@FindBy(xpath="//ul[@id='pr_id_2_list']//li//span")
	private List<WebElement> dest_suggestion_list;

	@FindBy(xpath = "//p-calendar[@id='jDate']//input")
	private WebElement travel_date_txtbox;

	@FindBy(xpath = "//table/tbody//td/a")
	private List<WebElement> date_list;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement search_trains;

	@FindBy(xpath = "//a[text()=' LOGIN ']")
	private WebElement login_button;




	@FindBy(xpath = "//div[@role='form']//input[@placeholder='User Name']")
	private WebElement usernametxtbox;

	@FindBy(xpath = "//div[@role='form']//input[@placeholder='Password']")
	private WebElement passwordtxtbox;

	@FindBy(xpath = "//button[contains(text(),'SIGN IN')]")
	private WebElement signinbutton;

	@FindBy(xpath = "//a[contains(@class,'loginCloseBtn')]")
	private WebElement close_login;

	
	WebDriver drv;
	public Homepage(WebDriver drv) {
		this.drv = drv;
		PageFactory.initElements(drv, this);
	}

	public void enterSource(String source) {
		source_txtbox = ExpWait.waitForElement(drv, 15, source_txtbox);
		source_txtbox.sendKeys(source);
		try {
		Thread.sleep(2000);
		}
		catch(InterruptedException e) {
			
		}
		for(WebElement e: src_suggestion_list) {
			if(e.getText().contains("C SHIVAJI MAH T")) {
				e.click();
				break;
			}
		}
	}
	
	public boolean clickLogin() {
		login_button = ExpWait.waitForElement(drv, 15, login_button);
		login_button.click();
		login_button = ExpWait.waitForElement(drv, 15, modal_title);
		return modal_title.getText().equals("LOGIN");
	}

	public void enterUserName(String username) {
		usernametxtbox = ExpWait.waitForElement(drv, 15, usernametxtbox);
		usernametxtbox.click();
		usernametxtbox.sendKeys(username);
	}

	public void enterPassword(String password) {
		passwordtxtbox = ExpWait.waitForElement(drv, 15, passwordtxtbox);
		passwordtxtbox.click();
		passwordtxtbox.sendKeys(password);
	}

	public boolean LoginToAppliation(){
		signinbutton = ExpWait.waitForElement(drv, 15, signinbutton);
		signinbutton.click();
		System.out.println(welcome_text.getText());
		return welcome_text.getText().contains("mutviswa");
	}

	public void enterDestination(String destination) {
		destn_txtbox = ExpWait.waitForElement(drv, 15, destn_txtbox);
		destn_txtbox.sendKeys(destination);
		try {
			Thread.sleep(2000);
			}
			catch(InterruptedException e) {
				
			}
		for(WebElement e: dest_suggestion_list) {
			if(e.getText().contains("PUNE JN -")) {
				e.click();
				break;
			}
		}

	}

	public void enterTravelDate(String date) {
		travel_date_txtbox = ExpWait.waitForElement(drv, 15, travel_date_txtbox);
		travel_date_txtbox.click();
		for(WebElement ele: date_list) {
			if(ele.getText().contains(date)) {
				ele.click();
				break;
			}
		}
	}

	public void searchTrains() {
		search_trains = ExpWait.waitForElement(drv, 15, search_trains);
		search_trains.click();
		
	}
}
