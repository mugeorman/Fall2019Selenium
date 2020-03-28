package com.automation.tests.day13;

import org.testng.annotations.Test;

public class SystemProperties {



    @Test
    public void test(){

        // C:\Users\memet\IdeaProjects\Fall2019Selenium\pom.xml copy path from right click way
        //System.getProperty("user.dir")+"/pom.xml"   system way

        System.out.println(System.getProperty("user.dir"));
        System.out.println(System.getProperty("os.name"));
        //flexible path to downloads folder
        //System.getProperty("user.home")+/Downloads
        System.out.println(System.getProperty("user.home"));
        // for windows , use \\ instead of /
        String pathToDownloads=System.getProperty("user.home")+"/Downloads";

        System.out.println("pathToDownloads = " + pathToDownloads);

        System.out.println(System.getProperty("os.arch"));



    }






}
