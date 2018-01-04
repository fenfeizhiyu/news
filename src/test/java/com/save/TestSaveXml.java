package com.save;

import com.util.Utils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.dom4j.Document;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.*;

/**
 * @author yu.yang
 */
public class TestSaveXml {


    private static String FILE_BATH = TestSaveXml.class.getClassLoader().getResource("").getPath();



    @Test
    public void testSearchFile(){
        String path = FILE_BATH;
        List<File> fiels=( List<File>)FileUtils.listFiles(new File(path), FileFilterUtils.suffixFileFilter("xml"),  FileFilterUtils.trueFileFilter());
        System.out.println();
    }


    @Test
    public void testSaveXml(){
        Map<String, String> map = new HashMap<String, String>();
        map.put("name", "doe");
        map.put("book", "deb");
        map.put("vael", "ew");
        Set<String> set = new HashSet<String>();
        set.add("dwe");
        set.add("www");
        set.add("wggg");

        String fileName = "/data/run_data11.xml";

        System.out.println(this.getClass().getClassLoader().getResource("").getPath());
        Document document= XmlSave.saveMapToXml(map, "map_node", null);
        document=XmlSave.saveSetToXml(set, "set_node", "attr", document);
        document.setXMLEncoding("UTF-8");
        StringWriter sw = new StringWriter();

        try {
            File file=new File(FILE_BATH+fileName);
            if(file.exists()){
                file.delete();
            }
            file.createNewFile();
            FileWriter  out = new FileWriter( file);
            OutputFormat format = OutputFormat.createPrettyPrint();  //转换成字符串
            format.setEncoding("UTF-8");
            XMLWriter writer = new XMLWriter( out, format );
            XMLWriter xmlWriter =new XMLWriter(sw, format);
            xmlWriter.write(document);
            System.out.println(sw.toString());
            writer.write(document);
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
