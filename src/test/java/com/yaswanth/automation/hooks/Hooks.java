package com.yaswanth.automation.hooks;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.yaswanth.automation.driver.DriverFactory;
import com.yaswanth.automation.utils.ExtentReportManager;
import com.yaswanth.automation.utils.ScreenshotUtil;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

    private static ExtentReports extent;
    private static ExtentTest extentTest;

    @Before
    public void setUp(Scenario scenario) {

        System.out.println(">>> BEFORE HOOK STARTED");

        // Initialize WebDriver
        DriverFactory.initDriver();

        // Initialize Extent Report
        extent = ExtentReportManager.getExtentReport();

        // Create entry for current scenario
        extentTest = extent.createTest(scenario.getName());
    }

    @After
    public void tearDown(Scenario scenario) {

        String screenshotPath = ScreenshotUtil.takeScreenshot(scenario.getName());

        if (scenario.isFailed()) {
            extentTest.fail("Scenario Failed")
                      .addScreenCaptureFromPath(screenshotPath);
        } else {
            extentTest.pass("Scenario Passed")
                      .addScreenCaptureFromPath(screenshotPath);
        }

        extent.flush();
        DriverFactory.quitDriver();

        System.out.println(">>> AFTER HOOK COMPLETED");
    }

}
