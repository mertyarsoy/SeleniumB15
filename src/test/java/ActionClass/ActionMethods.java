package ActionClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class ActionMethods {

    @Test // ContextClick means right click
    public void ContextClick(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

        driver.navigate().to("https://the-internet.herokuapp.com/");

        WebElement contextMenu = driver.findElement(By.linkText("Context Menu"));
        contextMenu.click();

        WebElement box = driver.findElement(By.cssSelector("#hot-spot"));
        Actions action = new Actions(driver);
        action.contextClick(box).perform();

    }

    @Test
    public void ContextClickPractice(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

        driver.navigate().to("https://demo.guru99.com/test/simple_context_menu.html");

        WebElement rightClick = driver.findElement(By.xpath("//span[.='right click me']"));
        Actions action = new Actions(driver);
        action.contextClick(rightClick).perform();
    }

    @Test
    public void doubleClick(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

        driver.navigate().to("https://demo.guru99.com/test/simple_context_menu.html");

        WebElement doubleClick = driver.findElement(By.xpath("//button[contains(text(), 'Double-Click Me To See Alert')]"));
        Actions action = new Actions(driver);
        action.doubleClick(doubleClick).perform();

    }
}
