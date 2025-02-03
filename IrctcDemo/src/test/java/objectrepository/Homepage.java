package objectrepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	public static String baseURL = "https://www.irctc.co.in/nget/train-search";
	@FindBy(xpath = "//input[@aria-controls='pr_id_1_list']")
	private WebElement source_txtbox;
	
	@FindBy(xpath="//ul[@id='pr_id_1_list']//li//span")
	private List<WebElement> src_suggestion_list;

	@FindBy(xpath = "//input[@aria-controls='pr_id_2_list']")
	private WebElement destn_txtbox;
	
	@FindBy(xpath="//ul[@id='pr_id_2_list']//li//span")
	private List<WebElement> dest_suggestion_list;
	
	@FindBy(xpath = "//p-calendar[@id='jDate']//input")
	private WebElement travel_date;
	
	WebDriver drv;
	public Homepage(WebDriver drv) {
		this.drv = drv;
		PageFactory.initElements(drv, this);
		// TODO Auto-generated constructor stub
	}
	
	public void SearchTrain(String src, String destn)throws Exception {
		
		source_txtbox.sendKeys(src);
		Thread.sleep(2000);
		for(WebElement e: src_suggestion_list) {
			if(e.getText().contains("C SHIVAJI MAH T - CSMT")) {
				e.click();
				break;
			}
		}
		destn_txtbox.sendKeys(destn);
		Thread.sleep(2000);
		for(WebElement e: dest_suggestion_list) {
			if(e.getText().contains("PUNE JN - ")) {
				e.click();
				break;
			}
		}
		
		travel_date.click();
		drv.findElement(By.xpath("//table//td/a[text()='20']")).click();
		drv.findElement(By.xpath("//button[@type='submit']")).click();
		
		
		
	}
	
}
