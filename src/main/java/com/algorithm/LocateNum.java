package com.algorithm;

/**
 * Created by Eric on 2016/7/27.
 */

import java.util.Scanner;

/**
 对于一个有序数组，我们通常采用二分查找的方式来定位某一元素，请编写二分查找的算法，在数组中查找指定元素。
 给定一个整数数组A及它的大小n，同时给定要查找的元素val，请返回它在数组中的位置(从0开始)，若不存在该元素，返回-1。若该元素出现多次，请返回第一次出现的位置。
 测试样例：
 [1,3,5,7,9],5,3
 返回：1
 **/
public class LocateNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       while (sc.hasNext()){
            String inputString = sc.nextLine();
            String nums = inputString.substring(1,inputString.length() - 5);
            String[] numString = nums.split(",");
            int[] array = new int[numString.length];
            for(int i = 0;i < numString.length;i ++)
                array[i] = Integer.parseInt(numString[i]);
            int m = 0,n = array.length - 1;
            Boolean flag = false;
            int location = 0;
            int num_A = Integer.parseInt(inputString.substring(inputString.length() - 1));
            while (m <= n){
                int mid = m + (n - m) / 2;
                if (array[mid] == num_A)
                {
                    flag = true;
                    location = mid;
                    break;
                }
                else if ((array[mid] > num_A))
                    n = mid - 1;
                else m = mid + 1;
            }
            if (flag == true)
                System.out.println(location);
            else System.out.println(-1);
       }
    }
    //折半查找
    public int getPos(int[] A, int n, int val) {
        int i = 0, j = A.length - 1;
        Boolean flag = false;
        int location = 0;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (A[mid] == val) {
                flag = true;
                location = mid;
                break;
            } else if ((A[mid] > val))
                j = mid - 1;
            else i = mid + 1;
        }
        if (A[0] == val)
            location = 0;
        if (flag == true)
            return location;
        else return -1;
    }
}
