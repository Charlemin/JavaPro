package com.json;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/**
 * Created by Eric on 2016/6/20.
 */
public class Json_to_Map {

        @Test
        public void test(){
            String json = "{\"success\":true,\"A\":{\"address\": \"address2\",\"name\":\"haha2\",\"id\":2,\"email\":\"email2\"},"+
                    "\"B\":{\"address\":\"address\",\"name\":\"haha\",\"id\":1,\"email\":\"email\"}}";
            ObjectMapper om=new ObjectMapper();
            try {
                Map<String,Map<String,Object>> map=om.readValue(json,Map.class);
                System.out.println(map.size());
                Set<String> set=map.keySet();
                Iterator<String> iterator=set.iterator();
                while (iterator.hasNext()){
                    String field=iterator.next();
                    Object object=map.get(field);
                    System.out.println(field+" "+object);
                }
            }
            catch (JsonParseException e) {
                e.printStackTrace();
            } catch (JsonMappingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Test
        public void test2(){
            String json = "{\"success\":true,\"A\":{\"address\": \"address2\",\"name\":\"haha2\",\"id\":2,\"email\":\"email2\"},"+
                    "\"B\":{\"address\":\"address\",\"name\":\"haha\",\"id\":1,\"email\":\"email\"}}";
            ObjectMapper objectMapper=new ObjectMapper();
            try {
                JsonNode rootnode=objectMapper.readTree(json);
                //String successString=rootnode.get("success").asText();
                String B=rootnode.get("B").toString();
                AccountBean accountBean=objectMapper.readValue(B,AccountBean.class);
                System.out.println(accountBean.getAddress());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
}
