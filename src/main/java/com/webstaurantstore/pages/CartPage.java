package com.webstaurantstore.pages;

import com.webstaurantstore.common.WebstaurantCore;
import com.webstaurantstore.locators.CartPageLocators;
import com.webstaurantstore.utils.SeleniumMethods;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CartPage extends WebstaurantCore {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    SeleniumMethods sel = new SeleniumMethods(driver);

    public CartPage verifyItemAddedToCartSuccessful() {
        String displayedItemName = sel.getText(CartPageLocators.ADDED_ITEM_NAME_X);
        SearchResultsPage search = new SearchResultsPage(driver);
        Assert.assertEquals(displayedItemName, search.getItemName(), "the added item name does not match the item listed in the cart page");
        return this;
    }

    public CartPopUp removeAllItemsFromCart() {
        sel.selClickBy(CartPageLocators.EMPTY_CART_BUTTON_CSS);
        return new CartPopUp(driver);
    }

    public CartPage verifyRemoveAllItemsFromCartSuccessful(String message) {
        String verifyStr = sel.getText(CartPageLocators.CART_IS_EMPTY_NOTIFICATION_X);
        Assert.assertEquals(verifyStr, message, "cart is empty message did not display");
        return this;
    }

}
