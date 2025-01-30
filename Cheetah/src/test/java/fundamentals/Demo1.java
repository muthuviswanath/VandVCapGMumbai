package fundamentals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo1 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("file:///D:/CapG_Mumbai/test_html/index.html");
		driver.manage().window().maximize();
		for (int i=1;i<=6;i++) {
			if(i%2!=0) {
				Thread.sleep(1000);
				driver.findElement(By.name(i+"")).click();
			}
		}
		for (int j=6;j>=1;j--) {
			Thread.sleep(1000);
			driver.findElement(By.name(j+"")).click();
		}


	}

}
