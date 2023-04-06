package MentoringWithAhmet.Bank.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AccountPage {
    public AccountPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy (xpath = "//strong[contains(text(),'Welcome')]")
    WebElement header;
    public void validateHarryPotter(String expected){
        Assert.assertEquals(BrowserUtils.getTextandTrim(header),expected);
    }

    @FindBy (xpath = "//button[contains(@ng-click,'deposit()')]")
    WebElement topDepositButton;
    @FindBy (xpath = "//input[@placeholder='amount']")
    WebElement selectAmount;
    @FindBy (xpath = "//button[@type='submit']")
    WebElement bottomDepositButton;
    public void deposit(String amount){
        topDepositButton.click();
        this.selectAmount.sendKeys(amount);
        bottomDepositButton.click();
    }

    @FindBy (xpath = "//span[contains(text(),'Deposit Successful')]")
    WebElement header2;
    public void validateDeposit(String expected){
        Assert.assertEquals(BrowserUtils.getTextandTrim(header2),expected);
    }

}
