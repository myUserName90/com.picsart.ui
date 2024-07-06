package com.picsart.ui.pageobjects;

import com.picsart.ui.config.Configuration;
import com.picsart.ui.helper.WaitHelper;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static com.picsart.ui.config.DriverBase.getDriver;
import static com.picsart.ui.helper.WaitHelper.getWait;

@Log4j2
public abstract class PageBase<T extends PageBase<T>> {

    public static String MAIN_URL = Configuration.SELENIUM_URL;


    public abstract T open();

    public abstract T init();

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

    private String getElementIdentifier(WebElement element) {
        if (element.getText().isBlank()) {
            return element.getAttribute("id").toUpperCase();
        }
        return element.getText().toUpperCase();
    }

    protected void click(WebElement element) {
        getWait().waitUntilElementToBeVisible(element);
        getWait().waitUntilElementToBeClickable(element);
        element.click();
        log.info("Clicked " + getElementIdentifier(element));
    }
    protected void hover(WebElement element) {
        getWait().waitUntilElementToBeVisible(element);
        Actions action = new Actions(getDriver());
        action.moveToElement(element).perform();
    }

    protected void hover(List<WebElement> elements,int position) {
        hover(elements.get(position));
    }

    protected boolean isElementDisplayed(WebElement element) {
        return element.isDisplayed();
    }

    protected void switchToFrame(WebElement element) {
        getDriver().switchTo().frame(element);
    }
}
