package FrameAndIFrame;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.compress.compressors.lz77support.LZ77Compressor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class FramePractice2 {

    @Test
    public void practiceFrame() throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.navigate().to("https://skpatro.github.io/demo/iframes/");
        Actions action = new Actions(driver);
        Thread.sleep(1000);
        /*
TASK 1:
  1-Navigate to the website "https://skpatro.github.io/demo/iframes/"
  2-Click pavilion (new tab will be opened, consider switch window)
  3-Choose "Selenium-Java" from Selenium button (Action class is suggested)
  4-Validate the Header "Selenium-Java Tutorial – Basic to Advance"
  5-Print out(NO validation) Table of Content options on console(loop and getText())
  6-Wait for Second task
 */
        WebElement pavilion = driver.findElement(By.xpath("//a[contains(text(),'Pavilion')]"));
        pavilion.click();

        BrowserUtils.switchByTitle(driver,"Home - qavalidation");

        //Thread.sleep(2000);
        WebElement seleniumOption = driver.findElement(By.xpath("//span[contains(text(),'Selenium')]"));
        WebElement seleniumJava = driver.findElement(By.xpath("//span[contains(text(),'Selenium-Java')]"));
       // Thread.sleep(2000);
        action.moveToElement(seleniumOption).click(seleniumJava).perform();

        Assert.assertEquals(BrowserUtils.getTextandTrim(driver.findElement(By.tagName("h1"))),
                "Selenium-Java Tutorial – Basic to Advance");

        List <WebElement> list = driver.findElements(By.xpath("//ul[@class='ht_toc_list']"));
        for (int i = 0; i < list.size(); i++) {
            System.out.println(BrowserUtils.getTextandTrim(list.get(i)));
        }

        /*
TASK 2:
1-Go back to the main page "iframe"
2-click category 1
3-Validate the header "Category Archives: SeleniumTesting"
4-Print out all the headers of the contents(i will show you)
 */
        BrowserUtils.switchByTitle(driver,"iframes");

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='Frame1']")));
        WebElement category1 = driver.findElement(By.xpath("//a[contains(text(),'Category1')]"));
        category1.click();
       //driver.switchTo().parentFrame();

        BrowserUtils.switchByTitle(driver,"SeleniumTesting Archives - qavalidation");

        Assert.assertEquals(BrowserUtils.getTextandTrim(driver.findElement(By.tagName("h1"))),"Category Archives: SeleniumTesting");

        List <WebElement> listOfTitles = driver.findElements(By.xpath("//h3[@class='entry-title']"));
        for (int i = 0; i < listOfTitles.size(); i++) {
            System.out.println(BrowserUtils.getTextandTrim(listOfTitles.get(i)));
        }

        //TASK 3

        BrowserUtils.switchByTitle(driver,"iframes");

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='Frame2']")));
        WebElement category3 = driver.findElement(By.xpath("//a[contains(text(),'Category3')]"));
        BrowserUtils.clickWithJS(driver,category3);
        //driver.switchTo().parentFrame();

        BrowserUtils.switchByTitle(driver,"SoftwareTesting Archives - qavalidation");

        Assert.assertEquals(BrowserUtils.getTextandTrim(driver.findElement(By.tagName("h1"))),"Category Archives: SoftwareTesting");

        Thread.sleep(2000);
        driver.quit();
    }
}
