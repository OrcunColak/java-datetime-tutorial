package com.colak.java8.zoneoffset;

import java.time.ZoneId;
import java.time.ZoneOffset;

// See https://levelup.gitconnected.com/java-date-and-time-api-mastering-zoned-and-offset-date-time-for-effective-time-zone-management-ae9683cde554
// Since it extends the ZoneId class, it inherits all of its methods.
class ZoneOffsetTest {

    private static void constants() {
        ZoneOffset example6 = ZoneOffset.MIN;
        // -18:00

        ZoneOffset example7 = ZoneOffset.UTC;
        // Z

        ZoneOffset example8 = ZoneOffset.MAX;
        // +18:00
    }

    private static void of() {
        ZoneOffset example9 = ZoneOffset.of("+2");
        // +02:00

        // ZoneOffset example10 = ZoneOffset.of("+19");
        // java.time.DateTimeException: Zone offset hours not in valid range:
        // value 19 is not in the range -18 to 18
    }

    private static void ofTotalSeconds() {
        ZoneOffset example11 = ZoneOffset.ofTotalSeconds(2 * 60 * 60);
        // +02:00

        ZoneOffset example12 = ZoneOffset.ofHoursMinutes(1, 45);
        // +01:45

        ZoneOffset example13 = ZoneOffset.ofHours(2);
        // +02:00

        ZoneOffset example14 = ZoneOffset.ofHoursMinutesSeconds(2, 10, 30);
        // +02:10:30
    }

    private static void ofOffset() {
        ZoneId example15 = ZoneOffset.ofOffset("UTC", // Can be one of: GMT, UTC or UT
                ZoneOffset.ofHoursMinutes(1, 45));
        // UTC+01:45
    }
}
