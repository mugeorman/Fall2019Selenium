package com.automation.pages.activities;

import com.automation.pages.AbstractPageBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CalendarsEventPage extends AbstractPageBase {



    @FindBy(css="[title='Create Calendar event']")
    private WebElement createCalendarEvent;


    public void clickToCreateCalendarEvent(){

        wait.until(ExpectedConditions.elementToBeClickable(createCalendarEvent)).click();


    }





}
