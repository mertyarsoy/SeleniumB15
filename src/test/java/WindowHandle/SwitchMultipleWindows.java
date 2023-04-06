package WindowHandle;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;
import java.time.Duration;

public class SwitchMultipleWindows {

    @Test
    public void multipleWindowsPractice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        Actions action = new Actions(driver);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open('http://www.techtorialacademy.com/')");
        js.executeScript("window.open('https://www.techtorialacademy.com/contact-us-techtorial')");
        js.executeScript("window.open('https://www.techtorialacademy.com/courses')");
        //BrowserUtils.switchByID(driver);
        BrowserUtils.switchByTitle(driver, "Contact us");
        Thread.sleep(2000);
        BrowserUtils.switchByTitle(driver, "Home");
        Thread.sleep(2000);
        BrowserUtils.switchByTitle(driver, "Courses");

        Thread.sleep(2000);
        driver.close();
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void task() throws InterruptedException {
           /*
1-Navigate to https://www.hyrtutorials.com/p/window-handles-practice.html
2-Click open multiple tabs under Button 4
3-the Basic Control and fill all the blanks
4-Click Register button and validate the message "Registration is Successful"
5-GO to the Window handle practice page and validate Header  which is Window Handles Practice
6- go to the alertsDemo page and click  the "Click Me" button under prompt box
7-quit all the pages.
8-Proud of yourself
 */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.navigate().to("https://www.hyrtutorials.com/p/window-handles-practice.html");
        Actions action = new Actions(driver);
        Thread.sleep(500);

        WebElement button4 = driver.findElement(By.xpath("//button[@id='newTabsBtn']"));
        BrowserUtils.scrollWithJS(driver, button4);
        action.click(button4).perform();

        BrowserUtils.switchByTitle(driver, "Basic Controls - H Y R Tutorials");

        String[] fields = new String[]{"//input[@id='firstName']", "//input[@id='lastName']",
                "//input[@id='email']", "//input[@id='password']"};
        String[] inputs = new String[]{"Mert", "Yarsoy", "mertyarsoy@gmail.com", "1234asd"};

        for (int i = 0; i < fields.length; i++) {
            Thread.sleep(500);
            WebElement element = driver.findElement(By.xpath(fields[i]));
            element.sendKeys(Keys.ARROW_DOWN);
            BrowserUtils.scrollWithJS(driver,element);
            element.sendKeys(inputs[i]);
        }

        WebElement language = driver.findElement(By.xpath("//input[@id='englishchbx']"));
        if (language.isEnabled() && language.isDisplayed() && !language.isSelected()) {
            language.click();
        }

        WebElement registerButton = driver.findElement(By.xpath("//button[@id='registerbtn']"));
        BrowserUtils.clickWithJS(driver, registerButton);

        WebElement message = driver.findElement(By.xpath("//label[@id='msg']"));
        Assert.assertEquals(BrowserUtils.getTextandTrim(message), "Registration is Successful");
        System.out.println(BrowserUtils.getTextandTrim(message));

        BrowserUtils.switchByTitle(driver, "Window Handles Practice - H Y R Tutorials");

        Assert.assertEquals(driver.getTitle().trim(), "Window Handles Practice - H Y R Tutorials");
        System.out.println(BrowserUtils.getTitleWithJS(driver));

        BrowserUtils.switchByTitle(driver, "AlertsDemo - H Y R Tutorials");

        WebElement box = driver.findElement(By.xpath("//button[@id='promptBox']"));
        BrowserUtils.scrollWithJS(driver, box);
        action.click(box).perform();

        driver.quit();

    }
}
