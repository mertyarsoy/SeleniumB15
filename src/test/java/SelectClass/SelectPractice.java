package SelectClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.bouncycastle.est.LimitedSource;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.channels.SelectionKey;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SelectPractice {
    @Test
    public void validateFirstAndAllOptions() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

        driver.navigate().to("file:///C:/Users/merty/OneDrive/Desktop/TECHTORIAL%20ACADEMY/ALL%20TOPICS%20SDET/SELENIUM%20folder/Techtorialhtml.html");

        WebElement country = driver.findElement(By.xpath("//select[@name='country']"));
        Select options = new Select(country);
        System.out.println(options.getFirstSelectedOption().getText().trim());
        String expected = "UNITED STATES";

        Assert.assertEquals(options.getFirstSelectedOption().getText().trim(), expected);

        List<WebElement> allCountries = options.getOptions();
        int counter = 0;
        for (int i = 0; i < allCountries.size(); i++) {
            System.out.println(i + 1 + ". " + allCountries.get(i).getText().trim());
            counter++;
        }
        System.out.println("There are " + counter + " countries in the Drop Down");

        options.selectByValue("207");
        Thread.sleep(500);
        options.selectByVisibleText("PARACEL ISLANDS ");
        Thread.sleep(500);
        options.selectByIndex(50);

        //Thread.sleep(2500);
        driver.quit();
    }

    @Test
    public void multiSelect() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

        driver.navigate().to("file:///C:/Users/merty/OneDrive/Desktop/TECHTORIAL%20ACADEMY/ALL%20TOPICS%20SDET/SELENIUM%20folder/Techtorialhtml.html");

        WebElement countrySelect = driver.findElement(By.cssSelector(".select"));
        Select country = new Select(countrySelect);
        country.selectByVisibleText("One");
        Thread.sleep(1000);
        country.selectByValue("3");
        Thread.sleep(1000);
        country.selectByIndex(4);
        Thread.sleep(1000);
        country.deselectByVisibleText("One");
        Thread.sleep(1000);
        country.deselectAll();


        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void validateOrderMessage() throws InterruptedException {
        /*
1-Navigate to the website
2-Select one way trip button
3-Choose 4 passengers(1 wife-1 husband-2 kids)
4-Validate the depart from is default "Acapulco"
5-Choose the depart from is Paris
6-Choose the date August 15th
7-Choose the arrive in is San Francisco
8-Choose the date December 15th
10-Click first class option.
11-Validate All the options from Airline
12-Choose the Unified option from airline list
13-Click Continue
14-Validate the message at the top.There is a bug here/
 "After flight finder - No Seats Avaialble"

 NOTE:Your test should fail and say available is not matching with Available.
 NOTE2:You can use any select method value,visibleText
 */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

        driver.navigate().to("https://demo.guru99.com/test/newtours/reservation.php");

        WebElement type = driver.findElement(By.xpath("//input[@name='tripType']"));
        if (type.isDisplayed() && type.isEnabled() && !type.isSelected()) {
            type.click();
        }

        WebElement passengers = driver.findElement(By.xpath("//select[@name='passCount']"));
        Select firstOption = new Select(passengers);
        firstOption.selectByValue("4");

        WebElement departure = driver.findElement(By.xpath("//select[@name='fromPort']"));
        Select secondOption = new Select(departure);
        secondOption.selectByVisibleText("Acapulco");

        WebElement fromMonth = driver.findElement(By.xpath("//select[@name='fromMonth']"));
        Select thirdOption = new Select(fromMonth);
        thirdOption.selectByVisibleText("August");

        WebElement fromDay = driver.findElement(By.xpath("//select[@name='fromDay']"));
        Select fourthOption = new Select(fromDay);
        fourthOption.selectByValue("15");

        WebElement arrival = driver.findElement(By.xpath("//select[@name='toPort']"));
        Select fifthOption = new Select(arrival);
        fifthOption.selectByVisibleText("Paris");

        WebElement toMonth = driver.findElement(By.xpath("//select[@name='toMonth']"));
        Select sixthOption = new Select(toMonth);
        sixthOption.selectByValue("12");

        WebElement toDay = driver.findElement(By.xpath("//select[@name='toDay']"));
        Select seventhOption = new Select(toDay);
        seventhOption.selectByVisibleText("15");

        WebElement classType = driver.findElement(By.xpath("//input[@value='First']"));
        if (!classType.isSelected() && classType.isDisplayed() && classType.isEnabled()) {
            classType.click();
        }

        WebElement airline = driver.findElement(By.xpath("//select[@name='airline']"));
        Select options = new Select(airline);
        List<WebElement> airlineOptions = options.getOptions();
        List<String> validation = Arrays.asList("No Preference", "Blue Skies Airlines", "Unified Airlines", "Pangea Airlines");

        /*
        int i = 0;
        for (WebElement individual:airlineOptions) {
            System.out.println(i+1+". "+individual.getText().trim());
            i++;
        }
         */

        for (int j = 0; j < airlineOptions.size(); j++) {
            System.out.println(j + 1 + ". " + airlineOptions.get(j).getText().trim());
            Assert.assertEquals(airlineOptions.get(j).getText().trim(), validation.get(j));
        }


        options.selectByVisibleText("Unified Airlines");

        WebElement signup = driver.findElement(By.xpath("//input[@name='findFlights']"));
        signup.click();

        WebElement textOriginal = driver.findElement(By.xpath("//font[@size='4']"));
        String expectedText = "After flight finder - No Seats Avaialble";
        Assert.assertEquals(textOriginal.getText().trim(), expectedText);
        System.out.println(textOriginal.getText().trim());

        System.out.println(driver.getPageSource());

        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void shortCutSelectClass() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

        driver.navigate().to("https://demo.guru99.com/test/newtours/reservation.php");

        WebElement type = driver.findElement(By.xpath("//input[@name='tripType']"));
        if (type.isDisplayed() && type.isEnabled() && !type.isSelected()) {
            type.click();
        }

        WebElement passengers = driver.findElement(By.xpath("//select[@name='passCount']"));
        BrowserUtils.selectBy(passengers, "4", "value");

        WebElement departure = driver.findElement(By.xpath("//select[@name='fromPort']"));
        BrowserUtils.selectBy(departure, "Acapulco", "text");

        WebElement fromMonth = driver.findElement(By.xpath("//select[@name='fromMonth']"));
        BrowserUtils.selectBy(fromMonth, "August", "text");

        WebElement fromDay = driver.findElement(By.xpath("//select[@name='fromDay']"));
        BrowserUtils.selectBy(fromDay, "14", "index");

        WebElement arrival = driver.findElement(By.xpath("//select[@name='toPort']"));
        BrowserUtils.selectBy(arrival, "Paris", "text");

        WebElement toMonth = driver.findElement(By.xpath("//select[@name='toMonth']"));
        BrowserUtils.selectBy(toMonth, "12", "value");

        WebElement toDay = driver.findElement(By.xpath("//select[@name='toDay']"));
        BrowserUtils.selectBy(toDay, "15", "text");

        WebElement classType = driver.findElement(By.xpath("//input[@value='First']"));
        if (!classType.isSelected() && classType.isDisplayed() && classType.isEnabled()) {
            classType.click();
        }

        WebElement airline = driver.findElement(By.xpath("//select[@name='airline']"));
        Select options = new Select(airline);
        List<WebElement> airlineOptions = options.getOptions();
        List<String> validation = Arrays.asList("No Preference", "Blue Skies Airlines", "Unified Airlines", "Pangea Airlines");

        /*
        int i = 0;
        for (WebElement individual:airlineOptions) {
            System.out.println(i+1+". "+individual.getText().trim());
            i++;
        }
         */

        for (int k = 0; k < airlineOptions.size(); k++) {
            System.out.println(k + 1 + ". " + airlineOptions.get(k).getText().trim());
            Assert.assertEquals(airlineOptions.get(k).getText().trim(), validation.get(k));
        }

        options.selectByVisibleText("Unified Airlines");

        WebElement signup = driver.findElement(By.xpath("//input[@name='findFlights']"));
        signup.click();

        WebElement textOriginal = driver.findElement(By.xpath("//font[@size='4']"));
        String expectedText = "After flight finder - No Seats Avaialble";
        Assert.assertEquals(textOriginal.getText().trim(), expectedText);
        System.out.println(textOriginal.getText().trim());

        System.out.println(driver.getPageSource());

        Thread.sleep(2000);
        driver.quit();
    }
}
