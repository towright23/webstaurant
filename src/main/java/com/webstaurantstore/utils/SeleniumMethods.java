package com.webstaurantstore.utils;

import com.webstaurantstore.common.WebstaurantCore;
import com.webstaurantstore.helper.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class SeleniumMethods extends WebstaurantCore {

    public SeleniumMethods(WebDriver driver) {
        super(driver);
    }

    public void selClickBy(By byElemLocator) {
        Waits wait = new Waits(driver);
        wait.waitForElementClickableBy(byElemLocator);
        driver.findElement(byElemLocator).click();
    }

    public void selClearFieldBy(By byElemLocator) {
        Waits wait = new Waits(driver);
        wait.waitForVisibilityOfElementBy(byElemLocator);
        driver.findElement(byElemLocator).clear();
    }

    public void selSendKeysBy(By byElemLocator, String inputStr) {
        Waits wait = new Waits(driver);
        wait.waitForVisibilityOfElementBy(byElemLocator);
        driver.findElement(byElemLocator).sendKeys(inputStr);
    }

    public String getText(By byElemLocator) {
        Waits wait = new Waits(driver);
        wait.waitForVisibilityOfElementBy(byElemLocator);
        return driver.findElement(byElemLocator).getText();
    }

    public void actionsMoveToElementBy(By byElemLocator) {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(byElemLocator)).perform();
    }

    public void jsClick(By byElemLocator) {
        Waits wait = new Waits(driver);
        wait.waitForVisibilityOfElementBy(byElemLocator);
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", driver.findElement(byElemLocator));
    }

    public void jsScroll(By byElemLocator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(byElemLocator));
    }

    public int findTotalElementCount(By elemLocator) {
        return driver.findElements(elemLocator).size();
    }

    public List<WebElement> getAllWebElements(By byElemLocator) {
        Waits wait = new Waits(driver);
        wait.waitForVisibilityOfElementBy(byElemLocator);
        return driver.findElements(byElemLocator);
    }

    public boolean isElementPresent(By byElemLocator) {
        return driver.findElements(byElemLocator).size() > 0;
    }

}
