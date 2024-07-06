package com.picsart.ui.tests;

import com.picsart.ui.base.TestBase;
import com.picsart.ui.helper.WaitHelper;
import com.picsart.ui.pageobjects.SearchPage;
import org.testng.annotations.Test;

import static com.picsart.ui.config.DriverBase.initDriverObject;

public class SearchPageTests extends TestBase {

    @Test
    public void testSearchPage() {
        new SearchPage()
                .open();
        WaitHelper.getShortWait().sleep(100);
    }
}
