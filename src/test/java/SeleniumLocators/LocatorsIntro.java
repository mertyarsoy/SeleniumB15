package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsIntro {
    public static void main(String[] args) throws InterruptedException {

        //1)ID Locator:

        System.setProperty("webdriver.chrome.driver","chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("file:///C:/Users/merty/OneDrive/Desktop/TECHTORIAL%20ACADEMY/ALL%20TOPICS%20SDET/SELENIUM%20folder/Techtorialhtml.html");
        WebElement header = driver.findElement(By.id("techtorial1"));
        String actualHeader = header.getText().trim(); // Techtorial Academy
        String expectedHeader = "Techtorial Academy";

        System.out.println(actualHeader);
        System.out.println(actualHeader.equals(expectedHeader) ? "Passed" : "Failed");

        Thread.sleep(3000);

        WebElement paragraph = driver.findElement(By.id("details2"));
        String actualParagraph = paragraph.getText().trim();
        String expectedParagraph = "To create your account, we'll need some basic information about you. This information will be" +
                " used to send reservation confirmation emails, mail tickets when needed and " +
                "contact you if your travel arrangements change. Please fill in the form completely.".trim();

        System.out.println(actualParagraph);
        System.out.println(actualParagraph.equals(expectedParagraph) ? "Passed" : "Failed");

        //2)NAME Locator:

        WebElement firstName = driver.findElement(By.name("firstName"));
        firstName.sendKeys("Mert");
        Thread.sleep(1000);

        WebElement lastName = driver.findElement(By.name("lastName"));
        lastName.sendKeys("Yarsoy");
        Thread.sleep(1000);

        WebElement phoneNum = driver.findElement(By.name("phone"));
        phoneNum.sendKeys("(786) 238 0866");
        Thread.sleep(1000);

        WebElement email = driver.findElement(By.id("userName"));
        email.sendKeys("mertyarsoy@gmail.com");
        Thread.sleep(1000);

        WebElement address = driver.findElement(By.name("address1"));
        address.sendKeys("201 Se 2nd Ave");
        Thread.sleep(1000);

        WebElement address2 = driver.findElement(By.name("address2"));
        address2.sendKeys("Monarc at Met 3 2220");
        Thread.sleep(1000);

        WebElement city = driver.findElement(By.name("city"));
        city.sendKeys("Miami");
        Thread.sleep(1000);

        WebElement state = driver.findElement(By.name("state"));
        state.sendKeys("FL");
        Thread.sleep(1000);

        WebElement zipCode = driver.findElement(By.name("postalCode"));
        zipCode.sendKeys("33131");
        Thread.sleep(1000);

        //3)CLASS Locator:

        WebElement checkboxesLabel = driver.findElement(By.className("checkboxes"));
        String actualCheckBox = checkboxesLabel.getText();
        System.out.println(actualCheckBox);
        Thread.sleep(1000);

        WebElement javaBox = driver.findElement(By.id("cond1"));
        if (javaBox.isDisplayed()&&!javaBox.isSelected()) {
            javaBox.click();
        }

        WebElement seleniumBox = driver.findElement(By.id("cond2"));
        if (seleniumBox.isDisplayed()&&!seleniumBox.isSelected()){
            seleniumBox.click();
        }

        WebElement testNGBox = driver.findElement(By.id("cond3"));
        if (testNGBox.isDisplayed()&&!testNGBox.isSelected()){
            testNGBox.click();
        }

        WebElement cucumberBox = driver.findElement(By.id("cond4"));
        if (cucumberBox.isDisplayed()&&!cucumberBox.isSelected()){
            cucumberBox.click();
        }

        System.out.println(driver.getTitle());

        //4)TAG NAME Locator:

        WebElement version = driver.findElement(By.tagName("u"));

        String actualVersion = version.getText().trim();
        String expectedVersion = "Use Java Version".trim();

        String result = actualVersion.equals(expectedVersion) ? "Validation is passed" : "Validation is failed";

        System.out.println(result);
        System.out.println(actualVersion);

        Thread.sleep(1000);
        driver.quit();

    }
}
