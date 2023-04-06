package com.test.blaze.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

public class CartPage {
    public CartPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(tagName = "td")
    List<WebElement> info;
    public void validateProduct(String title,String price) {
        List<String> expecteds = Arrays.asList(title, price);
        for (int i = 0; i < info.size(); i++) {
            if (BrowserUtils.getTextandTrim(info.get(i)).equals("MacBook Pro") && BrowserUtils.getTextandTrim(info.get(i)).equals("1100")) {
                Assert.assertEquals(BrowserUtils.getTextandTrim(info.get(i)), expecteds.get(i));
            }
        }
    }

    @FindBy (xpath = "//button[contains(text(),'Place Order')]")
    WebElement placeOrderButton;

    public void clickPlaceOrderButton(){
        placeOrderButton.click();
    }



}
