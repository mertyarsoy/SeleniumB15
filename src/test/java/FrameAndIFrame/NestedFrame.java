package FrameAndIFrame;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class NestedFrame {

    @Test
    public void NestedFramePractice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        Actions action = new Actions(driver);

        driver.navigate().to("https://the-internet.herokuapp.com/nested_frames");
        Thread.sleep(500);

        driver.switchTo().frame("frame-top"); // TOP FRAME
        // LEFT FRAME
        driver.switchTo().frame("frame-left");
        Assert.assertEquals(BrowserUtils.getTextandTrim(driver.findElement(By.xpath("//body[contains(text(),'LEFT')]"))), "LEFT");
        driver.switchTo().parentFrame(); // EXIT FROM LEFT

        //MIDDLE FRAME
        driver.switchTo().frame("frame-middle");
        Assert.assertEquals(BrowserUtils.getTextandTrim(driver.findElement(By.xpath("//div[contains(text(),'MIDDLE')]"))), "MIDDLE");
        driver.switchTo().parentFrame(); // EXIT FROM MIDDLE

        //RIGHT FRAME
        driver.switchTo().frame("frame-right");
        Assert.assertEquals(BrowserUtils.getTextandTrim(driver.findElement(By.xpath("//body[contains(text(),'RIGHT')]"))), "RIGHT");
      //  driver.switchTo().parentFrame(); // EXIT FROM RIGHT
       // driver.switchTo().parentFrame(); // EXIT FROM TOP

        driver.switchTo().defaultContent();

        //BOTTOM FRAME
        driver.switchTo().frame("frame-bottom");
        Assert.assertEquals(BrowserUtils.getTextandTrim(driver.findElement(By.xpath("//body[contains(text(),'BOTTOM')]"))),"BOTTOM");
        driver.switchTo().parentFrame(); // EXIT FROM BOTTOM

        driver.quit();


    }
}
