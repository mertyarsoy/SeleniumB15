package MentoringWithAhmet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Techlist {
    /*
    1-Open this link - https://www.techlistic.com/p/selenium-practice-form.html
2-Enter first and last name (textbox).
3-Select gender (radio button).
4-Select years of experience (radio button).
5-Enter date.(send keys)
6-Select Profession (Checkbox).
7-Select Automation tools you are familiar with (multiple checkboxes).
8-Select Continent(Send Keys).
9-Click on Submit button.
Try your own logic and automate it without any help.
     */
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\merty\\IdeaProjects\\SeleniumB15\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");

        WebElement firstName = driver.findElement(By.xpath("//input[@name ='firstname']"));
        firstName.sendKeys("Mert");



    }
}