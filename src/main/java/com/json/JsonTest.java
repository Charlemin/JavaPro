package com.json;

/**
 * Created by Eric on 2016/6/20.
 */
import java.io.IOException;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;

public class JsonTest {

    public static void main(String[] args) {
        String jsonstring = "{\"address\":\"address\",\"name\":\"haha\",\"id\":1,\"email\":\"email\"}";
        ObjectMapper om = new ObjectMapper();
        try {
            JsonNode node = om.readTree(jsonstring);
            String name = node.get("name").asText();
            System.out.println(name);
        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
