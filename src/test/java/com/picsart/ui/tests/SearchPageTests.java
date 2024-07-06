package com.picsart.ui.tests;

import com.picsart.ui.base.TestBase;
import com.picsart.ui.pageobjects.SearchPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
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
        assertTrue(isFiltersHidden);
    }
}
