package com.picsart.ui.tests;

import com.picsart.ui.base.TestBase;
import com.picsart.ui.pageobjects.SearchPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

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

        SearchPage hoveredImage = searchPage.hoverOnImageAssetsBy(1);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(hoveredImage.isLikeButtonVisible(0), "Like button is invisible.");
        softAssert.assertTrue(hoveredImage.isSaveButtonVisible(0), "Save button is invisible.");
        softAssert.assertTrue(hoveredImage.isTryNowButtonVisible(0), "TryNow button is invisible.");
        softAssert.assertAll();

        boolean isRegistrationModalDisplayed = hoveredImage
                .clickOnLikeBtn(0)
                .isRegistrationModalContainerVisible();
        assertTrue(isRegistrationModalDisplayed, "Registration modal is invisible.");
        SearchPage hoveredImage1 = searchPage
                .clickOnCloseModalIcon()
                .clickOnClearFilterBtn()
                .hoverOnPremiumIcons(0);
        SoftAssert softAssert1 = new SoftAssert();
        softAssert1.assertFalse(hoveredImage1.isLikeButtonVisible(0), "Like button is visible.");
        softAssert1.assertFalse(hoveredImage1.isSaveButtonVisible(0), "Save button is visible.");
        softAssert1.assertTrue(hoveredImage1.isTryNowButtonVisible(0), "TryNow button is not visible.");
        softAssert.assertAll();

    }


}
