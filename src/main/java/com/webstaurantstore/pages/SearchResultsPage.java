package com.webstaurantstore.pages;

import com.webstaurantstore.common.WebstaurantCore;
import com.webstaurantstore.helper.ByConverter;
import com.webstaurantstore.locators.SearchResultsPageLocators;
import com.webstaurantstore.utils.SeleniumMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class SearchResultsPage extends WebstaurantCore {
    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public String getItemName() {
        return itemName;
    }

    private static String itemName;
    public SearchResultsPage verifyExpectedTextAgainstCategoriesBox(String verifyText) {
        verifyTextExistsForSearchResults(verifyText, SearchResultsPageLocators.ALL_CATEGORIES_BOX_ANCHOR_CSS);
        return this;
    }

    public SearchResultsPagePopUp acceptProductAccessorySubmitIfPresent() {
        if(sel.isElementPresent(SearchResultsPageLocators.PRODUCT_ACCESSORIES_FOR_POPUP_SUBMIT)) {
            sel.selClickBy(SearchResultsPageLocators.PRODUCT_ACCESSORIES_FOR_POPUP_SUBMIT);
        }
        return new SearchResultsPagePopUp(driver);
    }
    SeleniumMethods sel = new SeleniumMethods(driver);
    public SearchResultsPage verifyExpectedTextAgainstSearchResultsProductListing(String verifyText) {
        int totalPages = getTotalSearchResultsPageCount();
        for(int i = 1; i < totalPages + 1; ++i) {
            if(i > 1){
                SearchResultsPageLocators search = new SearchResultsPageLocators();
                By buttonLocator = search.getPageButtonLocatorLinkText(String.valueOf(i), driver);
                sel.jsScroll(buttonLocator);
                sel.jsClick(buttonLocator);
            }
            if(i == totalPages) {
                sel.jsScroll(SearchResultsPageLocators.LAST_PAGE_BUTTON_X);
                sel.selClickBy(SearchResultsPageLocators.LAST_PAGE_BUTTON_X);
            }
            verifyTextExistsForSearchResults(verifyText, SearchResultsPageLocators.ALL_SEARCH_RESULTS_PRODUCT_LISTING_ANCHOR_CSS);
        }
        return this;
    }

    public int getTotalSearchResultsPageCount() {
        return Integer.parseInt(sel.getText(SearchResultsPageLocators.PAGINATION_LAST_PAGE_BUTTON_X));
    }

    public int getTotalProductListCount() {
        return sel.findTotalElementCount(SearchResultsPageLocators.ALL_SEARCH_RESULTS_PROD_LISTINGS_CSS);
    }

    public SearchResultsPage verifyTextExistsForSearchResults(String verifyText, By element) {
        List<WebElement> WebElementList = sel.getAllWebElements(element);
        for(WebElement webElement : WebElementList) {
            ByConverter bc = new ByConverter();
            By byWebElement = bc.convertToBy(webElement);
            sel.jsScroll(byWebElement);
            Assert.assertTrue(sel.getText(byWebElement).contains(verifyText), "failure, description: " + sel.getText(byWebElement) + " DID NOT CONTAIN: " + verifyText);
        }
        return this;
    }

    public SearchResultsPage navigateToLastPage() {
        sel.jsScroll(SearchResultsPageLocators.LAST_PAGE_BUTTON_X);
        sel.selClickBy(SearchResultsPageLocators.LAST_PAGE_BUTTON_X);
        return this;
    }

    public SearchResultsPage setLastItemName() {
        String totalProdCount = String.valueOf(getTotalProductListCount());
        SearchResultsPageLocators search = new SearchResultsPageLocators();
        itemName = getItemName(search.getProductNameLocatorByIndexCss(totalProdCount, driver));
        return this;
    }
    public SearchResultsPage addLastItemToCart() {
        String totalProdCount = String.valueOf(getTotalProductListCount());
        SearchResultsPageLocators search = new SearchResultsPageLocators();
        sel.selClickBy(search.getProductLocatorByIndexCss(totalProdCount, driver));
        return this;
    }

    public String getItemName(By locator) {
        return sel.getText(locator);
    }


}
