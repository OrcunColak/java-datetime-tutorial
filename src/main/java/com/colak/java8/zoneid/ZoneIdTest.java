package com.colak.java8.zoneid;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Map;
import java.util.Set;

// See https://levelup.gitconnected.com/java-date-and-time-api-mastering-zoned-and-offset-date-time-for-effective-time-zone-management-ae9683cde554
class ZoneIdTest {

    public static void main(String[] args) {
    }

    // The list includes not only the main time zones but also many specific variations and historical data for regions.
    // 1. City-Based Zones (Region IDs): Instead of just showing the 24-hour offsets (like UTC+2),
    // Java uses region-based time zones (like Europe/London, America/New_York).
    // 2. Daylight Saving Time (DST) Adjustments: Some locations have different time zone rules, including changes due
    // to DST, which can vary from country to country or even city to city.
    // 3. Historical Time Zone Data:
    // 4. Aliases and Variants
    private static void getAvailableZoneIds() {
        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        // [Asia/Aden, America/Cuiaba, ...]

        int availableZoneQuantity = availableZoneIds.size();
        // 603
    }

    // ZoneId.SHORT_IDS is a predefined map in the ZoneId class that provides a set of short (legacy) time zone IDs as keys,
    // which map to their respective full ZoneId strings. This is primarily for backward compatibility with older time zone formats,
    // where certain abbreviations (like "PST" for Pacific Standard Time or "EST" for Eastern Standard Time) were used.
    private static void shortIds() {
        Map<String, String> shortIds = ZoneId.SHORT_IDS;
        // NST=Pacific/Auckland, HST=-10:00, ACT=Australia/Darwin ...

        String nst = ZoneId.SHORT_IDS.get("NST");
        // Pacific/Auckland
    }

    private void of() {
        ZoneId example1 = ZoneId.of("Europe/Kyiv");
        // Europe/Kyiv

        Map<String, String> example2AliasMap = Map.of("UA", "Europe/Kyiv", "BR", "America/Cuiaba");
        ZoneId example2A = ZoneId.of("UA", example2AliasMap);
        // Europe/Kyiv

        ZoneId example2B = ZoneId.of("BR", example2AliasMap);
        // America/Cuiaba

        ZoneId example2C = ZoneId.of("America/Chicago", example2AliasMap);
        // America/Chicago

        // ZoneId example3 = ZoneId.of("MyZone");
        // java.time.zone.ZoneRulesException: Unknown time-zone ID: MyZone
    }

    private void systemDefault() {
        ZoneId example4 = ZoneId.systemDefault();
        // returns system default time-zone

        ZoneId example5 = ZoneId.from(ZonedDateTime.now(ZoneId.of("America/New_York")));
        // America/New_York
    }
}
