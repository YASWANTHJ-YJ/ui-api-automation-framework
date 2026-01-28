package com.yaswanth.automation.stepdefinitions;

import com.yaswanth.automation.driver.DriverFactory;
import com.yaswanth.automation.pages.LoginPage;
import io.cucumber.java.en.*;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//Cucumber Step Definition class, Cucumber scans this class
public class Stepdefinitions_Login {
	
	//Encapsulation - Step class controls how driver is used
	//Holds the browser instance and Is used by step methods
	private WebDriver driver;
	
	//Page Object
	private LoginPage loginPage;


     @Given("user is on login page")
    public void user_is_on_login_page() {
    	// Driver is GUARANTEED to be initialized here
         driver = DriverFactory.getDriver();

         driver.get("https://practicetestautomation.com/practice-test-login/");
         
         // Create page object AFTER driver exists
         loginPage = new LoginPage(driver);

         
        //loginPage.openLoginPage();
    }

    @When("user enters valid username and password")
    public void user_enters_valid_username_and_password() {
        loginPage.enterUsername("student");
        loginPage.enterPassword("Password123");
    }

    @Then("user should be logged in successfully")
    public void user_should_be_logged_in_successfully() {

        loginPage.clickLogin();
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains("Logged In Successfully | Practice Test Automation"));


        String actualTitle = loginPage.getPageTitle();
        
        System.out.println("Actual title: " + actualTitle);


        
    }

}
