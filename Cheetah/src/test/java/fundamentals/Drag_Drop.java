package fundamentals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Drag_Drop {
	//	https://jqueryui.com/ - website
	//	//a[contains(text(),'Droppable')]identify the link
	// find the draggable element - //div[@id='draggable']
	// find the droppable element - //div[@id='droppable']
	
	public static void main(String[] args) throws Exception{
		WebDriver drv = new ChromeDriver();
		drv.get("file:///D:/CapG_Mumbai/test_html/dragdrop.html");
		drv.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		drv.manage().window().maximize();
		drv.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebElement drag_element= drv.findElement(By.xpath("//div[@id='draggable']"));
		WebElement drop_element= drv.findElement(By.xpath("//div[@id='droppable']"));
		Actions act = new Actions(drv);
//		act.dragAndDrop(drag_element, drop_element).perform();
		act.clickAndHold(drag_element).moveToElement(drop_element).perform();
	}
}
