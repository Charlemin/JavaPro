package com.plus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/**
 * Created by Eric on 2016/3/7.
 */
public class hashMapTest {

    public static void main(String[] args) {

        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "Eric");
        map.put(2, "Charlie");
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, String> entry = (Map.Entry<Integer, String>) iterator.next();
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        ArrayList<String> ar = new ArrayList<String>();
        ar.add("as");
        ar.add("sd");
        Iterator<String> iter=ar.iterator();
        while (iter.hasNext())
          System.out.println(iter.next());
    }
}