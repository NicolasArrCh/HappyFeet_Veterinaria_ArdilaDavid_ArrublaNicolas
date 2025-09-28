package com.happyfeet.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtil {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static String formatDate(LocalDate date) {
        return date.format(FORMATTER);
    }

    public static LocalDate parseDate(String dateStr) {
        return LocalDate.parse(dateStr, FORMATTER);
    }

    public static boolean isExpired(LocalDate expiryDate) {
        return expiryDate.isBefore(LocalDate.now());
    }
}
