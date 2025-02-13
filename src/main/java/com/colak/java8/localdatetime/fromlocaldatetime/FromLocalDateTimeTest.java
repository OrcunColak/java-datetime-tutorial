package com.colak.java8.localdatetime.fromlocaldatetime;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class FromLocalDateTimeTest {

    private static final LocalDateTime BASE_DATE = LocalDateTime.of(1899, 12, 30, 0, 0);

    // This method does not return results that conform to Embercadero's TDateTime to double conversion, for dates
    // that are before BASE_DATE
    public static double localDateTimeToDouble(LocalDateTime localDateTime) {
        if (localDateTime == null) {
            return 0.0;
        }

        long days = ChronoUnit.DAYS.between(BASE_DATE, localDateTime);

        long secondsOfDay = localDateTime.toLocalTime()
                .toSecondOfDay();
        double fractionOfDay = secondsOfDay / 86400.0; // 86400 seconds in a day
        return days + fractionOfDay;
    }

    public static LocalDateTime doubleToLocalDateTime(double value) {
        long days = (long) value;
        double fractionalPart = value - days;

        long seconds = Math.round(fractionalPart * 86400);
        return BASE_DATE.plusDays(days)
                .plusSeconds(seconds);
    }
}
