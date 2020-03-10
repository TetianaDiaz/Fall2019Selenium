package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CheckBoxesTest {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/checkboxes");
        //#task
        //verify that 1st checkbox is not selected and 2nd is selected
        List<WebElement> checkBoxes = driver.findElements(By.tagName("input"));
        BrowserUtils.wait(2);

       boolean firstIsNotSelected = true;
        boolean secondIsSelected = true;

        if(!checkBoxes.get(0).isSelected() && checkBoxes.get(1).isSelected()){
            System.out.println("Test Passed!");
        }else{
            System.out.println("Test Failed!");
        }

        System.out.println( firstIsNotSelected = !checkBoxes.get(0).isSelected());
        System.out.println(secondIsSelected = checkBoxes.get(1).isSelected());

        BrowserUtils.wait(5);
        //lets' click on the first checkbox and verify it clicked
        checkBoxes.get(0).click();

        WebElement checkbox1 = checkBoxes.get(0);//to get 1st checkbox
        checkbox1.click();
        BrowserUtils.wait(2);
        if(checkbox1.isSelected()){
            System.out.println("Test Passed!");
            System.out.println("checkbox #1 is selected");
        }else{
            System.out.println("Test Failed");
            System.out.println("checkbox #1 is not selected!");
        }

        driver.quit();
    }
}
