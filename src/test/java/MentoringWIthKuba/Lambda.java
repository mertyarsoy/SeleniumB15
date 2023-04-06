package MentoringWIthKuba;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.*;

public class Lambda {

    @Test
    public void task() throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.navigate().to("https://www.lambdatest.com/selenium-playground/");
        Actions action = new Actions(driver);
        Thread.sleep(1000);

        WebElement tablePagination = driver.findElement(By.xpath("//a[contains(text(),'Table Pagination')]"));
        action.click(tablePagination).perform();

        WebElement selection = driver.findElement(By.xpath("//select[@id='maxRows']"));
        BrowserUtils.selectBy(selection,"Show ALL Rows","text");


        List<WebElement> allNames = driver.findElements(By.xpath("//tr//td[2]"));
        List<WebElement> allEmail = driver.findElements(By.xpath("//tr//td[3]"));

        for (int i = 0; i < allNames.size(); i++) {
            Map <String,String> map = new LinkedHashMap<>();
                map.put(allNames.get(i).getText().trim(),allEmail.get(i).getText().trim());
            System.out.println(map);
        }

        Thread.sleep(2000);
        driver.quit();




    }
}
