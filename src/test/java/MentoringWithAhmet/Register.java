package MentoringWithAhmet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Register {
    /*
    This is the URL = http://tutorialsninja.com/demo/index.php?route=account/register
     */
    public static void main(String[] args) throws InterruptedException{
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.navigate().to("http://tutorialsninja.com/demo/index.php?route=account/register");

        String[] fields = new String[] {"input-firstname","input-lastname","input-email",
        "input-telephone","input-password","input-confirm"};
        String[] inputs = new String[] {"Mert","Yarsoy","mertyarsoy@gmail.com",
        "7862380866","Jn8tHv4n","Jn8tHv4n"};

        for (int i = 0; i < fields.length; i++) {
            WebElement element = driver.findElement(By.id(fields[i]));
            element.sendKeys(inputs[i]);

            Thread.sleep(2000);
        }

        WebElement privacyButton = driver.findElement(By.xpath("//input[@name ='agree']"));
        if (privacyButton.isDisplayed() && !privacyButton.isSelected()){
            privacyButton.click();
        }

        WebElement submit = driver.findElement(By.xpath("//input[@value ='Continue']"));
        submit.click();

        Thread.sleep(5000);
        driver.quit();
    }
}
