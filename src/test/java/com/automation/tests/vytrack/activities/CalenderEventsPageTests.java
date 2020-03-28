package com.automation.tests.vytrack.activities;

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

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import static org.testng.Assert.*;

/**
 * TASK
 *
 * Scenario: Verify for store manager
 *
 * Login as story manager
 * Go to Activities --> Calendar Events
 * Verify that Create Calendar Event button is displayed
 */
public class CalenderEventsPageTests {


    private String storeManagerUserName="storemanager55";
    private String storeManagerPassword="UserUser123";

    private WebDriver driver;
    private Actions actions;
    private String URL= "https://qa2.vytrack.com/user/login";
    private By usernameBy= By.id("prependedInput");
    private By passwordBy= By.id("prependedInput2");
    private By activities=By.xpath("//span[@class='title title-level-1' and contains (text(),'Activities')]");
    private By calendarEventsBy= By.linkText("Calendar Events");
    private By calendarEventBttnBy=By.cssSelector("a[title='Create Calendar event']");
    private By currentUserBy=By.cssSelector("#user-menu > a");
    private By ownerBy=By.className("select2-chosen"); // By.cssSelector("#s2id_oro_calendar_event_form_calendar")
    private By titleBy=By.cssSelector("[name='oro_calendar_event_form[title]']");
    private By startDateBy = By.cssSelector("[id*='date_selector_oro_calendar_event_form_start-uid']");
    private By startTimeBy = By.cssSelector("[id*='time_selector_oro_calendar_event_form_start-uid']");


    @Test
    public void verifyCalendarEventButton(){

        WebElement calendarButton= driver.findElement(calendarEventBttnBy);

        assertTrue(calendarButton.isDisplayed());

    }

    /**
     * //in the @BeforeMethod
     * Test Case: Default options
     * Login as sales manager
     * Go to Activities --> Calendar Events
     *
     *
     * Click on Create Calendar Event
     * Default owner name should be current user
     * Default title should be blank
     * Default start date should be current date
     * Default start time should be current time
     */

    @Test (description = "Default options")
    public void verifyDefaultValues(){
        //Click on Create Calendar Event
        driver.findElement(calendarEventBttnBy).click();

        BrowserUtils.wait(4);
        // Default owner name should be current user
        String currentUserName=driver.findElement(currentUserBy).getText().trim();

        WebElement owner=driver.findElement(ownerBy);

        String defaultOwnerName=owner.getText().trim();

        BrowserUtils.wait(4);

        assertEquals(currentUserName,defaultOwnerName);

        //* Default title should be blank
        WebElement titleElement=driver.findElement(titleBy);
        assertTrue(titleElement.getAttribute("value").isEmpty());


        //* Default start date should be current date
        String expectedDate= LocalDate.now().format(DateTimeFormatter.ofPattern("MMM dd, yyyy"));
        String actualDate = driver.findElement(startDateBy).getAttribute("value");

        assertEquals(actualDate , expectedDate);

        String expectedTime = LocalTime.now(ZoneId.of("GMT-7")).format(DateTimeFormatter.ofPattern("h:m a"));
        String actualTime = driver.findElement(startTimeBy).getAttribute("value");

        assertEquals(actualTime,expectedTime);


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
        driver.findElement(calendarEventsBy).click();

        BrowserUtils.wait(5);

    }

    @AfterMethod
    public void tearDown(){

        driver.quit();
    }
}