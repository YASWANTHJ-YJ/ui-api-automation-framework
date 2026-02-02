package com.yaswanth.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class LoginPage {

	 /*
     * Hooks → create driver
     * StepDefinition → pass driver
     * Page → use same browser session
     * Without constructor → framework breaks
     */
    private WebDriver driver;

    // ================= CONSTRUCTOR =================
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // ================= LOCATORS =================
    //Encapsulation
    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton   = By.id("submit");

    // ================= ACTION METHODS =================
    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }
    
    //Page Object should expose data, not assertions
    //Step definition decides pass/fail
    public String getPageTitle() {
        return driver.getTitle();
    }

	

}
