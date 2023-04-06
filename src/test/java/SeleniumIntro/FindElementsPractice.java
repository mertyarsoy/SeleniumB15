package SeleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class FindElementsPractice {
    /*

     */
    public static void main(String[] args) throws InterruptedException{
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

        driver.navigate().to("https://the-internet.herokuapp.com/");

        List<WebElement> allLinks = driver.findElements(By.xpath("//li"));

        AtomicInteger i = new AtomicInteger();
        allLinks.forEach(link ->{
            try {
                Thread.sleep(100);
            }catch (InterruptedException e){

            }
            i.getAndIncrement();
            System.out.println(i+". "+link.getText().trim());
        });

        System.out.println("===================");

        AtomicInteger j = new AtomicInteger();
        allLinks.forEach(individual->{
            try {
                Thread.sleep(100);
            }catch (InterruptedException e){
            }
            if (individual.getText().length() >= 12){
                j.getAndIncrement();
                System.out.println(j+". "+individual.getText().trim());
            };
        });

        System.out.println("All Links: "+i);
        System.out.println("Links has length more than 12: "+j);
        System.out.println("==========================");






        Thread.sleep(2000);
        driver.quit();





    }
}
