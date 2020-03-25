package com.automation.tests.mypractice.homework;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.Driver;
import java.util.List;

public class homework2 {

    private String URL = "https://practice-cybertekschool.herokuapp.com/";
    private WebDriver driver;
    private By registrationFormBy = By.xpath("//a[@href='/registration_form']");
    private By dateOfBirthBy = By.xpath("//input[@name='birthday']");
    private By warningMessageBy = By.xpath("//small[@data-bv-validator='date']");
    private By JavaBy = By.xpath("//label[@for='inlineCheckbox2']");
    private By CplusplusBy = By.xpath("//label[@for='inlineCheckbox1']");
    private By JavaScriptBy = By.xpath("//label[@for='inlineCheckbox3']");
    private By firstNameBy = By.xpath("//input[@name='firstname']");
    private By lastNameBy = By.xpath("//input[@name='lastname']");
    private By userNameBy = By.xpath("//input[@name='username']");
    private By passwordBy = By.xpath("//input[@name='password']");
    private By phoneBy = By.xpath("//input[@name='phone']");
    private By femaleBy = By.xpath("//input[@value='female']");
    private By dobBy = By.xpath("//input[@name='birthday']");
    private By departmentBy = By.xpath("//select[@name='department']");
    private By departmentOfEngineeringBy = By.xpath("//option[@value='DE']");
    private By jobTitleBy = By.xpath("//select[@name='job_title']");
    private By SDETBy = By.xpath("/html/body/div/div[2]/div/div/div/div/form/div[10]/div/select/option[5]");
    private By signUpBy = By.xpath("//button[@id='wooden_spoon']");
    private By emailBy = By.xpath("//input[@name='email']");

    @BeforeMethod
    public void setup(){

        driver = DriverFactory.createDriver("chrome");
        driver.get(URL);
        driver.manage().window().maximize();
        BrowserUtils.wait(3);
        driver.findElement(registrationFormBy).click();
        BrowserUtils.wait(2);
    }


    @Test
    public void test1(){

        driver.findElement(dateOfBirthBy).sendKeys("wrong_dob");
        BrowserUtils.wait(2);
        String actualWarningMessage = driver.findElement(warningMessageBy).getText();
        String expectedWarningMessage = "The date of birth is not valid";

        Assert.assertEquals(actualWarningMessage, expectedWarningMessage);
    }

    @Test
    public void test2(){

       String CplusplusActual = driver.findElement(CplusplusBy).getText();
       String CplusplusExpected = "C++";
       Assert.assertEquals(CplusplusActual, CplusplusExpected);
       BrowserUtils.wait(3);

       String JavaActual = driver.findElement(JavaBy).getText();
       String JavaExpected = "Java";
       Assert.assertEquals(JavaActual, JavaExpected);
       BrowserUtils.wait(3);

       String JavaScriptActual = driver.findElement(JavaScriptBy).getText();
       String JavaScriptExpected = "JavaScript";
       Assert.assertEquals(JavaScriptActual, JavaScriptExpected);
       BrowserUtils.wait(3);

    }

    @Test
    public void test3(){
        driver.findElement(firstNameBy).sendKeys("a");
        String actualWarningMessage = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div/div/form/div/div/small[2]")).getText();
        String expectedWarningMessage = "first name must be more than 2 and less than 64 characters long";
        Assert.assertEquals(actualWarningMessage, expectedWarningMessage);
    }

    @Test
    public void test4(){
        driver.findElement(lastNameBy).sendKeys("a");
        String actualWarningMessage = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div/div/form/div[2]/div/small[2]")).getText();
        String expectedWarningMessage = "The last name must be more than 2 and less than 64 characters long";
        Assert.assertEquals(actualWarningMessage, expectedWarningMessage);
    }

    @Test
    public void test5(){
        driver.findElement(firstNameBy).sendKeys("Tanya");
        driver.findElement(lastNameBy).sendKeys("Diaz");
        driver.findElement(userNameBy).sendKeys("tanyadiaz");
        driver.findElement(emailBy).sendKeys("t.potetenina@gmail.com");
        driver.findElement(passwordBy).sendKeys("Tanyushka22@");
        driver.findElement(phoneBy).sendKeys("571-000-0030");

        List<WebElement> genders = driver.findElements(By.name("gender"));
        //select gender
        genders.get(0).click();

        BrowserUtils.wait(3);

        driver.findElement(femaleBy).click();
        driver.findElement(dobBy).sendKeys("06/22/1986");
        driver.findElement(departmentBy).click();
        driver.findElement(departmentOfEngineeringBy).click();
        driver.findElement(jobTitleBy).click();
        BrowserUtils.wait(3);
        driver.findElement(SDETBy).click();
        BrowserUtils.wait(3);

        driver.findElement(By.xpath("//label[@for='inlineCheckbox2']")).click();//select Java
        BrowserUtils.wait(3);
        driver.findElement(signUpBy).click();
        BrowserUtils.wait(3);
        String expected = "You've successfully completed registration!";
        String actual = driver.findElement(By.xpath("//p")).getText();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test6(){

    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
