package com.yaswanth.automation.runners;

import org.testng.annotations.DataProvider;

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
                "html:target/cucumber-reports.html",
                //To rerun failed testcases,
                //RetryAnalyzer is suitable for TestNG tests, not Cucumber scenarios. For Cucumber, rerun plugin is the industry-standard solution.
               // "rerun:target/rerun.txt"
        },
        
        //Makes console output readable
        monochrome = true
)
public class TestRunnerTestNG extends AbstractTestNGCucumberTests {

	@Override
	//Each scenario runs in a separate TestNG thread
    //Without this: Everything runs sequentially
    //Even if TestNG is configured for parallel
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
		//This gives TestNG all Cucumber scenarios as test data
		//Each scenario becomes one TestNG test
        return super.scenarios();
    }
}
