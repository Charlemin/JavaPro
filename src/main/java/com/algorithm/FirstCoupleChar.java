package com.algorithm;

/**
 * Created by Eric on 2016/7/27.
 */

/**
 对于一个字符串，请设计一个高效算法，找到第一次重复出现的字符。
 给定一个字符串(不一定全为字母)A及它的长度n。请返回第一个重复出现的字符。保证字符串中有重复字符，字符串的长度小于等于500。
 测试样例：
 "qywyer23tdd",11
 返回：y
 */
public class FirstCoupleChar {
    public static void main(String[] args) {
        System.out.println(findFirstRepeat("qywyer23tdd",11));
    }
    public static char findFirstRepeat(String A, int n) {
        char character = '0';
        for (int i = 0;i < n;i ++){
            Boolean flag = false;
            char one = A.charAt(i);
            for (int j = 0;j < i;j ++){
                if (A.charAt(j) == one)
                {
                    flag = true;
                    character = A.charAt(j);
                }
            }
            if (flag == true)
                break;
        }
        return character;
    }
}
