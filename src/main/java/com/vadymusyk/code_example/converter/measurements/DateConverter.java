package com.vadymusyk.code_example.converter.measurements;


import com.vadymusyk.code_example.exception.measurements.DataValidationException;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

/**
 * Created by vadymusyk on 06.03.17.
 */
public class DateConverter {

    public static long convertToUnix(LocalDateTime date) {
        return date.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    public static LocalDateTime convertToLocalDateTime(long date) {
        if (Long.toString(date).length() != 13) {
            throw new DataValidationException("UNIXDate validation failed");
        } else {
            return LocalDateTime.ofInstant(Instant.ofEpochMilli(date),
                    TimeZone.getTimeZone(ZoneId.systemDefault()).toZoneId());
        }
    }

    public static LocalDateTime convertToLocalDateTime(String fromDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        return LocalDateTime.parse(fromDate, formatter);
    }

    public static String convertByMask(LocalDateTime createDate) {
        return createDate.getHour() + ":" + createDate.getMinute() + " " + createDate.getDayOfMonth()
                + "/" + createDate.getMonthValue() + "/" + createDate.getYear();
    }
}
