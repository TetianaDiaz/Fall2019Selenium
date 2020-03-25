package com.automation.tests.mypractice.homework;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class homework3rd_part {

    private WebDriver driver;
    private String URL = "http://practice.cybertekschool.com";

    @BeforeMethod
    public void setup(){
        driver = DriverFactory.createDriver("chrome");
        driver.get(URL);
        driver.manage().window().maximize();
    }

    @Test
    public void test7(){

        driver.findElement(By.xpath("//a[@href ='/upload']")).click();
        //driver.findElement(By.cssSelector("input[id ='file-upload']")).click();
        driver.findElement(By.cssSelector("input[id ='file-upload']")).sendKeys("C:/Users/tpote/Desktop/Cybertek/Automation Tools/notes 222");
        driver.findElement(By.cssSelector("input[class ='button']")).click();

        String actual = driver.findElement(By.xpath("//h3")).getText();
        String expected = "File Uploaded!";

        Assert.assertEquals(actual, expected);
    }
@Test
    public void test8(){
        driver.findElement(By.xpath("//a[@href='/autocomplete']")).click();
        driver.findElement(By.xpath("//input[@id='myCountry']")).sendKeys("United States of America");
        driver.findElement(By.xpath("//input[@type='button']")).click();

        String actual = driver.findElement(By.xpath("//p[@id='result']")).getText();
        String expected = "You selected: United States of America";

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void test9(){
        driver.findElement(By.xpath("//a[@href='/status_codes']")).click();
        driver.findElement(By.xpath("//a[@href='status_codes/200']")).click();

    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
