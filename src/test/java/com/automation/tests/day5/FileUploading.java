package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploading {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/upload");
        BrowserUtils.wait(5);
        WebElement upload = driver.findElement(By.id("file-upload"));
        //I am going to upload pom.xml file
        String filePath = System.getProperty("user.dir")+"/pom.xml";//for every computer, path is different
        //user.dir returns path to your project

        upload.sendKeys(filePath);
        BrowserUtils.wait(5);
        driver.findElement(By.id("file-submit")).click();//click to upload

        BrowserUtils.wait(5);

        driver.quit();
    }
}
