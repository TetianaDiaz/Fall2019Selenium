package com.automation.tests.vytrack.fleet;

import com.automation.utilities.BrowserUtils;
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

public class VehiclePageTests {

    private String URL = "http://qa2.vytrack.com/user/login";
    private By usernameBy = By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");
    //> in css selector means same thing as / in xpath - direct child
    private By fleetBy = By.xpath("//span[@class='title title-level-1' and contains(text(), 'Fleet')]");
    //xpath allows to specify multiple search criterias in this locator,
    // we are looking for element that has a class name and contains text , we use contains due to spaces
    private String username = "storemanager85";
    private String password = "UserUser123";
    private By subtitleBy = By.className("oro-subtitle");
    private By pageNumberBy = By.cssSelector("input[type='number']");
    private WebDriver driver;

    @Test
    public void verifyPageSubTitle() {

        //login
        driver.findElement(usernameBy).sendKeys(username);
        driver.findElement(passwordBy).sendKeys(password, Keys.ENTER);

        BrowserUtils.wait(5);
        //click on fleet
       // driver.findElement(fleetBy).click();
        Actions actions = new Actions(driver);
        //move to element instead of click
        //Action class is used for more advanced browser interactions
        actions.moveToElement(driver.findElement(fleetBy)).perform();//we use actions class to drag and drop ,
        // context click, move mouse to webelement or some point
        //perform - to execute command
        //every action should end with perform()



        BrowserUtils.wait(2);
        //click on vehicles
        driver.findElement(By.linkText("Vehicles")).click();

        BrowserUtils.wait(5);

        //find subtitle element
        WebElement subTitleElement = driver.findElement(subtitleBy);
        System.out.println(subTitleElement.getText());
        String expected = "All Cars";
        String actual = subTitleElement.getText();
        Assert.assertEquals(actual, expected);
    }
    @Test
    public void verifyPageNumber(){

        String expected = "1";
        String actual = driver.findElement(pageNumberBy).getAttribute("value");//because the value is number 1 not the text we use getAttribute
        Assert.assertEquals(actual, expected);

    }

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
        driver.findElement(usernameBy).sendKeys(username);
        driver.findElement(passwordBy).sendKeys(password, Keys.ENTER);
        BrowserUtils.wait(5);
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(fleetBy)).perform();//we use actions class to drag and drop ,
        BrowserUtils.wait(2);
        driver.findElement(By.linkText("Vehicles")).click();
        BrowserUtils.wait(5);
    }

    @AfterMethod
    public void teardown() {
        //if webdriver object alive
        if (driver != null) {
            //close browser, close session
            driver.quit();
            //destroy webdriver object for sure
            driver = null;
        }

    }
}
