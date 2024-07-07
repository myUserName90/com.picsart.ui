package com.picsart.ui.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.picsart.ui.helper.WaitHelper.getWait;

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

    @FindBy(css = "li[data-testid=\"checkbox-item-root\"]:nth-of-type(3)")
    private WebElement personalFilterCheckBox;

    @FindBy(css = "div[data-testid=\"search-card-root\"]")
    private List<WebElement> imageAssetsList;

    @FindBy(css = "button[data-testid=\"like-button-root\"]")
    private List<WebElement> likeBtns;

    @FindBy(css = "button[data-testid=\"save-button-root\"]")
    private List<WebElement> saveBtns;

    @FindBy(css = "button[data-testid=\"try-now-button-root\"]")
    private List<WebElement> tryNowBtns;

    @FindBy(css = "div[data-testid=\"registration-modal-container\"]")
    private WebElement registrationModalContainer;

    @FindBy(css = "svg[data-testid=\"modal-close-icon\"]")
    private WebElement closeModalIcon;

    @FindBy(css = "button[data-testid=\"search-filter-header-clear\"]")
    private WebElement clearFilterBtn;

    @FindBy(css = "div[data-testid=\"premium-icon-root\"]")
    private List<WebElement> premiumIcons;


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
        switchToFrame(frameSocialSearch);
        return this;
    }

    public SearchPage clickOnFilterBtn() {
        click(filterBtn);
        return this;
    }

    //TODO
//    public SearchPage switchToSocialSearchFrame(){
//        switchToFrame(frameSocialSearch);
//        return this;
//    }

    public boolean isFilterBarHidden() {
        return filterSearchBar.getAttribute("class").contains("hide");
    }

    public SearchPage selectPersonalFilterCheckBox() {
        click(personalFilterCheckBox);
        return this;
    }

    public SearchPage hoverOnImageAssetsBy(int position) {
        hover(imageAssetsList, position);
        return this;
    }

    public boolean isLikeButtonVisible(int position) {
        getWait().waitUntilElementsListCountHigherThan(likeBtns, 1);
        return isElementDisplayed(likeBtns.get(position));
    }

    public boolean isSaveButtonVisible(int position) {
        getWait().waitUntilElementsListCountHigherThan(saveBtns, 1);
        return isElementDisplayed(saveBtns.get(position));
    }

    public boolean isTryNowButtonVisible(int position) {
        getWait().waitUntilElementsListCountHigherThan(tryNowBtns, 1);
        return isElementDisplayed(tryNowBtns.get(position));
    }

    public SearchPage clickOnLikeBtn(int position) {
        click(likeBtns.get(position));
        getWait().sleep(50);
        return this;
    }

    public boolean isRegistrationModalContainerVisible() {
        switchToDefaultContent();
        return isElementDisplayed(registrationModalContainer);
    }

    public SearchPage clickOnCloseModalIcon() {
        click(closeModalIcon);
        getWait().sleep(50);
        return this;
    }

    public SearchPage clickOnClearFilterBtn() {
        switchToFrame(frameSocialSearch);
        click(clearFilterBtn);
        return this;
    }

    public SearchPage hoverOnPremiumIcons(int position) {
        hover(premiumIcons, position);
        return this;
    }


}
