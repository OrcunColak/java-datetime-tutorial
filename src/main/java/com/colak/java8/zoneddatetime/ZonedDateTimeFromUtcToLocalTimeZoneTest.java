package com.colak.java8.zoneddatetime;

import java.time.ZoneId;
import java.time.ZonedDateTime;

class ZonedDateTimeFromUtcToLocalTimeZoneTest {

    public static void main() {

        // Set up the test: a specific time in UTC
        ZonedDateTime utcTime = ZonedDateTime.of(2024, 11, 25, 10, 0, 0, 0, ZoneId.of("UTC"));

        // Test conversion to "Europe/Istanbul"
        String userTimeZone = "Europe/Istanbul";
        ZonedDateTime convertedTime = convertToUserTimeZone(utcTime, userTimeZone);

        // User Time Zone 2024-11-25T13:00+03:00[Europe/Istanbul]
        System.out.println("User Time Zone " + convertedTime);
    }

    private static ZonedDateTime convertToUserTimeZone(ZonedDateTime utcTime, String userTimeZone) {
        return utcTime.withZoneSameInstant(ZoneId.of(userTimeZone));
    }
}
