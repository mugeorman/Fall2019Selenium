package com.automation.tests.PracticeMuge.practicewebpagepractices;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class NoSelectDrpDownsDay6 {
    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/dropdown");

        BrowserUtils.wait(3);

        driver.findElement(By.id("dropdownMenuLink")).click();

        BrowserUtils.wait(2);

        //driver.findElement(By.linkText("Amazon")).click();

        List<WebElement> allLinks = driver.findElements(By.className("dropdown-item"));
        List<String> linkssss = new ArrayList<>();


        for (int i = 0; i < allLinks.size(); i++) {
            System.out.println(allLinks.get(i).getText() + " : " + allLinks.get(i).getAttribute("href"));
//             BrowserUtils.wait(1);
//             allLinks.get(i).click();
//             driver.navigate().back();
//             BrowserUtils.wait(1);
//            allLinks= driver.findElements(By.className("dropdown-item"));
            linkssss.add(allLinks.get(i).getAttribute("href"));
//
        }

            for(String each: linkssss) {
                driver.get(each);
                BrowserUtils.wait(2);
            }


            BrowserUtils.wait(3);
            driver.quit();

        }
    }

