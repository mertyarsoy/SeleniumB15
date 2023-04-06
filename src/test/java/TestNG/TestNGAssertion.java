package TestNG;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGAssertion {

    public int multiplication(int num,int num2){
        return num*num2;
    }

    @Test
    public void validateMultiplication(){
        int actual = multiplication(3,4);
        int expected = 12;
        /*
        if (actualResult == expectedResult){
            System.out.println("PASSED");
        }
         */
        Assert.assertEquals(actual,expected);
    }
    @Test
    public void validateZero(){
        int actual = multiplication(0,99999);
        int expected = 0;
        Assert.assertEquals(actual,expected);
        Assert.assertTrue(actual == expected);
    }
    @Test
    public void validateNegativeWithPositive(){
        int actual = multiplication(-1,9);
        int expected = -9;
        Assert.assertFalse(actual != expected);
    }
    @Test
    public void validateNegativeWithNegative(){
        int actual = multiplication(-1,-7);
        int expected = 7;
        Assert.assertEquals(actual,expected);
    }
}
