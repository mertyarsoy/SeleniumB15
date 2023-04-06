package WaitTimes;

import Utils.BrowserUtils;
import Utils.DriverHelper;
import Utils.UpgradedDriverHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ExplicitlyWait {

    WebDriver driver;

    @Test
    public void validateTheText() throws InterruptedException {
        driver = DriverHelper.getDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/");

        WebElement dynamicLoading = driver.findElement(By.linkText("Dynamic Loading"));
        dynamicLoading.click();
        WebElement example1 = driver.findElement(By.linkText("Example 1: Element on page that is hidden"));
        example1.click();
        WebElement startButton = driver.findElement(By.tagName("button"));
        startButton.click();
        WebElement header = DriverHelper.waitForElement(By.xpath("//*[@id=\"finish\"]/h4"));
        Assert.assertEquals(BrowserUtils.getTextandTrim(header), "Hello World!");

        driver.navigate().back();
        driver.navigate().back();

        WebElement dynamicControls = driver.findElement(By.linkText("Dynamic Controls"));
        dynamicControls.click();
        WebElement checkbox = driver.findElement(By.xpath("//input[@type='checkbox']"));
        if (checkbox.isDisplayed() && checkbox.isEnabled() && !checkbox.isSelected()) {
            checkbox.click();
        }
        WebElement removeButton = driver.findElement(By.xpath("//button[contains(text(),'Remove')]"));
        removeButton.click();
        WebElement header2 = DriverHelper.waitForElement(By.cssSelector("p#message"));
        Assert.assertEquals(BrowserUtils.getTextandTrim(header2), "It's gone!");

        driver.quit();
    }
}
