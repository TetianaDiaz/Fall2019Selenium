package com.automation.tests.day8;

import org.testng.Assert;
import org.testng.annotations.Test;

public class UnitTestPractice {

    /**
     * This method stands for reversing strigns
     * @param str to reverse
     * @return reversed string
     */
    public static String reverseString(String str){
        String reversed = "";

        for (int i = str.length()-1; i >=0 ; i--) {

            reversed+=str.charAt(i);
        }
        return reversed;
    }


    public static void main(String[] args) {
        //unit testing
        //to check if our method works properly
        //if assertion fails that means our method doesn't work correctly
        //that means we have to fix the method
       String expected = "cba";
       String toReverse = "abc";
       String actual = reverseString(toReverse);

       //Assertion
       verifyEquals(expected, actual);
    }

    //annotation
    //description is not working for Gunit, only for testng
    @Test(description = "Verify if method can reverse a string")
    public void test(){
        String expected = "elpp";
        String actual = reverseString("apple");
        //it coming from testng. unit also has this class
        //you can compare any data types here: strings, primitives, arrays. objects
        //to verify if expected result equals to actual
        Assert.assertEquals(actual, expected);
    }

    @Test(description="Verify if method can reverse a string")
    public void test2(){
        String expected = "rac";
        String actual = reverseString("car");
        Assert.assertEquals(actual, expected);
    }

    /**
     *
     * @param expected
     * @param actual
     * @return
     */
    public static boolean verifyEquals(String expected, String actual){

        if(expected.equals(actual)){
            System.out.println("Test Passed");
            return true;
        }else{
            System.out.println("Test Failed");
            System.out.println("Expected: " + expected);
            System.out.println("Actual: " + actual);
            return false;
        }
    }
}
