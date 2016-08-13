package com.algorithm;

/**
 * Created by Eric on 2016/8/12.
 */

import java.util.*;

/**
 题目描述

 输入一个字符串，求出该字符串包含的字符集合

 输入描述:
 每组数据输入一个字符串，字符串最大长度为100，且只包含字母，不可能为空串，区分大小写。

 输出描述:
 每组数据一行，按字符串原有的字符顺序，输出字符集合，即重复出现并靠后的字母不输出。

 输入例子:
 abcqweracb

 输出例子:
 abcqwer
 */
public class CharSet {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String c = in.next();
            StringBuffer sb = new StringBuffer();
            Set<Character> set = new HashSet<Character>();
            for(int i = 0;i<c.length();i++){
                if(set.add(c.charAt(i)))
                    sb.append(c.charAt(i));
            }
            System.out.println(sb.toString());
        }
    }

    public static void calCharNum(String input){
        int length=input.length();
        for(int i = 0;i < length;i ++){
            int count = 0;
            boolean flag = false;
            for(int j = 0;j < i;j ++){
                if(input.charAt(i) == input.charAt(j)){
                    flag = true;
                    break;
                }
            }
            if(flag == true)
                continue;
            for(int j = i;j < length;j ++)
                if (input.charAt(j) == input.charAt(i))
                    count ++;
            System.out.println(input.charAt(i) + ":" + count);

        }
    }

    public static void getCharSet(String input){
        int length = input.length();
        for(int i = 0;i < length;i ++){
            boolean flag = false;
            for(int j = 0;j < i;j ++){
                if(input.charAt(i) == input.charAt(j)){
                    flag = true;
                    break;
                }
            }
            if(flag == true)
                continue;
            System.out.print(input.charAt(i));

        }
    }
}
