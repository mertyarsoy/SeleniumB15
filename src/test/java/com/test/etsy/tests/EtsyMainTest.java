package com.test.etsy.tests;

import Utils.ConfigReader;
import Utils.TestBase;
import com.test.etsy.pages.HomePage;
import com.test.etsy.pages.Iphone13CasePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class EtsyMainTest extends EtsyTestBase{
    @Parameters({"searchWord", "brand", "model", "Case"})
    @Test
    public void testCase(String searchWord, String brand, String model, String Case) throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.searchData(searchWord);

        Iphone13CasePage iphone13CasePage = new Iphone13CasePage(driver);
        iphone13CasePage.validateHeaders(brand, model, Case);

    }
}
