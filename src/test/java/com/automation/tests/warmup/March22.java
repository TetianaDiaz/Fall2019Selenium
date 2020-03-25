package com.automation.tests.warmup;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class March22 {

    /**
     * THis method is coming form Comparable interface
     * If you want to be able to sort collection of some class
     * you need to implement this interface
     * and override compareTo method
     */

    @Test
    public void test(){
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.findElement(By.xpath("//table[1]//*[text()='Last Name']"));
        BrowserUtils.wait(2);
        List<WebElement> column = driver.findElements(By.xpath("//table[1]//tbody//td[1]"));//to get all the last names

        for (int i = 0; i <column.size()-1 ; i++) {
            //take a string
            String value = column.get(i).getText();
            //take a following string
            String nextValue = column.get(i+1).getText();
            System.out.println(value.compareTo(nextValue));

            //if difference is negative - order value is before nextValue in alphabetic order
            //if difference is positive - order value is after nextValue in alphabetic order
            //if difference is 0 - value and nextValue are equals
            Assert.assertTrue(nextValue.compareTo(nextValue)<0);

        }
    }
}
