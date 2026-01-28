package com.yaswanth.automation.hooks;

import com.yaswanth.automation.driver.DriverFactory;
import io.cucumber.java.Before;
import io.cucumber.java.After;

public class Hooks {

    @Before
    public void setUp() {
    	
    	// This calls your factory to launch Chrome
    	System.out.println(">>> BEFORE HOOK STARTED");
        DriverFactory.initDriver();
    }

    @After
    public void tearDown() {
    	
    	// This ensures the browser closes even if the test fails
    	System.out.println(">>> AFTER HOOK STARTED");
    	DriverFactory.quitDriver();
    }
}