package com.automation.tests.mypractice.homework5;

import com.automation.pages.LoginPage;
import com.automation.pages.activities.CalendarEventsPage;
import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class VyTrackHomework {



  @Test
    public void test1(){

      LoginPage loginPage = new LoginPage();
      loginPage.login();
      CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
      calendarEventsPage.navigateTo("Activities", "Calendar Events Page");




//     actions.moveToElement(driver.findElement(By.xpath("//span[@class='title title-level-1' and contains(text(),'Activities')]")))
//             .pause(1000).perform();
//
//    actions.moveToElement(driver.findElement(By.cssSelector("a[title='Create Calendar event']"))).pause(1000).click();
//    actions.moveToElement(driver.findElement(By.xpath("//table//tr[5]//td[9]"))).pause(1000).perform();
//      Assert.assertTrue(driver.findElement(By.xpath("//table//tr[5]//td[9]//a[@title='View']")).isDisplayed());
//      Assert.assertTrue(driver.findElement(By.xpath("//table//tr[5]//td[9]//a[@title='Edit']")).isDisplayed());
//      Assert.assertTrue(driver.findElement(By.xpath("//table//tr[5]//td[9]//a[@title='Delete']")).isDisplayed());

  }



}
