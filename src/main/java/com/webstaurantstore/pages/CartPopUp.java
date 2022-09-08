package com.webstaurantstore.pages;

import com.webstaurantstore.common.WebstaurantCore;
import com.webstaurantstore.locators.CartPopUpLocators;
import com.webstaurantstore.utils.SeleniumMethods;
import org.openqa.selenium.WebDriver;

public class CartPopUp extends WebstaurantCore {
    public CartPopUp(WebDriver driver) {
        super(driver);
    }

    SeleniumMethods sel = new SeleniumMethods(driver);

    public CartPage selectEmptyCartFromPopUp() {
        sel.selClickBy(CartPopUpLocators.EMPTY_CART_BUTTON_X);
        return new CartPage(driver);
    }
}
