package com.colak.java8.yearmonth;

import java.time.YearMonth;
import java.time.ZoneId;
import java.util.Date;

public class DateToYearMonthTest {

    public static YearMonth toYearMonth(Date date) {
        return YearMonth.from(date.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate());
    }
}
