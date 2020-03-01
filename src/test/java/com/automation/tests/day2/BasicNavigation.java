package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation {

    public static void main(String[] args) throws Exception{
        //to start selenium script we need:
        //setup webdriver (browser driver)and create webdriver object
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        //in Selenium, everything starts from WebDriver interface
        //ChromeDriver extends RemoteWebDriver  --> implements WebDriver

        driver.get("http://google.com"); //this open a website
        driver.manage().window().maximize(); //to maximize browser
        driver.manage().window().fullscreen();
        Thread.sleep(3000); //for demo , wait 3 seconds
        //method that return page title
        String title = driver.getTitle(); //returns <title>Some title</title> text
        String expectedTitle = "Google"; // we provide it
        System.out.println("Title is " + title);
        if(expectedTitle.equals(title)){
            System.out.println("Test passed");
        }else{
            System.out.println("test failed");
        }
        //go to another website withing the same window
        driver.navigate().to("http://amazon.com");
        Thread.sleep(3000); //for demo, wait 3 seconds

        if(driver.getTitle().toLowerCase().contains("amazon")){
            System.out.println("test passed!");
        }else{
            System.out.println("test failed!");
        }

        //comeback to google
        driver.navigate().back();
        //checking if page title is equal to Google
        //.getTitle() - returns page title
        verifyEquals(driver.getTitle(), "Google");

        //move forward in the browser history
        //again going to amazon
        driver.navigate().forward();
        Thread.sleep(3000);
        System.out.println("title: " + driver.getTitle());
        //driver.getTitle() - returns page title of the page that is currently opened

        System.out.println("URL" + driver.getCurrentUrl()) ;
       //to get URL
        //must be at the end
        //driver.navigate().to() = driver.get()
        driver.navigate().refresh();//to reload the page
        Thread.sleep(3000);

        driver.close(); //to close browser

        //browser cannot close itself

    }

    /**
     * Check if to strigns are same. If print Test passed! message
     * Otherwise, print Test Failed message
     * @param arg1
     * @param arg2
     */
    public static void verifyEquals(String arg1, String arg2){
        if(arg1.equals(arg2)){
            System.out.println("test passed!");
        }else{
            System.out.println("test failed!");
        }
    }
}
