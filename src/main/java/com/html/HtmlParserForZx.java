package com.html;

import com.model.NewsTitle;
import com.util.CheckUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.utils.DateUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.Date;

/**
 * 中新网解析
 * @author yu.yang
 */
public class HtmlParserForZx implements HtmlParser {

    private static final String BASEPATH = "http://www.hb.chinanews.com";

    public NewsTitle parserNewsTitle(String html) {
        if(StringUtils.isNotBlank(html)){
            Document doc = Jsoup.parse(html);
            Element content = doc.getElementById("content_left");
            Elements pTags = content.getElementsByTag("p");
            StringBuilder sb = new StringBuilder();
            for(Element p:pTags){
                NewsTitle title=new NewsTitle();
                Elements eles=p.getElementsByClass("news_list_time");
                Elements links=p.getElementsByTag("a");
                if(links.size()==0){
                    break;
                }
                Element link=links.get(0);
                title.setTitle(link.text());
                title.setUrl(link.attr("href"));
                if(!title.getUrl().contains("http")){
                    title.setUrl(BASEPATH + title.getUrl());
                }
                sb.append(link.text()).append("$").append( title.getUrl()).append("$");
                if(eles.size()==0){
                    sb.append("now()").append("/r/n");
                    title.setPubTime(DateUtils.formatDate(new Date(),"yyyy-MM-dd HH:mm:ss"));
                }else {
                    sb.append(eles.get(0).text());
                    sb.append("\r\n");
                    title.setPubTime(eles.get(0).text());
                }

            }
            System.out.println(sb.toString());
        }

        return null;
    }
}
