package MentoringWithAhmet.Bank.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerPage {
    public CustomerPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy (css = "#userSelect")
    WebElement selection;
    @FindBy (xpath = "//button[contains(text(),'Login')]")
    WebElement loginButton;
    public void selectHarryPotter(String selection){
        BrowserUtils.selectBy(this.selection,selection,"text");
        loginButton.click();
    }
}
