package AlertInterface;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class HTMLPopUp {

    @Test
    public void testCase() throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        Actions action = new Actions(driver);

        driver.navigate().to("https://sweetalert.js.org/");
        Thread.sleep(500);

        WebElement previewButton = driver.findElement(By.xpath("//button[contains(@onclick,'alert')]"));
        previewButton.click();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(),"Oops, something went wrong!");
        alert.accept();

        WebElement otherPreviewButton = driver.findElement(By.xpath("//button[contains(@onclick,'swal')]"));
        otherPreviewButton.click();
        Thread.sleep(1000);
        Assert.assertEquals(BrowserUtils.getTextandTrim(driver.findElement(By.xpath("//div[contains(text(),'Something went wrong!')]"))),"Something went wrong!");

        driver.quit();

    }
}
