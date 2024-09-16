This java code has been written in Eclipse for selenium 


**Instructions for Running the Script:
Download ChromeDriver: Make sure you have the ChromeDriver executable that matches your version of Chrome. You can download it from the ChromeDriver site.

Set Up Your Environment:

Install Java: Ensure that Java is installed on your machine and that javac and java commands are available in your PATH.
Add Selenium Dependencies: If using Maven or Gradle, include Selenium dependencies. For a standalone setup, download the Selenium Java bindings from the Selenium website.
Compile and Run the Script:

Save the Script: Save the Java code into a file named AmazonSearch.java.
Compile: Open a terminal or command prompt and run:
sh
Copy code
javac AmazonSearch.java
Run: Execute the compiled Java file:
sh
Copy code
java AmazonSearch
Key Points:
CSS Selectors: The CSS selectors used (h2 .a-text-normal for product titles and .a-price .a-offscreen for prices) are based on the structure of the Amazon search results page. They might need to be adjusted if Amazon updates their page structure.
Error Handling: Includes basic error handling to catch issues with missing elements or price parsing errors.
Headless Mode: The script runs in headless mode, which is useful for running the script without opening a browser window. Remove options.addArguments("--headless") if you want to see the browser window.
**
           

This is the automation script for listing product with prices : LG soundbar 
if there is no price then it will show the product in zero price
