package com.test.saucedemo.pages;

import Utils.BrowserUtils;
import org.checkerframework.checker.signature.qual.FieldDescriptor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {
    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy (css = "#user-name")
    WebElement username;
    @FindBy (css = "#password")
    WebElement password;
    @FindBy (css = "#login-button")
    WebElement loginButton;
    @FindBy (tagName = "h3")
    WebElement message;

    public void loginPositive(String username,String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        loginButton.click();
    }

    public void loginNegative(String username,String password,String message){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        loginButton.click();
        Assert.assertEquals(BrowserUtils.getTextandTrim(this.message),message);
    }
}
