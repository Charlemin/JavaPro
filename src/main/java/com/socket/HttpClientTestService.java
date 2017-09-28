package com.socket;

import net.sf.json.JSONObject;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import java.util.ArrayList;
import java.util.List;


public class HttpClientTestService {

    public static void main(String[] args) {

        System.out.println(new HttpClientTestService().getTest("http://god-staging.d.pt.xiaomi.com/v2/profile/stars"));
        //System.out.println(new HttpClientTestService().postRequest("http://god-staging.d.pt.xiaomi.com/tmc/usertaggroupmap/add","{\"groupName\":\"unique\",\"tagName\":\"xmmll_oversea\"}"));
        System.out.println(new HttpClientTestService().postTest("http://god-staging.d.pt.xiaomi.com/tmc/usertaggroupmap/add","{\"groupName\":\"unique\",\"tagName\":\"xmmll_oversea\"}"));
    }

    public JSONObject getTest(String url){
        CloseableHttpClient client = HttpClients.createDefault();
        CloseableHttpResponse response;
        try{
            HttpGet httpGet = new HttpGet(url);
            response = client.execute(httpGet);
            System.out.println(response.getStatusLine().getStatusCode());
            HttpEntity entity = response.getEntity();
            Header[] headers = response.getAllHeaders();
            for (Header header : headers){
                System.out.println(header.getName() + ":" + header.getValue());
            }
            if (entity != null)
                return JSONObject.fromObject(EntityUtils.toString(entity, "UTF-8"));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public JSONObject postTest(String url,String request){
        CloseableHttpClient client = HttpClients.createDefault();
        CloseableHttpResponse response;
        try{
            HttpPost httpPost = new HttpPost(url);
            List<NameValuePair> formparams = new ArrayList<NameValuePair>();
            formparams.add(new BasicNameValuePair("data", request));
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");
            httpPost.setEntity(uefEntity);
            response = client.execute(httpPost);
            System.out.println(response.getStatusLine().getStatusCode());
            Header[] headers = response.getAllHeaders();
            for (Header header : headers){
                System.out.println(header.getName() + ":" + header.getValue());
            }
            HttpEntity entity = response.getEntity();
            if (entity != null)
                return JSONObject.fromObject(EntityUtils.toString(entity, "UTF-8"));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
