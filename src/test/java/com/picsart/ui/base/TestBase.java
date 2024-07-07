package com.picsart.ui.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import static com.picsart.ui.config.DriverBase.*;

public class TestBase {

    @BeforeMethod
//    @Parameters({"width","height"})
    //TODO
    public void setUp() {
        initDriverObject();}

    @AfterMethod
    public void tearDown() {
        closeDrivers();
    }
}
