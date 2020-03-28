package com.officeHours;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class JavaScriptOH_03_23_2020_Nurullah {


    @Test(description = "Send text to search box on etsy")
    public void test1() {

        WebDriver driver = DriverFactory.createDriver("chrome");

        driver.get("https://www.etsy.com");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('global-enhancements-search-query').value='Send these characters'");


    }

    @Test(description = "get the page title")
    public void testcase3() {
        WebDriver driver = DriverFactory.createDriver("chrome");

        driver.get("https://www.etsy.com");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //return keyword before the script is for Selenium to know that it needs to bring back information
        String pageTitle = js.executeScript("return document.title").toString();
        System.out.println(pageTitle);

    }

    @Test(priority = 1, description = "Clicking on an element")
    public void test2() {
        WebDriver driver = DriverFactory.createDriver("chrome");
        //Navigating to etsy homepage
        driver.get("https://www.etsy.com/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(" document.getElementById('catnav-primary-link-891').click();");
    }

    @Test(description = "return page URL")
    public void test4() {
        WebDriver driver = DriverFactory.createDriver("chrome");
        //Navigating to etsy homepage
        driver.get("https://www.etsy.com/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //return keyword before the script is for Selenium to know that it needs to bring back information
        String pageURL = js.executeScript("return document.URL").toString();
        System.out.println(pageURL);
    }

    @Test(description = "return element text")
    public void test5() {
        WebDriver driver = DriverFactory.createDriver("chrome");
        //Navigating to etsy homepage
        driver.get("https://www.etsy.com/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String elementText = js.executeScript("return document.getElementById('catnav-primary-link-11049').innerHTML").toString();
        elementText = elementText.trim();
        System.out.println(elementText);
    }

    @Test(description = "scroll an element into view")
    public void test6() {
        WebDriver driver = DriverFactory.createDriver("chrome");
        //Navigating to etsy homepage
        driver.get("https://www.etsy.com/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('email-list-signup-email-input').scrollIntoView();");


    }
}
