package com.webstaurantstore.locators;

import com.webstaurantstore.common.WebstaurantCore;
import com.webstaurantstore.helper.ByConverter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultsPageLocators {

    public static final By ALL_SEARCH_RESULTS_PROD_LISTINGS_CSS = By.cssSelector("div#product_listing div#ProductBoxContainer");
    public static final By PAGINATION_LAST_PAGE_BUTTON_X = By.xpath("//li/a[contains(@aria-label, 'last page')]");
    public static final By ALL_SEARCH_RESULTS_PRODUCT_LISTING_ANCHOR_CSS = By.cssSelector("div#product_listing div#ProductBoxContainer div#details a.block");
    public static final By ALL_CATEGORIES_BOX_ANCHOR_CSS = By.cssSelector("div#categoriesBox a");
    public static final By LAST_PAGE_BUTTON_X = By.xpath("//a[contains(@aria-label,'last page')]");

    public static final By PRODUCT_ACCESSORIES_FOR_POPUP_SUBMIT = By.xpath("//div[contains(@class,'ReactModal_')]//footer//button[@type='submit']");
    public By getPageButtonLocatorLinkText(String pageNumber, WebDriver driver) {
        WebElement locator = driver.findElement(By.linkText(pageNumber));
        ByConverter bc = new ByConverter();
        return bc.convertToBy(locator);
    }

    public By getProductLocatorByIndexCss(String productIndex, WebDriver driver) {
        WebElement locator = driver.findElement(By.cssSelector("div#product_listing >div#ProductBoxContainer:nth-child(" + productIndex + ") div.add-to-cart"));
        ByConverter bc = new ByConverter();
        return bc.convertToBy(locator);
    }

    public By getProductNameLocatorByIndexCss(String productIndex, WebDriver driver) {
        WebElement locator = driver.findElement(By.cssSelector("div#product_listing >div#ProductBoxContainer:nth-child(" + productIndex + ")  div#details a.block"));
        ByConverter bc = new ByConverter();
        return bc.convertToBy(locator);
    }

}
