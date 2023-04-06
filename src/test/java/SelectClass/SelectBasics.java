package SelectClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class SelectBasics {
    @Test
    public void practiceSelect() throws InterruptedException{
        //Select class is all about "DROP DOWN"
        //Drop Box must have select TAG NAME

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

        driver.navigate().to("https://the-internet.herokuapp.com/");

        WebElement dropDown = driver.findElement(By.linkText("Dropdown"));
        dropDown.click();
        Thread.sleep(300);

        //Location of the box
        WebElement optionBox = driver.findElement(By.xpath("//select[@id='dropdown']"));

        Select options = new Select(optionBox); // provide the location of the element inside Select Object
        System.out.println(options.getFirstSelectedOption().getText().trim()); // gets default selected option

        options.selectByValue("1"); // value
        Thread.sleep(1500);
        options.selectByVisibleText("Option 2"); // visible text
        Thread.sleep(1500);
        options.selectByIndex(1); // by index

        List <WebElement> allTheOptions = options.getOptions();
        List <String> expectedOption = Arrays.asList("Please select an option","Option 1","Option 2");

        for (int i = 0; i < allTheOptions.size(); i++) {
            Assert.assertEquals(allTheOptions.get(i).getText().trim(),expectedOption.get(i));
            System.out.println(allTheOptions.get(i).getText().trim());
        }

        Thread.sleep(5000);
        driver.quit();
    }
}
