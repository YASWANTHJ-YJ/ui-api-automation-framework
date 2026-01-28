package com.yaswanth.automation.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = "src/test/resources/features/Login.feature",
        //Where Cucumber should search for:
        //Step Definitions & Hooks
        glue = {
                "com.yaswanth.automation.stepdefinitions",
                "com.yaswanth.automation.hooks"
                },
        		tags = "@smoke",
        // Generates HTML report after run
        plugin = {
                "pretty",
                "html:target/cucumber-reports.html"
        },
        
        //Makes console output readable
        monochrome = true
)
public class TestRunnerTestNG extends AbstractTestNGCucumberTests {
}
