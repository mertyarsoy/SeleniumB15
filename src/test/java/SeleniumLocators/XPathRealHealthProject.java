package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class XPathRealHealthProject {
    /*
//THESE PARTS SHOULD BE DONE BY XPATH:
1-Navigate to the https://katalon-demo-cura.herokuapp.com/
2-Click Make an Appointment
3-Login the username and password provided and Login successfully
4-Choose the facility either HongKong or Seoul -->send keys
5-Click apply for hospital admission box if it is displayed and validate it is selected
6-Healthcare program 'Medicaid'
7-Visit date should be provided -->send keys
8-Put your command for this box -->send keys
9-Book your appointment
THESE PARTS SHOULD BE DONE BY CONTAINS or . XPATH METHOD
10-Validate the header is "Appointment confirmation" (if statement)
11-Print out the headers and values(only values) on your console.
12)Click go to homepage and print out url
13)Driver.quit or close.
     */
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.navigate().to("https://katalon-demo-cura.herokuapp.com/");

        WebElement makeAppointment = driver.findElement(By.xpath("//a[@id='btn-make-appointment']"));
        makeAppointment.click();

        // next page

        WebElement username = driver.findElement(By.xpath("//input[@id='txt-username']"));
        username.sendKeys("John Doe");
        Thread.sleep(3000);
        WebElement password = driver.findElement(By.xpath("//input[@id='txt-password']"));
        password.sendKeys("ThisIsNotAPassword");

        WebElement button = driver.findElement(By.xpath("//button[@id='btn-login']"));
        button.click();

        //next page

        WebElement facility = driver.findElement(By.xpath("//select[@id='combo_facility']"));
        if (facility.isSelected() && !facility.isSelected()) {
            facility.click();
        }
        WebElement hongKong = driver.findElement(By.xpath("//option[@value='Hongkong CURA Healthcare Center']"));
        hongKong.click();
        WebElement readmission = driver.findElement(By.xpath("//input[@id='chk_hospotal_readmission']"));
        if (readmission.isDisplayed() && !readmission.isSelected()) {
            readmission.click();
        }
        WebElement medicaid = driver.findElement(By.xpath("//input[@value='Medicaid']"));
        if (medicaid.isDisplayed() && !medicaid.isSelected()) {
            medicaid.click();
        }
        WebElement dateofBirth = driver.findElement(By.xpath("//input[@id='txt_visit_date']"));
        dateofBirth.sendKeys("01/09/1999");
        WebElement comment = driver.findElement(By.xpath("//textarea"));
        comment.sendKeys("As a HarvardX certified SDET, I specialize in developing and implementing quality assurance measures for software applications. " +
                "My experience at Techtorial Academy has been instrumental in improving and developing my skills in software development and quality assurance. " +
                "With a passion for optimizing software performance, I bring a detail-oriented and collaborative approach to every project. " +
                "With experience in software development, project management, and team leadership, I am a highly motivated and results-driven professional. " +
                "My certificate in computer science from HarvardX has helped me develop a strong foundation in various programming languages and platforms. " +
                "I am passionate about using technology to solve real-world problems and delivering " +
                "high-quality solutions that meet the needs of my clients and customers. As an excellent communicator and team player, I thrive in fast-paced and dynamic environments.");
        //System.out.println(comment.getAttribute("//textarea"));
        WebElement appointment = driver.findElement(By.xpath("//button[@id='btn-book-appointment']"));
        appointment.click();


        //HEADER
        WebElement header = driver.findElement(By.xpath("//h2[contains(text(),'Appointment Confirmation')]"));
        String actualHeader = header.getText().trim();
        String expectedHeader = "Appointment Confirmation";
        String result = actualHeader.equals(expectedHeader) ? "Passed" : "Failed";

        WebElement homePage = driver.findElement(By.xpath("//a[@class ='btn btn-default']"));
        homePage.click();

        //URL
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://katalon-demo-cura.herokuapp.com/";
        String result2 = actualUrl.equals(expectedUrl) ? "Passed" : "Failed";

        System.out.println(result);
        System.out.println(result2);
        System.out.println("Title = " + driver.getTitle());
        System.out.println("URL = " + actualUrl);
        System.out.println("Header = " + actualHeader);

        /*
        WebElement demoUser = driver.findElement(By.xpath("//input[@aria-describedby ='demo_username_label']"));
        System.out.println(demoUser.getAttribute("value"));
         */
        Thread.sleep(2000);
        driver.quit();

        //CTRL + ALT + L = Organizes and put the code into precise line
    }
}
