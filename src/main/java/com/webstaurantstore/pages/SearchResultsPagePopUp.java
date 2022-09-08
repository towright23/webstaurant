package com.webstaurantstore.pages;

import com.webstaurantstore.common.WebstaurantCore;
import com.webstaurantstore.locators.SearchResultsPagePopUpLocators;
import com.webstaurantstore.utils.SeleniumMethods;
import org.openqa.selenium.WebDriver;

public class SearchResultsPagePopUp extends WebstaurantCore {
    public SearchResultsPagePopUp(WebDriver driver) {
        super(driver);
    }

    SeleniumMethods sel = new SeleniumMethods(driver);
    public CartPage clickViewShoppingCart() {
        sel.selClickBy(SearchResultsPagePopUpLocators.VIEW_CART_LKTXT);
        return new CartPage(driver);
    }
}
