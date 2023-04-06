package MentoringWithAhmet.Bank.tests;

import MentoringWithAhmet.Bank.pages.AccountPage;
import MentoringWithAhmet.Bank.pages.CustomerPage;
import MentoringWithAhmet.Bank.pages.LoginPage;
import org.testng.annotations.Test;

public class Testing extends BankTestBase{

    @Test
    public void validateCustomerLoginFunctionality() throws InterruptedException{

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickCustomerLogin();

        CustomerPage customerPage = new CustomerPage(driver);
        customerPage.selectHarryPotter("Harry Potter");

        AccountPage accountPage = new AccountPage(driver);
        accountPage.validateHarryPotter("Welcome Harry Potter !!");
        accountPage.deposit("1000");
        accountPage.validateDeposit("Deposit Successful");


    }
}

