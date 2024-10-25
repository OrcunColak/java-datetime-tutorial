package com.colak.java8.date;

import java.time.YearMonth;
import java.time.ZoneId;
import java.util.Date;

public class YearMonthToDateTest {

    public static Date toDate(YearMonth ym) {
        return Date.from(ym.atDay(1).atStartOfDay(
                ZoneId.systemDefault()).toInstant());
    }

}
