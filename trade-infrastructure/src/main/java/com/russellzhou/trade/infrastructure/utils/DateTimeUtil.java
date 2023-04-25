package com.russellzhou.trade.infrastructure.utils;

import org.apache.commons.lang3.StringUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Objects;

/**
 * @author： zhoudewei
 * @date： 2023/4/25 18:46
 * @description： 日期时间工具类
 * @version： v1.0
 */
public class DateTimeUtil {

    private final static DateTimeFormatter CHINESE_DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH时mm分ss秒");

    private final static DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public final static String DATE_PATTERN_YYMMDDHHMMSS = "yyMMddHHmmss";

    public final static String DATA_PATTERN_RFC3339 = "yyyy-MM-dd'T'HH:mm:ss+08:00";

    /**
     * 时间戳转时间
     *
     * @param milliseconds
     * @return
     */
    public static LocalDateTime transformTimestamp(Long milliseconds) {
        return Instant.ofEpochMilli(milliseconds).atZone(ZoneOffset.ofHours(8)).toLocalDateTime();
    }

    public static String formatDateStr(Date date) {
        if (Objects.isNull(date)) {
            return null;
        }
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zoneId);
        String dateStr = DATE_FORMAT.format(localDateTime);
        return dateStr;
    }

    /**
     * 日期转中文xxxx年xx月xx日
     *
     * @param date
     * @return
     */
    public static String formatChineseDate(Date date) {
        if (Objects.isNull(date)) {
            return null;
        }
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zoneId);
        String dateStr = CHINESE_DATE_FORMAT.format(localDateTime);
        return dateStr;
    }

    /**
     * 转换日期到本地日期时间格式
     *
     * @param date
     * @return
     */
    public static LocalDateTime parseDate2LocalDateTime(Date date) {
        if (date == null) {
            return null;
        }
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    /**
     * LocalDateTime转换为Date
     */
    public static Date parseLocalDateTime2Date(LocalDateTime localDateTime) {
        if (localDateTime == null) {
            return null;
        }
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zonedDateTime = localDateTime.atZone(zoneId);
        return Date.from(zonedDateTime.toInstant());
    }

    /**
     * LocalDateTime转换为毫米级别时间戳
     */
    public static Long epochMilli(LocalDateTime localDateTime) {
        if (localDateTime == null) {
            return null;
        }
        return localDateTime.toInstant(ZoneOffset.of("+8")).toEpochMilli();
    }

    /**
     *  将日期转换为指定的日期格式字符串
     *
     * @param date
     * @param pattern 需要转换出来的日期格式
     * @return
     */
    public static String formatDateToString(Date date, String pattern) {
        if (Objects.isNull(date) || StringUtils.isBlank(pattern)) {
            return StringUtils.EMPTY;
        }
        DateFormat formatter = new SimpleDateFormat(pattern);
        return formatter.format(date);
    }

    /**
     * 将Date类型转换成RFC3339
     * @param dateTime
     * @return
     */
    public static String dataToRfc3339(LocalDateTime dateTime){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DATA_PATTERN_RFC3339).withZone(ZoneId.systemDefault());
        return dateTimeFormatter.format(dateTime);
    }

    /**
     * 计算x天前（后）的时间
     * @param date
     * @param num
     * @return
     */
    public static Date getDayOffsetDateTime(Date date, long num){
        if(date == null){
            date = new Date();
        }
        LocalDateTime currentLocalDateTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
        LocalDateTime calculatedLocalDateTime = currentLocalDateTime.plusDays(num);
        return Date.from(calculatedLocalDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }
}
