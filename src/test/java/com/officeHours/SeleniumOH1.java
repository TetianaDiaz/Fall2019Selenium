package com.officeHours;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class SeleniumOH1 {
/**
 * - iterator
 *    - List, Set, Map and other types of Collections can use iterator class to iterate over that Collection
 *    -List has indexes (for i, for each, while, Iterator)
 *    -Map (for each, Iterator - to loop through keys)
 *    * - Basic Selenium Navigations
 */

public static void main(String[] args) {

    //create ArrayList of Strigns and oterate over it

    ArrayList<String> keysToSearch = new ArrayList<>();
    keysToSearch.add("fruits");
    keysToSearch.add("vegetables");
    keysToSearch.add("berries");
    Iterator <String> iterator = keysToSearch.iterator();
    //iterator () - return Iterator type which we can use with all iterator methods
    //[fruits, veggies, berries]

    while (iterator.hasNext()){
        System.out.println(iterator.next());
    }
    //print before modification and
    //add * to each String and print again

    Iterator <String> iterator1 = keysToSearch.iterator();
    while (iterator1.hasNext()){
        String item = iterator1.next();
        System.out.println(item);
        System.out.println("*" + item);
    }

    //create Map with <String, String>

    HashMap<String, String>peronalInfo = new HashMap<>();
    peronalInfo.put("name", "Bryan");
    peronalInfo.put("student_id", "2314635541");
    peronalInfo.put("major", "computer science");

    Iterator <String> mapIterator = peronalInfo.keySet().iterator();
    while(mapIterator.hasNext()){
        String key = mapIterator.next();
        System.out.println(key +  ":" + peronalInfo.get(key));
    }

    //Selenium
/**
 * id - unique (it is not always available) we always want to use it when it's available
 * class - classname
 * name
 * tag - every element has a tag
 *
 * linkText - will only work with the link
 * partialLinkText
 *
 * locators that is using html (syntax)
 * css
 * xpath
 * ------------------------------------------
 *<input id="global-enhancements-search-query" data-id="search-query"
 * data-global-enhancements-search-input="" type="text" name="search_query"
 * class="wt-input wt-input-btn-group__input global-enhancements-search-input-btn-group__input wt-pr-xs-7"
 * placeholder="Search for items or shops" value=""
 * autocomplete="off" autocorrect="off" autocapitalize="off">
 *
 *
 * input - tag
 * key = "value" - attributes
 *
 * id="global-enhancements-search-query" - one of the attributes
 * we can use id to locate the element
 * name="search_query" - attribute - we can use name to locate the element
 *
 * class="wt-input wt-input-btn-group__input global-enhancements-search-input-btn-group__input wt-pr-xs-7"
 *  - we can use class to locate element
 *
 *  When we want to find element it is always must be unique
 *  id- always unique
 *  name, tag, class - are not unique very often
 */

    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();

    driver.get("http://etsy.com");
    WebElement searchBar = driver.findElement(By.id("global-enhancements-search-query"));
    //find element () - returns WebElement
    //as param we put By.locator(value of attribute)
    //can be id, name, classname, class....




}
}
