package com.automation.tests.PracticeMuge;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Day11JavaScriptPractice {


    private WebDriver driver;


    @BeforeMethod
    public void setup(){

        WebDriverManager.chromedriver().version("79").setup();
        driver=new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().maximize();


    }

    @Test
    public void verifyTitle(){


        // neden bos cikiyor bununla bir bak gettext
//        WebElement title=driver.findElement(By.xpath("//title[text()='Practice']"));
//        String actual=title.getText();

        // getTitle() way:
 //      String actual=driver.getTitle();

        //JavaScript way:

        JavascriptExecutor js= (JavascriptExecutor) driver;
        String actual=js.executeScript("return document.title").toString();

        String expected="Practice";


        Assert.assertEquals(actual,expected);

    }

    @Test
    public void clickTest(){


        WebElement link= driver.findElement(By.linkText("Multiple Buttons"));
        //link.click();

        JavascriptExecutor js= (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click()",link);
       // js.executeScript("document.getElementById('disappearing_button')")

        WebElement button6=driver.findElement(By.id("disappearing_button"));

        js.executeScript("arguments[0].click()",button6);

        //String actual1=driver.findElement(By.xpath("//p[@id='result']")).getText();
        String expected="Now it's gone!";

        //or
        // sor boyle yapabilir miyim ??
        String actual2=js.executeScript("return document.getElementById('result').textContent").toString();

        Assert.assertEquals(actual2,expected);
    }



    @Test
    public void textInputTest(){

        driver.findElement(By.linkText("Form Authentication")).click();
         BrowserUtils.wait(3);

         WebElement username=driver.findElement(By.name("username"));
         WebElement password= driver.findElement(By.name("password"));

         JavascriptExecutor js= (JavascriptExecutor) driver;

         js.executeScript("arguments[0].setAttribute('value','tomsmith')",username);

         js.executeScript("arguments[0].setAttribute('value','SuperSecretPassword')",password);

         js.executeScript("arguments[0].click()",driver.findElement(By.id("wooden_spoon")));

         BrowserUtils.wait(4);

      String expected="Welcome to the Secure Area. When you are done click logout below.";

      String subheader=js.executeScript("return document.getElementsByClassName('subheader')[0].textContent").toString();

      Assert.assertEquals(subheader,expected);

      //with classic way
      //String actual=driver.findElement(By.xpath("//h4[@class='subheader']")).getText();
      //Assert.assertEquals(actual,expected);




    }


    @Test
    public void scrollToElement(){

        WebElement link=driver.findElement(By.linkText("Cybertek School"));

        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)",link);


    }


    @Test
    public void scrollTest(){


        driver.navigate().to("http://practice.cybertekschool.com/infinite_scroll");

        JavascriptExecutor js= (JavascriptExecutor) driver;

        for (int i = 0; i <15 ; i++) {

            js.executeScript("window.scrollBy(0,100)");
            BrowserUtils.wait(1);
        }
    }

    @AfterMethod
    public void teardown(){
        BrowserUtils.wait(2);
        driver.quit();
    }




}
