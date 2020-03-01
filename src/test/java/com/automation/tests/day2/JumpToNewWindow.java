package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class JumpToNewWindow {

    public static void main(String[] args) throws Exception {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/open_new_tab");
        Thread.sleep(5000);

        //every windows has some id, this id calls window handle
        //based on window handle, we can switch in between windows
        String windowHandle = driver.getWindowHandle();

        System.out.println(windowHandle);
        //getWindowHandles() - returns id's of all currently opened windows
        //Set - doesn't allow duplicates

        Set<String> windowsHandles = driver.getWindowHandles();

        System.out.println(windowsHandles);
        //since we have all windows
        //and we know id of original window
        //we can say switch to something that is not equals to old window id








    }
}
