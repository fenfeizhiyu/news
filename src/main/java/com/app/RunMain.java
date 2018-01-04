package com.app;

import com.config.XmlConfigParser;
import com.html.HtmlParser;
import com.html.HtmlParserForZx;
import com.http.DefaultHtmlLoader;
import com.http.HtmlLoader;
import com.model.NewSource;
import com.model.NewsTitle;
import com.model.SaveUnit;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yu.yang
 */
public class RunMain {

    public static void main(String[] args){
        XmlConfigParser config = new XmlConfigParser();
        config.parseConfig();
        List<NewSource>  sourceList=config.getSourceList();
        HtmlLoader loader = new DefaultHtmlLoader();
        HtmlParser htmlParser=new HtmlParserForZx();
        List<SaveUnit> saveUnits = new ArrayList<SaveUnit>();
        for(NewSource source:sourceList){
            SaveUnit saveUnit = new SaveUnit(source);
            NewsTitle newsTitle=htmlParser.parserNewsTitle(loader.getHtml(source.getUrl()));
            saveUnit.getNewsTitles().add(newsTitle);
            saveUnits.add(saveUnit);
        }

    }

}
