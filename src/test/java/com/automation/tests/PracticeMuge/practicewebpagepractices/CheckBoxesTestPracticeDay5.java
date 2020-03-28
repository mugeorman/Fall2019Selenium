package com.automation.tests.PracticeMuge.practicewebpagepractices;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckBoxesTestPracticeDay5 {
    public static void main(String[] args) {


        WebDriver driver= DriverFactory.createDriver("chrome");

        driver.get("http://practice.cybertekschool.com/checkboxes");

        BrowserUtils.wait(3);

        List<WebElement> checkboxes= driver.findElements(By.tagName("input"));

        if(!checkboxes.get(0).isSelected() && checkboxes.get(1).isSelected()){
            System.out.println("TEST PASSED");
        }else{
            System.out.println("TEST FAILED");
        }

        BrowserUtils.wait(3);

        checkboxes.get(0).click();

        BrowserUtils.wait(3);

        if(checkboxes.get(0).isSelected()){
            System.out.println("TEST PASSED");
            System.out.println("checkbox #1 is selected");
        }else{
            System.out.println("TEST FAILED");
            System.out.println("chcekbox #1 is not selected");
        }








    }
}
