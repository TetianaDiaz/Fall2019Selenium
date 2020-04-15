package com.automation.tests.vytrack.fleet;

import com.automation.pages.AbstractPageBase;
import com.automation.pages.LoginPage;
import com.automation.pages.fleet.VehiclePage;
import com.automation.tests.vytrack.AbstractTestBase;
import com.automation.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewVehicleTest extends AbstractTestBase {

    @Test
    public void verifyTitle(){

        LoginPage loginPage = new LoginPage();
        VehiclePage vehiclesPage = new VehiclePage();
        loginPage.login();
        vehiclesPage.navigateTo("Fleet", "Vehicles");

        String expectedTitle = "All - Car - Entities - System - Car - Entities - System";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);

    }



}
