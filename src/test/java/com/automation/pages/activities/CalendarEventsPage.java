package com.automation.pages.activities;

import com.automation.pages.AbstractPageBase;
import com.automation.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CalendarEventsPage extends AbstractPageBase {



    @FindBy(css="[title='Create Calendar event']")
    private WebElement createCalendarEvent;


    @FindBy(className="select2-chosen")
    private WebElement owner;


    @FindBy(css="[id^='date_selector_oro_calendar_event_form_start']")
    private WebElement startDate;

    @FindBy(css="[id^='time_selector_oro_calendar_event_form_start']")
    private WebElement startTime;

    @FindBy(css="[id^='time_selector_oro_calendar_event_form_end']")
    private WebElement endTime;

    @FindBy(css="[class='grid-header-cell__label']")
    private List<WebElement> columnNames;

    @FindBy(css = "[id^='oro_calendar_event_form_title-uid']")
    private WebElement title;

    @FindBy (css = "iframe[id^='oro_calendar_event_form_description-uid']")  // xpath: //*[text()='Description']/../following-sibling::div//iframe
    private WebElement descriptionFrame;

    @FindBy(id = "tinymce")
    public WebElement descriptionTextArea;

    @FindBy(css = "[class='btn-group pull-right'] > button")
    private WebElement saveAndClose;

    @FindBy (xpath = "(//div[@class='control-label'])[1]")
    private WebElement generalInfoTitle;

    @FindBy (xpath = "//label[text()='Description']/following-sibling::div//div")
    private WebElement generalInfoDescription;



    public void enterCalendarEventTitle(String titleValue){
        BrowserUtils.wait(5);
        BrowserUtils.waitForPageToLoad(20);
        wait.until(ExpectedConditions.visibilityOf(title)).sendKeys(titleValue);



    }

    public void enterCalendarEventDescription(String description){
        BrowserUtils.wait(5);
        BrowserUtils.waitForPageToLoad(20);
        // WAIT UNTIL FRAME IS AVAILABLE AND SWITCH TO IT
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(descriptionFrame));
        descriptionTextArea.sendKeys(description);
        driver.switchTo().defaultContent(); //exit from the frame

    }

    public void clickOnSaveAndClose(){
        BrowserUtils.wait(5);
        BrowserUtils.waitForPageToLoad(20);
        wait.until(ExpectedConditions.elementToBeClickable(saveAndClose)).click();

    }

    public String getGeneralInfoTitleText(){
        BrowserUtils.wait(5);
        BrowserUtils.waitForPageToLoad(40);
        return  generalInfoTitle.getText();
    }

    public String getGeneralInfoDescriptionText(){
        BrowserUtils.wait(5);
        BrowserUtils.waitForPageToLoad(40);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='Description']/following-sibling::div//div")));
        return generalInfoDescription.getText();
    }

    public List<String> getColumnNames(){


        BrowserUtils.wait(5);
        BrowserUtils.waitForPageToLoad(20);
        //wait.until(ExpectedConditions.visibilityOf(columnNames.get(0)));
        return BrowserUtils.getTextFromWebElement(columnNames);
    }

    public String getStartTime(){

        BrowserUtils.wait(5);
        BrowserUtils.waitForPageToLoad(20);
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[id^='time_selector_oro_calendar_event_form_start']")));
        wait.until(ExpectedConditions.visibilityOf(startTime));
        return startTime.getAttribute("value");
    }

    public String getEndTime(){

        BrowserUtils.wait(5);
        BrowserUtils.waitForPageToLoad(20);
        wait.until(ExpectedConditions.visibilityOf(endTime));
        return endTime.getAttribute("value");
    }

    public String getOwnerName(){

        BrowserUtils.wait(5);
        BrowserUtils.waitForPageToLoad(20);
        //wait until element to be present in DOM
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("select2-chosen")));
        wait.until(ExpectedConditions.visibilityOf(owner));

        return owner.getText().trim();
    }


    public void clickToCreateCalendarEvent(){

        BrowserUtils.wait(5);
        BrowserUtils.waitForPageToLoad(20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[title='Create Calendar event']")));
        wait.until(ExpectedConditions.elementToBeClickable(createCalendarEvent)).click();
        BrowserUtils.waitForPageToLoad(20);


    }

    public String getStartDate(){
        BrowserUtils.wait(5);
        BrowserUtils.waitForPageToLoad(20);
        wait.until(ExpectedConditions.visibilityOf(startDate));
       // BrowserUtils.scrollTo(startDate);
        return startDate.getAttribute("value");

    }





}
