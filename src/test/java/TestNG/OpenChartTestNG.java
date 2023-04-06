package TestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class OpenChartTestNG {

    @Test
    public void successfulLogin() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

        driver.navigate().to("https://demo.opencart.com/admin/");

        WebElement userName = driver.findElement(By.xpath("//input[@id = 'input-username']"));
        userName.sendKeys("demo");
        WebElement password = driver.findElement(By.xpath("//input[@id = 'input-password']"));
        password.sendKeys("demo", Keys.ENTER);

        // WebElement loginButton = driver.findElement(By.xpath("//button[@class = 'btn btn-primary']"));
        //loginButton.click();

        Thread.sleep(1000);

        String actualTitle = driver.getTitle().trim();
        // System.out.println(actualTitle);
        String expectedTitle = "Dashboard";

        Assert.assertEquals(actualTitle, expectedTitle);

        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void negativeLogin() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

        driver.navigate().to("https://demo.opencart.com/admin/");

        WebElement userName = driver.findElement(By.xpath("//input[@id = 'input-username']"));
        userName.sendKeys("Mert");
        WebElement password = driver.findElement(By.xpath("//input[@id = 'input-password']"));
        password.sendKeys("Yarsoy", Keys.ENTER);

        WebElement alert = driver.findElement(By.xpath("//div[@id='alert']"));
        Thread.sleep(1000);
        Assert.assertEquals(alert.getText().trim(), "No match for Username and/or Password.");

        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void validateProducts() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

        driver.navigate().to("https://demo.opencart.com/admin/");

        WebElement userName = driver.findElement(By.xpath("//input[@id = 'input-username']"));
        userName.sendKeys("demo");
        WebElement password = driver.findElement(By.xpath("//input[@id = 'input-password']"));
        password.sendKeys("demo", Keys.ENTER);

        WebElement buttonX = driver.findElement(By.xpath("//button [@class ='btn-close']"));
        // Thread.sleep(2000);
        buttonX.click();

        WebElement catalogButton = driver.findElement(By.xpath("//a[contains(text(), 'Catalog')]"));
        catalogButton.click();

        WebElement productsButton = driver.findElement(By.xpath("//a[.='Products']"));

        Thread.sleep(3000);
        Assert.assertTrue(productsButton.isDisplayed());
        Assert.assertEquals(productsButton.getText().trim(), "Products");

        Thread.sleep(2000);
        driver.quit();

    }

    @Test
    public void Products() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

        driver.navigate().to("https://demo.opencart.com/admin/");

        WebElement userName = driver.findElement(By.xpath("//input[@id = 'input-username']"));
        userName.sendKeys("demo");
        WebElement password = driver.findElement(By.xpath("//input[@id = 'input-password']"));
        password.sendKeys("demo", Keys.ENTER);

        WebElement buttonX = driver.findElement(By.xpath("//button [@class ='btn-close']"));
        // Thread.sleep(2000);
        buttonX.click();

        WebElement catalogButton = driver.findElement(By.xpath("//a[contains(text(), 'Catalog')]"));
        catalogButton.click();

        WebElement productsButton = driver.findElement(By.xpath("//a[.='Products']"));
        productsButton.click();

        List <WebElement> allBoxes = driver.findElements(By.xpath("//input [@type ='checkbox']"));
        for (int i = 1; i < allBoxes.size(); i++) {
            Thread.sleep(200);
            Assert.assertTrue(allBoxes.get(i).isDisplayed() && !allBoxes.get(i).isSelected()
            && allBoxes.get(i).isEnabled());
            allBoxes.get(i).click();
            Assert.assertTrue(allBoxes.get(i).isSelected());
            allBoxes.get(i).sendKeys(Keys.ARROW_DOWN);

        }

        WebElement nextPage = driver.findElement(By.xpath("//a[@class='page-link']"));
        nextPage.click();
        Thread.sleep(2000);

        List <WebElement> allboxes2 = driver.findElements(By.xpath("//input [@type ='checkbox']"));
        for (int i = 1; i < allboxes2.size(); i++) {
            Thread.sleep(200);
            Assert.assertTrue(allboxes2.get(i).isDisplayed() && allboxes2.get(i).isEnabled()
            && !allboxes2.get(i).isSelected());
            allboxes2.get(i).click();
            allboxes2.get(i).sendKeys(Keys.ARROW_DOWN);

        }

        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void DescendingOrder() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

        driver.navigate().to("https://demo.opencart.com/admin/");

        WebElement userName = driver.findElement(By.xpath("//input[@id = 'input-username']"));
        userName.sendKeys("demo");
        WebElement password = driver.findElement(By.xpath("//input[@id = 'input-password']"));
        password.sendKeys("demo", Keys.ENTER);

        WebElement buttonX = driver.findElement(By.xpath("//button [@class ='btn-close']"));
        buttonX.click();
        Thread.sleep(1000);

        WebElement catalogButton = driver.findElement(By.xpath("//a[contains(text(), 'Catalog')]"));
        catalogButton.click();
        Thread.sleep(1000);

        WebElement productsButton = driver.findElement(By.xpath("//a[.='Products']"));
        productsButton.click();
        Thread.sleep(1000);

        WebElement productsNameButton = driver.findElement(By.cssSelector(".asc"));
        productsNameButton.click();
        Thread.sleep(1000);

        List <WebElement> products= driver.findElements(By.xpath("//td[@class='text-start']"));
        List <String> actualProducts = new ArrayList<>();
        List <String> expectedProducts = new ArrayList<>();

        for (int i = 1; i < products.size(); i++) {
            actualProducts.add(products.get(i).getText().toUpperCase().trim()); // mostly for comparison like asc,desc
            expectedProducts.add(products.get(i).getText().toUpperCase().trim());
        }

        Collections.sort(expectedProducts); // sorting for ascending
        Collections.reverse(expectedProducts); // making guarantee it is descending order

        System.out.println(actualProducts);
        System.out.println(expectedProducts);

        Assert.assertEquals(actualProducts,expectedProducts);

        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void validateProductNameFunctionality() throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

        driver.navigate().to("https://demo.opencart.com/admin/");

        WebElement userName = driver.findElement(By.xpath("//input[@id = 'input-username']"));
        userName.sendKeys("demo");
        WebElement password = driver.findElement(By.xpath("//input[@id = 'input-password']"));
        password.sendKeys("demo", Keys.ENTER);

        WebElement buttonX = driver.findElement(By.xpath("//button [@class ='btn-close']"));
        buttonX.click();
        Thread.sleep(1000);

        WebElement catalogButton = driver.findElement(By.xpath("//a[contains(text(), 'Catalog')]"));
        catalogButton.click();
        Thread.sleep(1000);

        WebElement productsButton = driver.findElement(By.xpath("//a[.='Products']"));
        productsButton.click();
        Thread.sleep(1000);

        List<WebElement> products=driver.findElements(By.xpath("//td[@class='text-start']"));
        List<String> actualProducts=new ArrayList<>();
        List<String> expectedProducts=new ArrayList<>();

        for(int i=1;i<products.size();i++){
            actualProducts.add(products.get(i).getText().toUpperCase().trim());
            expectedProducts.add(products.get(i).getText().toUpperCase().trim());
        }

        Collections.sort(expectedProducts);
        Assert.assertEquals(actualProducts,expectedProducts);

        Thread.sleep(2000);
        driver.quit();
    }

}