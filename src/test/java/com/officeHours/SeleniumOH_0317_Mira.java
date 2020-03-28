package com.officeHours;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.HashMap;

import static org.testng.Assert.assertEquals;

public class SeleniumOH_0317_Mira {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver= DriverFactory.createDriver("chrome");

        driver.get("https://qa3.vytrack.com/");

        WebElement username= driver.findElement(By.id("prependedInput"));
        username.sendKeys("salesmanager110");
        WebElement password=driver.findElement(By.id("prependedInput2"));
        password.sendKeys("UserUser123");
        WebElement login=driver.findElement(By.id("_submit"));
        login.click();

        Thread.sleep(2);

        WebElement dashboards=driver.findElement(By.xpath("//span[@class='title title-level-1'][1]"));

        Actions action=new Actions(driver);

        action.moveToElement(dashboards).perform();
          BrowserUtils.wait(2);
        WebElement contacts=driver.findElement(By.xpath("(//a[@href='/contact'])[5]"));
        BrowserUtils.wait(6);
        contacts.click();

        BrowserUtils.wait(6);

        WebElement createContact=driver.findElement(By.linkText("Create Contact"));

        BrowserUtils.wait(3);
        createContact.click();

        BrowserUtils.wait(3);

        String currentTitle=driver.getTitle();

        String expected="Create Contact - Contacts - Customers";

       if(currentTitle.equalsIgnoreCase(expected)){
           System.out.println("passed");
       }else{
           System.out.println("failed");
       }


        HashMap<String, String> contact1= new HashMap<>();
       contact1.put("First Name","Metin");
       contact1.put("Last Name","Kazmirci");
       contact1.put("Phones","954-654-9898");
       contact1.put("Country","United States");
       contact1.put("States","VA");
       contact1.put("Street","400 Main Street");
       contact1.put("City","Tysons");
       contact1.put("Zip Code","22102");
       contact1.put("Sales Group","true");

        System.out.println("contact1 informations = " + contact1);

        WebElement saveAndClose=driver.findElement(By.xpath("//button[@type='submit'][1]"));

        BrowserUtils.wait(4);

        saveAndClose.click();








       // driver.quit();





    }





}
