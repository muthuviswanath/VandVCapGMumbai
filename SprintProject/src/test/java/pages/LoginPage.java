package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	@FindBy(xpath = "//input[@id='username']")
	private WebElement username_txtbox;

	@FindBy(xpath = "//input[@id='password']")
	private WebElement password_txtbox;

	@FindBy(xpath = "//button[@id='login']")
	private WebElement login_button;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}

	public void  login(String username, String password) throws Exception {
		Thread.sleep(2000);
		username_txtbox.sendKeys(username);
		Thread.sleep(2000);
		password_txtbox.sendKeys(username);
		Thread.sleep(2000);
		login_button.click();
	}
}
