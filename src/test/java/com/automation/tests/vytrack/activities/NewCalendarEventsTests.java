package com.automation.tests.vytrack.activities;

import com.automation.pages.LoginPage;
import com.automation.pages.activities.CalendarsEventsPage;
import com.automation.tests.vytrack.AbstractTestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewCalendarEventsTests extends AbstractTestBase {

   /*
    * Test Case: Default options
    * Login as sales manager
    * Go to Activities --> Calendar Events
    * Click on Create Calendar Event
    * Default owner name should be current user
    */

    @Test
    public void defaultOptionsTest(){

        LoginPage loginPage=new LoginPage();
        CalendarsEventsPage calendarsEventsPage=new CalendarsEventsPage();

        loginPage.login();
        calendarsEventsPage.navigateTo("Activities","Calendar Events");
        calendarsEventsPage.clickToCreateCalendarEvent();

        Assert.assertEquals(calendarsEventsPage.getOwnerName(),calendarsEventsPage.getCurrentUserName());



    }






}
