package com.yaswanth.automation.config;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties prop;

    static {
        try {
            FileInputStream fis = new FileInputStream(
                System.getProperty("user.dir") +
                "/src/main/resources/config/config.properties"
            );
            prop = new Properties();
            prop.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load config file");
        }
    }

    public static String getProperty(String key) {
        return prop.getProperty(key);
    }
}
