package JavaScriptExecutor;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.bouncycastle.jce.provider.BrokenPBE;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JavaScriptPractice {
    @Test
    public void practice() throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

        driver.navigate().to("https://www.techtorialacademy.com/");
        Actions action = new Actions(driver);
        Thread.sleep(500);

        WebElement text = driver.findElement(By.xpath("//div[contains(text(),'Copyright © 2023')]"));
        BrowserUtils.scrollWithJS(driver,text);
        Assert.assertEquals(BrowserUtils.getTextandTrim(text),"Copyright © 2023");

        WebElement applyNow = driver.findElement(By.xpath("//span[contains(text(),'Apply Now')]"));
        BrowserUtils.scrollWithJS(driver,applyNow);
        BrowserUtils.clickWithJS(driver,applyNow);

        List <WebElement> list = driver.findElements(By.xpath("//h3[@data-element-id='heading3Normal']"));
        List <String> expectedList = Arrays.asList("info@techtorialacademy.com","+ 1 (224) 570 91 91","Chicago & Houston");

        for (int i = 0; i < list.size(); i++) {
            Assert.assertEquals(BrowserUtils.getTextandTrim(list.get(i)),expectedList.get(i));
            System.out.println("Validation: "+BrowserUtils.getTextandTrim(list.get(i)));
        }


        Thread.sleep(2000);
        driver.quit();
    }
}
