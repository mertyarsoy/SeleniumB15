package SeleniumIntro;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.Key;
import java.time.Duration;
import java.util.List;

public class GetAttribute {
    public static void main(String[] args) throws  InterruptedException{
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.navigate().to("https://www.w3.org/TR/2019/NOTE-wai-aria-practices-1.1-20190814/examples/checkbox/checkbox-1/checkbox-1.html");

        List <WebElement> allBoxes = driver.findElements(By.xpath("//div[@role='checkbox']"));
        allBoxes.forEach(box ->{
            box.sendKeys(Keys.ARROW_DOWN);
          //  box.sendKeys(Keys.ARROW_DOWN);
            try {
                Thread.sleep(500);
            }catch (InterruptedException e){

            }
            if (box.getAttribute("aria-checked").equals("false")) {
                box.click();
            }
            box.sendKeys(Keys.ARROW_DOWN);
        });

        Thread.sleep(3000);
        driver.quit();

    }
}
