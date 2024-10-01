package com.colak.java8.offsettime;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.List;
import java.util.stream.Stream;

// See https://levelup.gitconnected.com/java-date-and-time-api-mastering-zoned-and-offset-date-time-for-effective-time-zone-management-ae9683cde554
class OffsetTimeTest {

    private static void of() {
        OffsetTime example35 = OffsetTime.MIN;
        // 00:00+18:00

        OffsetTime example36 = OffsetTime.MAX;
        // 23:59:59.999999999-18:00

        OffsetTime example37 = OffsetTime.of(10, 15, 30, 15, ZoneOffset.UTC);
        // 10:15:30.000000015Z

        OffsetTime example38 = OffsetTime.of(10, 15, 30, 15, ZoneOffset.MIN);
        // 10:15:30.000000015-18:00

        OffsetTime example39 = OffsetTime.ofInstant(Instant.ofEpochMilli(1725494870000L), ZoneId.of("Europe/Kyiv"));
        // 03:07:50+03:00

        OffsetTime example40 = OffsetTime.now(ZoneId.of("Europe/Kyiv"));
        // 23:16:38.155048587+03:00 (each run is different value)
    }

    private static void compare() {
        boolean example51 = OffsetTime.now(ZoneId.of("Europe/Kyiv"))
                .isBefore(OffsetTime.now(ZoneId.of("Europe/London")));
        // true

        boolean example52 = OffsetTime.now(ZoneId.of("Europe/Kyiv"))
                .isAfter(OffsetTime.now(ZoneId.of("Europe/London")));
        // false

        boolean example53 = OffsetTime.now(ZoneId.of("Europe/Kyiv"))
                .equals(OffsetTime.now(ZoneId.of("Europe/London")));
        // false

        List<OffsetTime> example57 = Stream.of(OffsetTime.now(ZoneId.of("Europe/Kyiv")),
                        OffsetTime.now(ZoneId.of("Europe/London")))
                .sorted()
                .toList();
        // [17:09:35.817276338+03:00, 15:09:35.817291413+01:00]
    }
}
