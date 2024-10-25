package com.colak.java8.localdate;

import java.time.LocalDate;
import java.time.temporal.ChronoField;

public class FromLocalDate {

    public static int getYear(LocalDate date) {
        return date.getYear();
    }

    public static int getWeek(LocalDate date) {
        return date.get(ChronoField.ALIGNED_WEEK_OF_YEAR);
    }

}
