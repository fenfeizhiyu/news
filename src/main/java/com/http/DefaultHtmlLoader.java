package com.http;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;

/**
 * @author yu.yang
 */
public class DefaultHtmlLoader implements HtmlLoader{

    public String getHtml(String url){
        HttpClient httpClient= HttpClients.custom().build();
        HttpGet get = new HttpGet("http://www.hb.chinanews.com/dsxw.html");
        HttpResponse res=null;
        try{
            res=httpClient.execute(get);
            if(res.getStatusLine().getStatusCode()==200){
                return IOUtils.toString(res.getEntity().getContent(),"gb2312");
            }else {
                System.out.println("error:"+url);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
