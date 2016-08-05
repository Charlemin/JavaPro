package com.test;

/**
 * Created by Eric on 2016/8/5.
 */
public class StringTest {
    public static void main(String[] args) {
        String str1 = "gwrfg" + "rgrag";
        String str2 = new String(str1);
        System.out.println(str1 == str2);
        System.out.println(str1.equals(str2));
    }
}
