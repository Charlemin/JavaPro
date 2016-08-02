package com.test;

import com.sun.javafx.binding.StringFormatter;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Eric on 2016/8/1.
 */
public class ObjectTest {
    public static void main(String[] args) {
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        map.put(1,1);
        map.put(2,2);
        System.out.println(map);
        ObjectMapper om = new ObjectMapper();
        try {
            String mapString = om.writeValueAsString(map);
            System.out.println(mapString);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static int test(){
        int[] i = {1,2,3,4,5};
        try{
            return 1;
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            return 2;
        }
    }
}
