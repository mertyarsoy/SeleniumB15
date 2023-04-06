package HomeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class HW {
    /*
 -->HOMEWORK:
  --> Go to the website that I send on the slack
       --> Click all the boxes when aria-label is false (Think about getAttribute method)
       -> URL = https://www.w3.org/TR/2019/NOTE-wai-aria-practices-1.1-20190814/examples/checkbox/checkbox-1/checkbox-1.html
     */
    public static void main(String[] args) throws InterruptedException{
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.w3.org/TR/2019/NOTE-wai-aria-" +
                "practices-1.1-20190814/examples/checkbox/checkbox-1/checkbox-1.html");

        List<WebElement> boxes = driver.findElements(By.xpath("//div[@aria-checked ='false']"));

/*
        for (WebElement box:boxes) {
         if (box.isDisplayed() && !box.isSelected() && box.isEnabled()){
             box.click();
             Thread.sleep(2000);
         }
        }
 */

        boxes.forEach(box ->{
            if (box.isDisplayed() && !box.isSelected() && box.isEnabled());
            try {
                Thread.sleep(500);
            }catch (InterruptedException e){

            }
            box.click();
        } );




        Thread.sleep(4000);
        driver.quit();



    }
}
