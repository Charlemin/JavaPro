package com.test;

import com.sun.javafx.binding.StringFormatter;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Eric on 2016/8/1.
 */
public class ObjectTest {
    public static void main(String[] args) throws IOException {
        InputStream in = ObjectTest.class.getClassLoader().getResourceAsStream("default.json");
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(reader);
        String input = rootNode.toString();
        Map<String,Object> map = mapper.readValue(input, new TypeReference<Map<String, Object>>(){});
        List<Integer> integers = (List<Integer>) map.get("breach");
        System.out.println(integers);
        Iterator<Integer> iterator = integers.iterator();
        while (iterator.hasNext())
            System.out.println(iterator.next());
    }

    public static int test(){
        int[] i = {1,2,3,4,5};
        try{
            return 1;
        } catch (Exception e){
            e.printStackTrace();
        }
        return 3;
    }
}
