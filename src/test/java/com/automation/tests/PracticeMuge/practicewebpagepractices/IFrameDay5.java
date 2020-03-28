package com.automation.tests.PracticeMuge.practicewebpagepractices;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IFrameDay5 {
    public static void main(String[] args) {


       WebDriver driver= DriverFactory.createDriver("chrome");

       driver.get("http://practice.cybertekschool.com/iframe");

       BrowserUtils.wait(4);

       driver.switchTo().frame("mce_0_ifr");

        WebElement textInput= driver.findElement(By.id("tinymce"));

        System.out.println(textInput.getText());

        BrowserUtils.wait(3);

        textInput.clear();

        textInput.sendKeys("Hello World");

        BrowserUtils.wait(4);

         driver.switchTo().defaultContent();

         WebElement heading= driver.findElement(By.tagName("h3"));
        System.out.println(heading.getText());

        driver.quit();
    }
}
