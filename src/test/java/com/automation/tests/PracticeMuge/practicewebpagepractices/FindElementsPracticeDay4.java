package com.automation.tests.PracticeMuge.practicewebpagepractices;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FindElementsPracticeDay4 {
    public static void main(String[] args) {


        WebDriver driver =DriverFactory.createDriver("chrome");

        driver.get("http://practice.cybertekschool.com/");

        BrowserUtils.wait(3);

        List<WebElement> allLinks=driver.findElements(By.tagName("a"));

        for (WebElement eachLink :allLinks){
            System.out.println(eachLink.getText());
            System.out.println(eachLink.getAttribute("href"));
            System.out.println();

        }

        for(int i=1;i<allLinks.size();i++){
            allLinks.get(i).click();
            driver.navigate().back();
            allLinks=driver.findElements(By.tagName("a"));

        }


        driver.quit();




    }
}
