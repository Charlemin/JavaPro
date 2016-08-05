package com.algorithm;

/**
 * Created by Eric on 2016/8/5.
 */

import java.util.Scanner;
import java.util.Vector;

/**
 题目描述
 给定一个递增序列，a1 <a2 <...<an 。定义这个序列的最大间隔为d=max{ai+1 - ai }(1≤i<n),现在要从a2 ,a3 ..an-1 中删除一个元素。问剩余序列的最大间隔最小是多少？

 输入描述:
 第一行，一个正整数n(1<=n<=100),序列长度;接下来n个小于1000的正整数，表示一个递增序列。

 输出描述:
 输出答案。

 输入例子:
 5
 1 2 3 7 8

 输出例子:
 4
 */

public class MaxSpace {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int[] A = new int[n];
            for (int i =0;i < n;i ++)
                A[i] = sc.nextInt();
            int min = Integer.MIN_VALUE;
            for (int i = 1;i <n;i ++)
            {
                Vector<Integer> B = new Vector<Integer>();
                for (int j = 0;j < n;j ++)
                    if (j == i)
                        continue;
                    else
                        B.add(A[j]);
                if (min > getMax(B));
                min = getMax(B);
            }
            System.out.println(min);
        }
    }

    public static int getMax(Vector<Integer> nums){
        int max = 0;
        for (int i = 0;i < nums.size() - 1;i ++)
            if (max < nums.get(i + 1) - nums.get(i))
                max = nums.get(i + 1) - nums.get(i);
        return max;
    }
}
