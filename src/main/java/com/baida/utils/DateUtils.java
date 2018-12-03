package com.baida.utils;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * 功能:时间格式化(工具类)
 * @author ShiQing_Chen
 * @date 2018/12/3 17:29
 */

public class DateUtils {

    /**
     * 功能说明:取得当前日期Timestamp
     *
     * @return Timestamp 日期时间
     */
    public static Timestamp getNowTimestamp() {
        return new Timestamp(new Date().getTime());
    }
}
