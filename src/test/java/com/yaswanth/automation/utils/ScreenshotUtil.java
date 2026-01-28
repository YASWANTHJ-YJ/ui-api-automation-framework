package com.yaswanth.automation.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.yaswanth.automation.driver.DriverFactory;

public class ScreenshotUtil {

    public static String takeScreenshot(String scenarioName) {

        WebDriver driver = DriverFactory.getDriver();

        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String screenshotName = scenarioName.replaceAll(" ", "_") + "_" + timestamp + ".png";

        String screenshotPath = System.getProperty("user.dir")
                + "/test-output/screenshots/" + screenshotName;

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File dest = new File(screenshotPath);

        try {
            FileUtils.copyFile(src, dest);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return screenshotPath;
    }
}
