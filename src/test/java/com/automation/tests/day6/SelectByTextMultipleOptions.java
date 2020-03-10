package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectByTextMultipleOptions {

    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(3);
        Select languageSelect = new Select(driver.findElement(By.name("Languages")));

        //Whether this select element support selecting multiple options at the same time?
        //this is done by checking the value of the multiple attribute
        languageSelect.isMultiple();
        boolean isMultiple = languageSelect.isMultiple();
        System.out.println(isMultiple); //--> if it's true, you can select more than one option
        languageSelect.selectByVisibleText("Java");
        languageSelect.selectByVisibleText("JavaScript");
        languageSelect.selectByVisibleText("Python");

        //let's get all selected option

        List<WebElement> selectedLanguages = languageSelect.getAllSelectedOptions();

        for (WebElement selectedLanguage: selectedLanguages) {
            System.out.println(selectedLanguage.getText());
        }
        BrowserUtils.wait(3);
        languageSelect.deselectByVisibleText("Java"); //to unselect something
        BrowserUtils.wait(3);

        languageSelect.deselectAll();


        BrowserUtils.wait(3);
        driver.quit();
    }
}
