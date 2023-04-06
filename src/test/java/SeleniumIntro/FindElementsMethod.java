package SeleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class FindElementsMethod {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("file:///C:/Users/merty/OneDrive/Desktop/TECHTORIAL%20ACADEMY/ALL%20TOPICS%20SDET/SELENIUM%20folder/Techtorialhtml.html");

        List <WebElement> allBoxes = driver.findElements(By.xpath("//input[@type='checkbox']")); // 4 elements

        allBoxes.forEach(box ->{
            if (box.isDisplayed() && box.isEnabled() && !box.isSelected()){
                box.click();
                try {
                    Thread.sleep(3000);
                }catch (InterruptedException e){

                }
            }
        });

        Thread.sleep(1000);
        driver.quit();
        /*
        for (WebElement box:allBoxes) {
            if (box.isDisplayed() && !box.isSelected() && box.isEnabled()){
                Thread.sleep(1000);
                box.click();
            }
        }

         */











    }
}
