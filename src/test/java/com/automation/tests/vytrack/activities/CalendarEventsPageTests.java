package com.automation.tests.vytrack.activities;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;



public class CalendarEventsPageTests {

    private String URL = "http://qa2.vytrack.com/user/login";
    private By usernameBy = By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");

    private Actions actions;

    private String username = "storemanager85";
    private String password = "UserUser123";

    private WebDriver driver;
    private By activitiesBy = By.xpath("//span[@class='title title-level-1' and contains(text(),'Activities')]");
    private By createCalendarEventBtnBy = By.cssSelector("a[title='Create Calendar event']");
    private By currentUserBy = By.cssSelector("#user-menu > a");
    private By OwnerBy = By.className("select2-chosen");
    private By titleBy = By.cssSelector("[name='oro_calendar_event_form[title]']");
    private By startDateBy = By.cssSelector("[id*='date_selector_oro_calendar_event_form_start-uid']");
    private By startTimeBy = By.cssSelector("[id*='time_selector_oro_calendar_event_form_start-uid']");


    @BeforeMethod
    public void setup() {
        driver = DriverFactory.createDriver("chrome");
        driver.get(URL);
        driver.manage().window().maximize();
        actions = new Actions(driver);

        BrowserUtils.wait(3);
        driver.findElement(usernameBy).sendKeys(username);
        driver.findElement(passwordBy).sendKeys(password, Keys.ENTER);

        BrowserUtils.wait(5);

        //hover over Activities
        actions.moveToElement(driver.findElement(activitiesBy));
        actions.perform();
        BrowserUtils.wait(2);
        driver.findElement(By.linkText("Calendar Events")).click();
        BrowserUtils.wait(5);

    }

    @Test
    public void verifyCreateCalendarButton(){
    WebElement createCalendarEventBtn = driver.findElement(createCalendarEventBtnBy);
    Assert.assertTrue(createCalendarEventBtn.isDisplayed());

    }


    /**
     *  TEst Case: Default options
     *     Login as sales manager
     *     Go to Activities --> Calendar Events
     *
     *
     *     Click on Create Calendar Events
     *     Default owner name should be current user
     *     Default title should be blank
     *     Default start date should be current date
     *     Default start time should be current time
     */

    @Test(description = "Default options")
    public void verifyDefaultValues(){
        //Click on Calendar event
        driver.findElement(createCalendarEventBtnBy).click();
        BrowserUtils.wait(3);

        String currentUserName = driver.findElement(currentUserBy).getText().trim();
        String defaultOwnerName = driver.findElement(OwnerBy).getText().trim();
        Assert.assertEquals(currentUserName, defaultOwnerName);

        //Default title should be blank
        //input elements do not contain text , instead text is inside attribute "value"
        //Use getAttribute() method to retrieve that value
        WebElement titleElement = driver.findElement(titleBy);
        Assert.assertTrue(titleElement.getAttribute("value").isEmpty());//text that you enter into input
        //box will be stored inside "value" attribute. So getText()

        //https://www.journaldev.com/17899/java-simpledateformat-java-date-format     dates in java

        //Default start date should be current date
        String expectedDate = LocalDate.now().format(DateTimeFormatter.ofPattern("MMM dd, yyyy"));
        String actualDate = driver.findElement(startDateBy).getAttribute("value");

        Assert.assertEquals(actualDate, expectedDate);

        String expectedTime = LocalTime.now(ZoneId.of("GMT-7")).format(DateTimeFormatter.ofPattern("h:m a"));
        String actualTIme = driver.findElement(startTimeBy).getAttribute("value");
        Assert.assertEquals(actualTIme, expectedTime);

    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
