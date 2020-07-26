package com.wjh.demo.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * @Auther: Wen Jiahu
 * @Date: 2019/03/10
 * @Description: 时间工具类
 */
public class DateUtils {

    private final static long minute = 60 * 1000;// 1分钟
    private final static long hour = 60 * minute;// 1小时
    private final static long day = 24 * hour;// 1天
    private final static long month = 31 * day;// 月
    private final static long year = 12 * month;// 年

    /**
     * 日期格式字符串转换成时间戳
     *
     * @param date_str 字符串日期
     * @param format   如：yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static Long date2TimeStamp(String date_str, String format) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.parse(date_str).getTime();

    }

    private static String getDateFormat(Date date, String dateFormatType) {
        SimpleDateFormat simformat = new SimpleDateFormat(dateFormatType);
        return simformat.format(date);
    }

    public static String formatCSTTime(String date, String format) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
        Date d = sdf.parse(date);
        return getDateFormat(d, format);
    }

    public final static String YYYYMMDDHHMMSS = "yyyyMMddHHmmssSSS";

    /**
     * @return
     * @author neo
     * @date 2015-5-21
     */
    public static String getDateSequence() {
        return new SimpleDateFormat(YYYYMMDDHHMMSS).format(new Date());
    }


    /**
     * @return
     * @author neo
     * @date 2016年8月10日
     */
    public static long getCurrentTime() {
        return System.currentTimeMillis();
    }

    public static long getCurrentTimeAdd(long mills) {
        return System.currentTimeMillis() + mills;
    }

    public static Long getTodayZeroPointTimestamps() {
        Long currentTimestamps = System.currentTimeMillis();
        Long oneDayTimestamps = Long.valueOf(60 * 60 * 24 * 1000);
        return currentTimestamps - (currentTimestamps + 60 * 60 * 8 * 1000) % oneDayTimestamps;
    }

    public static String getTimeFormatText(Long date) {
        if (date == null) {
            return null;
        }
        long diff = new Date().getTime() - date;
        long r = 0;
        if (diff > year) {
            r = (diff / year);
            return r + "年前";
        }
        if (diff > month) {
            r = (diff / month);
            return r + "个月前";
        }
        if (diff > day) {
            r = (diff / day);
            return r + "天前";
        }
        if (diff > hour) {
            r = (diff / hour);
            return r + "个小时前";
        }
        if (diff > minute) {
            r = (diff / minute);
            return r + "分钟前";
        }
        return "刚刚";
    }

    /**
     * 将时间戳转换成当天0点
     *
     * @param timestamp
     * @return
     */
    public static long getDayBegin(long timestamp) {
        String format = "yyyy-MM-DD";
        String toDayString = new SimpleDateFormat(format).format(new Date(timestamp));
        Date toDay = null;
        try {
            toDay = org.apache.commons.lang3.time.DateUtils.parseDate(toDayString, new String[]{format});

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return toDay.getTime();
    }

    /**
     * 获取一个月之前的时间戳
     *
     * @return
     */
//    public static long getLastMonthTime() {
//        return getDayBegin(getCurrentTime()) - 86400000l * 30;
//    }

    public static String getDate(Long timestamp) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(timestamp);
    }

    /**
     * 生成年月日数字
     *
     * @return
     */
    public static String getDateStr() {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        return format.format(System.currentTimeMillis());
    }

    /**
     * 生成年月日数字
     *
     * @return
     */
    public static String getDateStrAdd(long days) {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        long i = 1000 * 60 * 60 * 24 * days;
        long l = System.currentTimeMillis() + i;
        return format.format(l);
    }

    public static long dateConvertToTimes(Date date) {
        return date.getTime();
    }

    /**
     * 获取本周的第一天时间戳
     *
     * @return long
     **/
    public static long getWeekStartStamp() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.WEEK_OF_MONTH, 0);
        cal.set(Calendar.DAY_OF_WEEK, 2);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        return cal.getTimeInMillis();
    }

    /**
     * 获取本周的最后一天
     *
     * @return long
     **/
    public static long getWeekEndStamp() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_WEEK, cal.getActualMaximum(Calendar.DAY_OF_WEEK));
        cal.add(Calendar.DAY_OF_WEEK, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.add(Calendar.DATE, 1);
        return cal.getTimeInMillis() - 1;
    }

    /**
     * 获取本月开始时间戳
     *
     * @return String
     **/
    public static long getMonthStartStamp() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, 0);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        return cal.getTimeInMillis();
    }

    /**
     * 获取本月最后一天时间戳
     *
     * @return String
     **/
    public static long getMonthEndStamp() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.add(Calendar.DATE, 1);
        return cal.getTimeInMillis() - 1;
    }

}
