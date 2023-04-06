package Utils;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class TestBase {
    protected WebDriver driver;

    @BeforeSuite
    public void clearTheCookies(){
        driver = UpgradedDriverHelper.getDriver();
        driver.manage().deleteAllCookies();
    }

    @BeforeMethod
    public void setup() {
        driver = UpgradedDriverHelper.getDriver();
        driver.navigate().to(ConfigReader.readProperty(""));
    }

    @AfterMethod
    public void tearDown(ITestResult iTestResult) throws InterruptedException {
//        if (!iTestResult.isSuccess()){
//            Thread.sleep(3000);
//            BrowserUtils.getScreenShot(driver,"blazepicture");
//        }
        driver.quit();
    }
}

