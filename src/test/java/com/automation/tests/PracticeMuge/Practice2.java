package com.automation.tests.PracticeMuge;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice2 {
    public static void main(String[] args) throws Exception{

        WebDriverManager.chromedriver().setup();

        ChromeDriver driver= new ChromeDriver();

        driver.get("http://google.com");
        Thread.sleep(4000);

        driver.navigate().to("http://cybertekschool.com");
        driver.manage().window().maximize();

        Thread.sleep(2500);

        
        
        String title= driver.getTitle();
        String expectedTitle="Google";

        System.out.println("title = " + title);

        if(expectedTitle.equals(title)){
            System.out.println("test passed");
        }else{
            System.out.println("test failed");
        }
        
        driver.navigate().back();

        driver.navigate().refresh();

        driver.navigate().forward();

        driver.close();






    }
}
