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
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");

        // Set up Chrome options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // Optional: Run in headless mode

        WebDriver driver = new ChromeDriver(options);

        try {
            // 1. Open amazon.in
            driver.get("https://www.amazon.in");

            // 2. Search for 'lg soundbar'
            WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
            searchBox.sendKeys("LG soundbar");
            searchBox.submit();

            // Wait for results to load
            Thread.sleep(5000); // Increase wait time if necessary

            // Initialize data storage
            Map<String, Double> products = new HashMap<>();

            // 3. Read product names and associated main price on 1st search result page
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

            // 4. Sort products by price
            List<Map.Entry<String, Double>> sortedProducts = new ArrayList<>(products.entrySet());
            sortedProducts.sort(Map.Entry.comparingByValue());

            // 5. Print sorted products
            for (Map.Entry<String, Double> entry : sortedProducts) {
                System.out.println(entry.getValue() + " " + entry.getKey());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 6. Close WebDriver
            driver.quit();
        }
    }
}
