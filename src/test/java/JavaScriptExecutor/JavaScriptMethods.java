package JavaScriptExecutor;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class JavaScriptMethods {

    // We use JavaScript methods when Selenium methods don't work
    //as expected.Specifically, click, getTitle
    //NOTE: We love using ScrollIntoView method from JavaScript in professional environment
    @Test
    public void getTitle() throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

        driver.navigate().to("https://www.techtorialacademy.com/");
        Actions action = new Actions(driver);
        Thread.sleep(500);

        String title = driver.getTitle(); // -> This is regular driver method for title
        System.out.println("Regular title ==> "+title);

        // if regular driver method does not work we use one of the JavaScript method

        JavascriptExecutor js = (JavascriptExecutor) driver; // -> Because of the casting now your driver acts like JS Executor
        String title2 = js.executeScript("return document.title").toString();
        System.out.println("JavaScript title ==> "+title2);

        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void clickJS() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

        driver.navigate().to("https://demoqa.com/radio-button");
        Actions action = new Actions(driver);
        Thread.sleep(500);

        WebElement yesButton = driver.findElement(By.xpath("//input[@id='yesRadio']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()",yesButton);

        WebElement message = driver.findElement(By.cssSelector(".mt-3"));
        Assert.assertEquals(BrowserUtils.getTextandTrim(message),"You have selected Yes");

        WebElement impressiveButton = driver.findElement(By.cssSelector("#impressiveRadio"));
        js.executeScript("arguments[0].click()",impressiveButton);

        WebElement message2 = driver.findElement(By.cssSelector(".mt-3"));
        Assert.assertEquals(BrowserUtils.getTextandTrim(message2),"You have selected Impressive");


        Thread.sleep(1000);
        driver.quit();

    }
    //This one is all about scrolling the page based on the location of element -->
    @Test
    public void scrollIntoView() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

        driver.navigate().to("https://www.techtorialacademy.com/");
        Actions action = new Actions(driver);
        Thread.sleep(500);

        WebElement findCourse = driver.findElement(By.xpath("//span[contains(text(),'Find out which course is for you')]//.."));
        JavascriptExecutor js =  (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)",findCourse); //***
        Thread.sleep(2000);
        js.executeScript("arguments[0].click()",findCourse); // **
        System.out.println(driver.getTitle());
        System.out.println(js.executeScript("return document.title")); // *


        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void shortCutJSMethods() throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

        driver.navigate().to("https://www.techtorialacademy.com/");
        Actions action = new Actions(driver);
        Thread.sleep(500);

        WebElement findCourse = driver.findElement(By.xpath("//span[contains(text(),'Find out which course is for you')]//.."));
        BrowserUtils.scrollWithJS(driver,findCourse);
        BrowserUtils.clickWithJS(driver,findCourse);
        System.out.println(BrowserUtils.getTitleWithJS(driver));



        Thread.sleep(2000);
        driver.quit();

    }


}
