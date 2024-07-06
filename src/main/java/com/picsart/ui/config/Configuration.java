package com.picsart.ui.config;

import lombok.extern.log4j.Log4j2;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@Log4j2
public class Configuration {
    public static String BROWSER_TYPE;

    public static Properties MAIN_CONFIGS = readFile("src/main/resources/config.properties");
    public static String SELENIUM_URL;


    static {
        BROWSER_TYPE = getProperty("browser", MAIN_CONFIGS);
        SELENIUM_URL = getProperty("selenium.url", MAIN_CONFIGS);
    }

    public static String getProperty(String key, Properties properties) {
        log.info("Getting property from " + properties + "by " + key);
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
