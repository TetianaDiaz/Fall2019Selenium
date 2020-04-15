package com.automation.tests.mypractice.vytrack;

import com.automation.pages.LoginPage;
import com.automation.pages.fleet.VehiclePage;
import com.automation.tests.vytrack.AbstractTestBase;
import com.automation.utilities.Driver;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class vytrackTest extends AbstractTestBase{

@Test
public void fleetModuleAccess(){
    //as a truck driver I should be able to access Vehicle under fleet module

    LoginPage login = new LoginPage();
    login.login("user19", "UserUser123");
    VehiclePage vehiclePage = new VehiclePage();
    vehiclePage.navigateTo("Fleet", "Vehicle");

}



}
