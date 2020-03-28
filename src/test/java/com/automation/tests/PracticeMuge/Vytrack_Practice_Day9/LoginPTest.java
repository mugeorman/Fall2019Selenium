package com.automation.tests.PracticeMuge.Vytrack_Practice_Day9;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import  static org.testng.Assert.*;

public class LoginPTest {


     private WebDriver driver;
     private String URL= "https://qa2.vytrack.com/user/login";
     private By usernameBy= By.cssSelector("input[name='_username']");
     private By passwordBy= By.cssSelector("input[id='prependedInput2']");
     private By loginBy= By.xpath("//button[@id='_submit']");
     private By dashBoardText=By.xpath("//h1[@class='oro-subtitle']");
     private By invalidMessage=By.xpath("//div[@class='alert alert-error']/div[1]"); // By.cssSelector("[class='alert alert-error'] > div")

     @Test(description = "Verify that after login Dashboard page is displayed")
     public void loginTest(){


         driver.findElement(usernameBy).sendKeys("salesmanager107");
         driver.findElement(passwordBy).sendKeys("UserUser123");
         BrowserUtils.wait(2);
         driver.findElement(loginBy).click();
         BrowserUtils.wait(2);
         //driver.findElement(dashBoardText);
         String actual= driver.findElement(dashBoardText).getText();
         String expected="Dashboard";

         assertEquals(actual,expected);

     }

     @Test(description = "Verify that warning message displays when user enters invalid username")
     public void invalidUsername(){


         driver.findElement(usernameBy).sendKeys("salesmanager");
         driver.findElement(passwordBy).sendKeys("UserUser123");
         BrowserUtils.wait(2);
         driver.findElement(loginBy).click();
         BrowserUtils.wait(2);


         String actual= driver.findElement(invalidMessage).getText();
         String expected="Invalid user name or password.";

         assertTrue(driver.findElement(invalidMessage).isDisplayed());
         assertEquals(actual,expected);


     }


     @BeforeMethod
    public void setUp(){
         WebDriverManager.chromedriver().setup();
         driver=new ChromeDriver();
         driver.manage().window().maximize();
         BrowserUtils.wait(2);
         driver.get(URL);

     }

     @AfterMethod
    public void tearDown(){
        if(driver!=null) {
            driver.quit();
            driver=null;
        }
     }

}
