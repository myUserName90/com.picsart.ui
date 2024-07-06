package com.picsart.ui.pageobjects;

public class SearchPage extends PageBase{
    private static  final String SEARCH_PAGE_PATH = "search/images/";
    @Override
    public PageBase open() {
        return openPage();
    }

    @Override
    public PageBase init() {
        return initPage();
    }

    @Override
    public String getUrlPath() {
        return SEARCH_PAGE_PATH;
    }
}
