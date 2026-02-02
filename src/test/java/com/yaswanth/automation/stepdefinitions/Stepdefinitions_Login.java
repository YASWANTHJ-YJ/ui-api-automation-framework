package com.yaswanth.automation.stepdefinitions;

import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.yaswanth.automation.config.ConfigReader;
import com.yaswanth.automation.driver.DriverFactory;
import com.yaswanth.automation.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import com.yaswanth.automation.utils.ExcelUtils;

//Cucumber Step Definition class, Cucumber scans this class
public class Stepdefinitions_Login {
	
	//Encapsulation - Step class controls how driver is used
	//Holds the browser instance and Is used by step methods
	private WebDriver driver;
	
	//Page Object
	private LoginPage loginPage;
	
	private Map<String, String> testData;


     @Given("user is on login page")
    public void user_is_on_login_page() {
    	// Driver is GUARANTEED to be initialized here
         driver = DriverFactory.getDriver();

         System.out.println("Thread ID: " + Thread.currentThread().getId() +
        		    " | Scenario running");

         driver.get(ConfigReader.getProperty("url"));
         
         // Create page object AFTER driver exists
         loginPage = new LoginPage(driver);
        //loginPage.openLoginPage();
    }
/*
    @When("user enters valid username and password")
    public void user_enters_valid_username_and_password() {
        
    	String username = ConfigReader.getProperty("username");
        String password = ConfigReader.getProperty("password");

        //loginPage.login(username, password);
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
//    	loginPage.enterUsername("student");
//        loginPage.enterPassword("Password123");
    }
    */
    

    @When("user enters {string} username and password")
    public void user_enters_valid_username_and_password(String testType) {

    	testData = ExcelUtils.getTestData("LoginData", testType);

    	System.out.println("Username: " + testData.get("username"));
    	System.out.println("Password: " + testData.get("password"));
    	
    	loginPage.enterUsername(testData.get("username"));
        loginPage.enterPassword(testData.get("password"));
        loginPage.clickLogin();        
    }

    @Then("login should be {string}")
    public void login_should_be(String expectedResult) {

    	 
        if (expectedResult.equalsIgnoreCase("success")) {
        	
        	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.titleContains("Logged In Successfully"));

            String actualTitle = loginPage.getPageTitle();
            
            System.out.println("Actual title: " + actualTitle);
            
            loginPage.verifyLoginSuccess();
        } else {
            loginPage.verifyLoginFailure();
        }
    }
    

}
