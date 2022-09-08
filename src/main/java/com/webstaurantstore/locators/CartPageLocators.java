package com.webstaurantstore.locators;

import org.openqa.selenium.By;

public class CartPageLocators {

    public static final By ADDED_ITEM_NAME_X = By.xpath("//div[@class='cartItems']//div[@class='ag ag-cart box']//span[@class='itemDescription description']");
    public static final By EMPTY_CART_BUTTON_CSS =  By.cssSelector("button.emptyCartButton");
    public static final By CART_IS_EMPTY_NOTIFICATION_X = By.xpath("//div[@class='cartEmpty']//p[@class='header-1']");
}
