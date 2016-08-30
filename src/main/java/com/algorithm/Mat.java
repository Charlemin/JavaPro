package com.algorithm;

import java.util.Scanner;

/**
 * Created by Administrator on 2016/8/17 0017.
 */
public class Mat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int t = sc.nextInt();
            for (int i = 0;i < t;i ++){
                int n = sc.nextInt();
                int k = sc.nextInt();
                int[] nums = new int[2*n];
                for (int j = 0;j < 2*n;j ++)
                nums[j] = sc.nextInt();
                if (k == 1)
                    for (int l = 0;l < n;l ++) {
                        System.out.print(nums[l]);
                        System.out.println(nums[l + 3]);
                    }

            }
        }
    }
}
