package MentoringWithAhmet;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

/*
/*
1-Navigate to the website "https://www.facebook.com/"
2-Click Create Account Button
3-Fill all the boxes
4-Choose Custom Gender
5-Choose any pronoun you want from
6-Click Sign up button
7-In general facebook has a protection to automate create account  so once you
click sign up button if there is a message then validate it. If no, just close or quit

   PURPOSE:
       1-This task can come during the interview
       2-How to deal with dynamic elements
 */
public class Facebook{

    @Test
    public void creatingFacebookAccount() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.navigate().to("https://www.facebook.com/");

        WebElement createAccountButton = driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));
        createAccountButton.click();

        String[] fields = new String[]{"firstname","lastname","reg_email__","reg_passwd__"};
        String[] inputs = new String[]{"Mert","Yarsoy","mertyarsoy@gmail.com","123asd"};

        for (int i = 0; i < fields.length; i++) {
            WebElement elements = driver.findElement(By.name(fields[i]));
            elements.sendKeys(inputs[i]);
        }

        WebElement reEnter = driver.findElement(By.name("reg_email_confirmation__"));
        reEnter.sendKeys("mertyarsoy@gmail.com");

        WebElement month = driver.findElement(By.cssSelector("#month"));
        month.sendKeys("September");
        Thread.sleep(100);

        WebElement day = driver.findElement(By.cssSelector("#day"));
        day.sendKeys("1");
        Thread.sleep(100);

        WebElement year = driver.findElement(By.cssSelector("#year"));
        year.sendKeys("1999");
        Thread.sleep(100);

        WebElement gender = driver.findElement(By.xpath("//input[@value='2']"));
        if (gender.isEnabled() && gender.isDisplayed() && !gender.isSelected()){
            gender.click();
        }

        WebElement signupButton = driver.findElement(By.xpath("//button[@name='websubmit']"));
        signupButton.click();

        /*
        WebElement message = driver.findElement(By.id("reg_error_inner"));
        String expected = "Please choose a more secure password. It should be longer than 6 characters, unique to you, and difficult for others to guess.";
        Assert.assertEquals(message.getText().trim(),expected);

         */
        Thread.sleep(6000);
        driver.quit();


    }
}
