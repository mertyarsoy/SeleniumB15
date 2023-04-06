package com.test.blaze.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class OrderPage {
    public OrderPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "name")
    WebElement name;
    @FindBy(id = "country")
    WebElement country;
    @FindBy(id = "city")
    WebElement city;
    @FindBy(id = "card")
    WebElement card;
    @FindBy(id = "month")
    WebElement month;
    @FindBy(id = "year")
    WebElement year;
    public void sendInformations(String name,String country,String city,
                                 String card,String month,String year){
        this.name.sendKeys(name);
        this.country.sendKeys(country);
        this.city.sendKeys(city);
        this.card.sendKeys(card);
        this.month.sendKeys(month);
        this.year.sendKeys(year);
    }
    @FindBy (xpath = "//button[contains(@onclick,'purchaseOrder()')]")
    WebElement purchaseButton;
    public void clickPurchaseButton(WebDriver driver){
        BrowserUtils.scrollWithJS(driver,purchaseButton);
        purchaseButton.click();
    }

    @FindBy(xpath = "//h2[contains(text(),'Thank you for your purchase!')]")
    WebElement order;
    @FindBy(xpath = "//button[contains(text(),'OK')]")
    WebElement okButton;
    public void orderValidationandURL(WebDriver driver,String expected,String expectedURL) throws InterruptedException {
        Assert.assertEquals(BrowserUtils.getTextandTrim(order),expected);
        Thread.sleep(1000);
        okButton.click();
        Thread.sleep(500);
        Assert.assertEquals(driver.getCurrentUrl(),expectedURL);
    }
}




