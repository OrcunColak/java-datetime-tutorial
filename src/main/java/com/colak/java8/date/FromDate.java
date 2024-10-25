package com.colak.java8.date;

import java.util.Calendar;
import java.util.Date;

public class FromDate {

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
