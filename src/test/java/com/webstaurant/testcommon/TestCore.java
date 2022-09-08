package com.webstaurant.testcommon;

import com.webstaurantstore.pages.HomePage;
import com.webstaurantstore.utils.JsonReader;
import com.webstaurantstore.utils.WebDriverConfig;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

public class TestCore {

    protected WebDriver driver;
    protected HomePage homepage;
    protected static Properties testConfig;
    protected String baseUrl;

    @BeforeSuite()
    public void beforSuite() throws IOException {
        testConfig = new Properties();
        testConfig.load(new FileInputStream("src/main/resources/UITestConfig.properties"));
    }

    @BeforeMethod()
    @Parameters({"browserRemote"})
    public void beforeMethod(@Optional String browserRemote) {
        driver = WebDriverConfig.createDriver(testConfig.getProperty("browser"), testConfig.getProperty("runFromSuite"), browserRemote);
        if(System.getProperty("test.env") != null) {
            baseUrl = System.getProperty("test.env");
        }
        else {
            baseUrl = testConfig.getProperty("baseUrl");
        }
        driver.get(baseUrl);
        homepage = new HomePage(driver);
    }

    @DataProvider(name = "dataProvider")
    public Object[][] passData(Method method) throws IOException {
        testConfig = new Properties();
        testConfig.load(new FileInputStream("src/main/resources/UITestConfig.properties"));
        String name = getClass().getName();
        String fileName = name.substring(name.lastIndexOf(".") + 1).trim();
        return JsonReader.getdata(testConfig.getProperty("dataLocation").concat(fileName).concat(".json"), method.getName());
    }

    @AfterMethod()
    public void afterMethod(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            try {
                TakesScreenshot screenshot = (TakesScreenshot) driver;
                File srs = screenshot.getScreenshotAs(OutputType.FILE);
                String osName = System.getProperty("os.name");
                if (osName.contains("Windows")) {
                    FileUtils.copyFile(srs, new File(".\\printscreen\\failureprintscreen" + result.getName() + ".png"));
                } else {
                    FileUtils.copyFile(srs, new File("printscreen/failureprintscreen" + result.getName() + ".png"));
                }
                System.out.println("Screenshot captured, please investigate");
            } catch (Exception e) {
                System.out.println("Exception while taking screenshot ->" + e.getMessage());
            }
        }
        WebDriverConfig.quitDriver(driver);
    }

}
