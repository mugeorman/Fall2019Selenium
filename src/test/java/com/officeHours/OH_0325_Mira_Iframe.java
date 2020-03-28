package com.officeHours;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class OH_0325_Mira_Iframe {



    private WebDriver driver;


    @Test
    public void test(){

        driver.get("http://practice.cybertekschool.com/nested_frames");
        driver.switchTo().frame("frame-top");

        List<WebElement> frameList=driver.findElements(By.xpath("//frame"));

        /*
            we have stored all frames webelements inside the list
            1. Loop through list
            2. swithch to each frame
                a. get test from body
                b. switch to parent
         */



        for(WebElement each: frameList){

            BrowserUtils.wait(2);
            driver.switchTo().frame(each);
            String bodyText=driver.findElement(By.tagName("body")).getText();
            System.out.println("bodyText = " + bodyText);
            driver.switchTo().parentFrame();

        }

        driver.switchTo().defaultContent(); //will always take you to the main html - default (red in the schema)
        driver.switchTo().frame("frame-bottom"); // switched to bottom frame
        String bodyText = driver.findElement(By.xpath("//body")).getText();
        System.out.println("Body text: " + bodyText);
        driver.switchTo().defaultContent(); //switch back to default after you finished your iteraction with frame content

    }



    @BeforeMethod
    public void setup(){

        driver= DriverFactory.createDriver("chrome");
        driver.manage().window().maximize();


    }

    @AfterMethod
    public void teardown(){

        driver.quit();


    }



}
