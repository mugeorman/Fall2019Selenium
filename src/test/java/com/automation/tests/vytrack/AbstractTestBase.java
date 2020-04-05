package com.automation.tests.vytrack;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.ConfigurationReader;
import com.automation.utilities.Driver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

public abstract class AbstractTestBase {  // day 14 we create that

    // will be visible in the subclass, regardless on subclass location(same package or not)
   // protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;

    protected ExtentReports report;
    protected ExtentHtmlReporter htmlReporter;
    protected ExtentTest test;


    //@Optional - to make parameter optional
    // if you don't specify it , testng will require to specify this parameter for every test , in xml runner
    @BeforeTest
    @Parameters("reportName")
    public void setupTest(@Optional String reportName){

        System.out.println("Report name: "+reportName);
        reportName=reportName==null?"report.html":reportName+".html";

       report=new ExtentReports();

       String reportPath="";
       //location of report file
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            reportPath = System.getProperty("user.dir") + "\\test-output\\"+reportName;
        } else {
            reportPath = System.getProperty("user.dir") + "/test-output/"+reportName;
        }

        //is a HTML report itself
       htmlReporter= new ExtentHtmlReporter(reportPath);
       //add it to the reporter
        report.attachReporter(htmlReporter);
        htmlReporter.config().setReportName("VYTRACK test Automation Results");

    }

    @AfterTest
    public void afterTest(){
        // to release the report
        report.flush();


    }


    @BeforeMethod
    public void setup(){

        String URL= ConfigurationReader.getProperty("qa1");
      //  driver=Driver.getDriver();
        Driver.getDriver().get(URL);
        Driver.getDriver().manage().window().maximize();
        wait=new WebDriverWait(Driver.getDriver(),25);  //   wait=new WebDriverWait(Driver.getDriver(),15);
        actions=new Actions(Driver.getDriver()); // actions=new Actions(Driver.getDriver());

    }


    @AfterMethod
    public void teardown(ITestResult iTestResult) throws Exception{
        //ITestResult class describes the result of a test
            //if test failed , take a screenshot
        if(iTestResult.getStatus()==ITestResult.FAILURE){
           String screenshotPath= BrowserUtils.getScreenshot(iTestResult.getName());

            test.fail(iTestResult.getName());//attach test name that failed
            BrowserUtils.wait(4);
            test.addScreenCaptureFromPath(screenshotPath,"Failed");// attach screenshot
            test.fail(iTestResult.getThrowable());// attach console output
        }

       // BrowserUtils.wait(1);
        Driver.closeDriver();

    }






}
