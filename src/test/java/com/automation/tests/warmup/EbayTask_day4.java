package com.automation.tests.warmup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EbayTask_day4 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();

        driver.get("http://ebay.com");
        WebElement input= driver.findElement(By.name("_nkw"));
        input.sendKeys("java book", Keys.ENTER);

        WebElement numberOfResults= driver.findElement(By.tagName("h1"));
        String numberResult=numberOfResults.getText();
        System.out.println("numberResult = " + numberResult);












    }
}
