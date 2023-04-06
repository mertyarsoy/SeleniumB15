package FrameAndIFrame;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class FramePractice {

    @Test
    public void iframe() throws InterruptedException {
        /*
 1-Navigate To the website "https://the-internet.herokuapp.com/iframe"
 2-Validate the header "An iFrame containing the TinyMCE WYSIWYG Editor"
 3-Clear the message and send "I love Selenium"
 4-Click Elemental Selenium link
 5-Validate the header "Elemental Selenium"
 */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.navigate().to("https://the-internet.herokuapp.com/iframe");
        Actions action = new Actions(driver);
        Thread.sleep(1000);

        Assert.assertEquals(BrowserUtils.getTextandTrim(driver.findElement(By.tagName("h3"))),
                "An iFrame containing the TinyMCE WYSIWYG Editor");
        System.out.println(BrowserUtils.getTextandTrim(driver.findElement(By.tagName("h3"))));

        driver.switchTo().frame("mce_0_ifr");
        WebElement paragraph = driver.findElement(By.cssSelector("#tinymce"));
        paragraph.clear();
        paragraph.sendKeys("Hello Selenium");
        driver.switchTo().parentFrame();

        WebElement elementalSelenium = driver.findElement(By.linkText("Elemental Selenium"));
        elementalSelenium.click();

        BrowserUtils.switchByTitle(driver,"Elemental Selenium: Receive a Free, Weekly Tip on Using Selenium like a Pro");

        Assert.assertEquals(BrowserUtils.getTextandTrim(driver.findElement(By.tagName("h1"))),"Elemental Selenium");
        System.out.println(BrowserUtils.getTextandTrim(driver.findElement(By.tagName("h1"))));

        Thread.sleep(2000);
        driver.quit();
    }
}
