package com.automation.tests.mypractice.homework5;

import com.automation.pages.LoginPage;
import com.automation.tests.vytrack.AbstractTestBase;
import com.automation.utilities.BrowserUtils;
import com.automation.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


public class VyTrackHomework extends AbstractTestBase {

  private WebDriver driver;
  private WebDriverWait wait;
  private Actions actions;




  public void navigateToCalendarEvents(){
    WebElement loaderMask= null;
    driver = Driver.getDriver();
    wait= new WebDriverWait(driver, 20);
    if(driver.findElements(By.cssSelector("div[class='loader-mask shown']")).size()>0) {
      loaderMask = driver.findElement(By.cssSelector("div[class='loader-mask shown']"));
      wait.until(ExpectedConditions.invisibilityOf(loaderMask));
    }

    WebElement activitiesElement = driver.findElement(By.linkText("Activities"));
    wait.until(ExpectedConditions.visibilityOf(activitiesElement));
    wait.until(ExpectedConditions.elementToBeClickable(activitiesElement));
    activitiesElement.click();

    WebElement calendarEventsElement = driver.findElement(By.linkText("Calendar Events"));
    wait.until(ExpectedConditions.visibilityOf(calendarEventsElement));
    wait.until(ExpectedConditions.elementToBeClickable(calendarEventsElement));
    calendarEventsElement.click();

    wait.until(ExpectedConditions.invisibilityOf(loaderMask));
  }


  @Test
    public void test1(){

      LoginPage loginPage = new LoginPage();
      loginPage.login();
      navigateToCalendarEvents();
      BrowserUtils.wait(10);
      BrowserUtils.waitForPageToLoad(20);
      actions = new Actions(driver);
      actions.moveToElement(driver.findElement(By.xpath("//table/tbody/tr[1]/td[9]/div/div/a"))).
            pause(1000).perform();

//      JavascriptExecutor js = (JavascriptExecutor) driver;
//      WebElement link = driver.findElement(By.xpath("//table/tbody/tr[1]/td[9]/div/div/ul/li/ul/li[1]/a"));
//
//      js.executeScript("arguments[0].click()", link);


      Assert.assertTrue(driver.findElement(By.xpath("(//i[@class='fa-eye hide-text'])[1]")).isDisplayed());
      Assert.assertTrue(driver.findElement(By.xpath("(//i[@class='fa-trash-o hide-text'])[1]")).isDisplayed());
      Assert.assertTrue(driver.findElement(By.xpath("(//i[@class='fa-pencil-square-o hide-text'])[1]")).isDisplayed());

      //<a href="/calendar/event/view/1846" class="action
    //         no-hash
    //
    //        mode-icon-only
    //
    //    " title="View">
    //
    //
    //        <i class="fa-eye hide-text"></i>
    //
    //
    //
    //</a>




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
