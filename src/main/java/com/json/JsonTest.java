package com.json;

/**
 * Created by Eric on 2016/6/20.
 */
import java.io.IOException;

import com.util.ReadUtil;
import net.sf.json.JSONObject;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;

public class JsonTest {

    static ReadUtil readUtil;
    public JsonTest(){
        this.readUtil = new ReadUtil();
    }
    public static void main(String[] args) {
        JsonTest jsonTest = new JsonTest();
        String input = readUtil.readFromJson("car.json");
        JSONObject inputJson = JSONObject.fromObject(input);
        //System.out.println(inputJson.getJSONObject("metrics").getJSONArray("policies"));
        System.out.println(inputJson.getJSONArray("partitions"));
    }

    protected static void test(){}
    protected void teste(){}
}
