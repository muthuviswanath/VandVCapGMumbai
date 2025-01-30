package fundamentals;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MenuTest {
	public static void main(String[] args) {
		WebDriver drv = new ChromeDriver();
		drv.navigate().to("https://lms.educatio.co.in");
		drv.manage().window().maximize();

		//Identifying all the elements
		WebElement python = drv.findElement(By.cssSelector("input[value='Python']"));
		WebElement java = drv.findElement(By.cssSelector("input[value='Java']"));
		WebElement c = drv.findElement(By.cssSelector("input[value='C']"));

		WebElement bmw = drv.findElement(By.id("bmwcheck"));
		WebElement benz = drv.findElement(By.id("benzcheck"));
		WebElement porsche = drv.findElement(By.id("porschecheck"));

		Scanner s = new Scanner(System.in);
		do {
			System.out.println("1. Choose your favourite language\n2. Choose your favourite Brands\n3.Exit\n\nChoose your option[1-3]: ");
			int main_menu_choice = s.nextInt();
			switch(main_menu_choice) {
			case 1:
				System.out.println("1. Python\n2. Java\n3.C\nChoose your language");
				int lang_choice = s.nextInt();
				if(lang_choice==1) 
					python.click();
				else if(lang_choice==2)
					java.click();
				else
					c.click();
				break;
			case 2:
				System.out.println("Enter the number of brands to choose (1/2/3): ");
				int brand_choice = s.nextInt();
				if (brand_choice == 1) {
					System.out.println("1. BMW\n2. MERCEDES\n3. PORSCHE");
					int car_choice = s.nextInt();
					if (car_choice == 1)
						bmw.click();
					else if(car_choice ==2)
						benz.click();
					else
						porsche.click();
				}
				else if(brand_choice == 2) {
					System.out.println("1. BMW\n2. MERCEDES\n3. PORSCHE");
					int[] car_choices = new int[2];
					for(int i=0; i<car_choices.length;i++) {
						car_choices[i] = s.nextInt();
					}
					for(int cars:car_choices) {
						if (cars==1) 
							bmw.click();
						if (cars==2)
							benz.click();
						if (cars==3)
							porsche.click();
					}
				}
				else if(brand_choice==3){
					bmw.click();
					benz.click();
					porsche.click();
				}
				break;
			case 3:
				return;
			default:
				System.out.println("Invalid choice");
			}
		}while(true);
	}
}
