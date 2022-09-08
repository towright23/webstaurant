package com.webstaurantstore.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.security.InvalidParameterException;
import java.util.concurrent.TimeUnit;

public class WebDriverConfig {
        public static WebDriver createDriver(String browser, String runFromSuite, String browserRemote) {
        WebDriver driver;
        if (runFromSuite.equalsIgnoreCase("true")) {
            if (browserRemote.equalsIgnoreCase("chromeRemote")) {
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("disable-infobars");
                options.addArguments("disable-dev-shm-usage");
                driver = new ChromeDriver(options);
                driver.manage().window().maximize();
            } else if (browserRemote.equalsIgnoreCase("chromeRemoteHeadless")) {
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless");
                options.addArguments("enable-automation");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-extensions");
                options.addArguments("--dns-prefetch-disable");
                options.addArguments("--disable-gpu");
                options.addArguments("--disable-dev-shm-usage");
                options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                driver = new ChromeDriver(options);
                driver.manage().window().maximize();
            } else if (browserRemote.equalsIgnoreCase("firefoxRemote")) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
            } else if (browserRemote.equalsIgnoreCase("firefoxRemoteHeadless")) {
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments("--headless");
                driver = new FirefoxDriver(options);
                driver.manage().window().maximize();
            } else {
                throw new InvalidParameterException(
                        browserRemote + "- is not a valid web browser for remote driver.");
            }
        } else {
            if (browser.equalsIgnoreCase("Firefox")) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
            } else if (browser.equalsIgnoreCase("FireFoxHeadless")) {
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments("--headless");
                driver = new FirefoxDriver(options);
                driver.manage().window().maximize();
            } else if (browser.equalsIgnoreCase("Chrome")) {
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("disable-infobars");
                driver = new ChromeDriver(options);
                driver.manage().window().maximize();
            } else if (browser.equalsIgnoreCase("ChromeHeadless")) {
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless");
                driver = new ChromeDriver(options);
                driver.manage().window().maximize();
            } else {
                throw new InvalidParameterException(browser + "- is not a valid web browser for web driver.");
            }
        }
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver;
    }

    public static void quitDriver(WebDriver driver) {
        driver.close();
    }
}
