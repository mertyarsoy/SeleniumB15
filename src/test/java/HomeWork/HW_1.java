package HomeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HW_1 {
    /*
    STEP 1:
  1-Navigate to "https://demoqa.com/text-box"
  2-Enter your full name,current and permanent address
  3-Click submit button
  4-Validate that all of your information is displayed and matching correctly.
  TIPS: Think about if conditions
  Example:
  *Name:David
  *Email:david@gmail.com
  *Current address: (random address)
  *Permanent address: (random address)
     */
    public static void main(String[] args) throws InterruptedException{
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.navigate().to("https://demoqa.com/text-box");

        List<String> fields = new ArrayList<>();
        fields.add("//input[@id='userName']");fields.add("//input[@id='userEmail']");
        fields.add("//textarea[@id ='currentAddress']");fields.add("//textarea[@id ='permanentAddress']");

        List<String> inputs = new ArrayList<>();
        inputs.add("Mert Yarsoy");inputs.add("mertyarsoy@gmail.com");
        inputs.add("201 Se 2nd Ave");inputs.add("Monarc at Met 3 2220 Miami,FL 33131");

        /*
        String allText = String.format("Name: %s\nEmail: %s\nCurrent Address: %s\nPermanent Address: %s",
                name, email, currentAddress, permanentAddress);
        System.out.println(allText);
         */

        for (int i = 0; i < fields.size(); i++) {
            driver.findElement(By.xpath(fields.get(i))).sendKeys(inputs.get(i));
            Thread.sleep(100);
        }

        WebElement submit = driver.findElement(By.xpath("//button[@id ='submit']"));
        if (submit.isDisplayed() && submit.isEnabled()){
            submit.click();
        }

        System.out.println("FIRST WEBSITE: ");

        List<WebElement> allList = driver.findElements(By.tagName("p"));
        allList.forEach(individiualList ->{
            String list = individiualList.getText().trim();
            /*
            String expectedList = "Name:Mert Yarsoy"+"Email:mertyarsoy@gmail.com"+
                    "Current Address :201 Se 2nd Ave"+"Permananet Address :Monarc at Met 3 2220 Miami,FL 33131";
            String result = list.equals(expectedList) ? "Passed" : "Failed";
            System.out.println(result);

             */
            System.out.println("Validate: "+list);
        });

        System.out.println("===============");

        /*
        STEP 2:
        1-Navigate to "https://demoqa.com/radio-button"
        2-Click yes radio button
        3-Validate text is: You have selected Yes
        4-Click Impressive radio button
        5-Validate text is: You have selected Impressive
        TIPS: Be careful about your XPath if you have any issue with getting the text
         */

        driver.navigate().to("https://demoqa.com/radio-button");

        WebElement yesButton = driver.findElement(By.xpath("//label[@class  ='custom-control-label']"));
        if (yesButton.isDisplayed() && yesButton.isDisplayed() && !yesButton.isSelected()){
            yesButton.click();
        }

        WebElement validate = driver.findElement(By.tagName("p"));
        String yesTag = validate.getText().trim();
        String expectedYesTag = "You have selected Yes";
        String result = yesTag.equals(expectedYesTag) ? "Passed" : "Failed";

        WebElement impressiveButton = driver.findElement(By.xpath("//label[@for  ='impressiveRadio']"));
        if (impressiveButton.isEnabled() && impressiveButton.isDisplayed() && !impressiveButton.isSelected()){
            impressiveButton.click();
        }

        WebElement validate2 = (driver.findElement(By.tagName("p")));
        String impressiveTag = validate2.getText().trim();
        String expectedImpressiveTag = "You have selected Impressive";
        String secondResult = impressiveTag.equals(expectedImpressiveTag) ? "Passed" : "Failed";

        System.out.println("SECOND WEBSITE:");
        System.out.println("Validate: "+yesTag);
        System.out.println(result);
        System.out.println("Validate: "+impressiveTag);
        System.out.println(secondResult);
        System.out.println("===============");

        /*
        STEP 3:
        1-Navigate to "https://www.saucedemo.com/"
        2-Enter username "Java"
        3-Enter password "Selenium
        4-Click login button
        5-Validate "Epic sad-face: Username and password do not match any user in this service" message
        TIPS: To be able to see this message you need to first see this message then try to inspect it.(It means
        at least run one time with the username and password you provided above to see the message then inspect
        the message.*be careful to see if it is fully copied or not*
         */

        driver.navigate().to("https://www.saucedemo.com/");

        String[] items = new String[] {"//input[@id ='user-name']","//input[@id ='password']"};
        String[] informations = new String[] {"Java","Selenium"};

        for (int i = 0; i < items.length; i++) {
            driver.findElement(By.xpath(items[i])).sendKeys(informations[i]);
        }

        WebElement loginButton = driver.findElement(By.xpath("//input[@id ='login-button']"));
        loginButton.click();

        WebElement validation = driver.findElement(By.tagName("h3"));
        String epicTag = validation.getText().trim();
        String expectedEpicTag = "Epic sadface: Username and password do not match any user in this service";
        String finaL = epicTag.equals(expectedEpicTag) ? "Passed" : "Failed";

        System.out.println("THIRD WEBSITE:");
        System.out.println("Validate: "+epicTag);
        System.out.println(finaL);
        System.out.println("===============");
        /*
        STEP 4:
        1-Navigate to "https://www.saucedemo.com/"
        2-Enter username "standard_user"
        3-Enter password "secret_sauce"
        4-Click login button
        5-Validate current url is "https://www.saucedemo.com/inventory.html"
         */

        driver.navigate().to("https://www.saucedemo.com/");

        String[] items2 = new String[] {"//input[@id ='user-name']","//input[@id ='password']"};
        String[] informations2 = new String[] {"standard_user","secret_sauce"};

        /*
        for (int i = 0; i < items.length; i++) {
            driver3.findElement(By.xpath(items2[i])).sendKeys(informations2[i]);
        }
         */

        int i = 0;
        for (String individual:items2) {
            driver.findElement(By.xpath((individual))).sendKeys(informations2[i]);
            i++;
        }

        WebElement sameLoginButton = driver.findElement(By.xpath("//input[@id ='login-button']"));
        sameLoginButton.click();
        String expectedURL = "https://www.saucedemo.com/inventory.html";
        String anotherResult = driver.getCurrentUrl().equals(expectedURL) ? "Passed" : "Failed";

        System.out.println("FOURTH WEBSITE:");
        System.out.println("Current Url = "+driver.getCurrentUrl());
        System.out.println(anotherResult);

        Thread.sleep(2000);
        driver.quit();
    }
}
