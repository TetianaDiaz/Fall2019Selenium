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
        Thread.sleep(3000); //for demo , wait 3 seconds
        //method that return page title
        String title = driver.getTitle(); //returns <title>Some title</title> text
        String expectedTitle = "Google";
        System.out.println("Title is" + title);
        if(expectedTitle.equals(title)){
            System.out.println("Test passed");
        }else{
            System.out.println("test failed");
        }
        //must be at the end

        driver.close(); //to close browser
        //browser cannot close itself

    }
}
