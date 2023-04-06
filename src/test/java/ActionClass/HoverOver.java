package ActionClass;

import Utils.BrowserUtils;
import Utils.DriverHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.security.Key;
import java.time.Duration;
import java.util.*;

public class HoverOver {
    protected WebDriver driver;
    @Test
    public void validateNamesFromPictures() throws InterruptedException {
        driver = DriverHelper.getDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/hovers");

        List < WebElement> usernames = driver.findElements(By.tagName("h5"));
        List <WebElement> images = driver.findElements(By.xpath("//div[@class='figure']//img"));

        List<String> actualNames = new ArrayList<>();
        List<String> expectedNames = Arrays.asList("name: user1","name: user2","name: user3");

        Actions action = new Actions(driver);
        for (int i = 0; i < usernames.size(); i++) {
            Thread.sleep(1500);
            action.moveToElement(images.get(i)).perform();
            actualNames.add(BrowserUtils.getTextandTrim(usernames.get(i)));

        }
        System.out.println("Actual = "+actualNames);
        System.out.println("Expected = "+expectedNames);
        Assert.assertEquals(actualNames,expectedNames);


        driver.quit();
    }
    @Test
    public void moveToElement() throws InterruptedException {
        driver = DriverHelper.getDriver();
        driver.navigate().to("https://demos.telerik.com/kendo-ui/fx/expand");

        Actions action = new Actions(driver);

        Thread.sleep(2000);
        WebElement acceptCookies = driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']"));
        action.click(acceptCookies).perform();

        List <WebElement> info = driver.findElements(By.xpath("//div[@class ='product-description']//h3"));
        List<WebElement> price = driver.findElements(By.xpath("//div[@class = 'product-description']/p"));
        List <WebElement> image = driver.findElements(By.xpath("//div[@class ='product k-listview-item']//img"));

        Map <String,String> map = new HashMap<>();
        for (int i = 0; i < info.size(); i++) {
            action.moveToElement(image.get(i)).perform();
            map.put(BrowserUtils.getTextandTrim(info.get(i)),BrowserUtils.getTextandTrim(price.get(i)));
            action.sendKeys(Keys.ARROW_DOWN).perform();
        }

        Set <Map.Entry<String,String>> pairs = map.entrySet();
        for (Map.Entry<String,String> pair : pairs) {
            System.out.println(pair);
        }


        Thread.sleep(2000);
        driver.quit();
    }
}
