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

    @FindBy(css = "#like_button_item0")
    private WebElement firstLikeBtn;

    @FindBy(css = "#save_button_item0")
    private WebElement firstSaveBtn;

    @FindBy(css = "#try_now_button_item0")
    private WebElement firstTryNowBtn;

    @FindBy(css = "div[data-testid=\"registration-modal-container\"]")
    private WebElement registrationModalContainer;

    @FindBy(css = "svg[data-testid=\"modal-close-icon\"]")
    private WebElement closeModalIcon;

    @FindBy(css = "button[data-testid=\"search-filter-header-clear\"]")
    private WebElement clearFilterBtn;

    @FindBy(css = "div[data-automation=\"search-item-premium\"]")
    private List<WebElement> premiumAssets;

    @FindBy(css = "div[data-automation=\"search-item-premium\"] a")
    private List<WebElement> premiumImageUrlTag;


    @Override
    public SearchPage open() {
        return openPage();
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

    public boolean isLikeButtonVisible() {
        return isElementDisplayed(filterBtn);
    }

    public boolean isSaveButtonVisible() {
        return isElementDisplayed(firstSaveBtn);
    }

    public boolean isTryNowButtonVisible() {
        return isElementDisplayed(firstTryNowBtn);
    }

    public SearchPage clickOnLikeBtn() {
        click(firstLikeBtn);
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
        hover(premiumAssets, position);
        return this;
    }

    public SearchPage clickOnTryNowButton() {
        click(firstTryNowBtn);
        return this;
    }

    public String getAssetUrl(int position) {
        return getElementAttribute(premiumImageUrlTag.get(position), "href");
    }


    public String getCurrentUrl() {
        return getUrl();
    }


}
