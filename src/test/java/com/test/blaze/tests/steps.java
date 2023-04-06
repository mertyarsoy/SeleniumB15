package com.test.blaze.tests;

import Utils.ConfigReader;
import Utils.TestBase;
import com.test.blaze.pages.CartPage;
import com.test.blaze.pages.HomePage;
import com.test.blaze.pages.LaptopPage;
import com.test.blaze.pages.OrderPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class steps extends BlazeTestBase{

    @Parameters({"laptopBrand","laptopPrice","message"})
    @Test
    public void testCase(String laptopBrand, String laptopPrice,
                         String message) throws InterruptedException {
        /*
    1-Navigate to the website "https://www.demoblaze.com/#"
    2-Click the Laptops from homepage(firstPage)
    3-Click MacBook Pro from the list with Loop(LaptopPage)
    4-Validate the header="MacBook Pro"(MacBook Pro Page)
    5-Validate the price=$1100 *includes tax(MacBook Pro Page)
    6-Validate the product Descr="Product description(MacBook Pro Page)
Apple has introduced three new versions of its MacBook Pro line, including a 13-inch and
15-inch model with the Touch Bar, a thin, multitouch strip display that sits above the MacBook Pro's keyboard."
    7-Click the Add to card Button and validate the alert text="Product added" then click "OK" button
     */

        HomePage homePage = new HomePage(driver);
        homePage.clickLaptopButton();

        LaptopPage laptopPage = new LaptopPage(driver);
        laptopPage.selectProduct(laptopBrand);
        laptopPage.validationofHeaders(laptopBrand, laptopPrice, "Product description\n" +
                "Apple has introduced three new versions of its MacBook Pro line, including a 13-inch and 15-inch model with the Touch Bar, a thin," +
                " multi-touch strip display that sits above the MacBook Pro's keyboard.");
        laptopPage.clickAddToCart();
        Thread.sleep(200);
        laptopPage.alertHandleAndValidate(driver, message);

    }

    @DataProvider(name = "customerInfo")
    public Object[][] getData(){
        return new Object[][]{
                {"Mert Yarsoy","USA","Miami","122312313","September","2023"},
                {"John","USA","Chicago","12334452","January","2026"},
                {"Phuong","Vietnam","Siylong","2112351234","April","2029"}
        };
    }
    @Test(dataProvider = "customerInfo")
    public void testCase2(String name,String country,String city,
                          String creditCard,String month,String year)
        throws InterruptedException {
        /*
1-Navigate to the website "https://www.demoblaze.com/#"
2-Click the Laptops from homepage(firstPage)
3-Click MacBook Pro from the list with Loop(LaptopPage)
4-Click Add to cart button
5-Validate the text and click ok button(you already have method)
6-Click Cart Button top(WebElement can be in MainPage)
7-Validate the Name of Product and Price(no need test class for it just method)
8-Click Place Order and provide all the information(ORDER PAGE)
9-Validate the Thank-you message and click OK
10-Validate the url is "https://www.demoblaze.com/index.html"
 */

        HomePage homePage = new HomePage(driver);
        homePage.clickLaptopButton();

        LaptopPage laptopPage = new LaptopPage(driver);
        laptopPage.selectProduct("MacBook Pro");
        laptopPage.clickAddToCart();
        laptopPage.alertHandleAndValidate(driver, "Product added");

        laptopPage.clickCartButton(driver);

        CartPage cartPage = new CartPage(driver);
        cartPage.validateProduct("Macbook Pro", "1100");
        cartPage.clickPlaceOrderButton();

        OrderPage orderPage = new OrderPage(driver);
        orderPage.sendInformations(name, country, city, creditCard, month, year);
        orderPage.clickPurchaseButton(driver);

        orderPage.orderValidationandURL(driver, "Thank you for your purchase!", "https://www.demoblaze.com/index.html");

    }

}
