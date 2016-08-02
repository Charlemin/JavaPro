package com.algorithm;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Administrator on 2016/8/2 0002.
 */

/**
 题目描述

 给出一个名字，该名字有26个字符串组成，定义这个字符串的“漂亮度”是其所有字母“漂亮度”的总和。
 每个字母都有一个“漂亮度”，范围在1到26之间。没有任何两个字母拥有相同的“漂亮度”。字母忽略大小写。
 给出多个名字，计算每个名字最大可能的“漂亮度”。

 输入描述:
 整数N，后续N个名字

 输出描述:
 每个名称可能的最大漂亮程度

 输入例子:
 2
 zhangsan
 lisi

 输出例子:
 192
 101
 */
public class NamePretty {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            String[] names = new String[n];
            for (int i = 0;i < n;i ++)
                names[i] = sc.next();
            for (int i = 0;i < n;i ++){
                int pretty = 0;
                names[i].toLowerCase();
                String name = names[i];
                int[] nums = getNums(name);
                Arrays.sort(nums);//升序排列
                int pretty_degree = 26;
                for (int k = nums.length - 1;nums[k] != 0;k --)
                {
                    pretty += (nums[k] * pretty_degree);
                    pretty_degree --;
                }
                System.out.println(pretty);
            }
        }
    }

    public static int[] getNums(String name) {
        int n = name.length();
        int[] nums = new int[n];
        for (int i = 0;i < n;i++)
            nums[i] = 0;
        for(int i = 0;i < n;i ++) {
            boolean flag = false;
            for (int j = 0; j < i; j ++)
                if (name.charAt(j) == name.charAt(i)) {
                    flag = true;
                    break;
                }
            if (flag == true)
                continue;
            for (int k = i; k < n; k ++)
                if (name.charAt(k) == name.charAt(i))
                    nums[i] ++;
        }
        return nums;
    }

}
