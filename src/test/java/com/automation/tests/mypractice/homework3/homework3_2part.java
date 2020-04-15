package com.automation.tests.mypractice.homework3;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class homework3_2part {

    private String URL1 = "http://tempmailaddress.com";
    private String URL2 = "http://practice.cybertekschool.com";
    private WebDriver driver;
    private By copyBy = By.xpath("//a[@class='color cetc hidden-desktop']");


    @BeforeMethod
    public void setup(){
        driver = DriverFactory.createDriver("chrome");
        driver.get(URL1);
        driver.manage().window().maximize();
        BrowserUtils.wait(3);
    }

    @Test
    public void test6(){

        String emailAddress = driver.findElement(By.xpath("//span[@id='email']")).getText();
        BrowserUtils.wait(2);
        driver.navigate().to(URL2);
        driver.findElement(By.xpath("//a[@href='/sign_up']")).click();
        driver.findElement(By.xpath("//input[@name='full_name']")).sendKeys("Tanya");
        BrowserUtils.wait(3);
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(emailAddress);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        BrowserUtils.wait(2);
        String actual = driver.findElement(By.xpath("//h3[@name='signup_message']")).getText();
        String expected = "Thank you for signing up. Click the button below to return to the home page.";

        Assert.assertEquals(actual, expected);

        BrowserUtils.wait(2);

        driver.navigate().to(URL1);
        String actual2 = driver.findElement(By.xpath("//td[@class='from']")).getText().trim();
        String expected2 = "do-not-reply@practice.cybertekschool.com";
        Assert.assertEquals(actual2, expected2);
        BrowserUtils.wait(2);
        driver.findElement(By.xpath("//td[@class='from']")).click();

        String actual3 = driver.findElement(By.xpath("//span[@id='predmet']")).getText();
        String expected3 = "Thanks for subscribing to practice.cybertekschool.com!";

        Assert.assertEquals(actual3, expected3);

    }

    @AfterMethod
    public void teardown(){

    }
}
