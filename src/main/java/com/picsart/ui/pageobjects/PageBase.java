package com.picsart.ui.pageobjects;

import com.picsart.ui.config.Configuration;
import org.openqa.selenium.support.PageFactory;

import static com.picsart.ui.config.DriverBase.getDriver;

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
}
