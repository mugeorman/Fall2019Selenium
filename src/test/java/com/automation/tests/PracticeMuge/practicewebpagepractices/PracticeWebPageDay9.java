package com.automation.tests.PracticeMuge.practicewebpagepractices;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class PracticeWebPageDay9 {

    private WebDriver driver;
    private String URL="http://practice.cybertekschool.com/registration_form";
    private By firstName=By.name("firstname");
    private By lastName=By.xpath("//input[@name='lastname']");
    private By username=By.name("username");
    private By email=By.name("email");
    private By password= By.name("password");
    private By phone=By.cssSelector("input[name='phone']");

    private By maleBy= By.cssSelector("input[value='male']");
    private By femaleBy=By.cssSelector("input[value='female']");
    private By otherBy= By.cssSelector("input[value='other']");

    private By dateOfBirth=By.name("birthday");
    private By department= By.name("department");
    private By jobTitle=By.name("job_title");

    private By cPlusPlus=By.xpath("//label[text()='C++']"); // //label[text()='C++']/preceding-sibling::input
    private By java=By.xpath("//label[text()='Java']"); // //label[text()='Java']/preceding-sibling::input
    private By javaScript=By.xpath("//label[text()='JavaScript']"); // //label[text()='JavaScript']/preceding-sibling::input
    private By signUp=By.id("wooden_spoon");




    @Test
    public void test1(){
      driver.findElement(firstName).sendKeys("Muge");
      driver.findElement(lastName).sendKeys("Orman");
      driver.findElement(username).sendKeys("mugeorman");
      driver.findElement(email).sendKeys("mugeorman@mynet.com");
      driver.findElement(password).sendKeys("14725896");
      driver.findElement(phone).sendKeys("954-700-7070");
      driver.findElement(femaleBy).click();
      driver.findElement(dateOfBirth).sendKeys("09/06/1949");

      Select departmentSelect=new Select(driver.findElement(department));
      departmentSelect.selectByVisibleText("Mayor's Office");

      Select jobTitleSelect= new Select(driver.findElement(jobTitle));
      jobTitleSelect.selectByVisibleText("SDET");

      driver.findElement(java).click();

      driver.findElement(signUp).click();

      BrowserUtils.wait(5);

      String actual=driver.findElement(By.tagName("p")).getText();
      String expected="You've successfully completed registration!";

      assertEquals(actual,expected);
    }

    @Test
    public void verifyFirstNameLengthTest(){

        driver.findElement(firstName).sendKeys("a");
        BrowserUtils.wait(3);
        String expected="first name must be more than 2 and less than 64 characters long";
        String actual=driver.findElement(By.xpath("//small[@data-bv-result='INVALID']")).getText();

        assertEquals(actual,expected);
        assertTrue(driver.findElement(By.xpath("//small[@data-bv-result='INVALID']")).isDisplayed());

    }



    @BeforeMethod
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
        BrowserUtils.wait(3);
    }

    @AfterMethod
    public void tearDown(){

        driver.quit();
    }
}
