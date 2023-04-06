package HomeWork.HW_4.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import javax.swing.*;
import java.text.BreakIterator;
import java.util.Map;

public class PatientPage {
    public PatientPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy (xpath = "//input[@name='givenName']")
    WebElement firstName;
    @FindBy (xpath = "//input[@name='familyName']")
    WebElement lastName;
    @FindBy (xpath = "//select[@id='gender-field']")
    WebElement gender;
    @FindBy (xpath = "//span[@id='genderLabel']")
    WebElement genderTitle;
    @FindBy (xpath = "//input[@id='birthdateDay-field']")
    WebElement day;
    @FindBy (xpath = "//select[@id='birthdateMonth-field']")
    WebElement month;
    @FindBy (xpath = "//input[@id='birthdateYear-field']")
    WebElement year;
    @FindBy (xpath = "//span[contains(text(),'Address')]")
    WebElement addressTitle;
    @FindBy (css = "#address1")
    WebElement address;
    @FindBy (css = "#address2")
    WebElement address2;
    @FindBy (css = "#cityVillage")
    WebElement city;
    @FindBy (css = "#stateProvince")
    WebElement state;
    @FindBy (css = "#country")
    WebElement country;
    @FindBy (css = "#postalCode")
    WebElement postalCode;
    @FindBy (xpath = "//span[contains(text(),'Phone Number')]")
    WebElement phoneNumberTitle;
    @FindBy (xpath = "//input[@name='phoneNumber']")
    WebElement phoneNumber;
    public void registration(WebDriver driver,String firstName,String lastName,
                             String day,String month,String year,String address,
    String address2,String city,String state,String country,String postalCode,String phoneNumber) throws InterruptedException{
        this.firstName.sendKeys(firstName,Keys.ENTER);
       Thread.sleep(1500);
        BrowserUtils.acceptAlertIfPresent(driver);
        Thread.sleep(1500);
        this.lastName.sendKeys(lastName, Keys.ENTER);
        Thread.sleep(2000);
        genderTitle.click();
        Thread.sleep(3000);
        BrowserUtils.acceptAlertIfPresent(driver);
        Thread.sleep(3000);
        BrowserUtils.selectBy(gender,"Male","text");
        Thread.sleep(3000);
        BrowserUtils.acceptAlertIfPresent(driver);
       Thread.sleep(3000);
        gender.sendKeys(Keys.ENTER);
       Thread.sleep(1500);
        this.day.sendKeys(day,Keys.ENTER);
        Thread.sleep(1500);
        BrowserUtils.acceptAlertIfPresent(driver);
        Thread.sleep(1500);
        BrowserUtils.selectBy(this.month,month,"text");
       Thread.sleep(1500);
        BrowserUtils.acceptAlertIfPresent(driver);
       Thread.sleep(1500);
        this.year.sendKeys(year);
        addressTitle.click();
        Thread.sleep(3000);
        BrowserUtils.acceptAlertIfPresent(driver);
       Thread.sleep(3000);
        this.address.sendKeys(address);
        Thread.sleep(2000);
        BrowserUtils.acceptAlertIfPresent(driver);
       Thread.sleep(2000);
        this.address2.sendKeys(address2);
       Thread.sleep(2000);
        BrowserUtils.acceptAlertIfPresent(driver);
        Thread.sleep(3000);
        BrowserUtils.acceptAlertIfPresent(driver);
       Thread.sleep(3000);
        this.city.sendKeys(city);
        Thread.sleep(3000);
        BrowserUtils.acceptAlertIfPresent(driver);
        Thread.sleep(3000);
        this.state.sendKeys(state);
       Thread.sleep(3000);
        BrowserUtils.acceptAlertIfPresent(driver);
        Thread.sleep(3000);
        BrowserUtils.acceptAlertIfPresent(driver);
        Thread.sleep(3000);
        this.country.sendKeys(country);
       Thread.sleep(3000);
        BrowserUtils.acceptAlertIfPresent(driver);
       Thread.sleep(3000);
        this.postalCode.sendKeys(postalCode);
        Thread.sleep(3000);
        BrowserUtils.acceptAlertIfPresent(driver);
        Thread.sleep(3000);
        BrowserUtils.acceptAlertIfPresent(driver);
        Thread.sleep(3000);
        phoneNumberTitle.click();
        Thread.sleep(3000);
        this.phoneNumber.sendKeys(phoneNumber,Keys.ENTER);
        Thread.sleep(3000);
        BrowserUtils.acceptAlertIfPresent(driver);
        Thread.sleep(3000);
        BrowserUtils.acceptAlertIfPresent(driver);
        Thread.sleep(3000);
    }

    @FindBy (xpath = "//div[@id='dataCanvas']")
    WebElement table;
    public void validateTable(String validation){
        Assert.assertEquals(BrowserUtils.getTextandTrim(table),validation);
    }

}
