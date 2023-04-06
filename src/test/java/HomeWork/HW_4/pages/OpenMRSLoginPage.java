package HomeWork.HW_4.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ThreadGuard;

public class OpenMRSLoginPage {
    public OpenMRSLoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy (xpath = "//input[@id='username']")
    WebElement username;
    @FindBy (xpath = "//input[@id='password']")
    WebElement password;
    @FindBy (css = "#Laboratory")
    WebElement location;
    @FindBy (css = "#loginButton")
    WebElement loginButton;
    public void Login(String username,String password) throws InterruptedException{
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        location.click();
        loginButton.click();
        Thread.sleep(2000);

    }


}
