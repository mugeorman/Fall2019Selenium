package com.automation.tests.PracticeMuge.practicewebpagepractices;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.sql.SQLOutput;

public class RadioButtonsTestDay5 {
    public static void main(String[] args) {

        WebDriver driver=DriverFactory.createDriver("chrome");

        driver.get("http://practice.cybertekschool.com/radio_buttons");

        driver.manage().window().maximize();

        BrowserUtils.wait(2);

        WebElement blackButton= driver.findElement(By.id("black"));


        if(blackButton.isDisplayed() && blackButton.isEnabled()) {
            blackButton.click();
        }

        BrowserUtils.wait(2);

        if(blackButton.isSelected()){
            System.out.println("TEST PASSED");
        }else{
            System.out.println("TEST FAILED");
        }





        driver.quit();




    }
}
