package com.picsart.ui.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class DriverConfig {

    public static WebDriver createChromeDriver(int width, int height) {
        WebDriver driver;
        ChromeOptions options = new ChromeOptions();
        options.addArguments(String.format("--window-size=%d,%d", width, height));
        driver = new ChromeDriver(options);
        return driver;
    }

}
