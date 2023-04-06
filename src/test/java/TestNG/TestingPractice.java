package TestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.dynalink.linker.LinkerServices;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.security.Key;
import java.security.SignedObject;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class TestingPractice {

    @Test
    public void youtube() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.navigate().to("https://www.youtube.com/");

        WebElement searchBox = driver.findElement(By.xpath("//input[@id='search']"));
        searchBox.sendKeys("Seda Kahveci");
        WebElement searchButton = driver.findElement(By.xpath("//button[@id='search-icon-legacy']"));
        searchButton.click();
        Thread.sleep(2000);

        /*
        WebElement profile = driver.findElement(By.xpath("//a[@class='channel-link yt-simple-endpoint style-scope ytd-channel-renderer']"));
        profile.click();
        Thread.sleep(2000);
        WebElement videosOption = driver.findElement(By.xpath("//div[@style-target='tab-content']"));
        videosOption.click();
        Thread.sleep(2000);
         */

        List<WebElement> allVideos = driver.findElements(By.xpath("//a[@id='video-title']"));


        for (WebElement video : allVideos) {
            video.sendKeys(Keys.ARROW_DOWN);
            video.sendKeys(Keys.ARROW_DOWN);
            video.sendKeys(Keys.ARROW_DOWN);

            List <String> list = new ArrayList<>();
            list.add(video.getText().trim());
            System.out.println(list);

            Thread.sleep(1000);
            if (video.getAttribute("title").equals("KATAR-DOHA`DA YAŞAM | ÇALIŞMAK | KATAR`A GITMELI MI?")) {
                video.click();
                System.out.println("FOUND IT ==> " + " KATAR-DOHA`DA YAŞAM | ÇALIŞMAK | KATAR`A GITMELI MI?");
                break;
            }
        }


        Thread.sleep(6000);
        driver.quit();
    }

    @Test
    public void youtube2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.navigate().to("https://www.youtube.com/");

        WebElement searchBox = driver.findElement(By.xpath("//input[@id='search']"));
        searchBox.sendKeys("Seda Kahveci");
        WebElement searchButton = driver.findElement(By.xpath("//button[@id='search-icon-legacy']"));
        searchButton.click();
        Thread.sleep(2000);

        List<WebElement> allVideos = driver.findElements(By.xpath("//a[@id='video-title']"));
        for (WebElement anotherVideo : allVideos) {
            anotherVideo.sendKeys(Keys.ARROW_DOWN);
            Thread.sleep(3000);

            Thread.sleep(1000);
            if (anotherVideo.getAttribute("title").equals("VİZE  NASIL ALINIR? BAŞVURU VE 9 İPUCU | 2020")) {
                anotherVideo.click();
                System.out.println("FOUND IT " + " VİZE  NASIL ALINIR? BAŞVURU VE 9 İPUCU | 2020");
                break;

            }
        }

        Thread.sleep(2000);
        driver.quit();


    }
}