package com.algorithm;

/**
 * Created by Eric on 2016/8/8.
 */

import java.util.Scanner;

/**
 题目描述
 小东和三个朋友一起在楼上抛小球，他们站在楼房的不同层，假设小东站的楼层距离地面N米，球从他手里自由落下，
 每次落地后反跳回上次下落高度的一半，并以此类推知道全部落到地面不跳，求4个小球一共经过了多少米？(数字都为整数)
 给定四个整数A,B,C,D，请返回所求结果。
 测试样例：
 100,90,80,70
 返回：1020
 */
public class Balls {
    public static void main(String[] args) {
        System.out.println(new Balls().calcDistance(100,90,80,70));
    }

    public int calcDistance(int A, int B, int C, int D) {
        int sum = 0;
        int[] distance = {A,B,C,D};
        for (int i = 0;i < 4;i ++) {
            int length = distance[i];
            sum += distance[i];
            while (length > 0) {
                if (length % 2 == 0)
                    sum += length;
                else sum += ((length + 1) / 2) * 2;
                length /= 2;
            }
        }
        return sum;
    }
}
