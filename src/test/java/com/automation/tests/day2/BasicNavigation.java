package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BasicNavigation {
    public static void main(String[] args) throws Exception{

        // to start selenium script we need:
        // setup web driver (browser driver) and create web driver object

        WebDriverManager.chromedriver().setup();

        //ChromeDriver extends RemoteWebDriver --> implements WebDriver
        //RemoteWebDriver driver= new ChromeDriver(); polymorphism
        ChromeDriver driver = new ChromeDriver();

        // In selenium , everything starts from WebDriver interface


        driver.get("http://google.com");

        Thread.sleep(3000);

        // method that return page title
        // you can also see it as tab name, in the browser
        String title= driver.getTitle(); // returns <title>Some title</title> text
        String expectedTitle="Google";

        System.out.println("title = " + title);

        if(expectedTitle.equals(title)){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed");
        }

        driver.close();







    }
}
