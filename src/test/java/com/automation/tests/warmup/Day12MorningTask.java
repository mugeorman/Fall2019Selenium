package com.automation.tests.warmup;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/**
 * Warm-up task for 15 minutes:
 * Go to http://practice.cybertekschool.com/tables
 * Click on "Last name" column name
 * Verify that table is sorted by last name in alphabetic order.
 * until 11:19
 *
 * The Java String compareTo() method is used for comparing two strings lexicographically.
 *      * Each character of both the strings is converted into a Unicode value for comparison.
 *      * If both the strings are equal then this method returns 0 else it returns positive or negative value.
 *      * The result is positive if the first string is lexicographically greater than
 *      * the second string else the result would be negative.
 *      *
 *      *  This method is coming from Comparable interface.
 *      *  If you want ot be able to sort collection of some class
 *      *  you need to implement this interface
 *      *  and override compareTo method
 *      *
 *      "a".compareTo("b") = -1
 *      61 - 62 = -1
 *      a is before b
 *      "a".compareTo("a")
 *      61 - 61 = 0
 *      0 means 2 strings are equals
 *
 */
public class Day12MorningTask {



    private WebDriver driver;


    @Test
    public void verifyTableSortedByLastName(){

      driver.findElement(By.xpath("//table[1]//th/span[1]")).click();

      BrowserUtils.wait(2);

      List<WebElement> lastNames= driver.findElements(By.xpath("//table[1]//tbody//td[1]"));

      List<String> textLastNames=BrowserUtils.getTextFromWebElement(lastNames);


      List<String> sortedLastNames= BrowserUtils.getTextFromWebElement(lastNames);//Arrays.asList("Bach","Conway","Doe","Smith");
       Collections.sort(sortedLastNames);

        Assert.assertEquals(textLastNames,sortedLastNames);



//   WebDriver driver = DriverFactory.createDriver("chrome");
//        driver.get("http://practice.cybertekschool.com/tables");
//        //click on column name
//        driver.findElement(By.xpath("//table[1]//*[text()='Last Name']")).click();
//        BrowserUtils.wait(2);
//        //collect all values from the first column
//        List<WebElement> column = driver.findElements(By.xpath("//table[1]//tbody//td[1]"));
//        for (int i = 0; i < column.size() - 1; i++) {
//            //take a string
//            String value = column.get(i).getText();
//            //take a following string
//            String nextValue = column.get(i + 1).getText();
//
//            System.out.println(value.compareTo(nextValue));
//
//            //if difference is negative - order value is before nextValue in alphabetic order
//            //if difference is positive - order value is after nextValue in alphabetic order
//            //if difference is 0 - value and nextValue are equals
//            Assert.assertTrue(value.compareTo(nextValue) <= 0);


    }


    @BeforeMethod
    public void setup(){

        WebDriverManager.chromedriver().version("79").setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        BrowserUtils.wait(3);

        driver.get("http://practice.cybertekschool.com/tables");

    }


    @AfterMethod
    public void teardown(){
        BrowserUtils.wait(3);
        driver.quit();
    }

}
