package fundamentals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementCollection {
	public static void main(String[] args) {
		WebDriver drv = new ChromeDriver();
		drv.manage().window().maximize();
		drv.navigate().to("https://lms.educatio.co.in");
		WebElement css_link = drv.findElement(By.linkText("CssSelector"));
		css_link.click();
		// Making use of universal selector
		List<WebElement> element_list = drv.findElements(By.cssSelector("*"));
//		for(WebElement w:element_list) {
//			System.out.println(w.getTagName());
//		}
		System.out.println();
		for(int i=0; i<element_list.size(); i++) {
			System.out.println(element_list.get(i).getText());
		}
	}
}
