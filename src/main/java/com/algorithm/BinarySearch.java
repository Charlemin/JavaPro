package com.algorithm;

public class BinarySearch {

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6};
        System.out.println(search(a, 7));
    }

    private static int search(int[] a, int key){
        int right = a.length -1;
        int left = 0;
        while (left <= right) {
            int location = left + (right - left) / 2;
            if (a[location] == key)
                return location;
            if (a[location] > key)
                right = location - 1;
            if (a[location] < key)
                left = location + 1;
        }
        return -1;
    }
}
