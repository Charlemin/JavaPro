package com.algorithm;

/**
 * Created by Eric on 2016/8/12.
 */

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 题目描述

 请你实现一个简单的字符串替换函数。原串中需要替换的占位符为"%s",请按照参数列表的顺序一一替换占位符。若参数列表的字符数大于占位符个数。则将剩下的参数字符添加到字符串的结尾。
 给定一个字符串A，同时给定它的长度n及参数字符数组arg，请返回替换后的字符串。保证参数个数大于等于占位符个数。保证原串由大小写英文字母组成，同时长度小于等于500。
 测试样例：
 "A%sC%sE",7,['B','D','F']
 返回："ABCDEF"
 */
public class ReplaceString {
    public static void main(String[] args) {
        char[] arg = {'B','D','F'};
        System.out.println(new ReplaceString().formatString("A%sC%sE",7,arg,3));
    }

    public String formatString(String A, int n, char[] arg, int m) {
        int length = A.length();
        A = A.replace("%s","%");
        int k = length - A.length();
        StringBuffer buffer = new StringBuffer(A);
        int j = 0;
        for (int i = 0;i < buffer.length();i ++)
        {
            if (buffer.charAt(i) == '%')
                buffer.replace(i,i + 1,String.valueOf(arg[j ++]));
        }
        if (k == m)
            return buffer.toString();
        else {
            for (int i = k;i < m;i ++)
                buffer.append(arg[i]);
            return buffer.toString();
        }
    }
}
