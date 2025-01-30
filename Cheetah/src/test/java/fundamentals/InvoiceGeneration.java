package fundamentals;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InvoiceGeneration {
	public static void main(String[] args) throws Exception {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://lms.educatio.co.in");
		Scanner scanner = new Scanner(System.in);

		WebElement table = driver.findElement(By.id("product"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));

		Map<String, Integer> productPriceMap = new HashMap<String, Integer>();
		Map<String, String> productAuthorMap = new HashMap<String, String>();
		for (int i = 1; i < rows.size(); i++) { 
			List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
			String author = cols.get(0).getText();
			String itemDesc = cols.get(1).getText();
			int amount = Integer.parseInt(cols.get(2).getText());
			productPriceMap.put(itemDesc, amount);
			productAuthorMap.put(itemDesc, author);
		}
		System.out.println("Available Products:");
		int index = 1;
		for (String product : productPriceMap.keySet()) {
			System.out.println(index + ". " + product + " - Rs. " + productPriceMap.get(product));
			index++;
		}


		List<String> selectedProducts = new ArrayList<String>();
		List<Integer> quantities = new ArrayList<Integer>();

		while (true) {
			System.out.print("Enter the product name (or type 'done' to finish): ");
			String productName = scanner.nextLine();

			if (productName.equalsIgnoreCase("done")) {
				break;
			}

			if (productPriceMap.containsKey(productName)) {
				System.out.print("Enter quantity for " + productName + ": ");
				int quantity = scanner.nextInt();
				scanner.nextLine();  // Consume newline

				selectedProducts.add(productName);
				quantities.add(quantity);
			} else {
				System.out.println("Product not found. Please try again.");
			}
		}

		File invoice = new File("D:/CapG_Mumbai/invoice.txt");
		PrintStream fo = new PrintStream(invoice);
		System.setOut(fo);
		System.out.println("===========================================================================================================");
		System.out.println("Bill.No: 234 		                        Invoice");
		System.out.println("GST: 112345678 								Date: " + "29-01-2024");
		System.out.println("\n                                    Capgemini Library");
		System.out.println("===========================================================================================================");

		System.out.println("-----------------------------------------------------------------------------------------------------------");
		String formattedString = String.format("%-10s %-30s %-15s %-15s %-20s %-15s %n", 
				"S.No", "Item Description", "Amount", 
				"Quantity", "Author", "Price");
		System.out.println(formattedString);
		double totalPrice = 0;
		for (int i = 0; i < selectedProducts.size(); i++) {
			String productName = selectedProducts.get(i);
			int quantity = quantities.get(i);
			int amount = productPriceMap.get(productName);
			double price = amount * quantity;
			totalPrice += price;
			String value_string = String.format("%-10d %-30s %-15d %-15d %-20s %-15.2f %n", 
					(i + 1), productName, amount, quantity, 
					productAuthorMap.get(productName), price);
			System.out.print(value_string);
		}

		double cgst = totalPrice * 0.09;
		double sgst = totalPrice * 0.09;
		double discount = totalPrice * 0.03;
		double finalPrice = totalPrice + cgst + sgst - discount;
		String grandTotalLine = String.format("%-50s %-25s %15.2f %n", "", "Grand Total", totalPrice);
		String cgstLine = String.format("%-50s %-25s %15.2f %n", "", "C.GST 9%", cgst);
		String sgstLine = String.format("%-50s %-25s %15.2f %n", "", "S.GST 9%", sgst);
		String discountLine = String.format("%-50s %-25s %15.2f %n", "", "Discount of 3%", -discount);
		String finalPriceLine = String.format("%-50s %-25s %15.2f %n", "", "Final Price", finalPrice);
		System.out.println("-----------------------------------------------------------------------------------------------------------");
		System.out.print(grandTotalLine);
		System.out.print(cgstLine);
		System.out.print(sgstLine);
		System.out.print(discountLine);
		System.out.println("================================================================================================================");
		System.out.print(finalPriceLine);
		System.out.println("================================================================================================================");
		System.out.println("                                    Thank You for your Order");

		driver.quit();
	}
}
