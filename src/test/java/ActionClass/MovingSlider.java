package ActionClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class MovingSlider {

    @Test
    public void validateSliderFunctionality() throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

        driver.navigate().to("https://the-internet.herokuapp.com/");
        Actions action = new Actions(driver);
        Thread.sleep(500);

        WebElement horizontalSlider = driver.findElement(By.linkText("Horizontal Slider"));
        horizontalSlider.click();
        WebElement slider = driver.findElement(By.xpath("//input[@type='range']"));
        WebElement range = driver.findElement(By.xpath("//span[@id='range']"));

          while (!BrowserUtils.getTextandTrim(range).equals("4.5")){
              Thread.sleep(1000);
              slider.sendKeys(Keys.ARROW_RIGHT);
          }

        Assert.assertEquals(BrowserUtils.getTextandTrim(range),"4.5");
        Thread.sleep(5000);
        driver.quit();




    }
}
