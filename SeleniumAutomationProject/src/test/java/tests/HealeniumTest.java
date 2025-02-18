package tests;

import com.epam.healenium.SelfHealingDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;

public class HealeniumTest {
    public static void main(String[] args) {
        // Setup WebDriver with Healenium
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        WebDriver delegate = new ChromeDriver(options);
        SelfHealingDriver driver = SelfHealingDriver.create(delegate);

        try {
            // Open the test page
            driver.get("file:///C:/Users/muthu/OneDrive/Desktop/aibased_automation/index.html");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            // Find and click the login button before UI change
            WebElement loginButton = driver.findElement(By.id("login-btn"));
            loginButton.click();
            System.out.println("Clicked login button before UI change.");

            // Wait for 6 seconds (UI change occurs after 5 seconds)
            Thread.sleep(6000);

            // Attempt to find and click the updated button (Healenium will heal)
            WebElement healedButton = driver.findElement(By.id("login-btn"));
            healedButton.click();
            System.out.println("Clicked healed button after UI change.");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
