package com.test.sentrifugo.tests;

import Utils.BrowserUtils;
import com.test.sentrifugo.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.index.qual.PolyUpperBound;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest {

    @Test
    public void validateSuccesfulLogin() throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.navigate().to("http://demo.sentrifugo.com/index.php/");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("EM01","sentrifugo");

        Assert.assertTrue(driver.getCurrentUrl().endsWith("welcome"));

        Thread.sleep(2000);
        driver.quit();
    }
    @Test
    public void validateNegativeLogin(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.navigate().to("http://demo.sentrifugo.com/index.php/");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("ahmet","sentrifugo");

        Assert.assertEquals(loginPage.validateErrorMessage(),"The username or password you entered is incorrect.");
        Assert.assertEquals(loginPage.validateColorOfErrorMessage(),"rgba(255, 0, 0, 1)");

        driver.quit();
    }
}
