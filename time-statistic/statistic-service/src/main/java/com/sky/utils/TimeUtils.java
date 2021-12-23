package com.sky.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author sky
 * @create 2021-12-23 11:13
 */
public class TimeUtils {
    // 获取仅七天日期（MM-dd）
    public static String[] getDays() {
        return (String[]) getDaysBetween(6);
    }

    // 获取今年所有月份（yyyy/MM）
    public static String[] getMonths() {
        Calendar cal = Calendar.getInstance();
        String year = cal.get(Calendar.YEAR) + "";
        String[] res = new String[12];
        for (int i=0; i<12; i++) {
            if (i < 10) {
                res[i] = year + "/0" + (i+1);
            }else {
                res[i] = year + "/" + (i+1);
            }
        }
        return res;
    }

    private static Date getDateAdd(int days) {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_MONTH, -days);
        return c.getTime();
    }

    private static Object[] getDaysBetween(int days) { //最近几天日期
        List<String> dayss = new ArrayList<>();
        Calendar start = Calendar.getInstance();
        start.setTime(getDateAdd(days));
        long startTIme = start.getTimeInMillis();
        Calendar end = Calendar.getInstance();
        end.setTime(new Date());
        long endTime = end.getTimeInMillis();
        long oneDay = 1000 * 60 * 60 * 24L;
        long time = startTIme;
        while (time <= endTime) {
            Date d = new Date(time);
            DateFormat df = new SimpleDateFormat("MM-dd");
            dayss.add(df.format(d));
            time += oneDay;
        }
        return dayss.toArray(new String[dayss.size()]);
    }
}
