package com.algorithm;

/**
 * Created by Eric on 2016/8/10.
 */

import java.util.*;

/**
 牛牛想尝试一些新的料理，每个料理需要一些不同的材料，问完成所有的料理需要准备多少种不同的材料。
 输入描述:
 每个输入包含 1 个测试用例。每个测试用例的第 i 行，表示完成第 i 件料理需要哪些材料，各个材料用空格隔开，输入只包含大写英文字母和空格，
 输入文件不超过 50 行，每一行不超过 50 个字符。

 输出描述:
 输出一行一个数字表示完成所有料理需要多少种不同的材料。

 输入例子:
 BUTTER FLOUR
 HONEY FLOUR EGG

 输出例子:
 4
 */
public class Kicthen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> strList= new ArrayList<String>();
        while (sc.hasNext())
            strList.add(sc.next());
            Map<String,Integer> nums = new HashMap<String, Integer>();
            for (int i = 0;i < strList.size();i ++){
                String str = strList.get(i);
                nums.put(str,1);
            }
            System.out.println(nums.size());
    }
}
