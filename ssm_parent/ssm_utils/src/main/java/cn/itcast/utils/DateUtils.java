package cn.itcast.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
//    日期转字符串
    public static String dateToString(Date date,String patt){

        SimpleDateFormat sdf = new SimpleDateFormat(patt);
        String dateStr = sdf.format(date);
        return dateStr;
    }
//    字符串转日期
    public static Date stringToDate(String dateStr,String patt) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(patt);
        Date date = sdf.parse(dateStr);
        return date;
    }
}
