package com.colak.java8.offsetdatetime;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.List;
import java.util.stream.Stream;

// See https://levelup.gitconnected.com/java-date-and-time-api-mastering-zoned-and-offset-date-time-for-effective-time-zone-management-ae9683cde554
class OffsetDateTimeTest {

    private static void of() {
        OffsetDateTime example41 = OffsetDateTime.MIN;
        // -999999999-01-01T00:00+18:00

        OffsetDateTime example42 = OffsetDateTime.MAX;
        // +999999999-12-31T23:59:59.999999999-18:00

        OffsetDateTime example43 = OffsetDateTime.of(LocalDate.of(2024, 9, 4),
                LocalTime.NOON, ZoneOffset.UTC);
        // 2024-09-04T12:00Z

        OffsetDateTime example44 = OffsetDateTime.of(2024, 9, 4, 12, 15,
                59, 100, ZoneOffset.UTC);
        // 2024-09-04T12:15:59.000000100Z

        OffsetDateTime example45 = OffsetDateTime.of(LocalDateTime.of(LocalDate.of(2024, 9, 4), LocalTime.NOON),
                ZoneOffset.UTC);
        // 2024-09-04T12:00Z

        OffsetDateTime example46 = OffsetDateTime.now();
        // 2024-09-24T10:35:30.315164584 your offset

        OffsetDateTime example47 = OffsetDateTime.now(ZoneId.of("Europe/Kyiv"));
        // 2024-09-24T16:36:45.261935297+03:00

        OffsetDateTime example50 = OffsetDateTime.ofInstant(Instant.ofEpochMilli(1725494870000L),
                ZoneId.of("Europe/Kyiv"));
        // 2024-09-05T03:07:50+03:00
    }

    private static void compare() {
        boolean example54 = OffsetDateTime.now(ZoneId.of("Europe/Kyiv"))
                .isBefore(OffsetDateTime.now(ZoneId.of("Europe/London")));
        // true

        boolean example55 = OffsetDateTime.now(ZoneId.of("Europe/Kyiv"))
                .isAfter(OffsetDateTime.now(ZoneId.of("Europe/London")));
        // false

        boolean example56 = OffsetDateTime.now(ZoneId.of("Europe/Kyiv"))
                .equals(OffsetDateTime.now(ZoneId.of("Europe/London")));
        // false

        List<OffsetDateTime> example58 = Stream.of(OffsetDateTime.now(ZoneId.of("Europe/Kyiv")),
                        OffsetDateTime.now(ZoneId.of("Europe/London")))
                .sorted()
                .toList();
        // [2024-09-24T17:10:31.580483809+03:00, 2024-09-24T15:10:31.580489594+01:00]
    }
}
