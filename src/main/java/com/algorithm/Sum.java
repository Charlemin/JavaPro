package com.algorithm;

/**
 * Created by Eric on 2016/8/15.
 */

/**
 有n个数，给我们一个和m。要求从n个数中抽取若干个数（>=1)，使得这些数的和为m。求符合条件的组合的数目。
 */
public class Sum {
    public static void main(String[] args) {
        int[] num = {3,2,1,4};
        int sum = 20;
        int n = 4;
        int i,j;
        int[] result = new int[sum + 1];
        int[] temp = new int[sum + 1];
        for(i = 0; i < n; i ++)
            if(num[i] > sum)
                    continue;
            else {
                for(j = 0; j < sum + 1; j ++)
                    temp[j] = result[j];
                temp[0] = 1;
                for(j = 0;j < sum + 1;j ++)
                    if( (j + num[i]) <= sum)
                        result[j + num[i]] += temp[j];
                }
        System.out.println(result[sum]);
    }
}
