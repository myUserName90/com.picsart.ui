package com.picsart.ui.helper;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static com.picsart.ui.config.DriverBase.getDriver;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class WaitHelper {
    private static int SHORT_TIMEOUT = 10;

    private static int TIMEOUT = 20;

    private static int LONG_TIMEOUT = 50;

    private static WebDriverWait wait;

    public static WaitHelper getShortWait() {
        return getCustomWait(SHORT_TIMEOUT);
    }

    public static WaitHelper getWait() {
        return getCustomWait(TIMEOUT);
    }

    public static WaitHelper getLongWait() {
        return getCustomWait(LONG_TIMEOUT);
    }


    private static WaitHelper getCustomWait(int timeout) {
        WaitHelper waitHelper = new WaitHelper();
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(timeout), Duration.ofMillis(50));
        return waitHelper;
    }

    public WebElement waitUntilElementToBeVisible(WebElement element) {
        return wait.until(visibilityOf(element));
    }

    public WebElement waitUntilElementToBeClickable(WebElement element) {
        return wait.until(elementToBeClickable(element));
    }


    public void waitForPageReady() {
        wait.until((jsReturnsValue("return document.readyState=='complete';")));
    }

    public WaitHelper waitUntilElementsListCountHigherThan(List<WebElement> elements, int count) {
        wait.until(driver -> {
            int elementsCount = elements.size();
            return elementsCount > count;
        });
        return this;
    }

    public void sleep(int timeOut){
        try{
            Thread.sleep(timeOut);
        }catch (InterruptedException exception){
            //handle thread sleep
        }
    }
}
