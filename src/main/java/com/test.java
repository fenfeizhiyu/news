package com;

import com.model.NewSource;
import com.config.XmlConfigParser;

import java.util.List;

/**
 * @author yu.yang
 */
public class test {
    public static void main(String[] args){
        XmlConfigParser xmlConfigParser = new XmlConfigParser();
        xmlConfigParser.parseConfig();
        List<NewSource> sources= xmlConfigParser.getSourceList();
        System.out.println(sources.size());
    }

}
