package com.colak.java8.localdatetime.convertfrominstant;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class ConvertFromInstantTest {

    public static void main() {
        Instant now = Instant.now();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(now, ZoneId.systemDefault());
        System.out.println("localDateTime = " + localDateTime);
    }
}