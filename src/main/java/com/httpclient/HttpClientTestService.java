package com.httpclient;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;


public class HttpClientTestService {

    public static void main(String[] args) throws Exception{

        HttpClientTestService httpClientTestService = new HttpClientTestService();
//        JSONObject result;
//        result = httpClientTestService.getTest2("http://data-staging.god.pt.xiaomi.com/tmc/common");
//        System.out.println(result);
//        JSONObject request = new JSONObject();
//        JSONArray jobs = new JSONArray();
//        JSONObject job = new JSONObject();
//        JSONObject submitParams = new JSONObject();
//        job.put("jsonClass","SparkTasks$IdMappingJob");
//        submitParams.put("executorMemory","4g");
//        submitParams.put("driverMemory","3g");
//        submitParams.put("minExecutors",50);
//        submitParams.put("queue","root.production.cloud_group.data_platform.push");
//        job.put("submitParams",submitParams);
//        job.put("input","/user/h_user_profile/zhangxiang3/tmp/pn");
//        job.put("fromIdType","pnmd5");
//        job.put("toIdType","phone");
//        job.put("output","/user/h_user_profile/zhangxiang3/tmp/test_phone");
//        jobs.add(job);
//        request.put("jobs",jobs);
//        System.out.println(httpClientTestService.subSparkJob(request + ""));
    }

    public JSONObject getTest2(String url){
        HttpClient client = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(url);
        try{
            HttpResponse response = client.execute(httpGet);
            HttpEntity entity = response.getEntity();
            return JSONObject.fromObject(EntityUtils.toString(entity, "UTF-8"));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
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

    public String optionsTest(String url){
        CloseableHttpClient client = HttpClients.createDefault();
        CloseableHttpResponse response;
        try{
            HttpOptions httpOptions = new HttpOptions(url);

            System.out.println(httpOptions.getMethod());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public JSONObject postTest(String url,String request){
        CloseableHttpClient client = HttpClients.createDefault();
        CloseableHttpResponse response;
        BasicClientCookie cookie = new BasicClientCookie("name","zhamin");
        cookie.setPath("/home/zhamin");
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

    public JSONArray subSparkJob(String jobs) throws UnsupportedEncodingException {

        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost("http://json.post.run.pt.xiaomi.com/task/submit");
        post.addHeader("Content-Type", "application/json");
        HttpEntity entity = new ByteArrayEntity(jobs.getBytes("UTF-8"));
        post.setEntity(entity);
        JSONArray sids = new JSONArray();
        try {
            HttpResponse response = client.execute(post);
            String res = EntityUtils.toString(response.getEntity());
            sids = JSONArray.fromObject(res);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return sids;
    }
}
