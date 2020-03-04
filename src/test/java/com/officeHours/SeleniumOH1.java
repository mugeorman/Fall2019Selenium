package com.officeHours;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.*;
public class SeleniumOH1 {
    public static <Webdriver> void main(String[] args) {


        // Create arraylist of Strings - iterate over it

        ArrayList<String> keysToSearch = new ArrayList<>();
        keysToSearch.add("fruits");
        keysToSearch.add("veggies");
        keysToSearch.add("berries");
        Iterator<String> iterator = keysToSearch.iterator();
        //iterator() - return Iterator type which we can use with all iterator methods
        //[fruits, veggies, berries]
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        //print before modification
        // add * to each string and print again

        Iterator<String> iterator1= keysToSearch.iterator();
        while(iterator1.hasNext()){
            String item= iterator1.next();
            System.out.println(item);
            System.out.println("*" + item);

        }


        // create a map with <String, String>
        HashMap<String,String> personalInfo= new HashMap<>();
        personalInfo.put("name","Bryan");
        personalInfo.put("student_id","234234567");
        personalInfo.put("major","computer science");

        Iterator<String> mapIterator= personalInfo.keySet().iterator();

        while(mapIterator.hasNext()){

            String key= mapIterator.next();
            System.out.println(key+":"+personalInfo.get(key));
        }




        //====================
        //SELENIUM

        /**
         * id- unique (it is not always available) - we always want to use when it is available
         * class- classname
         * name
         * tag - every element will have a tag

         will only work with the link
         * linktext
         * partial linktext

         locator taht is using html(sytnax)
         * css
         * xpath


         <input id="global-enhancements-search-query" data-id="search-query"
         data-global-enhancements-search-input=""
         type="text" name="search_query"
         class="wt-input wt-input-btn-group__input
         global-enhancements-search-input-btn-group__input wt-pr-xs-7"
         placeholder="Search for items or shops" value="handbags"
         autocomplete="off" autocorrect="off" autocapitalize="off">

         input - tag
         key = "value" - attributes
         id="global-enhancements-search-query" - one of the attributes
         we can use id to locate the element

         name="search_query" - attribute - we can use name to locate the element


         class="wt-input wt-input-btn-group__input global-enhancements-search-input-btn-group__input wt-pr-xs-7"
         - we can use class to locate element

         When we want to find element it is always must be unique
         id- always unique
         name-tag-class are not unique very often


         */


        WebDriverManager.chromedriver().setup();

        WebDriver driver= new ChromeDriver();

        driver.get("http://etsy.com");

        WebElement seachBar= driver.findElement(By.id("global-enhancements-search-query"));

        //findElement() --> returns WebElement
        // as parameter we put By.locator("value of attribute")
        //                         (id, name, classname, class, ......)





        }
}
