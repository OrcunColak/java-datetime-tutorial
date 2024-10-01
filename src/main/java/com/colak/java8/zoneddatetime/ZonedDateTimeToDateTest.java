package com.colak.java8.zoneddatetime;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

public class ZonedDateTimeToDateTest {

    public static void main() {
        ZonedDateTime zonedDateTime = LocalDate.of(1960, 7, 11).atStartOfDay(ZoneId.systemDefault());
        System.out.println(zonedDateTime);
        // 1960-07-11T00:00+02:00[Europe/Istanbul]

        Date publicationDate = Date.from(zonedDateTime.toInstant());
        System.out.println(publicationDate);
        // Mon Jul 11 00:00:00 TRT 1960
    }
}
