package com.algorithm;

public class QuickSort {

    public static void main(String[] args) {
        int[] a = {1,34,51,645,90,65,29,6,56,354,7,6};
        quickSort(a, 0,11);
        for (int i = 0; i < 12; i ++)
            System.out.println(a[i] + "\n");
    }
    private static void quickSort(int[] a, int i, int j) {
        int left = i;
        int right = j;
        if (left >= right)
            return;
        int temp = a[i];
        while (left != right) {
            while (left < right && a[right] >= temp)
                right--;
            if (left < right)
                a[left] = a[right];
            while (left < right && a[left] <= temp)
                left++;
            if (left < right)
                a[right] = a[left];
        }
        a[left] = temp;
        quickSort(a,i, left -1);
        quickSort(a, left + 1, j);
    }
}
