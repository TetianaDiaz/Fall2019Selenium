package com.automation.tests.mypractice.homework4;

import com.automation.utilities.Driver;
import com.automation.utilities.DriverFactory;
import com.google.common.collect.Ordering;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class homework4_part3 {

    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = DriverFactory.createDriver("chrome");
        driver.get("http://www.amazon.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    /**
     * verify that default value of the All departments dropdown is All
     * verify that options in the All departments dropdown are not sorted alphabetically
     */
    @Test
    public void DepartmentSort() {

        Assert.assertEquals(driver.findElement(By.xpath("//span[@class='nav-search-label']")).getText(), "All");
        List<WebElement> list1 = driver.findElements(By.xpath("//select[@aria-describedby='searchDropdownDescription']/*"));

        List<String> listString = new ArrayList<>();
        for (int i = 0; i < list1.size(); i++) {

            listString.add(list1.get(i).getText());
        }

        System.out.println(listString);

        listString.sort(Comparator.naturalOrder());
        System.out.println(listString);

        boolean sorted = Ordering.natural().isOrdered(listString);

        System.out.println(sorted);

        List<WebElement> l1 = new Select(driver.findElement(By.id("searchDropdownBox"))).getOptions();
        boolean notAlphabetOrder = false;

        for (int i = 0; i < l1.size() - 1; i++) {
            if (l1.get(i).getText().compareTo(l1.get(i + 1).getText()) > 0) {

                notAlphabetOrder = true;
                break;
            }
        }
    }




    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
