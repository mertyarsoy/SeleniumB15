package TestNG;

import org.testng.annotations.*;

public class TestNGAnnotations {

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("I am a beforeSuite annotation");
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("I am a beforeTest annotation");
    }
    @BeforeClass
    public void beforeClass(){// It runs before every class, and it will be used to launch
        // their browser
        System.out.println("I am a beforeClass annotation");
    }

    @BeforeMethod
    public void beforeMethod(){ // It runs before every test annotation, and
        // it is good to use for setting up your Automation (TestBase class)
        System.out.println("I am a beforeMethod annotation");
    }

    @Test
    public void test(){
        System.out.println("I am a test annotation");
    }
    @Test
    public void test2(){ // It executes the codes
        System.out.println("I am a second test annotation");
    }
    @Test
    public void test3(){
        System.out.println("I am a third test annotation");
    }

    @AfterMethod
    public void afterMethod(){ /// It runs after every test annotations,
        // and it is good to use for screenshot and quit your driver
        System.out.println("I am an afterMethod annotation");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("I am an afterClass annotation");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("I am an afterClass annotation");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("I am an afterSuite annotation");
    }

}
