package com.plus;

import com.sun.javafx.image.BytePixelSetter;
import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Eric on 2016/7/7.
 */
public class WordPattern {

    public static void main(String[] args) {

        boolean result1 = wordPattern("abba","dog cat cat fish");
        boolean result2 = wordPattern("abba","dog cat cat dog");
        System.out.println(result1);
        System.out.println(result2);
    }

    @Test
    public void getMapInfo(){
        Map map = new HashMap();
        map.put("apple", "新鲜的苹果");     //向列表中添加数据
        map.put("computer", "配置优良的计算机");   //向列表中添加数据
        map.put("book", "堆积成山的图书");     //向列表中添加数据
        Iterator iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            System.out.print(entry.getKey() + ":");
            System.out.println(entry.getValue());
        }
        System.out.println("=== ===");
        Iterator iterator = map.keySet().iterator();
        while (iterator.hasNext()){
            System.out.println(map.get(iterator.next()));
        }
        System.out.println("=== ===");
        System.out.println("Map集合大小为："+map.size());

    }
    public static boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length())
            return false;
        Map<Character,String> hashMap = new HashMap<Character, String>();
        for (int i = 0;i < pattern.length();i++)
            if (hashMap.containsKey(pattern.charAt(i))) {
                if (!hashMap.get(pattern.charAt(i)).equals(words[i]))
                    return false;
            }
            else {
                if (hashMap.containsValue(words[i])) return false;
                hashMap.put(pattern.charAt(i),words[i]);
            }
        return true;
    }
}
