package com.plus;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Eric on 2016/6/22.
 */
public class ListTest {

    public static void main(String[] args) {

        List<String> list = new LinkedList<String>();
        ObjectMapper objectMapper = new ObjectMapper();
        list.add("zganub");
        list.add("saff");
        list.add("fdafhghd");
        String json = null;
        try {
            json = objectMapper.writeValueAsString(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(list.toString());
        System.out.println(json);
    }
}
