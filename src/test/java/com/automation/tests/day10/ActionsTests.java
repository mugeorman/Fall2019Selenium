package com.automation.tests.day10;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionsTests {

    private WebDriver driver;
    private Actions actions;

    @BeforeMethod
    public void setup(){
        driver= DriverFactory.createDriver("chrome");
        actions=new Actions(driver);
    }

    @Test
    public void hoverOnImage(){
        driver.get("http://practice.cybertekschool.com/hovers");
        driver.manage().window().maximize();
        BrowserUtils.wait(3);

        WebElement img1=driver.findElement(By.xpath("(//img)[1]"));
        WebElement img2=driver.findElement(By.xpath("(//img)[2]"));
        WebElement img3=driver.findElement(By.xpath("(//img)[3]"));

        // build() is needed when you have couple of actions
        //builder pattern => you put one method then you can take action
        // builder pattern == chaining methods
       //what is build?
       //if you have multiple actions you have to put build
       //to combine a couple of actions.
       //build() is needed when you have couple of actions
       //build combines the action; perform; starts the action
      //in this example; first we move to one image then second so we used build
      //always end with perform
      //perform does not click, it starts the action, execute the event
      //you can perform click, drag and drop etc
      //actions class has different implementations
      //moveToElement returns instance of action class that's why we can chain them
      //   always end with perform()
      //  moveToElement returns instance of action class that's why we can chain them
        actions.moveToElement(img1).pause(1000).moveToElement(img2).
                pause(1000).moveToElement(img3).build().perform();


        //hover on the first image
        //verify that" name: user1" is displayed

        actions.moveToElement(img1).perform();
         WebElement imgText1=driver.findElement(By.xpath("//h5[text()='name: user1']"));
        Assert.assertTrue(imgText1.isDisplayed());

        //move to second image
        BrowserUtils.wait(2);

        actions.moveToElement(img2).perform();
        WebElement imgText2=driver.findElement(By.xpath("//h5[text()='name: user2']"));
        Assert.assertTrue(imgText2.isDisplayed());
    }

    @Test
    public void jqueryMenuTest(){
        driver.get("http://practice.cybertekschool.com/jqueryui/menu#");

        // hover on "enabled"
        // hover on downloads
        //click PDF

        WebElement enabled=driver.findElement(By.cssSelector("[id='ui-id-3']"));
        WebElement downloads= driver.findElement(By.cssSelector("[id='ui-id-4']"));
        WebElement  pdf=driver.findElement(By.cssSelector("[id='ui-id-5']"));

        actions.moveToElement(enabled).pause(1000).moveToElement(downloads).pause(1000).click(pdf).build().perform();
        BrowserUtils.wait(2);



    }
    @Test
    public void dragAndDropTest(){

        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        driver.manage().window().maximize();
        BrowserUtils.wait(5);

        //click on accept cookies
        driver.findElement(By.xpath("//button[text()='Accept Cookies']")).click();
        BrowserUtils.wait(3);

        WebElement earth=driver.findElement(By.id("droptarget"));
        WebElement moon =driver.findElement(By.id("draggable"));

        BrowserUtils.wait(3);

        actions.dragAndDrop(moon, earth).perform();
       // actions.clickAndHold(moon).pause(2000).moveToElement(earth).pause(1000).release().build().perform();

        String expected="You did great!";
        String actual= earth.getText();


        Assert.assertEquals(actual,expected);

    }


    @AfterMethod
    public void teardown(){
        BrowserUtils.wait(3);
        driver.quit();
    }

}
