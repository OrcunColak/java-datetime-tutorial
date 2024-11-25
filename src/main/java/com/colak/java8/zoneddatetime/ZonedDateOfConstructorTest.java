package com.colak.java8.zoneddatetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

// See https://levelup.gitconnected.com/java-date-and-time-api-mastering-zoned-and-offset-date-time-for-effective-time-zone-management-ae9683cde554
class ZonedDateOfConstructorTest {

    // There are 3 of(...) overloads
    private static void of() {
        ZoneId zoneId = ZoneId.of("Europe/Kyiv");

        ZonedDateTime example16 = ZonedDateTime.of(2024, 9, 4, 7, 15, 30, 50000, zoneId);
        // 2024-09-04T07:15:30.000050+03:00[Europe/Kyiv]

        ZonedDateTime example17 = ZonedDateTime.of(LocalDate.of(2024, 9, 4), LocalTime.NOON, zoneId);
        // 2024-09-04T12:00+03:00[Europe/Kyiv]

        ZonedDateTime example18 = ZonedDateTime.of(LocalDateTime.of(2024, 9, 4, 7, 10, 10), zoneId);
        // 2024-09-04T07:10:10+03:00[Europe/Kyiv]
    }

}
