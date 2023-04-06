package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsIntro2 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

            driver.navigate().to("file:///C:/Users/merty/OneDrive/Desktop/TECHTORIAL%20ACADEMY/ALL%20TOPICS%20SDET/SELENIUM%20folder/Techtorialhtml.html");
        System.out.println(driver.getTitle());

        //5)LINKTEXT Locator:

        WebElement javaLink = driver.findElement(By.linkText("Java"));
        javaLink.click();
        WebElement javaHeader = driver.findElement(By.tagName("h1"));
        String actualJavaHeader = javaHeader.getText().trim().equals("Java".trim()) ? "Passed" : "Failed";
        System.out.println(actualJavaHeader);

        driver.navigate().back();

        WebElement seleniumLink = driver.findElement(By.linkText("Selenium"));
        seleniumLink.click();
        WebElement seleniumHeader = driver.findElement(By.tagName("h1"));
        String actualSeleniumHeader = seleniumHeader.getText().trim().equals("Selenium automates browsers. That's it!".trim()) ? "Passed" : "Failed";
        System.out.println(actualSeleniumHeader);

        driver.navigate().back();

        WebElement cucumberLink = driver.findElement(By.linkText("Cucumber"));
        cucumberLink.click();
        WebElement cucumberHeader = driver.findElement(By.tagName("h1"));
        String actualcucumberHeader = cucumberHeader.getText().trim().equals("Tools & techniques that elevate teams to greatness".trim()) ? "Passed" : "Failed";
        System.out.println(actualcucumberHeader);

        driver.navigate().back();

        WebElement testNGLink = driver.findElement(By.linkText("TestNG"));
        testNGLink.click();
        WebElement testNGHeader = driver.findElement(By.tagName("h2"));
        String actualtestNGHeader = testNGHeader.getText().trim().equals("TestNG".trim()) ? "Passed" : "Failed";
        System.out.println(actualtestNGHeader);

        driver.navigate().back();

        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="file:///C:/Users/merty/OneDrive/Desktop/TECHTORIAL%20ACADEMY/ALL%20TOPICS%20SDET/SELENIUM%20folder/Techtorialhtml.html";
        System.out.println(actualUrl.equals(expectedUrl) ? "Passed" : "Failed");

        System.out.println(driver.getPageSource());

        //6)PARTIAL LINKTEXT Locator:

        WebElement restAPI = driver.findElement(By.partialLinkText("Rest"));
        restAPI.click();
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://rest-assured.io/";
        String result = actualURL.equals(expectedURL) ? "Passed" : "Failed";
        System.out.println(result);
        driver.navigate().back();

        Thread.sleep(3000);
        driver.quit();


























    }
}

