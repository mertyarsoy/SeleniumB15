package AlertInterface;

import Utils.BrowserUtils;
import com.beust.ah.A;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertIntro {

    @Test
    public void alertAcceptandGetText() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        Actions action = new Actions(driver);

        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");
        Thread.sleep(500);

        WebElement jsAlert = driver.findElement(By.xpath("//button[contains(@onclick,'jsAlert')]"));
        jsAlert.click();

        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "I am a JS Alert");
        alert.accept();

        Assert.assertEquals(BrowserUtils.getTextandTrim(driver.findElement(By.cssSelector("#result"))), "You successfully clicked an alert");

        driver.quit();
    }

    @Test
    public void alertDismiss() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        Actions action = new Actions(driver);

        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");
        Thread.sleep(500);

        WebElement jsConfirm = driver.findElement(By.xpath("//button[contains(@onclick,'jsConfirm')]"));
        jsConfirm.click();

        Alert alertDismiss = driver.switchTo().alert();
        alertDismiss.dismiss();

        Assert.assertEquals(BrowserUtils.getTextandTrim(driver.findElement(By.cssSelector("#result"))), "You clicked: Cancel");

        driver.quit();
    }

    @Test
    public void alertSendKeys() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        Actions action = new Actions(driver);

        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");
        Thread.sleep(500);

        WebElement jsPrompt = driver.findElement(By.xpath("//button[contains(@onclick,'jsPrompt')]"));
        jsPrompt.click();

        Alert alertPrompt = driver.switchTo().alert();
        alertPrompt.sendKeys("Mert Yarsoy");
        Thread.sleep(2000);
        alertPrompt.accept();

        Assert.assertEquals(BrowserUtils.getTextandTrim(driver.findElement(By.cssSelector("#result"))), "You entered: Mert Yarsoy");

        driver.quit();
    }

    @Test
    public void testCase() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        Actions action = new Actions(driver);

        driver.navigate().to("https://www.hyrtutorials.com/p/alertsdemo.html");
        Thread.sleep(500);

        WebElement alertBox = driver.findElement(By.cssSelector("#alertBox"));
        alertBox.click();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "I am an alert box!");
        alert.accept();

        Assert.assertEquals(BrowserUtils.getTextandTrim(driver.findElement(By.xpath("//div[contains(text(),'You selected alert popup')]"))), "You selected alert popup");

        WebElement confirmBox = driver.findElement(By.cssSelector("#confirmBox"));
        confirmBox.click();
        alert.accept();
        Assert.assertEquals(BrowserUtils.getTextandTrim(driver.findElement(By.xpath("//div[contains(text(),'You pressed OK in confirmation popup')]"))),
                "You pressed OK in confirmation popup");

        WebElement promptBox = driver.findElement(By.cssSelector("#promptBox"));
        promptBox.click();
        alert.sendKeys("Mert Yarsoy");
        alert.accept();
        Assert.assertEquals(BrowserUtils.getTextandTrim(driver.findElement(By.xpath("//div[contains(text(),'You entered text Mert Yarsoy in propmt popup')]"))),
                "You entered text Mert Yarsoy in propmt popup");

        driver.quit();
    }
}
