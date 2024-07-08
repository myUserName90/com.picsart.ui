package com.picsart.ui.config;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configuration {

    public static Properties MAIN_CONFIGS = readFile("src/main/resources/config.properties");
    public static String SELENIUM_URL;


    static {
        SELENIUM_URL = getProperty("selenium.url", MAIN_CONFIGS);
    }

    public static String getProperty(String key, Properties properties) {
        return properties.getProperty(key);
    }

    public static Properties readFile(String path) {
        Properties properties = new Properties();
        try (FileInputStream file = new FileInputStream(path)) {
            properties.load(file);
        } catch (IOException e) {
            // expetion
        }
        return properties;
    }
}
