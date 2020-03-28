package com.automation.tests.PracticeMuge;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day11WebTablesPractice {


    private WebDriver driver;


    @Test
    public void getColumnNames(){

        List<WebElement> columnNames=driver.findElements(By.xpath("//table[@id='table1']//th"));
        List<String> actual=new ArrayList<>();

        for(WebElement eachCol:columnNames){

            actual.add(eachCol.getText());

        }

        List<String> expected= Arrays.asList("Last Name","First Name","Email","Due","Web Site","Action");

        Assert.assertEquals(actual,expected);

    }


    @Test
    public void countOfRows(){

       List<WebElement> rows= driver.findElements(By.xpath("//table[@id='table1']//tbody//tr"));

       Assert.assertEquals(rows.size(),4);



    }


    @Test
    public void getWebsites(){

        List<WebElement> allWebSites=driver.findElements(By.xpath("//table[@id='table1']//tbody//td[5]"));
        
//        for (WebElement each:allWebSites){
//
//            System.out.println("each = " + each.getText());
//
//        }

        System.out.println(BrowserUtils.getTextFromWebElement(allWebSites));
    }


    @Test
    public void deleteRowTest(){


         List<WebElement> rowsBefore= driver.findElements(By.xpath("//table[1]//tbody//tr"));

        driver.findElement(By.xpath("//table[1]//tbody//td[3]/following-sibling::td/a[text()='delete']")).click();

        List<WebElement> rowsAfter=driver.findElements(By.xpath("//table[1]//tbody//tr"));

        Assert.assertEquals(rowsAfter.size(),3);

        Assert.assertTrue(driver.findElements(By.xpath("//table[1]//td[text()='jsmith@gmail.com']")).isEmpty());
    }




    @BeforeMethod
    public void setup(){

        DriverFactory.createDriver("chrome");
//        ChromeOptions chromeOptions=new ChromeOptions();
//        chromeOptions.setHeadless(false);
       // driver=new ChromeDriver(chromeOptions);
        driver=new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/tables");
        driver.manage().window().maximize();
        BrowserUtils.wait(2);


    }


    @AfterMethod
    public void teardown(){

        driver.quit();


    }


}
