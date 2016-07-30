package com.algorithm;

/**
 * Created by Eric on 2016/7/28.
 */

/**
 有一个长为n的数组A，求满足0≤a≤b<n的A[b]-A[a]的最大值。
 给定数组A及它的大小n，请返回最大差值。
 测试样例：
 [10,5],2
 返回：0
 */
public class MaxDeviation {
    public static void main(String[] args) {
         int[] A = {5386,5384,11054,6345,5816,11757};
        System.out.println(new MaxDeviation().getDis(A,6));
    }

    public int getDis(int[] A, int n) {
        int maxDev = 0;
        for (int i = 0;i < n - 1; i ++)
            for (int j = i; j < n;j ++)
                if (maxDev < A[j] - A[i] )
                    maxDev = A[j] - A[i];
        return maxDev;
    }
}
