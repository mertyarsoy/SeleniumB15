package FileUpload;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class FileUploadPractice{

    @Test
    public void testCase() throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.navigate().to("https://the-internet.herokuapp.com/upload");
        Actions action = new Actions(driver);
        //Thread.sleep(1000);

        WebElement chooseFile = driver.findElement(By.cssSelector("#file-upload"));
        chooseFile.sendKeys("C:\\Users\\merty\\OneDrive\\Desktop\\usaflag.png");
        //Thread.sleep(1000);

        WebElement uploadButton = driver.findElement(By.cssSelector("#file-submit"));
        uploadButton.click();

        Assert.assertEquals(BrowserUtils.getTextandTrim(driver.findElement(By.cssSelector("#uploaded-files"))),"usaflag.png");
        System.out.println(BrowserUtils.getTextandTrim(driver.findElement(By.cssSelector("#uploaded-files"))));

        driver.quit();
    }

    @Test
    public void testCase2() throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.navigate().to("https://demo.guru99.com/test/upload/");
        Actions action = new Actions(driver);
        //Thread.sleep(1000);

        WebElement chooseFile = driver.findElement(By.cssSelector("#uploadfile_0"));
        chooseFile.sendKeys("C:\\Users\\merty\\OneDrive\\Desktop\\selfie.jpg");

        Assert.assertEquals(BrowserUtils.getTextandTrim(driver.findElement(By.xpath("//*[@id=\"uploadwindow\"]/span/b"))),
                "Select file to send(max 196.45 MB)");

        WebElement agreeTerms = driver.findElement(By.xpath("//input[@type='checkbox']"));
        if (agreeTerms.isDisplayed() && agreeTerms.isEnabled() && !agreeTerms.isSelected()){
            agreeTerms.click();
        }

        WebElement submitButton = driver.findElement(By.xpath("//button[@id='submitbutton']"));
        submitButton.click();

        Thread.sleep(200);
        Assert.assertEquals(BrowserUtils.getTextandTrim(driver.findElement(By.xpath("//h3[@id='res']"))),"1 file\n" +
                "has been successfully uploaded.");

        driver.quit();

    }
}
