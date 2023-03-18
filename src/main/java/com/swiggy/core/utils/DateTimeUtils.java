package com.swiggy.core.utils;

import lombok.experimental.UtilityClass;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@UtilityClass
public class DateTimeUtils {
    public String convertMillisToDate(long millis) {
        DateFormat formatter = new SimpleDateFormat("dd MMM yyyy HH:mm:ss.SSS Z");
        return formatter.format(new Date(millis));
    }
}
