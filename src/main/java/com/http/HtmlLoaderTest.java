package com.http;


import nu.validator.htmlparser.sax.HtmlParser;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.BasicHttpClientConnectionManager;
import org.dom4j.DocumentHelper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.xml.sax.InputSource;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author yu.yang
 */
public class HtmlLoaderTest {


    public static void main(String[] args){




        HttpClient httpClient= HttpClients.custom().build();
        HttpGet get = new HttpGet("http://www.hb.chinanews.com/dsxw.html");
        HttpResponse res=null;
        try {
          res=  httpClient.execute(get);
          if(res.getStatusLine().getStatusCode()==200){
           InputStream is= res.getEntity().getContent();
              String html = IOUtils.toString(is,"gb2312");
              Document doc = Jsoup.parse(html);
              Element content = doc.getElementById("content_left");
              Elements pTags = content.getElementsByTag("p");
              StringBuilder sb = new StringBuilder();
              for(Element p:pTags){
                  Elements eles=p.getElementsByClass("news_list_time");
                  Elements links=p.getElementsByTag("a");
                  if(links.size()==0){
                      break;
                  }
                  Element link=links.get(0);
                  sb.append(link.text()).append("$").append( link.attr("href")).append("$");
                  if(eles.size()==0){
                      sb.append("now()").append("/r/n");
                  }
                  if(eles.get(0).hasText()){
                      sb.append(eles.get(0).text());
                      sb.append("\r\n");
                  }
              }
              System.out.println(sb.toString());

          }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



}
