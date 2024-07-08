package com.picsart.ui.config;

import org.openqa.selenium.WebDriver;

public class DriverBase {
    private static final ThreadLocal<WebDriver> driverPool = new ThreadLocal<>();

    public static void initDriverObject(int width, int height) {
        driverPool.set(DriverConfig.createChromeDriver(width,height));
    }

    public static WebDriver getDriver() {
        return driverPool.get();
    }


    public static void closeDrivers() {
        WebDriver driver = getDriver();
        if (driver != null) {
            driver.quit();
            driverPool.remove();
        }
    }
}
