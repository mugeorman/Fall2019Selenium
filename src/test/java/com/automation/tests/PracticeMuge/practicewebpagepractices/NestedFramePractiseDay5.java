package com.automation.tests.PracticeMuge.practicewebpagepractices;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NestedFramePractiseDay5 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/nested_frames");

        BrowserUtils.wait(3);


        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");

        WebElement content=driver.findElement(By.id("content"));
        System.out.println(content.getText());

        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-left");

        WebElement body= driver.findElement(By.tagName("body"));
        System.out.println(body.getText());

        driver.switchTo().defaultContent();

        driver.switchTo().frame("frame-bottom");
        WebElement bottomBody=driver.findElement(By.tagName("body"));
        System.out.println(bottomBody.getText());


        BrowserUtils.wait(3);
        driver.quit();



    }
}
