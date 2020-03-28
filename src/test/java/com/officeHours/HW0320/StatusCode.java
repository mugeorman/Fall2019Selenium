package com.officeHours.HW0320;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class StatusCode {

    private WebDriver driver;

    @BeforeMethod
    public void setup(){

        driver= DriverFactory.createDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");

    }

//    @Test(priority = 0, description = "Verify that following message is displayed: 'This page returned 500 status code'")
//    public void testCase12() {


    //Test Case #12
       /*
        Step 1. Go to "https://practice-cybertekschool.herokuapp.com"
        Step 2. And click on "Status Codes".
        Step 3. Then click on "500".
        Step 4. Verify that following message is displayed: "This page returned a 500 status code"
       */
    //Step 1
//        WebDriver driver = BrowserFactory.getDriver("chrome");
//        driver.get("https://practice-cybertekschool.herokuapp.com");
    //Step 2
    /*
       xpath :
      //a[text()='Status Codes']
      //a[contains(text(),'Status Codes')]
      //ul/li[46]
      //a[@href="/status_codes"]
       linkText : lintText("Status Codes")
       partialLinkText: partialLintText("Status Codes")
      partiallinkText("Status")
      partiallinkText("Codes")
      CssSelector
      [href="/status_codes"]
    */
//        WebElement statusCodeLink = driver.findElement(By.linkText("Status Codes"));
//        statusCodeLink.click();
//        //Step 3
//        WebElement statusCode = driver.findElement(By.linkText("500"));
//        statusCode.click();
//        // Step 4
//        String expectedMessage = "This page returned a 500 status code";
//        WebElement displayedMessageElement = driver.findElement(By.xpath("//p"));
//        String actualMessage = displayedMessageElement.getText();
//
//        if (actualMessage.contains(expectedMessage)) {
//            System.out.println("Passed");
//        } else {
//            System.out.println("FAILED");
//        }
//        driver.close();
//
//    }


//    @Test(priority = 1, description = "Verify that following message is displayed: 'This page returned 404 status code'")
//    public void testCase11(){

    //Step 1
//        WebDriver driver = BrowserFactory.getDriver("chrome");
//        driver.get("https://practice-cybertekschool.herokuapp.com");
//
//        WebElement statusCodeLink = driver.findElement(By.linkText("Status Codes"));
//        statusCodeLink.click();
//Step 3
//        WebElement statusCode = driver.findElement(By.linkText("404"));
//        statusCode.click();
// Step 4
//        String expectedMessage = "This page returned a 404 status code";
//        WebElement displayedMessageElement = driver.findElement(By.xpath("//p"));
//        String actualMessage = displayedMessageElement.getText();

//        if (actualMessage.contains(expectedMessage)) {
//            System.out.println("Passed");
//        } else {
//            System.out.println("FAILED");
//        }
//
//        driver.quit();
//   }


    /**
     * DataProvider--->> Provides data to test cases
     *
     */

    @DataProvider(name="testData")
    public static Object [] testData(){

        return new Object []{"200","301","404","500"};
    }

    /*
        DataProvider returns data in form of single dimensional Object array(Object [])
        or 2 dimensional Object array(Object [][])

        Object[]---> When you have only 1 parameter
        Object [] [] ---> when you have 2+ parameters
        cannot carry primitive data(int, byte, double..) but it can carry
        wrapper class objects(Integer,Double,Byte..)

     */

    @Test(dataProvider = "testData")
    public void statusCodes(String code){

        //404, 500 should be the parameters



        WebElement statusCodeLink = driver.findElement(By.linkText("Status Codes"));
        statusCodeLink.click();

        WebElement statusCode = driver.findElement(By.linkText(code));  // dynamic area we must change it
        statusCode.click();

        String expectedMessage = "This page returned a "+code+" status code";
        WebElement displayedMessageElement = driver.findElement(By.xpath("//p"));
        String actualMessage = displayedMessageElement.getText();

        /*
            The following is HARD assertion and contains a message
            that is displayed only if the assertion fails
            When a HARD assertion fails the rest of the script is skipped
         */
        Assert.assertTrue(actualMessage.contains(expectedMessage),"The status code does not exist");


    }

    @AfterMethod
    public void teardown(){

        driver.close();
    }


}
