package com.yaswanth.automation.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;



	@CucumberOptions(
		    features = "@target/rerun.txt",
		    glue = {"com.yaswanth.automation.stepdefinitions",
		    		"com.yaswanth.automation.hooks"},
		    plugin = {
		        "pretty",
		        "html:target/cucumber-rerun.html"
		    }
		)
		public class RerunTestRunner extends AbstractTestNGCucumberTests {
		}
