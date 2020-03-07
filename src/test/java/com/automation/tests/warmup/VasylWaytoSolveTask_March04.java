package com.automation.tests.warmup;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VasylWaytoSolveTask_March04 {
    static WebDriver driver;

    public static void main(String[] args) throws Exception {


        ebayTest();
        amazonTest();
        wikiTest();


    }


    /**
     * Go to ebay
     * enter search term
     * click on search button
     * print number of results
     */
    public static void ebayTest() {

        driver = DriverFactory.createDriver("chrome");
        driver.get("http://ebay.com");
        driver.findElement(By.id("gh-ac")).sendKeys("java book");
        driver.findElement(By.id("gh-btn")).click();
        WebElement searchResults = driver.findElement(By.tagName("h1"));
        System.out.println(searchResults.getText().split(" ")[0]);
        driver.quit();
    }


    /*
    go to amazon
enter search term
click on search button
verify title contains search term
     */
    public static void amazonTest(){

        driver=DriverFactory.createDriver("chrome");
        driver.get("http://amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("java book", Keys.ENTER);
        String title= driver.getTitle();

//       WebElement result=driver.findElement(By.className("a-section a-spacing-small a-spacing-top-small"));
//       String numberResult= result.getText();
//        System.out.println("numberResult = " + numberResult);


        if(title.contains("java book")){
            System.out.println("TEST PASSED");
        }else{
            System.out.println("TEST FAILED");
        }

        driver.quit();

    }
/*
Go to wikipedia.org
enter search term `selenium webdriver`
click on search button
search for `Selenium (software)`
verify url ends with `Selenium_(software)`
 */
    public static  void wikiTest() throws Exception{

        driver=DriverFactory.createDriver("chrome");
        driver.get("http://en.wikipedia.org/wiki/Main_Page");
        driver.findElement(By.id("searchInput")).sendKeys("Selenium webdriver",Keys.ENTER);
        driver.findElement(By.partialLinkText("Selenium (software)")).click();

        Thread.sleep(4000);

        String link= driver.getCurrentUrl();

        if(link.endsWith("Selenium_(software)")){
            System.out.println("TEST PASSED");
        }else{
            System.out.println("TEST FAILED");
        }

         driver.quit();
    }

}
