package com.automation.tests.mypractice.homework4;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Random;

public class homework4_part5 {

    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver= DriverFactory.createDriver("chrome");
        driver.manage().window().maximize();

    }

    /**
     *   /**
     *      * go to https://www.w3schools.com/
     *      * 2. find all the elements in the page with the tag a
     *      * 3. for each of those elements, if it is displayed on the page, print the text and the href of that
     *      * element.
     *      */

    @Test
    public void findAllElements(){
        driver.get("http://www.w3schools.com");
        List<WebElement> list = driver.findElements(By.tagName("a"));

        for (int i = 0; i <list.size() ; i++) {
            if(list.get(i).isDisplayed()){
                System.out.println(list.get(i).getText() + " ---- " + list.get(i).getAttribute("href"));
            }
        }
    }

    /**
     * 1. go to https://www.selenium.dev/documentation/en/
     * 2. find all the elements in the page with the tag a
     * 3. verify that all the links are valid
     */
    @Test
    public void testLinks(){
        driver.get("http://www.selenium.dev/documentation/en/");
        List <WebElement> list = driver.findElements(By.tagName("a"));
        for (int i = 0; i <list.size() ; i++) {
        String href = list.get(i).getAttribute("href");
            try {
                URL url = new URL(href);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setConnectTimeout(3000);
                httpURLConnection.connect();
                //get response from URL and if code return 200 that means the link is valid
                Assert.assertEquals(httpURLConnection.getResponseCode(), 200);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * search for "wooden spoon"
     * 3. click search
     * 4. remember the name and the price of a random result
     * 5. click on that random result
     * 6. verify default quantity of items is 1
     * 7. verify that the name and the price is the same as the one from step 5
     * 8. verify button "Add to Cart" is visible
     */
    @Test
    public void cart(){
        driver.get("http://amazon.com");
        driver.findElement(By.cssSelector("input[type='text']")).sendKeys("wooden spoon", Keys.ENTER);
        List <WebElement> listOfSpoons = driver.findElements(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']"));
        //listOfSpoons.remove(13);

        Random r = new Random();
        int index = r.nextInt(listOfSpoons.size());//or r.nextInt(y.getOptions().size());
        index= index==0?1:index;//ternary operator, the random can give us 0, but in html count starts from 1,
        // so in order not to get 0, we will change it to 1
        String productTitle = listOfSpoons.get(index).getText().trim();
        String productPrice = "$" +driver.findElement(By.xpath("(//span[@class='a-price-whole'])["+ index+"]")).getText() +"."+
                driver.findElement(By.xpath("(//span[@class='a-price-fraction'])["+ index+"]")).getText();
        //String priceWhole=
        listOfSpoons.get(index).click();
        String productPrice2 = driver.findElement(By.xpath("//span[@id='price_inside_buybox']")).getText();
        String productTitle2 = driver.findElement(By.xpath("//span[@id='productTitle']")).getText().trim();

        Assert.assertEquals(driver.findElement(By.xpath("//span[@class='a-dropdown-prompt']")).getText(), "1");

        Assert.assertEquals(productTitle, productTitle2);

        Assert.assertEquals(productPrice, productPrice2);

        Assert.assertTrue(driver.findElement(By.cssSelector("input[id='add-to-cart-button']")).isDisplayed());
    }

    /**
     * 1. go to https://amazon.com
     * 2. search for "wooden spoon"
     * 3. click search
     * 4. remember name first result that has prime label
     * 5. select Prime checkbox on the left
     * 6. verify that name first result that has prime label is same as step 4
     * 7. check the last checkbox under Brand on the left
     * 8. verify that name first result that has prime label is different
     */
    @Test
    public void prime(){
        driver.get("http://amazon.com");
        driver.findElement(By.cssSelector("input[type='text']")).sendKeys("wooden spoon", Keys.ENTER);
        String firstItemName = driver.findElement(By.xpath("(//i[@aria-label='Amazon Prime']/../../../../../..//h2/a/span)[1]")).getText();
        driver.findElement(By.xpath("(//i[@class='a-icon a-icon-checkbox'])[1]")).click();
        String firstItemNamePrime =
              driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[1]")).getText();
        Assert.assertEquals(firstItemName, firstItemNamePrime);

        driver.findElement(By.xpath("(//i[@class='a-icon a-icon-checkbox'])[18]")).click();
        String firstItemNameBrand = driver.findElement(By.xpath("(//i[@aria-label='Amazon Prime']/../../../../../..//h2/a/span)[1]")).getText();

        Assert.assertEquals(firstItemNamePrime, firstItemNameBrand);
    }


    /**
     * 1. go to https://amazon.com
     * 2. search for "wooden spoon"
     * 3. remember all Brand names on the left
     * 4. select Prime checkbox on the left
     * 5. verify that same Brand names are still displayed
     */
    @Test
    public void moreSpoons(){
        driver.get("http://amazon.com");
        driver.findElement(By.cssSelector("input[type='text']")).sendKeys("wooden spoon", Keys.ENTER);
        String allBrands= driver.findElement(By.xpath("//div[@id='brandsRefinements']")).getText();
        driver.findElement(By.xpath("(//i[@class='a-icon a-icon-checkbox'])[1]")).click();
        String allBrandsPrime = driver.findElement(By.xpath("//div[@id='brandsRefinements']")).getText();

        Assert.assertEquals(allBrands, allBrandsPrime);

    }

    /**
     *
     */
    public void cheapSpoons(){
        driver.get("http://amazon.com");
        driver.findElement(By.cssSelector("input[type='text']")).sendKeys("wooden spoon", Keys.ENTER);

    }


    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
