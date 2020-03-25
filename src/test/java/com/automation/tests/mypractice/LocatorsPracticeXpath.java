package com.automation.tests.mypractice;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

public class LocatorsPracticeXpath {

    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com");
        WebElement dropDownLink = driver.findElement(By.xpath("/html/body/div/div[2]/div/ul/li[11]/a"));
        System.out.println(dropDownLink.getText());
        dropDownLink.click();
        BrowserUtils.wait(5);
        driver.close();
    }

}
