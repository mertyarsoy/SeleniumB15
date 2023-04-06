package com.test.saucedemo.tests;

import Utils.ConfigReader;
import Utils.TestBase;
import com.test.saucedemo.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends SauceTestBase{

    @Test(priority = 1)
    public void validatePositiveLogin() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginPositive(ConfigReader.readProperty("QA_username"),
                                ConfigReader.readProperty("QA_password"));
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");
    }

    @Test(dataProvider = "negativeLogin",dataProviderClass = AllData.class,priority = 2)
    public void validateNegativeLogin(String username,String password,String message){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginNegative(username,password,message);
    }
}
