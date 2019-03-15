package com;

import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {45,78,92,36,54,89,51,23,3,54};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i --)
            adjustHeap(arr, i, arr.length);
        for (int i = arr.length - 1; i > 0; i --) {
            swap(arr, 0, i);
            adjustHeap(arr, 0, i);
        }
    }

    private static void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];
        for (int k = 2 * i + 1; k < length; k = 2 * k + 1) {
            if (k + 1 < length && arr[k] < arr[k + 1])
                k ++;
            if (arr[k] > temp) {
                arr[i] = arr[k];
                i = k;
            } else break;
        }
        arr[i] = temp;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
