package objectrepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

	@FindBy(xpath = "//span[@class='commonModal__close']")
	private WebElement close_modal;

	@FindBy(xpath = "//a/span[text()='Buses'][1]")
	private WebElement bus_link;

	@FindBy(xpath = "//input[@id='fromCity']")
	private WebElement fromCity;

	
	@FindBy(xpath = "//div[@class='react-autosuggest__container react-autosuggest__container--open']//input[@type='text']")
	private WebElement fromCitySearch;
	
	
	
	
	
	
}
