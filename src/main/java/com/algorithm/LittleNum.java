package com.algorithm;

/**
 * Created by Administrator on 2016/8/13 0013.
 */

import java.util.Arrays;
import java.util.Scanner;

/**
 给定N个正整数，求不能由它们的和组成的最小的正整数是多少？
 按照从小到大排序
 数学归纳法，假设当前i个数能组成的数的区间为1..S，则对于第i+1个数，如果A[i+1]<=S+1，则前i+1个数能组成的数区间为1...S+A[i+1]，
 否则，S+1没法由前i+1个数组成，因为是递增序列，可知S+1便是最小的不能组成的数。
 */
public class LittleNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int[] num = new int[n];
            for (int i =0;i < n;i ++)
                num[i] = sc.nextInt();
            Arrays.sort(num);
            int sum = 0;
            for (int i = 0; i < n;i ++)
                if (num[i] <= sum + 1)
                    sum += num[i];
                else break;
            System.out.println(sum + 1);
        }
    }
}
