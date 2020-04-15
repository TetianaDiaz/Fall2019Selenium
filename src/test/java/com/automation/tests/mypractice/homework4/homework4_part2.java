package com.automation.tests.mypractice.homework4;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class homework4_part2 {

    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
    }

    /**
     * 1.Verify that dropdowns under Select your date of birth display current year, month, day
     */
    @Test
    public void TodaysDateTest(){
       //Locate the WebElements for year, month and day
        WebElement year = driver.findElement(By.xpath("//select[@id='year']"));
        WebElement month = driver.findElement(By.xpath("//select[@id='month']"));
        WebElement day = driver.findElement(By.xpath("//select[@id='day']"));
        //use select class for each dropdown
        Select y = new Select(year);
        Select m = new Select(month);
        Select d = new Select(day);
        //use method getFirstSelectedOption that is coming from Select class to get the data that was selected
        String year_value = y.getFirstSelectedOption().getText();
        String month_value = m.getFirstSelectedOption().getText();
        String day_value = d.getFirstSelectedOption().getText();
        //use simple date format class to get current date
        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMMMdd");
        Assert.assertEquals(year_value+month_value+day_value, sf.format(new Date()));
    }

    /**
     * 1. Select a random year under Select your date of birth
     * select month January
     * verify that days dropdown has current number of days
     * repeat steps 3, 4 for all the months
     */
    @Test
    public void YearMonthsDaysTest(){
        //locating dropdown for year
        WebElement year = driver.findElement(By.id("year"));
        List <WebElement> listOfYears= driver.findElements(By.xpath("//select[@id='year']/*"));
        WebElement month = driver.findElement(By.id("month"));
        WebElement day = driver.findElement(By.id("day"));

        Select y = new Select(year);
        Select m = new Select(month);
        Select d = new Select(day);
        Random r = new Random();
        int index = r.nextInt(listOfYears.size());//or r.nextInt(y.getOptions().size());
        y.selectByIndex(index);

        List<String> month31 = new ArrayList<>(Arrays.asList(new String [] {"January", "March", "May", "July", "August", "October", "December"}));
        int febDays;
        int yearValue = Integer.parseInt(y.getFirstSelectedOption().getText());//converting to int from String
        if(yearValue% 400==0||(yearValue%4==0 && yearValue%100 != 0)){
            febDays = 29;
        }else{
            febDays = 28;
        }
        for (int i = 0; i <12 ; i++) {

            m.selectByIndex(i);
            if(month31.contains(m.getFirstSelectedOption().getText())){
                Assert.assertEquals(d.getOptions().size(), 31);
            }else if(m.getFirstSelectedOption().getText().equals("February")){
                Assert.assertEquals(d.getOptions().size(), febDays);
            }else{
                Assert.assertEquals(d.getOptions().size(), 30);
            }
        }
    }


    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
