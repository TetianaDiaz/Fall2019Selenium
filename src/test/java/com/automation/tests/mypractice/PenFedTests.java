package com.automation.tests.mypractice;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PenFedTests {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://penfed.org");

        BrowserUtils.wait(5);

        WebElement alert = driver.findElement(By.xpath("//span[@class='alertTxt']"));
        System.out.println(alert.getText());

                //<a href="#" data-role="button" class="pfui-button pfui-button-close
        // pfui-button-alert-close">
        // <i class="fa fa-times-circle" aria-hidden="true"></i></a>
    }
}
