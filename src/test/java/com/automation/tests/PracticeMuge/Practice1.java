package com.automation.tests.PracticeMuge;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice1 {
    public static void main(String[] args) throws Exception{

        WebDriverManager.chromedriver().setup();

        ChromeDriver driver= new ChromeDriver();

        driver.get("http://google.com");

        driver.navigate().to("http://amazon.com");
        Thread.sleep(3000);

        System.out.println("driver.getTitle() = " + driver.getTitle());
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());

        if(driver.getTitle().equals("walmart")){
            System.out.println("test passed");
        }else{
            System.out.println("test failed");
           driver.navigate().to("http://walmart.com");
        }


    }
}
