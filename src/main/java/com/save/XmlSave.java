package com.save;

import com.constant.Constant;
import com.util.CheckUtil;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;


import java.io.File;
import java.io.FileWriter;
import java.util.Map;
import java.util.Set;

/**
 * @author yu.yang
 */
public class XmlSave {

    private static Document initDocument(Document document){
        if(CheckUtil.notNull(document)){
            return document;
        }
        document=DocumentHelper.createDocument();
        document.addElement( Constant.XML_ROOT_NODE);
        return document;
    }

    /**
     * 保存Map
     * @param data
     * @param nodeName
     * @param fileName
     * @param document
     */
    public static Document saveMapToXml(Map<String,String> data, String nodeName, Document document){
        document = initDocument(document);
        Element root =document.getRootElement();
        Element node= root.addElement(nodeName);
        for(Map.Entry<String,String> entry:data.entrySet()){
            node.addElement(entry.getKey()).setText(entry.getValue());
        }
        return document;
    }

    /**
     * 保存set
     * @param set
     * @param nodeName
     * @param attrName
     * @param document
     */
    public static Document saveSetToXml(Set<String> set, String nodeName, String attrName, Document document){
        document = initDocument(document);
        Element root =document.getRootElement();
        for(String s:set){
            Element node=root.addElement(nodeName);
            node.addAttribute(attrName, s);
        }
        return document;
    }


    /**
     * 保存Document
     * @param document
     * @param filePath
     * @param newFile
     */
    public static void saveDoucmentToFile(Document document,String filePath,boolean newFile){
        File file = new File(filePath);
        FileWriter out=null;
        try {
            if(newFile){
                file.delete();
                file.createNewFile();
            }else {
                if(!file.exists()){
                    file.createNewFile();
                }
            }
            out = new FileWriter( file);
            OutputFormat format = OutputFormat.createPrettyPrint();  //转换成字符串
            format.setEncoding("UTF-8");
            XMLWriter writer = new XMLWriter( out, format );
            writer.write(document);
            out.flush();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if(out!=null){
                    out.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }





}
