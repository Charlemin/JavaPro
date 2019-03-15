package com.algorithm;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ConvertObject {
//    public static void main(String[] args) {
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
//        System.out.println(df.format(new Date()));
//    }
//
//    public  static int test(){
//        int i = 1;
//        try {
//            return i;
//        } finally {
//            i += 1;
//            System.out.println("我被执行了！");
//            return i;
//        }
//    }
//
//    public static String objectToString(Object obj) {
//        ObjectMapper mapper = new ObjectMapper();
//        try {
//            return mapper.writeValueAsString(obj);
//        } catch (Exception e) {
//        }
//        return obj.toString();
//    }
//
//    public static Map<String, Object> stringToMap(String mapString) {
//        ObjectMapper mapper = new ObjectMapper();
//        try {
//            return mapper.readValue(mapString, new TypeReference<Map<String, Object>>() {
//            });
//        } catch (JsonParseException e) {
//
//            e.printStackTrace();
//        } catch (JsonMappingException e) {
//            // TODO Auto-generated catch block
//
//            e.printStackTrace();
//        } catch (IOException e) {
//
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        return new HashMap<String, Object>();
//    }
}