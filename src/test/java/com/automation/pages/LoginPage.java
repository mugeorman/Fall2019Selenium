package com.automation.pages;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.ConfigurationReader;
import com.automation.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(id="prependedInput")
    public WebElement username;
    // this and the below is same thing
    //public WebElement username2= Driver.getDriver().findElement(By.id("prependedInput"));

    @FindBy(id="prependedInput2")
    public WebElement password;

    @FindBy(id="_submit")
    public WebElement login;


    @FindBy(linkText="Forgot your password?")
    public WebElement forgotPassword;

    public LoginPage(){

        // to connect our webdriver , page class and page factory
        // PageFactory - used to use @FindBy annotations
        //PageFactory - helps to find elements easier
        PageFactory.initElements(Driver.getDriver(),this);
                                                      // or instead of this LoginPage.class

    }

    /**
     * Method to login, version #1
     * @param usernameValue
     * @param passwordValue
     */
    public void login(String usernameValue,String passwordValue){

        username.sendKeys(usernameValue);
        password.sendKeys(passwordValue, Keys.ENTER);
        BrowserUtils.wait(3);
    }

    /**
     * Method to login, version #2
     * Credentials will be retrieved from configuration.properties file
     */
    public void login(){

        username.sendKeys(ConfigurationReader.getProperty("store_manager"));
        password.sendKeys(ConfigurationReader.getProperty("password"),Keys.ENTER);
    }


}
