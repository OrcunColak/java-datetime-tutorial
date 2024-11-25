package com.colak.java8.timezone.setdefault;

import java.util.TimeZone;

class TimeZoneSetTest {

    public static void main() {
        printDefaultTimeZone();

        // Set default time zone to UTC
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));

        printDefaultTimeZone();

    }

    private static void printDefaultTimeZone() {
        TimeZone timeZone = TimeZone.getDefault();
        System.out.println("Default Time Zone " + timeZone.getID());
    }
}
