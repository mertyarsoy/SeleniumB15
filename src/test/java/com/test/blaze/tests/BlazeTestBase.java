package com.test.blaze.tests;

import Utils.BrowserUtils;
import Utils.DriverHelper;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BlazeTestBase {
    public WebDriver driver;

    @BeforeSuite
    public void clearTheCookies(){
        driver = DriverHelper.getDriver();
        driver.manage().deleteAllCookies();
    }

    @BeforeMethod
    public void setup() {
        driver = DriverHelper.getDriver();
        driver.navigate().to("https://www.demoblaze.com/#");
    }

    @AfterMethod
    public void tearDown(ITestResult iTestResult) throws InterruptedException {
//        if (!iTestResult.isSuccess()){
//            Thread.sleep(3000);
//            BrowserUtils.getScreenShot(driver,"blazepicture");
//        }
        driver.quit();
    }
}
