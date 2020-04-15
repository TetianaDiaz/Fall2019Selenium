package com.automation.tests.vytrack.activities;


import com.automation.pages.LoginPage;
import com.automation.pages.activities.CalendarEventsPage;
import com.automation.tests.vytrack.AbstractTestBase;
import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DateTimeUtilities;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class NewCalendarEventsTests extends AbstractTestBase {

    LoginPage loginPage = new LoginPage();
    CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
    /**
     *  Test Case: Default options
     *     Login as sales manager
     *     Go to Activities --> Calendar Events
     *     Click on Create Calendar Events
     *     Default owner name should be current user
     *     Default title should be blank
     *     Default start date should be current date
     *     Default start time should be current time
     */

    @Test
    public void defaultOptionsTest(){
        test=report.createTest("Verify default login options");

        LoginPage loginPage = new LoginPage();
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        loginPage.login();
        calendarEventsPage.navigateTo("Activities", "Calendar Events");
        calendarEventsPage.clickToCreateCalendarEvent();
        Assert.assertEquals(calendarEventsPage.getOwnerName(), calendarEventsPage.getCurrentUserName());


        String actualStartDate = calendarEventsPage.getStartDate();
        String expectedStartDate = DateTimeUtilities.getCurrentDate("MMM dd, yyyy");
        Assert.assertEquals(actualStartDate, expectedStartDate);

        test.pass("Default options verified");

    }

    /**
     * Test Case: Time difference
     * Login as sales manager
     * Go to Activities --> calendar Events
     * Click on Create Calendar Events
     * Verify that difference between start and end time is 1 hour
     */

    public void timeDifference(){

        loginPage.login();
        calendarEventsPage.navigateTo("Activities", "Calendar Events");
        calendarEventsPage.clickToCreateCalendarEvent();

    }
    @Test
    public void  timeDifferenceTest() {
        test=report.createTest("Veirfy time difference");
     loginPage.login();
     calendarEventsPage.navigateTo("Activities", "Calendar Events");
     calendarEventsPage.clickToCreateCalendarEvent();
     String startTime = calendarEventsPage.getStartTime();
     String endTime = calendarEventsPage.getEndTime();
     String format = "h:mm a";
     long actual = DateTimeUtilities.getTimeDifference(startTime, endTime, format);
        Assert.assertEquals(actual, 1, "Time difference is not correct");
        test.pass("Time difference verified");
    }

    /**
     * use qa1
     * Login as store manager
     * Verify that column names displayed:
     * TITLE
     * CALENDAR
     * START
     * END
     * RECURRENT
     * RECURRENCE
     * INVITATION STATUS
     *
     */
   @Test
    public void verifyColumnNamesTest(){
       test=report.createTest("Verify columns names");
        loginPage.login();
        calendarEventsPage.navigateTo("Activities", "Calendar Events");

        List<String> expected = Arrays.asList("TITLE", "CALENDAR", "START", "END", "RECURRENT", "RECURRENCE", "INVITATION STATUS");
       Assert.assertEquals(calendarEventsPage.getColumnNames(), expected);
       test.pass("Column names verified");
    }
  //  public Object [] events(){

   // }
    @Test (dataProvider = "calendarEvents")
    public void createCalendarEventTest(String title, String description){

       //only for extend report. To create a test in html report
       test = report.createTest("Create Calendar Event for" + title);
        LoginPage loginPage = new LoginPage();
        loginPage.login();
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

       calendarEventsPage.navigateTo("Activities", "Calendar Events");
       calendarEventsPage.clickToCreateCalendarEvent();
       calendarEventsPage.enterCalendarEventTitle(title);
        //BrowserUtils.wait(2);
       calendarEventsPage.enterCalendarEventDescription(description);
       calendarEventsPage.clickOnSaveAndClose();
       //verify that calendar event info is correct

       Assert.assertEquals(calendarEventsPage.getGeneralInfoDescriptionText(), description);
       Assert.assertEquals(calendarEventsPage.getGeneralInfoTitleText(), title);
       //for extent report, specify that test passed in report (if all assertions passed)
       test.pass("Calendar event was created successfully");

    }

    @DataProvider
    public Object [][] calendarEvents(){
       return new Object[][]{
               {"Daily stand-up meeting", "Scrum meeting to provide updates"},
               {"Sprint review", "Scrum meeting where team discussing previous sprint"},
               {"Sprint Planning", "Scrum meeting where team discussing backlog for following sprint"},
       };
    }
}
