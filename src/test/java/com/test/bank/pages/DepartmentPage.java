package com.test.bank.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

public class DepartmentPage {
    public DepartmentPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//button[contains(text(),'Add Customer')]")
    WebElement addCustomerButton;
    public void clickAddCustomerButton(){
        addCustomerButton.click();
    }

    @FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement firstName;
    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement lastName;
    @FindBy(xpath = "//input[@placeholder='Post Code']")
    WebElement postalCode;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitButton;
    public void setInformation(String firstName,String lastName,String postalCode){
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.postalCode.sendKeys(postalCode);
        submitButton.click();
    }

    @FindBy(xpath = "//button[contains(@ng-click,'openAccount()')]")
    WebElement openAccountButton;
    public void clickopenAccountButton(){
        openAccountButton.click();
    }

    @FindBy(css = "#userSelect")
    WebElement customerName;
    @FindBy(css = "#currency")
    WebElement currency;
    public void setSelection(){
        customerName.click();
        BrowserUtils.selectBy(customerName,"6","value");
        currency.click();
        BrowserUtils.selectBy(currency,"Dollar","text");
    }

    @FindBy(xpath = "//button[contains(text(),'Process')]")
    WebElement processButton;
    public void clickProcessButton(){
        processButton.click();
    }

    @FindBy(xpath = "//button[@ng-class='btnClass3']")
    WebElement customersButton;
    public void clickCustomerButton(){
        customersButton.click();
    }

    @FindBy(xpath = "//input[@placeholder='Search Customer']")
    WebElement searchButton;
    public void searchYourName(String name){
        this.searchButton.sendKeys(name);
    }

    @FindBy(xpath = "//tbody//tr[1]//td")
    List<WebElement> message;
    public void validation(String firstName,String lastName,
                           String postCode,String accountNumber){

        List<String> list = Arrays.asList(firstName,lastName,postCode,accountNumber);
        for (int i = 0; i < list.size(); i++) {
            Assert.assertEquals(BrowserUtils.getTextandTrim(message.get(i)),list.get(i));
        }
    }

    @FindBy(xpath = "//button[contains(text(),'Delete')]")
    WebElement deleteButton;
    public void clickDeleteButton(){
        deleteButton.click();
    }

}
