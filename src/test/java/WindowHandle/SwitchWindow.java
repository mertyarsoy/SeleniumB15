package WindowHandle;

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
import java.util.Set;

public class SwitchWindow {

    @Test
    public void switchPractice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.navigate().to("https://the-internet.herokuapp.com/windows");

        WebElement clickHere = driver.findElement(By.linkText("Click Here"));
        clickHere.click();

        WebElement header = driver.findElement(By.tagName("h3"));
        System.out.println(BrowserUtils.getTextandTrim(header));

        String mainPageID = driver.getWindowHandle(); // pageID of the class
        System.out.println(mainPageID); // CDwindow-F7302B1D7AA519D8DEA0C45BDA3AC1EB
        Set<String> allPagesID = driver.getWindowHandles();
        System.out.println(allPagesID); // [CDwindow-F7302B1D7AA519D8DEA0C45BDA3AC1EB, CDwindow-1CF2E42F69383734D0CBE5F91457FE34]

        // This is used for only 2 tabs/windows
        for (String id:allPagesID) {
            if (!id.equals(mainPageID)){
                driver.switchTo().window(id);
                break;
            }
        }

        WebElement header2 = driver.findElement(By.tagName("h3"));
        System.out.println(BrowserUtils.getTextandTrim(header2));

        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void switchToWindows() throws InterruptedException{
        /*
        TASK:
        1-Navigate to the website "https://www.hyrtutorials.com/p/window-handles-practice.html"
        2-Click Open New Tab under Button2
        3-Get the title of the newTab and validate"
        4-Get the header of the newTab and validate "AlertsDemo"
        5-Click click me button
        6-Quit the tabs
 */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.navigate().to("https://www.hyrtutorials.com/p/window-handles-practice.html");
        Actions action = new Actions(driver);
        Thread.sleep(1000);

        WebElement newTab = driver.findElement(By.cssSelector("#newTabBtn"));
        action.click(newTab).perform();
        System.out.println(BrowserUtils.getTitleWithJS(driver));

        String mainPageID = driver.getWindowHandle();
        Set<String> allPagesID = driver.getWindowHandles();
        for (String id :allPagesID) {
            if (!id.equals(mainPageID)){
                driver.switchTo().window(id);
                break;
            }
        }

        Assert.assertEquals(driver.getTitle(),"AlertsDemo - H Y R Tutorials");
        System.out.println(driver.getTitle());

        WebElement alertsDemo = driver.findElement(By.xpath("//h1[contains(text(),'AlertsDemo')]"));
        Assert.assertEquals(BrowserUtils.getTextandTrim(alertsDemo),"AlertsDemo");
        System.out.println(BrowserUtils.getTextandTrim(alertsDemo));

        WebElement alertBox = driver.findElement(By.xpath("//button[@id='alertBox']"));
        action.click(alertBox).perform();

        Thread.sleep(2000);
        driver.quit();

    }
}
