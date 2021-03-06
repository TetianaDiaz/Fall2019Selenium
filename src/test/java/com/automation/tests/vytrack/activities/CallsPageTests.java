package com.automation.tests.vytrack.activities;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CallsPageTests {
    private String URL = "http://qa2.vytrack.com/user/login";
    private By usernameBy = By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");

    private Actions actions;

    private String username = "storemanager85";
    private String password = "UserUser123";

    private WebDriver driver;
    private By activitiesBy = By.xpath("//span[@class='title title-level-1' and contains(text(),'Activities')]");
    private By logCallBtnBy = By.cssSelector("a[title='Log call']");

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
        actions.moveToElement(driver.findElement(activitiesBy)).perform();
        BrowserUtils.wait(2);
        driver.findElement(By.linkText("Calls")).click();
        BrowserUtils.wait(5);

    }



    @Test
    public void verifyLogButton(){
        WebElement logCallBtnElement = driver.findElement(logCallBtnBy);
        Assert.assertTrue(logCallBtnElement.isDisplayed());
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}



