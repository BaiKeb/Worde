package com.example.demo01.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class FormatDate {

    public static void main(String[] args) {

        Date nowDate = new Date();

        Date yetDate = new Date();

        // 得到日历
        Calendar calendar = Calendar.getInstance();

        calendar.setTime(nowDate);
        // 前三天
        calendar.add(Calendar.DATE, -3);

        Date a = calendar.getTime();

        calendar.setTime(nowDate);

        calendar.add(Calendar.DATE, -7);
        // 前七天
        Date b = calendar.getTime();
        // 上个月
        calendar.add(Calendar.MONTH, -1);
        yetDate = calendar.getTime();

        SimpleDateFormat format = new SimpleDateFormat("yyyy");
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM");

        String today = format1.format(nowDate);
        String Yesterday = format1.format(a);
        String week = format1.format(b);

        String yet = format2.format(yetDate);
        String now = format2.format(nowDate);
        String year = format.format(nowDate);

    }
}
