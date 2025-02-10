package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	@FindBy(xpath = "")
	private WebElement abcd;
	
	public BasePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getAbcd() {
		return abcd;
	}

}
