package com.yaswanth.automation.utils;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.IRetryAnalyzer;
import com.yaswanth.automation.retry.RetryAnalyzer;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.yaswanth.automation.driver.DriverFactory;

public class TestListener implements ITestListener {

    private static ExtentReports extent = ExtentReportManager.getExtentReport();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest extentTest =
                extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        WebDriver driver = DriverFactory.getDriver();

        String path = ScreenshotUtil.takeScreenshot(result.getMethod().getMethodName());

        test.get().pass("Test Passed")
                .addScreenCaptureFromPath(path);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = DriverFactory.getDriver();

        String path = ScreenshotUtil.takeScreenshot(result.getMethod().getMethodName());

        test.get().fail(result.getThrowable())
                .addScreenCaptureFromPath(path);
    }
    
    @Override
    public void onStart(ITestContext context) {
        for (ITestNGMethod method : context.getAllTestMethods()) {
            method.setRetryAnalyzerClass(RetryAnalyzer.class);
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
