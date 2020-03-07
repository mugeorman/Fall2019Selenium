package com.automation.tests.PracticeMuge;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FindingElementPracticeFromDay3 {
    public static void main(String[] args) throws Exception {


//        WebDriverManager.chromiumdriver().setup();
//        WebDriver driver= new ChromeDriver();

          WebDriver driver= DriverFactory.createDriver("chrome");
          driver.get("http://practice.cybertekschool.com/sign_up");

          Thread.sleep(3000);

         WebElement fullName=driver.findElement(By.name("full_name"));
         fullName.sendKeys("Ayse Orman");
        Thread.sleep(3000);

         WebElement email= driver.findElement(By.name("email"));
         email.sendKeys("ayse@gmail.com");
        Thread.sleep(3000);

         WebElement signUp= driver.findElement(By.name("wooden_spoon"));
         signUp.click();
        Thread.sleep(3000);

        String expected= ("Thank you for signing up. Click the button below to return to the home page.");
        WebElement message= driver.findElement(By.className("subheader"));
        String actual= message.getText();

        if(expected.equals(actual)){
            System.out.println("TEST PASSED");
        }else{
            System.out.println("TEST FAILED");
        }


        driver.quit();







    }
}
