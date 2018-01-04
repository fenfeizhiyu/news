package com.save;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;


import java.util.Map;

/**
 * @author yu.yang
 */
public class XmlSave {

    public void saveToXml(Map<String,String> data, String nodeName,String fileName){
        Document document = DocumentHelper.createDocument();
        Element root = document.addElement( "root" );
        Element node= root.addElement(nodeName);

    }

}
