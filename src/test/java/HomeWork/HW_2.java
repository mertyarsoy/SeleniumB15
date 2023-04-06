package HomeWork;

import Utils.BrowserUtils;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class HW_2 {

    @Test
    public void task() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");

        String expectedTitle = "Web Orders Login";
        Assert.assertEquals(driver.getTitle().trim(), expectedTitle);
        System.out.println(driver.getTitle());

        WebElement username = driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
        username.sendKeys("Tester".trim());
        WebElement password = driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        password.sendKeys("test".trim());

        WebElement login = driver.findElement(By.cssSelector("#ctl00_MainContent_login_button"));
        login.click();

        String expectedTitle2 = "Web Orders";
        Assert.assertEquals(driver.getTitle().trim(), expectedTitle2);
        System.out.println(driver.getTitle());

        WebElement header = driver.findElement(By.tagName("h2"));
        String expectedHeader = "List of All Orders";
        Assert.assertEquals(BrowserUtils.getTextandTrim(header), expectedHeader);
        System.out.println(BrowserUtils.getTextandTrim(header));

        Thread.sleep(2000);
        driver.quit();

    }

    @Test
    public void task2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");

        String expectedTitle = "Web Orders Login";
        Assert.assertEquals(driver.getTitle().trim(), expectedTitle);
        System.out.println(driver.getTitle());

        WebElement username = driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
        username.sendKeys("Tester".trim());
        WebElement password = driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        password.sendKeys("test".trim());

        WebElement login = driver.findElement(By.cssSelector("#ctl00_MainContent_login_button"));
        login.click();

        WebElement viewProductButton = driver.findElement(By.xpath("//a[.='View all products']"));
        Assert.assertTrue(viewProductButton.isDisplayed());
        Assert.assertTrue(viewProductButton.isEnabled());
        viewProductButton.click();

        WebElement viewAllProducts = driver.findElement(By.xpath("//li[@class='selected']"));
        Assert.assertEquals(viewAllProducts.getAttribute("class").trim(), "selected");

        WebElement header = driver.findElement(By.xpath("//h2[contains(text(),'List of Product')]"));
        String expectedHeader = "List of Products";
        Assert.assertEquals(BrowserUtils.getTextandTrim(header), expectedHeader);

        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("Products"));


        Thread.sleep(2000);
       driver.quit();

    }

    @Test
    public void task3() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");

        String expectedTitle = "Web Orders Login";
        Assert.assertEquals(driver.getTitle().trim(), expectedTitle);
        System.out.println(driver.getTitle());

        WebElement username = driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
        username.sendKeys("Tester".trim());
        WebElement password = driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        password.sendKeys("test".trim());

        WebElement login = driver.findElement(By.cssSelector("#ctl00_MainContent_login_button"));
        login.click();

        List<WebElement> list = driver.findElements(By.xpath("//ul[@class='menu']"));
        List<String> extension = Arrays.asList("Default.aspx", "Products.aspx", "Process.aspx");

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < extension.size(); j++) {
                if (list.get(i).getText().contains(extension.get(j))) {
                    Assert.assertTrue(list.get(i).getText().contains(extension.get(j)));
                }
            }
        }
        /*
        for (WebElement a:list) {
            for (String b :extension) {
                if (a.getText().contains(b)){
                    Assert.assertTrue(a.getText().contains(b));
                    break;
                }
            }
        }
 */
        Thread.sleep(2000);
       driver.quit();

    }

    @Test
    public void task4() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");

        String expectedTitle = "Web Orders Login";
        Assert.assertEquals(driver.getTitle().trim(), expectedTitle);
        System.out.println(driver.getTitle());

        WebElement username = driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
        username.sendKeys("Tester".trim());
        WebElement password = driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        password.sendKeys("test".trim());

        WebElement login = driver.findElement(By.cssSelector("#ctl00_MainContent_login_button"));
        login.click();

        Thread.sleep(2000);

        WebElement orderButton = driver.findElement(By.xpath("//a[contains(text(),'Order')]"));
        orderButton.click();

        WebElement selectProduct = driver.findElement(By.xpath("//select[@id='ctl00_MainContent_fmwOrder_ddlProduct']"));
        BrowserUtils.selectBy(selectProduct, "ScreenSaver", "text");

        WebElement quantity = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtQuantity']"));
        quantity.clear();
        Thread.sleep(500);
        quantity.sendKeys("5");

        String[] fields = new String[]{"//input[@id='ctl00_MainContent_fmwOrder_txtName']", "//input[@id='ctl00_MainContent_fmwOrder_TextBox2']",
                "//input[@id='ctl00_MainContent_fmwOrder_TextBox3']", "//input[@id='ctl00_MainContent_fmwOrder_TextBox4']", "//input[@id='ctl00_MainContent_fmwOrder_TextBox5']"};
        String[] inputs = new String[]{"CodeFish IT School", "2200 E Devon", "Des Plaines", "Illinois", "60018"};

        for (int i = 0; i < fields.length; i++) {
            WebElement elements = driver.findElement(By.xpath(fields[i]));
            elements.sendKeys(inputs[i]);
        }

        WebElement cardButton = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_cardList_1']"));
        if (cardButton.isEnabled() && cardButton.isDisplayed() && !cardButton.isSelected()) {
            cardButton.click();
        }

        List<String> fieldsList = Arrays.asList("//input[@id='ctl00_MainContent_fmwOrder_TextBox6']", "//input[@id='ctl00_MainContent_fmwOrder_TextBox1']");
        List<String> inputsList = Arrays.asList("444993876233", "03/24");

        for (int i = 0; i < fieldsList.size(); i++) {
            WebElement element2 = driver.findElement(By.xpath(fieldsList.get(i)));
            element2.sendKeys(inputsList.get(i));
        }

        WebElement processButton = driver.findElement(By.xpath("//a[@id='ctl00_MainContent_fmwOrder_InsertButton']"));
        processButton.click();

        Thread.sleep(5000);
       driver.quit();
    }

    @Test
    public void task5() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");

        String expectedTitle = "Web Orders Login";
        Assert.assertEquals(driver.getTitle().trim(), expectedTitle);
        System.out.println(driver.getTitle());

        WebElement username = driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
        username.sendKeys("Tester".trim());
        WebElement password = driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        password.sendKeys("test".trim());

        WebElement login = driver.findElement(By.cssSelector("#ctl00_MainContent_login_button"));
        login.click();

        Thread.sleep(2000);

        WebElement orderButton = driver.findElement(By.xpath("//a[contains(text(),'Order')]"));
        orderButton.click();

        WebElement selectProduct = driver.findElement(By.xpath("//select[@id='ctl00_MainContent_fmwOrder_ddlProduct']"));
        BrowserUtils.selectBy(selectProduct, "ScreenSaver", "text");

        WebElement quantity = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtQuantity']"));
        quantity.clear();
        Thread.sleep(500);
        quantity.sendKeys("5");

        String[] fields = new String[]{"//input[@id='ctl00_MainContent_fmwOrder_txtName']", "//input[@id='ctl00_MainContent_fmwOrder_TextBox2']",
                "//input[@id='ctl00_MainContent_fmwOrder_TextBox3']", "//input[@id='ctl00_MainContent_fmwOrder_TextBox4']", "//input[@id='ctl00_MainContent_fmwOrder_TextBox5']"};
        String[] inputs = new String[]{"CodeFish IT School", "2200 E Devon", "Des Plaines", "Illinois", "60018"};

        for (int i = 0; i < fields.length; i++) {
            WebElement elements = driver.findElement(By.xpath(fields[i]));
            elements.sendKeys(inputs[i]);
        }

        WebElement cardButton = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_cardList_1']"));
        if (cardButton.isEnabled() && cardButton.isDisplayed() && !cardButton.isSelected()) {
            cardButton.click();
        }

        List<String> fieldsList = Arrays.asList("//input[@id='ctl00_MainContent_fmwOrder_TextBox6']", "//input[@id='ctl00_MainContent_fmwOrder_TextBox1']");
        List<String> inputsList = Arrays.asList("444993876233", "03/24");

        for (int i = 0; i < fieldsList.size(); i++) {
            WebElement element2 = driver.findElement(By.xpath(fieldsList.get(i)));
            element2.sendKeys(inputsList.get(i));
        }

        WebElement processButton = driver.findElement(By.xpath("//a[@id='ctl00_MainContent_fmwOrder_InsertButton']"));
        processButton.click();

        WebElement text = driver.findElement(By.tagName("strong"));
        String expectedText = "New order has been successfully added.";
        Assert.assertEquals(BrowserUtils.getTextandTrim(text), expectedText);
        System.out.println(BrowserUtils.getTextandTrim(text));

        WebElement viewAllOrder = driver.findElement(By.xpath("//a[contains(text(),'View all orders')]"));
        viewAllOrder.click();

        driver.navigate().refresh();

        String expectedOrder = "CodeFish IT School";
        Assert.assertEquals(BrowserUtils.getTextandTrim(driver.findElement(By.xpath("//td[contains(text(),'CodeFish IT School')]"))), expectedOrder);
        System.out.println("Order received from ==> " + BrowserUtils.getTextandTrim(driver.findElement(By.xpath("//td[contains(text(),'CodeFish IT School')]"))));

        Thread.sleep(5000);
        driver.quit();
    }

}
