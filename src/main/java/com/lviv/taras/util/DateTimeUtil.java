package com.lviv.taras.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class DateTimeUtil {

    public static LocalDateTime stringToLocalDateTime(String stringTime) {
        LocalDateTime result = null;

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        try {
            Date date = simpleDateFormat.parse(stringTime);

            Instant instant = Instant.ofEpochMilli(date.getTime());
            result = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        } catch (ParseException ex) {
            System.out.println("Exception " + ex);
        }
        return result;
    }
}
