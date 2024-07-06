package com.picsart.ui.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverConfig {

    private static WebDriver createChromeDriver() {
        WebDriver driver;
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver =  new ChromeDriver(options);
        driver.manage().window().maximize();
        return driver;
    }

    private static WebDriver createFirefoxDriver() {
        WebDriver driver;
        FirefoxOptions options = new FirefoxOptions();
        driver = new FirefoxDriver(options);
        return driver;
    }

    public static WebDriver createWebDriver(String browser) {
        if (browser.equals("chrome")) {
            return createChromeDriver();
        } else
            return createFirefoxDriver();
    }
}
