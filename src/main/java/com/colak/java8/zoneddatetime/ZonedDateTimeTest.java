package com.colak.java8.zoneddatetime;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalQueries;
import java.time.temporal.TemporalUnit;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

// See https://levelup.gitconnected.com/java-date-and-time-api-mastering-zoned-and-offset-date-time-for-effective-time-zone-management-ae9683cde554
class ZonedDateTimeTest {

    // This method combines a LocalDateTime and a ZoneId to produce a ZonedDateTime.
    // It assumes the provided ZoneId is valid for the given LocalDateTime without performing additional validation checks.
    private static void ofLocal() {
        ZonedDateTime example19 = ZonedDateTime.ofLocal(LocalDateTime.of(2024, 9, 4, 7, 10, 10),
                ZoneId.of("Europe/Kyiv"), ZoneOffset.of("+3"));
        // 2024-09-04T07:10:10+03:00[Europe/Kyiv]
    }

    // This method also combines a LocalDateTime and a ZoneId but includes a ZoneRules object for more rigorous validation.
    // It checks that the provided LocalDateTime adheres to the rules of the specified time zone, including daylight saving time adjustments.
    private void ofStrict() {
        ZonedDateTime example20 = ZonedDateTime.ofStrict(LocalDateTime.of(2024, 9, 4, 7, 10, 10),
                ZoneOffset.of("+3"), ZoneId.of("Europe/Kyiv"));
        // 2024-09-04T07:10:10+03:00[Europe/Kyiv]

        // ZonedDateTime example21 = ZonedDateTime.ofStrict(LocalDateTime.of(2024, 9, 4, 7, 10, 10),
        //        ZoneOffset.of("+1"), ZoneId.of("Europe/Kyiv"));
        // java.time.DateTimeException ZoneOffset '+01:00' is not valid for LocalDateTime
        // '2024-09-04T07:10:10' in zone 'Europe/Kyiv'
    }

    // This method has two overloaded versions: one without arguments and another that accepts a ZoneId, allowing you
    // to create an instance in a specific time zone.
    private static void now() {
        ZonedDateTime example22 = ZonedDateTime.now();
        // 2024-09-23T16:18:28.519514695-03:00[your time zone]

        ZonedDateTime example23 = ZonedDateTime.now(ZoneId.of("Europe/Kyiv"));
        // 2024-09-23T16:18:28.519514695-03:00[your time zone]
    }

    private static void ofInstant() {
        ZonedDateTime example24 = ZonedDateTime.ofInstant(Instant.ofEpochMilli(1725494870000L),
                ZoneId.of("Europe/Kyiv"));
        // 2024-09-05T03:07:50+03:00[Europe/Kyiv]

        ZonedDateTime example25 = ZonedDateTime.ofInstant(
                LocalDateTime.ofInstant(Instant.ofEpochMilli(1725494870000L), ZoneId.of("Europe/Kyiv")),
                ZoneOffset.ofHoursMinutes(1, 30),
                ZoneId.of("Europe/Kyiv"));
        // 2024-09-05T04:37:50+03:00[Europe/Kyiv]
    }

    private static void accessors() {
        ZonedDateTime example26 = ZonedDateTime.of(LocalDate.of(2024, 9, 4),
                LocalTime.NOON, ZoneId.of("Europe/Kyiv"));
        int example26Offset = example26.get(ChronoField.OFFSET_SECONDS) / (60 * 60);
        // 3 hours

        ZoneId example26Zone = example26.getZone();
        // Europe/Kyiv

        boolean example26Supported = example26.isSupported(ChronoField.HOUR_OF_DAY);
        // true

        long example26Long = example26.getLong(ChronoField.HOUR_OF_DAY);
        // 12

        TemporalUnit example26Queries = example26.query(TemporalQueries.precision());
        // Nanos
    }

    private static void with() {
        ZonedDateTime example27 = ZonedDateTime.of(LocalDate.of(2024, 9, 4),
                LocalTime.NOON, ZoneId.of("Europe/Kyiv"));
        // 2024-09-04T12:00+03:00[Europe/Kyiv]

        ZonedDateTime example27With = example27.with(ChronoField.HOUR_OF_DAY, 1);
        // 2024-09-04T01:00+03:00[Europe/Kyiv]

        ZonedDateTime example27WithHour = example27.withHour(1);
        // 2024-09-04T01:00+03:00[Europe/Kyiv]
    }

