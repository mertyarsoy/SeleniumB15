package SeleniumIntro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RealExamplePractice {

    //  Test Case - Open Godaddy.com and validate it's Page title and the url.
//    Steps to Automate:
//            1. Launch browser of your choice say., Firefox, chrome etc.
//            2. Open this URL - https://www.godaddy.com/
//            3. Maximize or set size of browser window.
//4. Get Title of page and validate it.(if conditions) expected title from website
//4. Get URL of current page and validate it.          expected url from website
//            5. Close browser.(driver.close)

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.godaddy.com/");

        String actualTitle = driver.getTitle().trim();
        String expectedTitle = "Domain Names, Websites, Hosting & Online Marketing Tools - GoDaddy".trim();

        String actualURL = driver.getCurrentUrl().trim();
        String expectedURL = "https://www.godaddy.com/".trim();

        System.out.println(driver.getTitle());
        System.out.println(actualTitle.equals(expectedTitle) ? "PASSED" : "FAILED");
        System.out.println(actualURL.equals(expectedURL) ? "PASSED" : "FAILED");

        driver.quit();
    }
}
