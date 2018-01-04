package com.util;

import org.apache.commons.io.FileUtils;

import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.http.client.utils.DateUtils;

import java.io.File;
import java.util.Date;
import java.util.List;

/**
 * @author yu.yang
 */
public class Utils {

    public static String getTimeDay(){
       return DateUtils.formatDate(new Date(), "yyyyMMdd");
    }

    /**
     *
     * @param path
     * @return
     */
    public static List<File> searchXmlFile(String path){
        return (List<File> )FileUtils.listFiles(new File(path), FileFilterUtils.suffixFileFilter("xml"), FileFilterUtils.trueFileFilter());
    }

}
