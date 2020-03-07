package com.automation.tests.warmup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.nio.file.attribute.UserPrincipalNotFoundException;

public class AmazonTask_day4 {
    public static void main(String[] args) throws Exception {

        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();

        driver.get("http://amazon");

        Thread.sleep(3000);

        WebElement search= driver.findElement(By.name("field-keywords"));
        search.sendKeys("iphone11", Keys.ENTER);









    }
}
