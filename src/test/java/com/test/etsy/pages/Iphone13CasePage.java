package com.test.etsy.pages;

import MentoringWithAhmet.Bank.pages.AccountPage;
import Utils.BrowserUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import javax.swing.*;
import java.util.List;

public class Iphone13CasePage {
    public Iphone13CasePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(tagName = "//li//h3")
    List<WebElement> list;
    public void validateHeaders(String brand,String model,String Case){
        for (int i = 0; i < list.size(); i++) {
            Assert.assertTrue(BrowserUtils.getTextandTrim(list.get(i)).contains(brand) ||
                    BrowserUtils.getTextandTrim(list.get(i)).contains(model) ||
                    BrowserUtils.getTextandTrim(list.get(i)).contains(Case));

        }
    }



}
