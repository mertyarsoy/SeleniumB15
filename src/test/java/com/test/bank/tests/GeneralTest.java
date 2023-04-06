package com.test.bank.tests;

import Utils.ConfigReader;
import com.test.bank.pages.DepartmentPage;
import com.test.bank.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;

public class GeneralTest {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.navigate().to(ConfigReader.readProperty("bankUrl"));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test(priority = 1)
    public void loginTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickBankManagerLogin();
    }

    @Test(priority = 2)
    public void departmentTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickBankManagerLogin();

        DepartmentPage departmentPage = new DepartmentPage(driver);
        departmentPage.clickAddCustomerButton();
        departmentPage.setInformation(ConfigReader.readProperty("firstName"),
                ConfigReader.readProperty("lastName"),
                ConfigReader.readProperty("postalCode"));

        Alert alert = driver.switchTo().alert();
        alert.accept();

        departmentPage.clickopenAccountButton();
        departmentPage.setSelection();
        departmentPage.clickProcessButton();

        Thread.sleep(300);
        alert.accept();

        departmentPage.clickCustomerButton();

        departmentPage.searchYourName("Mert");
        departmentPage.validation("Mert", "Yarsoy", "33131", "1016");
        departmentPage.clickDeleteButton();

        Thread.sleep(2000);
    }
}
