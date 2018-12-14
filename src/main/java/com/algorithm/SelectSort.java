package com.algorithm;

import java.util.Arrays;

public class SelectSort {

    public static void main(String[] args) {
        int []arr = {9,23};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void selectSort(int[] a) {
        int length = a.length;
        for (int i = 0; i < length; i ++) {
            int k = i;
            for (int j = i; j < length; j++)
                if (a[k] > a[j])
                    k = j;
            if (i != k) {
                int temp = a[i];
                a[i] = a[k];
                a[k] = temp;
            }
        }
    }
}
