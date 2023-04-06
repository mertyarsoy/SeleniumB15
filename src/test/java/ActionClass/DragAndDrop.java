package ActionClass;

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
import java.util.concurrent.BrokenBarrierException;

public class DragAndDrop {

    @Test
    public void DragAndDrop() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.navigate().to("https://demos.telerik.com/kendo-ui/dragdrop/area");
        Thread.sleep(500);
        Actions action = new Actions(driver);

        WebElement acceptCookies = driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']"));
        action.click(acceptCookies).perform();

        WebElement orangeBox = driver.findElement(By.xpath("//div[@class='test2']"));
        Assert.assertEquals(BrowserUtils.getTextandTrim(orangeBox),"... Or here.");

        String actualColorOfBox = orangeBox.getCssValue("background-color");
        String expectedColorOfBox = "rgba(238, 111, 11, 1)";
        Assert.assertEquals(actualColorOfBox,expectedColorOfBox);

        WebElement dragger = driver.findElement(By.xpath("//div[@id='draggable']"));
        action.scrollByAmount(200,200).perform();
        action.dragAndDrop(dragger,orangeBox).perform();


        // After drag and drop
        orangeBox = driver.findElement(By.xpath("//div[@class='test2']"));
        Assert.assertEquals(BrowserUtils.getTextandTrim(orangeBox),"You did great!");

        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void ClickAndHoldAndRelease() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.navigate().to("https://demos.telerik.com/kendo-ui/dragdrop/area");
        Thread.sleep(500);
        Actions action = new Actions(driver);

        WebElement acceptCookies = driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']"));
        action.click(acceptCookies).perform();

        WebElement blueBox = driver.findElement(By.xpath("//div[@class='test1']"));
        Assert.assertEquals(BrowserUtils.getTextandTrim(blueBox),"Drag the small circle here ...");

        Assert.assertEquals(blueBox.getCssValue("background-color"),"rgba(63, 81, 181, 1)");

        //Click, hold and release
        action.scrollByAmount(350,400).perform();
        WebElement dragger = driver.findElement(By.xpath("//div[@id='draggable']"));
        action.clickAndHold(dragger).moveToElement(blueBox).release().perform();

        blueBox = driver.findElement(By.xpath("//div[@class='test1']"));
        Assert.assertEquals(BrowserUtils.getTextandTrim(blueBox),"You did great!");

        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void task() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.navigate().to("https://demoqa.com/droppable");
        Actions action = new Actions(driver);
        Thread.sleep(500);

        WebElement dropBox = driver.findElement(By.xpath("//div[@id='droppable']"));
        WebElement dragger = driver.findElement(By.xpath("//div[@id='draggable']"));
        action.dragAndDrop(dragger,dropBox).perform();
        //action.clickAndHold(dragger).moveToElement(dropBox).release().perform();

        Assert.assertEquals(dropBox.getCssValue("background-color"),"rgba(70, 130, 180, 1)");
        Assert.assertEquals(BrowserUtils.getTextandTrim(dropBox),"Dropped!");

        Thread.sleep(2000);
        driver.quit();

    }
    
    @Test
    public void task2() throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.navigate().to("https://demoqa.com/droppable");
        Actions action = new Actions(driver);
        Thread.sleep(500);

        WebElement acceptClick = driver.findElement(By.cssSelector("#droppableExample-tab-accept"));
        acceptClick.click();

        WebElement dragBox = driver.findElement(By.cssSelector("#notAcceptable"));
        WebElement dragBox2 = driver.findElement(By.cssSelector("#acceptable"));
        WebElement dropBox = driver.findElement(By.xpath("//div[@id='acceptDropContainer']//div[@id='droppable']"));

        Assert.assertEquals(BrowserUtils.getTextandTrim(dragBox),"Not Acceptable");
        Assert.assertEquals(BrowserUtils.getTextandTrim(dragBox2),"Acceptable");
        Assert.assertEquals(BrowserUtils.getTextandTrim(dropBox),"Drop here");

        action.clickAndHold(dragBox).moveToElement(dropBox).release().perform();
        action.clickAndHold(dragBox2).moveToElement(dropBox).release().perform();

        dropBox = driver.findElement(By.xpath("//div[@id='acceptDropContainer']//div[@id='droppable']"));
        Assert.assertEquals(BrowserUtils.getTextandTrim(dropBox),"Dropped!");

        Thread.sleep(2000);
        driver.quit();

        
    }
}
