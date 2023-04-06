package com.test.sentrifugo.pages;

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

    @FindBy(xpath = "//input[@title='Add']")
    WebElement addButton;
    @FindBy(xpath = "//input[@id='deptname']")
    WebElement departmentName;
    @FindBy(css = "#s2id_unitid")
    WebElement businessUnit;
    @FindBy(xpath = "//span[.='Orange Blossom']")
    WebElement orangeBlossom;
    @FindBy(xpath = "//input[@id='deptcode']")
    WebElement departmentCode;
    @FindBy(id = "submitbutton")
    WebElement saveButton;
    @FindBy(css = ".ml-alert-1-success")
    WebElement message;

    @FindBy(xpath = "//tbody//tr[1]//td//span")
    List<WebElement> allinformation;

    public void validateDepartmentFunctionality(String departmentName,String departmentCode,String expectedMessage){
        addButton.click();
        this.departmentName.sendKeys(departmentName);
        businessUnit.click();
        orangeBlossom.click();
        this.departmentCode.sendKeys(departmentCode);
        saveButton.click();
        Assert.assertEquals(BrowserUtils.getTextandTrim(message),expectedMessage);
    }

    public void validateAllInfoFromList(String name,String code,String started_on,String departmentHead,
                                        String timeZone,String businessUnit){
        List<String> expected = Arrays.asList(name,code,started_on,departmentHead,timeZone,businessUnit);
        for (int i = 0; i < allinformation.size(); i++) {
            Assert.assertEquals(BrowserUtils.getTextandTrim(allinformation.get(i)),expected.get(i));
        }
    }
}
