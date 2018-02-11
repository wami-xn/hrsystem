package com.wami.project.hrsystem.core.utils;

import org.apache.logging.log4j.core.util.Integers;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

@SuppressWarnings({"unused","WeakerAccess"})
public class TimeClassHandler {
    private static final String DEFAULT_FORMAT= "yyyy-MM-dd HH:mm:ss";

    private static TimeZone TIMEZONE = TimeZone.getTimeZone("Asia/Shanghai");
    /**
     * 统一的转换为util.Date的方法
     */
    public static Date toDate(Date date){
        return date;
    }
    public static Date toDate(String time, String format) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.parse(time);
    }
    public static Date toDate(String time) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_FORMAT);
        return sdf.parse(time);
    }
    /**
     * 统一的转换为sql.Date的方法
     */
    public static java.sql.Date toSqlDate(Date timestamp){
        return new java.sql.Date(timestamp.getTime());
    }
    public static java.sql.Date toSqlDate(String time, String format) throws ParseException {
        return toSqlDate(toDate(time,format));
    }
    public static java.sql.Date toSqlDate(String time) throws ParseException {
        return toSqlDate(toDate(time));
    }
    /**
     * 统一的转换为sql.Time的方法
     */
    public static Time toSqlTime(Date timestamp){
        return new java.sql.Time(timestamp.getTime());
    }
    public static Time toSqlTime(String time, String format) throws ParseException {
        return toSqlTime(toDate(time,format));
    }
    public static Time toSqlTime(String time) throws ParseException {
        return toSqlTime(toDate(time));
    }
    /**
     * 统一的转换为sql.Timestamp的方法
     */
    public static Timestamp toSqlTimestamp(Date timestamp){
        return new Timestamp(timestamp.getTime());
    }
    public static Timestamp toSqlTimestamp(String time, String format) throws ParseException {
        return toSqlTimestamp(toDate(time,format));
    }
    public static Timestamp toSqlTimestamp(String time) throws ParseException {
        return toSqlTimestamp(toDate(time));
    }
    /**
     * 统一的转换为String的方法
     */
    public static String toString(Date date, String format, TimeZone timeZone){
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        sdf.setTimeZone(timeZone);
        return sdf.format(date);
    }
    public static String toString(Date date, String format){
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        sdf.setTimeZone(TIMEZONE);
        return sdf.format(date);
    }
    public static String toString(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_FORMAT);
        sdf.setTimeZone(TIMEZONE);
        return sdf.format(date);
    }

    /**
     * 快速获取取出具体年，月，日，周，时，分，秒的方法
     */
    public static Integer getYear(Date date){
        return Integers.parseInt(toString(date, "yyyy"));
    }
    public static Integer getMonth(Date date){
        return Integers.parseInt(toString(date, "MM"));
    }
    public static Integer getDayOfWeek(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.DAY_OF_WEEK);
    }
    public static Integer getDayOfMonth(Date date){
        return Integers.parseInt(toString(date, "dd"));
    }
    public static Integer getDayOfYear(Date date){
        return Integers.parseInt(toString(date, "D"));
    }
    public static Integer getWeekOfMonth(Date date){
        return Integers.parseInt(toString(date, "W"));
    }
    public static Integer getWeekOfYear(Date date){
        return Integers.parseInt(toString(date, "w"));
    }
    public static Integer getHour(Date date){
        return Integers.parseInt(toString(date, "HH"));
    }
    public static Integer getMinute(Date date){
        return Integers.parseInt(toString(date, "mm"));
    }
    public static Integer getSecond(Date date) {
        return Integers.parseInt(toString(date, "ss"));
    }
    public static Integer[] getTime(Date date){
        return new Integer[]{getYear(date),getMonth(date),getDayOfMonth(date),getHour(date), getMinute(date), getSecond(date)};
    }
}
