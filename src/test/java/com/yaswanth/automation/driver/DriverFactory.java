package com.yaswanth.automation.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

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
    
    public static WebDriver initDriver() {
    	
        // This is why we needed the Maven folder—it provides WebDriverManager!
    	// Automatically manages the downloading and setting up of ChromeDriver
    	
        WebDriverManager.chromedriver().setup();
        
        // Create a new Chrome instance and assign it to the current thread
        driver.set(new ChromeDriver());
        return getDriver();
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