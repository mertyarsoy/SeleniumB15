package com.test.saucedemo.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class ProductPage {
    public ProductPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='inventory_item_name']")
    List<WebElement> items;
    @FindBy(xpath = "//div[@class='inventory_details_desc large_size']")
    WebElement description;
    @FindBy(xpath = "//div[@class='inventory_details_price']")
    WebElement priceHeader;

    public void chooseItemandValidateDescriptionAndPrice(String itemName, String description, String expectedPrice) {
        for (int i = 0; i < items.size(); i++) {
            if (BrowserUtils.getTextandTrim(items.get(i)).contains(itemName)) {
                items.get(i).click();
                break;
            }
        }
        Assert.assertTrue(BrowserUtils.getTextandTrim(this.description).contains(description));
        Assert.assertEquals(BrowserUtils.getTextandTrim(priceHeader), expectedPrice);
    }

}
