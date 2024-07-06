package com.picsart.ui.config;

import org.openqa.selenium.WebDriver;

public class DriverBase {
    private static final ThreadLocal<WebDriver> driverPool = ThreadLocal.withInitial(DriverBase::initDriverObject);

    private static WebDriver initDriverObject() {
        return DriverConfig.createWebDriver(Configuration.BROWSER_TYPE);
    }

    public static WebDriver getDriver() {
        return driverPool.get();
    }


    public static void closeDrivers() {
        getDriver().quit();
        driverPool.remove();
    }
}
