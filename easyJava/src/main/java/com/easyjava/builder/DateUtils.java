package com.easyjava.builder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName DateUtils
 * @Description
 * @Author Siyuan
 * @Date 2024/11/06/14:10
 * @Version 1.0
 */
public class DateUtils {
    public static final String YYYY_MM_DD_HH_MM_SS= "yyyy-MM-dd HH:mm:ss";

    public static final String YYYY_MM_DD= "yyyy-MM-dd";

    public static final String YYYY_A_MM_A_DD= "yyyy/MM/dd";

    public static final String YYYY_A_MM_A_DD_HH_MM_SS= "yyyy/MM/dd HH:mm:ss";
    public static String format(Date date, String patten){
        return new SimpleDateFormat(patten).format(date);
    }

    public static Date parse(String date, String patten){
        try {
            new SimpleDateFormat(patten).parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
