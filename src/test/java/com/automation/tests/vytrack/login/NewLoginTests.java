package com.automation.tests.vytrack.login;

import com.automation.pages.LoginPage;
import com.automation.tests.vytrack.AbstractTestBase;
import com.automation.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewLoginTests extends AbstractTestBase {


    @Test
    public void verifyPageTitle(){

        LoginPage loginPage= new LoginPage();

        loginPage.login();

        Assert.assertEquals(Driver.getDriver().getTitle(),"Dashboard");


    }

    @Test
    public void verifyWarningMessage(){

        LoginPage loginPage= new LoginPage();

        loginPage.login("absc","UserUser123");

        Assert.assertEquals(loginPage.getWarningMessageText(),"Invalid user name or password.");

    }



}
