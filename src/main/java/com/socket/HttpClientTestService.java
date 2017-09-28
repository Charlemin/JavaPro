package com.socket;

import net.sf.json.JSONObject;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;


public class HttpClientTestService {

    public static void main(String[] args) {

        //System.out.println(new HttpClientTestService().getRequest("zhamin"));
        System.out.println(new HttpClientTestService().postRequest("http://god-staging.d.pt.xiaomi.com/tmc/usertaggroupmap/add","{\"groupName\":\"push\",\"tagName\":\"xmmall_oversea\"}"));

    }

    public JSONObject getRequest(String request) {

        try {
            //String url = "http://god-staging.d.pt.xiaomi.com/tmc/ids/" + userName;
            String url = "http://god-staging.d.pt.xiaomi.com/v2/profile/stars";
            HttpClient client = new HttpClient();
            HttpMethod getMethod = new GetMethod(url);
            getMethod.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
            client.executeMethod(getMethod);
            String responseString = getMethod.getResponseBodyAsString();
            return JSONObject.fromObject(responseString);
        } catch (Exception ignore) {
            System.out.println(ignore.getMessage());
        }
        return null;
    }

    public JSONObject postRequest(String url,String request){
        HttpClient httpClient = new HttpClient();
        PostMethod postMethod = new PostMethod(url);
        NameValuePair para = new NameValuePair("data",request);
        try{
            postMethod.setRequestBody(new NameValuePair[]{para});
            int status = httpClient.executeMethod(postMethod);
            System.out.println(status);
            return JSONObject.fromObject(postMethod.getResponseBodyAsString());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
