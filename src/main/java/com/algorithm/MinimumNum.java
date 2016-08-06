package com.algorithm;

import java.util.Arrays;
import java.util.Scanner;

import java.util.HashMap;
import java.util.concurrent.ArrayBlockingQueue;

/**
 n个数的和不能表示的最小的数
 */
public class MinimumNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] nums = new int[101];
            int[] array = new int[n];
            for (int i = 0; i < n; i++)
                array[i] = sc.nextInt();
            Arrays.sort(array);
            for (int i = 1;i <= n;i++)
                nums[i] = array[i -1];
            int sum = 0;
            for (int i = 1; i <= n; i++)
                if (nums[i] <= sum + 1)
                    sum += nums[i];
                else
                    break;
            System.out.println(sum + 1);
        }
    }
}
