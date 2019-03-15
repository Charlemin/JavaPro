package com;

import java.util.Collections;
import java.util.Comparator;
import java.util.SortedMap;
import java.util.TreeMap;

public class SortedTreeMap {

    public static void main(String[] args) {
        SortedMap<String,Integer> sortedTreeMap = new TreeMap<String,Integer>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.compareTo(o2) > 0)
                    return -1;
                return 1;
            }
        }); // SortedMap接收TreeMap的实例
        // 增加元素
        sortedTreeMap.put("aa", 11);
        sortedTreeMap.put("bb", 22);
        sortedTreeMap.put("cc", 33);
        sortedTreeMap.put("dd", 44);
        sortedTreeMap.put("ee", 55);

        System.out.println("共有多少个元素：" + sortedTreeMap.size());//添加了7个元素，减去重复的剩余5个
        System.out.println("entrySet：" + sortedTreeMap.entrySet());//所有的键值对
        System.out.println("第一个元素：" + sortedTreeMap.firstKey());//第一个key元素
        System.out.println("最后一个元素：" + sortedTreeMap.lastKey());//最后一个key元素
        System.out.println("headSet元素：" + sortedTreeMap.headMap("cc"));//cc之前的元素
        System.out.println("tailSet元素：" + sortedTreeMap.tailMap("cc"));//cc之后的元素
        System.out.println("subSet元素：" + sortedTreeMap.subMap("aa", "dd"));//aa到dd之间的元素
        System.out.println("subSet元素：" + sortedTreeMap.values());//values,所有的value值

    }
}
