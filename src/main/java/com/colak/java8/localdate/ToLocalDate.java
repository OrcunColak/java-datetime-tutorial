package com.colak.java8.localdate;

import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.Locale;

public class ToLocalDate {

    public static LocalDate from(int year, int week) {
        WeekFields weekFields = WeekFields.of(Locale.getDefault());

        return LocalDate.now()
                .withYear(year)
                .with(weekFields.weekOfYear(), week)
                .with(weekFields.dayOfWeek(), 1);
    }
}
