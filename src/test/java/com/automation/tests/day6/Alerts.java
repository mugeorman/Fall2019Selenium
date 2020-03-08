package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Alerts {
    public static void main(String[] args) {

        WebDriver driver= DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/javascript_alerts");

        BrowserUtils.wait(3);

        List<WebElement> buttons= driver.findElements(By.tagName("button"));

        System.out.println("TEST NO:1");
        buttons.get(0).click(); // to click on the first button
        BrowserUtils.wait(3);

        // to get the text from popup message
        String popupText= driver.switchTo().alert().getText();
        System.out.println(popupText);

        driver.switchTo().alert().accept(); // to click ok

        String expected= "You successfully clicked an alert";
        String actual=driver.findElement(By.id("result")).getText();

        //if it will fail, because there is a typo in the html "successfuly" ##BUG##
        if(expected.equals(actual)){
            System.out.println("TEST PASSED");
        }else{
            System.out.println("TEST FAILED");
            System.out.println("Expected : "+expected);
            System.out.println("Actual : "+actual);
        }


        BrowserUtils.wait(3);

        // ######################################################
        System.out.println("TEST NO:2");
        buttons.get(1).click(); //to click on the 2nd button
        BrowserUtils.wait(3);

        // to click cancel
        driver.switchTo().alert().dismiss();// must be :

        String expected2="You clicked: Cancel";
        String actual2=driver.findElement(By.id("result")).getText();

        if(expected2.equals(actual2)){
            System.out.println("TEST PASSED");
        }else{
            System.out.println("TEST FAILED");
            System.out.println("Expected2 : "+expected2);
            System.out.println("Actual2 : "+actual2);
        }

        BrowserUtils.wait(3);
        // ######################################################
        System.out.println("TEST NO:3");
        //TASK for 5 min until 3.37
        buttons.get(2).click();
        BrowserUtils.wait(3);




        Alert alert= driver.switchTo().alert();
        alert.sendKeys("Hello Muge");// driver.switchTo().alert().sendKeys("Hello Muge");
        BrowserUtils.wait(4);
        alert.accept();//  driver.switchTo().alert().accept();

        String expected3="Hello Muge";
        String actual3=driver.findElement(By.id("result")).getText();

        if(actual3.endsWith(expected3)){
            System.out.println("TEST PASSED");
        }else{
            System.out.println("TEST FAILED");
            System.out.println("Expected3 : "+expected3);
            System.out.println("Actual3 : "+actual3);
        }



        BrowserUtils.wait(3);
        driver.quit();




    }
}
