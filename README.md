Amazon Product Price Scraper
This Java code uses Selenium WebDriver to scrape product names and prices from Amazon's search results page.

Prerequisites
ChromeDriver: Download the ChromeDriver executable that matches your version of Chrome from the ChromeDriver site.

Java: Ensure Java is installed on your machine. Verify that javac and java commands are available in your PATH.

Selenium: Add Selenium dependencies to your project:

Maven: Add the Selenium dependency to your pom.xml.
Gradle: Add the Selenium dependency to your build.gradle.
Standalone: Download Selenium Java bindings from the Selenium website.

Instructions for Running the Script
Save the Script: Save the provided Java code into a file named AmazonSearch.java.

Compile the Script: Open a terminal or command prompt and navigate to the directory containing AmazonSearch.java. Compile the script with:
javac AmazonSearch.java

Run the Script: Execute the compiled Java file with:
java AmazonSearch

Key Points
CSS Selectors: The script uses specific CSS selectors (h2 .a-text-normal for product titles and .a-price .a-offscreen for prices) based on the Amazon search results page structure. These selectors may need updating if Amazon changes its page layout.

Error Handling: Basic error handling is included to manage issues such as missing elements or errors in price parsing.

Headless Mode:By default, the script runs with a visible browser window. To run the script in headless mode (without opening a browser window), add or uncomment the following line in the code:
options.addArguments("--headless");

Description
This script automates the extraction of LG soundbar products and their prices from Amazon's search results. If a product’s price is not available, it is considered as zero.
