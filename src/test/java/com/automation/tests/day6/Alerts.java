package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Alerts {

    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/javascript_alert");
        BrowserUtils.wait(3);
        List<WebElement> buttons = driver.findElements(By.tagName("button"));
        buttons.get(0).click();//to click on the first button
        BrowserUtils.wait(3);
        String popupText = driver.switchTo().alert().getText();//to get the text from popup message
        driver.switchTo().alert();//to click OK
        String expected = "You successfully clicked an alert";
        String actual = driver.findElement(By.id("result")).getText();

        //if it will fail, because is a typo
        if(expected.equals(actual)){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed");
            System.out.println("Expected: " + expected);
            System.out.println("Actual: " + actual);
        }
        BrowserUtils.wait(3);

        buttons.get(1).click();//to click on the 2nd button
        BrowserUtils.wait(3);
        //to click cancel
        driver.switchTo().alert().dismiss();//result must be : You clicked: Cancel
        String expected2 = "You clicked: OK";
        String actual2 = driver.findElement(By.id("result")).getText();

        if(expected2.equals(actual2)){
            System.out.println("test passed");
        }else{
            System.out.println("test failed");
            System.out.println("Expected: " + expected2);
            System.out.println("Actual: " + actual2);
        }
        //####################################
        //Task for 5 minutes until 3:37 click button 3
        //Enetr some text: Hello, world!
        //Verify that result text ends with Hello, World!
        BrowserUtils.wait(3);
        buttons.get(2).click();//to click on the 3rd button
        BrowserUtils.wait(3);

        //to click cancel
        Alert alert = driver.switchTo().alert();//result must be : You clicked: Cancel
        alert.sendKeys("Hello, world!");

        String actual3 = driver.findElement(By.id("result")).getText();
        String expected3 = "Hello, world!";

        if(actual3.equals(expected3)){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed");
            System.out.println("Expected: " + expected3);
            System.out.println("Actual: " + actual3);

        }




        BrowserUtils.wait(3);
        driver.quit();
    }
}
