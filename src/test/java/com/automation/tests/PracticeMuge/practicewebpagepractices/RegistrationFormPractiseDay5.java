package com.automation.tests.PracticeMuge.practicewebpagepractices;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class RegistrationFormPractiseDay5 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/registration_form");

        BrowserUtils.wait(3);

        WebElement firstName=driver.findElement(By.name("firstname"));
        firstName.sendKeys("Muge");

        WebElement lastName=driver.findElement(By.name("lastname"));
        lastName.sendKeys("Orman");

        WebElement userName= driver.findElement(By.name("username"));
        userName.sendKeys("morman");

        WebElement email=driver.findElement(By.name("email"));
        email.sendKeys("morman@hotmail.com");

        WebElement password= driver.findElement(By.name("password"));
        password.sendKeys("12341234");

        WebElement phoneNum=driver.findElement(By.name("phone"));
        phoneNum.sendKeys("801-555-2233");

        List<WebElement> gender=driver.findElements(By.name("gender"));
        gender.get(1).click();

        WebElement dob=driver.findElement(By.name("birthday"));
        dob.sendKeys("05/25/1990");

        WebElement language=driver.findElement(By.id("inlineCheckbox2"));
        language.click();

        WebElement signup=driver.findElement(By.id("wooden_spoon"));
        signup.click();

        BrowserUtils.wait(3);

         String expected="Well done!";


          String actual= driver.findElement(By.tagName("h4")).getText();

          if(expected.equals(actual)){
              System.out.println("PASSED");
          }else{
              System.out.println("FAILED");
          }

        BrowserUtils.wait(3);
         driver.quit();



    }
}
