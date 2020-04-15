package com.automation.tests.mypractice.homework4;

import com.automation.utilities.Driver;
import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class homework4_part1 {

    private WebDriver driver;

    @BeforeMethod
    public void setup(){

        driver = DriverFactory.createDriver("chrome");
        driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testDays(){
   List<WebElement> list1 = driver.findElements(By.cssSelector("span"));
   Random r =new Random();
   int count = 0;
   while(count<3){
       //this method will return any value between 0 and 6
       int index = r.nextInt(list1.size());

       if(list1.get(index).isEnabled()){
           list1.get(index).click();
           if(list1.get(index).getText().equals("Friday")){
               ++count;
           }
           System.out.println(list1.get(index).getText());
           list1.get(index).click();
       }
   }
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
