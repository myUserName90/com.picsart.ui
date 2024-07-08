package com.picsart.ui.config;

import org.openqa.selenium.WebDriver;

public class DriverBase {
    private static final ThreadLocal<WebDriver> DRIVER_POOL = new ThreadLocal<>();

    public static void initDriverObject(int width, int height) {
        DRIVER_POOL.set(DriverConfig.createChromeDriver(width,height));
    }

    public static WebDriver getDriver() {
        return DRIVER_POOL.get();
    }


    public static void closeDrivers() {
        WebDriver driver = getDriver();
        if (driver != null) {
            driver.quit();
            DRIVER_POOL.remove();
        }
    }
}
