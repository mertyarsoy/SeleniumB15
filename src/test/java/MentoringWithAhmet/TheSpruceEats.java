package MentoringWithAhmet;

import Utils.BrowserUtils;
import com.sun.jdi.ThreadReference;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.BreakIterator;
import java.time.Duration;

public class TheSpruceEats {

    /*
1-Navigate to the website "https://www.thespruceeats.com/"
2-Under Ingredients option --> choose Fish&SeaFood option
3-ScrollDown to the search bar
4-Send the data: "Fish for dinner"
5-On the left side choose 4 star up option
6-From popular: Choose the Editor's choice option
7-Validate the name of product is "6-Ingredient Roasted Salmon Fillets"
8-Quit or close your driver
 */
    @Test
    public void task() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.navigate().to("https://www.thespruceeats.com/");
        Actions action = new Actions(driver);
        Thread.sleep(1000);

        WebElement ingredients = driver.findElement(By.xpath("//span[contains(text(),'Ingredients')]"));
        action.moveToElement(ingredients).perform();

        Thread.sleep(2000);
            WebElement fishAndSeafood = driver.findElement(By.xpath("//a[contains(text(),'Fish & Seafood')]"));
        action.click(fishAndSeafood).perform();

        Thread.sleep(4000);
        WebElement searchButton = driver.findElement(By.cssSelector("#search-form-input"));
        BrowserUtils.scrollWithJS(driver, searchButton);
        searchButton.sendKeys("Fish for dinner", Keys.ENTER);

        WebElement ratingButton = driver.findElement(By.xpath("//label[@for='starRating_score_4Star']"));
        if (ratingButton.isDisplayed() & ratingButton.isEnabled() & !ratingButton.isSelected()) {
            ratingButton.click();
        }

        WebElement editorsChoice = driver.findElement(By.xpath("//label[@for='pop_search_editor']"));
        if (editorsChoice.isDisplayed() & editorsChoice.isEnabled() & !editorsChoice.isSelected()) {
            editorsChoice.click();
        }

        Thread.sleep(2000);
        WebElement text = driver.findElement(By.xpath("//span[contains(text(),'6-Ingredient Roasted Salmon Fillets')]"));
        Assert.assertEquals(BrowserUtils.getTextandTrim(text), "6-Ingredient Roasted Salmon Fillets");

        System.out.println(BrowserUtils.getTextandTrim(text));

        Thread.sleep(2000);
        driver.quit();


    }
}
