package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class RadioButtons {
    public static void main(String[] args){


        WebDriverManager.chromedriver().setup();

        WebDriver driver= new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/radio_buttons");

        driver.manage().window().maximize();

        BrowserUtils.wait(2);

        // <input type="radio">
        List<WebElement> radioButtons= driver.findElements(By.tagName("input"));

        for (WebElement eachRadioButton:radioButtons) {

            // <input type="radio" id="red" name="color">
            String id=eachRadioButton.getAttribute("id");

            // return trued if button already clicked
            boolean isSelected=eachRadioButton.isSelected();
            System.out.println(id+" is selected? "+isSelected);



            // if button is eligible to click
            // return true if you can click on the button

            if(eachRadioButton.isEnabled()) {
                eachRadioButton.click();
                System.out.println("Clicked on: "+ id);
                BrowserUtils.wait(1);
            }else{
                System.out.println("Button is disabled, not clicked: "+id);
            }
            System.out.println();
        }

        driver.quit();




    }
}
