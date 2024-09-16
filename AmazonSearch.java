import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AmazonSearch {
    public static void main(String[] args) {
        // Set path to your ChromeDriver
    	System.setProperty("webdriver.chrome.driver", "D:\\selenium + java\\all webdriver in it\\chromedriver.exe");

        // Set up Chrome options
        ChromeOptions options = new ChromeOptions();
       // options.addArguments("--headless"); // Run in headless mode (optional)

        WebDriver driver = new ChromeDriver(options);

        try {
            // Open Amazon.in search results page
            driver.get("https://www.amazon.in/s?k=LG+sound+bar&crid=3USX54AEZOE9A&sprefix=lg+sound+bar%2Caps%2C240&ref=nb_sb_noss_2");

            // Wait for results to load
            Thread.sleep(5000); // Increase wait time if necessary

            // Initialize data storage
            Map<String, Double> products = new HashMap<>();

            // Locate product elements
            List<WebElement> productElements = driver.findElements(By.cssSelector(".s-main-slot .s-result-item"));

            for (WebElement item : productElements) {
                try {
                    // Get product name
                    WebElement titleElement = item.findElement(By.cssSelector("h2 .a-text-normal"));
                    String productName = titleElement.getText();

                    // Get price
                    WebElement priceElement = item.findElement(By.cssSelector(".a-price .a-offscreen"));
                    String priceText = priceElement.getText();
                    
                    // Clean price text
                    priceText = priceText.replace("₹", "").replace(",", "").trim();
                    
                    // Convert price to double
                    double price = 0;
                    if (!priceText.isEmpty()) {
                        try {
                            price = Double.parseDouble(priceText);
                        } catch (NumberFormatException e) {
                            price = 0; // Handle parsing errors
                        }
                    }

                    products.put(productName, price);
                } catch (Exception e) {
                    // Handle exceptions and missing elements
                    System.err.println("Error processing product: " + e.getMessage());
                }
            }

            // Sort products by price
            List<Map.Entry<String, Double>> sortedProducts = new ArrayList<>(products.entrySet());
            sortedProducts.sort(Map.Entry.comparingByValue());

            // Print products
            for (Map.Entry<String, Double> entry : sortedProducts) {
                System.out.println(entry.getValue() + " " + entry.getKey());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close WebDriver
            driver.quit();
        }
    }
}
