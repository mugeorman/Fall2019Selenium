package com.automation.tests.PracticeMuge.practicewebpagepractices;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class VerifyingElementGoneDay4 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        driver.findElement(By.id("disappearing_button")).click();
        BrowserUtils.wait(3);

        if(driver.findElements(By.id("disappearing_button")).size()==0){
            System.out.println("TEST PASSED");
        }else{
            System.out.println("TEST FAILED");
        }

        BrowserUtils.wait(3);

        List<WebElement> buttons= driver.findElements(By.tagName("button"));

        for (WebElement eachButton:buttons) {
            eachButton.click();
            BrowserUtils.wait(3);
        }


        driver.quit();




    }
}
