package com.test.saucedemo.tests;

import Utils.ConfigReader;
import Utils.TestBase;
import com.github.dockerjava.core.exec.SaveImageCmdExec;
import com.test.saucedemo.pages.LoginPage;
import com.test.saucedemo.pages.ProductPage;
import org.testng.annotations.Test;

public class ProductTest extends SauceTestBase{

    @Test(dataProvider = "TestingProductLinks", dataProviderClass = AllData.class)
    public void validateAllProductLinksAreWorking(String itemName, String description, String price) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginPositive(ConfigReader.readProperty("QA_username"),
                ConfigReader.readProperty("QA_password"));

        ProductPage productPage = new ProductPage(driver);
        productPage.chooseItemandValidateDescriptionAndPrice(itemName, description, price);


    }
}
