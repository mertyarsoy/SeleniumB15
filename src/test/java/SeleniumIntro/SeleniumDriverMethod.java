package SeleniumIntro;

import Utils.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumDriverMethod {

    /*
    driver.get();
    driver.manage.window.maximize();
    driver.getTitle();
    driver.getCurrentUrl();
    driver.getPageSource();
    driver.navigateTo();
    driver.navigate.refresh();
    driver.navigate.forward();
    driver.navigate.back();
    drive.close();
     */

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("https://www.google.com/");
        System.out.println(driver.getTitle());

        driver.get("https://www.youtube.com/");
        System.out.println(driver.getCurrentUrl());

       // Thread.sleep(3000);
        driver.navigate().back();// google
        //Thread.sleep(3000);
        driver.navigate().forward();// youtube
       // Thread.sleep(3000);
        driver.navigate().refresh();// refresh the page
        //Thread.sleep(3000);

        System.out.println(driver.getPageSource()); // it pulls up the latest page source html

        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Process.aspx");
        WebElement element = driver.findElement(By.xpath("//select[@name ='ctl00$MainContent$fmwOrder$ddlProduct']"));
        BrowserUtils.selectBy(element,"MyMoney","text");

        Thread.sleep(3000);
        driver.quit();

    }


}
