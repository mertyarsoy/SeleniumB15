package HomeWork.HW_4.pages;

import Utils.BrowserUtils;
import Utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SelectPage{
    public SelectPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#countriesSingle")
    WebElement dropDown;

    public void validateSelection(String expected) {
        Select select = new Select(dropDown);
        Assert.assertEquals(BrowserUtils.getTextandTrim(select.getFirstSelectedOption()),expected);
    }

    public void validateSize(Integer size) {
        Select select = new Select(dropDown);
        List<WebElement> allOptions = select.getOptions();
        Assert.assertEquals(allOptions.size(),size);
    }

    public void validateDropDown(String country,String country2,String country3,String country4){
        Select select = new Select(dropDown);
        List<WebElement> allOptions = select.getOptions();
        List <String> expectedList = Arrays.asList(country,country2,country3,country4);
        for (int i = 0; i < allOptions.size(); i++) {
            Assert.assertEquals(BrowserUtils.getTextandTrim(allOptions.get(i)),expectedList.get(i));
        }
    }

    public void selectChina() throws InterruptedException {
        Thread.sleep(150);
        BrowserUtils.selectBy(dropDown,"2","index");
    }
    public void selectEngland() throws InterruptedException{
        Thread.sleep(150);
        BrowserUtils.selectBy(dropDown,"england","value");
    }
    public void selectUnitedStates() throws InterruptedException{
        Thread.sleep(150);
        BrowserUtils.selectBy(dropDown,"United states of America","text");
    }

    @FindBy (xpath = "//select[@id='countriesMultiple']")
    WebElement multipleSelect;
    public void validateMultipleSelect(String country,String country2,String country3,String country4){
        Select select = new Select(multipleSelect);
        List<WebElement> allOptions = select.getOptions();
        List<String> expectedList = Arrays.asList(country,country2,country3,country4);
        for (int i = 0; i < allOptions.size(); i++) {
            Assert.assertEquals(BrowserUtils.getTextandTrim(allOptions.get(i)),expectedList.get(i));
        }
    }

    @FindBy (xpath = "//*[@id='countriesMultiple']/option[1]")
    WebElement indiaSelect;
    @FindBy (xpath = "//*[@id='countriesMultiple']/option[2]")
    WebElement usaSelect;
    @FindBy (xpath = "//*[@id='countriesMultiple']/option[3]")
    WebElement chinaSelect;
    @FindBy (xpath = "//*[@id='countriesMultiple']/option[4]")
    WebElement englandSelect;

    public void selectChinaAndEngland(WebDriver driver) throws InterruptedException {
        Actions action = new Actions(driver);
        action.clickAndHold(chinaSelect).moveToElement(englandSelect).release().perform();
    }

    @FindBy (xpath = "//div[@id='result']")
    WebElement header;
    public void validateHeader(){
        Assert.assertTrue(header.isDisplayed());
    }

    public void deSelectAll(){
        Select select = new Select(multipleSelect);
        select.deselectAll();
    }

    public void selectAllAndValidate(WebDriver driver){
        Actions action = new Actions(driver);
        action.clickAndHold(indiaSelect).moveToElement(usaSelect).
                moveToElement(chinaSelect).moveToElement(englandSelect).release().perform();
        Assert.assertTrue(header.isDisplayed());
        }

        public void deSelectChinaAndEngland(){
        Select select = new Select(multipleSelect);
        select.deselectByIndex(2);
        select.deselectByValue("england");
        }
    }



