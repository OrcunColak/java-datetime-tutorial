package com.colak.java8.date.todate;

import java.time.YearMonth;
import java.time.ZoneId;
import java.util.Date;

public class YearMonthToDateTest {

    public static Date toDate(YearMonth yearMonth) {
        return Date.from(yearMonth.atDay(1).atStartOfDay(
                ZoneId.systemDefault()).toInstant());
    }

}
