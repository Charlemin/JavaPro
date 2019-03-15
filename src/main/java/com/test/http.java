package com.test;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class http {
    public static void main(String[] args) throws Exception{
        File file = new File("/opt/pn.txt");
        String name = "手机号看画像";
        String user = "org-devtest!@@!_admin";
        String url = "http://data.god.pt.xiaomi.com/v2/upload/push";
        String fileType = "ecopn";

        System.out.println(getStringFromUploadFileResponse(user,name,file,fileType,url));
    }

    public static String getStringFromUploadFileResponse(String user, String name, File file, String fileType, String url) throws Exception {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(url);
        HttpEntity reqEntity = MultipartEntityBuilder.create().
                addPart("file", new FileBody(file)).
                addPart("user", new StringBody(user, ContentType.create("text/plain", Charset.forName("UTF-8")))).
                addPart("name", new StringBody(name, ContentType.create("text/plain",Charset.forName("UTF-8")))).
                addPart("fileType", new StringBody(fileType,ContentType.create("text/plain",Charset.forName("UTF-8")))).build();
        post.setEntity(reqEntity);
        CloseableHttpResponse httpResponse = httpClient.execute(post);
        try {
            return EntityUtils.toString(httpResponse.getEntity());
        } catch (Exception e) {
            System.out.println("post response error,url-01");
        }finally {
            try {
                httpResponse.close();
                httpClient.close();
            }catch (IOException ex) {
                System.out.println("post response error,url-02");
            }
        }
        return null;
    }

    public static String getDateOfTime(long rawTime) {
        SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMddhhmmss");
        String time = fmt.format(new Date(rawTime * 1000));
        return time;
    }

    @Test
    public void test(){
        System.out.println(getDateOfTime(1531310400));
    }
}
