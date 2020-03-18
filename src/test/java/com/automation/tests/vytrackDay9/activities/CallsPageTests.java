package com.automation.tests.vytrackDay9.activities;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Login as story manager
 * Go to Activities --> Calls
 * Verify that Log Call button is displayed
 */
public class CallsPageTests {

    private String storeManagerUserName="storemanager55";
    private String storeManagerPassword="UserUser123";

    private WebDriver driver;
    private Actions actions;
    private String URL= "https://qa2.vytrack.com/user/login";
    private By usernameBy= By.id("prependedInput");
    private By passwordBy= By.id("prependedInput2");
    private By activities=By.xpath("//span[@class='title title-level-1' and contains (text(),'Activities')]");
    private By logCallBtnBy=By.cssSelector("a[title='Log call']");

   @Test
   public void verifyLogCallButton(){

       WebElement logCallButton= driver.findElement(logCallBtnBy);

       assertTrue(logCallButton.isDisplayed());


   }

    @BeforeMethod
    public void setup(){

        driver= DriverFactory.createDriver("chrome");
        driver.get(URL);
        driver.manage().window().maximize();
        actions=new Actions(driver);

        BrowserUtils.wait(3);

        driver.findElement(usernameBy).sendKeys(storeManagerUserName);
        driver.findElement(passwordBy).sendKeys(storeManagerPassword, Keys.ENTER);

        BrowserUtils.wait(5);

        actions.moveToElement(driver.findElement(activities)).perform();
        BrowserUtils.wait(2);
        driver.findElement(By.linkText("Calls")).click();

        BrowserUtils.wait(5);

    }

    @AfterMethod
    public void tearDown(){

        driver.quit();
    }
}
