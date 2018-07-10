package com.viewol.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by lenovo on 2018/7/3.
 */
public class DateUtil {

    public static String FORMAT_FULL = "yyyy-MM-dd HH:mm:ss";
    public static String FORMAT_NUM = "MMddHHmmss";

    public static Date parseDate(String str_date,String str_format){
        SimpleDateFormat format = new SimpleDateFormat(str_format);
        try{
            return format.parse(str_date);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

    public static long parseDate(Date date,String str_format){
        SimpleDateFormat format = new SimpleDateFormat(str_format);
        try{
            String str = format.format(date);
            return Long.parseLong(str);
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }
}
