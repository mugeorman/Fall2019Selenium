package com.automation.tests.PracticeMuge;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class March4thTaskAmazon_Ebay_Wiki {

    public static void main(String[] args) {

          ebayAmazonWiki();

    }

    public static void ebayAmazonWiki(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();

        driver.get("http://ebay.com");
        BrowserUtils.wait(3);

        driver.findElement(By.name("_nkw")).sendKeys("converse",Keys.ENTER);
        //driver.findElement(By.id("gh-btn")).click();
        System.out.println(driver.findElement(By.tagName("h1")).getText());

        BrowserUtils.wait(3);
        driver.navigate().to("http://amazon.com");
        BrowserUtils.wait(3);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("toys",Keys.ENTER);

        String title=driver.getTitle();
        if(title.contains("toys")){
            System.out.println("TEST PASSED");
        }else{
            System.out.println("TEST FAILED");
        }


        driver.navigate().to("http://wikipedia.org");
        driver.findElement(By.id("searchInput")).sendKeys("selenium webdriver",Keys.ENTER);
        driver.findElement(By.partialLinkText("Selenium (software)")).click();
        BrowserUtils.wait(3);

       String currentUrl= driver.getCurrentUrl();
       if(currentUrl.endsWith("Selenium_(software)")){
           System.out.println("TEST PASSED");
       }else{
           System.out.println("TEST FAILED");
       }


        BrowserUtils.wait(3);


        driver.quit();
    }



}
