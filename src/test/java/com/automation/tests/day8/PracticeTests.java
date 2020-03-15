package com.automation.tests.day8;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

/*####TASK for 10 minutes: until 4:17
Create a class called PracticeTests
- setup before/after methods
	- in before method. instantiate webdriver and navigate to: http://practice.cybertekschool.com/
	- in after method - just close webdriver.
- create a test called loginTest
	- go to “Form Authentication” page
	- enter valid credentials
	- verify that following sub-header message is displayed: “Welcome to the Secure Area. When you are done click logout below.”

 */
public class PracticeTests {

    private WebDriver driver;


    @Test
    public void loginTest(){
        driver.findElement(By.linkText("Form Authentication")).click();
        BrowserUtils.wait(3);
        driver.findElement(By.name("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");

        BrowserUtils.wait(2);
        driver.findElement(By.id("wooden_spoon")).click();

        String expectedMessage="Welcome to the Secure Area. When you are done click logout below.";
        String actualMessage= driver.findElement(By.className("subheader")).getText();

        Assert.assertEquals(expectedMessage,actualMessage,"Sub-header message is not matching");

         //driver.findElement(By.linkText("Logout")).click();

    }


    /*
     *   TASK for 5 minutes
     *  Given user is on the practice landing page
     *  When user navigates to "Forgot password" page
     *  Then user enters his email
     *  And clicks "Retrieve password" button
     *  Then user verifies that message "Your e-mail's been sent!" is displayed
     */


    @Test
     public void forgotPasswordTest(){
        driver.findElement(By.linkText("Forgot Password")).click();

         BrowserUtils.wait(3);

         driver.findElement(By.name("email")).sendKeys("emaynell8f@google.es");
         driver.findElement(By.id("form_submit")).click();

         String expectedMessage= "Your e-mail's been sent!";
         String actualMessage=driver.findElement(By.name("confirmation_message")).getText();

         Assert.assertEquals(expectedMessage,actualMessage,"message is not matching");

     }

    /**
     * TASK for 5 minutes
     * Given user is on the practice landing page
     * When user navigates to "Checkboxes" page
     * And clicks on checkbox #1
     * Then user verifies that checkbox #1 is selected
     */

     @Test
     public void checkboxTest1(){

        driver.findElement(By.linkText("Checkboxes")).click();

        BrowserUtils.wait(3);

        // locator for specific checkbox , xpath : //input[1] , cssSelector : input:nth-of-type(1)
        //  //input[@type=“checkbox”][1]
        //   collect all checkboxes
        List<WebElement> checkBoxes= driver.findElements(By.tagName("input"));

        WebElement checkbox1= checkBoxes.get(0);
        checkBoxes.get(0).click();

        Assert.assertTrue(checkbox1.isSelected(), "Checkbox #1 is not selected");



     }


    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        //INTERVIEW QUESTION: HOW TO HANDLE SSL(Secure Sockets Layer) ISSUES IN SELENIUM?
        //ChromeOptions - use to customize browser for tests
       // ChromeOptions chromeOptions = new ChromeOptions();
        //to ignore "Your connection is not private issue"
        //chromeOptions.setAcceptInsecureCerts(true);
       // driver = new ChromeDriver(chromeOptions);

        driver=new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void teardown(){
        //close browser and destroy webdriver object
        driver.quit();
    }






}
