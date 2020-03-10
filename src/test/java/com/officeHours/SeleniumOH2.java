package com.officeHours;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumOH2 {
    public static void main(String[] args)  {
        /**
         * 1. we will go to http://automationpractice.com
         * 2. Search for 'tshirt' in a searchbox + click enter or click search button
         * 3.validate you got 'no results' message on UI
         * 4. Search for 't-shirt'
         * 5. Validate there was 1 result found
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://automationpractice.com");
        //Thread.sleep(2000);

        WebElement search_box = driver.findElement(By.id("search_query_top"));
        //WebElement - class is Selenium/java and it has many useful methods
        //.sendKeys("value that we want send - input")
        search_box.sendKeys("tshirt" , Keys.ENTER);//Keys is enum, we add keys.Enter to click on the button
        //you can use + or , doesn't matter

        /*
        <p class="alert alert-warning">
					No results were found for your search&nbsp;"tshirt"
			</p>
         */
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement error = driver.findElement(By.xpath("//p[@class='alert alert-warning']"));
        String errorText = error.getText();
        //.getText() -> returns String (text) from the lement
        System.out.println("Error message: " + errorText);
        //NoSuchElementException - it means we could't locate the element

        search_box=driver.findElement(By.id("search_query_top"));
        search_box.clear();
        //.clear() - (void) it will delete any values from input box
        search_box.sendKeys("t-shirt", Keys.ENTER);
        //StaleElementReferenceException - element is old/stale - we want to find this element again
        //sometimes refresh page works

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement count = driver.findElement(By.className("product-count"));
        System.out.println("items found: " + count.getText());


        driver.quit();






    }

}
