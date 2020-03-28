package com.automation.tests.PracticeMuge.practicewebpagepractices;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RadioButtonsDay5 {
    public static void main(String[] args) {


        WebDriver driver=DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/radio_buttons");

        BrowserUtils.wait(2);

        driver.findElement(By.id("blue")).click();
        driver.manage().window().maximize();


        List<WebElement> radioButtons= driver.findElements(By.tagName("input"));


        for (WebElement eachButton:radioButtons){
            boolean isSelected= eachButton.isSelected();
            System.out.println(eachButton.getAttribute("id")+" is selected?"+ isSelected);

            if(eachButton.isEnabled()){
                eachButton.click();
                BrowserUtils.wait(1);
                System.out.println("Cliked on ::"+ eachButton.getAttribute("id")+ " button");

            }else{
                System.out.println(eachButton.getAttribute("id")+" Button is disabled, not clicked");

            }

        }



         driver.quit();

    }
}
