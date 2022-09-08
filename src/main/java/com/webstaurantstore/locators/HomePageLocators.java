package com.webstaurantstore.locators;

import com.webstaurantstore.common.WebstaurantCore;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageLocators {

    public static final By SEARCH_INPUT_FIELD_X = By.xpath("//input[@id='searchval']");
    public static final By SEARCH_BUTTON_x = By.xpath("//button[@value='Search'][contains(text(),'Search')]");

}
