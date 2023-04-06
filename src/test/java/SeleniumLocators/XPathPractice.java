package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class XPathPractice {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("http://tutorialsninja.com/demo/index.php?route=account/register");

        WebElement firstName = driver.findElement(By.xpath("//input[@id='input-firstname']"));
        firstName.sendKeys("Mert");

        WebElement lastName = driver.findElement(By.xpath("//input[@id='input-lastname']"));
        lastName.sendKeys("Yarsoy");

        WebElement email = driver.findElement(By.xpath("//input[@id='input-email']"));
        email.sendKeys("mertyarsoy@gmail.com");

        WebElement phone = driver.findElement(By.xpath("//input[@id='input-telephone']"));
        phone.sendKeys("7862380866");

        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("Jn8tHv4n");

        WebElement confirmationpassword = driver.findElement(By.xpath("//input[@id='input-confirm']"));
        confirmationpassword.sendKeys("Jn8tHv4n");

        WebElement privacyButton = driver.findElement(By.xpath("//input[@name = 'agree']"));
        if (privacyButton.isDisplayed() && !privacyButton.isSelected()){
            privacyButton.click();
        }

        WebElement signup = driver.findElement(By.xpath("//input[@value = 'Continue']"));
        signup.click();

        Thread.sleep(3000);
        driver.quit();




    }
}
