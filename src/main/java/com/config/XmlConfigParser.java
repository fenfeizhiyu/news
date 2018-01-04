package com.config;

import com.model.NewSource;
import com.util.CheckUtil;
import org.apache.commons.io.FileUtils;
import org.apache.ibatis.parsing.XNode;
import org.apache.ibatis.parsing.XPathParser;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yu.yang
 */
public class XmlConfigParser {

    public static void main(String[] args){
        /*
        try {
            String s=FileUtils.readFileToString(new File("./src/main//resources/hb_url.xml"),"utf-8");
            XPathParser xPathParser = new XPathParser(s);
           XNode xNode= xPathParser.evalNode("/news-config");
           List<XNode> nodes=xNode.getChildren();
            System.out.println(nodes.size());

        } catch (IOException e) {
            e.printStackTrace();
        }*/

    }


    private static final String BASE_PATH = "./src/main//resources";
    private static final String[] URL_PATHS=new String[]{"/config/hb_url.xml"};
    private static List<NewSource> sourceList;

    public  List<NewSource> getSourceList() {
        return sourceList;
    }

    public  void parseConfig(){
        try {
            sourceList = new ArrayList<NewSource>();
            for(String str:URL_PATHS){
                String s=FileUtils.readFileToString(new File(BASE_PATH+str),"utf-8");
                XPathParser xPathParser = new XPathParser(s);
                XNode xNode= xPathParser.evalNode("/news-config");
                List<XNode> nodes=xNode.getChildren();
                for(XNode newsNode:nodes){
                   NewSource source= parserNewsNode(newsNode);
                   if(CheckUtil.notNull(source)){
                       sourceList.add(source);
                   }
                }
            }
            return ;
        }catch (Exception e){
            e.printStackTrace();
            return ;
        }
    }

    private  NewSource parserNewsNode(XNode xNode){
        if(xNode==null)
            return null;
       List<XNode> nodes= xNode.getChildren();
        if(CheckUtil.isEmpty(nodes)){
            return null;
        }
        NewSource newSource = new NewSource();
       for(XNode node :nodes){
           setNewSourceValue(node.getName(), node.getStringBody(), newSource);
       }
        return newSource;
    }

    private void setNewSourceValue(String tag,String value,NewSource source){
        if(tag.equals("tag-name")){
            source.setTagName(value);
        }
        if(tag.equals("file-pref")){
            source.setFilePref(value);
        }
        if(tag.equals("source")){
            source.setSource(value);
        }
        if(tag.equals("url")){
            source.setUrl(value);
        }
        if(tag.equals("save_text")){
            source.setSaveText(value);
        }
    }






}
