package com.aidar.util;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by paradise on 07.05.16.
 */
public class DateUtil {

    public static Date getMonthAgoDate() {
        Date now = new Date();
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_MONTH, -1);
        return c.getTime();
    }

}
