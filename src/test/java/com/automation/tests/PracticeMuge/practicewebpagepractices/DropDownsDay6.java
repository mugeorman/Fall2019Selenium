package com.automation.tests.PracticeMuge.practicewebpagepractices;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropDownsDay6 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/dropdown");

        BrowserUtils.wait(3);

        Select simpleDropDown= new Select(driver.findElement(By.id("dropdown")));

        simpleDropDown.selectByValue("1");


        Select date= new Select(driver.findElement(By.id("day")));

        date.selectByValue("24");

        Select month=new Select(driver.findElement(By.id("month")));

        month.selectByVisibleText("April");

        Select year= new Select( driver.findElement(By.id("year")));

        year.selectByVisibleText("2016");

      List<WebElement> months= month.getOptions();

      for(WebElement eachMonth: months){
          eachMonth.click();
          System.out.println(eachMonth.getText());
      }



        Select state= new Select(driver.findElement(By.id("state")));

        state.selectByVisibleText("Florida");

        String selectedState= state.getFirstSelectedOption().getText();
        String actual= "Florida";
        if(selectedState.equals(actual)){
            System.out.println("PASSED");
        }else{
            System.out.println("FAILED");
        }


        System.out.println("=====MultiSelection=====");

        Select languages= new Select(driver.findElement(By.name("Languages")));

        System.out.println(languages.isMultiple());

        List<WebElement> languageOpt= languages.getOptions();

        for (WebElement echLang:languageOpt){
            echLang.click();
            BrowserUtils.wait(1);
            System.out.println(echLang.getText());

        }

        languages.deselectByVisibleText("Java");
        languages.deselectByVisibleText("JavaScript");
        BrowserUtils.wait(2);

        List<WebElement> allSelectedOpt= languages.getAllSelectedOptions();
        for (WebElement eachSelectedLang:allSelectedOpt){
            System.out.println(eachSelectedLang);
        }






        BrowserUtils.wait(3);
        driver.quit();



    }
}