    private static void plusMinus() {
        ZonedDateTime example28 = ZonedDateTime.of(LocalDate.of(2024, 9, 4),
                LocalTime.NOON, ZoneId.of("Europe/Kyiv"));
        // 2024-09-04T12:00+03:00[Europe/Kyiv]

        ZonedDateTime example28PlusDuration = example28.plus(Duration.ofHours(1));
        // 2024-09-04T13:00+03:00[Europe/Kyiv]

        ZonedDateTime example28PlusChronoUnit = example28.plus(1, ChronoUnit.HOURS);
        // 2024-09-04T13:00+03:00[Europe/Kyiv]

        ZonedDateTime example28PlusHour = example28.plusHours(1);
        // 2024-09-04T13:00+03:00[Europe/Kyiv]

        ZonedDateTime example28MinusDuration = example28.minus(Duration.ofHours(1));
        // 2024-09-04T11:00+03:00[Europe/Kyiv]

        ZonedDateTime example28MinusChronoUnit = example28.minus(1, ChronoUnit.HOURS);
        // 2024-09-04T11:00+03:00[Europe/Kyiv]

        ZonedDateTime example28MinusHour = example28.minusHours(1);
        // 2024-09-04T11:00+03:00[Europe/Kyiv]
    }

    private static void beforeAfter() {
        boolean example29 = ZonedDateTime.of(LocalDate.of(2024, 9, 4),
                        LocalTime.NOON, ZoneId.of("Europe/Kyiv"))
                .isBefore(ZonedDateTime.of(LocalDate.of(2024, 9, 4),
                        LocalTime.MAX, ZoneId.of("Europe/Kyiv")));
        // true

        boolean example30 = ZonedDateTime.of(LocalDate.of(2024, 9, 4),
                        LocalTime.NOON, ZoneId.of("Europe/Kyiv"))
                .isBefore(ZonedDateTime.of(LocalDate.of(2024, 9, 4),
                        LocalTime.MAX, ZoneId.of("Europe/London")));
        // true

        boolean example31 = ZonedDateTime.of(LocalDate.of(2024, 9, 4),
                        LocalTime.NOON, ZoneId.of("Europe/Kyiv"))
                .isBefore(ZonedDateTime.of(LocalDate.of(2024, 9, 4),
                        LocalTime.NOON, ZoneId.of("Asia/Tokyo")));
        // false

        boolean example32 = ZonedDateTime.of(LocalDate.of(2024, 9, 4),
                        LocalTime.NOON, ZoneId.of("Europe/Kyiv"))
                .equals(ZonedDateTime.of(LocalDate.of(2024, 9, 4),
                        LocalTime.NOON, ZoneId.of("Europe/Kyiv")));
        // true
    }

    private static void compare() {
        Optional<ZonedDateTime> example33 = Stream.of(
                ZonedDateTime.of(LocalDate.of(2024, 9, 1),
                        LocalTime.NOON, ZoneId.of("Europe/Kyiv")),
                ZonedDateTime.of(LocalDate.of(2024, 9, 2),
                        LocalTime.NOON, ZoneId.of("Europe/Kyiv")),
                ZonedDateTime.of(LocalDate.of(2024, 9, 3),
                        LocalTime.NOON, ZoneId.of("Europe/Kyiv"))
        ).max(Comparator.naturalOrder());
        // Optional[2024-09-03T12:00+03:00[Europe/Kyiv]]

        List<ZonedDateTime> example34 = Stream.of(
                        ZonedDateTime.of(LocalDate.of(2024, 9, 1),
                                LocalTime.NOON, ZoneId.of("Europe/Kyiv")),
                        ZonedDateTime.of(LocalDate.of(2024, 9, 3),
                                LocalTime.NOON, ZoneId.of("Europe/Kyiv")),
                        ZonedDateTime.of(LocalDate.of(2024, 9, 2),
                                LocalTime.NOON, ZoneId.of("Europe/Kyiv"))
                )
                .sorted()
                .toList();
        // [2024-09-01T12:00+03:00[Europe/Kyiv],
        // 2024-09-02T12:00+03:00[Europe/Kyiv],
        // 2024-09-03T12:00+03:00[Europe/Kyiv]]
    }
}
