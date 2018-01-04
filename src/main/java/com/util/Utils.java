package com.util;

import org.apache.http.client.utils.DateUtils;

import java.util.Date;

/**
 * @author yu.yang
 */
public class Utils {

    public static String getTimeDay(){
       return DateUtils.formatDate(new Date(), "yyyyMMdd");
    }
}
