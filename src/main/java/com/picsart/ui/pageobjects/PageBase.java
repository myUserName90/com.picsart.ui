package com.picsart.ui.pageobjects;

import com.picsart.ui.config.Configuration;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.NoSuchElementException;

import static com.picsart.ui.config.DriverBase.getDriver;
import static com.picsart.ui.helper.WaitHelper.getWait;


public abstract class PageBase<T extends PageBase<T>> {

    public static String MAIN_URL = Configuration.SELENIUM_URL;


    public abstract T open();

    public abstract String getUrlPath();

    protected T initPage() {
        PageFactory.initElements(getDriver(), this);
        return (T) this;
    }

    protected T openPage() {
        load();
        initPage();
        return (T) this;
    }

    protected void load() {
        if (getUrlPath() == null) {
            getDriver().get(MAIN_URL);
        } else {
            getDriver().get(MAIN_URL + getUrlPath());
        }
    }

    protected void click(WebElement element) {
        getWait().waitUntilElementToBeVisible(element);
        getWait().waitUntilElementToBeClickable(element);
        element.click();
    }

    protected void hover(WebElement element) {
        getWait().waitUntilElementToBeVisible(element);
        Actions action = new Actions(getDriver());
        action.moveToElement(element).perform();
    }

    protected void hover(List<WebElement> elements, int position) {
        getWait().waitUntilElementsListCountHigherThan(elements,1);
        hover(elements.get(position));
    }

    protected boolean isElementDisplayed(WebElement element) {
        try {
            getWait().waitUntilElementToBeVisible(element);
            element.isDisplayed();
        } catch (NoSuchElementException |  StaleElementReferenceException e) {
            return false;
        }
        return element.isDisplayed();
    }

    protected void switchToFrame(WebElement element) {
        getWait().waitForPageReady();
        getDriver().switchTo().frame(element);
    }

    protected void switchToDefaultContent() {
        getDriver().switchTo().defaultContent();
    }

    protected String getUrl(){
        return getDriver().getCurrentUrl();
    }

    protected String getElementAttribute(WebElement element, String attribute) {
        return element.getAttribute(attribute);
    }

}
