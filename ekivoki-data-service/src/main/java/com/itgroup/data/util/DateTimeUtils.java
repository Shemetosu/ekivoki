package com.itgroup.data.util;

import lombok.experimental.UtilityClass;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@UtilityClass
public class DateTimeUtils {

    private static final String DATE_PATTERN = "yyyy.MM.dd";
    private static final String TIME_PATTERN = "HH:mm:ss";
    private static final String DATE_TIME_PATTERN = DATE_PATTERN + " " + TIME_PATTERN;

    public static String convert(LocalDate source) {
        return source == null
                ? null
                : source.format(DateTimeFormatter.ofPattern(DATE_PATTERN));
    }

    public static String convert(LocalTime source) {
        return source == null
                ? null
                : source.format(DateTimeFormatter.ofPattern(TIME_PATTERN));
    }

    public static String convert(LocalDateTime source) {
        return source == null
                ? null
                : source.format(DateTimeFormatter.ofPattern(DATE_TIME_PATTERN));
    }
}
