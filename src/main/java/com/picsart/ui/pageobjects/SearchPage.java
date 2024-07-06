package com.picsart.ui.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends PageBase<SearchPage> {
    private static final String SEARCH_PAGE_PATH = "search/images/";

    @FindBy(css = "#onetrust-accept-btn-handler")
    private WebElement acceptAllCookiesBtn;

    @FindBy(css = "button[id='filter_icon']")
    private WebElement filterBtn;

    @FindBy(css = "div[data-testid=\"search-filter-root\"]")
    private WebElement filterSearchBar;

    @FindBy(css = "iframe[data-testid='com.picsart.social.search']")
    private WebElement frameSocialSearch;

    @Override
    public SearchPage open() {
        return openPage();
    }

    @Override
    public SearchPage init() {
        return initPage();
    }

    @Override
    public String getUrlPath() {
        return SEARCH_PAGE_PATH;
    }

    public SearchPage clickOnAcceptAllCookiesBtn() {
        click(acceptAllCookiesBtn);
        return this;
    }

    public SearchPage clickOnFilterBtn() {
        switchToFrame(frameSocialSearch);
        click(filterBtn);
        return this;
    }

    public boolean isFilterBarHidden(){
        return filterSearchBar.getAttribute("class").contains("hide");
    }


}
