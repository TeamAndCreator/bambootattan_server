package com.ahau.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GetTimeUtil {

    /**
     * @return time 格式（22:35:29）
     */
    public static String getTime(){
        SimpleDateFormat time1 = new SimpleDateFormat("HH:mm:ss");//设置时间点格式
        return time1.format(new Date());
    }

    /**
     * @return date 格式（2018-04-22）
     */
    public static String getDate(){
        SimpleDateFormat date1 = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        return date1.format(new Date());
    }
}
