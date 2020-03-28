package com.automation.tests.PracticeMuge.practicewebpagepractices;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadingDay5 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
       WebDriver driver= new ChromeDriver();

       driver.get("http://practice.cybertekschool.com/upload");

        BrowserUtils.wait(3);

        WebElement chooseFile=driver.findElement(By.id("file-upload"));

        String filePath=System.getProperty("user.dir")+"/pom.xml";

        chooseFile.sendKeys(filePath);

        WebElement upload= driver.findElement(By.id("file-submit"));
        upload.click();

        WebElement message=driver.findElement(By.tagName("h3"));
        String actual=message.getText();
        System.out.println("actual = " + actual);
        String expected="File Uploaded!";

        if(actual.equals(expected)){
            System.out.println("TEST PASSED");
        }else{
            System.out.println("TEST FAILED");
            System.out.println(actual);
            System.out.println(expected);
        }

        BrowserUtils.wait(3);
        driver.quit();











    }
}
