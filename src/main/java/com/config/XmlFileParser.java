package com.config;

import com.util.CheckUtil;
import com.util.Utils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yu.yang
 */
public class XmlFileParser {


    /**
     * 查找指定路径下所有xml文件
     * @param path
     * @return
     */
    public List<String> getXmlFiles(String path){
        List<File> files = Utils.searchXmlFile(path);
        if (CheckUtil.isEmpty(files)) {
            return null;
        }else {
            List<String> xmlStr = new ArrayList<String>();
            for(File file:files){
                try {
                    String xml=FileUtils.readFileToString(file, "UTF-8");
                    if (StringUtils.isNotBlank(xml)) {
                        xmlStr.add(xml);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return xmlStr;
        }
    }


}
