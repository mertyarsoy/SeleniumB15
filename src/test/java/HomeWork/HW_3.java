package HomeWork;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class HW_3 {

    @Test
    public void testCase()  throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        Actions action = new Actions(driver);

        driver.navigate().to("http://uitestpractice.com/Students/Index");
        Thread.sleep(500);

        WebElement button = driver.findElement(By.xpath("//button[@class='btn btn-info']"));
        action.click(button).perform();

        //Thread.sleep(2500);
        driver.switchTo().frame("aswift_2");
        driver.switchTo().frame("ad_iframe");
        WebElement ad = driver.findElement(By.cssSelector("#dismiss-button"));
        ad.click();

        Thread.sleep(1500);
        String[] fields = new String[]{"//input[@id='FirstName']","//input[@id='LastName']","//input[@id='EnrollmentDate']"};
        String[] inputs = new String[]{"Mert","Yarsoy","3/2/2023"};

        for (int i = 0; i < fields.length; i++) {
            WebElement element = driver.findElement(By.xpath(fields[i]));
            element.sendKeys(inputs[i]);
        }

        WebElement submitButton = driver.findElement(By.xpath("//input[@type='submit']"));
        submitButton.click();

        WebElement searchButton = driver.findElement(By.cssSelector("#Search_Data"));
        searchButton.sendKeys("Mert", Keys.ENTER);

        Thread.sleep(1000);
        Assert.assertEquals(BrowserUtils.getTextandTrim(driver.findElement(By.xpath("//td[contains(text(),'Mert')]"))),"Mert");
        Assert.assertEquals(BrowserUtils.getTextandTrim(driver.findElement(By.xpath("//td[contains(text(),'Yarsoy')]"))),"Yarsoy");
        Assert.assertEquals(BrowserUtils.getTextandTrim(driver.findElement(By.xpath("//td[contains(text(),'3/2/2023 12:00:00 AM')]"))),"3/2/2023 12:00:00 AM");

        driver.quit();
    }

    @Test
    public void testCase2() throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        Actions action = new Actions(driver);

        driver.navigate().to("http://uitestpractice.com/Students/Index");
        Thread.sleep(500);

        WebElement searchButton = driver.findElement(By.cssSelector("#Search_Data"));
        searchButton.sendKeys("Yarsoy", Keys.ENTER);

        WebElement editButton = driver.findElement(By.xpath("//button[@style='background-color:blueviolet']"));
        BrowserUtils.clickWithJS(driver,editButton);

        WebElement firstName = driver.findElement(By.xpath("//input[@id='FirstName']"));
        firstName.clear(); firstName.sendKeys("John");

        WebElement saveButton = driver.findElement(By.xpath("//input[@class='btn btn-default']"));
        saveButton.click();

        Thread.sleep(2000);
        WebElement searchButton2 = driver.findElement(By.cssSelector("#Search_Data"));
        Thread.sleep(1000);
        searchButton2.sendKeys("John",Keys.ENTER);

        WebElement pageSwitch = driver.findElement(By.xpath("//a[contains(text(),'3')]"));
        BrowserUtils.clickWithJS(driver,pageSwitch);

        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void testCase3() throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        Actions action = new Actions(driver);

        driver.navigate().to("http://uitestpractice.com/Students/Index");
        Thread.sleep(500);

        WebElement searchButton = driver.findElement(By.cssSelector("#Search_Data"));
        searchButton.sendKeys("Ben",Keys.ENTER);
        Thread.sleep(2000);
/*
        WebElement deleteButton = driver.findElement(By.xpath("//button[contains(text(),'DELETE')]"));
        BrowserUtils.clickWithJS(driver,deleteButton);

        WebElement confirmDelete = driver.findElement(By.xpath("//input[@value='Delete']"));
        confirmDelete.click();

        WebElement searchButton2 = driver.findElement(By.cssSelector("#Search_Data"));
        searchButton2.sendKeys("Yakup",Keys.ENTER);

 */

        Assert.assertTrue(BrowserUtils.getTextandTrim(driver.findElement(By.xpath("//div[@class='container body-content']")))
                .contains("There are zero students with this search text Page 0 of 0"));

        driver.quit();
    }

    @Test
    public void testCase4() throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        Actions action = new Actions(driver);

        driver.navigate().to("http://uitestpractice.com/");
        Thread.sleep(500);

        WebElement drag = driver.findElement(By.cssSelector("#draggable"));
        WebElement drop = driver.findElement(By.cssSelector("#droppable"));
        action.clickAndHold(drag).moveToElement(drop).release().perform();

        Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'Dropped!')]")).isDisplayed());

        Thread.sleep(500);
        driver.quit();

    }

    @Test
    public void testCase5() throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        Actions action = new Actions(driver);

        driver.navigate().to("http://uitestpractice.com/");
        Thread.sleep(500);

        WebElement doubleClickButton = driver.findElement(By.xpath("//button[contains(@ondblclick,'myDblClickFunction')]"));
        action.doubleClick(doubleClickButton).perform();

        Alert alert = driver.switchTo().alert();
        alert.accept();

        driver.quit();
    }

    @Test
    public void tesCase6() throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        Actions action = new Actions(driver);

        driver.navigate().to("http://uitestpractice.com/");
        Thread.sleep(1000);

        driver.switchTo().frame("iframe_a");
        WebElement nameButton = driver.findElement(By.cssSelector("#name"));
        BrowserUtils.scrollWithJS(driver,nameButton);
        nameButton.sendKeys("Mert Yarsoy");
        driver.switchTo().parentFrame();
        Thread.sleep(2000);
        WebElement link = driver.findElement(By.linkText("uitestpractice.com"));
        BrowserUtils.clickWithJS(driver,link);

        driver.quit();
    }

    @Test
    public void testCase7() throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        Actions action = new Actions(driver);

        driver.navigate().to("http://uitestpractice.com/");
        Thread.sleep(1000);

        WebElement clickButton = driver.findElement(By.xpath("//a[contains(@onclick,'window.open')]"));
        BrowserUtils.scrollWithJS(driver,clickButton);
        BrowserUtils.clickWithJS(driver,clickButton);

        BrowserUtils.switchByID(driver);
       // BrowserUtils.switchByTitle(driver,"(7) C# Beginner to advanced - Lesson 29 - Delegates - YouTube");

        Thread.sleep(3000);
        Assert.assertEquals(BrowserUtils.getTextandTrim(driver.findElement(By.xpath("//h1[@class='style-scope ytd-watch-metadata']"))),
                "C# Beginner to advanced - Lesson 29 - Delegates");

        Thread.sleep(1000);
        driver.quit();
    }


}
