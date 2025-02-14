package tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LabTest {
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "./chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		try {
			// Open the Practo website
			driver.get("https://www.practo.com/tests");

			// Maximize the browser window
			driver.manage().window().maximize();

			// Wait for the city selection modal to appear
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.cssSelector(".ReactModal__Content.ReactModal__Content--after-open")
					));

			// Find all cities inside the modal
			List<WebElement> cities = modal.findElements(By.tagName("li"));

			// Choose a specific city (e.g., selecting "Mumbai")
			for (WebElement city : cities) {
				if (city.getText().equalsIgnoreCase("Mumbai")) {
					city.click();
					break;
				}
			}

			// Additional waiting after selection (if needed)
			Thread.sleep(2000);


			// Wait and find the search box
			WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(
					By.id("omniSearch")));

			// Click input box to activate dropdown
			searchBox.click();
			Thread.sleep(1000); // Allow dropdown to appear

			// Enter search text
			searchBox.sendKeys("Thyroid Profile Total BLOOD");
			Thread.sleep(2000); // Wait for dropdown suggestions

			// Wait for dropdown to appear
			WebElement dropdown = wait.until(ExpectedConditions.presenceOfElementLocated(
					By.cssSelector(".c-search__suggestion-container")));

			// Select the option from the dropdown
			Actions act = new Actions(driver);
			act.moveToElement(driver.findElement(By.cssSelector(".c-search__suggestion-container")))
					.moveByOffset(20,50).click().perform();

			Thread.sleep(2000);
			
			// Click on add to cart button
			WebElement add_to_cart = driver.findElement(By.xpath("//div[text()='Add to Cart']"));
			add_to_cart.click();
			
			Thread.sleep(2000);

			// Click on proceed to checkout
			WebElement proceed_to_checkout = driver.findElement(By.xpath("//div[text()='Proceed to Checkout']"));
			proceed_to_checkout.click();
			
			Thread.sleep(4000);
			
			// Enter Patient Details 
			WebElement patient_name = driver.findElement(By.xpath("//input[@data-aid='patient-name']"));
			patient_name.clear();
			patient_name.sendKeys("Apurva");
			Thread.sleep(2000);

			WebElement patient_age = driver.findElement(By.xpath("//input[@data-aid='patient-age']"));
			patient_age.clear();
			patient_age.sendKeys("21");
			Thread.sleep(2000);

			WebElement patient_gender = driver.findElement(By.xpath("//div[@data-aid='patient-gender-selected-FEMALE']"));
			patient_gender.click();
			Thread.sleep(2000);
			
			WebElement patient_mobile = driver.findElement(By.xpath("//input[@data-aid='patient-mobile']"));
			patient_mobile.clear();
			patient_mobile.sendKeys("+917904093412");
			Thread.sleep(2000);	
			
			WebElement patient_email = driver.findElement(By.xpath("//input[@data-aid='patient-email']"));
			patient_email.clear();
			patient_email.sendKeys("muthuviswanath@outlook.com");
			Thread.sleep(2000);	

			WebElement continue_button = driver.findElement(By.xpath("//input[@data-aid='order-continue-button']"));
			continue_button.click();
			Thread.sleep(2000);	
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}