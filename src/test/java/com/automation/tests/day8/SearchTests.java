package com.automation.tests.day8;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SearchTests {

    private WebDriver driver;

    @Test
    public void googleSearchTest(){
        driver.get("http://google.com");
        driver.findElement(By.name("q")).sendKeys("java", Keys.ENTER);
        BrowserUtils.wait(2);
        //since every search item has a tag name <h3>
        //it's the easiest way to collect all of them
        List<WebElement> searchItems= driver.findElements(By.tagName("h3"));
        for(WebElement eachSearchItem: searchItems){
            System.out.println(eachSearchItem.getText());
            String var=eachSearchItem.getText();
            if(!var.isEmpty()){
                System.out.println(var);
                //verify that every search result contains java
                //is some of the search results
                // doesnt contain java word, it will fail the test
                Assert.assertTrue(var.toLowerCase().contains("java"));
            }
        }
    }

    @Test(description = "Search fro Java book on amazon")
    public void amazonSearchTest(){
        driver.get("http://amazon.com");
        // there is a chance that item is not visible
        // so we need to maximize window before clicking on it
        driver.manage().window().maximize();
        BrowserUtils.wait(5);

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java",Keys.ENTER);
        BrowserUtils.wait(5);

        // find all links inside h2 elements, because h2 element is not clickable itself /vasyl inkinde bunla calisti
        // hyperlinks must be clickable
        //List<WebElement> searchItems=driver.findElements(By.xpath("//h2//a"));
        List<WebElement> searchItems=driver.findElements(By.tagName("h2"));

        //click on the first item
        for(WebElement searchItem: searchItems){
            System.out.println("Title: "+searchItem.getText());
        }
        searchItems.get(0).click();

        BrowserUtils.wait(3);

        WebElement productTitle=driver.findElement(By.id("title"));
        String productTitleString= productTitle.getText();
        System.out.println(productTitleString);

        Assert.assertTrue(productTitleString.contains("Java"));

        //Vasyl in code u icin yazdik bunu benim h2 tag ile calisti ondan  onun kodlari coment out yaptim
        //so h2 elements are not clickable, even though they contain links
        //that's why, instead of collection all h2 elements
        //we collected all hyperlinks
        //every hyperlink represent some search item

    }

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
    }

    @AfterMethod
    public void teardown(){
        //close browser and destroy webdriver object
        driver.quit();
    }


}
