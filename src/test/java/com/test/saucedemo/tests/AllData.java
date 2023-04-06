package com.test.saucedemo.tests;

import org.testng.annotations.DataProvider;

public class AllData {
    @DataProvider(name = "negativeLogin")
    public Object[][] getUserInfo() {
        return new Object[][]{
                {"standard_user", "", "Epic sadface: Password is required"},
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {"asdas", "asdasdas", "Epic sadface: Username and password do not match any user in this service"}
        };
    }

    @DataProvider(name = "TestingProductLinks")
    public Object[][] getLinks() {
        return new Object[][]{
                {"Sauce Labs Backpack", "Sly Pack", "$29.99"},
                {"Sauce Labs Bike Light", "riding your bike ", "$9.99"},
                {"Sauce Labs Bolt T-Shirt", "bolt T-shirt", "$15.99"},
                {"Sauce Labs Fleece Jacket", "fleece jacket", "$49.99"},
                {"Sauce Labs Onesie", "infant onesie", "$7.99"},
                {"Test.allTheThings() T-Shirt (Red)", "Labs t-shirt", "$15.99"}
        };
    }
}
