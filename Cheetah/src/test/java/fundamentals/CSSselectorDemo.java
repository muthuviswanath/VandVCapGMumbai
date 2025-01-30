package fundamentals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CSSselectorDemo {
	public static void main(String[] args) {
		WebDriver drv = new ChromeDriver();
		drv.manage().window().maximize();
		drv.navigate().to("https://lms.educatio.co.in");
		WebElement css_link = drv.findElement(By.linkText("CssSelector"));
		css_link.click();
		// Making use of universal selector
		List<WebElement> element_list = drv.findElements(By.cssSelector("*"));
		System.out.println("Total number of elements in the page: " + element_list.size());

		//Type Selector
		List<WebElement> div_list = drv.findElements(By.cssSelector("div"));
		System.out.println("Total number of div(s) in the page: " + div_list.size());

		//Class Selector
		WebElement class_selector =drv.findElement(By.cssSelector(".class-example"));
		System.out.println("Class Selector Text: " + class_selector.getText());

		//ID Selector
		WebElement id_selector = drv.findElement(By.id("id-example"));
		System.out.println("Id Selector Text: " + id_selector.getText());

		//Attribute Selector
		WebElement text_box = drv.findElement(By.cssSelector("[placeholder='Input field']"));
		text_box.sendKeys("Selenium WebDrivver");

		//Descendant Selector
		WebElement unordered_list = drv.findElement(By.cssSelector("div ul"));
		System.out.println(unordered_list.getTagName());

		//Child Selector
		//		WebElement paragraph= drv.findElement(By.cssSelector("div > div:nth-child(11) li:firstchild"));		
		//				System.out.println(paragraph.getText());
		//			
		//Sibling  Selector
		WebElement par = drv.findElement(By.cssSelector("h1 + p"));
		System.out.println(par.getText());

	}

}













