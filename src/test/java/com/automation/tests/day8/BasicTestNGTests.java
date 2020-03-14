package com.automation.tests.day8;

import org.testng.Assert;
import org.testng.annotations.*;

public class BasicTestNGTests {

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("BEFORE SUITE");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("AFTER SUITE");
    }


    // runs only once before @BeforeClass and @BeforeMethod
    @BeforeTest
    public void beforeTest(){
        System.out.println("BEFORE TEST");
    }

    // runs only once AFTER @AfterClass and @AfterMethod
    @AfterTest
    public void afterTest(){
        System.out.println("AFTER TEST");
    }

    //Runs only once in the class @beforemethod and before any test
    // regardless on number of tests, it runs only once
    @BeforeClass
    public static void beforeClass(){
        // something that should be done only once in class before all tests
        System.out.println("BEFORE CLASS");
    }


    @AfterClass
    public static void afterClass(){
        // something that should be done only once in class after all tests
        System.out.println("AFTER CLASS");
    }

    //RUNS BEFORE EVERY TEST AUTOMATICALLY
    // works as a pre-condition or setup
    @BeforeMethod
    public void setup(){
    System.out.println("BEFORE METHOD");
    }

    // RUNS AUTOMATICALLY AFTER EVERY TEST
    @AfterMethod
    public void teardown(){
        System.out.println("AFTER METHOD");
    }

    @Test
    public void test1(){
        System.out.println("TEST 1");
        String expected="apple";
        String actual="apple";
        Assert.assertEquals(expected,actual);



    }

    @Test
    public void test2(){
        System.out.println("TEST 2");
        int num1=5;
        int num2=10;
        // it calls hard assertion
        // if assertion fails- it stops the execution(due to exception)
        Assert.assertTrue(num1<num2);

    }




}
