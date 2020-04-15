package com.automation.tests.mypractice;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.Driver;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckboxesPractice {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/checkboxes");
//        driver.findElement(By.cssSelector("input[type='checkbox']:nth-of-type(1)")).click();
//        BrowserUtils.wait(2);
//        driver.findElement(By.cssSelector("input[type='checkbox']:nth-of-type(1)")).click();
        BrowserUtils.wait(2);

        //fidn all elements with tag name input
        List<WebElement> checkboxes = driver.findElements(By.tagName("input"));
        //loop through this list of elements
        for (WebElement checkbox: checkboxes) {
            BrowserUtils.wait(2);
            if(!checkbox.isSelected()){
                checkbox.click();
            }
            
        }
        driver.quit();
    }
}
