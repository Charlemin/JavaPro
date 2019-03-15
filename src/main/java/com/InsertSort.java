package com;

import java.util.Arrays;

public class InsertSort {

    public static void main(String[] args) {
        int[] arr = {45,78,92,36,54,89,51,23,3,54};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i ++) {
            int j;
            int temp = arr[i];
            for (j = i - 1; j >= 0 && arr[j] > temp; j --)
                arr[j + 1] = arr[j];
            arr[j + 1] = temp;
        }
    }
}
