package com.automation.tests.warmup;

import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class March4 {

    public static void main(String[] args) throws Exception{

        //ebayTest();
        //amazonTest();
        wikiTest();

    }

    /**
     *  Go to ebay
     * enter search term
     * click on search button
     * print number of results
     * @throws Exception
     */
    public static void ebayTest() throws Exception{

       WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://ebay.com");
        driver.findElement(By.id("gh-ac")).sendKeys("java book");
        driver.findElement(By.id("gh-btn")).click();
        Thread.sleep(3000);
        WebElement searchResults = driver.findElement(By.tagName("h1"));
        System.out.println(searchResults.getText());
        driver.quit();
    }

    public static void amazonTest() throws Exception{
       WebDriver driver = DriverFactory.createDriver("chrome");
       driver.get("http://amazon.com");
       driver.findElement(By.id("twotabsearchtextbox")).sendKeys("java book", Keys.ENTER);
       Thread.sleep(3000);
       String title = driver.getTitle();
       if(title.contains("java book")){
           System.out.println("Test passed");
       }else{
           System.out.println("Test failed");
       }
       driver.quit();
    }

    public static void wikiTest () throws Exception{
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://en.wikipedia.org/wiki/Main_Page");
        //enter search term 'selenium webdriver' & click on search button
        driver.findElement(By.id("searchInput")).sendKeys("selenium webdriver", Keys.ENTER);
        driver.findElement(By.partialLinkText("Selenium (software)")).click();

        Thread.sleep(3000);
        String link = driver.getCurrentUrl();//to get link as a String

        //verify url ends with 'selenium_(software)'
       if(link.endsWith("Selenium_(software)")){
           System.out.println("Test passed");
       }else{
           System.out.println("Test failed");
       }
        driver.quit();
    }
}
