package HomeWork.HW_4.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    public HomePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "#referenceapplication-registrationapp-registerPatient-" +
            "homepageLink-referenceapplication-registrationapp-registerPatient-homepageLink-extension")
    WebElement registerPatient;
    public void clickRegisterPatient(){
        registerPatient.click();
    }
}
