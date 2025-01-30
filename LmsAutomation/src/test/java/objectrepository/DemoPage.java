package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DemoPage {
	
	@FindBy(xpath = "//input[@type='radio'][@value='Python'][@name='planguage']")
	private WebElement python_radio;

	@FindBy(xpath = "//input[@type='radio'][@value='Java'][@name='planguage']")
	private WebElement java_radio;

	@FindBy(xpath = "//input[@type='radio'][@value='C'][@name='planguage']")
	private WebElement c_radio;

	@FindBy(xpath = "//input[@id='bmwcheck']")
	private WebElement bmw_check;

	@FindBy(xpath = "//input[@id='benzcheck']")
	private WebElement benz_check;

	@FindBy(xpath = "//input[@id='porschecheck']")
	private WebElement porsche_check;

	@FindBy(xpath = "//select[@id='countryselect']")
	private WebElement country_drop_down;
	
	@FindBy(xpath = "//select[@size='5']")
	private WebElement multiple_fruits_select;
	
	Select dropdownmenu;
	Select multiplemenu;

	



	public DemoPage(WebDriver drv) {
		PageFactory.initElements(drv, this);
		dropdownmenu = new Select(country_drop_down);
		multiplemenu = new Select(multiple_fruits_select);
	}

	public void choosePython() {
		python_radio.click();
	}

	public void chooseJava() {
		java_radio.click();
	}
	public void chooseC() {
		c_radio.click();
	}

	public void checkBenz() {
		benz_check.click();
	}

	public void checkBMW() {
		bmw_check.click();
	}

	public void checkPorsche() {
		porsche_check.click();
	}

	public void dropdownByIndex(Integer index) {
		dropdownmenu.selectByIndex(index);	
	}

	public void dropdownByVisibleText(String visibleText) {
		dropdownmenu.selectByVisibleText(visibleText);	
	}
	public void dropdownByValue(String value) {
		dropdownmenu.selectByValue(value);
	}
	public void dropdownByPartialVisibleText(String visibleText) {
		dropdownmenu.selectByContainsVisibleText(visibleText);
	}
	
	public void multiSelectByIndex(Integer index) {
		multiplemenu.selectByIndex(index);	
	}

	public void multiSelectByVisibleText(String visibleText) {
		multiplemenu.selectByVisibleText(visibleText);	
	}
	public void multiSelectByValue(String value) {
		multiplemenu.selectByValue(value);
	}
	public void multiSelectByPartialVisibleText(String visibleText) {
		multiplemenu.selectByContainsVisibleText(visibleText);
	}
	
	public void deselectMultiSelectByIndex(Integer index) {
		multiplemenu.selectByIndex(index);	
	}

	public void deselectMultiSelectByVisibleText(String visibleText) {
		multiplemenu.selectByVisibleText(visibleText);	
	}
	public void deselectMultiSelectByValue(String value) {
		multiplemenu.selectByValue(value);
	}
	public void deselectMultiSelectByPartialVisibleText(String visibleText) {
		multiplemenu.selectByContainsVisibleText(visibleText);
	}
	



}
