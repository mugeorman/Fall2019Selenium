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
        driver.manage().window().maximize(); // to maximize browser
       // driver.manage().window().fullscreen(); // to make it fullscreen

        Thread.sleep(3000);

        // method that return page title
        // you can also see it as tab name, in the browser
        String title= driver.getTitle(); // returns <title>Some title</title> text
        String expectedTitle="Google";

        System.out.println("title = " + title);

        if(expectedTitle.equals(title)){
            System.out.println("TEST PASSED");
        }else{
            System.out.println("TEST FAILED");
        }

        // go to another websites within the same windiw
        driver.navigate().to("http://amazon.com");
        Thread.sleep(3000);

        if(driver.getTitle().toLowerCase().contains("amazon")){
            System.out.println("TEST PASSED");
        }else{
            System.out.println("TEST FAILED");
        }

        // come back to google
        driver.navigate().back();
        Thread.sleep(3000);

        // checking if page title is equals to Google
        // .getTitle() - returns page title
        verifyEquals(driver.getTitle(),"Google");

        //move forward in the browser history
        driver.navigate().forward();
        Thread.sleep(3000);
        System.out.println("Title: "+driver.getTitle());
        // driver.getTitle() - returns page title of the page that is currently opened

        // to get URL
        System.out.println("URL= " + driver.getCurrentUrl());

        driver.navigate().refresh(); // to reload
        Thread.sleep(3000); // for demo, wait 3 seconds



        // navigate().to() = driver.get()
        // must be at the end
        driver.close();



    }

    /**
     *
     * @param arg1
     * @param arg2
     */
    public static  void verifyEquals(String arg1, String arg2){
        if(arg1.equals(arg2)){
            System.out.println("TEST PASSED!");
        }else{
            System.out.println("TEST FAILED");
        }
    }


}
