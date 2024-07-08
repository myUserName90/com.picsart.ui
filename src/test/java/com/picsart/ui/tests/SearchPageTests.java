package com.picsart.ui.tests;

import com.picsart.ui.base.TestBase;
import com.picsart.ui.pageobjects.SearchPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SearchPageTests extends TestBase {

    @Test
    public void testSearchPage() {
        SearchPage searchPage = new SearchPage()
                .open()
                .clickOnAcceptAllCookiesBtn();
        boolean isFiltersHidden = searchPage
                .clickOnFilterBtn()
                .isFilterBarHidden();

        assertTrue(isFiltersHidden, "Filters are not hidden");

        searchPage
                .clickOnFilterBtn()
                .selectPersonalFilterCheckBox();

        SearchPage hoveredImage = searchPage.hoverOnImageAssetsBy(0);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(hoveredImage.isLikeButtonVisible(), "Like button is invisible.");
        softAssert.assertTrue(hoveredImage.isSaveButtonVisible(), "Save button is invisible.");
        softAssert.assertTrue(hoveredImage.isTryNowButtonVisible(), "TryNow button is invisible.");
        softAssert.assertAll();

        boolean isRegistrationModalDisplayed = hoveredImage
                .clickOnLikeBtn()
                .isRegistrationModalContainerVisible();
        assertTrue(isRegistrationModalDisplayed, "Registration modal is invisible.");

        SearchPage hoveredImage1 = hoveredImage
                .clickOnCloseModalIcon()
                .clickOnClearFilterBtn()  ///Here I found a bug (after clearing the filters, assets are not refreshed.)
                .hoverOnPremiumIcons(0);

        SoftAssert softAssert1 = new SoftAssert();
        softAssert1.assertFalse(hoveredImage1.isLikeButtonVisible(), "Like button is visible.");
        softAssert1.assertFalse(hoveredImage1.isSaveButtonVisible(), "Save button is visible.");
        softAssert1.assertTrue(hoveredImage1.isTryNowButtonVisible(), "TryNow button is not visible.");
        softAssert.assertAll();

        String expectedUrl = hoveredImage1.getAssetUrl(0);
        String actualUrl = hoveredImage1.clickOnTryNowButton().getCurrentUrl();

        assertEquals(actualUrl, expectedUrl, "You are navigated with wrong asset url");


    }


}
