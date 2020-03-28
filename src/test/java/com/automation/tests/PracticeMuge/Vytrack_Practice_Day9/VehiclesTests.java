package com.automation.tests.PracticeMuge.Vytrack_Practice_Day9;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class VehiclesTests {

      private WebDriver driver;
      private String URL= "https://qa2.vytrack.com/user/login";
      private By usernameBy= By.cssSelector("input[name='_username']");
      private By passwordBy= By.cssSelector("input[id='prependedInput2']");
      private By loginBy= By.xpath("//button[@id='_submit']");
      private By fleetBy=By.xpath("//*[@class='title title-level-1' and contains(text(),'Fleet')]");
      private By vehiclesBy= By.linkText("Vehicles");
      private By subTitleBy=By.xpath("//h1[@class='oro-subtitle']");
      private By pageNumBy=By.xpath("//input[@type='number']");

      private String username="salesmanager107";
      private String password="UserUser123";






      @Test
      public void verifyPageSubTitle(){



         String actualSubTitle= driver.findElement(subTitleBy).getText();
         String expectedSubTitle="All Cars";

         assertEquals(actualSubTitle,expectedSubTitle);



      }

      @Test
      public void verifyPageNumber(){

          String actual= driver.findElement(pageNumBy).getAttribute("value");
          String expected="1";

          assertEquals(actual,expected);


      }




      @BeforeMethod
      public void setUp(){

            WebDriverManager.chromedriver().setup();
            driver= new ChromeDriver();
            driver.get(URL);
            driver.manage().window().maximize();
            BrowserUtils.wait(3);

            driver.findElement(usernameBy).sendKeys(username);
            driver.findElement(passwordBy).sendKeys(password, Keys.ENTER);
            driver.findElement(fleetBy).click();
            BrowserUtils.wait(5);
            driver.findElement(vehiclesBy).click();
            BrowserUtils.wait(3);

      }

      @AfterMethod
      public void tearDown(){
            driver.quit();
      }




}
