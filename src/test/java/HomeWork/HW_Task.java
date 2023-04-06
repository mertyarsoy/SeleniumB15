package HomeWork;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class HW_Task {

    @Test
    public void HW() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.navigate().to("https://www.techtorialacademy.com/");

        WebElement findCourse = driver.findElement(By.xpath("//span[contains(text(),'Find out which course is for you')]"));
        BrowserUtils.scrollWithJS(driver, findCourse);
        Thread.sleep(3000);
        BrowserUtils.clickWithJS(driver, findCourse);

        System.out.println(BrowserUtils.getTitleWithJS(driver));

        String pages = driver.getWindowHandle();
        Set <String> allPagesID = driver.getWindowHandles();

        for (String page:allPagesID) {
            if (!page.equals(pages)){
                driver.switchTo().window(page);
                break;
            }
        }

        System.out.println(BrowserUtils.getTitleWithJS(driver));

        Thread.sleep(2000);
        driver.quit();
    }
}
