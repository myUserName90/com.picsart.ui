package com.picsart.ui.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import static com.picsart.ui.config.DriverBase.*;

public class TestBase {

    @Parameters({"width","height"})
    @BeforeMethod
    public void setUp(@Optional("1920") int width, @Optional("1080") int height) {
        initDriverObject(width,height);}

    @AfterMethod
    public void tearDown() {
        closeDrivers();
    }
}
