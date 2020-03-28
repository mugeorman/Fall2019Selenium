package com.automation.tests.PracticeMuge;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TugceTwitter {

    public static void main(String[] args) throws Exception {

            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.get("http://twitter.com");
            driver.manage().window().maximize();
            WebElement username = driver.findElement(By.name("session[username_or_email]"));
            username.sendKeys("mugeorman@gmail.com");
            WebElement password = driver.findElement(By.name("session[password]"));
            password.sendKeys("aysemuge");
            WebElement login = driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div/main/div/div/div/div[1]/div[1]/form/div/div[3]/div"));
            login.click();
            BrowserUtils.wait(3);
            WebElement messages = driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div/header/div/div/div/div/div[2]/nav/a[4]/div"));
            messages.click();
            WebElement newMessage= driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div/main/div/div/div/section[1]/div[1]/div/div/div/div/div[2]/a"));
            newMessage.click();
            Thread.sleep(5000);
            WebElement search=driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[1]/div/div/div/div/div[2]/div[2]/div/div[2]/div/div/div/div/div/form/div[1]/div/div/div[2]/input"));
            search.sendKeys("tugceydgnplt");
//            WebElement tugce= driver.findElement(By.linkText("Tuğçe Polat"));           //(By.xpath("//*[@id=\"typeaheadDropdown-10\"]/div[2]/div[1]/div/div/div[2]"));
//            tugce.click();
            WebElement next=driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[1]/div/div/div/div/div[2]/div[2]/div/div[1]/div/div/div/div[3]/div/div/div/span/span"));
            next.click();
            Thread.sleep(5000);



            driver.quit();

        }
}