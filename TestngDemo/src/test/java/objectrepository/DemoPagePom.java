package objectrepository;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoPagePom {
	WebDriver drv;
	
	@FindBy(xpath = "//label[@for='Python']//input[@type='radio']")
	private WebElement python_radio;
	
	@FindBy(xpath = "//input[@id='name']")
	private WebElement alert_text;
	
	@FindBy(xpath = "//input[@id='alertbtn']")
	private WebElement alert_button;
	
	public DemoPagePom(WebDriver drv) {
		this.drv = drv;
		PageFactory.initElements(drv,this);
	}
	
	public void clickPythonRadio() {
		python_radio.click();
	}
	
	public void alertMessage(String s) throws Exception{
		alert_text.sendKeys(s);
		alert_button.click();
		Thread.sleep(2000);
		Alert al = drv.switchTo().alert();
		System.out.println(al.getText());
		al.accept();
	}
}
