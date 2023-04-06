package com.test.blaze.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import javax.swing.*;
import java.util.List;

public class LaptopPage {
    public LaptopPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[@class='hrefch']")
    List<WebElement> list;
    public void selectProduct(String brand) throws InterruptedException {
        for (int i = 0; i < list.size(); i++) {
            Thread.sleep(1500);
            if (BrowserUtils.getTextandTrim(list.get(i)).contains(brand)){
                list.get(i).click();
            }
        }
    }

    @FindBy(tagName = "h2")
    WebElement header;
    @FindBy (tagName = "h3")
    WebElement header2;
    @FindBy (xpath = "//div[@id='more-information']")
    WebElement header3;

    public void validationofHeaders(String expected,String expected2,String excepted3) throws InterruptedException{
        Assert.assertEquals(BrowserUtils.getTextandTrim(this.header),expected);
        Assert.assertEquals(BrowserUtils.getTextandTrim(this.header2),expected2);
        Assert.assertEquals(BrowserUtils.getTextandTrim(this.header3),excepted3);
    }

    @FindBy(xpath = "//a[contains(text(),'Add to cart')]")
    WebElement addToCartButton;
    public void clickAddToCart() throws InterruptedException {
        Thread.sleep(2000);
        addToCartButton.click();
    }

    public void alertHandleAndValidate(WebDriver driver,String expected) throws InterruptedException {
        Thread.sleep(600);
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText().trim(),expected);
        alert.accept();
    }

    @FindBy (css = "#cartur")
    WebElement cartButton;
    public void clickCartButton(WebDriver driver){
        BrowserUtils.clickWithJS(driver,cartButton);
    }


}

