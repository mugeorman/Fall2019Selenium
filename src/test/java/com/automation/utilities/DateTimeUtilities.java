package com.automation.utilities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateTimeUtilities {

    /**
     * This method returns current date as a String
     * provide a format as a parameter
     *
     * MM-to specify month like : 01, 02,03..
     * MMM -Jan , Feb, Mar
     *
     * dd- to specify day like: 01,02,03...
     *
     * yyyy - to specify year like: 2010, 2020...
     *
     * @param format for example MMM dd, yyyy
     * @return current date as a string
     */


    public static String getCurrentDate(String format){

        return LocalDate.now().format(DateTimeFormatter.ofPattern(format));

    }





}
