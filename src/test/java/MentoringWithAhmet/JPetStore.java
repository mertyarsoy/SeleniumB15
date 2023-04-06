package MentoringWithAhmet;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JPetStore {

    @Test
    public void validateCostMathFunctionality() throws InterruptedException{
        /*
1-Navigate to the website "https://petstore.octoperf.com/actions/Catalog.action"
2-Choose one category and put the product_id and name as a map format(Only one of the category) then print out
3-Go to the main menu and choose 2 different category and choose one item from there
4-Add them into the card
5-Validate the total cost equals to the price at the bottom shows.
6-Quit

 */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.navigate().to("https://petstore.octoperf.com/actions/Catalog.action");
        Actions action = new Actions(driver);

        WebElement reptiles = driver.findElement(By.xpath("//img[@src='../images/reptiles_icon.gif']"));
        reptiles.click();

        List<WebElement> productID = driver.findElements(By.xpath("//a[contains(text(),'RP-SN-01')]"));
        List<WebElement> name = driver.findElements(By.xpath("//td[contains(text(),'Rattlesnake')]"));

        for (int i = 0; i < productID.size(); i++) {
            Map<String,String> map = new HashMap<>();
            map.put(BrowserUtils.getTextandTrim(productID.get(i)),BrowserUtils.getTextandTrim(name.get(i)));
            System.out.println(map);
        }

        WebElement mainMenu = driver.findElement(By.xpath("//a[contains(text(),'Return to Main Menu')]"));
        mainMenu.click();

        WebElement birds = driver.findElement(By.xpath("//img[@src='../images/birds_icon.gif']"));
        birds.click();
        WebElement amazonPatrot = driver.findElement(By.xpath("//a[@href='/actions/Catalog.action?viewProduct=&productId=AV-CB-01']"));
        amazonPatrot.click();
        WebElement addToCart = driver.findElement(By.xpath("//a[@href='/actions/Cart.action?addItemToCart=&workingItemId=EST-18']"));
        addToCart.click();

        Thread.sleep(1000);
        driver.navigate().back();
        driver.navigate().back();

        WebElement finch = driver.findElement(By.xpath("//a[@href='/actions/Catalog.action?viewProduct=&productId=AV-SB-02']"));
        finch.click();
        WebElement addTocart = driver.findElement(By.xpath("//a[@href='/actions/Cart.action?addItemToCart=&workingItemId=EST-19']"));
        addTocart.click();

        Thread.sleep(200);
        Assert.assertEquals(BrowserUtils.getTextandTrim(driver.findElement(By.xpath("//td[contains(text(),'Sub Total: $209.00 ')]"))),"Sub Total: $209.00");


        driver.quit();
    }
}
