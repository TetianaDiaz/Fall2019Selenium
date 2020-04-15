package com.automation.tests.mypractice.homework4;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class homework4_part4 {

    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = DriverFactory.createDriver("chrome");
        driver.get("http://www.amazon.com/gp/site-directory");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    /**
     * verify that every main department name (indicated by blue rectangle) is present in the All
     * department dropdown (indicated by green rectangle in the picture)
     */

    @Test
    public void mainDep(){
        List<WebElement> list1 = driver.findElements(By.xpath("//h2"));
        List <WebElement> allDepList = driver.findElements(By.xpath("//option"));
        //another way to get allDepList
        //List <WebElement> allDepList = new Select(driver.findElement(By.id("searchDropdownBox"))).getOptions();
        boolean isPresent = true;
        int count = 0;
        for (int i = 0; i <list1.size() ; i++) {
            for (int j = 0; j <allDepList.size() ; j++) {
                if(list1.get(i).getText().trim().equals(allDepList.get(j).getText().trim())){
                    ++count;
                    }
                }
            }
            if(count!=list1.size()){
                isPresent = false;
            }
        Assert.assertTrue(isPresent);

        }

        @Test
        public void mainDepByMykyta(){
            List<WebElement> mainDep = driver.findElements(By.xpath("//h2"));
            List <WebElement> allDep = driver.findElements(By.xpath("//option"));
            
            Set<String> mainDeps = new HashSet<>();
            Set<String> allDeps = new HashSet<>();

            for (WebElement each: mainDep) {
                mainDeps.add(each.getText());
            }
            for (WebElement each:allDep) {
                allDeps.add(each.getText());
            }
            for (String each: mainDeps) {
                if(!allDeps.contains(each)){
                    System.out.println(each);
                    System.out.println("This main dep is not is All department list");
                }
                Assert.assertTrue(allDep.containsAll(mainDeps));
            }
        }


    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
