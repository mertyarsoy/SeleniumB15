package HomeWork.HW_4.tests;

import HomeWork.HW_4.pages.HomePage;
import HomeWork.HW_4.pages.OpenMRSLoginPage;
import HomeWork.HW_4.pages.PatientPage;
import HomeWork.HW_4.pages.SelectPage;
import Utils.ConfigReader;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Locale;

public class Testing extends UITestBase {

    @Parameters({"firstSelected", "country", "country2", "country3", "country4"})
    @Test(priority = 1)
    public void task(String firstSelected, String country, String country2, String country3, String country4) throws InterruptedException {
        driver.navigate().to(ConfigReader.readProperty("UITestingUrl"));

        SelectPage selectPage = new SelectPage(driver);

        selectPage.validateSelection(firstSelected);
        selectPage.validateSize(4);
        selectPage.validateDropDown(country, country2, country3, country4);
        selectPage.selectChina();
        selectPage.selectEngland();
        selectPage.selectUnitedStates();
    }

    @Parameters({"country", "country2", "country3", "country4"})
    @Test(priority = 2)
    public void task2(String country, String country2, String country3, String country4) throws InterruptedException {
        driver.navigate().to(ConfigReader.readProperty("UITestingUrl"));

        SelectPage selectPage = new SelectPage(driver);

        selectPage.validateMultipleSelect(country, country2, country3, country4);
        selectPage.selectChinaAndEngland(driver);
        selectPage.validateHeader();
        selectPage.deSelectAll();
        selectPage.selectAllAndValidate(driver);
        selectPage.deSelectChinaAndEngland();
    }

    @Parameters("validation")
    @Test(priority = 3)
    public void task3(String validation) throws InterruptedException {
        driver.navigate().to(ConfigReader.readProperty("codeFishUrl"));

        OpenMRSLoginPage openMRSLoginPage = new OpenMRSLoginPage(driver);
        openMRSLoginPage.Login(ConfigReader.readProperty("username"), ConfigReader.readProperty("password"));

        HomePage homePage = new HomePage(driver);
        homePage.clickRegisterPatient();

        PatientPage patientPage = new PatientPage(driver);
        patientPage.registration(driver,ConfigReader.readProperty("firstName"),ConfigReader.readProperty("lastName"),
                ConfigReader.readProperty("day"),ConfigReader.readProperty("month"),ConfigReader.readProperty("year"),
                ConfigReader.readProperty("address"),ConfigReader.readProperty("address2"),ConfigReader.readProperty("city"),
                ConfigReader.readProperty("state"),ConfigReader.readProperty("country"),ConfigReader.readProperty("postalCode"),ConfigReader.readProperty("phoneNumber"));

        patientPage.validateTable(validation);


    }



}
