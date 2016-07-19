package com.plus;

import javax.swing.text.html.HTMLDocument;
import java.util.*;

/**
 * Created by Eric on 2016/7/6.
 */
public class MapTest {

    public static void main(String[] args) {
        Map<String,String> hashMap = new HashMap<String,String>();
        List<String> list = new ArrayList<String>();
        for (int i = 0;i < 10;i ++){
            hashMap.put(Integer.toString(i),Integer.toString(i));
            list.add(Integer.toString(i));
        }
        Iterator iterator_key = hashMap.keySet().iterator();
        Iterator iterator_entry = hashMap.entrySet().iterator();
        Iterator iterator_list = list.iterator();
        System.out.println("===HashMap的第一种输出方式===");
        while (iterator_key.hasNext())
            System.out.println(hashMap.get(iterator_key.next()));
        System.out.println("===HashMap的第二种输出方式===");
        while (iterator_entry.hasNext()){
            Map.Entry entry = (Map.Entry) iterator_entry.next();
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        System.out.println("===ArrayList的输出方式===");
        while (iterator_list.hasNext()){
            System.out.println(iterator_list.next());
        }
    }
}
