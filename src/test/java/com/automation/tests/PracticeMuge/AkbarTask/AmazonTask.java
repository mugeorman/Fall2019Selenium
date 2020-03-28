package com.automation.tests.PracticeMuge.AkbarTask;

//Lets assume you are searching for iphone on amazon
//many search results came in
//I want you to store all the price element on the result page
// in the meantime , I want you to store all the price text into List
// we can use findElements and getText together
// it will give us a List<String> that contains prices
// but we want to get List<Double>
// we need to parseDouble
// how do I get max price, min , average
// remove items above average



// get the unique prices
// each and every collection implementation classes has constructor to accept another Collection object
// to copy whatever is inside

//Set<Double> uniquePrices= new HashSet<>(prices);
//
// System.out.println("uniquePrices = " + uniquePrices);

// what if we want to have list that contains Product name, price
// List<Product> :
//Try to do this task at home : Create a product classes, 2 encapsulated fields name and price
// toString , Constructor
//Create List of Product , fill up this list , using actual search result you got from amazon

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.*;

public class AmazonTask {


    public static void main(String[] args) {


        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver= new ChromeDriver();

        driver.get("https://amazon.com");
        driver.manage().window().maximize();


        driver.findElement(By.cssSelector("[id='twotabsearchtextbox']")).sendKeys("iphone", Keys.ENTER);



        List<WebElement>allPrices=driver.findElements(By.xpath("//span [contains (text(),'$') ] [contains (text(),'.')]"));

        BrowserUtils.wait(3);

        List<Double> pricesDouble=new ArrayList<>();
        
        for (WebElement eachPrices:allPrices) {

            if(!eachPrices.getText().isEmpty()) {

                pricesDouble.add(Double.parseDouble(eachPrices.getText().replace("$", "")));
            }
        }

        System.out.println("pricesDouble = " + pricesDouble);


        // how do I get max price, min , average
        //maxprice:
        double maxPrice=pricesDouble.get(0);

        for (Double eachPrices:pricesDouble) {

            if(eachPrices>maxPrice){
                maxPrice=eachPrices;
            }

        }
        System.out.println("maxPrice = " + maxPrice);


       // double maxPr=Collections.max(pricesDouble);

        //min price:


        double minPrice=pricesDouble.get(0);
        for (Double eachPrices:pricesDouble) {
            if(eachPrices<minPrice){
                minPrice=eachPrices;
            }
        }
        System.out.println("minPrice = " + minPrice);

       // double minPr=Collections.min(pricesDouble);

       // remove items above average

        //average:

        double sum=0.0;

        for (Double eachPrices:pricesDouble) {

            sum+=eachPrices;
        }
          double average=sum/pricesDouble.size();
        System.out.println("average = " + average);

        //remove:

        pricesDouble.removeIf(each-> each>average);

        System.out.println("after removing above average pricesDouble = " + pricesDouble);

        driver.quit();
    }


}
