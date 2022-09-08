package com.webstaurantstore.pages;

import com.webstaurantstore.common.WebstaurantCore;
import com.webstaurantstore.locators.HomePageLocators;
import com.webstaurantstore.utils.SeleniumMethods;
import org.openqa.selenium.WebDriver;

public class HomePage extends WebstaurantCore {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    SeleniumMethods sel = new SeleniumMethods(driver);
    public HomePage fillOutSearchField(String searchText) {
        sel.selSendKeysBy(HomePageLocators.SEARCH_INPUT_FIELD_X, searchText);
        return this;
    }

    public SearchResultsPage clickSearchButton() {
        sel.selClickBy(HomePageLocators.SEARCH_BUTTON_x);
        return new SearchResultsPage(driver);
    }
}
