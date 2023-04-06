package SelectClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.NumberFormat;
import java.text.ParseException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DreamCar {
    /*
NOTE: Please use browser utils for the select classes if it is needed.
1-Navigate to the website
2-Choose the "New Cars" from the New/used option
3-Choose "Lexus" for Make part
4-Choose "RX-350"
5-Validate the Price is selected "No max price"-->getFirstSelectedOption
6-Choose the distance 40 mil
7-Put your Zip code-->Before that Clear it.60056
8-Click Search Button
9-Validate the header "New Lexus RX 350 for sale"
10-Click Sort by and choose the Lowest Price
11-Validate the all titles has Lexus RX 350
     */

    @Test
    public void validateHeaders() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

        driver.navigate().to("https://www.cars.com/");

        WebElement newUsed = driver.findElement(By.cssSelector("#make-model-search-stocktype"));
        BrowserUtils.selectBy(newUsed, "new", "value");

        WebElement make = driver.findElement(By.xpath("//select[@id='makes']"));
        BrowserUtils.selectBy(make, "Lexus", "text");

        WebElement model = driver.findElement(By.xpath("//select[@id='models']"));
        BrowserUtils.selectBy(model, "lexus-rx_350", "value");

        WebElement price = driver.findElement(By.xpath("//select[@id='make-model-max-price']"));
        Select select = new Select(price);
        System.out.println(select.getFirstSelectedOption().getText().trim());

        WebElement distance = driver.findElement(By.xpath("//select[@id='make-model-maximum-distance']"));
        BrowserUtils.selectBy(distance, "40 miles", "text");

        WebElement zipcode = driver.findElement(By.xpath("//input[@id='make-model-zip']"));
        zipcode.clear();
        zipcode.sendKeys("60056");

        WebElement submit = driver.findElement(By.xpath("//button[@type='submit']"));
        submit.click();

        WebElement header = driver.findElement(By.xpath("//h1[@class='sds-heading--1 sds-page-section__title']"));
        String actualHeader = BrowserUtils.getTextandTrim(header);
        String expectedHeader = "New Lexus RX 350 for sale";

        Assert.assertEquals(actualHeader, expectedHeader);

        WebElement sortBy = driver.findElement(By.cssSelector("#sort-dropdown"));
        BrowserUtils.selectBy(sortBy, "Lowest price", "text");


        Thread.sleep(5000);
        List<WebElement> allList = driver.findElements(By.xpath("//h2[@class='title']"));

        for (WebElement title:allList) {
            System.out.println(title.getText().trim());
            Assert.assertTrue(BrowserUtils.getTextandTrim(title).contains("Lexus RX 350"));
        }


        Thread.sleep(2000);
        driver.quit();
    }
}