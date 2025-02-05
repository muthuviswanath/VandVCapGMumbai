package objectrepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrainResults {
	@FindBy(xpath = "//div[@class='tbis-div']//span")
	private List<WebElement> result_text;
	
	WebDriver drv;
	public TrainResults(WebDriver drv) {
		this.drv = drv;
		PageFactory.initElements(drv,this);
	}
	
	public boolean verifyResultText() {
		boolean res = false;
		for (WebElement ele:result_text) {
			if (ele.getText().contains("Result")) {
				res =  true;
				break;
			}
		}
		return res;
	}
	
}
