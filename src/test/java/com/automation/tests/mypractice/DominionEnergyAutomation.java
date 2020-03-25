package com.automation.tests.mypractice;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.automation.utilities.DriverFactory.*;

public class DominionEnergyAutomation {

    public static void main(String[] args) {
        WebDriver driver = createDriver("chrome");
        driver.get("http://dominionenergy.com");
        BrowserUtils.wait(2);
        driver.findElement(By.xpath("//a[@title='Sign In']")).click();
        BrowserUtils.wait(2);
        driver.findElement(By.xpath("//span[@class='bx-title']")).click();
        BrowserUtils.wait(2);
        driver.findElement(By.xpath("//input[@name='USER']")).sendKeys("Tetiana1");
        BrowserUtils.wait(2);
        driver.findElement(By.xpath("//input[@name='PASSWORD']")).sendKeys("Tanyushka22", Keys.ENTER);
        BrowserUtils.wait(2);
        driver.findElement(By.xpath("//a[@href='/Payment']")).click();





    }
}
