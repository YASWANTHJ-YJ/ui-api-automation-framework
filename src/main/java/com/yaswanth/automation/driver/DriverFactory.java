package com.yaswanth.automation.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import com.yaswanth.automation.config.ConfigReader;


/**
 * DriverFactory Class: Manages the lifecycle of the WebDriver.
 * Implements ThreadLocal for Thread-Safe parallel execution.
 */

public class DriverFactory {

	// ThreadLocal container to isolate WebDriver instances for parallel testing
	
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    /**
     * Initializes the browser, sets up the driver, and stores it in ThreadLocal.
     * @return WebDriver instance
     */
    
    public static void initDriver() {
    	if (driver.get() == null) {
    	
        // This is why we needed the Maven folder—it provides WebDriverManager!
    	// Automatically manages the downloading and setting up of ChromeDriver
    	
    		String browser = ConfigReader.getProperty("browser");

    		System.out.println("Browser from config: " + browser);

    		if (browser.equalsIgnoreCase("chrome")) {
    		    WebDriverManager.chromedriver().setup();
    		    WebDriver cdriver = new ChromeDriver();
    		    // Create a new Chrome instance and assign it to the current thread
                driver.set(cdriver);
    		}
    		else if (browser.equalsIgnoreCase("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                WebDriver fdriver = new FirefoxDriver();
                //tlDriver.set(new FirefoxDriver());
                driver.set(fdriver);
            }
    		else if (browser.equalsIgnoreCase("edge")) {
                WebDriverManager.edgedriver().setup();
                WebDriver edriver = new EdgeDriver();
                //tlDriver.set(new FirefoxDriver());
                driver.set(edriver);
            }
    		else {
                throw new RuntimeException("Invalid browser name: " + browser);
            }
    		getDriver().manage().window().maximize();
    		
    		

    	
    }
    }

    /**
     * Retrieves the driver instance currently associated with the calling thread.
     * @return WebDriver instance
     */
    public static WebDriver getDriver() {
        return driver.get();
    }

    /**
     * Closes the browser and removes the driver instance from memory.
     * Essential to prevent memory leaks and dangling browser processes.
     */
    public static void quitDriver() {
        if (getDriver() != null) {
            getDriver().quit(); // Close the browser window
            driver.remove();    // Clear the ThreadLocal variable
        }
    }

	
}