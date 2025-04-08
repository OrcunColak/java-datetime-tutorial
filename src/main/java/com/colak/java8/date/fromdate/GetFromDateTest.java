package com.colak.java8.date.fromdate;

import java.util.Calendar;
import java.util.Date;

public class GetFromDateTest {

    public static void main(String[] args) {
        Date date = new Date();
        int year = getYear(date);
        System.out.println("year = " + year);

        int week = getWeek(date);
        System.out.println("week = " + week);
    }

    public static int getYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        return calendar.get(Calendar.YEAR);
    }

    public static int getWeek(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        return calendar.get(Calendar.WEEK_OF_YEAR);
    }
}