package com.automation.tests.PracticeMuge.practicewebpagepractices;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckBoxesPracticeDay5 {
    public static void main(String[] args) {

        WebDriver driver=DriverFactory.createDriver("chrome");
         driver.get("http://practice.cybertekschool.com/checkboxes");
        BrowserUtils.wait(3);

        List<WebElement> checkboxes=driver.findElements(By.tagName("input"));

        //checkboxes.get(0).click();

        BrowserUtils.wait(2);
        for(int i=0; i<checkboxes.size();i++) {
            if (checkboxes.get(i).isDisplayed() && checkboxes.get(i).isEnabled() && !checkboxes.get(i).isSelected()) {
                checkboxes.get(i).click();
            }else{
                System.out.println(i+1+" checkbox wasn't clicked");
            }
        }
        BrowserUtils.wait(2);


        driver.quit();
    }
}
