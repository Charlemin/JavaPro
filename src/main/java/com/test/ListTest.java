package com.test;

import java.util.ArrayList;
import java.util.List;

public class ListTest {
    public static void main(String[] args) {
        List<String> aer = new ArrayList<String>();
        String result = "";
        for (int i = 1;i <=274;i ++){
            String str = "(" + "\"tag_" + i + "\"" + "," + "\"tag_" +i + "\"" + "," + "\"小米音乐\"" + "," + (2020 + i) + "," + "\"\"" + ")";
            aer.add(str);
            result += str + ",";
        }

        UserTagUp userTagUp = new UserTagUp();
        userTagUp.setName("zhamin");
        System.out.println(userTagUp + "");
        System.out.println(result);
        System.out.println(aer);
    }
}

