package WaitTimes;

import Utils.BrowserUtils;
import Utils.DriverHelper;
import Utils.UpgradedDriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

import java.time.Duration;

public class FluentlyWait {

    WebDriver driver;
    @Test
    public void fluentWaitTest(){
        driver = DriverHelper.getDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/");

        WebElement dynamicControls = driver.findElement(By.linkText("Dynamic Controls"));
        dynamicControls.click();
        WebElement checkbox = driver.findElement(By.xpath("//input[@type='checkbox']"));
        if (checkbox.isDisplayed() && checkbox.isEnabled() && !checkbox.isSelected()) {
            checkbox.click();
        }
        WebElement removeButton = driver.findElement(By.xpath("//button[contains(text(),'Remove')]"));
        removeButton.click();

        Wait<WebDriver> fluentWait = new FluentWait<>(driver) // // Polymorphism
                .pollingEvery(Duration.ofSeconds(3))
                .withMessage("Text is not on the page")
                .withTimeout(Duration.ofSeconds(10))
                .ignoring(NoSuchElementException.class);

        WebElement message = fluentWait.until(mydriver-> driver.findElement(By.cssSelector("p#message")));
        System.out.println(BrowserUtils.getTextandTrim(message));

    }
}
