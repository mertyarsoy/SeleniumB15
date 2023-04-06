package SeleniumIntro;

import Utils.BrowserUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class YoutubeInterviewQuestion {
    /* 1-Navigate to the website YouTube
 2-Search for justin bieber
 3-Find the all song names and store in the list Justin Bieber - Hold On (Live from Paris)
 4-Use for and if conditions to find the song
 5-Click the song
 6-Enjoy your music
 7-Ready to be level 2
 */
    public static void main(String[] args) throws InterruptedException{
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

        driver.navigate().to("https://www.youtube.com/");

        WebElement search = driver.findElement(By.xpath("//input[@id='search']"));
        search.sendKeys("Justin Bieber songs");search.sendKeys(Keys.ENTER);
        Thread.sleep(2000);

        /*
        WebElement click = driver.findElement(By.xpath("//button[@class='style-scope ytd-searchbox']"));
        click.click();
         */

        List<WebElement> allSongs = driver.findElements(By.xpath("//a[@id='video-title']"));

        for (WebElement song:allSongs) {
            song.sendKeys(Keys.ARROW_DOWN);
            Thread.sleep(1000);
           if (song.getAttribute("title").equals("Justin Bieber - Ghost")){
              song.click();
               System.out.println(BrowserUtils.getTextandTrim(song));
               System.out.println("FOUND IT !! "+driver.getCurrentUrl());
              break;
           }
        }

        Thread.sleep(6000);
        driver.quit();





    }
}

