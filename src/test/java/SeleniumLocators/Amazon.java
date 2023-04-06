package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Amazon {
    public static void main(String[] args) throws InterruptedException{

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.navigate().to("https://www.amazon.com/");
        //System.out.println(driver.getPageSource());
        System.out.println("==========================");
        System.out.println(driver.getTitle());

        WebElement box = driver.findElement(By.id("twotabsearchtextbox"));
        box.sendKeys("Rolex Watch");

        Thread.sleep(1000);
        driver.quit();



    }
}
